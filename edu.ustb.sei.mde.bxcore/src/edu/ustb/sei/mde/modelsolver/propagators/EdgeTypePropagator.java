package edu.ustb.sei.mde.modelsolver.propagators;

import edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.ITypedEdge;
import edu.ustb.sei.mde.modelsolver.EdgeVar;

public class EdgeTypePropagator extends TypeFilterPropagator<EdgeVar,IStructuralFeatureEdge> {
	
	
	
	public EdgeTypePropagator(EdgeVar v, IStructuralFeatureEdge type, TypeGraph typeGraph) {
		super(v, type, typeGraph);
	}

	@Override
	protected boolean shouldKeep(int value) {
		ITypedEdge node = var.getSemanticObject(value);
    	return node.getType()==type;
	}

	

}
