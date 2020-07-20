package edu.ustb.sei.mde.query.structure;

import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;


public class UncontrolledMultiMap<F, S> {
	private Map<F,Collection<S>> map;
	
	public UncontrolledMultiMap() {
		map = ContainerCreator.autoMap();
	}
	
	public void put(F f,S s,Supplier<Collection<S>> sup) {
		Collection<S> col = map.get(f);
		if(col==null) {
			col = createCollection(f,sup);
		}
		col.add(s);
	}

	private Collection<S> createCollection(F f, Supplier<Collection<S>> sup) {
		Collection<S> col = null;
		synchronized (map) {
			col = map.get(f);
			if(col==null) {
				col = sup.get();
				map.put(f, col);
			}
		}
		return col;
	}
	
	public void set(F f, Collection<S> s) {
		synchronized (map) {
			map.put(f, s);
		}
	}
	
	public int size() {
		return map.size();
	}
	
	public void remove(F f, S s) {
		Collection<S> col = map.get(f);
		if(col!=null ) {
			col.remove(s);
		}
	}
	
	public Collection<S> get(F f) {
		return map.get(f);
	}
	
	public Collection<S> getOrDefault(F f, Collection<S> def) {
		Collection<S> x = map.get(f);
		if(x==null) return def;
		else return x;
	}
	
	public Collection<S> get(F f,Collection<S> def) {
		return map.getOrDefault(f,def);
	}
}
