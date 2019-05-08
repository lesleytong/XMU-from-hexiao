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
import edu.ustb.sei.mde.modelsolver.EdgeVar;
import edu.ustb.sei.mde.modelsolver.NodeVar;

public class EdgeNodeConnectionPropagator extends Propagator<Variable> {
	public EdgeNodeConnectionPropagator(EdgeVar<IEdge> edge, NodeVar<INode> source, NodeVar<INode> target) {
		super(new Variable[] {edge, source, target}, PropagatorPriority.LINEAR, true);
		this.edge = edge;
		this.source = source;
		this.target = target;
	}

	private EdgeVar<IEdge> edge;
	private NodeVar<INode> source;
	private NodeVar<INode> target;

	@Override
	public void propagate(int evtmask) throws ContradictionException {
		// edge => source, target
		
		Set<INode> sns = new HashSet<>();
		Set<INode> tns = new HashSet<>();
		
		edge.iterator().forEachRemaining(e->{
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
		for(Iterator<INode> it = target.iterator(); it.hasNext() ;) {
			t = it.next();
			if(!tns.contains(t))
				target.removeValue(t, this);
		}
	}
	
	@Override
	public void propagate(int idxVarInProp, int mask) throws ContradictionException {
		if(mask==ValueEventType.INSTANTIATE.getMask()) {
			if(idxVarInProp==0) { // edge
				IEdge ev = edge.getValue();
				INode sn = ev.getSource();
				INode tn = ev.getTarget();
				
				source.instantiateTo(sn, this);
				target.instantiateTo(tn, this);
			} else if(idxVarInProp==1) { // source => edge, target
				INode sn = source.getValue();
				Set<INode> tns = new HashSet<>();
				
				IEdge ev = null;
				for(Iterator<IEdge> it = edge.iterator();it.hasNext();) {
					ev = it.next();
					if(ev.getSource()==sn) {
						tns.add(ev.getTarget());
					} else {
						edge.removeValue(ev, this);
					}
				}
				
				INode tv = null;
				for(Iterator<INode> it = target.iterator();it.hasNext();) {
					tv = it.next();
					if(!tns.contains(tv)) {
						target.removeValue(tv, this);
					}
				}
			} else if(idxVarInProp==2) { // target => edge, source
				INode tn = target.getValue();
				Set<INode> sns = new HashSet<>();
				
				IEdge ev = null;
				for(Iterator<IEdge> it = edge.iterator();it.hasNext();) {
					ev = it.next();
					if(ev.getTarget()==tn) {
						sns.add(ev.getSource());
					} else {
						edge.removeValue(ev, this);
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
			IEdge ev = edge.getValue();
			if(ev.getSource() == source.getValue() && ev.getTarget() == target.getValue())
				return ESat.TRUE;
			else return ESat.FALSE;
		} else {
			if(edge.isInstantiated()) {
				IEdge ev = edge.getValue();
				if(source.contains(ev.getSource()) && target.contains(ev.getTarget())) return ESat.UNDEFINED;
				else return ESat.FALSE;
			}
			
			if(source.isInstantiated() && target.isInstantiated()) {
				int sourceMatch = 0;
				int targetMatch = 0;
				int totalSize = 0;
				INode sv = source.getValue();
				INode tv = target.getValue();
				IEdge ev = null;
				for(Iterator<IEdge> it = edge.iterator();it.hasNext();totalSize++) {
					ev = it.next();
					if(ev.getSource()==sv) sourceMatch++;
					if(ev.getTarget()==tv) targetMatch++;
				}
				
				if(sourceMatch==0 || targetMatch==0) return ESat.FALSE;
				else if(sourceMatch==totalSize && targetMatch==totalSize) return ESat.TRUE;
				else return ESat.UNDEFINED;
			}
		}
		return ESat.UNDEFINED;
	}

}
