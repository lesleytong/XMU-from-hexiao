package edu.ustb.sei.mde.xmu2.runtime.values;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;

/*
 * FeatureSourceList will refresh the source list, 
 * but it will become out-of-date when the source list is changed.
 */
public class FeatureSelectionList<E> implements EList<E> {
	
	private List<E> source;
	private List<Integer> indexes = new UniqueEList<Integer>();
	
	public FeatureSelectionList(List<E> source) {
		super();
		this.source = source;
	}
	
	public void addFromSource(int sourceIndex) {
		indexes.add(sourceIndex);
	}

	@Override
	public int size() {
		return indexes.size();
	}

	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	@Override
	public boolean contains(Object o) {
		return indexes.contains(source.indexOf(o));
	}
	
	class SimpleIterator implements Iterator<E> {

		private FeatureSelectionList<E> list;
		private int id = 0;
		public SimpleIterator(FeatureSelectionList<E> l) {
			list = l;
		}
		
		@Override
		public boolean hasNext() {
			return id < list.size();
		}

		@Override
		public E next() {
			return list.get(id++);
		}
		
	}

	@Override
	public Iterator<E> iterator() {
		return new SimpleIterator(this);
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean add(E e) {
		int oldSize = source.size();
		source.add(e);
		int newSize = source.size();
		
		if(oldSize+1==newSize)
			indexes.add(oldSize);
		
		return oldSize!=newSize;
	}
	
	private void increaseAfter(int id) {
		ListIterator<Integer> it = indexes.listIterator();
		while(it.hasNext()) {
			Integer i = it.next();
			if(i>=id) it.set(i+1);
		}
	}
	
	private void reduceAfter(int id) {
		ListIterator<Integer> it = indexes.listIterator();
		while(it.hasNext()) {
			Integer i = it.next();
			if(i>id) it.set(i-1);
		}
	}

	@Override
	public boolean remove(Object o) {
		int oid = source.indexOf(o);
		int nid = indexes.indexOf(oid);
		
		if(oid==-1 || nid==-1) 
			return false;
		source.remove(oid);
		indexes.remove(nid);
		reduceAfter(nid);
		return true;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		int size = size();
		while(size>0) {
			remove(0);
		}
	}

	@Override
	public E get(int index) {
		return source.get(indexes.get(index));
	}

	@Override
	public E set(int index, E element) {
		return source.set(indexes.get(index), element);
	}

	@Override
	public void add(int index, E element) {
		if(index>size() || index<0) 
			throw new ArrayIndexOutOfBoundsException();
		if(index==size())
			add(element);
		else {
			int originalId = indexes.get(index);
			source.add(originalId,element);
			increaseAfter(originalId);
			indexes.add(index, originalId);
		}
	}

	@Override
	public E remove(int index) {
		int oid = indexes.get(index);
		E e = source.remove(oid);
		indexes.remove(index);
		reduceAfter(oid);
		return e;
	}

	@Override
	public int indexOf(Object o) {
		return indexes.indexOf(source.indexOf(o));
	}

	@Override
	public int lastIndexOf(Object o) {
		return indexes.lastIndexOf(source.lastIndexOf(o));
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
