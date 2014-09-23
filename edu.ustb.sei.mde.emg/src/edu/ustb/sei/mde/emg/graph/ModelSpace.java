package edu.ustb.sei.mde.emg.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ustb.sei.commonutil.util.BidirectionalMap;
import edu.ustb.sei.commonutil.util.PairHashMap;

public class ModelSpace extends NamedElement {
	private List<EObject> allElements;
	
	static private BidirectionalMap<Integer, EObject> idObjMap  = new BidirectionalMap<Integer,EObject>();
	
	
	
	private List<ModelSpace> instanceSpaces;
	private ObjectAdapter elementAdapter = null;
	
	private PairHashMap<EObject, EReference, int[]> elemRelMap;
	
	private HashMap<EObject, List<EObject>> typeToAllElementsMap = null;
	private HashMap<EObject, int[]> typeToAllElementIDMap = null;
	
	private Resource model;
	public Resource getModel() {
		return model;
	}


	public void setModel(Resource model) {
		this.model = model;
	}


	public EPackage getMetamodel() {
		return metamodel;
	}


	public void setMetamodel(EPackage metamodel) {
		this.metamodel = metamodel;
	}

	private EPackage metamodel;
	
	//private ModelSpaceHelper modelHelper = null;
	
//	public ModelSpaceHelper getModelHelper() {
//		if(modelHelper==null)
//			modelHelper = new EcoreModelSpaceHelper();
//		return modelHelper;
//	}
//
//	public void setModelHelper(ModelSpaceHelper modelHelper) {
//		this.modelHelper = modelHelper;
//	}

