package edu.ustb.sei.mde.morel.resource.morel.execution.constraints;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import edu.ustb.sei.mde.emg.graph.ModelUniverse;
import edu.ustb.sei.mde.emg.runtime.Environment;
import solver.constraints.ICF;
import solver.constraints.Propagator;
import solver.constraints.PropagatorPriority;
import solver.exception.ContradictionException;
import solver.variables.IntVar;
import solver.variables.delta.IIntDeltaMonitor;
import solver.variables.events.IntEventType;
import solver.variables.events.PropagatorEventType;
import util.ESat;
import util.tools.ArrayUtils;

public class PropEnclosureLinkS_T extends Propagator<IntVar> {
	private static final long serialVersionUID = 7821428208629752741L;
	
	private IntVar source;
	
	private IntVar target;
	
	private List<EReference> references;//this collection determines what kinds of arcs can be traveled through
	
	private List<EClass> types;
	
	private Environment environment;
	private ModelUniverse modelUniverse;
	
	private IIntDeltaMonitor[] idms;
	
	private ReferenceChangeListener listener = null;
	
	private boolean emptyAllowed = false;
	private int maxLength = -1;
	
	

	public PropEnclosureLinkS_T(IntVar source, IntVar target,List<EReference> references, List<EClass> types, Environment environment) {
		super(ArrayUtils.toArray(source,target), PropagatorPriority.TERNARY, true);
		this.source = source;
		this.target = target;
		this.references = references;
		this.environment = environment;
		modelUniverse = environment.getModelUniverse();
		this.types = types;
		
		listener = (ReferenceChangeListener) modelUniverse.getUnveriseRelatedObject(ReferenceChangeListener.class);

		
		idms = new IIntDeltaMonitor[2];
		idms[0] = vars[0].monitorDelta(this);
        idms[1] = vars[1].monitorDelta(this);
	}

	@Override
	public ESat isEntailed() {
		for(int s = source.getLB(); s<= source.getUB(); s=source.nextValue(s)) {
			List<EObject> list = collect(s);
			for(EObject to : list) {
				int toi = modelUniverse.getElementID(to);
				if(target.contains(toi))
					return ESat.TRUE;
			}
		}
		return ESat.FALSE;
	}

	@Override
	public void propagate(int evtmask) throws ContradictionException {
		// TODO Auto-generated method stub
		ArrayList<EObject> tarList = new ArrayList<EObject>();
		
        idms[0].freeze();
        idms[1].freeze();
        
        for(int s = source.getLB();s<=source.getUB();s=source.nextValue(s)) {
			List<EObject> list = collect(s);
			if(list.size()==0)
				source.removeValue(s, aCause);
			else
				tarList.addAll(list);
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
	/////////////////////////MAY BE REPLACED///////////////////////////
	private List<EObject> collect(int s) {
		EObject so = modelUniverse.getElementByID(s);
		
		UniqueEList<EObject> list = modelUniverse.getObjectReachableList().get(so, references);
		if(list==null) {

			if(so.eAdapters().contains(listener))
				so.eAdapters().add(listener);
			
			list = new UniqueEList<EObject>();
			modelUniverse.getObjectReachableList().put(so, references, list);
			int oldSize = 0;
			int pace = 0;			
			list.add(so);
			do {
				int currSize = list.size();
				if(oldSize==currSize) break;
				int ni = oldSize;
				
				oldSize = list.size();
				
				for(;ni<currSize;ni++) {
					EObject nso = list.get(ni);
					for(EReference r : references) {
						collect(nso,r,list);
					}
				}
				pace++;
			} while((maxLength<0||pace<=maxLength));
			if(!emptyAllowed) list.remove(0);
		}
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	private void collect(EObject s, EReference r, List<EObject> list) {
		EClass cls = s.eClass();
		if(cls.getEAllReferences().contains(r)) {
			if(r.isMany()) {
				List<EObject> col = (List<EObject>)s.eGet(r);
				//list.addAll(col);
				for(EObject o : col) {
					if(checkType(o)) {
						list.add(o);
						modelUniverse.getPrefixObjects().put(o, s);
					}
				}
			} else {
				if(s.eGet(r)!=null){
					EObject obj = (EObject) s.eGet(r);
					if(checkType(obj)){
						list.add(obj);
						modelUniverse.getPrefixObjects().put(obj, s);
					}
				}
			}
		}
	}
	
	private boolean checkType(EObject o) {
		if(types.size()==0) return true;
		
		for(EClass c: types) {
			if(c.isSuperTypeOf(o.eClass()))
				return true;
		}
		return false;
	}
	///////////////////////////////////////////////////////////
	

	@Override
	public void propagate(int idxVarInProp, int mask)
			throws ContradictionException {
		if (IntEventType.isInstantiate(mask)) {
			if (idxVarInProp == 0) {
				int s = source.getValue();
				List<EObject> list = collect(s);
				
				for(int t = target.getLB(); t<=target.getUB(); t=target.nextValue(t)) {
					EObject to = modelUniverse.getElementByID(t);
					if(!list.contains(to)) {
						idms[1].freeze();
						target.removeValue(t, aCause);
						idms[1].unfreeze();						
					}
				}
			} else {
				int t = target.getValue();
				EObject to = modelUniverse.getElementByID(t);
				for(int s = source.getLB();s<=source.getUB();s=source.nextValue(s)) {
					List<EObject> list = collect(s);
					if(!list.contains(to)) {
						idms[0].freeze();
						source.removeValue(s, aCause);
						idms[0].unfreeze();						
					}
					
				}
			}
			if(source.isInstantiated()==false && source.getLB()==source.getUB()) source.instantiateTo(source.getLB(), aCause);
			if(target.isInstantiated()==false && target.getLB()==target.getUB()) target.instantiateTo(target.getLB(), aCause);
			if(source.isInstantiated() && target.isInstantiated()) {
				setPassive();
			}
		}
	}

	final static public Class<? extends Adapter> listenerType =  ReferenceChangeListener.class;
}

