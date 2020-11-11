package edu.ustb.sei.mde.query.structure;

import java.util.Map;

// injective mapping between F,S
public class BiMap<F,S> {
	private Map<F,S> forwardMap;
	private Map<S,F> backwardMap;
	
	public BiMap() {
		forwardMap = ContainerCreator.autoMap();
		backwardMap = ContainerCreator.autoMap();
	}
	
	public S forwardGet(F f) {
		return forwardMap.get(f);
	}
	public S forwardGet(F f, S defaultValue) {
		return forwardMap.getOrDefault(f, defaultValue);
	}
	public F backwardGet(S s) {
		return backwardMap.get(s);
	}
	public F backwardGet(S s, F defaultValue) {
		return backwardMap.getOrDefault(s, defaultValue);
	}
	
	private void put(F f, S s) {
		S oldS = forwardMap.put(f, s);
		F oldF = backwardMap.put(s, f);
		
		if(oldS!=null) {
			backwardMap.remove(oldS);
		}
		
		if(oldF!=null) {
			forwardMap.remove(oldF);
		}
	}
	
	public void forwardPut(F f, S s) {
		put(f,s);
	}
	
	public void backwardPut(S s, F f) {
		put(f,s);
	}
	
	public void forwardRemove(F f) {
		S oldS = forwardMap.remove(f);
		if(oldS!=null) {
			backwardMap.remove(oldS);
		}
	}
	
	public void backwardRemove(S s) {
		F oldF = backwardMap.remove(s);
		if(oldF!=null) {
			forwardMap.remove(oldF);
		}
	}
	
	public int size() {
		assert forwardMap.size()==backwardMap.size();
		return forwardMap.size();
	}
}
