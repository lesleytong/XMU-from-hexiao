package edu.ustb.sei.mde.modelsolver;

import org.chocosolver.solver.Model;

import edu.ustb.sei.chocoex.variables.AbstractArrayValueVariable;
import edu.ustb.sei.mde.graph.INode;
import edu.ustb.sei.mde.graph.type.ITypeNode;

/**
 * TypeNode and DataTypeNode
 * @author hexiao
 *
 * @param <T>
 */
public class NodeVar<T extends INode> extends AbstractArrayValueVariable<T> {
	private ITypeNode type;
	
	public NodeVar(String name, T[] nodes, Model model) {
		super(name, nodes, model);
	}

	@Override
	public int getTypeAndKind() {
		return VAR | GraphModel.GRAPH_ELEMENT;
	}
}