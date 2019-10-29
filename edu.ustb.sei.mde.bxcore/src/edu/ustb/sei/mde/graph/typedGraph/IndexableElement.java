package edu.ustb.sei.mde.graph.typedGraph;

import java.util.function.Consumer;

import edu.ustb.sei.mde.bxcore.structures.Index;

abstract public class IndexableElement {
	
	public IndexableElement() {
		if(isIndexable())
			index = Index.index();
		else
			index = null;
	}
	
	public boolean isIndexable() {
		return true;
	}
	
	private Index index;
	
	
//	private Set<Object> indices;
	
//	public Set<Object> getIndices() {
//		return indices;
//	}
	
	public Index getIndex() {
		return this.index;
	}
	
//	public Object getAnyIndex() {
//		if(indices.isEmpty()) return null;
//		return indices.stream().findFirst().get();
//	}
	
//	public void appendIndex(Object index) {
//		indices.add(index);
//	}
//	
//	public void mergeIndices(IndexableElement e) {
//		indices.addAll(e.getIndices());
//	}
	
	public void autoAppendIndex() {
		appendIndexValue(IndexSystem.generateUUID());
	}
	
	public void appendIndexValue(Object ind) {
		index.add(ind);
	}
	
	public void appendIndex(Index ind) {
		index.merge(ind);
	}
	
	public void foreach(Consumer<Object> a) {
		index.internalIndices().forEach(a);
	}
	
	public void mergeIndex(IndexableElement e) {
		index.merge(e.getIndex());
	}

}
