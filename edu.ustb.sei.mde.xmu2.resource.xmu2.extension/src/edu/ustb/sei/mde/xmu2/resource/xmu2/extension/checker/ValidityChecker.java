package edu.ustb.sei.mde.xmu2.resource.xmu2.extension.checker;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.mde.xmu2.AbstractRule;
import edu.ustb.sei.mde.xmu2.ArithmeticRule;
import edu.ustb.sei.mde.xmu2.EntryData;
import edu.ustb.sei.mde.xmu2.EntryPoint;
import edu.ustb.sei.mde.xmu2.ModelRule;
import edu.ustb.sei.mde.xmu2.Parameter;
import edu.ustb.sei.mde.xmu2.TransformationModel;
import edu.ustb.sei.mde.xmu2.VariableDeclaration;
import edu.ustb.sei.mde.xmu2.expression.ExpressionPackage;
import edu.ustb.sei.mde.xmu2.expression.LoopPath;
import edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression;
import edu.ustb.sei.mde.xmu2.pattern.Pattern;
import edu.ustb.sei.mde.xmu2.pattern.PatternExpression;
import edu.ustb.sei.mde.xmu2.pattern.PatternNode;
import edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2OptionProvider;
import edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Options;
import edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ResourcePostProcessor;
import edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ResourcePostProcessorProvider;
import edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemType;
import edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.ModelIterator;
import edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Resource;
import edu.ustb.sei.mde.xmu2.statement.AssignStatement;
import edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement;
import edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause;
import edu.ustb.sei.mde.xmu2.statement.Fail;
import edu.ustb.sei.mde.xmu2.statement.ForEachStatement;
import edu.ustb.sei.mde.xmu2.statement.PatternCaseClause;
import edu.ustb.sei.mde.xmu2.statement.RuleCallStatement;
import edu.ustb.sei.mde.xmu2.util.AnalysisUtil;
import edu.ustb.sei.mde.xmu2.util.Constants;
import edu.ustb.sei.mde.xmu2common.DomainTag;
import edu.ustb.sei.mde.xmu2core.EntryRuleParameter;

