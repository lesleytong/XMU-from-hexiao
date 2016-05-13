package edu.ustb.sei.mde.xmu2.runtime.values;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

public interface SafeType {
	
	final static Map<Object, SafeType> primitiveValueMap = new HashMap<Object, SafeType>();
	
	public Object getValue();
	static public SafeType createFromValue(Object value) {
		if(value==null) return NULL;
		else if(value.equals(Boolean.TRUE)) return TRUE;
		else if(value.equals(Boolean.FALSE)) return FALSE;
		else {
			if(value instanceof Integer
					|| value instanceof Long
					|| value instanceof Double
					|| value instanceof Short
					|| value instanceof Byte
					|| value instanceof Character) {
				SafeType val = primitiveValueMap.get(value);
				if(val==null) {
					val = new Just(value);
					primitiveValueMap.put(value, val);
				}
				return val;
			}
			else 
				return new Just(value);
		}
	}
	
	final static public SafeType TRUE = new Just(true);
	final static public SafeType FALSE = new Just(false);
	final static public SafeType NULL = new Nothing();
	final static public SafeType UNDEFINED = new Nothing();
	
	default public boolean isUndefined() {
		return this==UNDEFINED;
	}
	
	default public boolean isString() {
		return !isNull() && getValue() instanceof String;
	}
	default public String getStringValue() {
		return getValue()==null ? "" : getValue().toString();
	}
	
	default public boolean isDouble() {
		return !isNull() && getValue() instanceof Double;
	}
	
	default public Double getDoubleValue() {
		return (Double)getValue();
	}
	
	default public boolean isFloat() {
		return !isNull() && getValue() instanceof Float;
	}
	
	default public Float getFloatValue() {
		return (Float)getValue();
	}
	
	default public boolean isLong() {
		return !isNull() && getValue() instanceof Long;
	}
	
	default public Long getLongValue() {
		return (Long)getValue();
	}
	
	default public boolean isInteger() {
		return !isNull() && getValue() instanceof Integer;
	}
	
	default public Integer getIntegerValue() {
		return (Integer)getValue();
	}
	
	default public boolean isShort() {
		return !isNull() &&  getValue() instanceof Short;
	}
	
	default public Short getShortValue() {
		return (Short)getValue();
	}
	
	default public boolean isCharacter() {
		return !isNull() && getValue() instanceof Character;
	}
	default public Character getCharacterValue() {
		return (Character)getValue();
	}
	
	default public boolean isByte() {
		return !isNull() && getValue() instanceof Byte;
	}
	default public Byte getByteValue() {
		return (Byte)getValue();
	}
	
	default public boolean isBoolean() {
		return !isNull() && getValue() instanceof Boolean;
	}
	default public Boolean getBooleanValue() {
		return (Boolean)getValue();
	}
	
	default public boolean isObject() {
		return !isNull() && getValue() instanceof EObject;
	}
	default public EObject getObjectValue() {
		return (EObject)getValue();
	}
	
	default boolean isNull() {
		return this==NULL;
	}
}

class Just implements SafeType{

	final private Object value;
	Just(Object value) {
		super();
		this.value = value;
	}
	public int hashCode() {
		return value.hashCode();
	}
	
	public boolean equals(Object o) {
		if(o==null) return false;
		if(this==o) return true;
		if(o instanceof Just) {
			SafeType rv = (SafeType) o;
			if(this.value==rv.getValue()) return true;
			if(this.value!=null && this.value.equals(rv.getValue())) return true;
		}
		return false;
	}
	@Override
	public Object getValue() {
		return value;
	}
	
	public String toString() {
		return "#("+value+")";
	}
}

class Nothing implements SafeType {
	@Override
	public Object getValue() {
		return null;
	}
	
	public String toString() {
		if(this== UNDEFINED) 
			return "#(UNDEFINED)";
		else 
			return "#(NULL)";
	}
}
