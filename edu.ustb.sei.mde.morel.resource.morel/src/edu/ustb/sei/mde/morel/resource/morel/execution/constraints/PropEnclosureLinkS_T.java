package edu.ustb.sei.mde.morel.resource.morel.execution.constraints;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.commonutil.util.MultipleHashMap;
import edu.ustb.sei.commonutil.util.PairHashMap;
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

public class PropEnclosureLinkS_T extends Propagator<IntVar> {
	private static final long serialVersionUID = 7821428208629752741L;
	
	private IntVar source;
	
	private IntVar target;
	
	private List<EReference> references;//this collection determines what kinds of arcs can be traveled through
	
	private List<EClass> types;
	
	private Environment environment;
	
	private IIntDeltaMonitor[] idms;
	
	private boolean emptyAllowed = false;
	private int maxLength = -1;
	
	

	public PropEnclosureLinkS_T(IntVar source, IntVar target,List<EReference> references, List<EClass> types, Environment environment) {
		super(ArrayUtils.toArray(source,target), PropagatorPriority.TERNARY, true);
		this.source = source;
		this.target = target;
		this.references = references;
		this.environment = environment;
		this.types = types;
		
		idms = new IIntDeltaMonitor[2];
		idms[0] = vars[0].monitorDelta(this);
        idms[1] = vars[1].monitorDelta(this);
	}

	@Override
	public ESat isEntailed() {
		for(int s = source.getLB(); s<= source.getUB(); s=source.nextValue(s)) {
			List<EObject> list = collect(s);
			for(EObject to : list) {
				int toi = ModelSpace.getElementID(to);
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
	
	static protected PairHashMap<EObject, List<EReference>, UniqueEList<EObject>> objectReachableList = new PairHashMap<EObject, List<EReference>, UniqueEList<EObject>>();
	static protected MultipleHashMap<EObject, EObject> prefixObjects = new MultipleHashMap<EObject, EObject>(false);
	
	static public void resetCache() {
		objectReachableList.reset();
		prefixObjects.reset();
	}
	
	private List<EObject> collect(int s) {
		EObject so = ModelSpace.getElementByID(s);
		
		UniqueEList<EObject> list = objectReachableList.get(so, references);
		if(list==null) {

			if(so.eAdapters().contains(ReferenceChangeListener.instance))
				so.eAdapters().add(ReferenceChangeListener.instance);
			
			list = new UniqueEList<EObject>();
			objectReachableList.put(so, references, list);
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
						prefixObjects.put(o, s);
					}
				}
			} else {
				if(s.eGet(r)!=null){
					EObject obj = (EObject) s.eGet(r);
					if(checkType(obj)){
						list.add(obj);
						prefixObjects.put(obj, s);
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
	

	@Override
	public void propagate(int idxVarInProp, int mask)
			throws ContradictionException {
		if (EventType.isInstantiate(mask)) {
			if (idxVarInProp == 0) {
				int s = source.getValue();
				List<EObject> list = collect(s);
				
				for(int t = target.getLB(); t<=target.getUB(); t=target.nextValue(t)) {
					EObject to = ModelSpace.getElementByID(t);
					if(!list.contains(to)) {
						idms[1].freeze();
						target.removeValue(t, aCause);
						idms[1].unfreeze();						
					}
				}
			} else {
				int t = target.getValue();
				EObject to = ModelSpace.getElementByID(t);
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
}


class ReferenceChangeListener implements Adapter {
	
	public static final ReferenceChangeListener instance = new ReferenceChangeListener();

	@Override
	public void notifyChanged(Notification notification) {
		EObject source = (EObject) notification.getNotifier();
		EStructuralFeature feature = (EStructuralFeature) notification.getFeature();
		if(feature instanceof EReference) {
			PropEnclosureLinkS_T.objectReachableList.remove(source);
			visited.clear();
			clearPrefix(source);
		}
	}
	
	private HashSet<EObject> visited = new HashSet<EObject>();
	private void clearPrefix(EObject o) {
		if(visited.contains(o)) return;
		visited.add(o);
		
		Collection<EObject> col = PropEnclosureLinkS_T.prefixObjects.get(o);
		for(EObject no : col) {
			PropEnclosureLinkS_T.objectReachableList.remove(no);
			clearPrefix(no);
		}
	}

	@Override
	public Notifier getTarget() {
		return null;
	}

	@Override
	public void setTarget(Notifier newTarget) {
	}

	@Override
	public boolean isAdapterForType(Object type) {
		if(type instanceof EObject)
			return true;
		else return false;
	}
	
}