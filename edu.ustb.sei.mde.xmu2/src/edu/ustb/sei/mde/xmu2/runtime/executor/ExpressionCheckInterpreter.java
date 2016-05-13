package edu.ustb.sei.mde.xmu2.runtime.executor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ustb.sei.mde.xmu2.runtime.exceptions.*;
import edu.ustb.sei.mde.xmu2.runtime.structures.Context;
import edu.ustb.sei.mde.xmu2.runtime.values.ModelList;
import edu.ustb.sei.mde.xmu2.runtime.values.FeatureSelectionList;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;
import edu.ustb.sei.mde.xmu2.util.Constants;
import edu.ustb.sei.mde.xmu2.util.EvaluationUtil;
import edu.ustb.sei.mde.xmu2core.*;
import edu.ustb.sei.mde.xmu2common.*;

public class ExpressionCheckInterpreter extends AbstractInterpreter {

	@Override
	public void executeAlignStatement(AlignStatement statement, Context context) {
		throw new InvalidCalculationException("unsupported execution");
	}

	@Override
	public void executeCaseStatement(CaseStatement statement, Context context) {
		throw new InvalidCalculationException("unsupported execution");	}

	@Override
	public void executeCallStatement(CallStatement statement, Context context) {
		throw new InvalidCalculationException("unsupported execution");	}

	@Override
	public void executeForEachStatement(ForEachStatement statement, Context context) {
		throw new InvalidCalculationException("unsupported execution");	}

	@Override
	public void executeDeleteNodeStatement(DeleteNodeStatement statement, Context context) {
		throw new InvalidCalculationException("unsupported execution");	}

	@Override
	public void executeDeleteLinkStatement(DeleteLinkStatement statement, Context context) {
		throw new InvalidCalculationException("unsupported execution");	}

	@Override
	public void executeEnforceNodeStatement(EnforceNodeStatement statement, Context context) {
		throw new InvalidCalculationException("unsupported execution");	}

	@Override
	public void executeEnforceLinkStatement(EnforceLinkStatement statement, Context context) {
		throw new InvalidCalculationException("unsupported execution");	}

	@Override
	public SafeType executeBooleanOrExpression(BooleanOrExpression expression, Context context) {
		SafeType failure = Constants.FALSE;

		for(Expression e : expression.getOperands()) {
			SafeType res = null;
			
			try {
				res = this.executeExpression(e, context);
			} catch(InvalidCalculationException|InvalidModificationException fe) {
				res = null;
			}
			
			if(res==Constants.TRUE) 
				return Constants.TRUE;
			
			if(res== null || res.isNull()) 
				failure = null;
			else if(res.isUndefined() 
					&& failure==Constants.FALSE) 
				failure = res;
		}
		if(failure==null)
			throw new InvalidCalculationException("the operand of OR is invalid or null");
		else
			return failure;
	}

	@Override
	public SafeType executeBooleanAndExpression(BooleanAndExpression expression, Context context) {
		SafeType success = Constants.TRUE;
		for(Expression b : expression.getOperands()) {
			SafeType res = null;
			
			try {
				res = this.executeExpression(b, context);
			} catch(InvalidCalculationException|InvalidModificationException fe) {
				res = null;
			}
			
			if(res==Constants.FALSE) 
				return Constants.FALSE;
			
			if(res==null || res.isNull()) 
				success = null;
			
			else if(res.isUndefined() 
					&& success==Constants.TRUE) 
				success = res;
		}
		if(success==null)
			throw new InvalidCalculationException("the operand of AND is invalid or null");
		else 
			return success;
	}

	@Override
	public SafeType executeRelationalExpression(RelationalExpression expression, Context context) {
		SafeType left = this.executeExpression(expression.getLeft(),context);
		SafeType right = this.executeExpression(expression.getRight(),context);
		
		
		switch(expression.getOperator()) {
		case EQUAL:
			if(left.isUndefined() && right.isUndefined()) 
				throw new InvalidCalculationException("two operands of equal expression are both undefined");
			else if(left.isUndefined() || right.isUndefined()) 
				return SafeType.UNDEFINED;
			if((left.isNull() && right.isNull()) 
					|| (!left.isNull() && left.equals(right)))
				return Constants.TRUE;
			return Constants.FALSE;
		case LESS:
			return EvaluationUtil.less(left, right);
		case LESS_EQUAL:
			return EvaluationUtil.lessOrEqual(left, right);
		case GREATER:
			return EvaluationUtil.greater(left, right);
		case GREATER_EQUAL:
			return EvaluationUtil.greaterOrEqual(left, right);
		}
		throw new InvalidCalculationException("unexpected branch of relational expression");
	}

