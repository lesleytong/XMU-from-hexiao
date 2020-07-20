package edu.ustb.sei.mde.query.pattern;

import java.util.Arrays;

public class ProjectionPattern implements Pattern {
	private Variable[] ports;
	private Pattern hostPattern;
	private boolean unique;
	
	public ProjectionPattern(Variable[] ports, Pattern hostPattern) {
		assert ports.length==hostPattern.getPorts().length;
		this.ports = ports;
		this.hostPattern = extract(hostPattern);
		this.unique = true;
	}
	
	private Pattern extract(Pattern p) {
		if(p instanceof ProjectionPattern) return ((ProjectionPattern) p).hostPattern;
		else return p;
	}

	@Override
	public Variable[] getPorts() {
		return ports;
	}

	public Pattern getHostPattern() {
		return hostPattern;
	}

	public boolean isUnique() {
		return unique;
	}
	
	@Override
	public String toString() {
		String params = Arrays.stream(getPorts()).map(p->p.getName()).reduce((l,r)->l+","+r).orElse("");
		if(hostPattern instanceof GraphPattern<?, ?>) {
			return "("+params+")->"+((GraphPattern<?,?>) hostPattern).getName();
		} else {
			return "("+params+")->"+hostPattern.toString();
		}
	}

}
