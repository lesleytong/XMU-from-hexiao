package edu.ustb.sei.mde.xmu2.runtime.executor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.mde.xmu2.runtime.exceptions.InvalidBackwardEnforcementException;
import edu.ustb.sei.mde.xmu2.runtime.exceptions.InvalidCalculationException;
import edu.ustb.sei.mde.xmu2.runtime.structures.Context;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;
import edu.ustb.sei.mde.xmu2.util.Constants;
import edu.ustb.sei.mde.xmu2core.AtomicExpression;
import edu.ustb.sei.mde.xmu2core.EmptyValueExpression;
import edu.ustb.sei.mde.xmu2core.EnforceExpressionStatement;
import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.FeaturePath;
import edu.ustb.sei.mde.xmu2core.LoopPath;
import edu.ustb.sei.mde.xmu2core.Path;
import edu.ustb.sei.mde.xmu2core.PositionPath;
import edu.ustb.sei.mde.xmu2core.ProcedureCallStatement;
import edu.ustb.sei.mde.xmu2core.Variable;
import edu.ustb.sei.mde.xmu2core.VariableExpression;


abstract public class ModelEnforceInterpreter extends ModelCheckInterpreter {
	
	
	@Override
	public void executeEnforceExpressionStatement(EnforceExpressionStatement o, Context context) {
		if(this.enforceExpression(o.getExpression(), context, Constants.TRUE)==false)
			throw new InvalidCalculationException("cannot enforce the expression");
	}

	@Override
	protected boolean enforceAtomicExpression(AtomicExpression invalid, Context context,
			SafeType expect) {
		if(invalid instanceof VariableExpression) {
			VariableExpression exp = (VariableExpression)invalid;
			
			if(this.isEnforceableVariable(exp.getVariable())==false)
				return false;
			
			if(((VariableExpression) invalid).getVariable().getType() instanceof EClass && exp.getPaths().size()==1) {
				SafeType hostObject = context.get(exp.getVariable());
				if(hostObject.isNull() || hostObject.isUndefined()) 
					return false;
				
				Path path = exp.getPaths().get(0);
				if(path instanceof FeaturePath) {
					EStructuralFeature feature  = ((FeaturePath) path).getFeature();
					if(feature!=null) {
						context.getEnvironment().setFeature(hostObject.getObjectValue(), feature, expect.getValue());
						return true;
					} else 
						return false;
				} else 
					return false;
			}
		} 

		return super.enforceAtomicExpression(invalid, context, expect);
	}
	
	abstract protected boolean isEnforceableVariable(Variable v);


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
			
			SafeType host = context.get(source);
			
			List<Object> list = context.getEnvironment().getFeatureAsFeatureList(host.getObjectValue(), feature);
			
			if(loop!=null) {
				list = (List<Object>) this.handleLoopPath(list, loop, context).getValue();
			}
			
			SafeType val = this.executeExpression(target, context);
			
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
							throw new InvalidBackwardEnforcementException("cannot nil a list");
					}
				} else {
					context.getEnvironment().setFeature(host.getObjectValue(), feature, val.getValue());
					return true;				
				}
			} else {
				SafeType posVal = this.calculatePositionPath(position, context);
				
				if(val.isUndefined())
					throw new InvalidCalculationException("cannot enforce property pattern expression");
				
				if(val.isNull()) {
					if(posVal.isInteger()) {
						list.remove(posVal.getValue());
						return true;
					} else {
						throw new InvalidBackwardEnforcementException("cannot nil an unknown position");
					}
				} else {
					if(posVal.isInteger()) {
						if(posVal.getIntegerValue()>=list.size())
							list.add(val.getValue());
						else
							list.set(posVal.getIntegerValue(), val.getValue());
						return true;
					} else {
						throw new InvalidCalculationException("invalid position");
					}
				}
			}
		} else
			return true;
	}

	protected List<ProcedureCallStatement> collectRuleCallStatements(List<? extends Object> action, Context context) {
		List<ProcedureCallStatement> calls = context.getEnvironment().getFromProcedureCallCache(action);
		if(calls==null) {
			calls = new ArrayList<ProcedureCallStatement>();
			for(Object s : action) {
				if(s instanceof ProcedureCallStatement)
					calls.add((ProcedureCallStatement)s);
			}
			context.getEnvironment().putIntoProcedureCallCache(action, calls);
		}
		return calls;
	}
}
