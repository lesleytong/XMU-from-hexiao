package edu.ustb.sei.mde.xmu2.runtime.build;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.mde.xmu2.AbstractRule;
import edu.ustb.sei.mde.xmu2.ArithmeticRule;
import edu.ustb.sei.mde.xmu2.EntryData;
import edu.ustb.sei.mde.xmu2.EntryPoint;
import edu.ustb.sei.mde.xmu2.ModelRule;
import edu.ustb.sei.mde.xmu2.Parameter;
import edu.ustb.sei.mde.xmu2.TransformationModel;
import edu.ustb.sei.mde.xmu2.VariableDeclaration;
import edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression;
import edu.ustb.sei.mde.xmu2.expression.EmptyExpression;
import edu.ustb.sei.mde.xmu2.expression.EmptyValueType;
import edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression;
import edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression;
import edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression;
import edu.ustb.sei.mde.xmu2.expression.PathExpression;
import edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression;
import edu.ustb.sei.mde.xmu2.pattern.PatternPackage;
import edu.ustb.sei.mde.xmu2.runtime.exceptions.BuildException;
import edu.ustb.sei.mde.xmu2.statement.ActionType;
import edu.ustb.sei.mde.xmu2.statement.BlockStatement;
import edu.ustb.sei.mde.xmu2.statement.DefaultCaseClause;
import edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement;
import edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause;
import edu.ustb.sei.mde.xmu2.statement.PatternCaseClause;
import edu.ustb.sei.mde.xmu2.statement.RuleCallStatement;
import edu.ustb.sei.mde.xmu2.statement.Skip;
import edu.ustb.sei.mde.xmu2.statement.StatementPackage;
import edu.ustb.sei.mde.xmu2.statement.SwitchStatement;
import edu.ustb.sei.mde.xmu2.statement.UpdateClause;
import edu.ustb.sei.mde.xmu2.statement.UpdateStatement;
import edu.ustb.sei.mde.xmu2.util.AnalysisUtil;
import edu.ustb.sei.mde.xmu2common.DomainTag;
import edu.ustb.sei.mde.xmu2common.LoopOperator;
import edu.ustb.sei.mde.xmu2common.UnaryOperator;
import edu.ustb.sei.mde.xmu2core.AlignStatement;
import edu.ustb.sei.mde.xmu2core.BooleanValueExpression;
import edu.ustb.sei.mde.xmu2core.CaseExpressionClause;
import edu.ustb.sei.mde.xmu2core.CasePatternClause;
import edu.ustb.sei.mde.xmu2core.CaseStatement;
import edu.ustb.sei.mde.xmu2core.EmptyValueExpression;
import edu.ustb.sei.mde.xmu2core.EnforceLinkStatement;
import edu.ustb.sei.mde.xmu2core.EnforceNodeStatement;
import edu.ustb.sei.mde.xmu2core.EntryRuleParameter;
import edu.ustb.sei.mde.xmu2core.EnumValueExpression;
import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.IntegerValueExpression;
import edu.ustb.sei.mde.xmu2core.MatchPattern;
import edu.ustb.sei.mde.xmu2core.ObjectValueExpression;
import edu.ustb.sei.mde.xmu2core.OclCollectionType;
import edu.ustb.sei.mde.xmu2core.Path;
import edu.ustb.sei.mde.xmu2core.Pattern;
import edu.ustb.sei.mde.xmu2core.PatternExpression;
import edu.ustb.sei.mde.xmu2core.PatternNode;
import edu.ustb.sei.mde.xmu2core.Procedure;
import edu.ustb.sei.mde.xmu2core.ProcedureCallStatement;
import edu.ustb.sei.mde.xmu2core.Statement;
import edu.ustb.sei.mde.xmu2core.StringValueExpression;
import edu.ustb.sei.mde.xmu2core.Transformation;
import edu.ustb.sei.mde.xmu2core.Variable;
import edu.ustb.sei.mde.xmu2core.Xmu2coreFactory;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

public class BXCodeGenerator {

	public static final String POST = "@post";
	private Transformation transformation = null;;


	public BXCodeGenerator() {
		// TODO Auto-generated constructor stub
		transformation = Xmu2coreFactory.eINSTANCE.createTransformation();
	}
	
	public Transformation build(TransformationModel model) {
		transformation.setName(model.getName());
		transformation.getPackages().addAll(model.getPackages());
		convertRules(model, transformation);
		return transformation;
	}
	
	protected void convertRules(TransformationModel model, Transformation transformation) {
		Map<AbstractRule,Procedure> ruleMap = new HashMap<AbstractRule,Procedure>();
		
		for(AbstractRule r : model.getRules()) {
			Procedure p = Xmu2coreFactory.eINSTANCE.createProcedure();
			p.setName(r.getName());
			transformation.getProcedures().add(p);
			ruleMap.put(r, p);
		}
		
		int index = 0;
		
		for(index = 0; index < model.getRules().size() ; index++) {
			AbstractRule rule = model.getRules().get(index);
			Procedure p = transformation.getProcedures().get(index);
			
			if(rule instanceof ModelRule) {
				this.convertModelRule((ModelRule)rule, p,transformation);
			} else  {
				this.convertArithmeticRule((ArithmeticRule)rule,p);
			}
		}
		
		for(EntryPoint entry : model.getEntryPoints()) {
			ModelRule rule = entry.getRule();
			Procedure proc = ruleMap.get(rule);
			ProcedureCallStatement statement = Xmu2coreFactory.eINSTANCE.createProcedureCallStatement();
			statement.setProcedure(proc);
			
			for(EntryData e : entry.getParameters()) {
				EntryRuleParameter p = Xmu2coreFactory.eINSTANCE.createEntryRuleParameter();
				p.setTag(e.getTag());
				p.setIndex(e.getIndex());
				p.setFragment(e.getFragment());
				statement.getParameters().add(p);
			}
			
			transformation.getEntryRules().add(statement);
		}
	}
	
	private void convertArithmeticRule(ArithmeticRule rule, Procedure p) {
		throw new BuildException("Unconverted arithmetic rule "+rule.getName());
	}

	protected void convertModelRule(ModelRule rule, Procedure p, Transformation transformation) {
		VarMapStack map = new VarMapStack();
		collectVariables(rule, map);
		collectUpdatedSourceVariablesFromPattern(rule,map);
		
		map.registerVariable(p);
		
		for(edu.ustb.sei.mde.xmu2.Parameter para : rule.getParameters()) {
			Variable v = map.get(para.getName());
			p.getParameters().add(v);
		}
		
		p.getStatements().addAll(convertStatement(rule.getStatement(),map,transformation));
	}
	