public class ValidityChecker
		implements IXmu2OptionProvider, IXmu2ResourcePostProcessorProvider, IXmu2ResourcePostProcessor {
	
	private boolean termination = false;

	@Override
	public void process(Xmu2Resource resource) {
		termination = false;
		if(resource.getContents().isEmpty()) return;
		
		TransformationModel model = (TransformationModel)resource.getContents().get(0);
		
		
		try {
			for(AbstractRule r : model.getRules()) {
				if(termination) break;
				if(r instanceof ModelRule) {
					this.checkVariableValidity((ModelRule)r, resource);
					this.checkStatementUsage(r,false,resource);
					this.checkPatternValidity((ModelRule)r,resource);
				} else if(r instanceof ArithmeticRule) {
					this.checkVariableValidity((ArithmeticRule)r, resource);
					this.checkStatementUsage(r,true,resource);
				}
			}
			for(EntryPoint ep : model.getEntryPoints()) {
				if(termination) break;
				checkEntryPoints(ep, resource);
			}
		} catch(Exception e) {
			resource.addWarning("validity check is not finished because of some exceptions", 
					Xmu2EProblemType.ANALYSIS_PROBLEM, model);
		}

	}

	private void checkPatternValidity(EObject r, Xmu2Resource resource) {
		if(r instanceof PatternNode) {
			for(PatternExpression e : ((PatternNode) r).getExpressions()) {
				EClassifier cls = ((PatternNode) r).getVariable().getType();
				if(cls instanceof EClass) {
					if(!Constants.REFLECTIVE_OBJECT.getEAllStructuralFeatures().contains(e.getFeature())
							&& !((EClass) cls).getEAllStructuralFeatures().contains(e.getFeature()))
						resource.addError("the pattern node does not contain this feature", Xmu2EProblemType.SYNTAX_ERROR, e);
				}
				
				if(e instanceof ObjectPatternExpression) {
					EStructuralFeature f = e.getFeature();
					EClassifier tarType = ((ObjectPatternExpression) e).getTargetNode().getVariable().getType();
					
					if(!AnalysisUtil.isSuperTypeOf(f.getEType(), tarType) ) {
						resource.addWarning("type inconsistency", Xmu2EProblemType.ANALYSIS_PROBLEM, e);
					}
				}
			}
		} else {
			for(EObject c : r.eContents())
				this.checkPatternValidity(c, resource);
		}
	}

	private void checkStatementUsage(AbstractRule r, boolean isArithmeticRule, Xmu2Resource resource) {
		TreeIterator<EObject> it = r.eAllContents();
		while(it.hasNext()) {
			EObject o = it.next();
			if(o instanceof edu.ustb.sei.mde.xmu2.statement.Statement) {
				if(o instanceof edu.ustb.sei.mde.xmu2.statement.SwitchStatement) {
					if(isArithmeticRule) {
						for(edu.ustb.sei.mde.xmu2.statement.CaseClause cc : ((edu.ustb.sei.mde.xmu2.statement.SwitchStatement) o).getCases()) {
							if(cc instanceof PatternCaseClause)
								resource.addError("you cannot use the pattern case in a function", Xmu2EProblemType.SYNTAX_ERROR, cc);
						}
					}
				} else if(o instanceof edu.ustb.sei.mde.xmu2.statement.AssignStatement) {
					if(isArithmeticRule==false) {
						resource.addError("you cannot use the AssignStatement in a model rule", Xmu2EProblemType.SYNTAX_ERROR, o);
					}
				} else if(o instanceof edu.ustb.sei.mde.xmu2.statement.BlockStatement) {
				} else if(o instanceof edu.ustb.sei.mde.xmu2.statement.Fail) {
				} else {
					if(isArithmeticRule)
						resource.addError("you cannot use this statement in a function", Xmu2EProblemType.SYNTAX_ERROR, o);
				}
			} else if(o instanceof ObjectPatternExpression) {
				if(((ObjectPatternExpression) o).isNullable() 
						&& !((ObjectPatternExpression) o).getTargetNode().getExpressions().isEmpty())
					resource.addError("a nullable pattern node cannot have inner expressions", Xmu2EProblemType.SYNTAX_ERROR,o);
			}
		}
	}

	private void checkEntryPoints(EntryPoint ep, Xmu2Resource resource) {
		ModelRule rule = ep.getRule();
		if(rule.getParameters().size()!=ep.getParameters().size()) {
			resource.addError("the number of parameters is incorrect", Xmu2EProblemType.SYNTAX_ERROR, ep);
		} else {
			for(int i = 0 ; i < rule.getParameters().size() ; i ++) {
				Parameter fp = rule.getParameters().get(i);
				EntryData ed = ep.getParameters().get(i);
				if(fp.getTag()!=ed.getTag()) {
					resource.addError("the domain of the parameter "+i+" is inconsistent", Xmu2EProblemType.SYNTAX_ERROR, ed);
				}
				if(fp.getTag()==DomainTag.NORMAL) {
					resource.addError("the entry rule cannot own normal parameters", Xmu2EProblemType.SYNTAX_ERROR, fp);
				}
			}
		}
	}

	@Override
	public void terminate() {
		
		termination = true;
	}

	@Override
	public IXmu2ResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	@Override
	public Map<?, ?> getOptions() {
		return Collections.singletonMap( 
			      IXmu2Options.RESOURCE_POSTPROCESSOR_PROVIDER, 
			      this 
			    );
	}
	
	/*
	 * variable consistency rules
	 * 1. in the same pattern, declared variables should have different names
	 * 2. normal variables should not be declared in any pattern
	 * 3. source variables should not be declared or used in the view patterns
	 * 4. view variables should not be declared or used in the source patterns
	 * 5. view variables should not be declared or used as updated source variables
	 * 6. updated source variables should not be declared and used in source/view patterns
	 * 7. a variable used must be declared first
	 */
	
	//check the validity of variable name
	public void checkVariableValidity(AbstractRule rule, Xmu2Resource resource) {
		VariableValidityContext con = new VariableValidityContext();
		
		//collect variable names and check naming rules
		con.collectVariableNames(rule, resource);
		
		checkRuleCallValidity(rule,resource,con);
		
		return;
	}
	
	public void checkRuleCallValidity(AbstractRule rule,Xmu2Resource resource,VariableValidityContext cont) {
		try {
			TreeIterator<EObject> it = rule.eAllContents();
			
			while(it.hasNext()) {
				EObject o = it.next();
				
				if(o instanceof RuleCallStatement) {
					RuleCallStatement rc = (RuleCallStatement) o;
					
					AbstractRule r = rc.getRule();
					
					if(r.getParameters().size()!= rc.getParameters().size()) {
						resource.addError("the parameter count is inconsistent", Xmu2EProblemType.SYNTAX_ERROR, o);
					} else {
						int size = r.getParameters().size();
						for(int i = 0 ; i < size ; i++) {
							EObject ap = rc.getParameters().get(i);
							edu.ustb.sei.mde.xmu2.Parameter fp = r.getParameters().get(i);
							cont.checkVariableUsage(ap, resource, fp.getTag());
						}
					}
				}
			}
		} catch(Exception e) {
			resource.addWarning("validity check is not finished because of some exceptions", 
					Xmu2EProblemType.ANALYSIS_PROBLEM, rule);
		}
	}
	

}

