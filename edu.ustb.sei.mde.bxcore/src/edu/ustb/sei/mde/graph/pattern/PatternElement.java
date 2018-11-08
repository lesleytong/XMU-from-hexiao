package edu.ustb.sei.mde.graph.pattern;

import edu.ustb.sei.mde.bxcore.structures.FieldDef;

abstract public class PatternElement<T> extends FieldDef<T> {

	public PatternElement() {
	}
	
	public PatternElement(String name, T type) {
		super(name, type);
	}
}
