package edu.ustb.sei.mde.xmu.resource.xmu.interpret;

import edu.ustb.sei.mde.xmu.AdditiveOperator;
import edu.ustb.sei.mde.xmu.MultiplicativeOperator;

public class EvaluationUtil {
	static public SafeType additive(AdditiveOperator oper, SafeType left, SafeType right) {
		if(left.isUndefined() && right.isUndefined()) return SafeType.getInvalid();
		else if(left.isUndefined() || right.isUndefined()) left = SafeType.getUndefined();
		else if(left.isInvalid() || right.isInvalid()) return SafeType.getInvalid();
		
		
		if(left.isString() || right.isString()) {
			String ls = left.isNull()?"":left.getStringValue();
			String rs = right.isNull()?"":right.getStringValue();
			
			if(oper==AdditiveOperator.ADD) return SafeType.createFromValue(ls+rs);
			return SafeType.getInvalid();
			
		} else {
			if(left.isNull() || right.isNull()) return SafeType.getInvalid();
			
			if(left.isDouble() || right.isDouble()) {
				Double ld = toDouble(left);
				Double rd = toDouble(right);
				
				if(oper==AdditiveOperator.ADD)
					return SafeType.createFromValue(ld+rd);
				else 
					return SafeType.createFromValue(ld-rd);
			} else if(left.isFloat() || right.isFloat()) {
				Float ld = toFloat(left);
				Float rd = toFloat(right);
				
				if(oper==AdditiveOperator.ADD)
					return SafeType.createFromValue(ld+rd);
				else 
					return SafeType.createFromValue(ld-rd);
			} else if(left.isLong() || right.isLong()) {
				Long ld = toLong(left);
				Long rd = toLong(right);
				
				if(oper==AdditiveOperator.ADD)
					return SafeType.createFromValue(ld+rd);
				else 
					return SafeType.createFromValue(ld-rd);
			} else if(left.isInteger() || right.isInteger()) {
				Integer ld = toInteger(left);
				Integer rd = toInteger(right);
				
				if(oper==AdditiveOperator.ADD)
					return SafeType.createFromValue(ld+rd);
				else 
					return SafeType.createFromValue(ld-rd);
			} else if(left.isCharacter() || right.isCharacter()) {
				Character ld = toCharacter(left);
				Character rd = toCharacter(right);
				
				if(oper==AdditiveOperator.ADD)
					return SafeType.createFromValue(ld+rd);
				else 
					return SafeType.createFromValue(ld-rd);
			} else if(left.isByte() || right.isByte()) {
				Byte ld = toByte(left);
				Byte rd = toByte(right);
				
				if(oper==AdditiveOperator.ADD)
					return SafeType.createFromValue(ld+rd);
				else 
					return SafeType.createFromValue(ld-rd);
			} else {
				return SafeType.getInvalid();
			}
		}
	}
	
	static public SafeType mutiplicative(MultiplicativeOperator oper, SafeType left, SafeType right) {
		if(left.isUndefined() && right.isUndefined()) return SafeType.getInvalid();
		else if(left.isUndefined() || right.isUndefined()) left = SafeType.getUndefined();
		else if(left.isInvalid() || right.isInvalid()) return SafeType.getInvalid();
		
		if(left.isString() || right.isString()) {
			return SafeType.getInvalid();
			
		} else {
			if(left.isNull() || right.isNull()) return SafeType.getInvalid();
			
			if(left.isDouble() || right.isDouble()) {
				Double ld = toDouble(left);
				Double rd = toDouble(right);
				
				if(oper==MultiplicativeOperator.MUL)
					return SafeType.createFromValue(ld*rd);
				else 
					return SafeType.createFromValue(ld/rd);
			} else if(left.isFloat() || right.isFloat()) {
				Float ld = toFloat(left);
				Float rd = toFloat(right);
				
				if(oper==MultiplicativeOperator.MUL)
					return SafeType.createFromValue(ld*rd);
				else 
					return SafeType.createFromValue(ld/rd);
			} else if(left.isLong() || right.isLong()) {
				Long ld = toLong(left);
				Long rd = toLong(right);
				
				if(oper==MultiplicativeOperator.MUL)
					return SafeType.createFromValue(ld*rd);
				else 
					return SafeType.createFromValue(ld/rd);
			} else if(left.isInteger() || right.isInteger()) {
				Integer ld = toInteger(left);
				Integer rd = toInteger(right);
				
				if(oper==MultiplicativeOperator.MUL)
					return SafeType.createFromValue(ld*rd);
				else 
					return SafeType.createFromValue(ld/rd);
			} else if(left.isCharacter() || right.isCharacter()) {
				Character ld = toCharacter(left);
				Character rd = toCharacter(right);
				
				if(oper==MultiplicativeOperator.MUL)
					return SafeType.createFromValue(ld*rd);
				else 
					return SafeType.createFromValue(ld/rd);
			} else if(left.isByte() || right.isByte()) {
				Byte ld = toByte(left);
				Byte rd = toByte(right);
				
				if(oper==MultiplicativeOperator.MUL)
					return SafeType.createFromValue(ld*rd);
				else 
					return SafeType.createFromValue(ld/rd);
			} else {
				return SafeType.getInvalid();
			}
		}
	}
	
