package edu.ustb.sei.mde.morel.resource.morel.execution.constraints;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import edu.ustb.sei.mde.emg.graph.ModelSpace;
import edu.ustb.sei.mde.emg.runtime.Environment;
import solver.constraints.Propagator;
import solver.constraints.PropagatorPriority;
import solver.exception.ContradictionException;
import solver.variables.EventType;
import solver.variables.IntVar;
import solver.variables.delta.IIntDeltaMonitor;
import util.ESat;
import util.tools.ArrayUtils;

public class PropLinkS_T extends Propagator<IntVar> {
	private static final long serialVersionUID = -7064792404577803139L;
	private IntVar source;
	private IntVar target;
	private EReference reference;
	private Environment environment;
	private IIntDeltaMonitor[] idms;
	
	public PropLinkS_T(IntVar source, IntVar target, EReference reference,Environment environment) {
		super(ArrayUtils.toArray(source,target), PropagatorPriority.BINARY, true);
		
		this.source = source;
		this.target = target;
		this.reference = reference;
		this.environment = environment;
		
		idms = new IIntDeltaMonitor[2];
		idms[0] = vars[0].monitorDelta(this);
        idms[1] = vars[1].monitorDelta(this);
	}


	@SuppressWarnings("unchecked")
	@Override
	public void propagate(int evtmask) throws ContradictionException {
		ArrayList<EObject> tarList = new ArrayList<EObject>();
		
        idms[0].freeze();
        idms[1].freeze();
		
		for(int s = source.getLB(); s<=source.getUB(); s = source.nextValue(s)) {
			EObject so = ModelSpace.getElementByID(s);
			
			
			if(reference.isMany()) {
				Collection<? extends EObject> list = (Collection<? extends EObject>)so.eGet(reference);
				if(list.size()==0) source.removeValue(s, aCause);
				else {
					tarList.addAll(list);
				}
			} else {
				if(so.eGet(reference)==null)
					source.removeValue(s, aCause);
				else
					tarList.add((EObject) so.eGet(reference));
			}
		}
		
		for(int t = target.getLB(); t<=target.getUB(); t=target.nextValue(t)) {
			EObject to = ModelSpace.getElementByID(t);
			if(tarList.contains(to)==false)
				target.removeValue(t, aCause);
		}
		
        idms[0].unfreeze();
        idms[1].unfreeze();
        
		if(source.isInstantiated() && target.isInstantiated()) {
			setPassive();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void propagate(int idxVarInProp, int mask)
			throws ContradictionException {
		if (EventType.isInstantiate(mask)) {
            if (idxVarInProp == 0) {
                int s = source.getValue();
                EObject so = ModelSpace.getElementByID(s);
                
                idms[1].freeze();
    			if(reference.isMany()) {
    				List<EObject> list = (List<EObject>)so.eGet(reference);
    				
    				for(int t = target.getLB(); t<=target.getUB(); t=target.nextValue(t)) {
    					EObject to = ModelSpace.getElementByID(t);
    					if(list.contains(to)==false)
    						target.removeValue(t, aCause);
    				}
    			} else {
    				if(so.eGet(reference)!=null) {
    					EObject to = (EObject) so.eGet(reference);
    					target.instantiateTo(ModelSpace.getElementID(to), aCause);
    				}
    			}
    	        idms[1].unfreeze();
            } else {
            	int t = target.getValue();
            	EObject to = ModelSpace.getElementByID(t);
                idms[0].freeze();
            	for(int s = source.getLB();s<=source.getUB();s=source.nextValue(s)) {
            		EObject so = ModelSpace.getElementByID(s);
            		if(reference.isMany()) {
            			List<EObject> list = (List<EObject>)so.eGet(reference);
            			if(list.contains(to)==false)
            				source.removeValue(s, aCause);
            		} else {
            			if(to!=so.eGet(reference))
            				source.removeValue(s, aCause);
            		}
            	}
                idms[0].unfreeze();
            }
        }
		
		if(source.isInstantiated() && target.isInstantiated()) {
			setPassive();
		}
	}


	@SuppressWarnings("unchecked")
	@Override
	public ESat isEntailed() {
		for(int s = source.getLB(); s<= source.getUB(); s=source.nextValue(s)) {
			EObject so = ModelSpace.getElementByID(s);
			if(reference.isMany()) {
				List<EObject> list = (List<EObject>)so.eGet(reference);
				for(EObject to : list) {
					int toi = ModelSpace.getElementID(to);
					if(target.contains(toi))
						return ESat.TRUE;
				}
			} else {
				EObject to = (EObject)so.eGet(reference);
				if(to!=null) {
					int toi = ModelSpace.getElementID(to);
					if(target.contains(toi))
						return ESat.TRUE;
				}
			}
		}
		return ESat.FALSE;
	}

}
