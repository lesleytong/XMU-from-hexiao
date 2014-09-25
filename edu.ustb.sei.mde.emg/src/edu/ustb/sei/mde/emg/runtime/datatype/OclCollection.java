package edu.ustb.sei.mde.emg.runtime.datatype;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

public abstract class OclCollection extends ArrayList<Object> {

	private static final long serialVersionUID = -4575258925597003647L;

	public OclCollection() {
		// TODO Auto-generated constructor stub
	}

	public OclCollection(int initialCapacity) {
		super(initialCapacity);
		// TODO Auto-generated constructor stub
	}

	public OclCollection(Collection<?> c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	private EObject type;

	public EObject getType() {
		return type;
	}

	public void setType(EObject type) {
		this.type = type;
	}
}
