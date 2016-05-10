package edu.ustb.sei.mde.xmu2.util;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;

public class SingletonList<E> implements EList<E> {
	
	private E content = null;

	@Override
	public int size() {
		return content == null ? 0 : 1;
	}

	@Override
	public boolean isEmpty() {
		return size()==0;
	}

	@Override
	public boolean contains(Object o) {
		if(isEmpty())
			return false;
		else 
			return content.equals(o);
	}
	
	class SingletonListIterator implements Iterator<E> {
		private int index = 0;
		private SingletonList<E> list = null;
		
		public SingletonListIterator(SingletonList<E> l) {
			list = l;
		}
		
		@Override
		public boolean hasNext() {
			return list.isEmpty()==false && index == 0;
		}

		@Override
		public E next() {
			index = 1;
			return list.content;
		}
		
	}

	@Override
	public Iterator<E> iterator() {
		return new SingletonListIterator(this);
	}

	@Override
	public Object[] toArray() {
		if(isEmpty())
			return Constants.EMPTYARRAY;
		else {
			return new Object[]{content};
		}
	}

	@Override
	public <T> T[] toArray(T[] array) {
		int size = isEmpty() ? 0 : 1;
		
		if (size > 0)
	    {
	      if (array.length < size)
	      {
	        @SuppressWarnings("unchecked") T [] newArray = (T[])Array.newInstance(array.getClass().getComponentType(), size);
	        array  = newArray;
	      }
	  
	      array[0] = (T) content;
	    }

	    if (array.length > size)
	    {
	      array[size] = null;
	    }

	    return array;
	}

	@Override
	public boolean add(E e) {
		if(content==e) 
			return false;
		if(content!=null && content.equals(e))
			return false;
		
		content = e;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		if(content==null) return false;
		else if(content.equals(o)) return false;
		else {
			content = null;
			return true;
		}
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		if(content==null) {
			if(c.isEmpty()) return true;
			else return false;
		} else {
			if(c.isEmpty()) return true;
			else {
				for(Object o : c) {
					if(o.equals(content)==false)
						return false;
				}
				return true;
			}
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
	public boolean addAll(int index, Collection<? extends E> c) {
		if(index==0) return addAll(c);
		else return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		for(Object o : c) {
			remove(o);
		}
		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		for(Object o : c) {
			if(o.equals(content)) return false;
		}
		remove(content);
		return true;
	}

	@Override
	public void clear() {
		content = null;
	}

	@Override
	public E get(int index) {
		if(index == 0 ) {
			return content;
		} else {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	@Override
	public E set(int index, E element) {
		if(index==0) {
			E old = content;
			content = element;
			return old;
		} else {
			throw new ArrayIndexOutOfBoundsException(index);
		}
	}

	@Override
	public void add(int index, E element) {
		set(index,element);
	}

	@Override
	public E remove(int index) {
		if(index >= size())
			throw new ArrayIndexOutOfBoundsException(index);
		else {
			E o = content;
			content = null;
			return o;
		}
	}

	@Override
	public int indexOf(Object o) {
		if(contains(o))
			return 0;
		else
			return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		if(contains(o))
			return 0;
		else
			return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void move(int newPosition, E object) {
	}

	@Override
	public E move(int newPosition, int oldPosition) {
		return content;
	}
	
	

//	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);
//	public void addLister(PropertyChangeListener l) {
//		pcs.addPropertyChangeListener(l);
//	}
//	public void removeLister(PropertyChangeListener l) {
//		pcs.removePropertyChangeListener(l);
//	}

}
