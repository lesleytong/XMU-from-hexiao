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
	
	public PropPathS_C_T(IntVar source, IntVar target,
			IntVar size, IntVar[] path,
			PairHashSet<Integer, Integer> table,
			PropagatorPriority priority, boolean reactToFineEvt) {
		super(ArrayUtils.append(new IntVar[]{source,target,size},path),priority,reactToFineEvt);
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
		
	}
	
	private void filterForward(int id) throws ContradictionException {
		if(id==1 || id==2)//target or size
			return;
		
		IntVar[] allVars = getVars();
		int nextID = getNextID(id);
		
		IntVar s = allVars[id];
		
		if(s.isInstantiated()==false) 
			return;
		
		IntVar t = allVars[nextID];
		
		
		if(s.isInstantiatedTo(EIdentifiable.NULL_ID)) {
			// assert(source.contains(0)==false);
			// assert(target.contains(0)==false);
			size.removeValue(id-2, aCause);
			if(nextID!=1){
				t.instantiateTo(EIdentifiable.NULL_ID, aCause);
				filterForward(nextID);				
			}
		} else {
			//STEP 1 test if there exists i in s and j in target that make (i,j) in table held
			//if no, remove id-2 from size;
			
			//STEP 2 test nextID
			
			if(t.isInstantiatedTo(EIdentifiable.NULL_ID)) {
				nextID = 1;
				t = allVars[1];
			}
			
			int si = s.getValue();
			if(EIdentifiable.isValid(si)==false) return;
			for(int ti = t.getLB(); ti<=t.getUB();ti=t.nextValue(ti)){
				if(EIdentifiable.isValid(ti)==false) continue;
				if(table.contains(si, ti)==false) {
					t.removeValue(ti,aCause);
				}
			}
			if(t.isInstantiated())
				filterForward(nextID);
		}
	}

	protected int getNextID(int id) {
		IntVar[] allVars = getVars();
		int nextID = -1;
		if(id==0) nextID = 3;
		else nextID = id+1;
		
		if(nextID>=allVars.length) nextID = 1;
		return nextID;
	}

	protected int getPrevID(int id) {
		IntVar[] allVars = getVars();
		int prevID = -1;
		if(id==1) prevID = allVars.length-1;
		else prevID = id-1;
		if(prevID==2) prevID = 0;
		return prevID;
	}

	@Override
	public ESat isEntailed() {
		// TODO Auto-generated method stub
		return null;
	}

}
