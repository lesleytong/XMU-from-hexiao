package edu.ustb.sei.mde.modelsolver;

import java.util.Collection;

import org.chocosolver.solver.Model;
import edu.ustb.sei.mde.graph.typedGraph.ITypedEdge;

public class EdgeVar extends SemanticDomainVar<ITypedEdge> {

	public EdgeVar(String name, Collection<ITypedEdge> semanticalObjects, Model model) {
		super(name, semanticalObjects, model);
	}

}
