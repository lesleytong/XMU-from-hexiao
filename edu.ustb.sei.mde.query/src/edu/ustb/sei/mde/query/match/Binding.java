package edu.ustb.sei.mde.query.match;

import java.util.Map;

import edu.ustb.sei.mde.query.structure.ContainerCreator;

public class Binding {
	private Map<Object, Object> bindings;
	
	public Binding() {
		bindings = ContainerCreator.autoMap();
	}
	
	private Binding parent = null;	
	private Binding next = null;
	private Binding prev = null;
	
	public void addBinding(Object key, Object value) {
		bindings.put(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T get(Object key) {
		Object value = bindings.get(key);
		if(value==null && parent!=null) return parent.get(key);
		else return (T) value;
	}
	
	public Binding getParent() {
		return parent;
	}
	

	public void insertBefore(Binding c) {
		if(prev==null) {
			prev = c;
			c.next = this;
			c.prev = null;
		} else {
			c.prev = prev;
			prev.next = c;
			c.next = this;
			prev = c;
		}
		
		c.parent = parent;
	}
	public void insertAfter(Binding c) {
		if(next==null) {
			next = c;
			c.prev = this;
			c.next = null; // clear
		} else {
			c.next = next;
			next.prev = c;
			next = c;
			c.prev = this;
		}
		
		c.parent = parent;
	}
	
	public void remove() {
		if(prev!=null) prev.next = next;
		if(next!=null) next.prev = prev;
		this.parent = null;
		prev=null;
		next=null;
	}
	
	
}
