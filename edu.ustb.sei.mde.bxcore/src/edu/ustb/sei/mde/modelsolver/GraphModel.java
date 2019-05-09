package edu.ustb.sei.mde.modelsolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.chocosolver.memory.trailing.EnvironmentTrailing;
import org.chocosolver.memory.trailing.trail.flatten.OperationTrail;
import org.chocosolver.memory.trailing.trail.flatten.StoredBoolTrail;
import org.chocosolver.memory.trailing.trail.flatten.StoredDoubleTrail;
import org.chocosolver.memory.trailing.trail.flatten.StoredIntTrail;
import org.chocosolver.memory.trailing.trail.flatten.StoredLongTrail;
import org.chocosolver.solver.Model;
import org.chocosolver.solver.Settings;
import org.chocosolver.solver.constraints.Constraint;
import org.chocosolver.solver.search.strategy.Search;
import org.chocosolver.solver.search.strategy.strategy.AbstractStrategy;

import edu.ustb.sei.chocoex.AbstractEnvironmentEx;
import edu.ustb.sei.chocoex.AbstractModelEx;
import edu.ustb.sei.chocoex.decisions.ArraySetStrategy;
import edu.ustb.sei.chocoex.decisions.ArrayValueStrategy;
import edu.ustb.sei.mde.graph.IEdge;
import edu.ustb.sei.mde.graph.INode;
import edu.ustb.sei.mde.graph.type.IStructuralFeatureEdge;
import edu.ustb.sei.mde.graph.type.ITypeNode;
import edu.ustb.sei.mde.modelsolver.propagators.EdgeNodeConnectionPropagator;
import edu.ustb.sei.mde.modelsolver.propagators.EdgeSetNodeNodeSetConnectionPropagator;
import edu.ustb.sei.mde.modelsolver.propagators.EdgeSetNodeSetNodeConnectionPropagator;

public class GraphModel extends AbstractModelEx {
	
	// related to choco
	static final public int GRAPH_ELEMENT = 1<<7;

	public GraphModel(String name) {
		super(buildEnv(), name, new Settings() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public AbstractStrategy makeDefaultSearch(Model model) {
				// overrides default search strategy to handle graph vars
				AbstractStrategy other = Search.defaultSearch(model);
				
				List<AbstractStrategy> all = new ArrayList<>();
				all.add(other);

				NodeVar[] nvs = ((AbstractModelEx)model).retrieveVariables(NodeVar.class);
				if (nvs.length != 0) {
					all.add(new ArrayValueStrategy<NodeVar>(model, nvs));
				}
				
				EdgeVar[] evs = ((AbstractModelEx)model).retrieveVariables(EdgeVar.class);
				if(evs.length!=0) {
					all.add(new ArrayValueStrategy<EdgeVar>(model, evs));
				}
				
				NodeSetVar[] nsvs = ((AbstractModelEx)model).retrieveVariables(NodeSetVar.class);
				if (nsvs.length != 0) {
					all.add(new ArraySetStrategy<NodeSetVar>(model, nsvs));
				}
				
				EdgeSetVar[] esvs = ((AbstractModelEx)model).retrieveVariables(EdgeSetVar.class);
				if(esvs.length!=0) {
					all.add(new ArraySetStrategy<EdgeSetVar>(model, esvs));
				}
				
				return Search.sequencer(all.toArray(new AbstractStrategy[all.size()]));
			}
		});
	}
	
	public List<NodeVar<?>> getNodeVars() {
		return Arrays.stream(getVars()).filter(v->v.getClass()==NodeVar.class).map(v->(NodeVar<?>)v).collect(Collectors.toList());
	}
	
	public List<NodeSetVar<?>> getNodeSetVars() {
		return Arrays.stream(getVars()).filter(v->v.getClass()==NodeSetVar.class).map(v->(NodeSetVar<?>)v).collect(Collectors.toList());
	}
	
	public List<EdgeVar<?>> getEdgeVars() {
		return Arrays.stream(getVars()).filter(v->v.getClass()==EdgeVar.class).map(v->(EdgeVar<?>)v).collect(Collectors.toList());
	}
	
	public List<EdgeSetVar<?>> getEdgeSetVars() {
		return Arrays.stream(getVars()).filter(v->v.getClass()==EdgeSetVar.class).map(v->(EdgeSetVar<?>)v).collect(Collectors.toList());
	}
	
	public <T extends INode> NodeVar<T> node(String name, ITypeNode type, T[] values) {
		return new NodeVar<T>(name, values, this);
	}
	
	public <T extends IEdge> EdgeVar<T> edge(String name, IStructuralFeatureEdge type, T[] values) {
		return new EdgeVar<T>(name, values, this);
	}
	
	public <T extends INode> NodeSetVar<T> nodeSet(String name, ITypeNode type, T[] env) {
		return new NodeSetVar<>(name, Arrays.copyOfRange(env, 0, 0), env, this);
	}
	
	public <T extends INode> NodeSetVar<T> fixedNodeSet(String name, ITypeNode type, T[] values) {
		return new NodeSetVar<>(name, values, this);
	}
	
	public <T extends IEdge> EdgeSetVar<T> edgeSet(String name, IStructuralFeatureEdge type, T[] env) {
		return new EdgeSetVar<>(name, Arrays.copyOfRange(env, 0, 0), env, this);
	}
	
	public <T extends IEdge> EdgeSetVar<T> fixedEdgeSet(String name, IStructuralFeatureEdge type, T[] values) {
		return new EdgeSetVar<>(name, values, this);
	}
	
	public Constraint connection(EdgeVar<IEdge> e, NodeVar<INode> s, NodeVar<INode> t) {
		return new Constraint(s.getName()+"-("+e.getName()+")->"+t.getName(),new EdgeNodeConnectionPropagator(e, s, t));
	}
	
	public Constraint connection(EdgeSetVar<IEdge> e, NodeSetVar<INode> s, NodeVar<INode> t) {
		return new Constraint(s.getName()+"[]-("+e.getName()+"[])->"+t.getName(),new EdgeSetNodeSetNodeConnectionPropagator(e, s, t));
	}
	
	public Constraint connection(EdgeSetVar<IEdge> e, NodeVar<INode> s, NodeSetVar<INode> t) {
		return new Constraint(s.getName()+"-("+e.getName()+"[])->"+t.getName()+"[]",new EdgeSetNodeNodeSetConnectionPropagator(e, s, t));
	}
	
	static protected AbstractEnvironmentEx buildEnv() {
		GraphEnvironment env = new GraphEnvironment();
		int worldsize = EnvironmentTrailing.NBUPATES;
		int worldnumber = EnvironmentTrailing.NBWORLDS;
		double loadfactor = EnvironmentTrailing.LOADFACTOR;

        env.setBoolTrail(new StoredBoolTrail(worldsize, worldnumber, loadfactor));
        env.setIntTrail(new StoredIntTrail(worldsize, worldnumber, loadfactor));
        env.setDoubleTrail(new StoredDoubleTrail(worldsize, worldnumber, loadfactor));
        env.setOperationTrail(new OperationTrail(worldsize, worldnumber, loadfactor));
        env.setLongTrail(new StoredLongTrail(worldsize, worldnumber, loadfactor));
        
//        env.setTrail(StoredRegExp.class, new StoredRegExpTrail(worldsize, worldnumber, loadfactor));
        
        return env;
	}

}
