package edu.ustb.sei.mde.graph.typedGraph;

import java.util.HashMap;

import edu.ustb.sei.mde.graph.type.DataTypeNode;

public class ValueNode  extends IndexableElement implements ITypedNode {
	private final Object value;
	private final DataTypeNode type;
	
	private ValueNode(Object v,DataTypeNode type) {
		this.value = v;
		this.type = type;
	}
	
	@Override
	public boolean isIndexable() {
		return false;
	}

	@SuppressWarnings("unchecked")
	public <T> T getValue() {
		return (T) value;
	}
	
	static public ValueNode createConstantNode(Object value, DataTypeNode type) {
		if(value==null) 
			return NULL;
		else {
			HashMap<DataTypeNode,ValueNode> typeMap = constants.get(value);
			if(typeMap==null) {
				typeMap = new HashMap<>();
				constants.put(value, typeMap);
			}
			ValueNode c = typeMap.get(type);
			if(c==null) {
				c = new ValueNode(value, type);
				typeMap.put(type, c);
			}
			return c;
		}
	}
	
	static final public ValueNode NULL = new ValueNode(null,DataTypeNode.NULL_TYPE);
	
	static final private HashMap<Object,HashMap<DataTypeNode,ValueNode>> constants = new HashMap<Object,HashMap<DataTypeNode,ValueNode>>();

	@Override
	public DataTypeNode getType() {
		return this.type;
	} 
	
	public String toString() {
		return value==null ? "NULL" : value.toString();
	}

}
