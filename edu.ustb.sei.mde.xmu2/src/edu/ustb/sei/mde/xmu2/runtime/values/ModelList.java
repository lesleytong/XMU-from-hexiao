package edu.ustb.sei.mde.xmu2.runtime.values;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.mde.xmu2.util.ModelModificationEngine;

@SuppressWarnings("unchecked")
abstract public class ModelList<E> implements EList<E> {
	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}
	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}
	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}
	@Override
	public ListIterator<E> listIterator() {
		throw new UnsupportedOperationException();
	}
	@Override
	public ListIterator<E> listIterator(int index) {
		throw new UnsupportedOperationException();
	}
	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}
	@Override
	public void move(int newPosition, E object) {
		throw new UnsupportedOperationException();
	}
	@Override
	public E move(int newPosition, int oldPosition) {
		throw new UnsupportedOperationException();
	}
}