	@Override
	public SafeType executeAdditiveExpression(AdditiveExpression expression, Context context) {
		SafeType left = this.executeExpression(expression.getOperands().get(0),context);
		int size = expression.getOperators().size();
		
		for(int i=0;i<size;i++) {
			SafeType right = this.executeExpression(expression.getOperands().get(i+1),context);
			left = EvaluationUtil.additive(expression.getOperators().get(i), left, right);
		}
		
		return left;
	}

	@Override
	public SafeType executeMultiplicativeExpression(MultiplicativeExpression expression, Context context) {
		SafeType left = this.executeExpression(expression.getOperands().get(0),context);
		int size = expression.getOperators().size();
		
		for(int i=0;i<size;i++) {
			SafeType right = this.executeExpression(expression.getOperands().get(i+1),context);
			left = EvaluationUtil.mutiplicative(expression.getOperators().get(i), left, right);
		}
		
		return left;
	}

	@Override
	public SafeType executeUnaryExpression(UnaryExpression expression, Context context) {
		SafeType o = this.executeExpression(expression.getBody(),context);
		
		switch(expression.getOperator()) {
		case MINUS:
			return EvaluationUtil.minus(o);
		case NOT:
			return EvaluationUtil.not(o);
		}
		
		throw new InvalidCalculationException("unexpected branch of unary expression");
	}

//	@Override
//	public SafeType executeParenExpression(ParenExpression expression, Context context) {
//		SafeType value = this.execute(expression.getBody(), context);
//		
//		if(expression.getPaths().isEmpty()) return value;
//		else {
//			for(Path path : expression.getPaths()) {
//				value = getFeaturePath(value,path,context);
//			}
//			return value;
//		}
//	}

	@Override
	public SafeType executeTypeCastExpression(TypeCastExpression expression, Context context) {
		throw new UnsupportedOperationException("type cast expression is not supported now");
	}

	@Override
	public SafeType executeStringValueExpression(StringValueExpression expression, Context context) {
		SafeType value = SafeType.createFromValue(expression.getValue());
		if(expression.getPaths().isEmpty()) return value;
		else {
			for(Path path : expression.getPaths()) {
				value = getFeaturePath(value,path,context);
			}
			return value;
		}
	}

	@Override
	public SafeType executeBooleanValueExpression(BooleanValueExpression expression, Context context) {
		SafeType value = SafeType.createFromValue(expression.isValue());
		if(expression.getPaths().isEmpty()) return value;
		else {
			for(Path path : expression.getPaths()) {
				value = getFeaturePath(value,path,context);
			}
			return value;
		}
	}

	@Override
	public SafeType executeIntegerValueExpression(IntegerValueExpression expression, Context context) {
		SafeType value = SafeType.createFromValue(expression.getValue());
		if(expression.getPaths().isEmpty()) return value;
		else {
			for(Path path : expression.getPaths()) {
				value = getFeaturePath(value,path,context);
			}
			return value;
		}
	}

	@Override
	public SafeType executeEnumValueExpression(EnumValueExpression expression, Context context) {
		EEnum e = (EEnum) expression.getType();
		EEnumLiteral l = expression.getValue();
		return SafeType.createFromValue(EcoreUtil.createFromString(e, l.getName()));
	}

	@Override
	public SafeType executeEmptyValueExpression(EmptyValueExpression expression, Context context) {
		SafeType value = null;
		if(expression.getType()==Xmu2corePackage.eINSTANCE.getNull())
			value = Constants.NULL;
		else 
			value = Constants.UNDEFINED;
		
		if(expression.getPaths().isEmpty()) return value;
		else {
			for(Path path : expression.getPaths()) {
				value = getFeaturePath(value,path,context);
			}
			return value;
		}
	}

	@Override
	public SafeType executeObjectValueExpression(ObjectValueExpression expression, Context context) {
		SafeType value = SafeType.createFromValue(expression.getValue());
		if(expression.getPaths().isEmpty()) return value;
		else {
			for(Path path : expression.getPaths()) {
				value = getFeaturePath(value,path,context);
			}
			return value;
		}
	}

