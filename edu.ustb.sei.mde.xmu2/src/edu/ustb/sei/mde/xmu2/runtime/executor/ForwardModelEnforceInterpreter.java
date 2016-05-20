package edu.ustb.sei.mde.xmu2.runtime.executor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.mde.xmu2.runtime.build.SolverHelper;
import edu.ustb.sei.mde.xmu2.runtime.exceptions.InvalidBackwardEnforcementException;
import edu.ustb.sei.mde.xmu2.runtime.exceptions.InvalidCalculationException;
import edu.ustb.sei.mde.xmu2.runtime.exceptions.InvalidForwardEnforcementException;
import edu.ustb.sei.mde.xmu2.runtime.structures.Context;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;
import edu.ustb.sei.mde.xmu2.util.AnalysisUtil;
import edu.ustb.sei.mde.xmu2.util.Constants;
import edu.ustb.sei.mde.xmu2.util.ContextUtil;
import edu.ustb.sei.mde.xmu2.util.Tuple;
import edu.ustb.sei.mde.xmu2common.DomainTag;
import edu.ustb.sei.mde.xmu2core.AlignStatement;
import edu.ustb.sei.mde.xmu2core.CallStatement;
import edu.ustb.sei.mde.xmu2core.Callable;
import edu.ustb.sei.mde.xmu2core.CaseClause;
import edu.ustb.sei.mde.xmu2core.CaseExpressionClause;
import edu.ustb.sei.mde.xmu2core.CasePatternClause;
import edu.ustb.sei.mde.xmu2core.CaseStatement;
import edu.ustb.sei.mde.xmu2core.DeleteLinkStatement;
import edu.ustb.sei.mde.xmu2core.DeleteNodeStatement;
import edu.ustb.sei.mde.xmu2core.EnforceLinkStatement;
import edu.ustb.sei.mde.xmu2core.EnforceNodeStatement;
import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.ForEachStatement;
import edu.ustb.sei.mde.xmu2core.LoopPath;
import edu.ustb.sei.mde.xmu2core.Pattern;
import edu.ustb.sei.mde.xmu2core.PositionPath;
import edu.ustb.sei.mde.xmu2core.Procedure;
import edu.ustb.sei.mde.xmu2core.SolveConstraintStatement;
import edu.ustb.sei.mde.xmu2core.Function;
import edu.ustb.sei.mde.xmu2core.Statement;
import edu.ustb.sei.mde.xmu2core.Variable;

public class ForwardModelEnforceInterpreter extends ModelEnforceInterpreter {
	
	protected void mergeContext(Context outterContext, Context mergeContext) {
		{//write back to parameter
			Callable rule = outterContext.getCallable();
			for(Variable fp : rule.getParameters()) {
				if(fp.getTag()==DomainTag.VIEW || fp.getTag()==DomainTag.NORMAL) {
					SafeType val = mergeContext.get(fp);
					outterContext.put(fp, val);
				}
			}
		}
	}
	
	@Override
	public void executeAlignStatement(AlignStatement statement, Context context) {
		throw new InvalidForwardEnforcementException("in the forward direction, the alignment statement is invalid");
//		List<Context> smatches = ContextUtil.match(statement.getSource(), context);
//		
//		for(Context c : smatches) {
//			this.handleProcedureTrialCallStatements(this.collectRuleCallStatements(statement.getViewCreationStatements(),c),c);
//			ReorderedAlignStatement reorder = ReorderUtil.reorderAlignStatement(statement, c);
//			this.executeStatements(reorder.finalOrder, c);
//			mergeContext(context, c);
//		}
	}

