package edu.ustb.sei.mde.modelsolver;

import java.util.ArrayList;
import java.util.List;

import org.chocosolver.memory.IEnvironment;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Settings;
import org.chocosolver.solver.constraints.Constraint;

import edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge;
import edu.ustb.sei.mde.graph.type.ITypeNode;
import edu.ustb.sei.mde.graph.type.TypeGraph;
import edu.ustb.sei.mde.graph.typedGraph.ITypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.ITypedNode;
import edu.ustb.sei.mde.modelsolver.propagators.DirectConnectedPropagator;
import edu.ustb.sei.mde.modelsolver.propagators.EdgeTypePropagator;
import edu.ustb.sei.mde.modelsolver.propagators.NodeTypePropagator;

public class GraphModel extends Model {
	
	private List<NodeVar> nodeVars;
	public List<NodeVar> getNodeVars() {
		return nodeVars;
	}

	private List<EdgeVar> edgeVars;
	
	public List<EdgeVar> getEdgeVars() {
		return edgeVars;
	}

	protected void init() {
		nodeVars = new ArrayList<>();
		edgeVars = new ArrayList<>();
	}

	public GraphModel() {
		init();
	}

	public GraphModel(String name) {
		super(name);
		init();
	}

	public GraphModel(IEnvironment environment, String name) {
		super(environment, name);
		init();
	}

	public GraphModel(IEnvironment environment, String name, Settings settings) {
		super(environment, name, settings);
		init();
	}
	
	
	
	public NodeVar nodeVar(String name, List<ITypedNode> values) {
		NodeVar nv = new NodeVar(name, values, this);
		nodeVars.add(nv);
		return nv;
	}
	
	public EdgeVar edgeVar(String name, List<ITypedEdge> values) {
		EdgeVar nv = new EdgeVar(name, values, this);
		edgeVars.add(nv);
		return nv;
	}
	
	public Constraint nodeType(NodeVar v, ITypeNode t, TypeGraph typeGraph) {
		return new Constraint(v.getName()+" is an instance of "+t.getName(), new NodeTypePropagator(v, t, typeGraph));
	}
	
	public Constraint edgeType(EdgeVar v, IStructuralFeatureEdge t, TypeGraph typeGraph) {
		return new Constraint(v.getName()+" is an instance of "+t.getName(), new EdgeTypePropagator(v, t, typeGraph));
	}
	
	public Constraint connection(NodeVar s, EdgeVar e, NodeVar t) {
		return new Constraint(s.getName()+"-("+e.getName()+")->"+t.getName(),new DirectConnectedPropagator(s, t, e));
	}

}
