package edu.ustb.sei.mde.xmu.resource.xmu.interpret;

import java.util.HashMap;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.mde.xmu.*;
import edu.ustb.sei.mde.xmu.resource.xmu.analysis.Util;

public class XmuContext {
	private HashMap<Variable,SafeType> varBindings = new HashMap<Variable,SafeType>();
	private XmuEnvironment environment;
	private Rule rule;
	private XmuContext outerContext = null;
	
	public XmuContext createInnerContext(Variable... vars) {
		XmuContext inner = new XmuContext(this.getEnvironment());
		inner.outerContext = this;
		for(Variable v : vars)
			inner.varBindings.put(v, SafeType.getUndefined());
		return inner;
	}
	
	public HashMap<Variable,SafeType> getBindings() {
		return varBindings;
	}
	
	public XmuContext getCopy() {
		XmuContext copy = new XmuContext(this.getEnvironment());
		copy.initFromRule(this.rule);
		
		for(Entry<Variable,SafeType> entry : varBindings.entrySet()) {
			copy.putValue(entry.getKey(), entry.getValue());
		}
		
		copy.outerContext = this.outerContext;
		
		return copy;
	}
	
	public XmuContext(XmuEnvironment env) {
		super();
		environment = env;
	}
	
	public XmuEnvironment getEnvironment() {
		return environment;
	}
	
	public void initFromRule(Rule rule) {
		this.rule = rule;
		
		for(Variable v : rule.getNVars()) {
			varBindings.put(v, SafeType.getUndefined());
		}
		for(Variable v : rule.getSVars()) {
			varBindings.put(v, SafeType.getUndefined());
		}
		for(Variable v : rule.getVVars()) {
			varBindings.put(v, SafeType.getUndefined());
		}
		for(Variable v : rule.getSpVars()) {
			varBindings.put(v, SafeType.getUndefined());
		}
	}
	
	public Variable getVariable(String name) {
		for(Entry<Variable,SafeType> e : varBindings.entrySet()) {
			if(e.getKey().getName().equals(name)) return e.getKey();
		}
		
		if(outerContext!=null) return outerContext.getVariable(name);
		else return null;
	}
	
	public SafeType getSafeTypeValue(Variable var) {
		if(var==null) return SafeType.getInvalid();
		SafeType r = varBindings.get(var);
		
		if(r==null) {
			if(outerContext==null) return SafeType.getInvalid();
			else return outerContext.getSafeTypeValue(var);
		} else return r;
//		return r==null ? SafeType.getInvalid() : r;
	}
	
	@Deprecated
	public Object getValue(Variable var) {
		return SafeType.unwrap(varBindings.get(var));
	}
	
	public boolean putValue(Variable var, SafeType value) {
		if(var==null) 
			throw new RuntimeException("key is null");
		if(value==SafeType.getInvalid()) return false;
		
		if(varBindings.keySet().contains(var)) {
			//type check and conversion
			if(var instanceof ObjectVariable && !value.isNull() && !value.isObject()) return false;
			else if(var instanceof PrimitiveVariable) {
				if(value.isUndefined()) 
					return true;
				if(((PrimitiveVariable) var).getType() == EcorePackage.eINSTANCE.getEString()) {
					//value = SafeType.createFromValue(value.getStringValue());
					if(value.isNull()) ;
					else value = SafeType.createFromValue(value.getStringValue());
				} else if(((PrimitiveVariable) var).getType() == EcorePackage.eINSTANCE.getEBooleanObject()) {
					if(value.isBoolean()==false) return false;
				} else if(((PrimitiveVariable) var).getType() == EcorePackage.eINSTANCE.getEIntegerObject()) {
					value = SafeType.createFromValue(EvaluationUtil.toInteger(value));
				} else if(((PrimitiveVariable) var).getType() == EcorePackage.eINSTANCE.getEDoubleObject()) {
					value = SafeType.createFromValue(EvaluationUtil.toDouble(value));
				} else if(((PrimitiveVariable) var).getType() == EcorePackage.eINSTANCE.getEFloatObject()) {
					value = SafeType.createFromValue(EvaluationUtil.toFloat(value));
//				} else if(((PrimitiveVariable) var).getType() == EcorePackage.eINSTANCE.getEShortObject()) {
//					return false;
				} else if(((PrimitiveVariable) var).getType() == EcorePackage.eINSTANCE.getELongObject()) {
					value = SafeType.createFromValue(EvaluationUtil.toLong(value));
				} else if(((PrimitiveVariable) var).getType() == EcorePackage.eINSTANCE.getECharacterObject()) {
					value = SafeType.createFromValue(EvaluationUtil.toCharacter(value));
				} else if(((PrimitiveVariable) var).getType() == EcorePackage.eINSTANCE.getEByteObject()) {
					value = SafeType.createFromValue(EvaluationUtil.toByte(value));
				}
			}
			
			varBindings.put(var, value);
			if(rule!=null) {
				if(environment.isForward()) {
					if(rule.getSVars().contains(var)) {
						Variable spV = getVariable(var.getName()+Util.POST_FLAG);
						if(spV!=null) varBindings.put(spV, value);				
					} else if(rule.getSpVars().contains(var)) {
						Variable sv = getVariable(var.getName().substring(0, var.getName().length()-Util.POST_LENGTH));
						if(sv!=null) varBindings.put(sv, value);
					}
				} else {
					if(rule.getSpVars().contains(var)) {
						Variable sv = getVariable(var.getName().substring(0, var.getName().length()-Util.POST_LENGTH));
						if(sv!=null) {
							if(getSafeTypeValue(sv).isUndefined()) {
								EObject def = this.getEnvironment().getTrace().getSource(value.getObjectValue());
								varBindings.put(sv, SafeType.createFromValue(def));						
							}
						}
					}
				}
			}
			return true;
		} else {
			if(outerContext==null) {
				return false;
			} else {
				return outerContext.putValue(var, value);
			}
		}
		
		
	}
	
//	public boolean containValue(EObject v) {
//		if(v==null) return false;
//		for(Entry<Variable,SafeType> e : varBindings.entrySet()) {
//			if(e.getValue()!=null && v.equals(e.getValue().getValue())) return true;
//		}
//		return false;
//	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("====");
		sb.append(rule.getName());
		sb.append("====\n");
		
		for(Entry<Variable,SafeType> e : varBindings.entrySet()) {
			sb.append(e.getKey().getName());
			sb.append(" ::= ");
			sb.append(e.getValue().toString());
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