	@Override
	public void executeForEachStatement(ForEachStatement statement, Context context) {
		List<Context> smatches = ContextUtil.match(statement.getPattern(), context);
		
		for(Context c : smatches) {
//			if(statement.isDerived()) {
				this.handleTrialCallStatements(this.collectProcedureCallStatements(statement.getAction(), c), c);
				ReorderedAlignStatement reorder = ReorderUtil.reorderForEachStatement(statement, c);
				
				boolean selected = false;
				for(ReorderedAlignBranch branch : reorder.branches) {
					Context nc = c.clone();
					boolean passed = true;
					for(Object prec : branch.precondition) {
						if(prec instanceof Statement) {
							try{
								this.executeStatement((Statement)prec, nc);
							} catch(Exception e) {
								passed = false;
								break;
							}
						} else if(prec instanceof Pattern) {//the branch should be deprecated
							try {
								SafeType ret = AbstractInterpreter.MODEL_CHECK.matchPattern((Pattern) prec, nc);
								if (ret != Constants.TRUE) {
									passed = false;
									break;
								}
							} catch (Exception e) {
								passed = false;
								break;
							}
						} else if(prec instanceof Expression) {
							try {//the branch should be deprecated
								SafeType ret = AbstractInterpreter.MODEL_CHECK.executeExpression((Expression) prec, nc);
								if (ret != Constants.TRUE) {
									passed = false;
									break;
								}
							} catch (Exception e) {
								passed = false;
								break;
							}
						} else {
							throw new InvalidForwardEnforcementException("unknown condition type "+prec.getClass());
						}
					}
					
					if(passed) {
						selected = true;
						
						if(branch.finalOrder==null) {
							branch.finalOrder = new ArrayList<Statement>();
							branch.finalOrder.addAll(branch.match);
							branch.finalOrder.addAll(branch.enforce);
							branch.finalOrder.addAll(branch.lazy);
							branch.finalOrder.addAll(branch.tail);
						}
						
						this.handleTrialCallStatements(this.collectProcedureCallStatements(branch.finalOrder, nc), nc);
						
						for(Statement action : branch.finalOrder) {
							if(action instanceof Statement) {
								this.executeStatement((Statement)action, nc);
								
							} 
//							else if(action instanceof Expression) {
//								SafeType ret = this.executeExpression((Expression)action, nc);
//								if(ret!=Constants.TRUE) {
//									throw new InvalidForwardEnforcementException("cannot enforce expressions in case statement");
//								}
//							} else {
//								throw new InvalidForwardEnforcementException("unknown action type "+action.getClass());
//							}
						}
						
//						for(Statement post : rcc.postCondition) {
//							this.executeStatement(post, nc);
//						}
						
						ContextUtil.merge(c, nc);
						
						break;
					}
					
					
				}
				
				if(!selected) {
					throw new InvalidForwardEnforcementException("cannot select a branch from the align statement");
				}
				
//				this.executeStatements(reorder.finalOrder, c);
//			} else {
//				this.executeStatements(statement.getAction(), c);
//			}
			mergeContext(context, c);
		}
	}

