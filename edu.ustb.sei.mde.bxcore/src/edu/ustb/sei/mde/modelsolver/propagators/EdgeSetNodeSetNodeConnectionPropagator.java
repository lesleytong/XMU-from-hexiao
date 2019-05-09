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

public class EdgeSetNodeSetNodeConnectionPropagator extends Propagator<Variable> {
	public EdgeSetNodeSetNodeConnectionPropagator(EdgeSetVar<IEdge> edge, NodeSetVar<INode> source, NodeVar<INode> target) {
		super(new Variable[] {edge, source, target}, PropagatorPriority.CUBIC, true);
		this.edge = edge;
		this.source = source;
		this.target = target;
	}

	private EdgeSetVar<IEdge> edge;
	private NodeSetVar<INode> source;
	private NodeVar<INode> target;

	@Override
	public void propagate(int evtmask) throws ContradictionException {
//		// edge => source, target
//		Set<INode> sns = new HashSet<>();
//		Set<INode> tns = new HashSet<>();
//		
//		edge.upperBoundIterator().forEachRemaining(e->{
//			sns.add(e.getSource());
//			tns.add(e.getTarget());
//		});
//		
//		INode s = null;
//		for(Iterator<INode> it = source.upperBoundIterator(); it.hasNext() ;) {
//			s = it.next();
//			if(!sns.contains(s))
//				source.remove(s, this);
//		}
//		
//		INode t = null;
//		for(Iterator<INode> it = target.iterator(); it.hasNext() ;) {
//			t = it.next();
//			if(!tns.contains(t))
//				target.removeValue(t, this);
//		}
	}
	
	@Override
	public void propagate(int idxVarInProp, int mask) throws ContradictionException {
		if(mask==ValueEventType.ADD_TO_KER.getMask()) {
			handleAddToKer(idxVarInProp);
		} else if(mask==ValueEventType.REMOVE_FROM_ENVELOPE.getMask()) {
			handleRemFromEnv(idxVarInProp);
		} else if(mask==ValueEventType.INSTANTIATE.getMask()) {
			handleInst(idxVarInProp);
		}
	}

	public void handleInst(int idxVarInProp) throws ContradictionException {
		if(idxVarInProp == 2) { // target
			INode tn = target.getValue();
			Set<INode> sns = new HashSet<>();
			
			IEdge ev = null;
			for(Iterator<IEdge> it = edge.upperBoundIterator();it.hasNext();) {
				ev = it.next();
				if(ev.getTarget()==tn) {
					sns.add(ev.getSource());
				} else {
					edge.remove(ev, this);
				}
			}
			
			INode sv = null;
			for(Iterator<INode> it = source.upperBoundIterator();it.hasNext();) {
				sv = it.next();
				if(!sns.contains(sv)) {
					source.remove(sv, this);
				}
			}
		}
	}

	public void handleRemFromEnv(int idxVarInProp) throws ContradictionException {
		if(idxVarInProp==0) { // edge
			Set<INode> sns = new HashSet<>();
			Set<INode> tns = new HashSet<>();
			
			edge.upperBoundIterator().forEachRemaining(e->{
				sns.add(e.getSource());
				tns.add(e.getTarget());
			});
			
			for(INode sn : source.getUBValue()) {
				if(!sns.contains(sn)) source.remove(sn, this);
			}
			
			for(Iterator<INode> it = target.iterator(); it.hasNext();) {
				INode tn = it.next();
				if(!tns.contains(tn))
					target.removeValue(tn, this);
			}
			
		} else if(idxVarInProp==1) { // source => edge, target
			Set<INode> sns = new HashSet<>();
			source.lowerBoundIterator().forEachRemaining(tn->{
				sns.add(tn);
			});
			
			Set<INode> tns = new HashSet<>();
			
			IEdge ev = null;
			for(Iterator<IEdge> it = edge.upperBoundIterator();it.hasNext();) {
				ev = it.next();
				if(sns.contains(ev.getSource())) {
					tns.add(ev.getTarget());
				} else {
					edge.remove(ev, this);
				}
			}
			
			INode tv = null;
			for(Iterator<INode> it = target.iterator();it.hasNext();) {
				tv = it.next();
				if(!tns.contains(tv)) {
					target.removeValue(tv, this);
				}
			}
		}
	}

	public void handleAddToKer(int idxVarInProp) throws ContradictionException {
		if(idxVarInProp==0) { // edge
			Set<INode> sns = new HashSet<>();
			
			edge.lowerBoundIterator().forEachRemaining(e->{
				sns.add(e.getSource());
			});
			
			for(INode ssn : sns) source.force(ssn, this);
		}
	}

	@Override
	public ESat isEntailed() {
		if(edge.isInstantiated() && source.isInstantiated() && target.isInstantiated()) {
			INode tv = target.getValue();
			Set<INode> sns = new HashSet<>();
			
			IEdge ev = null;
			for(Iterator<IEdge> it = edge.lowerBoundIterator(); it.hasNext();) {
				ev = it.next();
				if(ev.getTarget()!=tv) return ESat.FALSE;
				sns.add(ev.getSource());
			}
			
			Set<INode> aSns = source.getLBValue();
			
			if(aSns.equals(sns)) {
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
				
				if(tns.size()!=1) return ESat.FALSE;
				
				if(target.isInstantiated()) {
					INode tv = target.getValue();
					if(tns.contains(tv)) return ESat.TRUE;
					else return ESat.FALSE;
				} else if(source.isInstantiated()){
					if(source.getLBValue().equals(sns)) {
						return ESat.TRUE;
					} else return ESat.FALSE;
				}
			}
		}
		return ESat.UNDEFINED;
	}

}