	private void collectUpdatedSourceVariablesFromPattern(ModelRule rule, VarMapStack map) {
		TreeIterator<EObject> it = rule.eAllContents();
		
		while(it.hasNext()) {
			EObject obj = it.next();
			if(obj instanceof UpdateStatement) {
				edu.ustb.sei.mde.xmu2.pattern.Pattern pat = ((UpdateStatement) obj).getSource();
				TreeIterator<EObject> varIt = pat.eAllContents();
				while(varIt.hasNext()) {
					EObject vo = varIt.next();
					if(vo instanceof VariableDeclaration 
							&& !(vo.eContainer() instanceof edu.ustb.sei.mde.xmu2.expression.LoopPath)) {
						String varName = ((VariableDeclaration) vo).getName();
						String ov = null,pv = null;
						
						ov = AnalysisUtil.getNonUpdatedSourceVariableName(varName);
						pv = AnalysisUtil.getUpdatedSourceVariableName(varName);
						
						
						Variable ovv = map.get(ov);
						if(ovv==null) {
							throw new BuildException("cannot find the correlated variable of "+pv); 
						} else if(ovv.getTag()!=DomainTag.SOURCE) {
							throw new BuildException("the correlated variable of "+pv+" is not a source variable");
						}
						
						Variable pvv = findOrCreateVariable(pv, map);
						setVariableType(pvv, ovv.getType());
						setVariableDomainTag(pvv, DomainTag.UPDATED_SOURCE);
					}
				}
			}
		}
	}

	private List<Statement> convertStatement(edu.ustb.sei.mde.xmu2.statement.Statement statement, VarMapStack varMap, Transformation transformation) {
		if(statement==null) return Collections.emptyList();
		
		if(statement instanceof UpdateStatement) {
			AlignStatement stmt = Xmu2coreFactory.eINSTANCE.createAlignStatement();
			
			
			varMap.push();
			
			refreshVariableTypes(varMap,false,((UpdateStatement) statement).getSource(),((UpdateStatement) statement).getView());
			stmt.setSource(convertPatternMatching(((UpdateStatement) statement).getSource(), varMap));
			stmt.setView(convertPatternMatching(((UpdateStatement) statement).getView(), varMap));
			
//			stmt.getSourceCreationStatements().addAll(convertPatternEnforcementStatement(((UpdateStatement) statement).getSource(), varMap, true));
			stmt.getViewCreationStatements().addAll(convertPatternEnforcementStatement(((UpdateStatement) statement).getView(), varMap,false));
			
			varMap.push();
			UpdateClause m = findUpdateClause(ActionType.MATCH, (UpdateStatement)statement);
			if(m!=null) {
				boolean skip = hasSkip(m.getStatement());
				List<Statement> defaultSourceCreationStatements = skip ? null :
						convertPatternEnforcementStatement(((UpdateStatement) statement).getSource(), varMap, true);
				List<Statement> specifiedStatements = reorderAndCombine(convertStatement(m.getStatement(), varMap, transformation), defaultSourceCreationStatements);
				stmt.getMatch().addAll(specifiedStatements);
			}
			varMap.pop();
			
			varMap.push();
			UpdateClause ums = findUpdateClause(ActionType.UNMATCHS, (UpdateStatement)statement);
			if(ums!=null) {
				stmt.getUnmatchs().addAll(convertStatement(ums.getStatement(), varMap, transformation));
			}
			varMap.pop();
			
			varMap.push();
			UpdateClause umv = findUpdateClause(ActionType.UNMATCHV, (UpdateStatement)statement);
			if(umv!=null) {
				boolean skip = hasSkip(umv.getStatement());
				List<Statement> defaultSourceCreationStatements = null, defaultMatchStatements = null;
				
				if(!skip) {
					if(m!=null)
						defaultMatchStatements = convertStatement(m.getStatement(), varMap, transformation);
					defaultSourceCreationStatements = convertPatternEnforcementStatement(((UpdateStatement) statement).getSource(), varMap, true);
				}
				
				List<Statement> convertStatement = convertStatement(umv.getStatement(), varMap, transformation);
				List<Statement> specifiedStatements = reorderAndCombine(convertStatement, defaultMatchStatements, defaultSourceCreationStatements);
				stmt.getUnmatchv().addAll(specifiedStatements);
			} else {
				List<Statement> defaultSourceCreationStatements = null, defaultMatchStatements = null;
				
				defaultSourceCreationStatements = convertPatternEnforcementStatement(((UpdateStatement) statement).getSource(), varMap, true);
				
				if(m!=null)
					defaultMatchStatements = convertStatement(m.getStatement(), varMap, transformation);

				List<Statement> specifiedStatements = reorderAndCombine(defaultMatchStatements, defaultSourceCreationStatements);
				
				stmt.getUnmatchv().addAll(specifiedStatements);
			}
			varMap.pop();
			
			varMap.pop();
			
			return Collections.singletonList(stmt);
			
		} else if(statement instanceof SwitchStatement) {
			CaseStatement stmt = Xmu2coreFactory.eINSTANCE.createCaseStatement();
			String rootVarName = ((SwitchStatement) statement).getRoot().getVariable();
			Variable rootVar = varMap.get(rootVarName);
			
			stmt.setTag(rootVar.getTag());
			
			for(edu.ustb.sei.mde.xmu2.statement.CaseClause c : ((SwitchStatement) statement).getCases()) {
				if(c instanceof PatternCaseClause) {
					CasePatternClause cc = Xmu2coreFactory.eINSTANCE.createCasePatternClause();
					
					varMap.push();
					refreshVariableTypes(varMap,false,((PatternCaseClause) c).getCondition());
					cc.setCondition(convertPatternMatching(((PatternCaseClause) c).getCondition(), varMap));
					cc.getAction().addAll(convertStatement(c.getAction(), varMap, transformation));
					
					if(rootVar.getTag()==DomainTag.VIEW) {
						cc.getViewCreationStatements().addAll(convertPatternEnforcementStatement(((PatternCaseClause) c).getCondition(), varMap, false));
						cc.getSourceCheckStatements().addAll(convertSourceCheckStatement(c.getAction(),varMap,transformation));
					}
					
					
					stmt.getClauses().add(cc);
					
					varMap.pop();
					
				} else if(c instanceof ExpressionCaseClause) {
					CaseExpressionClause cc = Xmu2coreFactory.eINSTANCE.createCaseExpressionClause();
					
					varMap.push();
					cc.setCondition(convertExpression(((ExpressionCaseClause) c).getCondition(), varMap,false));
					cc.getAction().addAll(convertStatement(c.getAction(), varMap, transformation));
					
					if(rootVar.getTag()==DomainTag.VIEW) {
						cc.getSourceCheckStatements().addAll(convertSourceCheckStatement(c.getAction(),varMap,transformation));
					}
					
					varMap.pop();
					
					stmt.getClauses().add(cc);
				} else if(c instanceof DefaultCaseClause) {
					CaseExpressionClause cc = Xmu2coreFactory.eINSTANCE.createCaseExpressionClause();
					edu.ustb.sei.mde.xmu2core.BooleanValueExpression cond = Xmu2coreFactory.eINSTANCE.createBooleanValueExpression();
					cond.setValue(true);

					varMap.push();
					cc.setCondition(cond);
					cc.getAction().addAll(convertStatement(c.getAction(), varMap, transformation));
					
					if(rootVar.getTag()==DomainTag.VIEW) {
						cc.getSourceCheckStatements().addAll(convertSourceCheckStatement(c.getAction(),varMap,transformation));
					}
					varMap.pop();
					
					stmt.getClauses().add(cc);
				}
			}
			
			return Collections.singletonList(stmt);
		} else if(statement instanceof RuleCallStatement) {
			String ruleName = ((RuleCallStatement) statement).getRule().getName();
			Procedure p = null;
			
			for(Procedure ip : transformation.getProcedures()) {
				if(ip.getName().equals(ruleName)) {
					p = ip;
					break;
				}
			}
			
			edu.ustb.sei.mde.xmu2core.ProcedureCallStatement stmt = Xmu2coreFactory.eINSTANCE.createProcedureCallStatement();
			stmt.setProcedure(p);
			for(edu.ustb.sei.mde.xmu2.expression.Expression e : ((RuleCallStatement) statement).getParameters()) {
				stmt.getParameters().add(convertExpression(e, varMap, false));
				stmt.getUpdatedParameters().add(convertExpression(e,varMap,true));
			}
			return Collections.singletonList(stmt);
			
		} else if(statement instanceof EnforcePatternStatement) {
			refreshVariableTypes(varMap,true,((EnforcePatternStatement) statement).getPattern());
			return convertPatternEnforcementStatement(((EnforcePatternStatement) statement).getPattern(),varMap,true);
		} else if(statement instanceof edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement) {
			edu.ustb.sei.mde.xmu2core.DeleteNodeStatement stmt = Xmu2coreFactory.eINSTANCE.createDeleteNodeStatement();
			String sourceVarName = ((edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement) statement).getNode().getVariable();
			Variable pv = getVariableInUpdatedContext(sourceVarName, varMap);
			stmt.setTarget(pv);
			return Collections.singletonList(stmt);
		} else if(statement instanceof edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement) {
			edu.ustb.sei.mde.xmu2core.DeleteLinkStatement stmt = Xmu2coreFactory.eINSTANCE.createDeleteLinkStatement();
			String sourceVarName = ((edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement) statement).getSource().getVariable();
			String feature = ((edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement) statement).getFeature();
			Variable pv = getVariableInUpdatedContext(sourceVarName, varMap);
			EClass type = (EClass) pv.getType();
			EStructuralFeature f = type.getEStructuralFeature(feature);
			stmt.setSource(pv);
			stmt.setFeature(f);
			stmt.setTarget(convertExpression(((edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement) statement).getTarget(),varMap,true));
			return Collections.singletonList(stmt);
		} else if(statement instanceof edu.ustb.sei.mde.xmu2.statement.ForEachStatement) {
			edu.ustb.sei.mde.xmu2core.ForEachStatement stmt = Xmu2coreFactory.eINSTANCE.createForEachStatement();
			stmt.setPattern(convertPatternMatching(((edu.ustb.sei.mde.xmu2.statement.ForEachStatement) statement).getPattern(),varMap));
			stmt.getAction().addAll(convertStatement(((edu.ustb.sei.mde.xmu2.statement.ForEachStatement) statement).getAction(),varMap,transformation));
			return Collections.singletonList(stmt);
		} else if(statement instanceof edu.ustb.sei.mde.xmu2.statement.BlockStatement) {
//			edu.ustb.sei.mde.xmu2core.BlockStatement result = Xmu2coreFactory.eINSTANCE.createBlockStatement();
			List<Statement> result = new ArrayList<Statement>();
			for(edu.ustb.sei.mde.xmu2.statement.Statement stmt : ((edu.ustb.sei.mde.xmu2.statement.BlockStatement) statement).getBody()) {
				result.addAll(this.convertStatement(stmt,varMap,transformation));
			}
			return result;
		} else if(statement instanceof Skip) {
			return Collections.EMPTY_LIST;
		}
		throw new BuildException("Unconverted statement "+statement);
	}
	
	
	private List<Statement> convertSourceCheckStatement(
			edu.ustb.sei.mde.xmu2.statement.Statement action, VarMapStack varMap, Transformation transformation) {
		if(action instanceof BlockStatement) {
			List<Statement> res = new ArrayList<Statement>();
			for(edu.ustb.sei.mde.xmu2.statement.Statement s : ((BlockStatement) action).getBody()) {
				res.addAll(convertSourceCheckStatement(s, varMap,transformation));
			}
			return res;
		} else if(action instanceof EnforcePatternStatement) {
			Pattern pattern = convertPatternMatching(((EnforcePatternStatement) action).getPattern(),varMap);
			MatchPattern stmt = Xmu2coreFactory.eINSTANCE.createMatchPattern();
			stmt.setPattern(pattern);
			return Collections.singletonList(stmt);
		} else {
			return convertStatement(action, varMap, transformation);
		}
	}

