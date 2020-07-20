package edu.ustb.sei.mde.query.pattern;

public interface Pattern {
	Variable[] getPorts();
	
	default public int multiplicity() {
		return getPorts().length;
	}
	
	default public boolean isBinary() {
		return multiplicity()==2;
	}
}
