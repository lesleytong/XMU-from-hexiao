package edu.ustb.sei.mde.graph.type;

import edu.ustb.sei.mde.graph.Nullable;

public class TypeEdge implements IStructuralFeatureEdge {
	@Nullable(false)
	private TypeNode source;
	@Nullable(false)
	private TypeNode target;
	@Nullable(false)
	private String name;
	
	private boolean isMany;

	private boolean isUnique;
	
	private boolean isContainment;
	
	public boolean isContainment() {
		return isContainment;
	}
	public void setContainment(boolean isContainment) {
		this.isContainment = isContainment;
	}
	
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
	
	public TypeNode getTarget() {
		return target;
	}
	void setTarget(TypeNode target) {
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