	@Override
	public void executeCallStatement(CallStatement ruleCallStatement, Context context) {
		Callable rule = ruleCallStatement.getCallable();
		
		if (rule instanceof Procedure) {
			List<Object> parameterList = new ArrayList<Object>();
			int size = rule.getParameters().size();

			Context newContext = new Context(context.getEnvironment());
			newContext.setCallable(rule);
			newContext.initFromCallable(rule);

			for (int i = 0; i < size; i++) {
				Variable fp = rule.getParameters().get(i);
				Expression ap = ruleCallStatement.getParameters().get(i);

				SafeType value = this.executeExpression(ap, context);

				if (value.isUndefined() && fp.getTag() != DomainTag.VIEW)
					throw new InvalidBackwardEnforcementException(
							"invalid parameter of rule call in forward transformation");

				newContext.put(fp, value);

				if (fp.getTag() == DomainTag.SOURCE || fp.getTag() == DomainTag.NORMAL)
					parameterList.add(value.getValue());

				if (fp.getTag() == DomainTag.SOURCE) {
					Variable fspv = newContext.getVariable(AnalysisUtil.getUpdatedSourceVariableName(fp.getName()));
					// invariant: fspv = fp
					newContext.put(fspv, value);
				}

			}

			Tuple ret = context.getEnvironment().getTrace(((Procedure)rule), parameterList);

			if (ret != null) {
				// write back
				for (int i = 0, j = 0; i < size; i++) {
					Variable fp = rule.getParameters().get(i);
					Expression uap = ruleCallStatement.getUpdatedParameters().get(i);

					if (fp.getTag() == DomainTag.VIEW) {

						Object obj = ret.get(j);
						j++;

						if (!this.enforceExpression(uap, context, SafeType.createFromValue(obj)))
							throw new InvalidBackwardEnforcementException("cannot putback view parameters");
					}
				}
				return;

			} else {
				this.executeStatements(((Procedure)rule).getForwardStatements(), newContext);

				List<Object> viewList = new ArrayList<Object>();
				// write back
				for (int i = 0; i < size; i++) {
					Variable fp = rule.getParameters().get(i);
					// Expression uap =
					// ruleCallStatement.getUpdatedParameters().get(i);

					if (fp.getTag() == DomainTag.VIEW) {
						SafeType spv = newContext.get(fp);

						// if(this.enforceExpression(uap, context, spv)==false)
						// throw new InvalidBackwardEnforcementException("cannot
						// putback updated source parameters");

						viewList.add(spv.getValue());
					}
				}

				// record trace
				context.getEnvironment().putTrace(((Procedure)rule), parameterList, viewList);

				return;
			}
		} else if (rule instanceof Function) {
			int size = rule.getParameters().size();

			Context newContext = new Context(context.getEnvironment());
			newContext.setCallable(rule);
			newContext.initFromCallable(rule);

			for (int i = 0; i < size; i++) {
				Variable fp = rule.getParameters().get(i);
				Expression ap = ruleCallStatement.getParameters().get(i);

				SafeType value = this.executeExpression(ap, context);

				if (value.isUndefined() && fp.getTag() != DomainTag.VIEW)
					throw new InvalidBackwardEnforcementException(
							"invalid parameter of rule call in forward transformation");

				newContext.put(fp, value);

				if (fp.getTag() == DomainTag.SOURCE) {
					Variable fspv = newContext.getVariable(AnalysisUtil.getUpdatedSourceVariableName(fp.getName()));
					newContext.put(fspv, value);
				}
			}
			
			this.executeStatements(((Function)rule).getForwardStatements(), newContext);

			// write back
			for (int i = 0; i < size; i++) {
				Variable fp = rule.getParameters().get(i);
				Expression uap = ruleCallStatement.getUpdatedParameters().get(i);

				if (fp.getTag() == DomainTag.VIEW) {
					SafeType spv = newContext.get(fp);

					if (!this.enforceExpression(uap, context, spv))
						throw new InvalidBackwardEnforcementException("cannot putback view parameters");
				}
			}
		}
	}

	@Override
	public void executeDeleteNodeStatement(DeleteNodeStatement statement, Context context) {
		Variable v = statement.getTarget();
		SafeType value = context.get(v);
		if(value.isUndefined() || value.isNull() || value.isUndefined()) {
			context.put(v, SafeType.UNDEFINED);//should it be null?
			return;
		} else {
			throw new InvalidForwardEnforcementException("trying to delete a non-empty variable");
		}
	}

	@Override
	public void executeDeleteLinkStatement(DeleteLinkStatement statement, Context context) {
		Variable src = statement.getSource();
		Expression tar = statement.getTarget();
		EStructuralFeature f = statement.getFeature();
		
		try {
			if(statement.isReflective()) {
				SafeType hostObj = context.get(src);
				SafeType expectedFeature = this.resolveReflectiveFeature(hostObj.getObjectValue().eClass(), statement, context);
				f = (EStructuralFeature) expectedFeature.getValue();
			}
		} catch(Exception e) {
			throw new InvalidForwardEnforcementException("cannot delete link because of the unresolved feature", e);
		}
		
		EObject sourcePost = context.get(src).getObjectValue();		
		SafeType value = this.executeExpression(tar, context);
		
		if(sourcePost == null || value.isNull() || value.isUndefined()) 
			return;
		
		if(context.getEnvironment().containFeature(sourcePost, f, value.getValue())==false) 
			return;
		
		throw new InvalidForwardEnforcementException("trying to delete an existing link");
	}
	
	

	@Override
	public void executeEnforceNodeStatement(EnforceNodeStatement statement, Context context) {
		if(statement.getTag()==DomainTag.UPDATED_SOURCE) {
			executeEnforceSourceNodeStatement(statement, context);
		} else {
			this.executeEnforceViewNodeStatement(statement, context);
		}
	}

