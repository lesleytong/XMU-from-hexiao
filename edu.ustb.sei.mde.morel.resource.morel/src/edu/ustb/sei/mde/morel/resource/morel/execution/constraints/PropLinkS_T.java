package edu.ustb.sei.mde.morel.resource.morel.execution.constraints;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import edu.ustb.sei.mde.emg.graph.ModelUniverse;
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
	private List<EReference> references;
	private Environment environment;
	private ModelUniverse modelUniverse;
	private IIntDeltaMonitor[] idms;
	
	public PropLinkS_T(IntVar source, IntVar target, EReference reference,Environment environment) {
		super(ArrayUtils.toArray(source,target), PropagatorPriority.BINARY, true);
		
		this.source = source;
		this.target = target;
		this.references = new ArrayList<EReference>();
		this.references.add(reference);
		this.environment = environment;
		this.modelUniverse = environment.getModelUniverse();
		
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
			EObject so = modelUniverse.getElementByID(s);
			boolean toBeDeleted = true;
			
			for(EReference ref : references) {
				if(ref.isMany()) {
					Collection<? extends EObject> list = (Collection<? extends EObject>)so.eGet(ref);
					if(list.size()==0) //source.removeValue(s, aCause);
						continue;
					else {
						toBeDeleted = false;
						tarList.addAll(list);
					}
				} else {
					if(so.eGet(ref)==null) {
						//source.removeValue(s, aCause);
						continue;
					}
					else{
						toBeDeleted = false;
						tarList.add((EObject) so.eGet(ref));
					}
				}
			}
			
			if(toBeDeleted)
				source.removeValue(s, aCause);
		}
		
		for(int t = target.getLB(); t<=target.getUB(); t=target.nextValue(t)) {
			EObject to = modelUniverse.getElementByID(t);
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
				EObject so = modelUniverse.getElementByID(s);
				for(int t = target.getLB(); t<=target.getUB(); t=target.nextValue(t)) {
					EObject to = modelUniverse.getElementByID(t);
					boolean toBeDeleted = true;
					for(EReference ref : references) {
						if(ref.isMany()) {
							List<EObject> list = (List<EObject>)so.eGet(ref);
							if(list.contains(to)) {
								toBeDeleted = false;
								break;
							}
						} else {
							if(to==so.eGet(ref)) {
								toBeDeleted = false;
								break;
							}
						}
					}
					idms[1].freeze();
					if(toBeDeleted) 
						target.removeValue(t, aCause);
					idms[1].unfreeze();					
				}
			} else {
				int t = target.getValue();
				EObject to = modelUniverse.getElementByID(t);
				for(int s = source.getLB();s<=source.getUB();s=source.nextValue(s)) {
					EObject so = modelUniverse.getElementByID(s);
					boolean toBeDeleted = true;
					for(EReference ref :references) {
						if(ref.isMany()) {
							List<EObject> list = (List<EObject>)so.eGet(ref);
							if(list.contains(to)){
								toBeDeleted = false;
								break;
							}
//							source.removeValue(s, aCause);
						} else {
							if(to==so.eGet(ref)){
								toBeDeleted = false;
								break;
							}
						}
					}
					idms[0].freeze();
					if(toBeDeleted)
						source.removeValue(s, aCause);
					idms[0].unfreeze();
				}
			}
			if(source.isInstantiated()==false && source.getLB()==source.getUB()) source.instantiateTo(source.getLB(), aCause);
			if(target.isInstantiated()==false && target.getLB()==target.getUB()) target.instantiateTo(target.getLB(), aCause);
			if(source.isInstantiated() && target.isInstantiated()) {
				setPassive();
			}
		}
		
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public ESat isEntailed() {
		for(int s = source.getLB(); s<= source.getUB(); s=source.nextValue(s)) {
			EObject so = modelUniverse.getElementByID(s);
			for(EReference ref : references) {
				if(ref.isMany()) {
					List<EObject> list = (List<EObject>)so.eGet(ref);
					for(EObject to : list) {
						int toi = modelUniverse.getElementID(to);
						if(target.contains(toi))
							return ESat.TRUE;
					}
				} else {
					EObject to = (EObject)so.eGet(ref);
					if(to!=null) {
						int toi = modelUniverse.getElementID(to);
						if(target.contains(toi))
							return ESat.TRUE;
					}
				}
			}
		}
		return ESat.FALSE;
	}

}
