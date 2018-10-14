package edu.ustb.sei.mde.graph.type;

import edu.ustb.sei.mde.graph.Nullable;

public class PropertyEdge implements IStructuralFeatureEdge {
	@Nullable(false)
	private TypeNode source;
	@Nullable(false)
	private DataTypeNode target;
	@Nullable(false)
	private String name;
	
	private boolean isMany;
	
	private boolean isUnique;
	
	public boolean isUnique() {
		return isMany==false || isUnique;
	}
	void setUnique(boolean isUnique) {
		this.isUnique = isUnique;
	}
	public TypeNode getSource() {
		return source;
	}
	void setSource(TypeNode source) {
		this.source = source;
	}
	
	public DataTypeNode getTarget() {
		return target;
	}
	void setTarget(DataTypeNode target) {
		this.target = target;
	}
	
	public String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	
	public boolean isMany() {
		return isMany;
	}
	void setMany(boolean isMany) {
		this.isMany = isMany;
	}
	
	public String toString() {
		return source.getName()+"-"+(isMany?"*":"-")+"->"+target.getName();
	}

}