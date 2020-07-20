package edu.ustb.sei.mde.query.structure;

import java.util.Arrays;

public class TupleN {
	private Object[] array;
	
	public TupleN(Object... arr) {
		array = arr;
	}
	
	public Object[] getArray() {
		return array;
	}
	
	@Override
	public int hashCode() {
		int code = 0;
		for(Object o : array) {
			code <<= 4;
			code |= o.hashCode() & 0xF;
		}
		return code;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj==null || !(obj instanceof TupleN)) return false;
		if(this==obj) return true;
		TupleN right = (TupleN) obj;
		return Arrays.deepEquals(array, right.array);
	}
}
