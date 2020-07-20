package edu.ustb.sei.mde.query.structure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


/**
 * A composite collection is a composition of a list of collections
 * A composite collection does not copy subcollections.
 * Whenever there is a change, it does not have to be updated if its subcollections are properly updated.
 * 
 * At present, it may not support parallel stream API
 * @author hexiao
 *
 * @param <E>
 */
public class CompositeCollection<E> implements Collection<E> {
	public CompositeCollection(List<Collection<E>> collections) {
		super();
		this.collections = collections;
	}
	
	public CompositeCollection(Stream<Collection<E>> collections) {
		this.collections = new ArrayList<>();
		collections.forEach(c->this.collections.add(c));
	}

	private List<Collection<E>> collections;
	

	@Override
	public int size() {
		return collections.stream().map(c->c.size()).reduce(0,(l,r)->l+r);
	}

	@Override
	public boolean isEmpty() {
		return collections.stream().allMatch(c->c.isEmpty());
	}

	@Override
	public boolean contains(Object o) {
		return collections.stream().anyMatch(c->c.contains(o));
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			private int collectionID = 0;
			private Iterator<E> iter = null;

			@Override
			public boolean hasNext() {
				while(collectionID<collections.size()-1) {
					if(iter==null) {
						iter = collections.get(collectionID).iterator();
					}
					if(iter.hasNext()) return true;
					collectionID++;
					iter = null;
				}
				
				return true;
			}

			@Override
			public E next() {
				return iter.next();
			}
			
		};
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
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
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
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

}
