package edu.ustb.sei.mde.emg.runtime.datatype;

import java.util.Collection;

public class OclSequence extends OclCollection {

	public OclSequence() {
		
	}

	public OclSequence(int initialCapacity) {
		super(initialCapacity);
		
	}

	public OclSequence(Collection<?> c) {
		super(c);
		
	}

}
