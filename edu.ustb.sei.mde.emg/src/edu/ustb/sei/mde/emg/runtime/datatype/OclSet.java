package edu.ustb.sei.mde.emg.runtime.datatype;

import java.util.Collection;

public class OclSet extends OclCollection {

	public OclSet() {
		// TODO Auto-generated constructor stub
	}

	public OclSet(int initialCapacity) {
		super(initialCapacity);
		// TODO Auto-generated constructor stub
	}

	public OclSet(Collection<?> c) {
		super(c);
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		c.retainAll(this);
		return super.addAll(index, c);
	}

	
	
}
