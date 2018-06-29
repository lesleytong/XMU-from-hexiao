package edu.ustb.sei.mde.graph.pattern;

import edu.ustb.sei.mde.graph.INode;
import edu.ustb.sei.mde.graph.type.TypeNode;

public class PatternNode extends PatternElement<TypeNode> implements INode {
	public String toString() {
		return this.getName()+":"+this.getType().getName();
	}

}
