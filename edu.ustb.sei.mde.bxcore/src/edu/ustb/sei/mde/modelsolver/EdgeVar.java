package edu.ustb.sei.mde.modelsolver;

import org.chocosolver.solver.Model;

import edu.ustb.sei.chocoex.variables.AbstractArrayValueVariable;
import edu.ustb.sei.mde.graph.IEdge;
import edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge;

/**
 * TypeNode and DataTypeNode
 * @author hexiao
 *
 * @param <T>
 */
public class EdgeVar<T extends IEdge> extends AbstractArrayValueVariable<T> {
	private IStructuralFeatureEdge type;
	
	public EdgeVar(String name, T[] edges, Model model) {
		super(name, edges, model);
	}

	@Override
	public int getTypeAndKind() {
		return VAR | GraphModel.GRAPH_ELEMENT;
	}
}