	@Deprecated
	protected void executeEnforceSourceNodeStatement(EnforceNodeStatement statement, Context context) {
		Variable node = statement.getNode();
		EClass type = (EClass)statement.getType();
		SafeType value = context.get(node);
		
		if(value.isUndefined()) 
			throw new InvalidForwardEnforcementException("the source element does not exist");
		else {
			EObject o = value.getObjectValue();
			if(AnalysisUtil.isSuperTypeOf(type, o.eClass()))
				return;
			else
				throw new InvalidForwardEnforcementException("the source element does not match the type constraint");
		}
	}

	@Override
	public void executeEnforceLinkStatement(EnforceLinkStatement statement, Context context) {
		if(statement.getTag()==DomainTag.UPDATED_SOURCE) {
			executeEnforceSourceLinkStatement(statement, context);
		} else {
			this.executeEnforceViewLinkStatement(statement, context);;
		}
	}

	@Deprecated
	protected void executeEnforceSourceLinkStatement(EnforceLinkStatement statement, Context context) {
		Variable source = statement.getSource();
		EStructuralFeature feature = statement.getFeature();
		LoopPath selector = statement.getSelector();
		PositionPath position = statement.getPosition();
		Expression target = statement.getTarget();
		
		
		
		if(AbstractInterpreter.MODEL_CHECK.enforceLink(source, feature, selector, position, target, context))
			return;
		else 
			throw new InvalidForwardEnforcementException("cannot enforce source link");
	}

	protected void executeEnforceViewNodeStatement(EnforceNodeStatement statement, Context context) {
		Variable node = statement.getNode();
		EClass type = (EClass)statement.getType();
		
		try {
			if(statement.isReflective()) {
				SafeType expectedType = this.resolveReflectiveClassifier(statement, context);
				type = (EClass) expectedType.getValue();
			}
		} catch(Exception e) {
			throw new InvalidForwardEnforcementException("cannot enforce link because of the unresolved type", e);
		}
		
		Expression candidate = statement.getCandidate();

		SafeType oldValue = context.get(node);
		SafeType newValue = null;
		SafeType candidateValue = null;
		
		// oldValue		candidateValue	nullable	=> newValue
		// undefined	undef/null		-			=> new object
		// undefined	object			-			=> object
		// null			-				true		=> null
		// null			-				false		=> exception
		// object		-				-			=> object or new object
		
		if(oldValue.isUndefined()) {
			try {
				if (candidate != null) {
					candidateValue = this.executeExpression(candidate, context);
					
					// I uncomment the following two lines, but I cannot
					// remember why I comment them
					if (!candidateValue.isNull() && !candidateValue.isUndefined()) {
						// to support reflective API, I have to check whether
						// value is a list
						Object value = candidateValue.getValue();
						if (value != null && value instanceof List<?>) {
							candidateValue = SafeType.UNDEFINED;
						}
					}
				}
			} catch (Exception e) {
				candidateValue = SafeType.UNDEFINED;
			}
		}
		
		boolean createNew = false;
		
		if(oldValue.isUndefined()) {
			if(candidateValue==null || candidateValue.isUndefined() || candidateValue.isNull())
				createNew = true;
			else {
				if(!AnalysisUtil.isSuperTypeOf(type, candidateValue.getObjectValue().eClass()))
					throw new InvalidForwardEnforcementException("cannot replace a view element");
				else
					newValue = candidateValue;
			}
		} else if(oldValue.isNull()) {
			if(statement.isNullable())
				newValue = SafeType.NULL;
			else 
				throw new InvalidForwardEnforcementException("cannot create a view element from null");
		} else {
			if(!AnalysisUtil.isSuperTypeOf(type, oldValue.getObjectValue().eClass()))
				throw new InvalidForwardEnforcementException("cannot replace a view element");
			else newValue = oldValue;
		}
		
		if(createNew) {
			newValue = SafeType.createFromValue(this.createViewElement(type, context));
		} else {
			if(!newValue.isNull())
				context.getEnvironment().markAsUsed(newValue.getObjectValue());
		}
		
		context.put(node, newValue);
		
		return;
	}

	private Object createViewElement(EClass type, Context context) {
		if(type.isAbstract()) {
			throw new InvalidForwardEnforcementException("cannot create an instance of an abstract type");
		} else {
			return context.getEnvironment().createObject(type);
		}
	}

