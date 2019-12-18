package edu.ustb.sei.mde.graph.typedGraph;

import edu.ustb.sei.mde.graph.type.TypeEdge;

public class TypedEdge extends IndexableElement implements ITypedEdge {
	
	private TypedNode source;
	private TypedNode target;
	private TypeEdge type;	//TypedEdge的类型看TypeEdge
	
	public TypedEdge() {
		
	}
	
	public TypedEdge(TypedNode source, TypedNode target, TypeEdge type) {
		super();
		this.source = source;
		this.target = target;
		this.type = type;
	}

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
