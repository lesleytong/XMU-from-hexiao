package edu.ustb.sei.mde.bxcore.structures;

import edu.ustb.sei.mde.graph.INamedElement;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeNode;

public class FieldDef<T> implements INamedElement {

	public FieldDef() {
	}
	
	public FieldDef(String name, T type) {
		this.name = name;
		this.type = type;
	}
	
	private T type;
	
	private String name;

	public T getType() {
		return type;
	}

	public void setType(T type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isElementType() {
		return type instanceof TypeNode || type instanceof TypeEdge || type instanceof PropertyEdge;
	}
	
	public boolean isSharable() {
		return type instanceof TypeNode;
	}
	
	public String toString() {
		return name;
	}

}