	protected void executeEnforceViewLinkStatement(EnforceLinkStatement statement, Context context) {
		Variable source = statement.getSource();
		EStructuralFeature feature = statement.getFeature();
		LoopPath selector = statement.getSelector();
		PositionPath position = statement.getPosition();
		Expression target = statement.getTarget();
		
		try {
			if(statement.isReflective()) {
				SafeType hostObj = context.get(source);
				SafeType expectedFeature = this.resolveReflectiveFeature(hostObj.getObjectValue().eClass(), statement, context);
				feature = (EStructuralFeature) expectedFeature.getValue();
			}
		} catch(Exception e) {
			throw new InvalidForwardEnforcementException("cannot enforce link because of the unresolved feature", e);
		}
		
		if(this.enforceLink(source, feature, selector, position, target, context))
			return;
		else 
			throw new InvalidForwardEnforcementException("cannot enforce view link");
	}

	@Override
	protected boolean isEnforceableVariable(Variable v) {
		return v.getTag()==DomainTag.NORMAL || v.getTag()==DomainTag.VIEW;
	}

	protected void handleTrialCallStatements(List<CallStatement> collectRuleCallStatements, Context context) {
		for(CallStatement u : collectRuleCallStatements) {
			this.trialRuleCall(u, context);
		}
	}
	
	private void trialRuleCall(CallStatement ruleCallStatement, Context context) {
		try {
			List<Object> parameterList = new ArrayList<Object>();
			Callable rule = ruleCallStatement.getCallable();

			if (rule instanceof Procedure) {

				int size = rule.getParameters().size();

				for (int i = 0; i < size; i++) {
					Variable fp = ruleCallStatement.getCallable().getParameters().get(i);
					if (fp.getTag() == DomainTag.SOURCE || fp.getTag() == DomainTag.NORMAL) {
						Expression ap = ruleCallStatement.getParameters().get(i);
						try {
							SafeType value = this.executeExpression(ap, context);
							if (value.isUndefined()) 
								return;
							parameterList.add(value.getValue());
						} catch (Exception e) {
							return;
						}
					}
				}

				Tuple ret = context.getEnvironment().getTrace(((Procedure)rule), parameterList);

				if (ret != null) {
					// write back
					for (int i = 0, j = 0; i < size; i++) {
						Variable fp = rule.getParameters().get(i);
						Expression uap = ruleCallStatement.getUpdatedParameters().get(i);

						if (fp.getTag() == DomainTag.VIEW) {
							Object obj = ret.get(j);
							j++;

							if (!this.enforceExpression(uap, context, SafeType.createFromValue(obj)))
								return;
						}
					}
					return;
				} else
					return;
			} else if (rule instanceof Function) {

			}
		} catch (Exception e) {
		}
	}
	