class VariableValidityContext {
	private Set<String> sourceVariableNames = new HashSet<String>();
	private Set<String> viewVariableNames = new HashSet<String>();
	private Set<String> updatedSourceVariableNames = new HashSet<String>();
	private Set<String> normalVariableNames = new HashSet<String>();
	
	public VariableValidityContext() {}
	
	void addSourceVariableName(String n) {
		sourceVariableNames.add(AnalysisUtil.getNonUpdatedSourceVariableName(n));
		updatedSourceVariableNames.add(AnalysisUtil.getUpdatedSourceVariableName(n));
	}
	void addViewVariableName(String n) {
		viewVariableNames.add(n);
	}
	void addUpdatedSourceVariableName(String n) {
		sourceVariableNames.add(AnalysisUtil.getNonUpdatedSourceVariableName(n));
		updatedSourceVariableNames.add(AnalysisUtil.getUpdatedSourceVariableName(n));
	}
	void addNormalVariableName(String n) {
		normalVariableNames.add(n);
	}
	
	boolean existInSourceVariable(String n) {
		return sourceVariableNames.contains(n);
	}
	boolean existInViewVariable(String n) {
		return viewVariableNames.contains(n);
	}
	boolean existInUpdatedSourceVariable(String n) {
		return updatedSourceVariableNames.contains(n);
	}
	boolean existInNormalVariable(String n) {
		return normalVariableNames.contains(n);
	}
	
	boolean isValidNonUpdatedVariableName(String n) {
		return !n.endsWith(Constants.POST);
	}
	

	
	public boolean isDuplicateNormalVariable(String name) {
		return existInNormalVariable(name) ||
				existInSourceVariable(name) ||
				existInViewVariable(name);
	}
	
	public boolean isDuplicateSourceVariable(String name) {
		return existInNormalVariable(name) ||
				existInViewVariable(name);
	}
	
	public boolean isDuplicateViewVariable(String name) {
		return existInNormalVariable(name) ||
				existInSourceVariable(name);
	}
	
	public boolean isDuplicateUpdatedSourceVariable(String name) {
		name = AnalysisUtil.getNonUpdatedSourceVariableName(name);
		
		return existInNormalVariable(name) ||
				existInViewVariable(name);
	}
	
