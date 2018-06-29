package edu.ustb.sei.mde.modelsolver.propagators;

import java.util.ArrayList;
import java.util.List;

import org.chocosolver.solver.constraints.Propagator;
import org.chocosolver.solver.constraints.PropagatorPriority;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.solver.explanations.RuleStore;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.events.IEventType;
import org.chocosolver.solver.variables.events.IntEventType;
import org.chocosolver.util.ESat;

import edu.ustb.sei.mde.graph.IEdge;
import edu.ustb.sei.mde.graph.typedGraph.ITypedEdge;
import edu.ustb.sei.mde.graph.typedGraph.ITypedNode;
import edu.ustb.sei.mde.modelsolver.EdgeVar;
import edu.ustb.sei.mde.modelsolver.NodeVar;

public class DirectConnectedPropagator extends Propagator<IntVar> {
	private NodeVar source;
	private NodeVar target;
	private EdgeVar edge;
	
	public DirectConnectedPropagator(NodeVar source, NodeVar target, EdgeVar edge) {
		super(new IntVar[] {source.internalIntVar(), edge.internalIntVar(), target.internalIntVar()}, PropagatorPriority.TERNARY, true);
		this.source = source;
		this.target = target;
		this.edge = edge;
	}

	@Override
	public void propagate(int evtmask) throws ContradictionException {
		boolean changed = true;
		List<IEdge> edges = new ArrayList<>(edge.getDomainSize());
		
		while(changed) {
			edges.clear();
			
			for(int i=edge.getLB();i<=edge.getUB();i=edge.nextValue(i)) {
				IEdge ev = edge.getSemanticObject(i);
				
				edges.add(ev);
				
				int si = source.getSemanticObjectId((ITypedNode) ev.getSource());
				int ti = target.getSemanticObjectId((ITypedNode) ev.getTarget());
				
				if(si==-1 || ti==-1 || source.contains(si)==false || target.contains(ti)==false) {
					edge.removeValue(i, this);
				}
			}
			
			changed = false;
			
			for(int si = source.getLB();si<=source.getUB();si=source.nextValue(si)) {
				ITypedNode n = source.getSemanticObject(si);
				if(edges.stream().anyMatch(e->e.getSource()==n)==false)
					changed = changed || source.removeValue(si, this);
			}
			
			for(int ti = target.getLB();ti<=target.getUB();ti=target.nextValue(ti)) {
				ITypedNode n = target.getSemanticObject(ti);
				if(edges.stream().anyMatch(e->e.getTarget()==n)==false)
					changed = changed || target.removeValue(ti, this);
			}
		}
	}


	@Override
	public ESat isEntailed() {
		if(source.isInstantiated() && target.isInstantiated() && edge.isInstantiated()) {
			int si = source.getValue();
			int ei = edge.getValue();
			int ti = target.getValue();
			
			ITypedNode sn = source.getSemanticObject(si);
			ITypedNode tn = target.getSemanticObject(ti);
			ITypedEdge e = edge.getSemanticObject(ei);
			
			if(e.getSource()==sn && e.getTarget()==tn)
				return ESat.TRUE;
			else 
				return ESat.FALSE;
		}
		return ESat.UNDEFINED;
	}
	
	@Override
	public int getPropagationConditions(int vIdx) {
		return IntEventType.instantiation();
	}
	
	@Override
    public void propagate(int varIdx, int mask) throws ContradictionException {
		if(IntEventType.isInstantiate(mask)) {
			if(varIdx==0) {//source => edge, target
				int si = source.getValue();
				ITypedNode sn = source.getSemanticObject(si);
				List<IEdge> edges = new ArrayList<>(edge.getDomainSize());
				for(int i=edge.getLB();i<=edge.getUB();i=edge.nextValue(i)) {
					IEdge ev = edge.getSemanticObject(i);
					if(ev.getSource()!=sn) {
						edge.removeValue(i, this);
					} else
						edges.add(ev);
				}
				for(int ti = target.getLB();ti<=target.getUB();ti=target.nextValue(ti)) {
					ITypedNode n = target.getSemanticObject(ti);
					if(edges.stream().anyMatch(e->e.getTarget()==n)==false)
						target.removeValue(ti, this);
				}
			} else if(varIdx==1) {//edge => source, target
				int ei = edge.getValue();
				IEdge e = edge.getSemanticObject(ei);
				
				int si = source.getSemanticObjectId((ITypedNode) e.getSource());
				int ti = target.getSemanticObjectId((ITypedNode) e.getTarget());
				
				source.instantiateTo(si, this);
				target.instantiateTo(ti, this);
			} else {//target => edge, source
				int ti = target.getValue();
				ITypedNode tn = target.getSemanticObject(ti);
				List<IEdge> edges = new ArrayList<>(edge.getDomainSize());
				for(int i=edge.getLB();i<=edge.getUB();i=edge.nextValue(i)) {
					IEdge ev = edge.getSemanticObject(i);
					if(ev.getTarget()!=tn) {
						edge.removeValue(i, this);
					} else
						edges.add(ev);
				}
				for(int si = source.getLB();si<=source.getUB();si=source.nextValue(si)) {
					ITypedNode n = source.getSemanticObject(si);
					if(edges.stream().anyMatch(e->e.getSource()==n)==false)
						source.removeValue(si, this);
				}
			}
		}
    }
	
	@Override
    public boolean why(RuleStore ruleStore, IntVar var, IEventType evt, int value) {
        boolean newrules = ruleStore.addPropagatorActivationRule(this);
        return newrules;
    }
}
