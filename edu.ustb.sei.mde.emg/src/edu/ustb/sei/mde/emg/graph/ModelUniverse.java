package edu.ustb.sei.mde.emg.graph;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import edu.ustb.sei.commonutil.util.BidirectionalMap;
import edu.ustb.sei.commonutil.util.MultipleHashMap;
import edu.ustb.sei.commonutil.util.PairHashMap;

public class ModelUniverse {

	private PairHashMap<EObject, EReference, int[]> elemRelMap = new PairHashMap<EObject, EReference, int[]>();
	private BidirectionalMap<Integer, EObject> idObjMap  = new BidirectionalMap<Integer,EObject>();
	private MultipleHashMap<EObject, EObject> prefixObjects = new MultipleHashMap<EObject, EObject>(false);
	private PairHashMap<EObject, List<EReference>, UniqueEList<EObject>> objectReachableList = new PairHashMap<EObject, List<EReference>, UniqueEList<EObject>>();

	public ModelSpace createModelSpace() {
		return new ModelSpace(this);
	}

	/**
	 * get all target ids based the source object and reference
	 * @param source
	 * @param ref
	 * @return
	 */
	public int[] getElementRelationship(EObject source, EReference ref) {
		int[] array = getElemRelMap().get(source, ref);
		if(array==null) {
			if(ref.isMany()) {
				@SuppressWarnings("unchecked")
				EList<EObject> targets = (EList<EObject>)source.eGet(ref);
				array = new int[targets.size()];
				for(int i=0;i<array.length;i++) {
					array[i] = getElementID(targets.get(i));
				}
			} else {
				EObject target = (EObject)source.eGet(ref);
				array = new int[1];
				array[0] = getElementID(target);
			}
		}
		
		return array;
	}

	public int getElementID(EObject object) {
		if(object == null)
			return EIdentifiable.NULL_ID;
		try {
			return getIdObjMap().backward(object);
		} catch(Exception e) {
			System.out.println("Exception when returning ID of "+object);
			return EIdentifiable.INVALID_ID;
		}
	}

	public EObject getElementByID(int id) {
		if(id<=EIdentifiable.NULL_ID)
			return null;
		return getIdObjMap().forward(id);
	}

	public PairHashMap<EObject, EReference, int[]> getElemRelMap() {
		return elemRelMap;
	}

	public void setElemRelMap(PairHashMap<EObject, EReference, int[]> elemRelMap) {
		this.elemRelMap = elemRelMap;
	}

	public BidirectionalMap<Integer, EObject> getIdObjMap() {
		return idObjMap;
	}

	public void setIdObjMap(BidirectionalMap<Integer, EObject> idObjMap) {
		this.idObjMap = idObjMap;
	}

	public void resetELCCache() {
		getObjectReachableList().reset();
		getPrefixObjects().reset();
	}

	public MultipleHashMap<EObject, EObject> getPrefixObjects() {
		return prefixObjects;
	}

	public PairHashMap<EObject, List<EReference>, UniqueEList<EObject>> getObjectReachableList() {
		return objectReachableList;
	}
	
	private HashMap<Object, Object> unveriseRelatedMap = new HashMap<Object, Object>();

	@SuppressWarnings("unchecked")
	public <T> T getUnveriseRelatedObject(Class<? extends T> cls) {
		Object o = unveriseRelatedMap.get(cls);
		if(o==null){
			try {
				Constructor<? extends T> c = cls.getConstructor(ModelUniverse.class);
				o = c.newInstance(this);
				unveriseRelatedMap.put(cls, o);
			} catch (NoSuchMethodException | SecurityException
					| InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return (T)o;
	}
	
	public List<EObject> collectReachable(EObject so, List<EReference> references, List<EClass> types,Class<? extends Adapter> listenerClass){
		return collectReachable(so,references,types,listenerClass,false,-1);
	}
	public List<EObject> collectReachable(EObject so, List<EReference> references, List<EClass> types,Class<? extends Adapter> listenerClass, boolean emptyAllowed, int maxLength) {
		
		UniqueEList<EObject> list = this.getObjectReachableList().get(so, references);
		if(list==null) {

			list = collectEnclosureReachable(so, references, types,
					emptyAllowed, maxLength, listenerClass);
		}
		
		return list;
	}

	public UniqueEList<EObject> collectEnclosureReachable(EObject so,
			List<EReference> references, List<EClass> types,
			boolean emptyAllowed,int maxLength, Class<? extends Adapter> listenerClass) {
		Adapter listener = getUnveriseRelatedObject(listenerClass);
		UniqueEList<EObject> list;
		if(so.eAdapters().contains(listener))
			so.eAdapters().add(listener);
		
		list = new UniqueEList<EObject>();
		getObjectReachableList().put(so, references, list);
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
					collectReachableImpl(nso,r,list,types);
				}
			}
			pace++;
		} while((maxLength<0||pace<maxLength));
		if(!emptyAllowed) list.remove(0);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	private void collectReachableImpl(EObject s, EReference r, List<EObject> list,List<EClass> types) {
		EClass cls = s.eClass();
		if(cls.getEAllReferences().contains(r)) {
			if(r.isMany()) {
				List<EObject> col = (List<EObject>)s.eGet(r);
				//list.addAll(col);
				for(EObject o : col) {
					if(checkType(o,types)) {
						list.add(o);
						getPrefixObjects().put(o, s);
					}
				}
			} else {
				if(s.eGet(r)!=null){
					EObject obj = (EObject) s.eGet(r);
					if(checkType(obj,types)){
						list.add(obj);
						getPrefixObjects().put(obj, s);
					}
				}
			}
		}
	}
	
	public List<EObject> collectDirectReachables(EObject s, List<EReference> refs, List<EClass> types) {
		List<EObject> objs = new ArrayList<EObject>();
		for(EReference r : refs) {
			collectReachableImpl(s, r, objs, types);
		}
		return objs;
	}
	
	private boolean checkType(EObject o,List<EClass> types) {
		if(types.size()==0) return true;
		
		for(EClass c: types) {
			if(c.isSuperTypeOf(o.eClass()))
				return true;
		}
		return false;
	}
	
}
