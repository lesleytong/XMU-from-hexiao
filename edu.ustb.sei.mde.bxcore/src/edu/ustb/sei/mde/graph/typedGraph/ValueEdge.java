package edu.ustb.sei.mde.graph.typedGraph;

import edu.ustb.sei.mde.graph.type.PropertyEdge;

public class ValueEdge extends IndexableElement  implements ITypedEdge {
	public ValueEdge(TypedNode source, ValueNode target, PropertyEdge type) {
		super();
		this.source = source;
		this.target = target;
		this.type = type;
	}

	private TypedNode source;
	private ValueNode target;
	private PropertyEdge type;
	
	public ValueEdge() {
		
	}
	
	public TypedNode getSource() {
		return source;
	}


	void setSource(TypedNode source) {
		this.source = source;
	}


	public ValueNode getTarget() {
		return target;
	}


	void setTarget(ValueNode target) {
		this.target = target;
	}


	public PropertyEdge getType() {
		return type;
	}


	void setType(PropertyEdge type) {
		this.type = type;
	}
	
	public String toString() {
		return source.toString()+"."+type.getName()+"="+target.toString();
	}

}