	private boolean hasSkip(edu.ustb.sei.mde.xmu2.statement.Statement root) {
		if(root instanceof Skip) return true;
		else if(root instanceof BlockStatement){
			for(edu.ustb.sei.mde.xmu2.statement.Statement s : ((BlockStatement) root).getBody()) {
				if(hasSkip(s)) return true;
			}
		}
		return false;
	}
	

	private List<Statement> reorderAndCombine(@SuppressWarnings("unchecked") List<Statement> ... convertStatements) {
		// TODO Auto-generated method stub
		List<Statement> enforce = new ArrayList<Statement>();
		List<Statement> ruleCall = new ArrayList<Statement>();
		
		for(List<Statement> convertStatement : convertStatements) {
			if(convertStatement !=null) {
				for(Statement s : convertStatement) {
					if(s instanceof ProcedureCallStatement) {
						ruleCall.add(s);
					} else {
						enforce.add(s);
					}
				}
			}
		}
		enforce.addAll(ruleCall);
		return enforce;
	}
	

	private void refreshVariableTypes(VarMapStack varMap, boolean updatedMode, edu.ustb.sei.mde.xmu2.pattern.Pattern... patterns) {
		for(edu.ustb.sei.mde.xmu2.pattern.Pattern pat : patterns) {
			TreeIterator<EObject> it = pat.eAllContents();
			while(it.hasNext()) {
				EObject o = it.next();
				if(o instanceof VariableDeclaration
						&& !(o.eContainer() instanceof edu.ustb.sei.mde.xmu2.expression.LoopPath)) {
					String varName = ((VariableDeclaration) o).getName();
					EClassifier t = ((VariableDeclaration) o).getType();
					Variable v = null;

					if(updatedMode) 
						v = getVariableInUpdatedContext(varName, varMap);
					else v = varMap.get(varName);
					
					v.setType(t);
				}
			}
		}
	}