	static public SafeType less(SafeType left, SafeType right) {
		if(left.isUndefined() && right.isUndefined()) return SafeType.getInvalid();
		else if(left.isUndefined() || right.isUndefined()) return SafeType.getUndefined();
		else if(left.isInvalid() || right.isInvalid()) return SafeType.getInvalid();
		else if(left.isNull() || right.isNull()) return SafeType.getInvalid();
		
		if(left.isString() || right.isString()) {
			String ls = left.getStringValue();
			String rs = right.getStringValue();
			
			if(ls.compareTo(rs)<0) return Just.TRUE;
			return Just.FALSE;
		} else {
			//if(left.isNull() || right.isNull()) return SafeType.getInvalid();
			
			if(left.isDouble() || right.isDouble()) {
				Double ld = toDouble(left);
				Double rd = toDouble(right);
				
				
				return SafeType.createFromValue(ld<rd);
			} else if(left.isFloat() || right.isFloat()) {
				Float ld = toFloat(left);
				Float rd = toFloat(right);
				
				
				return SafeType.createFromValue(ld<rd);
			} else if(left.isLong() || right.isLong()) {
				Long ld = toLong(left);
				Long rd = toLong(right);
				
				
				return SafeType.createFromValue(ld<rd);
			} else if(left.isInteger() || right.isInteger()) {
				Integer ld = toInteger(left);
				Integer rd = toInteger(right);
				
				
				return SafeType.createFromValue(ld<rd);
			} else if(left.isCharacter() || right.isCharacter()) {
				Character ld = toCharacter(left);
				Character rd = toCharacter(right);
				
				
				return SafeType.createFromValue(ld<rd);
			} else if(left.isByte() || right.isByte()) {
				Byte ld = toByte(left);
				Byte rd = toByte(right);
				
				
				return SafeType.createFromValue(ld<rd);
			} else {
				return SafeType.getInvalid();
			}
		}
	}
	
	static public SafeType lessOrEqual(SafeType left, SafeType right) {
		if(left.isUndefined() && right.isUndefined()) return SafeType.getInvalid();
		else if(left.isUndefined() || right.isUndefined()) return SafeType.getUndefined();
		else if(left.isInvalid() || right.isInvalid()) return SafeType.getInvalid();
		else if(left.isNull() && right.isNull()) return Just.TRUE;
		else if(left.isNull() || right.isNull()) return Just.getInvalid();
		
		if(left.isString() || right.isString()) {
			String ls = left.getStringValue();
			String rs = right.getStringValue();
			
			if(ls.compareTo(rs)<=0) return Just.TRUE;
			return Just.FALSE;
		} else {
			if(left.isNull() || right.isNull()) return SafeType.getInvalid();
			
			if(left.isDouble() || right.isDouble()) {
				Double ld = toDouble(left);
				Double rd = toDouble(right);
				
				
				return SafeType.createFromValue(ld<=rd);
			} else if(left.isFloat() || right.isFloat()) {
				Float ld = toFloat(left);
				Float rd = toFloat(right);
				
				
				return SafeType.createFromValue(ld<=rd);
			} else if(left.isLong() || right.isLong()) {
				Long ld = toLong(left);
				Long rd = toLong(right);
				
				
				return SafeType.createFromValue(ld<=rd);
			} else if(left.isInteger() || right.isInteger()) {
				Integer ld = toInteger(left);
				Integer rd = toInteger(right);
				
				
				return SafeType.createFromValue(ld<=rd);
			} else if(left.isCharacter() || right.isCharacter()) {
				Character ld = toCharacter(left);
				Character rd = toCharacter(right);
				
				
				return SafeType.createFromValue(ld<=rd);
			} else if(left.isByte() || right.isByte()) {
				Byte ld = toByte(left);
				Byte rd = toByte(right);
				
				
				return SafeType.createFromValue(ld<=rd);
			} else {
				return SafeType.getInvalid();
			}
		}
	}
	
