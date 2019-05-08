package edu.ustb.sei.mde.modelsolver;

import org.chocosolver.solver.Model;
import org.chocosolver.util.objects.setDataStructures.SetType;

import edu.ustb.sei.chocoex.variables.AbstractArraySetVariable;
import edu.ustb.sei.chocoex.variables.AbstractArrayValueVariable;
import edu.ustb.sei.mde.graph.INode;
import edu.ustb.sei.mde.graph.type.ITypeNode;

/**
 * TypeNode and DataTypeNode
 * @author hexiao
 *
 * @param <T>
 */
public class NodeSetVar<T extends INode> extends AbstractArraySetVariable<T> {
	private ITypeNode type;
	
	public NodeSetVar(String name, T[] nodes, Model model) {
		super(name, nodes, model);
	}
	
	public NodeSetVar(String name, T[] ker, SetType kerType, T[] env, SetType envType, Model model) {
		super(name,ker, kerType, env, envType, model);
	}
	
	public NodeSetVar(String name, T[] ker, T[] env, Model model) {
		super(name, ker, SetType.BITSET, env, SetType.BITSET, model);
	}
	

	@Override
	public int getTypeAndKind() {
		return VAR | GraphModel.GRAPH_ELEMENT;
	}
}