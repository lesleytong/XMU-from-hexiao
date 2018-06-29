package edu.ustb.sei.mde.modelsolver.propagators;

import edu.ustb.sei.mde.graph.type.ITypeNode;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.ITypedNode;
import edu.ustb.sei.mde.modelsolver.NodeVar;

public class NodeTypePropagator extends TypeFilterPropagator<NodeVar,ITypeNode> {
	
	public NodeTypePropagator(NodeVar v,ITypeNode type, TypeGraph typeGraph) {
        super(v,type, typeGraph);
    }

	protected boolean shouldKeep(int value) {
		ITypedNode node = var.getSemanticObject(value);
    	return typeGraph.isSuperTypeOf(node.getType(), type);
	}
}
