package edu.ustb.sei.mde.modelsolver.propagators;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.chocosolver.solver.constraints.Propagator;
import org.chocosolver.solver.constraints.PropagatorPriority;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.solver.variables.Variable;
import org.chocosolver.util.ESat;

import edu.ustb.sei.chocoex.variables.ValueEventType;
import edu.ustb.sei.mde.graph.IEdge;
import edu.ustb.sei.mde.graph.INode;
import edu.ustb.sei.mde.modelsolver.EdgeSetVar;
import edu.ustb.sei.mde.modelsolver.NodeSetVar;
import edu.ustb.sei.mde.modelsolver.NodeVar;

public class EdgeSetNodeNodeSetConnectionPropagator extends Propagator<Variable> {
	public EdgeSetNodeNodeSetConnectionPropagator(EdgeSetVar<IEdge> edge, NodeVar<INode> source, NodeSetVar<INode> target) {
		super(new Variable[] {edge, source, target}, PropagatorPriority.CUBIC, true);
		this.edge = edge;
		this.source = source;
		this.target = target;
	}

	private EdgeSetVar<IEdge> edge;
	private NodeVar<INode> source;
	private NodeSetVar<INode> target;

	@Override
	public void propagate(int evtmask) throws ContradictionException {
		// edge => source, target
		
		Set<INode> sns = new HashSet<>();
		Set<INode> tns = new HashSet<>();
		
		edge.upperBoundIterator().forEachRemaining(e->{
			sns.add(e.getSource());
			tns.add(e.getTarget());
		});
		
		INode s = null;
		for(Iterator<INode> it = source.iterator(); it.hasNext() ;) {
			s = it.next();
			if(!sns.contains(s))
				source.removeValue(s, this);
		}
		
		INode t = null;
		for(Iterator<INode> it = target.upperBoundIterator(); it.hasNext() ;) {
			t = it.next();
			if(!tns.contains(t))
				target.remove(t, this);
		}
	}
	
	@Override
	public void propagate(int idxVarInProp, int mask) throws ContradictionException {
		if(mask==ValueEventType.INSTANTIATE.getMask()) {
			if(idxVarInProp==0) { // edge
				Set<INode> sns = new HashSet<>();
				Set<INode> tns = new HashSet<>();
				
				edge.upperBoundIterator().forEachRemaining(e->{
					sns.add(e.getSource());
					tns.add(e.getTarget());
				});
				
				if(sns.size()!=1) source.contradiction(this, "Multiple values");
				
				INode sn = sns.stream().findAny().get();
				INode[] tn = tns.toArray(new INode[tns.size()]);
				
				source.instantiateTo(sn, this);
				target.instantiateTo(tn, this);
			} else if(idxVarInProp==1) { // source => edge, target
				INode sn = source.getValue();
				Set<INode> tns = new HashSet<>();
				
				IEdge ev = null;
				for(Iterator<IEdge> it = edge.upperBoundIterator();it.hasNext();) {
					ev = it.next();
					if(ev.getSource()==sn) {
						tns.add(ev.getTarget());
					} else {
						edge.remove(ev, this);
					}
				}
				
				INode tv = null;
				for(Iterator<INode> it = target.upperBoundIterator();it.hasNext();) {
					tv = it.next();
					if(!tns.contains(tv)) {
						target.remove(tv, this);
					}
				}
			} else if(idxVarInProp==2) { // target => edge, source
				Set<INode> tns = new HashSet<>();
				target.lowerBoundIterator().forEachRemaining(tn->{
					tns.add(tn);
				});
				
				Set<INode> sns = new HashSet<>();
				
				IEdge ev = null;
				for(Iterator<IEdge> it = edge.upperBoundIterator();it.hasNext();) {
					ev = it.next();
					if(tns.contains(ev.getTarget())) {
						sns.add(ev.getSource());
					} else {
						edge.remove(ev, this);
					}
				}
				
				INode sv = null;
				for(Iterator<INode> it = source.iterator();it.hasNext();) {
					sv = it.next();
					if(!sns.contains(sv)) {
						source.removeValue(sv, this);
					}
				}
			}
		}
	}

	@Override
	public ESat isEntailed() {
		if(edge.isInstantiated() && source.isInstantiated() && target.isInstantiated()) {
			INode sv = source.getValue();
			Set<INode> tns = new HashSet<>();
			
			IEdge ev = null;
			for(Iterator<IEdge> it = edge.lowerBoundIterator(); it.hasNext();) {
				ev = it.next();
				if(ev.getSource()!=sv) return ESat.FALSE;
				tns.add(ev.getTarget());
			}
			
			Set<INode> aTns = target.getLBValue();
			
			if(aTns.equals(tns)) {
				return ESat.TRUE;
			} else
				return ESat.FALSE;
		} else {
			if(edge.isInstantiated()) {
				Set<INode> sns = new HashSet<>();
				Set<INode> tns = new HashSet<>();
				IEdge ev = null;
				for(Iterator<IEdge> it = edge.lowerBoundIterator(); it.hasNext();) {
					ev = it.next();
					sns.add(ev.getSource());
					tns.add(ev.getTarget());
				}
				
				if(sns.size()!=1) return ESat.FALSE;
				
				if(source.isInstantiated()) {
					INode sv = source.getValue();
					if(sns.contains(sv)) return ESat.TRUE;
					else return ESat.FALSE;
				} else if(target.isInstantiated()){
					if(target.getLBValue().equals(tns)) {
						return ESat.TRUE;
					} else return ESat.FALSE;
				}
			}
		}
		return ESat.UNDEFINED;
	}

}
