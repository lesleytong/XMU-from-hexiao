package edu.ustb.sei.mde.bxcore.structures;

import edu.ustb.sei.mde.graph.INamedElement;
import edu.ustb.sei.mde.graph.type.PropertyEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;
import edu.ustb.sei.mde.graph.type.TypeNode;

public class FieldDef<T> implements INamedElement {

	public FieldDef() {
	}
	
	public FieldDef(String name, T type) {
		this(name, type, false);
	}
	
	public FieldDef(String name, T type, boolean many) {
		this.name = name;
		this.type = type;
		this.many = many;
	}
	
	private T type;
	private String name;
	private boolean many;

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
	
	public boolean isMany() {
		return many;
	}
	
	public void setMany(boolean many) {
		this.many = many;
	}
	
	@Override
	public int hashCode() {
		return (name.hashCode()<<16) | (type.hashCode() & 0xFF);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof FieldDef<?>) {
			return name.equals(((FieldDef<?>)obj).getName()) 
					&& type.equals(((FieldDef<?>)obj).type);
		}
		else return false;
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