	static protected UpdateClause findUpdateClause(ActionType type, UpdateStatement statement) {
		UpdateClause res = null;
		for(UpdateClause c : statement.getClauses()) {
			if(c.getType()==type) {
				res = c;
				break;
			} else if(c.getType()==ActionType.DEFAULT) {
				if(res==null) res = c;
			}
		}
		return res;
	}

	private List<Statement> convertPatternEnforcementStatement(edu.ustb.sei.mde.xmu2.pattern.Pattern statement, VarMapStack varMap,boolean updatedSource) {
		List<Statement> stmt = new ArrayList<Statement>();
		
		convertPatternNodeEnforcement(statement.getRoot(),stmt, varMap,updatedSource);
		
		return stmt;
	}

	private EnforceNodeStatement convertPatternNodeEnforcement(edu.ustb.sei.mde.xmu2.pattern.PatternNode root, List<Statement> stmt,
			VarMapStack varMap,boolean updatedSource) {
		EClassifier t = root.getVariable().getType();
		EnforceNodeStatement s = null;
		if(t instanceof EClass) {
			s = Xmu2coreFactory.eINSTANCE.createEnforceNodeStatement();
			Variable var = updatedSource ? 
					getVariableInUpdatedContext(root.getVariable().getName(), varMap) : 
						varMap.get(root.getVariable().getName());
			s.setNode(var);
			s.setType(t);
			s.setTag((updatedSource ? DomainTag.UPDATED_SOURCE : DomainTag.VIEW));
			stmt.add(s);
		}
		
		for(edu.ustb.sei.mde.xmu2.pattern.PatternExpression e : root.getExpressions()) {
			convertPatternExpressionEnforcement(e, stmt, varMap, updatedSource);
		}
		
		return s;
	}
	
	
	private void convertPatternExpressionEnforcement(edu.ustb.sei.mde.xmu2.pattern.PatternExpression e, List<Statement> stmt, VarMapStack varMap,boolean updatedSource) {
		if(e instanceof edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression) {
			
			edu.ustb.sei.mde.xmu2.pattern.PatternNode targetNode = ((edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression) e).getTargetNode();
			
			Variable sv = updatedSource ? getVariableInUpdatedContext(e.getOwnerNode().getVariable().getName(), varMap) : 
						varMap.get(e.getOwnerNode().getVariable().getName());
			
			EStructuralFeature f = e.getFeature();
			
			Variable tv = updatedSource ? getVariableInUpdatedContext(targetNode.getVariable().getName(), varMap) : 
								varMap.get(targetNode.getVariable().getName());
			
			EnforceNodeStatement ens = this.convertPatternNodeEnforcement(targetNode, stmt, varMap, updatedSource);			

			if(targetNode.getVariable().getType() instanceof EClass) {
				if(!f.isMany()) {
					edu.ustb.sei.mde.xmu2core.VariableExpression exp = Xmu2coreFactory.eINSTANCE.createVariableExpression();
					exp.setVariable(sv);
					edu.ustb.sei.mde.xmu2core.FeaturePath fp = Xmu2coreFactory.eINSTANCE.createFeaturePath();
					fp.setFeature(f);
					exp.getPaths().add(fp);
					ens.setCandidate(exp);
				}	
			}
			
			EnforceLinkStatement el = Xmu2coreFactory.eINSTANCE.createEnforceLinkStatement();
			el.setSource(sv);
			el.setFeature(f);
			el.setTag((updatedSource ? DomainTag.UPDATED_SOURCE : DomainTag.VIEW));
			
			edu.ustb.sei.mde.xmu2core.VariableExpression ve = Xmu2coreFactory.eINSTANCE.createVariableExpression();
			ve.setVariable(tv);
			el.setTarget(ve);
			
			el.setSourceType(e.getOwnerNode().getVariable().getType());
			
			el.setSelector((edu.ustb.sei.mde.xmu2core.LoopPath)convertPath(null,e.getSelector(), varMap,updatedSource));
			el.setPosition((edu.ustb.sei.mde.xmu2core.PositionPath)convertPath(null,e.getPosition(), varMap,updatedSource));
			stmt.add(el);
			return;
		} else if(e instanceof edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression) {
			Variable sv = updatedSource ? 
					getVariableInUpdatedContext(e.getOwnerNode().getVariable().getName(), varMap) : 
						varMap.get(e.getOwnerNode().getVariable().getName());
			EStructuralFeature f = e.getFeature();
			EnforceLinkStatement el = Xmu2coreFactory.eINSTANCE.createEnforceLinkStatement();
			el.setSource(sv);
			el.setFeature(f);
			el.setTag((updatedSource ? DomainTag.UPDATED_SOURCE : DomainTag.VIEW));
			el.setTarget(convertExpression(((edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression) e).getTargetExpression(), varMap,updatedSource));
			el.setSourceType(e.getOwnerNode().getVariable().getType());
			el.setSelector((edu.ustb.sei.mde.xmu2core.LoopPath)convertPath(null,e.getSelector(), varMap,updatedSource));
			el.setPosition((edu.ustb.sei.mde.xmu2core.PositionPath)convertPath(null,e.getPosition(), varMap,updatedSource));
			stmt.add(el);
			return;
		}
		throw new BuildException("Unconverted pattern expression enforcement");
	}
	
	static protected Variable getVariableInUpdatedContext(String varName, VarMapStack stack) {
		Variable v = null;
		String pvn = null;
		String ovn = null;
		
		ovn = AnalysisUtil.getNonUpdatedSourceVariableName(varName);
		pvn = AnalysisUtil.getUpdatedSourceVariableName(varName);
		
		v = stack.get(pvn);
		if(v==null) {
			v = stack.get(ovn);
			if(v==null) {
				throw new BuildException("Unregistered variable "+ovn);
			} else {
				if(v.getType() instanceof EDataType) {
					return v;
				} else {
					throw new BuildException("Unregistered variable "+pvn);
				}
			}
		} else return v;
	}

	static protected String getUpdatedSourceVariableName(String sourceVarName) {
		String pvn;
		if(sourceVarName.endsWith(POST)) {
			pvn = sourceVarName;
		} else {
			pvn = sourceVarName+POST;
		}
		return pvn;
	}

