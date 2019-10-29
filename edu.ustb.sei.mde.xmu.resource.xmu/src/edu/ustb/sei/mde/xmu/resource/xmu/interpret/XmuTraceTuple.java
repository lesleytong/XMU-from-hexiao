package edu.ustb.sei.mde.xmu.resource.xmu.interpret;
import java.util.Collections;
import java.util.List;

public class XmuTraceTuple {
	final static public XmuTraceTuple ANY_TUPLE = new XmuTraceAnyTuple();
	final static public XmuTraceTuple NULL_TUPLE = new XmuTraceTuple(Collections.emptyList());
	
	public Object get(int i) {
		return elements[i];
	}
	
	static public XmuTraceTuple createTupleFromArray(Object... argv) {
		XmuTraceTuple r = new XmuTraceTuple(argv);
		return r;
	}
	static public XmuTraceTuple createTuple(List<?> list) {
		if(list==null) return NULL_TUPLE;
		return new XmuTraceTuple(list);
	}
	
	static public XmuTraceTuple getAnyTuple() {
		return ANY_TUPLE;
	}
	
	private Object[] elements;
	protected XmuTraceTuple(List<?> list) {
		elements = new Object[list.size()];
		for(int i=0;i<list.size();i++) {
			Object o = list.get(i);
			elements[i] = o;
		}
	}
	
	protected XmuTraceTuple(Object... argv) {
		if(argv==null) elements = new Object[0];
		else elements = argv;
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
		if(o==null || !(o instanceof XmuTraceTuple)) 
			return false;
		
		XmuTraceTuple t = (XmuTraceTuple) o;
		
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
}

class XmuTraceAnyTuple extends XmuTraceTuple {

	protected XmuTraceAnyTuple() {
		super(Collections.emptyList());
	}
	
	public int hashCode() {		
		return 0;
	}
	
	public boolean equals(Object o) {
		return this==o;
	}
}