	@Override
	public SafeType executeVariableExpression(VariableExpression expression, Context context) {
		SafeType value  = context.get(expression.getVariable());
		if(expression.getPaths().isEmpty()) return value;
		else {
			for(Path path : expression.getPaths()) {
				value = getFeaturePath(value,path,context);
			}
			return value;
		}
	}
	
	protected SafeType getFeaturePath(SafeType host, Path path, Context context) {
		if(//host.isInvalid() || 
				host.isNull()) {
//			if(path instanceof HelperPath) {
//				BidirectionalMap<Object, Object> map = context.getEnvironment().getHelperMappings(((HelperPath) path).getHelper().getName());
//				Object v = map.forward(null);
//				if(v==null) return SafeType.getInvalid();
//				return SafeType.createFromValue(v);
//			}
//			return SafeType.getInvalid();
			if(path instanceof PositionPath) {
				return SafeType.NULL;
			} else
				throw new InvalidCalculationException("invalid path of NULL");
		}
		else if(host.isUndefined()) {
//			if(path instanceof HelperPath) {
//				BidirectionalMap<Object, Object> map = context.getEnvironment().getHelperMappings(((HelperPath) path).getHelper().getName());
//				Object v = map.forward(null);
//				if(v==null) return SafeType.getInvalid();
//				return SafeType.createFromValue(v);
//			}
//			return SafeType.getUndefined();
			throw new InvalidCalculationException("invalid path of UNDEFINED");
		}
		
		if(host.isObject()) {
			EObject o  = host.getObjectValue();
			if(path instanceof FeaturePath) {
				EStructuralFeature feature = ((FeaturePath) path).getFeature();
				return SafeType.createFromValue(o.eGet(feature));
//			} else if(path instanceof HelperPath) {
//				BidirectionalMap<Object, Object> map = context.getEnvironment().getHelperMappings(((HelperPath) path).getHelper().getName());
//				Object v = map.forward(host.getValue());
//				if(v==null) {
//					if(((HelperPath) path).getHelper().isDefaultEqual()) return host;
//					return SafeType.getInvalid();
//				}
//				return SafeType.createFromValue(v);
			} else if(path instanceof LoopPath) {
				List<? extends Object> col = Collections.singletonList(o);
				return handleLoopPath(col, (LoopPath)path, context);
			} else if(path instanceof OperationPath) {
				return handleOperationPath(host, (OperationPath)path, context);
			} else if(path instanceof PositionPath) {
				List<? extends Object> col = Collections.singletonList(o);
				return handlePositionPath(col, (PositionPath)path, context);
			} else 
				throw new InvalidCalculationException("invalid path of EObject");
		} else {
//			Object o = host.getValue();
//			if(path instanceof FeaturePath) {
//				try{
//					Field field = o.getClass().getField(((FeaturePath) path).getFeature());
//					if(field==null) return SafeType.getInvalid();
//					return SafeType.createFromValue(field.get(o));
//				} catch(Exception e) {
//					e.printStackTrace();
//					return SafeType.getInvalid();
//				}
////			} else if(path instanceof HelperPath) {
////				BidirectionalMap<Object, Object> map = context.getEnvironment().getHelperMappings(((HelperPath) path).getHelper().getName());
////				Object v = map.forward(host.getValue());
////				if(v==null) return SafeType.getInvalid();
////				return SafeType.createFromValue(v);
//			} else 
			if(path instanceof LoopPath) {
				List<?> col = null;
				if(host.getValue() instanceof List<?>)
					col = (List<?>)host.getValue();
				else
					col = Collections.singletonList(host.getValue());
				return handleLoopPath(col, (LoopPath)path, context);
			} else if(path instanceof OperationPath){
				return handleOperationPath(host, (OperationPath)path, context);
			} else if(path instanceof PositionPath) {
				List<?> col = null;
				if(host.getValue() instanceof List<?>)
					col = (List<?>)host.getValue();
				else
					col = Collections.singletonList(host.getValue());
				return handlePositionPath(col, (PositionPath)path, context);
			} else 
				throw new InvalidCalculationException("invalid path of Object");
		}
	}
	