	private Expression convertExpression(edu.ustb.sei.mde.xmu2.expression.Expression target,
			VarMapStack varMap, boolean updated) {
		if(target==null) 
			return null;
		
		if(target instanceof edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression) {
			edu.ustb.sei.mde.xmu2core.BooleanOrExpression exp = Xmu2coreFactory.eINSTANCE.createBooleanOrExpression();
			for(edu.ustb.sei.mde.xmu2.expression.Expression p : ((edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression) target).getOperands()) {
				exp.getOperands().add(convertExpression(p, varMap,updated));
			}
			return exp;
		} else if(target instanceof edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression) {
			edu.ustb.sei.mde.xmu2core.BooleanAndExpression exp = Xmu2coreFactory.eINSTANCE.createBooleanAndExpression();
			for(edu.ustb.sei.mde.xmu2.expression.Expression p : ((edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression) target).getOperands()) {
				exp.getOperands().add(convertExpression(p, varMap,updated));
			}
			return exp;
		} else if(target instanceof edu.ustb.sei.mde.xmu2.expression.RelationalExpression) {
			edu.ustb.sei.mde.xmu2core.RelationalExpression exp = Xmu2coreFactory.eINSTANCE.createRelationalExpression();
			exp.setOperator(((edu.ustb.sei.mde.xmu2.expression.RelationalExpression) target).getOperator());
			exp.setLeft(convertExpression(((edu.ustb.sei.mde.xmu2.expression.RelationalExpression) target).getLeft(), varMap,updated));
			exp.setRight(convertExpression(((edu.ustb.sei.mde.xmu2.expression.RelationalExpression) target).getRight(), varMap,updated));
			return exp;
		} else if(target instanceof edu.ustb.sei.mde.xmu2.expression.AdditiveExpression) {
			edu.ustb.sei.mde.xmu2core.AdditiveExpression exp = Xmu2coreFactory.eINSTANCE.createAdditiveExpression();
			exp.getOperators().addAll(((edu.ustb.sei.mde.xmu2.expression.AdditiveExpression) target).getOperators());
			
			for(edu.ustb.sei.mde.xmu2.expression.Expression e : ((edu.ustb.sei.mde.xmu2.expression.AdditiveExpression) target).getOperands()) {
				exp.getOperands().add(convertExpression(e, varMap,updated));
			}
			return exp;
		} else if(target instanceof edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression) {
			edu.ustb.sei.mde.xmu2core.MultiplicativeExpression exp = Xmu2coreFactory.eINSTANCE.createMultiplicativeExpression();
			exp.getOperators().addAll(((edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression) target).getOperators());
			
			for(edu.ustb.sei.mde.xmu2.expression.Expression e : ((edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression) target).getOperands()) {
				exp.getOperands().add(convertExpression(e, varMap,updated));
			}
			return exp;
		} else if(target instanceof edu.ustb.sei.mde.xmu2.expression.UnaryExpression) {
			edu.ustb.sei.mde.xmu2core.UnaryExpression exp = Xmu2coreFactory.eINSTANCE.createUnaryExpression();
			exp.setOperator(((edu.ustb.sei.mde.xmu2.expression.UnaryExpression) target).getOperator());
			
			exp.setBody(convertExpression(((edu.ustb.sei.mde.xmu2.expression.UnaryExpression) target).getBody(), varMap,updated));
			
			return exp;
		} else if(target instanceof edu.ustb.sei.mde.xmu2.expression.VariableExpression) {
			edu.ustb.sei.mde.xmu2core.VariableExpression exp = Xmu2coreFactory.eINSTANCE.createVariableExpression();
			
			String varName = ((edu.ustb.sei.mde.xmu2.expression.VariableExpression) target).getVariable();
			String ovn,pvn;
			
			ovn = AnalysisUtil.getNonUpdatedSourceVariableName(varName);
			pvn = AnalysisUtil.getUpdatedSourceVariableName(varName);
			
			Variable v = null;
			
			if(updated) {
				v = varMap.get(pvn);
				if(v==null) {
					v = varMap.get(ovn);
					if(v.getTag()==DomainTag.SOURCE)
						v = null;
				}
			} else {
				v = varMap.get(ovn);
			}
			
			if(v==null) {
				throw new BuildException("unregistered variable "+varName);
			} else
				exp.setVariable(v);
			
			return exp;
			
		} else if(target instanceof StringLiteralExpression) {
			StringValueExpression exp = Xmu2coreFactory.eINSTANCE.createStringValueExpression();
			exp.setValue(((StringLiteralExpression) target).getValue());
			exp.setType(EcorePackage.eINSTANCE.getEString());
			return exp;
		} else if(target instanceof IntegerLiteralExpression) {
			IntegerValueExpression exp = Xmu2coreFactory.eINSTANCE.createIntegerValueExpression();
			exp.setValue(((IntegerLiteralExpression) target).getValue());
			exp.setType(EcorePackage.eINSTANCE.getEInt());
			return exp;
		} else if(target instanceof BooleanLiteralExpression) {
			BooleanValueExpression exp = Xmu2coreFactory.eINSTANCE.createBooleanValueExpression();
			exp.setValue(((BooleanLiteralExpression) target).isValue());
			exp.setType(EcorePackage.eINSTANCE.getEBoolean());
			return exp;
		} else if(target instanceof EnumLiteralExpression) {
			EnumValueExpression exp = Xmu2coreFactory.eINSTANCE.createEnumValueExpression();
			exp.setValue(((EnumLiteralExpression) target).getValue());
			exp.setType(((EnumLiteralExpression) target).getType());
			return exp;
		} else if(target instanceof EmptyExpression) {
			EmptyValueExpression exp = Xmu2coreFactory.eINSTANCE.createEmptyValueExpression();
			
			if(((EmptyExpression) target).getType()==EmptyValueType.NULL_VALUE) {
				exp.setType(Xmu2corePackage.eINSTANCE.getNull());
			} else if(((EmptyExpression) target).getType()==EmptyValueType.EMPTY_VALUE){
				exp.setType(Xmu2corePackage.eINSTANCE.getUndefined());
			} else 
				throw new BuildException("unconverted empty expression");
			
			return exp;
		} else if(target instanceof ObjectURIExpression) {
			ObjectValueExpression exp = Xmu2coreFactory.eINSTANCE.createObjectValueExpression();
			exp.setValue(((ObjectURIExpression) target).getObject());
			return exp;
		} else if(target instanceof edu.ustb.sei.mde.xmu2.expression.ParenExpression) {
			edu.ustb.sei.mde.xmu2core.Expression exp = 
					convertExpression(((edu.ustb.sei.mde.xmu2.expression.ParenExpression) target).getBody(), varMap, updated);
			return exp;
		} else if(target instanceof PathExpression) {
			edu.ustb.sei.mde.xmu2core.AtomicExpression exp = (edu.ustb.sei.mde.xmu2core.AtomicExpression)convertExpression(((PathExpression) target).getHost(), varMap, updated);
			EClassifier type = inferType(exp);
			for(edu.ustb.sei.mde.xmu2.expression.Path p : ((PathExpression) target).getPath()) {
				exp.getPaths().add(convertPath(type, p, varMap, updated));
			}
			return exp;
		}
		
		throw new BuildException("unconverted expression "+target);
	}

