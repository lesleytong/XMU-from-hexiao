package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.xmu2.AbstractRule;
import edu.ustb.sei.mde.xmu2.EntryData;
import edu.ustb.sei.mde.xmu2.EntryPoint;
import edu.ustb.sei.mde.xmu2.ModelRule;
import edu.ustb.sei.mde.xmu2.Parameter;
import edu.ustb.sei.mde.xmu2.TransformationModel;
import edu.ustb.sei.mde.xmu2.VariableDeclaration;
import edu.ustb.sei.mde.xmu2.expression.ExpressionPackage;
import edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2OptionProvider;
import edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Options;
import edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ResourcePostProcessor;
import edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ResourcePostProcessorProvider;
import edu.ustb.sei.mde.xmu2.resource.xmu2.Xmu2EProblemType;
import edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement;
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
		
		
		try {
			TransformationModel model = (TransformationModel)resource.getContents().get(0);
			for(AbstractRule r : model.getRules()) {
				if(termination) break;
				if(r instanceof ModelRule) {
					this.checkVariableValidity((ModelRule)r, resource);
				}
			}
			for(EntryPoint ep : model.getEntryPoints()) {
				if(termination) break;
				checkEntryPoints(ep, resource);
			}
		} catch(Exception e) {
			resource.addWarning("validity check is not finished becase of some exception", 
					Xmu2EProblemType.ANALYSIS_PROBLEM, null);
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
		// TODO Auto-generated method stub
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
	public void checkVariableValidity(ModelRule rule, Xmu2Resource resource) {
		VariableValidityContext con = new VariableValidityContext();
		
		//collect variable names and check naming rules
		con.collectVariableNames(rule, resource);
		
		checkRuleCallValidity(rule,resource,con);
		
		return;
	}
	
	public void checkRuleCallValidity(ModelRule rule,Xmu2Resource resource,VariableValidityContext cont) {
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
			resource.addWarning("validity check is not finished becase of some exception", 
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
		sourceVariableNames.add(n);
	}
	void addViewVariableName(String n) {
		viewVariableNames.add(n);
	}
	void addUpdatedSourceVariableName(String n) {
		updatedSourceVariableNames.add(n);
	}
	void addNromalVariableName(String n) {
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
		if(name.endsWith(Constants.POST))
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
							addNromalVariableName(((edu.ustb.sei.mde.xmu2.Parameter) p).getName());
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
						addNromalVariableName(vd.getName());
				}
				
				for(EObject o : root.eContents()) {
					collectVariableNames(o, resource);
				}
			} else if(root instanceof edu.ustb.sei.mde.xmu2.statement.UpdateStatement) {
				TreeIterator<EObject> sp = ((edu.ustb.sei.mde.xmu2.statement.UpdateStatement) root).getSource().eAllContents();
				TreeIterator<EObject> vp = ((edu.ustb.sei.mde.xmu2.statement.UpdateStatement) root).getView().eAllContents();
				
				while(sp.hasNext()) {
					EObject o = sp.next();
					if(o instanceof VariableDeclaration) {
						if(AnalysisUtil.isValidNonUpdatedSourceVariableName(((VariableDeclaration) o).getName())==false)
							resource.addError("the name of a source variable should not end with '@post'", Xmu2EProblemType.SYNTAX_ERROR, o);
						
						if(isDuplicateSourceVariable(((VariableDeclaration) o).getName()))
							resource.addError("the source variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, o);
						else {
							addSourceVariableName(((VariableDeclaration) o).getName());
						}
					}
				}
				
				checkVariableUsage(((edu.ustb.sei.mde.xmu2.statement.UpdateStatement) root).getSource(), resource, DomainTag.SOURCE);
				
				while(vp.hasNext()) {
					EObject o = vp.next();
					if(o instanceof VariableDeclaration) {
						if(AnalysisUtil.isValidNonUpdatedSourceVariableName(((VariableDeclaration) o).getName())==false)
							resource.addError("the name of a view variable should not end with '@post'", Xmu2EProblemType.SYNTAX_ERROR, o);
						
						if(isDuplicateViewVariable(((VariableDeclaration) o).getName()))
							resource.addError("the view variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, o);
						else
							addViewVariableName(((VariableDeclaration) o).getName());
					}
				}
				
				checkVariableUsage(((edu.ustb.sei.mde.xmu2.statement.UpdateStatement) root).getView(), resource, DomainTag.VIEW);
				
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
						TreeIterator<EObject> rp = ((edu.ustb.sei.mde.xmu2.statement.PatternCaseClause) cc).getCondition().eAllContents();
						while(rp.hasNext()) {
							EObject o = rp.next();
							if(o instanceof VariableDeclaration) {
								if(flag==DomainTag.SOURCE) {
									
									if(isDuplicateSourceVariable(((VariableDeclaration) o).getName()))
										resource.addError("the source variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, o);
									else
										addSourceVariableName(((VariableDeclaration) o).getName());
									
								}
								else if(flag==DomainTag.VIEW) {
									if(isDuplicateViewVariable(((VariableDeclaration) o).getName()))
										resource.addError("the view variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, o);
									else
										addViewVariableName(((VariableDeclaration) o).getName());
								}
								else if(flag==DomainTag.NORMAL) {
									if(isDuplicateNormalVariable(((VariableDeclaration) o).getName()))
										resource.addError("the normal variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, o);
									else
										resource.addError("a normal variable cannot have a pattern condition", Xmu2EProblemType.SYNTAX_ERROR, cc);
								}
							}
						}
						
						checkVariableUsage(((edu.ustb.sei.mde.xmu2.statement.PatternCaseClause) cc).getCondition(), resource, flag);
					} else if(cc instanceof edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause) {
						//do nothing
						checkVariableUsage(((edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause) cc).getCondition(), resource, flag);
					}
					
					collectVariableNames(cc.getAction(), resource);
				}
				
			} else if(root instanceof EnforcePatternStatement) {
				TreeIterator<EObject> rp = root.eAllContents();
				while(rp.hasNext()) {
					EObject o = rp.next();
					if(o instanceof VariableDeclaration) {
						if(isDuplicateUpdatedSourceVariable(((VariableDeclaration) o).getName()))
							resource.addError("the updated source variable has been declared in a conflict context", Xmu2EProblemType.SYNTAX_ERROR, o);
						else {
							addUpdatedSourceVariableName(((VariableDeclaration) o).getName());
						}
					}
				}
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
			} else {
				for(EObject o : root.eContents()) {
					collectVariableNames(o,  resource);
				}
			}
		}catch(Exception e) {
			resource.addWarning("validity check is not finished becase of some exception", 
					Xmu2EProblemType.ANALYSIS_PROBLEM, root);
		}
	}
	
	public void checkVariableUsage(EObject root, Xmu2Resource res, DomainTag context) {
		try {
			ModelIterator it = new ModelIterator(root);
			while(it.hasNext()) {
				EObject o = it.next();
				if(o instanceof edu.ustb.sei.mde.xmu2.expression.VariableExpression) {
					String name = ((edu.ustb.sei.mde.xmu2.expression.VariableExpression) o).getVariable();
					
					if(isIteratorName(name,root)) {
						
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
								res.addWarning("using view variable in the context of updated source is not recommended", Xmu2EProblemType.ANALYSIS_PROBLEM, o);
							}
						}
					}
				}
			}
		} catch(Exception e) {
			res.addWarning("validity check is not finished becase of some exception", Xmu2EProblemType.ANALYSIS_PROBLEM, root);
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