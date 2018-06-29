package edu.ustb.sei.mde.graph.pattern;

import edu.ustb.sei.mde.graph.IEdge;
import edu.ustb.sei.mde.graph.type.TypeEdge;

public class PatternEdge extends PatternElement<TypeEdge> implements IEdge {
	private PatternNode source;
	private PatternNode target;
	
	
	public PatternNode getSource() {
		return source;
	}
	public void setSource(PatternNode source) {
		this.source = source;
	}
	public PatternNode getTarget() {
		return target;
	}
	public void setTarget(PatternNode target) {
		this.target = target;
	}
	
	public String toString() {
		return this.getName()+":"+source.getName()+"->"+target.getName();
	}

}