	private EClassifier inferType(Expression host) {
		if(host instanceof edu.ustb.sei.mde.xmu2core.BooleanOrExpression ||
				host instanceof edu.ustb.sei.mde.xmu2core.BooleanAndExpression ||
				host instanceof edu.ustb.sei.mde.xmu2core.RelationalExpression)
			return EcorePackage.eINSTANCE.getEBoolean();
		else if(host instanceof edu.ustb.sei.mde.xmu2core.AdditiveExpression) {
			// int or string
			EList<Expression> operands = ((edu.ustb.sei.mde.xmu2core.AdditiveExpression) host).getOperands();
			return calculateLargestType(operands,true);
		} else if(host instanceof edu.ustb.sei.mde.xmu2core.MultiplicativeExpression) {
			// int or other (currently it should be int)
			EList<Expression> operands = ((edu.ustb.sei.mde.xmu2core.MultiplicativeExpression) host).getOperands();
			return calculateLargestType(operands,false);
			
		} else if(host instanceof edu.ustb.sei.mde.xmu2core.UnaryExpression) {
			if(((edu.ustb.sei.mde.xmu2core.UnaryExpression) host).getOperator()==UnaryOperator.NOT)
				return EcorePackage.eINSTANCE.getEBoolean();
			else {
				EClassifier type = inferType(((edu.ustb.sei.mde.xmu2core.UnaryExpression) host).getBody());
				if(type==EcorePackage.eINSTANCE.getEInt() || type==EcorePackage.eINSTANCE.getEIntegerObject())
					type = EcorePackage.eINSTANCE.getEInt();
				else type = null;
				
				return type;
			}
		} else if(host instanceof edu.ustb.sei.mde.xmu2core.TypeCastExpression) {
			EClassifier type = ((edu.ustb.sei.mde.xmu2core.TypeCastExpression) host).getTargetType();
			EClassifier pathType = inferPathType(type,((edu.ustb.sei.mde.xmu2core.TypeCastExpression) host).getPaths());
			return pathType;
//		} else if(host instanceof edu.ustb.sei.mde.xmu2core.ParenExpression) {
//			EClassifier type = inferType(((edu.ustb.sei.mde.xmu2core.ParenExpression) host).getBody());
//			EClassifier pathType = inferPathType(type,((edu.ustb.sei.mde.xmu2core.ParenExpression) host).getPaths());
//			return pathType;
		} else if(host instanceof edu.ustb.sei.mde.xmu2core.VariableExpression) {
			EClassifier type = ((edu.ustb.sei.mde.xmu2core.VariableExpression) host).getVariable().getType();
			EClassifier pathType = inferPathType(type,((edu.ustb.sei.mde.xmu2core.VariableExpression) host).getPaths());
			return pathType;
		} else if(host instanceof edu.ustb.sei.mde.xmu2core.PrimitiveValueExpression) {
			return ((edu.ustb.sei.mde.xmu2core.PrimitiveValueExpression) host).getType();
		} else if(host instanceof edu.ustb.sei.mde.xmu2core.ObjectValueExpression) {
			EClass type = ((edu.ustb.sei.mde.xmu2core.ObjectValueExpression) host).getValue().eClass();
			EClassifier pathType = inferPathType(type,((edu.ustb.sei.mde.xmu2core.ObjectValueExpression) host).getPaths());
			return pathType;
		}
		return null;
	}


	protected EClassifier calculateLargestType(EList<Expression> operands, boolean numberic) {
		List<EClassifier> types = new ArrayList<EClassifier>(operands.size());
		for(edu.ustb.sei.mde.xmu2core.Expression e : operands) {
			EClassifier t = inferType(e);
			if(t==null) 
				t = EcorePackage.eINSTANCE.getEJavaObject();
			types.add(t);
		}
		
		EClassifier largestType = null;
		for(EClassifier t : types) {
			if(largestType==null) {
				largestType = t;
				if(t!=EcorePackage.eINSTANCE.getEInt() 
						&& t!=EcorePackage.eINSTANCE.getEIntegerObject()
						&& t!=EcorePackage.eINSTANCE.getEString()
						&& t!=EcorePackage.eINSTANCE.getEJavaObject()) {
					throw new BuildException("type error in additive expression");
				}
				largestType = normalizePrimitiveType(largestType);
			}
			else {
				if(t == EcorePackage.eINSTANCE.getEInt() 
						|| t==EcorePackage.eINSTANCE.getEIntegerObject()) {
					
				} else if(t == EcorePackage.eINSTANCE.getEString()) {
					if(!numberic) 
						largestType = EcorePackage.eINSTANCE.getEString();
				} else if(t==EcorePackage.eINSTANCE.getEJavaObject()){
					if(!numberic) 
						largestType = EcorePackage.eINSTANCE.getEString();
				} else {
					throw new BuildException("type error in additive expression");
				}
				largestType = normalizePrimitiveType(largestType);
			}
		}
		
		return largestType;
	}
	
	
	private EClassifier normalizePrimitiveType(EClassifier largestType) {
		if(largestType == EcorePackage.eINSTANCE.getEIntegerObject())
			return EcorePackage.eINSTANCE.getEInt();
		
		if(largestType == EcorePackage.eINSTANCE.getEBooleanObject())
			return EcorePackage.eINSTANCE.getEBoolean();
		
		if(largestType == EcorePackage.eINSTANCE.getEDoubleObject())
			return EcorePackage.eINSTANCE.getEDouble();
		
		return largestType;
	}


	private Map<EClassifier, OclCollectionType> collectionMap = new HashMap<EClassifier, OclCollectionType>();
	private OclCollectionType getCollectionType(EClassifier elementType) {
		OclCollectionType type = collectionMap.get(elementType);
		if(type==null) {
			type = Xmu2coreFactory.eINSTANCE.createOclCollectionType();
			type.setElementtype(elementType);;
			collectionMap.put(elementType, type);
			transformation.getDeclaredTypes().add(type);
		}
		return type;
	}

	private EClassifier inferPathType(EClassifier type, EList<Path> paths) {
		EClassifier curType = type;
		for(Path p : paths) {
			if(p instanceof edu.ustb.sei.mde.xmu2core.FeaturePath) {
				if(((edu.ustb.sei.mde.xmu2core.FeaturePath) p).getFeature().isMany()) {
					curType = getCollectionType(((edu.ustb.sei.mde.xmu2core.FeaturePath) p).getFeature().getEType());
				} else {
					curType = ((edu.ustb.sei.mde.xmu2core.FeaturePath) p).getFeature().getEType();
				}
			} else if(p instanceof edu.ustb.sei.mde.xmu2core.LoopPath) {
				if(((edu.ustb.sei.mde.xmu2core.LoopPath) p).getOperator()==LoopOperator.FOR_ALL ||
						((edu.ustb.sei.mde.xmu2core.LoopPath) p).getOperator()==LoopOperator.EXISTS) {
					curType = EcorePackage.eINSTANCE.getEBoolean();
				} else {
					curType = getCollectionType(((edu.ustb.sei.mde.xmu2core.LoopPath) p).getIterator().getType());
				}
			} else if(p instanceof edu.ustb.sei.mde.xmu2core.PositionPath) {
				if(curType instanceof OclCollectionType) {
					curType = ((OclCollectionType) curType).getElementtype();
				} else {
					continue;
				}
			} else if(p instanceof edu.ustb.sei.mde.xmu2core.OperationPath) {
				curType = null;//cannot infer the return type of an operation
			}
		}
		return curType;
	}

