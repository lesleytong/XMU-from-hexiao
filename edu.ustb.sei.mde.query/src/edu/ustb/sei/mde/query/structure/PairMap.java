package edu.ustb.sei.mde.query.structure;

import java.util.Collections;
import java.util.Map;

public class PairMap<F, S, T> {
	private Map<F,Map<S,T>> map;
	
	public PairMap() {
		map = ContainerCreator.autoMap();
	}
	
	public void put(F f, S s, T t) {
		Map<S,T> secondMap = map.get(f);
		if(secondMap==null) {
			// no concurrent write on f
			secondMap = ContainerCreator.autoMap();
			map.put(f, secondMap);
		}
		secondMap.put(s, t);
	}
	
	public T get(F f, S s) {
		Map<S,T> secondMap = map.getOrDefault(f, Collections.emptyMap());
		return secondMap.get(s);
	}
	
	public void remove(F f, S s) {
		Map<S,T> secondMap = map.getOrDefault(f, Collections.emptyMap());
		secondMap.remove(s);
	}

}
