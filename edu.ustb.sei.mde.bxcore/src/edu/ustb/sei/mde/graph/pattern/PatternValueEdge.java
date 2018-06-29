package edu.ustb.sei.mde.graph.pattern;

import edu.ustb.sei.mde.graph.IEdge;
import edu.ustb.sei.mde.graph.type.PropertyEdge;

public class PatternValueEdge extends PatternElement<PropertyEdge> implements IEdge {
	
	private PatternNode source;
	private PatternValueNode target;
	
	
	public PatternNode getSource() {
		return source;
	}
	public void setSource(PatternNode source) {
		this.source = source;
	}
	public PatternValueNode getTarget() {
		return target;
	}
	public void setTarget(PatternValueNode target) {
		this.target = target;
	}
	
	public String toString() {
		return this.getName()+":"+source.getName()+"->"+target.getName();
	}

}
