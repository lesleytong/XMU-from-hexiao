package edu.ustb.sei.mde.graph.type;

import edu.ustb.sei.mde.graph.Nullable;
import edu.ustb.sei.mde.graph.typedGraph.TypedNode;

public class TypeNode implements ITypeNode {
	@Nullable(false) private String name;
	private boolean isAbstract;
	

	void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	public boolean isAbstract() {
		return isAbstract;
	}

	void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}
	
	public String toString() {
		return "("+"name:"+name+", isAbstract:"+isAbstract+")";
	}
	
	
	private TypeGraph typeGraph;
	public TypeGraph getTypeGraph() {
		return typeGraph;
	}

	public void setTypeGraph(TypeGraph typeGraph) {
		this.typeGraph = typeGraph;
	}


	static public final TypeNode NULL_TYPE;
	static public final TypeNode ANY_TYPE;
	
	static {
		NULL_TYPE = new TypeNode();
		NULL_TYPE.setName("BOTTOM");
		NULL_TYPE.setAbstract(true);
		
		ANY_TYPE = new TypeNode();
		ANY_TYPE.setName("ANY");
		ANY_TYPE.setAbstract(true);
	}

	@Override
	public Class<?> getJavaType() {
		return TypedNode.class;
	}
	
	@Override
	public boolean isInstance(Object value) {
		if(value instanceof TypedNode) {
			return isSuperTypeOf(((TypedNode) value).getType());
		} else return false;
	}
}