	private Pattern convertPatternMatching(edu.ustb.sei.mde.xmu2.pattern.Pattern pattern,
			VarMapStack varMap) {
		edu.ustb.sei.mde.xmu2core.Pattern pat = Xmu2coreFactory.eINSTANCE.createPattern();
		pat.setRoot((PatternNode)convertPatternNodeMatching(pattern.getRoot(),varMap));
		pat.setGuard(convertExpression(pattern.getGuard(), varMap,false));
		return pat;
	}

	private EObject convertPatternNodeMatching(edu.ustb.sei.mde.xmu2.pattern.PatternNode node, VarMapStack varMap) {
		if(node.getVariable().getType() instanceof EDataType) {
			edu.ustb.sei.mde.xmu2core.VariableExpression ve = Xmu2coreFactory.eINSTANCE.createVariableExpression();
			Variable v = varMap.get(AnalysisUtil.getNonUpdatedSourceVariableName(node.getVariable().getName()));
			ve.setVariable(v);
			return ve;
		} else {
			edu.ustb.sei.mde.xmu2core.PatternNode n = Xmu2coreFactory.eINSTANCE.createPatternNode();
			Variable v = varMap.get(AnalysisUtil.getNonUpdatedSourceVariableName(node.getVariable().getName()));
			n.setVariable(v);
			n.setType((EClass)node.getVariable().getType());
			
			for(edu.ustb.sei.mde.xmu2.pattern.PatternExpression pe : node.getExpressions()) {
				n.getExpressions().add(convertPatternExpressionMatching(n,pe,varMap));
			}
			
			return n;
		}
		
		
	}

	private PatternExpression convertPatternExpressionMatching(edu.ustb.sei.mde.xmu2core.PatternNode n, 
			edu.ustb.sei.mde.xmu2.pattern.PatternExpression pe,
			VarMapStack varMap) {
		if(pe instanceof edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression) {
			EObject target = convertPatternNodeMatching(((edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression) pe).getTargetNode(), varMap);
			
			if(target instanceof edu.ustb.sei.mde.xmu2core.PatternNode) {
				edu.ustb.sei.mde.xmu2core.ObjectPatternExpression npe = Xmu2coreFactory.eINSTANCE.createObjectPatternExpression();				
				npe.setFeature(pe.getFeature());
				npe.setSelector((edu.ustb.sei.mde.xmu2core.LoopPath)convertPath(null,pe.getSelector(),varMap,false));
				npe.setPosition((edu.ustb.sei.mde.xmu2core.PositionPath)convertPath(null,pe.getPosition(),varMap,false));
				npe.setTarget((edu.ustb.sei.mde.xmu2core.PatternNode)target);
				return npe;
			} else if(target instanceof edu.ustb.sei.mde.xmu2core.VariableExpression){
				edu.ustb.sei.mde.xmu2core.PropertyPatternExpression npe = Xmu2coreFactory.eINSTANCE.createPropertyPatternExpression();
				npe.setFeature(pe.getFeature());
				npe.setSelector((edu.ustb.sei.mde.xmu2core.LoopPath)convertPath(null,pe.getSelector(),varMap,false));
				npe.setPosition((edu.ustb.sei.mde.xmu2core.PositionPath)convertPath(null,pe.getPosition(),varMap,false));
				npe.setTarget((edu.ustb.sei.mde.xmu2core.VariableExpression)target);
				return npe;
			}
		} else if(pe instanceof edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression) {
			edu.ustb.sei.mde.xmu2core.PropertyPatternExpression npe = Xmu2coreFactory.eINSTANCE.createPropertyPatternExpression();
			npe.setFeature(pe.getFeature());
			npe.setSelector((edu.ustb.sei.mde.xmu2core.LoopPath)convertPath(null,pe.getSelector(),varMap,false));
			npe.setPosition((edu.ustb.sei.mde.xmu2core.PositionPath)convertPath(null,pe.getPosition(),varMap,false));
			
			npe.setTarget(convertExpression(((edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression) pe).getTargetExpression(), varMap,false));
			return npe;
		}
		throw new BuildException("Unconverted pattern expression");
	}

	private edu.ustb.sei.mde.xmu2core.Path convertPath(EClassifier type, edu.ustb.sei.mde.xmu2.expression.Path path, VarMapStack varMap,boolean updated) {
		// TODO Auto-generated method stub
		if(path==null)
			return null;
		
		if(path instanceof edu.ustb.sei.mde.xmu2.expression.FeaturePath) {
			if(type instanceof EClass) {
				edu.ustb.sei.mde.xmu2core.FeaturePath fp = Xmu2coreFactory.eINSTANCE.createFeaturePath();
				EStructuralFeature feature = ((EClass) type).getEStructuralFeature(((edu.ustb.sei.mde.xmu2.expression.FeaturePath) path).getFeature());
				fp.setFeature(feature);
				return fp;
			} else {
				throw new BuildException("unconverted feature path");
			}
		} else if(path instanceof edu.ustb.sei.mde.xmu2.expression.LoopPath) {
			edu.ustb.sei.mde.xmu2core.LoopPath loop = Xmu2coreFactory.eINSTANCE.createLoopPath();
			loop.setOperator(((edu.ustb.sei.mde.xmu2.expression.LoopPath) path).getOperator());
			
			VariableDeclaration vd = ((edu.ustb.sei.mde.xmu2.expression.LoopPath) path).getVariable();
			checkNonUpdatedSourceVariableName(vd.getName());
			
			if(varMap.get(vd.getName())!=null)
				throw new BuildException("iterator variable name confliction "+vd.getName());
			
			Variable v = findOrCreateVariable(vd.getName(), varMap);
			v.setTag(DomainTag.NORMAL);
			v.setType(vd.getType());
			
			loop.setIterator(v);
			loop.setBody(convertExpression(((edu.ustb.sei.mde.xmu2.expression.LoopPath) path).getBody(), varMap,updated));
			varMap.remove(vd.getName());
			
			return loop;
		} else if(path instanceof edu.ustb.sei.mde.xmu2.expression.PositionPath) {
			edu.ustb.sei.mde.xmu2core.PositionPath position = Xmu2coreFactory.eINSTANCE.createPositionPath();
			position.setOperator(((edu.ustb.sei.mde.xmu2.expression.PositionPath) path).getType());
			
			position.setValue(convertExpression(((edu.ustb.sei.mde.xmu2.expression.PositionPath) path).getValue(), varMap,updated));
			
			return position;
			
		} else if(path instanceof edu.ustb.sei.mde.xmu2.expression.OperationPath) {
			edu.ustb.sei.mde.xmu2core.OperationPath operation = Xmu2coreFactory.eINSTANCE.createOperationPath();
			operation.setOperation(((edu.ustb.sei.mde.xmu2.expression.OperationPath) path).getOperation());
			for(edu.ustb.sei.mde.xmu2.expression.Expression pe : ((edu.ustb.sei.mde.xmu2.expression.OperationPath) path).getParameters()) {
				operation.getParameters().add(convertExpression(pe, varMap,false));//we cannot invoke operation against updated source
			}
			return operation;
		}
		
		throw new BuildException("unconverted feature path");
	}

