package edu.ustb.sei.mde.morel.resource.morel.execution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.mde.emg.library.OclStandardLibrary;
import edu.ustb.sei.mde.emg.runtime.Context;
import edu.ustb.sei.mde.emg.runtime.RuntimePackage;
import edu.ustb.sei.mde.emg.runtime.datatype.OclBag;
import edu.ustb.sei.mde.emg.runtime.datatype.OclCollection;
import edu.ustb.sei.mde.emg.runtime.datatype.OclOrderedSet;
import edu.ustb.sei.mde.emg.runtime.datatype.OclSequence;
import edu.ustb.sei.mde.emg.runtime.datatype.OclSet;
import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;
import edu.ustb.sei.mde.modeling.ui.ConsoleUtil;
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
import edu.ustb.sei.mde.morel.CollectionLiteralExp;
import edu.ustb.sei.mde.morel.CollectionType;
import edu.ustb.sei.mde.morel.ConditionExp;
import edu.ustb.sei.mde.morel.DeclarativeStatement;
import edu.ustb.sei.mde.morel.EnumLiteralExp;
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
import edu.ustb.sei.mde.morel.Pattern;
import edu.ustb.sei.mde.morel.PredefinedBindExp;
import edu.ustb.sei.mde.morel.PredefinedVariable;
import edu.ustb.sei.mde.morel.PredefinedVariableExp;
import edu.ustb.sei.mde.morel.PrimitiveVariable;
import edu.ustb.sei.mde.morel.PrimitiveVariableWithInit;
import edu.ustb.sei.mde.morel.Query;
import edu.ustb.sei.mde.morel.QueryModel;
import edu.ustb.sei.mde.morel.RealLiteralExp;
import edu.ustb.sei.mde.morel.RelationalExp;
import edu.ustb.sei.mde.morel.RelationalOperator;
import edu.ustb.sei.mde.morel.Rule;
import edu.ustb.sei.mde.morel.SectionType;
import edu.ustb.sei.mde.morel.SequenceType;
import edu.ustb.sei.mde.morel.SetType;
import edu.ustb.sei.mde.morel.SimpleLinkConstraint;
import edu.ustb.sei.mde.morel.Statement;
import edu.ustb.sei.mde.morel.StringLiteralExp;
import edu.ustb.sei.mde.morel.TransformationModel;
import edu.ustb.sei.mde.morel.TypeLiteralExp;
import edu.ustb.sei.mde.morel.UnaryExp;
import edu.ustb.sei.mde.morel.UnaryOperator;
import edu.ustb.sei.mde.morel.UndefinedLiteral;
import edu.ustb.sei.mde.morel.UndefinedLiteralExp;
import edu.ustb.sei.mde.morel.Variable;
import edu.ustb.sei.mde.morel.VariableExp;
import edu.ustb.sei.mde.morel.VariableWithInit;
import edu.ustb.sei.mde.morel.resource.morel.execution.primitives.Apply;
import edu.ustb.sei.mde.morel.resource.morel.execution.primitives.Initialize;
import edu.ustb.sei.mde.morel.resource.morel.execution.primitives.Match;
import edu.ustb.sei.mde.morel.resource.morel.util.AbstractMorelInterpreter;

