package edu.ustb.sei.mde.morel.resource.morel.execution.constraints;

import edu.ustb.sei.commonutil.util.PairHashMap;
import edu.ustb.sei.commonutil.util.PairHashSet;
import edu.ustb.sei.mde.emg.graph.EIdentifiable;
import solver.constraints.Propagator;
import solver.constraints.PropagatorPriority;
import solver.exception.ContradictionException;
import solver.variables.IntVar;
import util.ESat;
import util.tools.ArrayUtils;

public class PropPathS_C_T extends Propagator<IntVar> {
	private static final long serialVersionUID = 5730502659674889423L;

	public PropPathS_C_T(IntVar source, IntVar target,
			IntVar size, IntVar[] path,
			PairHashSet<Integer, Integer> table,
			PropagatorPriority priority, boolean reactToFineEvt) {
		super(ArrayUtils.append(new IntVar[]{source},path, new IntVar[]{target,size}),priority,reactToFineEvt);
		
		this.source = source;
		this.target = target;
		this.size = size;
		this.path = path;
		this.table = table;
	}
	
	private IntVar source;
	private IntVar target;
	private IntVar size;
	private IntVar[] path;
	private PairHashSet<Integer,Integer> table = null;

	@Override
	public void propagate(int evtmask) throws ContradictionException {
		// TODO Auto-generated method stub
		filterPath(0);
		filterTarget();
		for(int i = 1; i<vars.length-2;i++)
			filterSize(i);
	}
	
	
	
	@Override
	public void propagate(int idxVarInProp, int mask)
			throws ContradictionException {		
		//if(EventType.anInstantiationEvent(mask)) {
			if(idxVarInProp<vars.length-2){
				filterPath(idxVarInProp);
				filterPathBackward(idxVarInProp);
			} else if(idxVarInProp==vars.length-1){
				propSize();
			}
			filterTarget();
			if(allInstantiated()){
				this.setPassive();
			}
		//}
	}



	protected boolean allInstantiated() {
		for(IntVar v : vars) {
			if(v.isInstantiated()==false) return false;
		}
		return true;
	}

	private void filterPathBackward(int id) throws ContradictionException {
		if(id<=1) return;
		
		IntVar t = vars[id];
		int prevID = id-1;
		IntVar s = vars[prevID];
		
		for(int si = s.getLB();si<=s.getUB();si = s.nextValue(si)) {
			if(EIdentifiable.isValid(si)==false) continue;
			boolean fs = false;
			for(int ti = t.getLB();ti<=t.getUB();ti=t.nextValue(ti)) {
				if(EIdentifiable.isValid(ti)==false) continue;
				if(table.contains(si, ti)) {
					fs = true;
					break;
				}
			}
			if(!fs) {
				if(s.removeValue(si, aCause))
					filterPathBackward(prevID);
			}
		}
	}

	private void filterTarget() throws ContradictionException {
		IntVar[] vars = this.getVars();
		
		for(int ti = target.getLB(); ti<=target.getUB(); ti = target.nextValue(ti)) {
			boolean ft = false;
			TEST_EXIST:
				for(int i = 0;i<vars.length-2;i++) {
					if(size.contains(i)==false) continue;
					for(int si = vars[i].getLB(); si <= vars[i].getUB(); si = vars[i].nextValue(si)) {
						if(EIdentifiable.isValid(si)==false) continue;
						if(table.contains(si, ti)) {
							ft = true;
							break TEST_EXIST;
						}
					}
				}
			if(!ft) 
				target.removeValue(ti, aCause);
		}
	}
	
	private void filterSize(int id) throws ContradictionException{
		IntVar[] vars = this.getVars();
		if(id==0 || id>=vars.length-2) return;
		
		boolean ft = false;
		
		TEST_EXIST:
			for(int si = vars[id].getLB(); si<=vars[id].getUB(); si = vars[id].nextValue(si)) {
				if(EIdentifiable.isValid(si)==false) continue;
				for(int ti = target.getLB(); ti <= target.getUB(); ti = target.nextValue(ti)) {
					if(table.contains(si, ti)) {
						ft = true;
						break TEST_EXIST;
					}
				}
			}
		if(!ft) {
			size.removeValue(id, aCause);
			//vars[id+1].removeValue(0, aCause);
		}
	}
	
	private void filterPath(int id) throws ContradictionException {
		IntVar[] vars = this.getVars();
		IntVar s = vars[id];
		int nextID = id +1;
		if(nextID==vars.length-1) return;
		if(nextID==vars.length-2 && s.contains(0)) return;
		
		IntVar t = vars[nextID];
		
		if(s.isInstantiatedTo(0)) {
			if(t.instantiateTo(0, aCause)) {
				this.filterPath(nextID);
			}
			size.removeValue(id, aCause);
		} else {
			boolean changed = false;
			for(int ti = t.getLB(); ti<=t.getUB(); ti = t.nextValue(ti)) {
				if(EIdentifiable.isValid(ti)==false) continue;
				boolean ft = false;
				for(int si = s.getLB(); si<=s.getUB(); si = s.nextValue(si)) {
					if(EIdentifiable.isValid(si)==false) continue;
					if(table.contains(si, ti)){
						ft = true;
						break;
					}
				}
				if(!ft) {
					changed = t.removeValue(ti, aCause) || changed;
				}
			}
			if(changed) 
				this.filterPath(nextID);
		}
	}
	
	private void propSize() throws ContradictionException {
		if(size.isInstantiated()) {
			int v = size.getValue();
			for(int i = 1;i<vars.length-2;i++){
				if(i<=v)
					vars[i].removeValue(0, aCause);
				else
					vars[i].instantiateTo(0, aCause);
			}
		} else {
//			for(int i=1;i<=size.getLB()+1;i++) {
//				if(size.contains(i)) continue;
//				vars[i].removeValue(0, aCause);
//			}
		}
	}

	@Override
	public ESat isEntailed() {
		int prev = 0;
		final int tar = vars.length-2;
		
		for(int cur = 0;cur<vars.length-2;cur++){
			if(isConnective(prev,cur)==false) 
				return ESat.FALSE;
			else {
				prev = cur;
				if(isConnective(cur,tar) && isTerminable(cur+1))
					return ESat.TRUE;
			}
		}
		return ESat.FALSE;
	}
	
	private boolean isConnective(int prev, int cur) {
		if(prev==cur) return true;
		else {
			IntVar prevNode = vars[prev];
			IntVar curNode = vars[cur];
			
			for(int s = prevNode.getLB(); s<= prevNode.getUB(); s=prevNode.nextValue(s)) {
				if(EIdentifiable.isValid(s)==false) continue;
				for(int t = curNode.getLB(); t<= curNode.getUB(); t=curNode.nextValue(t)) {
					if(EIdentifiable.isValid(t)==false) continue;
					if(table.contains(s, t)) return true;
				}
			}
			return false;
		}
	}

	private boolean isTerminable(int cur) {
		if(cur==vars.length-2) return true;
		IntVar var = vars[cur];
		if(var.contains(0) && size.contains(cur))
			return true;
		return false;
	}

}