	private void collectVariables(EObject obj, VarMapStack map) {
		if(obj==null) {
		} else if(obj instanceof ModelRule) {
			((ModelRule) obj).getParameters().forEach(i -> {collectVariables(i,map);});
			((ModelRule) obj).getVariableDeclarations().forEach(i->{collectVariables(i,map);});
			collectVariables(((ModelRule) obj).getStatement(), map);
		} else if(obj instanceof VariableDeclaration) {
			VariableDeclaration v = (VariableDeclaration)obj;
			edu.ustb.sei.mde.xmu2.pattern.Pattern pat = (edu.ustb.sei.mde.xmu2.pattern.Pattern)AnalysisUtil.getAncestor(v, PatternPackage.eINSTANCE.getPattern());
			if(pat==null || ! (pat.eContainer() instanceof EnforcePatternStatement)) {
				
				checkNonUpdatedSourceVariableName(v.getName());
				
				Variable var = findOrCreateVariable(v.getName(), map);
				setVariableType(var, v.getType());
				
				if(pat==null) {
					setVariableDomainTag(var, DomainTag.NORMAL);
				} else {
					if(pat.eContainer() instanceof UpdateStatement) {
						if(pat.eContainmentFeature() == StatementPackage.eINSTANCE.getUpdateStatement_Source()) {
							setVariableDomainTag(var, DomainTag.SOURCE);
						} else if(pat.eContainmentFeature() == StatementPackage.eINSTANCE.getUpdateStatement_View()) {
							setVariableDomainTag(var, DomainTag.VIEW);
						}
					} else if(pat.eContainer() instanceof edu.ustb.sei.mde.xmu2.statement.PatternCaseClause) {
						SwitchStatement stmt = (SwitchStatement)pat.eContainer().eContainer();
						Variable rv = map.get(stmt.getRoot().getVariable());
						setVariableDomainTag(var, rv.getTag());
					} else {
						throw new BuildException("Unknown variable source "+var.getName());
					}
				}
				
			} else {
				// variable in enforce pattern statement
				String n = v.getName();
				String pvn = AnalysisUtil.getUpdatedSourceVariableName(n);
				String ovn = AnalysisUtil.getNonUpdatedSourceVariableName(n);
				
				Variable ovar = findOrCreateVariable(ovn, map);
				setVariableType(ovar, v.getType());
				setVariableDomainTag(ovar, DomainTag.SOURCE);
				
				Variable var = findOrCreateVariable(pvn, map);
				setVariableType(var,v.getType()); // set type
				setVariableDomainTag(var, DomainTag.UPDATED_SOURCE);
			}
		} else if(obj instanceof Parameter) {
			Parameter p = (Parameter) obj;
			checkNonUpdatedSourceVariableName(p.getName());
			Variable var = findOrCreateVariable(p.getName(),map);
			setVariableType(var,p.getType());
			setVariableDomainTag(var, ((Parameter) obj).getTag());
		} else if(obj instanceof edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement) {
			edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement stmt = (edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement) obj;
			registerUpdatedVariableExpression(stmt.getNode(), map, obj);
		} else  if(obj instanceof edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement) {
			edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement stmt = (edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement) obj;
			registerUpdatedVariableExpression(stmt.getSource(), map, obj);
		} else if(obj instanceof edu.ustb.sei.mde.xmu2.expression.LoopPath) {
			return;// do not go inside
		} else {
			for(EObject o : obj.eContents()) {
				collectVariables(o, map);
			}
		}
	}
	
	protected static void checkNonUpdatedSourceVariableName(String name) {
		if(name.endsWith(POST))
			throw new BuildException("invalid variable name for non-updated-source variable: "+name);
		else return;
	}

	protected static void setVariableDomainTag(Variable var, DomainTag t) {
		if(var.getTag()==null) var.setTag(t);
		else {
			if(var.getTag()!=t)
				throw new BuildException("Variable domain tag exception "+var);
		}
	}

	protected static void registerUpdatedVariableExpression(edu.ustb.sei.mde.xmu2.expression.VariableExpression var, VarMapStack map, EObject current) {
		String varName = var.getVariable();
		String ov = null,pv = null;
		
		ov = AnalysisUtil.getNonUpdatedSourceVariableName(varName);
		pv = AnalysisUtil.getUpdatedSourceVariableName(varName);
		
		Variable ovv = map.get(ov);
		if(ovv==null) {
			throw new BuildException("cannot find the correlated variable of "+pv); 
		} else if(ovv.getTag()!=DomainTag.SOURCE) {
			throw new BuildException("the correlated variable of "+pv+" is not a source variable");
		}
		
		Variable pvv = findOrCreateVariable(pv, map);
		setVariableType(pvv, ovv.getType());
		setVariableDomainTag(pvv, DomainTag.UPDATED_SOURCE);
	}

	protected static Variable findOrCreateVariable(String pv, VarMapStack map) {
		Variable pvv = map.get(pv);
		if(pvv==null) {
			pvv = Xmu2coreFactory.eINSTANCE.createVariable();
			pvv.setName(pv);
			map.put(pv, pvv);
		}
		return pvv;
	}

	protected static void setVariableType(Variable v, EClassifier t) {
		if(v.getType()==null)
			v.setType(t);
	}
}

class VarMapStack {
	private List<Map<Variable,EClassifier>> stack = new ArrayList<Map<Variable,EClassifier>>();
	private Map<String,Variable> top = new HashMap<String,Variable>();
	
	VarMapStack() {
//		push();
	}
	
	public void registerVariable(Procedure p) {
		// TODO Auto-generated method stub
		for(Variable v : top.values()) {
			p.getVariables().add(v);
		}
	}

	public void push() {
		Map<Variable,EClassifier> n = new HashMap<Variable,EClassifier>();
		stack.add(n);
		top.forEach((k,v)->{
			n.put(v, v.getType());
		});
	}
	public void pop() {
		Map<Variable,EClassifier> n = stack.get(stack.size()-1);
		List<String> unusedKeys = new ArrayList<String>();
		
		top.forEach((k,v)->{
			EClassifier ot = n.get(v);
			if(ot!=null)
				v.setType(ot);
			else {
				unusedKeys.add(k);
			}
		});
		
		for(String k : unusedKeys) {
			top.remove(k);
		}
	}
	
	public Variable get(String k) {
		return top.get(k);
	}
	
	public void put(String k, Variable v) {
		top.put(k, v);
	}
	public void remove(String k) {
		top.remove(k);
	}
}
