package edu.ustb.sei.mde.morel.resource.morel.execution;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.mde.emg.library.OclStandardLibrary;
import edu.ustb.sei.mde.emg.runtime.Context;
import edu.ustb.sei.mde.emg.runtime.datatype.OclBag;
import edu.ustb.sei.mde.emg.runtime.datatype.OclCollection;
import edu.ustb.sei.mde.emg.runtime.datatype.OclOrderedSet;
import edu.ustb.sei.mde.emg.runtime.datatype.OclSequence;
import edu.ustb.sei.mde.emg.runtime.datatype.OclSet;
import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;
import edu.ustb.sei.mde.morel.AdditiveExp;
import edu.ustb.sei.mde.morel.AdditiveOperator;
import edu.ustb.sei.mde.morel.BagType;
import edu.ustb.sei.mde.morel.BindExp;
import edu.ustb.sei.mde.morel.BlockStatement;
import edu.ustb.sei.mde.morel.BooleanAndExp;
import edu.ustb.sei.mde.morel.BooleanImpliesExp;
import edu.ustb.sei.mde.morel.BooleanLiteralExp;
import edu.ustb.sei.mde.morel.BooleanOrExp;
import edu.ustb.sei.mde.morel.CallPathExp;
import edu.ustb.sei.mde.morel.Clause;
import edu.ustb.sei.mde.morel.CollectionType;
import edu.ustb.sei.mde.morel.ConditionExp;
import edu.ustb.sei.mde.morel.Expression;
import edu.ustb.sei.mde.morel.FeaturePathExp;
import edu.ustb.sei.mde.morel.ForStatement;
import edu.ustb.sei.mde.morel.IfStatement;
import edu.ustb.sei.mde.morel.IntegerLiteralExp;
import edu.ustb.sei.mde.morel.IteratorPathExp;
import edu.ustb.sei.mde.morel.IteratorType;
import edu.ustb.sei.mde.morel.LetExp;
import edu.ustb.sei.mde.morel.LinkConstraint;
import edu.ustb.sei.mde.morel.LiteralExp;
import edu.ustb.sei.mde.morel.LoopPathExp;
import edu.ustb.sei.mde.morel.MorelFactory;
import edu.ustb.sei.mde.morel.MultiplicativeExp;
import edu.ustb.sei.mde.morel.MultiplicativeOperator;
import edu.ustb.sei.mde.morel.NestedExp;
import edu.ustb.sei.mde.morel.ObjectVariable;
import edu.ustb.sei.mde.morel.ObjectVariableWithInit;
import edu.ustb.sei.mde.morel.OperationPathExp;
import edu.ustb.sei.mde.morel.OrderedSetType;
import edu.ustb.sei.mde.morel.PrimitiveVariable;
import edu.ustb.sei.mde.morel.PrimitiveVariableWithInit;
import edu.ustb.sei.mde.morel.RealLiteralExp;
import edu.ustb.sei.mde.morel.RelationalExp;
import edu.ustb.sei.mde.morel.RelationalOperator;
import edu.ustb.sei.mde.morel.SequenceType;
import edu.ustb.sei.mde.morel.SetType;
import edu.ustb.sei.mde.morel.Statement;
import edu.ustb.sei.mde.morel.StringLiteralExp;
import edu.ustb.sei.mde.morel.UnaryExp;
import edu.ustb.sei.mde.morel.UnaryOperator;
import edu.ustb.sei.mde.morel.Variable;
import edu.ustb.sei.mde.morel.VariableExp;
import edu.ustb.sei.mde.morel.VariableWithInit;
import edu.ustb.sei.mde.morel.resource.morel.util.AbstractMorelInterpreter;

