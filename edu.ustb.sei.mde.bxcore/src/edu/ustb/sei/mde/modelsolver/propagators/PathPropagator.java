package edu.ustb.sei.mde.modelsolver.propagators;

import java.util.HashSet;
import java.util.Set;

import org.chocosolver.solver.constraints.Propagator;
import org.chocosolver.solver.constraints.PropagatorPriority;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.events.IntEventType;
import org.chocosolver.solver.variables.events.PropagatorEventType;
import org.chocosolver.util.ESat;

import edu.ustb.sei.mde.graph.typedGraph.ITypedNode;
import edu.ustb.sei.mde.graph.typedGraph.TypedGraph;
import edu.ustb.sei.mde.modelsolver.NodeVar;

public class PathPropagator extends Propagator<IntVar> {
	private NodeVar source;
	private NodeVar target;
	private TypedGraph graph;
	public PathPropagator(NodeVar source, NodeVar target, PathRegx pathRegx, TypedGraph graph) {
		super(new IntVar[] {source.internalIntVar(), target.internalIntVar()}, PropagatorPriority.VERY_SLOW, true);
		this.pathRegx = pathRegx;
		this.source = source;
		this.target = target;
		this.graph  = graph;
	}

	private PathRegx pathRegx;
	
	

	@Override
	public void propagate(int evtmask) throws ContradictionException {
		Set<ITypedNode> reachables = reachables();
		for(int ti = target.getLB();ti<=target.getUB();ti = target.nextValue(ti)) {
			ITypedNode n = target.getSemanticObject(ti);
			if(reachables.contains(n)==false)
				target.removeValue(ti, this);
		}
		
	}
	
	protected Set<ITypedNode> reachables() {
		Set<ITypedNode> reachables = new HashSet<>();
		for(int si = source.getLB();si<=source.getUB();si = source.nextValue(si)) {
			ITypedNode n = source.getSemanticObject(si);
			reachables.addAll(this.pathRegx.collectReachableFrom(n, graph));
		}
		return reachables;
	}

	@Override
	public ESat isEntailed() {
		if(source.isInstantiated() && target.isInstantiated()) {
			Set<ITypedNode> reachables = reachables();
			ITypedNode n = target.getSemanticObject();
			if(reachables.contains(n)) return ESat.TRUE;
			else return ESat.FALSE;
		}
		return ESat.UNDEFINED;
	}

	@Override
	public int getPropagationConditions(int vIdx) {
		if(vIdx==0)
			return IntEventType.instantiation();
		else 
			return IntEventType.VOID.getMask();
	}
	
	@Override
	public void propagate(int idxVarInProp, int mask) throws ContradictionException {
		if(idxVarInProp==0 && IntEventType.isInstantiate(mask)) {
			propagate(PropagatorEventType.CUSTOM_PROPAGATION.getMask());
		}
	}
}