public class OclInterpreter extends
		AbstractMorelInterpreter<Object, Context> {
	
	public OclInterpreter() {
		super();
		Initialize.instance.initialize();
	}



	protected OclStandardLibrary library = new OclStandardLibrary(null);

	@Override
	public Object interprete(EObject object, Context context) {
		// TODO Auto-generated method stub
		Object result = null;
		if(object instanceof LinkConstraint) {
			result = this.interprete_edu_ustb_sei_mde_morel_SimpleLinkConstraint((SimpleLinkConstraint) object, context);
		} else if(object instanceof StringLiteralExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_StringLiteralExp((StringLiteralExp)object, context);
		} else if(object instanceof IntegerLiteralExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_IntegerLiteralExp((IntegerLiteralExp)object, context);
		} else if(object instanceof RealLiteralExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_RealLiteralExp((RealLiteralExp)object, context);
		} else if(object instanceof BooleanLiteralExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_BooleanLiteralExp((BooleanLiteralExp)object, context);
		} else if(object instanceof VariableExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_VariableExp((VariableExp)object, context);
		} else if(object instanceof NestedExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_NestedExp((NestedExp)object, context);
		} else if(object instanceof LetExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_LetExp((LetExp)object, context);
		} else if(object instanceof ConditionExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_ConditionExp((ConditionExp)object, context);
		} else if(object instanceof BooleanImpliesExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_BooleanImpliesExp((BooleanImpliesExp)object, context);
		} else if(object instanceof BooleanOrExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_BooleanOrExp((BooleanOrExp)object, context);
		} else if(object instanceof BooleanAndExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_BooleanAndExp((BooleanAndExp)object, context);
		} if (object instanceof RelationalExp) {
			result = interprete_edu_ustb_sei_mde_morel_RelationalExp((edu.ustb.sei.mde.morel.RelationalExp) object, context);
		} else if(object instanceof AdditiveExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_AdditiveExp((AdditiveExp)object, context);
		} else if(object instanceof MultiplicativeExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_MultiplicativeExp((MultiplicativeExp)object, context);
		} else if(object instanceof UnaryExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_UnaryExp((UnaryExp)object, context);
		} else if(object instanceof BindExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_BindExp((BindExp)object, context);
		} else if(object instanceof PredefinedBindExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_PredefinedBindExp((PredefinedBindExp)object, context);
		} else if(object instanceof IfStatement) {
			result = this.interprete_edu_ustb_sei_mde_morel_IfStatement((IfStatement)object, context);
		} else if(object instanceof ForStatement) {
			result = this.interprete_edu_ustb_sei_mde_morel_ForStatement((ForStatement)object, context);
		} else if(object instanceof BlockStatement) {
			result = this.interprete_edu_ustb_sei_mde_morel_BlockStatement((BlockStatement)object, context);
		} else if(object instanceof Variable) {
			result = this.interprete_edu_ustb_sei_mde_morel_Variable((Variable)object, context);
		} else if(object instanceof VariableWithInit) {
			result = this.interprete_edu_ustb_sei_mde_morel_VariableWithInit((VariableWithInit)object, context);
		} else if(object instanceof UndefinedLiteralExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_UndefinedLiteralExp((UndefinedLiteralExp)object, context);
		} else if(object instanceof TypeLiteralExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_TypeLiteralExp((TypeLiteralExp)object, context);
		} else if(object instanceof PredefinedVariableExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_PredefinedVariableExp((PredefinedVariableExp)object, context);
		} else if(object instanceof DeclarativeStatement) {
			result = this.interprete_edu_ustb_sei_mde_morel_DeclarativeStatement((DeclarativeStatement)object, context);
		} else if(object instanceof CollectionLiteralExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_CollectionLiteralExp((CollectionLiteralExp)object, context);
		} else if(object instanceof EnumLiteralExp) {
			result = this.interprete_edu_ustb_sei_mde_morel_EnumLiteralExp((EnumLiteralExp)object, context);
		}
		
		if(result!=null) return result;
		else {
			System.out.println("call super.interprete:"+object);
			return super.interprete(object, context);
		}
	}
	
	

	public Object interprete_edu_ustb_sei_mde_morel_Query(Query query,
			Context context) {
		Match match = Match.instance;
		context.setHost(query);
		context.initWithHost();
		initVariable(query,context);
		
//		for(Variable v : query.getVariables()) {//��ʼ��
//			if(v instanceof VariableWithInit) {
//				Object val = this.interprete((VariableWithInit)v, context);
//				context.putValue(v, val);
//			}
//		}
		List<Context> result = match.match(query, context, this, context.getEnviroment());
		
		return result;
	}



	@Override
	public Object interprete_edu_ustb_sei_mde_morel_Rule(Rule rule,
			Context context) {
		try {
			Match match = Match.instance;
			Apply apply = Apply.instance;
			
			context.setHost(rule);
			context.initWithHost();
			
			for(Pattern p : rule.getPatterns()) {
				initVariable(p, context);
			}
			
			List<Pattern> lhs = Apply.getPatterns(rule, SectionType.LHS);
			List<Pattern> rhs = Apply.getPatterns(rule, SectionType.RHS);
			List<Pattern> nac = Apply.getPatterns(rule, SectionType.NAC);
			List<Pattern> pac = Apply.getPatterns(rule, SectionType.PAC);
			
			List<Context> lhsMatches = match.match(lhs, context, this, context.getEnviroment());
			
			List<Context> successfulContexts = new ArrayList<Context>();
			
			for(Context c : lhsMatches) {
				if(checkNAC(c, nac, match)==false) continue;
				if(checkPAC(c,pac,match)==false) continue;
				apply.apply(rhs, lhs, c, this, c.getEnviroment());
				successfulContexts.add(c);
			}
			
			return successfulContexts;
		} catch (Exception e) {
			ConsoleUtil.printToConsole(e.toString(), null, true);
			e.printStackTrace();
			return Collections.EMPTY_LIST;
		}
	}



	public void initVariable(Pattern p, Context context) {
		if(p.getType()==SectionType.LHS || p.getType()==SectionType.RHS) {
			for(Variable v : p.getVariables()) {//��ʼ��
				if(v instanceof VariableWithInit) {
					Object val = this.interprete((VariableWithInit)v, context);
					context.putValue(v, val);
				}
			}
		}
	}



	private boolean checkPAC(Context c, List<Pattern> pac, Match match) {
		for(Pattern np : pac) {
			Context nc = c.newScope();
			nc.setHost(np);
			nc.initWithHost();
			initVariable(np,nc);
			
			List<Context> nacMatches = match.match(pac, nc, this, c.getEnviroment());
			if(nacMatches.isEmpty()) return false;
		}
		return true;
	}



	private boolean checkNAC(Context c, List<Pattern> nac, Match match) {
		for(Pattern np : nac) {
			Context nc = c.newScope();
			nc.setHost(np);
			nc.initWithHost();
			initVariable(np,nc);
			
			List<Context> nacMatches = match.match(nac, nc, this, c.getEnviroment());
			if(nacMatches.isEmpty()==false) return false;
		}
		return true;
	}



	@Override
	public Boolean interprete_edu_ustb_sei_mde_morel_SimpleLinkConstraint(
			SimpleLinkConstraint linkConstraint, Context context) {
		EObject s = (EObject) context.getValue(linkConstraint.getSource());
		EObject t = (EObject) context.getValue(linkConstraint.getTarget());
		EReference ref = linkConstraint.getReference();
		if(ref.isMany()) {
			List<?> list = (List<?>)s.eGet(ref);
			return list.contains(t) && checkLinkOrder(linkConstraint.getId(),s,t,ref,context);
		} else return s.eGet(ref)==t && checkLinkOrder(linkConstraint.getId(),s,t,ref,context);
	}

	private boolean checkLinkOrder(Expression id, EObject s, EObject t,
			EReference ref, Context context) {
		if(id==null) return true;

		Context innerCont = context.newScope();
		PrimitiveVariable var = MorelFactory.eINSTANCE.createPrimitiveVariable();
		var.setName(PredefinedVariable.ID.getLiteral());
		var.setType(EcorePackage.eINSTANCE.getEIntegerObject());
		innerCont.getBindingMap().put(var, OclUndefined.INVALIDED);
		
		try {
			if(ref.isMany()) {
				List<?> col = (List<?>) s.eGet(ref);
				innerCont.putValue(var, (Integer)col.indexOf(t)+1);// 1-based
			} else {
				innerCont.putValue(var, 1);
			}
			
			Object v = interprete(id, innerCont);
			if(v!=Boolean.TRUE) return false;
			
		} catch (Exception e) {
			return false;
		}
		return true;
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
			c.getBindingMap().put(v, OclUndefined.INVALIDED);
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
		if(booleanImpliesExp.getRight()==null) return i;
		
		if(!(i instanceof Boolean)) {
			return OclUndefined.INVALIDED;
		}
		Boolean iv = (Boolean)i;
		
		if(booleanImpliesExp.getRight()!=null) {
			if(iv){
				return this.interprete(booleanImpliesExp.getRight(),context);
			} else 
				return true;
		} else return iv;
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_BooleanOrExp(
			BooleanOrExp booleanOrExp, Context context) {
		int size = booleanOrExp.getOperators().size();
		
		Object result = this.interprete(booleanOrExp.getChildren().get(0), context);
		
		for(int i = 0;i<size;i++) {
			if(result instanceof Boolean) {
				if(result==Boolean.TRUE) return true;
				else {
					Object add = this.interprete(booleanOrExp.getChildren().get(i+1), context);
					result = library.execute("or", result, add);
				}
			} else if(result==OclUndefined.INVALIDED || result==OclUndefined.NULL){
				Object add = this.interprete(booleanOrExp.getChildren().get(i+1), context);
				if(add==Boolean.TRUE) 
					return true;
			} else return OclUndefined.INVALIDED;
		}
		
		return result;
	}

	@Override
	public Object interprete_edu_ustb_sei_mde_morel_BooleanAndExp(
			BooleanAndExp booleanAndExp, Context context) {
		int size = booleanAndExp.getOperators().size();
		
		Object result = this.interprete(booleanAndExp.getChildren().get(0), context);
		
		for(int i = 0;i<size;i++) {
			if(result instanceof Boolean) {
				if(result==Boolean.TRUE) return true;
				else {
					Object add = this.interprete(booleanAndExp.getChildren().get(i+1), context);
					result = library.execute("and", result, add);
				}
			} else if(result==OclUndefined.INVALIDED || result==OclUndefined.NULL){
				Object add = this.interprete(booleanAndExp.getChildren().get(i+1), context);
				if(add==Boolean.FALSE) 
					return false;
			} else return OclUndefined.INVALIDED;
		}
		
		return result;
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
		
		if(relationalExp.getRight()==null) return l;
		
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
	
	

	@SuppressWarnings("unchecked")
	@Override
	public Object interprete_edu_ustb_sei_mde_morel_PredefinedBindExp(
			PredefinedBindExp predefinedBindExp, Context context) {
		// TODO Auto-generated method stub
		if(predefinedBindExp.getSource().getVariable()==PredefinedVariable.ID) {
			//TODO ���ù�ϵ����
			SimpleLinkConstraint link = (SimpleLinkConstraint) predefinedBindExp.eContainer();
			EObject src = (EObject) context.getValue(link.getSource());
			EObject tar = (EObject) context.getValue(link.getTarget());
			
			try {
				Integer i = (Integer)this.interprete(predefinedBindExp.getValueExp(), context);
				if(link.getReference().isMany()) {
					@SuppressWarnings("rawtypes")
					List col = (List)src.eGet(link.getReference());
					if(i>=1&&i<=col.size()) {
						col.add(i-1, tar);
						return true;
					} else return false;
					
				} else {
					if(i==1){
						src.eSet(link.getReference(), tar);
						return true;
					} else return false;
				}
			} catch (Exception e) {
				return false;
			}
			
		} else
			return super.interprete_edu_ustb_sei_mde_morel_PredefinedBindExp(
				predefinedBindExp, context);
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



	@Override
	public Object interprete_edu_ustb_sei_mde_morel_DeclarativeStatement(
			DeclarativeStatement declarativeStatement, Context context) {
		// TODO Auto-generated method stub
		return this.interprete(declarativeStatement.getExpression(), context);
	}



	@Override
	public Object interprete_edu_ustb_sei_mde_morel_UndefinedLiteralExp(
			UndefinedLiteralExp undefinedLiteralExp, Context context) {
		Object value = undefinedLiteralExp.getValue()==UndefinedLiteral.NULL ? null : OclUndefined.INVALIDED;
		return interprete_edu_ustb_sei_mde_morel_CallPathExp(value, undefinedLiteralExp.getPath(), context);
	}



	@Override
	public Object interprete_edu_ustb_sei_mde_morel_TypeLiteralExp(
			TypeLiteralExp typeLiteralExp, Context context) {
		return interprete_edu_ustb_sei_mde_morel_CallPathExp(typeLiteralExp.getValue(), typeLiteralExp.getPath(), context);

	}



	@Override
	public Object interprete_edu_ustb_sei_mde_morel_PredefinedVariableExp(
			PredefinedVariableExp predefinedVariableExp, Context context) {
		Object obj = null;
		String vname = predefinedVariableExp.getVariable().getLiteral();
		for(Entry<Variable,Object> e : context.getBindingMap().entrySet()) {
			if(e.getKey().getName().equals(vname)){
				obj = e.getValue();
				break;
			}
		}
		return interprete_edu_ustb_sei_mde_morel_CallPathExp(obj, predefinedVariableExp.getPath(), context);
	}



	@Override
	public Object interprete_edu_ustb_sei_mde_morel_CollectionLiteralExp(
			CollectionLiteralExp collectionLiteralExp, Context context) {
		// TODO Auto-generated method stub
		CollectionType type = null;
		OclCollection col = null;
		switch(collectionLiteralExp.getType()) {
		case "Set":
			type = MorelFactory.eINSTANCE.createSetType();
			col = new OclSet();
			break;
		case "OrderedSet":
			type = MorelFactory.eINSTANCE.createOrderedSetType();
			col = new OclOrderedSet();
			break;
		case "Sequence":
			type = MorelFactory.eINSTANCE.createSequenceType();
			col = new OclSequence();
			break;
		case "Bag":
			type = MorelFactory.eINSTANCE.createBagType();
			col = new OclBag();
			break;
		default:
			type = MorelFactory.eINSTANCE.createSequenceType();
			col = new OclSequence();
			break;
		}
		col.setType(type);
		
		EClassifier dataType = null;
		
		for(Expression e : collectionLiteralExp.getLiterals()) {
			Object v = this.interprete(e, context);
			col.add(v);
			if(dataType==null) {
				dataType = (EClassifier) library.oclType(v);
				type.setElementType(dataType);
			}
		}
		
		if(dataType==null) {
			col.setType(EcorePackage.eINSTANCE.getEJavaObject());
		}
		
		return interprete_edu_ustb_sei_mde_morel_CallPathExp(col, collectionLiteralExp.getPath(), context);
	}



	@Override
	public Object interprete_edu_ustb_sei_mde_morel_EnumLiteralExp(
			EnumLiteralExp enumLiteralExp, Context context) {
		return interprete_edu_ustb_sei_mde_morel_CallPathExp(enumLiteralExp.getEnumSymbol().getInstance(), enumLiteralExp.getPath(), context);
	}



	@Override
	public Object interprete_edu_ustb_sei_mde_morel_QueryModel(
			QueryModel queryModel, Context context) {
		
		try {
			Context init = context.newScope();
			for(Query query : queryModel.getQueries()) {
				@SuppressWarnings("unchecked")
				List<Context> result = (List<Context>) this.interprete_edu_ustb_sei_mde_morel_Query(query, init);
				
				ConsoleUtil.printToConsole(query.getName(), MorelLaunchConfigurationHelper.MOREL_TITLE, true);
				for(Context c : result){
					ConsoleUtil.printToConsole(c.toString(), MorelLaunchConfigurationHelper.MOREL_TITLE, true);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}



	@Override
	public Object interprete_edu_ustb_sei_mde_morel_TransformationModel(
			TransformationModel transformationModel, Context context) {
		try {
			Context init = context.newScope();
			for(Rule rule : transformationModel.getRules()) {
				List<Context> matches = (List<Context>)this.interprete_edu_ustb_sei_mde_morel_Rule(rule, init);
			}
			ConsoleUtil.printToConsole("Transformation is finished.", MorelLaunchConfigurationHelper.MOREL_TITLE, true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	
}
