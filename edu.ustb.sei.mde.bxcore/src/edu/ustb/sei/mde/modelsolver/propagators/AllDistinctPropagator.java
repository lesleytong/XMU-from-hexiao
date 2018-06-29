package edu.ustb.sei.mde.modelsolver.propagators;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.chocosolver.solver.constraints.Propagator;
import org.chocosolver.solver.constraints.PropagatorPriority;
import org.chocosolver.solver.exception.ContradictionException;
import org.chocosolver.solver.variables.IntVar;
import org.chocosolver.solver.variables.events.IntEventType;
import org.chocosolver.util.ESat;

import edu.ustb.sei.mde.modelsolver.SemanticDomainVar;

public class AllDistinctPropagator extends Propagator<IntVar> {
	
	@SuppressWarnings("rawtypes")
	private List<SemanticDomainVar> domVars;
	
	@SuppressWarnings("rawtypes") 
	public AllDistinctPropagator(List<SemanticDomainVar> domVars) {
		super(domVars.stream().map(d->d.internalIntVar()).toArray(size->new IntVar[size]),PropagatorPriority.LINEAR, true);
		this.domVars = domVars;
	}
	
	@Override
	public int getPropagationConditions(int vIdx) {
		return IntEventType.instantiation();
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void propagate(int evtmask) throws ContradictionException {
		List<SemanticDomainVar> fixedVars = new ArrayList<>();
		domVars.forEach(dv->{if(dv.isInstantiated()) fixedVars.add(dv);});
		if(fixedVars.isEmpty()) return;
		else {
			for(SemanticDomainVar dv : domVars) {
				if(dv.isInstantiated()==false) {
					for(SemanticDomainVar fv : fixedVars) {
						Object so = fv.getSemanticObject();
						int id = dv.getSemanticObjectId(so);
						if(id!=-1) dv.removeValue(id, this);
					}
				}
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void propagate(int idxVarInProp, int mask) throws ContradictionException {
		if(IntEventType.isInstantiate(mask)) {
			SemanticDomainVar v = this.domVars.get(idxVarInProp);
			Object so = v.getSemanticObject();
			
			for(SemanticDomainVar dv : domVars) {
				if(dv.isInstantiated()==false) {
					int id = dv.getSemanticObjectId(so);
					if(id!=-1) dv.removeValue(id, this);					
				}
			}
			
		}
	}

	@Override
	public ESat isEntailed() {
		if(domVars.stream().allMatch(dv->dv.isInstantiated())==false)
			return ESat.UNDEFINED;
		else {
			Set<Object> values = new HashSet<>();
			for(SemanticDomainVar<?> v : domVars) {
				Object o = v.getSemanticObject();
				if(values.contains(o)) return ESat.FALSE;
				values.add(o);
			}
			return ESat.TRUE;
		}
	}

}