	/**
	 * the method will return the element in col, whose position is equal to the value of path
	 * @param col
	 * @param path
	 * @param context
	 * @return
	 */
	protected SafeType handlePositionPath(List<? extends Object> col, PositionPath path, Context context) {
		try {
			SafeType id = calculatePositionPath(path,context);
			if(id.getIntegerValue()==-1)
				id = SafeType.createFromValue(col.size()-1);
			
			return SafeType.createFromValue(col.get(id.getIntegerValue()));
		} catch(Exception e) {
			throw new InvalidCalculationException("invalid position");
		}
	}

	protected SafeType handleOperationPath(SafeType host, OperationPath path, Context context) {
		Object o = host.getValue();
		
		try {
			EList<Expression> parameters = ((OperationPath)path).getParameters();
			
			Object[] args = new Object[parameters.size()];
			Class<?>[] types = new Class<?>[parameters.size()];
			
			for(int i=0;i<args.length;i++) {
				Expression e = parameters.get(i);
				SafeType pv = EXPRESSION_CHECK.executeExpression(e, context);
				if(pv.isUndefined())
					throw new InvalidCalculationException("invalid parameter");
				args[i] = pv.getValue();
				types[i] = args[i].getClass();
			}
			
			Method method = o.getClass().getMethod(((OperationPath)path).getOperation(), types);
			if(method!=null) {
				Object r = method.invoke(o, args);
				return SafeType.createFromValue(r);
			} else 
				throw new InvalidCalculationException("the operation does not exist");
		} catch(Exception e) {
			throw new InvalidCalculationException("invalid operation call");
		}
	}

	@SuppressWarnings("unchecked")
	public SafeType handleLoopPath(List<? extends Object> col, LoopPath path,
			Context context) {
		Context inner = context.createInnerContext();
		inner.registerVariable(path.getIterator());
		
		if(((LoopPath) path).getOperator()==LoopOperator.FOR_ALL) {
			SafeType ret = Constants.TRUE;
			for(Object o : col) {
				inner.put(path.getIterator(), SafeType.createFromValue(o));
				try {
					ret = this.executeExpression(path.getBody(), inner);
					if(ret==Constants.FALSE) return Constants.FALSE;
				} catch(Exception e) {
					return Constants.FALSE;
				}
			}
			return Constants.TRUE;
		} else if(((LoopPath) path).getOperator()==LoopOperator.EXISTS) {
			SafeType ret = Constants.FALSE;
			for(Object o : col) {
				inner.put(path.getIterator(), SafeType.createFromValue(o));
				try {
					ret = this.executeExpression(path.getBody(), inner);
					if(ret==Constants.TRUE) 
						return Constants.TRUE;
				} catch(Exception e) {
					return Constants.FALSE;
				}
			}
			return Constants.FALSE;
		} else if(((LoopPath) path).getOperator()==LoopOperator.SELECT) {
			List<Object> resCol = null;
			
			if(col instanceof ModelList<?>)
				resCol = new FeatureSelectionList<Object>((List<Object>)col);
			else
				resCol = new ArrayList<Object>();
			
			int index = 0;
			for(Object o : col) {
				inner.put(path.getIterator(), SafeType.createFromValue(o));
				try {
					SafeType ret = this.executeExpression(path.getBody(), inner);
					if(ret==Constants.TRUE) {
						if(resCol instanceof FeatureSelectionList<?>) {
							((FeatureSelectionList<?>) resCol).addFromSource(index);
						} else
							resCol.add(o);
					}
				} catch(Exception e){
				}
				index++;
			}
			return SafeType.createFromValue(resCol);
		}
		
		throw new InvalidCalculationException("invalid loop path");
	}

	public SafeType calculatePositionPath(PositionPath position, Context context) {
		if(position.getOperator()==PositionOperator.FIRST)
			return SafeType.createFromValue(0);
		else if(position.getOperator()==PositionOperator.LAST)
			return SafeType.createFromValue(-1);
		else {
			return this.executeExpression(position.getValue(),context);
		}
		
	}

	@Override
	public void executeMatchPatternStatement(MatchPattern o, Context context) {
		throw new InvalidCalculationException("unsupported execution");	}

	@Override
	public void executeCheckExpressionStatement(CheckExpressionStatement o, Context context) {
		throw new InvalidCalculationException("unsupported execution");	}

	@Override
	public void executeEnforceExpressionStatement(EnforceExpressionStatement o, Context context) {
		throw new InvalidCalculationException("unsupported execution");	}

	@Override
	public void executeSolveConstraintStatement(SolveConstraintStatement statement, Context context) {
		throw new InvalidCalculationException("unsupported execution");
	}
}
