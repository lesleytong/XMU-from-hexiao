package edu.ustb.sei.mde.query.structure;

import java.util.Iterator;
import java.util.List;

public class CompositeIterator<E> implements Iterator<E> {
	
	public CompositeIterator(List<Iterator<E>> iterators) {
		super();
		this.iterators = iterators;
		cur = 0;
	}

	private List<Iterator<E>> iterators;
	private int cur;
	

	@Override
	public boolean hasNext() {
		while(cur<iterators.size()) {
			Iterator<E> curIt = iterators.get(cur);
			if(curIt.hasNext()) return true;
			cur++;
		}
		return false;
	}

	@Override
	public E next() {
		return iterators.get(cur).next();
	}

}
