package edu.ustb.sei.mde.graph.pattern;

import edu.ustb.sei.mde.bxcore.structures.FieldDef;

abstract public class PatternElement<T> extends FieldDef<T> {

	public PatternElement() {
	}
	
	public PatternElement(String name, T type) {
		super(name, type);
	}

//	private T type;
//	
//	private String name;
//
//	public T getType() {
//		return type;
//	}
//
//	public void setType(T type) {
//		this.type = type;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
}
