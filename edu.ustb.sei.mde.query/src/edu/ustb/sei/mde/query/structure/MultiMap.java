package edu.ustb.sei.mde.query.structure;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class MultiMap<F, S> {
	private boolean isOrdered;
	private Map<F,Collection<S>> map;
	
	public MultiMap() {
		isOrdered = false;
		map = ContainerCreator.autoMap();
	}
	
	public void put(F f,S s) {
		Collection<S> col = map.get(f);
		if(col==null) {
			col = createCollection(f);
		}
		col.add(s);
	}

	private Collection<S> createCollection(F f) {
		Collection<S> col = null;
		synchronized (map) {
			col = map.get(f);
			if(col==null) {
				if(isOrdered) col = ContainerCreator.autoList();
				else col = ContainerCreator.autoSet();
				map.put(f, col);
			}
		}
		return col;
	}
	
	public void put(F f,Collection<S> s) {
		Collection<S> col = map.get(f);
		if(col==Collections.emptySet()) {
			col = createCollection(f);
		}
		col.addAll(s);
	}
	
//	/**
//	 * The method is currently not suggested to be used
//	 * @param f
//	 * @param s
//	 */
//	@Deprecated
//	private void set(F f, Collection<S> s) {
//		Collection<S> col = map.get(f);
//		if(col==null) {
//			col = createCollection(f);
//		}
//		col.clear();
//		col.addAll(s);
//	}
	
	public int size() {
		return map.size();
	}
	
	public void remove(F f, S s) {
		Collection<S> col = map.get(f);
		col.remove(s);
	}
	
	public Collection<S> get(F f) {
		return map.getOrDefault(f,Collections.emptySet());
	}

	public void clear() {
	   map.clear();
	}
}
