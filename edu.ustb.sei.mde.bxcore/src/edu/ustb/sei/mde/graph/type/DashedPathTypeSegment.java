package edu.ustb.sei.mde.graph.type;

import edu.ustb.sei.mde.graph.IEdge;

public class DashedPathTypeSegment {
	public DashedPathTypeSegment(IStructuralFeatureEdge[] edgeTypes, int min, int max) {
		super();
		this.edgeTypes = edgeTypes;
		this.min = min;
		this.max = max;
	}
	
	private IStructuralFeatureEdge[] edgeTypes;
	private int min;
	private int max;
	
	public IStructuralFeatureEdge[] getEdgeTypes() {
		return edgeTypes;
	}
	public int getMin() {
		return min;
	}
	public int getMax() {
		return max;
	}
	
	public boolean isInstance(IEdge edge) {
		for(IStructuralFeatureEdge type : edgeTypes) {
			if(type.isInstance(edge)) return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("(");
		boolean flag = true;
		for(IStructuralFeatureEdge et : edgeTypes) {
			if(!flag) builder.append("|");
			flag = false;
			builder.append(et.getName());
		}
		builder.append(")[");
		builder.append(min);
		builder.append(",");
		builder.append(max);
		builder.append("]");
		return super.toString();
	}
}