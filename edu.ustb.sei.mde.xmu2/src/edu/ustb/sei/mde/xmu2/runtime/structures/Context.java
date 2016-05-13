package edu.ustb.sei.mde.xmu2.runtime.structures;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;

import edu.ustb.sei.mde.xmu2.runtime.exceptions.ContextException;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;
import edu.ustb.sei.mde.xmu2.util.AnalysisUtil;
import edu.ustb.sei.mde.xmu2.util.Constants;
import edu.ustb.sei.mde.xmu2.util.EvaluationUtil;
import edu.ustb.sei.mde.xmu2common.DomainTag;
import edu.ustb.sei.mde.xmu2core.Callable;
import edu.ustb.sei.mde.xmu2core.Variable;

public class Context implements Iterable<Entry<Variable,SafeType>>{
	private Environment environment = null;
	private Context outerContext = null;
	private Callable callable = null;
	
	public Environment getEnvironment() {
		return this.environment;
	}
	
	public Callable getCallable() {
		return this.callable;
	}
	
	public void setCallable(Callable p) {
		this.callable = p;
	}
	
	public Context(Environment e) {
		environment = e;
		outerContext = null;
		
		variableNameMap = new HashMap<String, Variable>();
		variableValueMap = new HashMap<Variable, SafeType>();
	}
	
	public Context(Environment e, Context o) {
		this(e);
		outerContext = o;
	}
	
	private Map<String, Variable> variableNameMap;
	private Map<Variable, SafeType> variableValueMap;
	
	public void registerVariable(Variable var, SafeType value) {
		if(variableValueMap.containsKey(var))
			throw new ContextException("the variable "+var.getName()+" has been registered");
		
		variableNameMap.put(var.getName(), var);
		variableValueMap.put(var, value);
	}
	
	public void registerVariable(Variable var) {
		this.registerVariable(var, Constants.UNDEFINED);
	}
	
	public void put(Variable var, SafeType value) {
		SafeType oldValue = variableValueMap.get(var);
		if(oldValue==null) {
			if(outerContext!=null)
				outerContext.put(var, value);
			else
				throw new ContextException("the variable "+var.getName()+" has not been registered");
		} else {
			if(value.isUndefined()) return;
			if(var.getType() instanceof EClass) { 
				if(!value.isNull()) {
					if(!value.isObject()) 
						throw new ContextException("type cast exception: type="+var.getType()+", value="+value);
					else if(AnalysisUtil.isSuperTypeOf(((EClass)var.getType()),value.getObjectValue().eClass())==false)
//						throw new ContextException("type cast exception: type="+var.getType()+", value="+value);
						this.environment.getPrinter().println("type cast exception: type="+var.getType()+", value="+value);
				}
			}
			else if(var.getType() instanceof EDataType) {
				if(AnalysisUtil.isType(var.getType(), String.class)) {
					//value = SafeType.createFromValue(value.getStringValue());
					if(value.isNull()) ;
					else value = SafeType.createFromValue(value.getStringValue());
				} else if(AnalysisUtil.isType(var.getType(), boolean.class)) {
					if(value.isBoolean()==false) 
						throw new ContextException("type cast exception: type="+var.getType()+", value="+value);
				} else if(AnalysisUtil.isType(var.getType(), int.class)) {
					value = SafeType.createFromValue(EvaluationUtil.toInteger(value));
				} else if(AnalysisUtil.isType(var.getType(), double.class)) {
					value = SafeType.createFromValue(EvaluationUtil.toDouble(value));
				} else if(AnalysisUtil.isType(var.getType(), float.class)) {
					value = SafeType.createFromValue(EvaluationUtil.toFloat(value));
				} else if(AnalysisUtil.isType(var.getType(), short.class)) {
					value = SafeType.createFromValue(EvaluationUtil.toShort(value));
				} else if(AnalysisUtil.isType(var.getType(), long.class)) {
					value = SafeType.createFromValue(EvaluationUtil.toLong(value));
				} else if(AnalysisUtil.isType(var.getType(), char.class)) {
					value = SafeType.createFromValue(EvaluationUtil.toCharacter(value));
				} else if(AnalysisUtil.isType(var.getType(), byte.class)) {
					value = SafeType.createFromValue(EvaluationUtil.toByte(value));
				} 
			}
			
			variableValueMap.put(var, value);
			
			// handle correlated variable
			if(callable!=null) {
				if(environment.isForward()) {
					if(var.getTag() == DomainTag.SOURCE) {
						Variable spVar = variableNameMap.get(AnalysisUtil.getUpdatedSourceVariableName(var.getName()));
						if(spVar!=null) variableValueMap.put(spVar, value);
						
					} else if(var.getTag()==DomainTag.UPDATED_SOURCE) {
						Variable sVar = variableNameMap.get(AnalysisUtil.getNonUpdatedSourceVariableName(var.getName()));
						if(sVar!=null) variableValueMap.put(sVar, value);
					}
				} else {
					if(var.getTag()==DomainTag.UPDATED_SOURCE) {
						Variable sVar = variableNameMap.get(AnalysisUtil.getNonUpdatedSourceVariableName(var.getName()));
						if(sVar!=null) {
							if(get(sVar).isUndefined()) {
								Object def = this.getEnvironment().getDefaultSource(value.getValue());
								variableValueMap.put(sVar, SafeType.createFromValue(def));						
							}
						}
					}
				}
			}
		}
	}
	