	static public SafeType greater(SafeType left, SafeType right) {
		if(left.isUndefined() && right.isUndefined()) return SafeType.getInvalid();
		else if(left.isUndefined() || right.isUndefined()) return SafeType.getUndefined();
		else if(left.isInvalid() || right.isInvalid()) return SafeType.getInvalid();
		//else if(left.isNull() && right.isNull()) return Just.TRUE;
		else if(left.isNull() || right.isNull()) return Just.getInvalid();
		
		if(left.isString() || right.isString()) {
			String ls = left.getStringValue();
			String rs = right.getStringValue();
			
			//if(ls==null || rs==null) return SafeType.getInvalid();
			if(ls.compareTo(rs)>0) return Just.TRUE;
			return Just.FALSE;
		} else {
			//if(left.isNull() || right.isNull()) return SafeType.getInvalid();
			
			if(left.isDouble() || right.isDouble()) {
				Double ld = toDouble(left);
				Double rd = toDouble(right);
				
				
				return SafeType.createFromValue(ld>rd);
			} else if(left.isFloat() || right.isFloat()) {
				Float ld = toFloat(left);
				Float rd = toFloat(right);
				
				
				return SafeType.createFromValue(ld>rd);
			} else if(left.isLong() || right.isLong()) {
				Long ld = toLong(left);
				Long rd = toLong(right);
				
				
				return SafeType.createFromValue(ld>rd);
			} else if(left.isInteger() || right.isInteger()) {
				Integer ld = toInteger(left);
				Integer rd = toInteger(right);
				
				
				return SafeType.createFromValue(ld>rd);
			} else if(left.isCharacter() || right.isCharacter()) {
				Character ld = toCharacter(left);
				Character rd = toCharacter(right);
				
				
				return SafeType.createFromValue(ld>rd);
			} else if(left.isByte() || right.isByte()) {
				Byte ld = toByte(left);
				Byte rd = toByte(right);
				
				
				return SafeType.createFromValue(ld>rd);
			} else {
				return SafeType.getInvalid();
			}
		}
	}
	
	static public SafeType minus(SafeType operand) {
		if(operand.isInvalid() || operand.isUndefined()) return operand;
		if(operand.isNull()) return SafeType.getInvalid();
		
		if(operand.isDouble()) {
			return SafeType.createFromValue(-operand.getDoubleValue());
		} else if(operand.isFloat()) {
			return SafeType.createFromValue(-operand.getFloatValue());
		} else if(operand.isLong()) {
			return SafeType.createFromValue(-operand.getLongValue());
		} else if(operand.isInteger()) {
			return SafeType.createFromValue(-operand.getIntegerValue());
		} else if(operand.isCharacter()) {
			return SafeType.createFromValue(-operand.getCharacterValue());
		} else if(operand.isByte()) {
			return SafeType.createFromValue(-operand.getByteValue());
		} else 
			return SafeType.getInvalid();
	}
	
	static public SafeType not(SafeType operand) {
		if(operand.isInvalid() || operand.isUndefined()) return operand;
		if(operand.isNull()) return SafeType.getInvalid();

		if(operand.isBoolean()) 
			return SafeType.createFromValue(!operand.getBooleanValue());
		else return SafeType.getInvalid();
	}
	
	static public SafeType greaterOrEqual(SafeType left, SafeType right) {
		if(left.isUndefined() && right.isUndefined()) return SafeType.getInvalid();
		else if(left.isUndefined() || right.isUndefined()) return SafeType.getUndefined();
		else if(left.isInvalid() || right.isInvalid()) return SafeType.getInvalid();
		else if(left.isNull() && right.isNull()) return Just.TRUE;
		else if(left.isNull() || right.isNull()) return Just.getInvalid();
		
		if(left.isString() || right.isString()) {
			String ls = left.getStringValue();
			String rs = right.getStringValue();
			
			//if(ls==null || rs==null) return SafeType.getInvalid();
			if(ls.compareTo(rs)>=0) return Just.TRUE;
			return Just.FALSE;
		} else {
			//if(left.isNull() || right.isNull()) return SafeType.getInvalid();
			
			if(left.isDouble() || right.isDouble()) {
				Double ld = toDouble(left);
				Double rd = toDouble(right);
				
				
				return SafeType.createFromValue(ld>=rd);
			} else if(left.isFloat() || right.isFloat()) {
				Float ld = toFloat(left);
				Float rd = toFloat(right);
				
				
				return SafeType.createFromValue(ld>=rd);
			} else if(left.isLong() || right.isLong()) {
				Long ld = toLong(left);
				Long rd = toLong(right);
				
				
				return SafeType.createFromValue(ld>=rd);
			} else if(left.isInteger() || right.isInteger()) {
				Integer ld = toInteger(left);
				Integer rd = toInteger(right);
				
				
				return SafeType.createFromValue(ld>=rd);
			} else if(left.isCharacter() || right.isCharacter()) {
				Character ld = toCharacter(left);
				Character rd = toCharacter(right);
				
				
				return SafeType.createFromValue(ld>=rd);
			} else if(left.isByte() || right.isByte()) {
				Byte ld = toByte(left);
				Byte rd = toByte(right);
				
				
				return SafeType.createFromValue(ld>=rd);
			} else {
				return SafeType.getInvalid();
			}
		}
	}

