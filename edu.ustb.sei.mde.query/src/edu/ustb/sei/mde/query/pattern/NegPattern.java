package edu.ustb.sei.mde.query.pattern;

public class NegPattern implements Pattern {
	public NegPattern(ProjectionPattern hostPattern) {
		super();
		this.subPattern = hostPattern;
	}
	
	private Pattern subPattern;
	

	@Override
	public Variable[] getPorts() {
		return subPattern.getPorts();
	}


	public Pattern getSubPattern() {
		return subPattern;
	}
	
	@Override
	public String toString() {
		return "neg "+subPattern.toString();
	}

}
