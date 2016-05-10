package edu.ustb.sei.mde.xmu2.util;


public class Tuple {
	private Object[] elements;
	
	public Tuple(Object...objects) {
		elements = objects;
	}
	
	public Object[] getElements() {
		return elements;
	}
	
	final static int[] PRIME = {0, 0xFFFF, 0xFF, 0xFF, 0xF};
	
	public int hashCode() {
		int prime = 0xFFFF;

		if(elements.length==0) return 0;
		else if(elements.length<5) prime = PRIME[elements.length-1];
		else prime = PRIME[4];
		
		int result = 0;
		
		for(Object o : elements) {
			result = prime * result + ((o==null) ? 0 : o.hashCode()); 
		}
		
		return result;
	}
	
	public boolean equals(Object o) {
		if(o==null || !(o instanceof Tuple)) 
			return false;
		
		Tuple t = (Tuple) o;
		
		if(elements.length!=t.elements.length) 
			return false;
		
		for (int i = 0; i< elements.length; i++ ) {
			if(elements[i]==null) {
				if(t.elements[i]!=null) return false;
			} else {
				if(elements[i].equals(t.elements[i])==false) return false;
			}
		}
		
		return true;
	}

	public Object get(int j) {
		return elements[j];
	}
}
