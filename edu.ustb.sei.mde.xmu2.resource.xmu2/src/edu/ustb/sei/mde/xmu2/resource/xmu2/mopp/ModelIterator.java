package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

import java.util.Iterator;
import java.util.function.Consumer;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class ModelIterator implements Iterator<EObject> {
	
	private EObject root;
	private boolean first;
	private TreeIterator<EObject> iter;
	
	public ModelIterator(EObject o) {
		root = o;
		first = true;
		iter = root.eAllContents();
	}

	@Override
	public boolean hasNext() {
		return (first && root!=null) || (!first && iter!=null && iter.hasNext());
	}

	@Override
	public EObject next() {
		if(first) {
			first = false;
			return root;
		} else {
			return iter.next();
		}
	}
	
	public void forEach(EClass type, Consumer<EObject> action) {
		while(hasNext()) {
			EObject o = next();
			if(type.isSuperTypeOf(o.eClass()))
				action.accept(o);
		}
	}

}
