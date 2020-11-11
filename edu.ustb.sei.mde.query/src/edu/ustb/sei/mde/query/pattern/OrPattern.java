package edu.ustb.sei.mde.query.pattern;

import java.util.List;
import java.util.Arrays;

public class OrPattern implements Pattern {
	public OrPattern(Pattern[] subPatterns) {
		super();
		this.subPatterns = subPatterns;
	}

	protected Pattern[] subPatterns;
	private Variable[] ports = null;

	@Override
	public Variable[] getPorts() {
		if(ports==null) {
			List<Variable> common = Arrays.stream(subPatterns).map(p->Arrays.asList(p.getPorts())).reduce((l,r)->{
				l.retainAll(r);
				return l;
			}).get();
			
			ports = common.toArray(size->new Variable[size]);
		}
		return ports;
	}

	public Pattern[] getSubPatterns() {
		return subPatterns;
	}
	
	@Override
	public String toString() {
		return Arrays.stream(subPatterns).map(s->s.toString()).reduce((l, r)->l+"\nor\n"+r).orElse("");
	}
}
