package edu.ustb.sei.mde.modelsolver;

import java.util.Collection;

import org.chocosolver.solver.Model;

import edu.ustb.sei.mde.graph.typedGraph.ITypedNode;

public class NodeVar extends SemanticDomainVar<ITypedNode> {

	public NodeVar(String name, Collection<ITypedNode> semanticalObjects, Model model) {
		super(name, semanticalObjects, model);
	}

}
