package edu.ustb.sei.mde.graph.typedGraph;

import edu.ustb.sei.mde.graph.type.TypeEdge;

public class TypedEdge extends IndexableElement implements ITypedEdge {
	private TypedNode source;
	private TypedNode target;
	private TypeEdge type;
	
	
	public TypedNode getSource() {
		return source;
	}
	void setSource(TypedNode source) {
		this.source = source;
	}
	public TypedNode getTarget() {
		return target;
	}
	void setTarget(TypedNode target) {
		this.target = target;
	}
	public TypeEdge getType() {
		return type;
	}
	void setType(TypeEdge type) {
		this.type = type;
	}
	
	public String toString() {
		return source.toString()+"-"+type.getName()+"->"+target.toString();
	}
}