	@Override
	public void executeCaseStatement(CaseStatement statement, Context context) {
		if(statement.getTag()==DomainTag.NORMAL
				||statement.getTag()==DomainTag.SOURCE) {
			for(CaseClause css : statement.getClauses()) {//copy context for each iteration and merge at last
				if(css instanceof CasePatternClause) {
					SafeType c = this.checkPattern(((CasePatternClause) css).getCondition(), context);
					// FIXME
					// if there is a unique match, the action can modify the match
					// otherwise, the action should not modify.
					// currently, I cannot check this. 
					
					if(c.getValue()==Boolean.TRUE) {
//						List<Variable> sVars = ContextUtil.collectPatternVariables(((CasePatternClause) css).getCondition());
//						if(sVars.size()!=0) {
//						}
						
						handleTrialCallStatements(this.collectProcedureCallStatements(css.getAction(),context), context);
						this.executeStatements(css.getAction(), context);
						return;
					}
				} else if(css instanceof CaseExpressionClause) {
					SafeType c = this.executeExpression(((CaseExpressionClause) css).getCondition(), context);
					if(c.getValue()==Boolean.TRUE) {
						handleTrialCallStatements(this.collectProcedureCallStatements(css.getAction(),context), context);
						this.executeStatements(css.getAction(), context);
						return;
					}
				}
			}
			throw new InvalidBackwardEnforcementException("no branch can be triggered in switch statement");
		} else {
			/*
			 * C1 -> A1
			 * C2 -> A2
			 * 
			 * it is impossible that C1 and A1 and A2, so we can use A1/A2 to select C1/C2
			 */
			ReorderedCaseStatement reorder = ReorderUtil.reorderCaseStatement(statement, context);
			
			boolean selected = false;
			
			for(ReorderedCaseBranch rcc : reorder.branches) {
				Context nc = context.clone();
				boolean passed = true;
				for(Object prec : rcc.preCondition) {
					if(prec instanceof Statement) {
						try{
							this.executeStatement((Statement)prec, nc);
						} catch(Exception e) {
							passed = false;
							break;
						}
					} else if(prec instanceof Pattern) {//the branch should be deprecated
						try {
							SafeType ret = AbstractInterpreter.MODEL_CHECK.matchPattern((Pattern) prec, nc);
							if (ret != Constants.TRUE) {
								passed = false;
								break;
							}
						} catch (Exception e) {
							passed = false;
							break;
						}
					} else if(prec instanceof Expression) {
						try {//the branch should be deprecated
							SafeType ret = AbstractInterpreter.MODEL_CHECK.executeExpression((Expression) prec, nc);
							if (ret != Constants.TRUE) {
								passed = false;
								break;
							}
						} catch (Exception e) {
							passed = false;
							break;
						}
					} else {
						throw new InvalidForwardEnforcementException("unknown condition type "+prec.getClass());
					}
				}
				
				if(passed) {
					selected = true;
					this.handleTrialCallStatements(this.collectProcedureCallStatements(rcc.action, nc), nc);
					
					for(Object action : rcc.action) {
						if(action instanceof Statement) {
							this.executeStatement((Statement)action, nc);
							
						} else if(action instanceof Expression) {
							SafeType ret = this.executeExpression((Expression)action, nc);
							if(ret!=Constants.TRUE) {
								throw new InvalidForwardEnforcementException("cannot enforce expressions in case statement");
							}
						} else {
							throw new InvalidForwardEnforcementException("unknown action type "+action.getClass());
						}
					}
					
					for(Statement post : rcc.postCondition) {
						this.executeStatement(post, nc);
					}
					
					ContextUtil.merge(context, nc);
					
					break;
				}
			}
			
			if(selected == false) {
				throw new InvalidForwardEnforcementException("cannot select a branch from the case statement");
			}
			return;
		}
	}
	
	

	@Override
	public void executeSolveConstraintStatement(SolveConstraintStatement statement, Context context) {
		Expression e = statement.getConstraint();
		
		
		
		boolean enforceExpression = true;
		
		try {
			this.enforceExpression(e, context, Constants.TRUE);
		} catch(Exception exp) {
			enforceExpression = false;
		}
		
		if(enforceExpression==false) {
			SolverHelper.executeSolveConstraintStatement(statement, context);
		}
	}
	
	

	
//	private boolean isAllCheckable(CaseStatement statement, List<Variable> enforcedVariables) {
//		for(CaseClause cc : statement.getClauses()) {
//			if(cc instanceof CasePatternClause) {
//				if(this.isCheckable(((CasePatternClause) cc).getCondition(), enforcedVariables)==false)
//					return false;
//			} else if(cc instanceof CaseExpressionClause) {
//				if(this.checkExpressionExecutable(((CaseExpressionClause) cc).getCondition(), enforcedVariables)==false)
//					return false;
//			}
//		}
//		return true;
//	}
//	
//	private boolean isCheckable(Pattern pattern, List<Variable> enforcedVariables) {
//		return isCheckable(pattern.getRoot(), enforcedVariables);
//	}
//	
//	private boolean isCheckable(PatternNode node, List<Variable> enforcedVariables) {
//		if(enforcedVariables.contains(node.getVariable())) {
//			for(PatternExpression e : node.getExpressions()) {
//				if(e instanceof ObjectPatternExpression) {
//					if(isCheckable(((ObjectPatternExpression) e).getTarget(), enforcedVariables)==false)
//						return false;
//				} else if(e instanceof PropertyPatternExpression) {
//					if(this.checkExpressionExecutable(((PropertyPatternExpression) e).getTarget(), enforcedVariables)==false)
//						return false;
//				}
//			}
//			return true;
//		} else
//			return false;
//	}

}
