package edu.ustb.sei.mde.query.pattern;

public class ClosurePattern implements Pattern {
	protected boolean atLeastOne;
	protected Pattern subPattern;
	
	public ClosurePattern(Pattern subPattern, boolean atLeastOne) {
		this.atLeastOne = atLeastOne;
		this.subPattern = subPattern;
		if(subPattern.isBinary()==false) throw new RuntimeException();
	}

	@Override
	public Variable[] getPorts() {
		return subPattern.getPorts();
	}
	
	@Override
	public String toString() {
		String sub = subPattern.toString();
		return atLeastOne ? sub+"+" : sub+"*";
	}
}