	public static Byte toByte(SafeType left) {
		if(left.isDouble()) return left.getDoubleValue().byteValue();
		else if(left.isFloat()) return left.getFloatValue().byteValue();
		else if(left.isLong()) return left.getLongValue().byteValue();
		else if(left.isInteger()) return left.getIntegerValue().byteValue();
		else if(left.isCharacter()) return (byte)left.getCharacterValue().charValue();
		else if(left.isByte()) return left.getByteValue();
		else if(left.isBoolean()) return (byte)((left.getBooleanValue() ? 1 : 0));
		else return null;
	}

	public static Character toCharacter(SafeType left) {
		if(left.isDouble()) return (char)left.getDoubleValue().intValue();
		else if(left.isFloat()) return (char)left.getFloatValue().intValue();
		else if(left.isLong()) return (char)left.getLongValue().intValue();
		else if(left.isInteger()) return (char)left.getIntegerValue().intValue();
		else if(left.isCharacter()) return left.getCharacterValue().charValue();
		else if(left.isByte()) return (char)left.getByteValue().intValue();
		else if(left.isBoolean()) return (char)(left.getBooleanValue() ? 1 : 0);
		else return null;
	}

	public static Integer toInteger(SafeType left) {
		if(left.isDouble()) return left.getDoubleValue().intValue();
		else if(left.isFloat()) return left.getFloatValue().intValue();
		else if(left.isLong()) return left.getLongValue().intValue();
		else if(left.isInteger()) return left.getIntegerValue();
		else if(left.isCharacter()) return (int)left.getCharacterValue().charValue();
		else if(left.isByte()) return left.getByteValue().intValue();
		else if(left.isBoolean()) return left.getBooleanValue() ? 1 : 0;
		else return null;
	}

	public static Long toLong(SafeType left) {
		if(left.isDouble()) return left.getDoubleValue().longValue();
		else if(left.isFloat()) return left.getFloatValue().longValue();
		else if(left.isLong()) return left.getLongValue();
		else if(left.isInteger()) return left.getIntegerValue().longValue();
		else if(left.isCharacter()) return (long)left.getCharacterValue().charValue();
		else if(left.isByte()) return left.getByteValue().longValue();
		else if(left.isBoolean()) return left.getBooleanValue() ? 1l : 0l;
		else return null;
	}

	public static Float toFloat(SafeType left) {
		if(left.isDouble()) return left.getDoubleValue().floatValue();
		else if(left.isFloat()) return left.getFloatValue();
		else if(left.isLong()) return left.getLongValue().floatValue();
		else if(left.isInteger()) return left.getIntegerValue().floatValue();
		else if(left.isCharacter()) return (float)left.getCharacterValue().charValue();
		else if(left.isByte()) return left.getByteValue().floatValue();
		else if(left.isBoolean()) return left.getBooleanValue() ? 1.0f : 0.0f;
		else return null;
	}

	public static Double toDouble(SafeType left) {
		if(left.isDouble()) return left.getDoubleValue();
		else if(left.isFloat()) return left.getFloatValue().doubleValue();
		else if(left.isLong()) return left.getLongValue().doubleValue();
		else if(left.isInteger()) return left.getIntegerValue().doubleValue();
		else if(left.isCharacter()) return (double)left.getCharacterValue().charValue();
		else if(left.isByte()) return left.getByteValue().doubleValue();
		else if(left.isBoolean()) return left.getBooleanValue() ? 1.0 : 0.0;
		else return null;
	}
}
