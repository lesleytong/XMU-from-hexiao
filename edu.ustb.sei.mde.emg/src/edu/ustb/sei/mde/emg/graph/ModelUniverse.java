package edu.ustb.sei.mde.emg.graph;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import edu.ustb.sei.commonutil.util.BidirectionalMap;
import edu.ustb.sei.commonutil.util.PairHashMap;

public class ModelUniverse {

	private PairHashMap<EObject, EReference, int[]> elemRelMap = new PairHashMap<EObject, EReference, int[]>();
	private BidirectionalMap<Integer, EObject> idObjMap  = new BidirectionalMap<Integer,EObject>();

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
}
