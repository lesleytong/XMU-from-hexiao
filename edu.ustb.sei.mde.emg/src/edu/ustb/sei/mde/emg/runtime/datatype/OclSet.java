package edu.ustb.sei.mde.emg.runtime.datatype;

import java.util.Collection;

public class OclSet extends OclCollection {

	public OclSet() {
		
	}

	public OclSet(int initialCapacity) {
		super(initialCapacity);
		
	}

	public OclSet(Collection<?> c) {
		super(c.size());
		this.addAll(c);
	}

	@Override
	public boolean add(Object e) {
		if(this.contains(e)) return false;
		return super.add(e);
	}

	@Override
	public void add(int index, Object element) {
		if(this.contains(element)) return;
		super.add(index, element);
	}

	@Override
	public boolean addAll(Collection<?> c) {
		c.retainAll(this);
		return super.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<?> c) {
		
		c.retainAll(this);
		return super.addAll(index, c);
	}	
}
