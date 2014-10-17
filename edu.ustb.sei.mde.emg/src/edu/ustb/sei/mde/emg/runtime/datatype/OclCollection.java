package edu.ustb.sei.mde.emg.runtime.datatype;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.morel.BagType;
import edu.ustb.sei.mde.morel.CollectionType;
import edu.ustb.sei.mde.morel.OrderedSetType;
import edu.ustb.sei.mde.morel.SequenceType;
import edu.ustb.sei.mde.morel.SetType;

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
	
	public static OclCollection createCollection(CollectionType type) {
		OclCollection col = null;
		if(type instanceof SetType) {
			col = new OclSet();
		} else if(type instanceof BagType) {
			col = new OclBag();
		} else if(type instanceof SequenceType) {
			col = new OclSequence();
		} else if(type instanceof OrderedSetType) {
			col = new OclOrderedSet();
		}
		col.setType(type);
		return col;
	}
}