	public ModelSpace() {
		allElements = new ArrayList<EObject>();
		elementAdapter = new ObjectAdapter(this);

		instanceSpaces = new ArrayList<ModelSpace>();
		
		elemRelMap = new PairHashMap<EObject, EReference, int[]>();
		
		typeToAllElementsMap = new HashMap<EObject, List<EObject>>();
		typeToAllElementIDMap =  new HashMap<EObject, int[]>();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<EObject> allInstances(String instanceName, EObject type) {
		if(instanceName == null) {
			ArrayList<EObject> list = new ArrayList<EObject>();
			for(ModelSpace s : instanceSpaces) 
				list.addAll(s.getAllElementsByType(type));
			return list;
		} else {
			for(ModelSpace s : instanceSpaces) {
				if(instanceName.equals(s.getName()))
					return s.getAllElementsByType(type);
			}
			return Collections.EMPTY_LIST;
		}
	}
	
	public int[] allInstanceID(String instanceName, EObject type) {
		if(instanceName == null) {
			int[][] allIDs = new int[instanceSpaces.size()][];
			int size = 0;
			for(int i = 0 ; i< instanceSpaces.size() ; i++) {
				allIDs[i] = instanceSpaces.get(i).getAllElementIDByType(type);
				size += allIDs[i].length;
			}
			
			int base = 0;
			int[] result = new int[size];
			for(int[] ids : allIDs) {
				for(int i=0;i<ids.length;i++) {
					result[base+i] = ids[i];
				}
				base += ids.length;
			}
				
			return result;
		} else {
			for(ModelSpace s : instanceSpaces) {
				if(instanceName.equals(s.getName()))
					return s.getAllElementIDByType(type);
			}
			return new int[0];
		}
	}
	
	/**
	 * add an object into model space and initialize the related cache data.
	 * @param object
	 * @return
	 */
	public int addElement(EObject object) {
		int objectID = getElementID(object);
		if(objectID!=EIdentifiable.INVALID_ID)
			return objectID;
		allElements.add(object);
		objectID = EIdentifiable.getNextID();
		object.eAdapters().add(elementAdapter);
		idObjMap.put(objectID, object);
		
		addToAllElementsMap(object.eClass(),object);
		
		return objectID;
	}
	
	/**
	 * get all ids of objects owning the same type
	 * @param type
	 * @return
	 */
	public int[] getAllElementIDByType(EObject type) {
		int[] ids = typeToAllElementIDMap.get(type);
		if(ids == null) {
			ids = collectAllElementIDList(getAllElementsByType(type));
			typeToAllElementIDMap.put(type, ids);
		}
		return ids;
	}
	
	/**
	 * add an object to allObjectsMap
	 * @param type
	 * @param object
	 */
	private void addToAllElementsMap(EObject type, EObject object) {
		List<EObject> list = getAllElementsByType(type);
		list.add(object);
		typeToAllElementIDMap.put(type, null);
		
		for(EObject superType : ((EClass)type).getESuperTypes()) {
			addToAllElementsMap(superType, object);
		}
	}
	
	/**
	 * remove an object to allObjectsMap
	 * @param type
	 * @param object
	 */
	private void removeFromAllElementsMap(EObject type, EObject object) {
		List<EObject> list = getAllElementsByType(type);
		list.remove(object);
		typeToAllElementIDMap.put(type, null);
		
		for(EObject superType : ((EClass)type).getESuperTypes()) {
			removeFromAllElementsMap(superType, object);
		}
	}

	/**
	 * get all objects from allObjectsMap
	 * @param type
	 * @return
	 */
	public List<EObject> getAllElementsByType(EObject type) {
		List<EObject> list = typeToAllElementsMap.get(type);
		if(list==null) {
			list = new ArrayList<EObject>();
			typeToAllElementsMap.put(type, list);
		}
		return list;
	}
	

	/**
	 * collect object ids
	 * @param objects
	 * @return
	 */
	private int[] collectAllElementIDList(List<EObject> objects) {
		int[] ids = new int[objects.size()];
		for(int i=0;i<ids.length;i++) {
			ids[i] = getElementID(objects.get(i));
		}
		return ids;
	}
	
	/**
	 * remove an object from model space and clear the related cache data
	 * @param object
	 */
	public void removeElement(EObject object) {
		allElements.remove(object);
		idObjMap.removeBackward(object);
		object.eAdapters().remove(elementAdapter);
		removeFromAllElementsMap(object.eClass(),object);
	}
	
	/**
	 * add an object to a model
	 * @param object
	 */
	public void addElementToModel(EObject object) {
//		EList<EReference> containmentReferences = object.eClass().getEAllContainments();
//		for(EReference ref : containmentReferences) {
//			if(ref.isMany()) {
//				@SuppressWarnings("unchecked")
//				List<EObject> children = new ArrayList<EObject>((EList<EObject>) object.eGet(ref));
//				for(EObject c : children) {
//					addObjectToModel(c);
//				}
//			} else {
//				EObject c = (EObject)object.eGet(ref);
//				addObjectToModel(c);
//			}
//		}
		addElement(object);
	}
	
	/**
	 * delete an object from a model as well as all the containing objects and relationships
	 * @param object
	 */
	public void deleteElementFromModel(EObject object) {
		EList<EReference> containmentReferences = object.eClass().getEAllContainments();
		for(EReference ref : containmentReferences) {
			if(ref.isMany()) {
				@SuppressWarnings("unchecked")
				List<EObject> children = new ArrayList<EObject>((EList<EObject>) object.eGet(ref));
				for(EObject c : children) {
					deleteElementFromModel(c);
				}
			} else {
				EObject c = (EObject)object.eGet(ref);
				deleteElementFromModel(c);
			}
		}
		removeElement(object);
		EcoreUtil.delete(object);
	}
	
	static public int getElementID(EObject object) {
		if(object == null)
			return EIdentifiable.NULL_ID;
		try {
			return idObjMap.backward(object);
		} catch(Exception e) {
			return EIdentifiable.INVALID_ID;
		}
	}
	
	static public EObject getElementByID(int id) {
		if(id<=EIdentifiable.NULL_ID)
			return null;
		return idObjMap.forward(id);
	}
	
	/**
	 * get all target ids based the source object and reference
	 * @param source
	 * @param ref
	 * @return
	 */
	public int[] getElementRelationship(EObject source, EReference ref) {
		int[] array = elemRelMap.get(source, ref);
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

	/**
	 * reset the relationship cache
	 * @param source
	 * @param feature
	 */
	public void resetElementRelationshipMap(EObject source, EReference feature) {
		elemRelMap.put(source, feature, null);
		referenceToTupleID.remove(feature);
	}
	
	public void initWithResource(Resource resource, EPackage metamodel) {
		TreeIterator<EObject> iterator = resource.getAllContents();
		while(iterator.hasNext()) {
			EObject object = iterator.next();
			this.addElement(object);
		}
		
		this.setModel(resource);
		this.setMetamodel(metamodel);
	}
	
	public void initWithResource(Resource resource) {
		this.initWithResource(resource);
	}
	
	private HashMap<EReference, List<int[]>> referenceToTupleID = new HashMap<EReference, List<int[]>>();
	public List<int[]> getAllTupleIDByReference(EReference ref,boolean initOnDemand) {
		List<int[]> list = referenceToTupleID.get(ref);
		if(list==null) {
			list = new ArrayList<int[]>();
			referenceToTupleID.put(ref, list);
			if(initOnDemand) {
				for(EObject o : allElements) {
					if(ref.getEContainingClass().isSuperTypeOf(o.eClass())){
						int s = getElementID(o);
						int[] tars = getElementRelationship(o, ref);
						for(int t : tars) {
							list.add(new int[]{s,t});
						}
					}
				}
			}
		}
		
		return list;
	}
	
	public void addRelationship(EObject source, EObject target, EReference ref) {
		if(ref.isMany()) {
			((EList<EObject>)source.eGet(ref)).add(target);
		} else 
			source.eSet(ref, target);
	}
	
	public void addRelationship(EObject source, EObject target, EReference ref, int index) {
		if(ref.isMany()) {
			((EList<EObject>)source.eGet(ref)).add(index, target);
		} else 
			source.eSet(ref, target);
	}
	
	public void deleteRelationship(EObject source, EObject target, EReference ref) {
		if(ref.isMany()) {
			((EList<EObject>)source.eGet(ref)).remove(target);
		} else 
			source.eUnset(ref);
	}

}