	public void collectVariableNames(EObject root, Xmu2Resource resource) {
		try{
			if(root instanceof ModelRule) {
				for(edu.ustb.sei.mde.xmu2.Parameter p : ((ModelRule) root).getParameters()) {
					if(((edu.ustb.sei.mde.xmu2.Parameter) p).getTag()==DomainTag.NORMAL) {
						
						if(AnalysisUtil.isValidNonUpdatedSourceVariableName(p.getName())==false)
							resource.addError("the name of a normal variable should not end with '@post'", Xmu2EProblemType.SYNTAX_ERROR, p);
						
						if(isDuplicateNormalVariable(p.getName()))
							resource.addError("the normal variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, p);
						else
							addNormalVariableName(((edu.ustb.sei.mde.xmu2.Parameter) p).getName());
					} else if(((edu.ustb.sei.mde.xmu2.Parameter) p).getTag()==DomainTag.SOURCE) {
						if(AnalysisUtil.isValidNonUpdatedSourceVariableName(p.getName())==false)
							resource.addError("the name of a source variable should not end with '@post'", Xmu2EProblemType.SYNTAX_ERROR, p);
						
						if(isDuplicateSourceVariable(p.getName()))
							resource.addError("the source variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, p);
						else
							addSourceVariableName(((edu.ustb.sei.mde.xmu2.Parameter) p).getName());
					} else if(((edu.ustb.sei.mde.xmu2.Parameter) p).getTag()==DomainTag.VIEW) {
						if(AnalysisUtil.isValidNonUpdatedSourceVariableName(p.getName())==false)
							resource.addError("the name of a view variable should not end with '@post'", Xmu2EProblemType.SYNTAX_ERROR, p);
						
						if(isDuplicateViewVariable(p.getName()))
							resource.addError("the view variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, p);
						else
							addViewVariableName(((edu.ustb.sei.mde.xmu2.Parameter) p).getName());
					}
				}
				
				for(edu.ustb.sei.mde.xmu2.VariableDeclaration vd : ((ModelRule) root).getVariableDeclarations()) {
					if(AnalysisUtil.isValidNonUpdatedSourceVariableName(vd.getName())==false)
						resource.addError("the name of a normal variable should not end with '@post'", Xmu2EProblemType.SYNTAX_ERROR, vd);
					
					if(isDuplicateNormalVariable(vd.getName()))
						resource.addError("the normal variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, vd);
					else
						addNormalVariableName(vd.getName());
				}
				
				for(EObject o : root.eContents()) {
					collectVariableNames(o, resource);
				}
			} else if(root instanceof ArithmeticRule) {
				for(edu.ustb.sei.mde.xmu2.Parameter p : ((ArithmeticRule) root).getParameters()) {
					if(((edu.ustb.sei.mde.xmu2.Parameter) p).getTag()==DomainTag.NORMAL) {
						
						if(AnalysisUtil.isValidNonUpdatedSourceVariableName(p.getName())==false)
							resource.addError("the name of a normal variable should not end with '@post'", Xmu2EProblemType.SYNTAX_ERROR, p);
						
						if(isDuplicateNormalVariable(p.getName()))
							resource.addError("the normal variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, p);
						else
							addNormalVariableName(((edu.ustb.sei.mde.xmu2.Parameter) p).getName());
					} else if(((edu.ustb.sei.mde.xmu2.Parameter) p).getTag()==DomainTag.SOURCE) {
						if(AnalysisUtil.isValidNonUpdatedSourceVariableName(p.getName())==false)
							resource.addError("the name of a source variable should not end with '@post'", Xmu2EProblemType.SYNTAX_ERROR, p);
						
						if(isDuplicateSourceVariable(p.getName()))
							resource.addError("the source variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, p);
						else
							addSourceVariableName(((edu.ustb.sei.mde.xmu2.Parameter) p).getName());
					} else if(((edu.ustb.sei.mde.xmu2.Parameter) p).getTag()==DomainTag.VIEW) {
						if(AnalysisUtil.isValidNonUpdatedSourceVariableName(p.getName())==false)
							resource.addError("the name of a view variable should not end with '@post'", Xmu2EProblemType.SYNTAX_ERROR, p);
						
						if(isDuplicateViewVariable(p.getName()))
							resource.addError("the view variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, p);
						else
							addViewVariableName(((edu.ustb.sei.mde.xmu2.Parameter) p).getName());
					}
				}
				
				for(EObject o : root.eContents()) {
					collectVariableNames(o, resource);
				}
			} else if(root instanceof edu.ustb.sei.mde.xmu2.statement.UpdateStatement) {
				Pattern source = ((edu.ustb.sei.mde.xmu2.statement.UpdateStatement) root).getSource();
				collectVariablesInPattern(source, DomainTag.SOURCE, resource);
				checkVariableUsage(source, resource, DomainTag.SOURCE);
				
				Pattern view = ((edu.ustb.sei.mde.xmu2.statement.UpdateStatement) root).getView();
				collectVariablesInPattern(view, DomainTag.VIEW, resource);
				checkVariableUsage(view, resource, DomainTag.VIEW);
				
				for(edu.ustb.sei.mde.xmu2.statement.UpdateClause uc : ((edu.ustb.sei.mde.xmu2.statement.UpdateStatement) root).getClauses()) {
					collectVariableNames(uc, resource);
				}
				
			} else if(root instanceof edu.ustb.sei.mde.xmu2.statement.SwitchStatement) {
				DomainTag flag = null;
				
				if(existInSourceVariable(((edu.ustb.sei.mde.xmu2.statement.SwitchStatement) root).getRoot().getVariable())) {
					flag = DomainTag.SOURCE;
				} else if(existInViewVariable(((edu.ustb.sei.mde.xmu2.statement.SwitchStatement) root).getRoot().getVariable())) {
					flag = DomainTag.VIEW;
				} else if(existInNormalVariable(((edu.ustb.sei.mde.xmu2.statement.SwitchStatement) root).getRoot().getVariable())) {
					flag = DomainTag.NORMAL;
				} else {
					resource.addError("the root variable has not been declared or is declared in the updated-source doamin", Xmu2EProblemType.SYNTAX_ERROR, ((edu.ustb.sei.mde.xmu2.statement.SwitchStatement) root).getRoot());
				}
				
				for(edu.ustb.sei.mde.xmu2.statement.CaseClause cc : ((edu.ustb.sei.mde.xmu2.statement.SwitchStatement) root).getCases()) {
					if(cc instanceof edu.ustb.sei.mde.xmu2.statement.PatternCaseClause) {
						if(flag==DomainTag.NORMAL) {
							TreeIterator<EObject> rp = ((edu.ustb.sei.mde.xmu2.statement.PatternCaseClause) cc).getCondition().eAllContents();
							while(rp.hasNext()) {
								EObject o = rp.next();
								if (o instanceof VariableDeclaration) {
									String name = ((VariableDeclaration) o).getName();
									if (existInSourceVariable(name)
											|| existInUpdatedSourceVariable(name)
											|| existInUpdatedSourceVariable(name))
										resource.addError("the normal variable has been declared in a conflict context",
												Xmu2EProblemType.SYNTAX_ERROR, o);
									else if(!existInNormalVariable(name))
										resource.addWarning("it is recommended to declare the normal variable", Xmu2EProblemType.ANALYSIS_PROBLEM,o);
//										resource.addError("a normal variable cannot have a pattern condition",
//												Xmu2EProblemType.SYNTAX_ERROR, cc);
								}
							}
						} else
							collectVariablesInPattern(((edu.ustb.sei.mde.xmu2.statement.PatternCaseClause) cc).getCondition(), flag, resource);
						
						checkVariableUsage(((edu.ustb.sei.mde.xmu2.statement.PatternCaseClause) cc).getCondition(), resource, flag);
					} else if(cc instanceof edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause) {
						//do nothing
						checkVariableUsage(((edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause) cc).getCondition(), resource, flag);
					}
					
					collectVariableNames(cc.getAction(), resource);
				}
				
			} else if(root instanceof EnforcePatternStatement) {
//				TreeIterator<EObject> rp = root.eAllContents();
//				while(rp.hasNext()) {
//					EObject o = rp.next();
//					if(o instanceof VariableDeclaration) {
//						if(isDuplicateUpdatedSourceVariable(((VariableDeclaration) o).getName()))
//							resource.addError("the updated source variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, o);
//						else {
//							addSourceVariableName(AnalysisUtil.getNonUpdatedSourceVariableName(((VariableDeclaration) o).getName()));
//							addUpdatedSourceVariableName(((VariableDeclaration) o).getName());
//						}
//					}
//				}
				collectVariablesInPattern(((EnforcePatternStatement) root).getPattern(), DomainTag.UPDATED_SOURCE, resource);
				checkVariableUsage(root, resource, DomainTag.UPDATED_SOURCE);
				
			} else if(root instanceof edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement) {
				String varName = ((edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement) root).getNode().getVariable();
				if(isDuplicateUpdatedSourceVariable(varName))
					resource.addError("the updated source variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, root);
				else {
					addUpdatedSourceVariableName(varName);
				}
			} else if(root instanceof edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement) {
				String varName = ((edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement) root).getSource().getVariable();
				if(isDuplicateUpdatedSourceVariable(varName))
					resource.addError("the updated source variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, root);
				else {
					addUpdatedSourceVariableName(varName);
				}
				checkVariableUsage(((edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement) root).getTarget(), resource, DomainTag.UPDATED_SOURCE);
			} else if(root instanceof edu.ustb.sei.mde.xmu2.expression.LoopPath) {
				//do nothing
				String varName = ((edu.ustb.sei.mde.xmu2.expression.LoopPath) root).getVariable().getName();
				if(isDuplicateNormalVariable(varName)) {
					resource.addError("the iterator variable has been declared", Xmu2EProblemType.SYNTAX_ERROR, root);
				}
			} else if(root instanceof AssignStatement) {
				String varName = ((AssignStatement) root).getUpdatedVariable().getVariable();
				if(isDuplicateUpdatedSourceVariable(varName))
					resource.addError("the updated source variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, root);
				else {
					addUpdatedSourceVariableName(varName);
				}
				checkVariableUsage(((AssignStatement) root).getValue(), resource, DomainTag.NORMAL);
			} else if(root instanceof ForEachStatement) {
				Pattern source = ((edu.ustb.sei.mde.xmu2.statement.ForEachStatement) root).getPattern();
				
				String name = source.getRoot().getVariable().getName();
				
				if(existInSourceVariable(name))
					collectVariablesInPattern(source, DomainTag.SOURCE, resource);
				else if(existInNormalVariable(name))
					collectVariablesInPattern(source, DomainTag.NORMAL, resource);
				
				for(EObject o : root.eContents()) {
					collectVariableNames(o,  resource);
				}
			} else if(root instanceof Fail) {
				checkVariableUsage(((Fail) root).getExpression(), resource, DomainTag.NORMAL);
			}
			else {
				for(EObject o : root.eContents()) {
					collectVariableNames(o,  resource);
				}
			}
		}catch(Exception e) {
			resource.addWarning("validity check is not finished because of some exceptions", 
					Xmu2EProblemType.ANALYSIS_PROBLEM, root);
		}
	}

	public void collectVariablesInPattern(Pattern source, DomainTag domain, Xmu2Resource resource) {
		TreeIterator<EObject> sp = source.eAllContents();
		while(sp.hasNext()) {
			EObject o = sp.next();
			if(o instanceof VariableDeclaration) {
				if(o.eContainer() instanceof LoopPath) {
					//do nothing
				} else {
					String varName = ((VariableDeclaration) o).getName();
					if (domain == DomainTag.SOURCE) {
						if (AnalysisUtil
								.isValidNonUpdatedSourceVariableName(varName) == false)
							resource.addError("the name of a source variable should not end with '@post'",
									Xmu2EProblemType.SYNTAX_ERROR, o);

						if (isDuplicateSourceVariable(varName))
							resource.addError("the source variable has been declared in a conflict context",
									Xmu2EProblemType.SYNTAX_ERROR, o);
						else {
							addSourceVariableName(varName);
						}
					} else if (domain == DomainTag.VIEW) {
						if(AnalysisUtil.isValidNonUpdatedSourceVariableName(varName)==false)
							resource.addError("the name of a view variable should not end with '@post'", Xmu2EProblemType.SYNTAX_ERROR, o);
						
						if(isDuplicateViewVariable(varName))
							resource.addError("the view variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, o);
						else
							addViewVariableName(varName);
					} else if (domain == DomainTag.UPDATED_SOURCE) {
						if(isDuplicateUpdatedSourceVariable(varName))
							resource.addError("the updated source variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, o);
						else {
							addSourceVariableName(varName);
						}
					} else if(domain==DomainTag.NORMAL) {
						if(AnalysisUtil.isValidNonUpdatedSourceVariableName(varName)==false) 
							resource.addError("the name of a normal variable should not end with '@post'", Xmu2EProblemType.SYNTAX_ERROR, o);
						
						if(existInSourceVariable(varName)
								|| existInViewVariable(varName))
							resource.addError("the normal variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, o);
						else addUpdatedSourceVariableName(varName);
					}
					
				}
				
			}
		}
	}
	
	public void checkVariableUsage(EObject root, Xmu2Resource res, DomainTag context) {
		try {
			ModelIterator it = new ModelIterator(root);
			while(it.hasNext()) {
				EObject o = it.next();
				if(o instanceof edu.ustb.sei.mde.xmu2.expression.VariableExpression) {
					String name = ((edu.ustb.sei.mde.xmu2.expression.VariableExpression) o).getVariable();
					
					if(isIteratorName(name,o)) {
						
					} else {
						if(context==DomainTag.NORMAL) {
							if(existInNormalVariable(name) || 
									existInSourceVariable(name) || 
									existInViewVariable(name) ) {
								//valid
							} else {
								res.addError("undefined normal variable", Xmu2EProblemType.SYNTAX_ERROR, o);
							}
						} else if(context == DomainTag.SOURCE) {
							if(existInNormalVariable(name) || 
									existInSourceVariable(name) ) {
								//valid
							} else {
								res.addError("undefined source variable", Xmu2EProblemType.SYNTAX_ERROR, o);
							}
						} else if(context == DomainTag.VIEW) {
							if(existInNormalVariable(name) || 
									existInViewVariable(name) ) {
								//valid
							} else {
								res.addError("undefined view variable", Xmu2EProblemType.SYNTAX_ERROR, o);
							}
						} else if(context == DomainTag.UPDATED_SOURCE) {
							if(existInNormalVariable(name) || 
									existInSourceVariable(name) || 
									existInUpdatedSourceVariable(name) ) {
								//valid
							} else {
								if(existInViewVariable(name))
									res.addWarning("using view variable in the context of updated source is not recommended", Xmu2EProblemType.ANALYSIS_PROBLEM, o);
							}
						}
					}
				}
			}
		} catch(Exception e) {
			res.addWarning("validity check is not finished because of some exceptions", Xmu2EProblemType.ANALYSIS_PROBLEM, root);
		}
	}

	private boolean isIteratorName(String name, EObject root) {
		edu.ustb.sei.mde.xmu2.expression.LoopPath loop = 
				(edu.ustb.sei.mde.xmu2.expression.LoopPath)AnalysisUtil
				.getAncestor(root, ExpressionPackage.eINSTANCE.getLoopPath());
		
		if(loop==null) 
			return false;
		else {
			if(loop.getVariable().getName().equals(name)) 
				return true;
			else 
				return isIteratorName(name, loop.eContainer());
		}
	}
}
