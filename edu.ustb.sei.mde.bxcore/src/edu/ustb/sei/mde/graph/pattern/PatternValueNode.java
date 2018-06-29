package edu.ustb.sei.mde.graph.pattern;

import edu.ustb.sei.mde.graph.INode;
import edu.ustb.sei.mde.graph.type.DataTypeNode;

public class PatternValueNode extends PatternElement<DataTypeNode> implements INode {
	public String toString() {
		return this.getName()+":"+this.getType().getName();
	}
}
