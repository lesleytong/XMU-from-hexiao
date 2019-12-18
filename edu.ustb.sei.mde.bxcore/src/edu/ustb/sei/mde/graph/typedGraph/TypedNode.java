package edu.ustb.sei.mde.graph.typedGraph;

import edu.ustb.sei.mde.graph.type.TypeNode;

public class TypedNode  extends IndexableElement implements ITypedNode {
	
	private TypeNode type;	//TypedNode的类型看TypeNode
	
	static final public TypedNode NULL = new TypedNode(TypeNode.NULL_TYPE);

	public TypedNode() {
	}
	
	public TypedNode(TypeNode type) {
		this.type = type;
	}
		
	public TypeNode getType() {
		return type;
	}

	void setType(TypeNode type) {
		this.type = type;
	}
	
	public String toString() {
		return Integer.toHexString(hashCode())+":"+type.getName();
	}
		
}
