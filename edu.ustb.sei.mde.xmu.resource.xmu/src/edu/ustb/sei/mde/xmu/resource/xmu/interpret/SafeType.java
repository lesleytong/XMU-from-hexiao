package edu.ustb.sei.mde.xmu.resource.xmu.interpret;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.mde.xmu.*;

abstract public class SafeType {
	abstract public Object getValue();
	abstract public boolean isValue();
	abstract public boolean isNull();		//空值
	abstract public boolean isInvalid();	//计算出现错误时的返回值，表示无法计算下去
	abstract public boolean isUndefined();	//未知值，未初始化的值
	
	public static SafeType createFromValue(Object v) {
		if(v==null) 
			return Nothing.instance;
		else {
			if(Boolean.TRUE.equals(v)) 
				return (SafeType) Just.TRUE;
			else if(Boolean.FALSE.equals(v)) 
				return (SafeType) Just.FALSE;
			return new Just(v);
		}
	}
	
	public static SafeType getInvalid() {
		return Invalid.instance;
	}
	
	public static SafeType getUndefined() {
		return Undefined.instance;
	}
	public static SafeType wrap(Variable var, Object obj) {
		if(var instanceof PrimitiveVariable) {
			EDataType type = ((PrimitiveVariable) var).getType();
			
			if(type==EcorePackage.eINSTANCE.getEBooleanObject()) {
				if(obj instanceof Boolean) {
					return SafeType.createFromValue((Boolean)obj);
				} else {
					return SafeType.getInvalid();
				}
			} else if(type==EcorePackage.eINSTANCE.getEIntegerObject()) {
				if(obj instanceof Integer) {
					return SafeType.createFromValue((Integer)obj);
				} else {
					return SafeType.getInvalid();
				}
			} else if(type==EcorePackage.eINSTANCE.getEString()) {
				if(obj instanceof String) {
					return SafeType.createFromValue((String)obj);
				} else {
					if(obj == SafeType.getUndefined() || obj==SafeType.getInvalid())
						return SafeType.getInvalid();
					else return SafeType.createFromValue(obj.toString());
				}
			} else {
				return SafeType.createFromValue(obj);
			}
		} else {
			if(obj instanceof EObject)
				return SafeType.createFromValue((EObject)obj);
			return SafeType.getInvalid();
		}
	}
	
	static public Object unwrap(SafeType wvalue) {
		if(wvalue.isInvalid() || wvalue.isUndefined()) return wvalue;
		else return wvalue.getValue();
	}
	

	public static SafeType getNull() {
		
		return Nothing.instance;
	}
	
	public boolean isString() {
		return !isNull() && getValue() instanceof String;
	}
	public String getStringValue() {
		return getValue()==null ? "" : getValue().toString();
	}
	
	public boolean isDouble() {
		return !isNull() && getValue() instanceof Double;
	}
	public Double getDoubleValue() {
		return (Double)getValue();
	}
	
	public boolean isFloat() {
		return !isNull() && getValue() instanceof Float;
	}
	public Float getFloatValue() {
		return (Float)getValue();
	}
	
	public boolean isLong() {
		return !isNull() && getValue() instanceof Long;
	}
	public Long getLongValue() {
		return (Long)getValue();
	}
	
	public boolean isInteger() {
		return !isNull() && getValue() instanceof Integer;
	}
	public Integer getIntegerValue() {
		return (Integer)getValue();
	}
	
	public boolean isShort() {
		return !isNull() &&  getValue() instanceof Short;
	}
	public Short getShortValue() {
		return (Short)getValue();
	}
	
	public boolean isCharacter() {
		return !isNull() && getValue() instanceof Character;
	}
	public Character getCharacterValue() {
		return (Character)getValue();
	}
	
	public boolean isByte() {
		return !isNull() && getValue() instanceof Byte;
	}
	public Byte getByteValue() {
		return (Byte)getValue();
	}
	
	public boolean isBoolean() {
		return !isNull() && getValue() instanceof Boolean;
	}
	public Boolean getBooleanValue() {
		return (Boolean)getValue();
	}
	
	public boolean isObject() {
		return !isNull() && getValue() instanceof EObject;
	}
	public EObject getObjectValue() {
		return (EObject)getValue();
	}
}


class Just extends SafeType {
	
	static public SafeType TRUE = new Just(Boolean.TRUE);
	static public SafeType FALSE = new Just(Boolean.FALSE);
	
	private Object value;
	Just(Object v) {
		value = v;
	}
	@Override
	public Object getValue() {
		return value;
	}
	@Override
	public boolean isValue() {
		
		return true;
	}
	@Override
	public boolean isNull() {
		
		return false;
	}
	@Override
	public boolean isInvalid() {
		
		return false;
	}
	@Override
	public boolean isUndefined() {
		
		return false;
	}
	
	public String toString() {
		return getValue()==null ? "null" : getValue().toString();
	}
}

class Nothing extends SafeType {
	public static Nothing instance = new Nothing();

	@Override
	public Object getValue() {
		
		return null;
	}

	@Override
	public boolean isValue() {
		
		return false;
	}

	@Override
	public boolean isNull() {
		
		return true;
	}

	@Override
	public boolean isInvalid() {
		
		return false;
	}

	@Override
	public boolean isUndefined() {
		
		return false;
	}
	
	public String toString() {
		return "NULL";
	}
}

class Undefined extends SafeType {
	public static Undefined instance = new Undefined();

	@Override
	public Object getValue() {
		
		return null;
	}

	@Override
	public boolean isValue() {
		
		return false;
	}

	@Override
	public boolean isNull() {
		
		return false;
	}

	@Override
	public boolean isInvalid() {
		
		return false;
	}

	@Override
	public boolean isUndefined() {
		
		return true;
	}
	
	public String toString() {
		return "Undefined";
	}
}

class Invalid extends SafeType {
	public static Invalid instance = new Invalid();

	@Override
	public Object getValue() {
		
		return null;
	}

	@Override
	public boolean isValue() {
		
		return false;
	}

	@Override
	public boolean isNull() {
		
		return false;
	}

	@Override
	public boolean isInvalid() {
		
		return true;
	}

	@Override
	public boolean isUndefined() {
		
		return false;
	}
	
	public String toString() {
		return "Invalid";
	}
}