	public SafeType get(Variable var) {
		if(var==null) return null;
		SafeType val = variableValueMap.get(var);
		if(val==null) {
			if(outerContext!=null)
				return outerContext.get(var);
			else
				throw new ContextException("unregistered variable "+var);
		}
		else return val;
	}
	
	public SafeType get(String varName) {
		Variable v = variableNameMap.get(varName);
		if(v==null) {
			if(outerContext!=null)
				return outerContext.get(varName);
			else 
				throw new ContextException("unregistered variable "+varName);
		} else {
			return variableValueMap.get(v);
		}
	}
	
	public Context createInnerContext() {
		Context in = new Context(this.environment);
		in.outerContext = this;
		in.callable = this.callable;
		return in;
	}
	
	public Context clone() {
		Context clone = new Context(this.environment);
		clone.outerContext = this.outerContext;
		clone.callable = this.callable;
		
		for(String varName : variableNameMap.keySet()) {
			Variable var = variableNameMap.get(varName);
			SafeType val = variableValueMap.get(var);
			clone.registerVariable(var, val);
		}
		
		return clone;
	}
	
	public void resetValue(Variable v) {
		SafeType val = variableValueMap.get(v);
		if(val!=null) {
			variableValueMap.put(v, Constants.UNDEFINED);
		}
	}
	
	public void initFromCallable(Callable p) {
		callable = p;
		for(Variable v : p.getVariables()) {
			this.registerVariable(v);
		}
	}
	
	protected Map<Variable, SafeType> getVariableBindings() {
		return this.variableValueMap;
	}

	public Variable getVariable(String string) {
		Variable v = this.variableNameMap.get(string);
		if(v==null) {
			if(outerContext!=null)
				return outerContext.getVariable(string);
			else
				return null;
		} else
			return v;
	}


	@Override
	public Iterator<Entry<Variable, SafeType>> iterator() {
		return new ContextIterator(this);
	}
	
	class ContextIterator implements Iterator<Entry<Variable, SafeType>> {
		
		private Context currentContext;
		
		public ContextIterator(Context currentContext) {
			super();
			this.initWithContext(currentContext);
		}
		
		private void initWithContext(Context c) {
			this.currentContext = c;
			this.currentIterator = c.getVariableBindings().entrySet().iterator();
		}

		private Iterator<Entry<Variable, SafeType>> currentIterator;

		@Override
		public boolean hasNext() {
			if(currentIterator.hasNext()) return true;
			else {
				if(currentContext.outerContext==null) return false;
				else {
					this.initWithContext(currentContext.outerContext);
					return hasNext();
				}
			}
		}

		@Override
		public Entry<Variable, SafeType> next() {
			return currentIterator.next();
		}
		
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("====");
		builder.append(this.callable.getName());
		builder.append("====\n");
		for(Entry<Variable,SafeType> e : this) {
			builder.append(e.getKey().getName());
			builder.append(":");
			builder.append(e.getKey().getType().getName());
			builder.append(" = ");
			builder.append(e.getValue());
			builder.append("\n");
		}
		return builder.toString();
	}
}
