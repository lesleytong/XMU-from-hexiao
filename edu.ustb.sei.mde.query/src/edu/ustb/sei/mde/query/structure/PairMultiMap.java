package edu.ustb.sei.mde.query.structure;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PairMultiMap<F,S,T> {
	private Map<F,MultiMap<S,T>> map;
	
	public PairMultiMap() {
		map = new HashMap<>();
	}
	
	public void put(F f, S s, T t) {
		MultiMap<S,T> multi = map.get(f);
		if(multi==null) {
			multi = createSecondMap(f);
		}
		multi.put(s, t);
	}

	private MultiMap<S, T> createSecondMap(F f) {
		MultiMap<S, T> multi;
		synchronized (map) {
			multi = map.get(f);
			if(multi==null) {
				multi = new MultiMap<>();
				map.put(f, multi);				
			}
		}
		return multi;
	}
	
	public void putPlaceHolder(F f, S s) {
		MultiMap<S,T> multi = map.get(f);
		if(multi==null) {
			multi = createSecondMap(f);
		}
	}
	
	public void put(F f, S s, Collection<T> col) {
		MultiMap<S,T> multi = map.get(f);
		if(multi==null) {
			multi = createSecondMap(f);
		}
		multi.put(s, col);
	}
	
	public Collection<T> get(F f, S s) {
		MultiMap<S,T> multi = map.get(f);
		if(multi==null) {
			return Collections.emptySet();
		} else return multi.get(s);
	}
	
	
}
