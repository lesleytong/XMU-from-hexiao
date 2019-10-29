package edu.ustb.sei.mde.xmu2.runtime.executor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.mde.xmu2.runtime.exceptions.InvalidCalculationException;
import edu.ustb.sei.mde.xmu2.runtime.structures.Context;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;
import edu.ustb.sei.mde.xmu2.util.Constants;
import edu.ustb.sei.mde.xmu2common.PositionOperator;
import edu.ustb.sei.mde.xmu2core.CallStatement;
import edu.ustb.sei.mde.xmu2core.EmptyValueExpression;
import edu.ustb.sei.mde.xmu2core.EnforceExpressionStatement;
import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.Function;
import edu.ustb.sei.mde.xmu2core.LoopPath;
import edu.ustb.sei.mde.xmu2core.PositionPath;
import edu.ustb.sei.mde.xmu2core.Procedure;
import edu.ustb.sei.mde.xmu2core.Variable;


abstract public class ModelEnforceInterpreter extends ModelCheckInterpreter {
	
	
	@Override
	public void executeEnforceExpressionStatement(EnforceExpressionStatement o, Context context) {
		if(this.enforceExpression(o.getExpression(), context, Constants.TRUE)==false)
			throw new InvalidCalculationException("cannot enforce the expression");
	}

	
	abstract protected boolean isEnforceableVariable(Variable v);

	protected boolean enforceFeatureSelector(SafeType host, EStructuralFeature feature, LoopPath loop, PositionPath position, SafeType val, Context context) {
		try {
			List<Object> list = context.getEnvironment().getFeatureAsFeatureList(host.getObjectValue(), feature);

			if (loop != null) {
				list = (List<Object>) this.handleLoopPath(list, loop, context).getValue();
			}

			if (position == null) {
				if (val.isUndefined())
					return false;

				if (list.contains(val.getValue())) {
					return true;
				} else {
					if (val.isNull()) {
						list.clear();
						return true;
					} else {
						context.getEnvironment().setFeature(host.getObjectValue(), feature, val.getValue());
						return true;
					}
				}
			} else {
				SafeType posVal = this.calculatePositionPath(position, context);

				if (val.isUndefined())
					return false;

				if (posVal.isUndefined()) {
					int idx = list.indexOf(val.getValue());

					if (idx >= 0) {
						if (position.getOperator() != PositionOperator.AT) {
							return false;
						}

						if (this.enforceExpression(position.getValue(), context, SafeType.createFromValue(idx)))
							return true;
						else
							return false;
					} else
						// insert val into list
						return false;
				} else {
					if (posVal.isNull())
						return false;

					if (!posVal.isInteger())
						return false;

					// FIXME list[id] = val
					if (list.contains(val.getValue()))
						return true;
					else {
						if (val.isNull()) {
							if (posVal.isInteger()) {
								list.remove((int) posVal.getIntegerValue());
								return true;
							} else {
								return false;
							}
						} else {
							if (posVal.isInteger()) {
								if (posVal.getIntegerValue() >= list.size())
									list.add(val.getValue());
								else
									list.set(posVal.getIntegerValue(), val.getValue());
								return true;
							} else {
								return false;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	protected boolean enforceLink(Variable source, EStructuralFeature feature, LoopPath loop, PositionPath position,
			Expression target, Context context) {
		boolean enforceVar = false;
		
		try {
			// try to enforce target expression and the position
			enforceVar = AbstractInterpreter.MODEL_CHECK.enforceLink(source, feature, loop, position, target, context);
			
		} catch(Exception e) {
			enforceVar = false;
		}
		
		if(enforceVar==false) {
			// try to enforce obj.ref
			// pos==null || pos != invalid
			SafeType val = this.executeExpression(target, context);
			
			SafeType host = context.get(source);
			
			List<Object> list = context.getEnvironment().getFeatureAsFeatureList(host.getObjectValue(), feature);
			
			if(loop!=null) {
				list = (List<Object>) this.handleLoopPath(list, loop, context).getValue();
			}
			
			
			if(position==null) {
				if(val.isUndefined())
					throw new InvalidCalculationException("cannot enforce property pattern expression");
				
				
				if(val.isNull()) {
					if(!feature.isMany()) {
						list.clear();
						return true;
					} else {
						if(target instanceof EmptyValueExpression) {
							list.clear();
							return true;
						} else
							throw new InvalidCalculationException("cannot nil a list");
					}
				} else {
					context.getEnvironment().setFeature(host.getObjectValue(), feature, val.getValue());
					return true;				
				}
			} else {
				SafeType posVal = this.calculatePositionPath(position, context);
				
				if(val.isUndefined())
					return false;
				
				if(val.isNull()) {
					if(posVal.isInteger()) {
						list.remove((int)posVal.getIntegerValue());
						return true;
					} else {
						return false;
					}
				} else {
					if(posVal.isInteger()) {
						if(posVal.getIntegerValue()>=list.size())
							list.add(val.getValue());
						else
							list.set(posVal.getIntegerValue(), val.getValue());
						return true;
					} else {
						return false;
					}
				}
			}
		} else
			return true;
	}
	
	protected List<CallStatement> collectFunctionCallStatements(List<? extends Object> action, Context context) {
		List<CallStatement> calls = context.getEnvironment().getFromProcedureCallCache(action);
		if(calls==null) {
			calls = new ArrayList<CallStatement>();
			for(Object s : action) {
				if(s instanceof CallStatement && ((CallStatement) s).getCallable() instanceof Function)
					calls.add((CallStatement)s);
			}
			context.getEnvironment().putIntoProcedureCallCache(action, calls);
		}
		return calls;
	}

	protected List<CallStatement> collectProcedureCallStatements(List<? extends Object> action, Context context) {
		List<CallStatement> calls = context.getEnvironment().getFromProcedureCallCache(action);
		if(calls==null) {
			calls = new ArrayList<CallStatement>();
			for(Object s : action) {
				if(s instanceof CallStatement && ((CallStatement) s).getCallable() instanceof Procedure)
					calls.add((CallStatement)s);
			}
			context.getEnvironment().putIntoProcedureCallCache(action, calls);
		}
		return calls;
	}
	
	protected List<CallStatement> collectCallStatements(List<? extends Object> action, Context context) {
		List<CallStatement> calls = context.getEnvironment().getFromProcedureCallCache(action);
		if(calls==null) {
			calls = new ArrayList<CallStatement>();
			for(Object s : action) {
				if(s instanceof CallStatement)
					calls.add((CallStatement)s);
			}
			context.getEnvironment().putIntoProcedureCallCache(action, calls);
		}
		return calls;
	}
}
