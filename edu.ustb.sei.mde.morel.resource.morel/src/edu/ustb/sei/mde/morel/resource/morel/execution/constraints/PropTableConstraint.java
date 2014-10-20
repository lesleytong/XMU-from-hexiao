package edu.ustb.sei.mde.morel.resource.morel.execution.constraints;

import edu.ustb.sei.commonutil.util.PairHashSet;
import edu.ustb.sei.mde.emg.graph.EIdentifiable;
import solver.constraints.Propagator;
import solver.constraints.PropagatorPriority;
import solver.exception.ContradictionException;
import solver.variables.IntVar;
import solver.variables.events.IntEventType;
import util.ESat;
import util.tools.ArrayUtils;

public class PropTableConstraint extends Propagator<IntVar> {
	private IntVar source;
	private IntVar target;
	private PairHashSet<Integer,Integer> table = null;
	
	@Override
	public void propagate(int evtmask) throws ContradictionException {
		// TODO Auto-generated method stub
		filterFromSrc();
		filterFromTar();
	}
	
	private void filterFromSrc() throws ContradictionException {
		for(int ti = target.getLB();ti<=target.getUB();ti = target.nextValue(ti)) {
			if(EIdentifiable.isValid(ti)==false) continue;
			boolean fi = false;
			for(int si = source.getLB();si<=source.getUB();si = source.nextValue(si)) {
				if(EIdentifiable.isValid(si)==false) continue;
				if(table.contains(si, ti)) {
					fi = true;
					break;
				}
			}
			if(fi==false)
				target.removeValue(ti, aCause);
		}
	}
	
	private void filterFromTar() throws ContradictionException {
		for(int si = source.getLB();si<=source.getUB();si = source.nextValue(si)) {
			if(EIdentifiable.isValid(si)==false) continue;
			boolean fi = false;
			for(int ti = target.getLB();ti<=target.getUB();ti = target.nextValue(ti)) {
				if(EIdentifiable.isValid(ti)==false) continue;
				if(table.contains(si, ti)) {
					fi = true;
					break;
				}
			}
			if(fi==false)
				source.removeValue(si, aCause);
		}
	}

	public PropTableConstraint(IntVar source, IntVar target,
			PairHashSet<Integer, Integer> table) {
		super(new IntVar[]{source,target},PropagatorPriority.BINARY,true);
		this.source = source;
		this.target = target;
		this.table = table;
	}

	@Override
	public ESat isEntailed() {
		if(source.isInstantiated() && target.isInstantiated()) {
			if(table.contains(source.getValue(), target.getValue()))
				return ESat.TRUE;
			else return ESat.FALSE;
		}
		return ESat.UNDEFINED;
	}

	@Override
	public void propagate(int idxVarInProp, int mask)
			throws ContradictionException {
		if(IntEventType.isInstantiate(mask)) {
			if(idxVarInProp==0)
				filterFromSrc();
			else filterFromTar();
		}
	}

}
