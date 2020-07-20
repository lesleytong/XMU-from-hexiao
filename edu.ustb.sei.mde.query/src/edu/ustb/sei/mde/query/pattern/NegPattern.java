package edu.ustb.sei.mde.query.pattern;

public class NegPattern implements Pattern {
	public NegPattern(ProjectionPattern hostPattern) {
		super();
		this.hostPattern = hostPattern;
	}
	
	private Pattern hostPattern;
	

	@Override
	public Variable[] getPorts() {
		return hostPattern.getPorts();
	}


	public Pattern getHostPattern() {
		return hostPattern;
	}
	
	@Override
	public String toString() {
		return "neg "+hostPattern.toString();
	}

}
