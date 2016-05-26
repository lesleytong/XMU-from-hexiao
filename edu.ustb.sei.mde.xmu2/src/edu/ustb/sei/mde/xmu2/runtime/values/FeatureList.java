package edu.ustb.sei.mde.xmu2.runtime.values;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.mde.xmu2.util.ModelModificationEngine;

public class FeatureList<E> extends ModelList<E> {

	private EObject object;
	public FeatureList(EObject object, EStructuralFeature feature, ModelModificationEngine engine) {
		super();
		this.object = object;
		this.feature = feature;
		this.engine = engine;
	}
	
	private EStructuralFeature feature;
	private ModelModificationEngine engine;

	@Override
	public int size() {
		if(feature.isMany()) {
			@SuppressWarnings("unchecked")
			List<Object> list = (List<Object>)object.eGet(feature);
			return list.size();
		} else {
			if(object.eGet(feature)==null)
				return 0;
			else return 1;
		}
		
	}
	@Override
	public boolean isEmpty() {
		return size()==0;
	}
	@Override
	public boolean contains(Object o) {
		if(feature.isMany()) {
			@SuppressWarnings("unchecked")
			List<Object> list = (List<Object>)object.eGet(feature);
			return list.contains(o);
		} else {
			return (object.eGet(feature)==o);
		}
	}
	
	class SimpleIterator implements Iterator<E>{

		private int index = 0;
		private List<E> list = null;
		
		public SimpleIterator(List<E> e) {
			list = e;
		}
		
		@Override
		public boolean hasNext() {
			return index < list.size();
		}

		@Override
		public E next() {
			E v = list.get(index);
			index++;
			return v;
		}
		
	}
	
	@Override
	public Iterator<E> iterator() {
		return new SimpleIterator(this);
	}
	
	
	
	@Override
	public boolean add(E e) {
		try {
			engine.setFeature(object, feature, e);
			return true;
		} catch(Exception ex) {
			return false;
		}
	}
	@Override
	public boolean remove(Object o) {
		try {
			return engine.deleteLink(object, feature, o);
		} catch(Exception ex) {
			return false;
		}
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		for(E e : c) {
			add(e);
		}
		return true;
	}
	
	
	@Override
	public boolean removeAll(Collection<?> c) {
		for(Object e : c) {
			remove(e);
		}
		return true;
	}
	
	
	
	@Override
	public void clear() {
		while(!isEmpty()) {
			remove(0);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public E get(int index) {
		if(index==-1)
			index = size()-1;
		
		if(index>=0&&index<size()) {
			if(feature.isMany()) {
				List<E> list = (List<E>)object.eGet(feature);
				return list.get(index);
			} else {
				return (E)object.eGet(feature);
			}
		} else 
			throw new ArrayIndexOutOfBoundsException(index);
	}
	
	@Override
	public E set(int index, E element) {
		if(index>=0&&index<size()) {
			E old = get(index);
			if(old.equals(element)) 
				return old;
			
			engine.setFeatureAtIndex(object, feature, element, index);
			
			return old;
		} else 
			throw new ArrayIndexOutOfBoundsException(index);
	}
	@Override
	public void add(int index, E element) {
		if(index==size())
			add(element);
		else if(index>=0 && index<size()) {
			engine.insertFeatureAtIndex(object, feature, element, index);
		} else
			throw new ArrayIndexOutOfBoundsException(index);
	}
	@Override
	public E remove(int index) {
		if(index>=0 && index<size()) {
			E old = get(index);
			
			engine.deleteLink(object, feature, old);
			
			return old;
			
		} else
			throw new ArrayIndexOutOfBoundsException(index);
	}
	@Override
	public int indexOf(Object o) {
		int size = size();
		for(int i = 0 ; i < size ; i++) {
			E e = get(i);
			if(e==o || (e!=null && e.equals(o)))
				return i;
		}
		return -1;
	}
	@Override
	public int lastIndexOf(Object o) {
		int size = size();
		for(int i = size-1 ; i>=0 ; i--) {
			E e = get(i);
			if(e==o || (e!=null && e.equals(o)))
				return i;
		}
		return -1;
	}
}
