package edu.ustb.sei.mde.modelsolver;

import org.chocosolver.solver.Model;
import org.chocosolver.util.objects.setDataStructures.SetType;

import edu.ustb.sei.chocoex.variables.AbstractArraySetVariable;
import edu.ustb.sei.mde.graph.IEdge;
import edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge;

public class EdgeSetVar<T extends IEdge> extends AbstractArraySetVariable<T> {
	private IStructuralFeatureEdge type;
	
	public EdgeSetVar(String name, T[] value, Model model) {
		super(name, value, model);
	}
	
	public EdgeSetVar(String name, T[] ker, SetType kerType, T[] env, SetType envType, Model model) {
		super(name, ker, kerType, env, envType, model);
	}
	
	public EdgeSetVar(String name, T[] ker, T[] env, Model model) {
		super(name, ker, SetType.BITSET, env, SetType.BITSET, model);
	}
	

	@Override
	public int getTypeAndKind() {
		return VAR | GraphModel.GRAPH_ELEMENT;
	}

}
