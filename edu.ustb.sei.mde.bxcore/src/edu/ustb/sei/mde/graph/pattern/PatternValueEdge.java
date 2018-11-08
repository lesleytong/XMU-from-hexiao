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
		if(source.isMany()) this.setMany(true);
	}
	public PatternValueNode getTarget() {
		return target;
	}
	public void setTarget(PatternValueNode target) {
		this.target = target;
		if(target.isMany()) this.setMany(true);
	}
	
	public String toString() {
		return this.getName()+":"+source.getName()+"->"+target.getName();
	}

}