public class OclInterpreter extends
		AbstractMorelInterpreter<Object, Context> {
	
	protected OclStandardLibrary library = new OclStandardLibrary(null);

	@Override
	public Boolean interprete_edu_ustb_sei_mde_morel_LinkConstraint(
			LinkConstraint linkConstraint, Context context) {
		EObject s = (EObject) context.getValue(linkConstraint.getSource());
		EObject t = (EObject) context.getValue(linkConstraint.getTarget());
		EReference ref = linkConstraint.getReference();
		if(ref.isMany()) {
			List<?> list = (List<?>)s.eGet(ref);
			return list.contains(t);
		} else return s.eGet(ref)==t;
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_StringLiteralExp(
			StringLiteralExp stringLiteralExp, Context context) {
		return this.interprete_edu_ustb_sei_mde_morel_CallPathExp(stringLiteralExp.getStringSymbol(),stringLiteralExp.getPath(),context);
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_IntegerLiteralExp(
			IntegerLiteralExp integerLiteralExp, Context context) {
		return this.interprete_edu_ustb_sei_mde_morel_CallPathExp(integerLiteralExp.getIntegerSymbol(),integerLiteralExp.getPath(),context);
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_RealLiteralExp(
			RealLiteralExp realLiteralExp, Context context) {
		return this.interprete_edu_ustb_sei_mde_morel_CallPathExp(realLiteralExp.getRealSymbol(),realLiteralExp.getPath(),context);
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_BooleanLiteralExp(
			BooleanLiteralExp booleanLiteralExp, Context context) {
		return this.interprete_edu_ustb_sei_mde_morel_CallPathExp(booleanLiteralExp.isBoolSymbol(),booleanLiteralExp.getPath(),context);
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_VariableExp(
			VariableExp variableExp, Context context) {
		CallPathExp path = variableExp.getPath();
		Object obj = context.getValue(variableExp.getReferredVariable());
		
		if(path==null) return obj;
		else {
			return interprete_edu_ustb_sei_mde_morel_CallPathExp(obj, variableExp.getPath(), context);
		}
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_NestedExp(
			NestedExp nestedExp, Context context) {
		CallPathExp path = nestedExp.getPath();
		Object obj = this.interprete(nestedExp.getExpression(), context);
		if(path==null) return obj;
		else {
			return interprete_edu_ustb_sei_mde_morel_CallPathExp(obj, nestedExp.getPath(), context);
		}
	}
	
	protected Object interprete_edu_ustb_sei_mde_morel_CallPathExp(Object point,
			CallPathExp callPathExp, Context context) {
		return interprete_edu_ustb_sei_mde_morel_CallPathExp(point, callPathExp, context, false, null);
	}

	protected Object interprete_edu_ustb_sei_mde_morel_CallPathExp(Object point,
			CallPathExp callPathExp, Context context, boolean bindValue, Object value) {
		// TODO Auto-generated method stub
		if(callPathExp==null) return point;
		else if(callPathExp instanceof FeaturePathExp) 
			return interprete_edu_ustb_sei_mde_morel_FeaturePathExp(point,(FeaturePathExp) callPathExp,context, bindValue, value);
		else if(callPathExp instanceof OperationPathExp) 
			return interprete_edu_ustb_sei_mde_morel_OperationPathExp(point,(OperationPathExp) callPathExp,context, bindValue, value);
		else if(callPathExp instanceof LoopPathExp) 
			return interprete_edu_ustb_sei_mde_morel_LoopPathExp(point,(LoopPathExp)callPathExp, context, bindValue, value);
		else throw new UnsupportedOperationException(callPathExp.toString());
	}

	protected Object interprete_edu_ustb_sei_mde_morel_FeaturePathExp(Object point,
			FeaturePathExp featurePathExp, Context context, boolean bindValue, Object value) {
		if(featurePathExp==null) return point;
		else if(bindValue&&featurePathExp.getNext()==null) {
			if(point instanceof EObject) {
				EStructuralFeature feature = ((EObject)point).eClass().getEStructuralFeature(featurePathExp.getFeature());
				if(feature.isMany()) {
					@SuppressWarnings("unchecked")
					Collection<Object> col = (Collection<Object>)(((EObject)point).eGet(feature));
					if(value instanceof Collection<?>)
						col.addAll((Collection<?>)value);
					else 
						col.add(value);
					return true;
				} else {
					((EObject)point).eSet(feature, value);
					return true;
				}
			}
			throw new UnsupportedOperationException(featurePathExp.toString());
		}
		else {
			if(point instanceof EObject){
				EObject eobj = (EObject)point;
				EStructuralFeature feature = eobj.eClass().getEStructuralFeature(featurePathExp.getFeature());
				return interprete_edu_ustb_sei_mde_morel_CallPathExp(eobj.eGet(feature), featurePathExp.getNext(), context, bindValue, value);				
			} else throw new UnsupportedOperationException(featurePathExp.toString());
		}
	}

	protected Object interprete_edu_ustb_sei_mde_morel_OperationPathExp(
			Object point, OperationPathExp operationPathExp, Context context, boolean bindValue, Object value) {
		if(operationPathExp==null) 
			return point;
		int size = operationPathExp.getParameters().size();
		Object[] params = new Object[size];
		for(int i=0;i<size;i++) {
			Expression exp = operationPathExp.getParameters().get(i);
			params[i] = this.interprete(exp, context);
		}
		Object obj = library.execute(operationPathExp.getOperation(), point, params);
		return this.interprete_edu_ustb_sei_mde_morel_CallPathExp(obj,operationPathExp.getNext(),context, bindValue, value);
	}

	protected Object interprete_edu_ustb_sei_mde_morel_LoopPathExp(
			Object point, LoopPathExp loopPathExp, Context context, boolean bindValue, Object value) {
		if(loopPathExp instanceof IteratorPathExp)
			return interprete_edu_ustb_sei_mde_morel_IteratorPathExp(point,(IteratorPathExp)loopPathExp, context, bindValue, value);
		else  throw new UnsupportedOperationException(loopPathExp.toString());
	}

	protected Object interprete_edu_ustb_sei_mde_morel_IteratorPathExp(
			Object point, IteratorPathExp loopPathExp, Context context, boolean bindValue, Object value) {
		if(loopPathExp==null)
			return point;
		switch(loopPathExp.getType().getValue()){
		case IteratorType.FOR_ALL_VALUE:
		{
			Collection<?> col = (Collection<?>) point;
			if(loopPathExp.getSecondVar()==null) {
				Context c = context.newScope();
				Variable firstVar = loopPathExp.getFirstVar();
				
				c.getBindingMap().put(firstVar, OclUndefined.INVALIDED);
				
				for(Object o : col) {
					c.putValue(firstVar, o);
					Boolean r = (Boolean)this.interprete(loopPathExp.getBodyExp(), c);
					if(!r) 
						return interprete_edu_ustb_sei_mde_morel_CallPathExp(false,loopPathExp.getNext(),context,bindValue,value);
				}
				return interprete_edu_ustb_sei_mde_morel_CallPathExp(true,loopPathExp.getNext(),context,bindValue,value);
			} else {
				Context c = context.newScope();
				Variable firstVar = loopPathExp.getFirstVar();
				Variable secondVar = loopPathExp.getSecondVar();
				
				c.getBindingMap().put(firstVar, OclUndefined.INVALIDED);
				c.getBindingMap().put(secondVar, OclUndefined.INVALIDED);
				
				for(Object o1 : col) {
					c.putValue(firstVar, o1);
					for(Object o2 : col) {
						c.putValue(secondVar, o2);
						Boolean r = (Boolean)this.interprete(loopPathExp.getBodyExp(), c);
						if(!r) 
							return interprete_edu_ustb_sei_mde_morel_CallPathExp(false,loopPathExp.getNext(),context,bindValue,value);
					}
				}
				
				return interprete_edu_ustb_sei_mde_morel_CallPathExp(true,loopPathExp.getNext(),context,bindValue,value);
			}
		}
		case IteratorType.EXISTS_VALUE:
		{
			Collection<?> col = (Collection<?>) point;
			if(loopPathExp.getSecondVar()==null) {
				Context c = context.newScope();
				Variable firstVar = loopPathExp.getFirstVar();
				
				c.getBindingMap().put(firstVar, OclUndefined.INVALIDED);
				
				for(Object o : col) {
					c.putValue(firstVar, o);
					Boolean r = (Boolean)this.interprete(loopPathExp.getBodyExp(), c);
					if(r) 
						return interprete_edu_ustb_sei_mde_morel_CallPathExp(true,loopPathExp.getNext(),context,bindValue,value);
				}
				return interprete_edu_ustb_sei_mde_morel_CallPathExp(false,loopPathExp.getNext(),context,bindValue,value);
			} else {
				Context c = context.newScope();
				Variable firstVar = loopPathExp.getFirstVar();
				Variable secondVar = loopPathExp.getSecondVar();
				
				c.getBindingMap().put(firstVar, OclUndefined.INVALIDED);
				c.getBindingMap().put(secondVar, OclUndefined.INVALIDED);
				
				for(Object o1 : col) {
					c.putValue(firstVar, o1);
					for(Object o2 : col) {
						c.putValue(secondVar, o2);
						Boolean r = (Boolean)this.interprete(loopPathExp.getBodyExp(), c);
						if(r) 
							return interprete_edu_ustb_sei_mde_morel_CallPathExp(true,loopPathExp.getNext(),context,bindValue,value);
					}
				}
				
				return interprete_edu_ustb_sei_mde_morel_CallPathExp(false,loopPathExp.getNext(),context,bindValue,value);
			}
		}
		case IteratorType.SELECT_VALUE:
		{
			Collection<?> col = (Collection<?>) point;
			OclCollection ret = (OclCollection) library.execute("createNewCollection", point);
			
			Context c = context.newScope();
			Variable firstVar = loopPathExp.getFirstVar();
			
			c.getBindingMap().put(firstVar, OclUndefined.INVALIDED);
			
			for(Object o : col) {
				c.putValue(firstVar, o);
				try {
					Boolean r = (Boolean)this.interprete(loopPathExp.getBodyExp(), c);
					if(r) 
						ret.add(o);
				} catch (Exception e) {
					continue;
				}
			}
			return interprete_edu_ustb_sei_mde_morel_CallPathExp(ret,loopPathExp.getNext(),context,bindValue,value);
		}
		case IteratorType.REJECT_VALUE:
		{
			Collection<?> col = (Collection<?>) point;
			OclCollection ret = (OclCollection) library.execute("createNewCollection", point);
			
			Context c = context.newScope();
			Variable firstVar = loopPathExp.getFirstVar();
			
			c.getBindingMap().put(firstVar, OclUndefined.INVALIDED);
			
			for(Object o : col) {
				c.putValue(firstVar, o);
				try {
					Boolean r = (Boolean)this.interprete(loopPathExp.getBodyExp(), c);
					if(!r) 
						ret.add(o);
				} catch (Exception e) {
					continue;
				}
			}
			return interprete_edu_ustb_sei_mde_morel_CallPathExp(ret,loopPathExp.getNext(),context,bindValue,value);
		}
		case IteratorType.COLLECT_VALUE:
		{
			Collection<?> col = (Collection<?>) point;
			Object type = library.oclType(col);
			CollectionType cType = null;
			OclCollection ret = null;
			
			if(type instanceof SetType) {
				ret = new OclSet();
				cType = MorelFactory.eINSTANCE.createSetType();
				cType.setElementType(EcorePackage.eINSTANCE.getEJavaObject());
				ret.setType(cType);
			} else if(type instanceof OrderedSetType) {
				ret = new OclOrderedSet();
				cType = MorelFactory.eINSTANCE.createOrderedSetType();
				cType.setElementType(EcorePackage.eINSTANCE.getEJavaObject());
				ret.setType(cType);
			} else if(type instanceof SequenceType) {
				ret = new OclSequence();
				cType = MorelFactory.eINSTANCE.createSequenceType();
				cType.setElementType(EcorePackage.eINSTANCE.getEJavaObject());
				ret.setType(cType);
			} else if(type instanceof BagType) {
				ret = new OclBag();
				cType = MorelFactory.eINSTANCE.createBagType();
				cType.setElementType(EcorePackage.eINSTANCE.getEJavaObject());
				ret.setType(cType);
			}
			
			Context c = context.newScope();
			Variable firstVar = loopPathExp.getFirstVar();
			
			c.getBindingMap().put(firstVar, OclUndefined.INVALIDED);
			
			for(Object o : col) {
				c.putValue(firstVar, o);
				try {
					Object r =this.interprete(loopPathExp.getBodyExp(), c);
					ret.add(r);
				} catch (Exception e) {
					continue;
				}
			}
			return interprete_edu_ustb_sei_mde_morel_CallPathExp(ret,loopPathExp.getNext(),context,bindValue,value);
		}
		case IteratorType.CLOSURE_VALUE:
		{
			throw new UnsupportedOperationException("closure");
		}
		}
		return null;
	}
	

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_LetExp(LetExp letExp,
			Context context) {
		Context c = context.newScope();
		for(Variable v : letExp.getVariables()) {
			c.putValue(v, OclUndefined.INVALIDED);
			if(v instanceof VariableWithInit) {
				c.putValue(v, this.interprete(((VariableWithInit)v).getInitExp(), c));
			}
		}
		return this.interprete(letExp.getInExp(), c);
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_ConditionExp(
			ConditionExp conditionExp, Context context) {
		// TODO Auto-generated method stub
		Object b = this.interprete(conditionExp.getCondition(),context);
		if(!(b instanceof Boolean)) return OclUndefined.INVALIDED;
		
		if((Boolean)b) return this.interprete(conditionExp.getThenBranch(), context);
		else return this.interprete(conditionExp.getElseBranch(), context);
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_BooleanImpliesExp(
			BooleanImpliesExp booleanImpliesExp, Context context) {
		Object i = this.interprete(booleanImpliesExp.getLeft(),context);
		if(!(i instanceof Boolean)) {
			return OclUndefined.INVALIDED;
		}
		Boolean iv = (Boolean)i;
		if(iv){
			return this.interprete(booleanImpliesExp.getRight(),context);
		} else 
			return true;
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_BooleanOrExp(
			BooleanOrExp booleanOrExp, Context context) {
		Object i = this.interprete(booleanOrExp.getLeft(),context);
		if(!(i instanceof Boolean)) 
			return this.interprete(booleanOrExp.getRight(),context);
		else {
			Boolean iv = (Boolean)i;
			if(!iv){
				return this.interprete(booleanOrExp.getRight(),context);
			} else 
				return true;
		}
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_BooleanAndExp(
			BooleanAndExp booleanAndExp, Context context) {
		Object i = this.interprete(booleanAndExp.getLeft(),context);
		
		if(!(i instanceof Boolean)) 
			return OclUndefined.INVALIDED;
		else {
			Boolean iv = (Boolean)i;
			if(iv){
				return this.interprete(booleanAndExp.getRight(),context);
			} else 
				return false;
		}
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_RelationalExp(
			RelationalExp relationalExp, Context context) {
		String op = null;
		switch(relationalExp.getOperator().getValue()){
		case RelationalOperator.EQUAL_VALUE:
			op = "=";
			break;
		case RelationalOperator.LESS_VALUE:
			op = "<";
			break;
		case RelationalOperator.LESS_OR_EQ_VALUE:
			op = "<=";
			break;
		case RelationalOperator.GREATER_VALUE:
			op = ">";
			break;
		case RelationalOperator.GREATER_OR_EQ_VALUE:
			op = ">=";
			break;
		case RelationalOperator.NOT_EQUAL_VALUE:
			op = "<>";
			break;
		default:
			op = "=";
			break;
		}
		Object l = this.interprete(relationalExp.getLeft(),context);
		Object r = this.interprete(relationalExp.getRight(), context);
		
		return library.execute(op, l, r);
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_AdditiveExp(
			AdditiveExp additiveExp, Context context) {
		// TODO Auto-generated method stub
		int size = additiveExp.getOperators().size();
		
		Object result = this.interprete(additiveExp.getChildren().get(0), context);
		String op = null;
		
		for(int i = 0;i<size;i++) {
			switch(additiveExp.getOperators().get(i).getValue()){
			case AdditiveOperator.PLUS_VALUE:
				op = "+";
				break;
			case AdditiveOperator.MINUS_VALUE:
				op = "-";
				break;
			}
			Object add = this.interprete(additiveExp.getChildren().get(i+1), context);
			result = library.execute(op, result, add);
		}
		
		return result;
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_MultiplicativeExp(
			MultiplicativeExp multiplicativeExp, Context context) {
		// TODO Auto-generated method stub
		int size = multiplicativeExp.getOperators().size();
		
		Object result = this.interprete(multiplicativeExp.getChildren().get(0), context);
		String op = null;
		
		for(int i = 0;i<size;i++) {
			switch(multiplicativeExp.getOperators().get(i).getValue()){
			case MultiplicativeOperator.MULTI_VALUE:
				op = "*";
				break;
			case MultiplicativeOperator.DIV_VALUE:
				op = "/";
				break;
			}
			Object add = this.interprete(multiplicativeExp.getChildren().get(i+1), context);
			result = library.execute(op, result, add);
		}
		
		return result;
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_UnaryExp(
			UnaryExp unaryExp, Context context) {
		// TODO Auto-generated method stub
		switch(unaryExp.getOperator().getValue()){
		case UnaryOperator.PLUS_VALUE:
			return this.interprete(unaryExp.getChild(), context);
		case UnaryOperator.MINUS_VALUE:
			return library.execute("minus", this.interprete(unaryExp.getChild(), context));
		case UnaryOperator.NOT_VALUE:
			return library.execute("not", this.interprete(unaryExp.getChild(), context));
		}
		return OclUndefined.INVALIDED;
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_BindExp(BindExp bindExp,
			Context context) {
		Object v = this.interprete(bindExp.getValueExp(), context);
		VariableExp exp = bindExp.getSource();
		if(exp.getPath()==null) {
			context.putValue(exp.getReferredVariable(), v);
			return true;
		} else {
			Object s = context.getValue(exp.getReferredVariable());
			return this.interprete_edu_ustb_sei_mde_morel_CallPathExp(s, exp.getPath(), context,true,v);
		}
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_IfStatement(
			IfStatement ifStatement, Context context) {
		// TODO Auto-generated method stub
		Object v = this.interprete(ifStatement.getCondition(),context);
		if(v instanceof Boolean) {
			if((Boolean)v) return this.interprete(ifStatement.getThenStatement(), context);
			else if(ifStatement.getElseStatement()!=null) 
				return this.interprete(ifStatement.getElseStatement(), context);
			else return true;
		} else {
			return OclUndefined.INVALIDED;
		}
	}

	@Override
	public Boolean interprete_edu_ustb_sei_mde_morel_ForStatement(
			ForStatement forStatement, Context context) {
		// TODO Auto-generated method stub
		Context c = context.newScope();
		if(forStatement.getIterator()!=null) {
			this.interprete(forStatement.getIterator(), c);
		}
		
		Boolean condition = true;
		while(true) {
			condition = (Boolean) this.interprete(forStatement.getTerminationExp(), c);
			if(!condition) break;
			this.interprete(forStatement.getBodyStatement(), c);
			this.interprete(forStatement.getStepExp(), c);
		}
		
		return true;
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_Variable(Variable variable,
			Context context) {
		if(variable instanceof VariableWithInit)
			return interprete_edu_ustb_sei_mde_morel_VariableWithInit((VariableWithInit) variable,context);
		else {
			context.getBindingMap().put(variable, OclUndefined.INVALIDED);
			return variable;
		}
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_VariableWithInit(
			VariableWithInit variableWithInit, Context context) {
		// TODO Auto-generated method stub
		context.getBindingMap().put(variableWithInit, OclUndefined.INVALIDED);
		Object v = this.interprete(variableWithInit.getInitExp(),context);
		context.putValue(variableWithInit, v);
		return variableWithInit;
	}

	@Override
	public Boolean interprete_edu_ustb_sei_mde_morel_BlockStatement(
			BlockStatement blockStatement, Context context) {
		for(Statement e : blockStatement.getStatements()) {
			this.interprete(e, context);
		}
		return true;
	}

}
