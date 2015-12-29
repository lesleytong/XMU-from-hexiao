package edu.ustb.sei.mde.emg.graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ustb.sei.commonutil.util.BidirectionalMap;
import edu.ustb.sei.mde.emg.graph.command.AddElementCommand;
import edu.ustb.sei.mde.emg.graph.command.AddRelationshipCommand;
import edu.ustb.sei.mde.emg.graph.command.DeleteElementCommand;
import edu.ustb.sei.mde.emg.graph.command.DeleteRelationshipCommand;
import edu.ustb.sei.mde.emg.graph.command.ModelCommand;

public class ModelSpace extends NamedElement {
	private List<EObject> allElements;

	
	private ObjectAdapter elementAdapter = null;
	private List<ModelSpace> instanceSpaces;
	
	
	private EPackage metamodel;
	private Resource model;
	
	private ModelUniverse modelUniverse = null;
	
	private HashMap<EReference, List<int[]>> referenceToTupleID = new HashMap<EReference, List<int[]>>();
	private HashMap<EObject, int[]> typeToAllElementIDMap = null;
	
	public void onChange() {
		modelUniverse.onChange();
	}
	
	public void pushCommand(ModelCommand cmd) {
		modelUniverse.pushCommand(cmd);
	}
	public void pushNotification(Notification notification) {
		modelUniverse.pushNotification(notification,this);
	}


	private HashMap<EObject, List<EObject>> typeToAllElementsMap = null;


	public ModelSpace(ModelUniverse modelUniverse) {
		this.modelUniverse = modelUniverse;
		allElements = new ArrayList<EObject>();
		elementAdapter = new ObjectAdapter(this);

		instanceSpaces = new ArrayList<ModelSpace>();
		
		//elemRelMap = new PairHashMap<EObject, EReference, int[]>();
		
		typeToAllElementsMap = new HashMap<EObject, List<EObject>>();
		typeToAllElementIDMap =  new HashMap<EObject, int[]>();
	}


	/**
	 * add an object into model space and initialize the related cache data.
	 * @param object
	 * @return
	 */
	public int addElement(EObject object) {
		//System.out.println("add "+object);		
		int objectID = modelUniverse.getElementID(object);
		if(objectID!=EIdentifiable.INVALID_ID)
			return objectID;
		
		synchronized(allElements) {
			allElements.add(object);
		}
		
		objectID = EIdentifiable.getNextID();
		
		if(!object.eAdapters().contains(elementAdapter))
			object.eAdapters().add(elementAdapter);
		
		BidirectionalMap<Integer, EObject> idObjMap = modelUniverse.getIdObjMap();
		
		synchronized(idObjMap){
			idObjMap.put(objectID, object);
		}
		
		addToAllElementsMap(object.eClass(),object);
		
		AddElementCommand cmd = new AddElementCommand(this,object);
		this.modelUniverse.pushCommand(cmd);
		
		return objectID;
	}

	/**
	 * add an object to a model
	 * @param object
	 * @deprecated
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

	public void addRelationship(EObject source, EObject target, EReference ref) {
		synchronized(source){
			if(ref.isMany()) {
				((EList<EObject>)source.eGet(ref)).add(target);
			} else 
				source.eSet(ref, target);
			
			AddRelationshipCommand cmd = new AddRelationshipCommand(this,source,target,ref,-1);
			this.modelUniverse.pushCommand(cmd);
		}
	}
	
	
	public void addRelationship(EObject source, EObject target, EReference ref, int index) {
		synchronized(source) {
			if(ref.isMany()) {
				((EList<EObject>)source.eGet(ref)).add(index, target);
			} else 
				source.eSet(ref, target);
			
//			AddRelationshipCommand cmd = new AddRelationshipCommand(this,source,target,ref,index);
//			this.modelUniverse.pushCommand(cmd);
		}
	}
	
	/**
	 * add an object to allObjectsMap
	 * @param type
	 * @param object
	 */
	private void addToAllElementsMap(EObject type, EObject object) {
		List<EObject> list = getAllElementsByType(type);
		
		synchronized(list) {
			list.add(object);
		}
		
		typeToAllElementIDMap.put(type, null);
		
		for(EObject superType : ((EClass)type).getESuperTypes()) {
			addToAllElementsMap(superType, object);
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
	
	/**
	 * collect object ids
	 * @param objects
	 * @return
	 */
	private int[] collectAllElementIDList(List<EObject> objects) {
		int[] ids = new int[objects.size()];
		for(int i=0;i<ids.length;i++) {
			ids[i] = modelUniverse.getElementID(objects.get(i));
		}
		return ids;
	}
	
	/**
	 * delete an object from a model as well as all the containing objects and relationships
	 * @param object
	 */
	public void deleteElement(EObject object) {
		EList<EReference> containmentReferences = object.eClass().getEAllContainments();
		for(EReference ref : containmentReferences) {
			if(ref.isMany()) {
				@SuppressWarnings("unchecked")
				List<EObject> children = new ArrayList<EObject>((EList<EObject>) object.eGet(ref));
				for(EObject c : children) {
					deleteElement(c);
				}
			} else {
				EObject c = (EObject)object.eGet(ref);
				if(c!=null) deleteElement(c);
			}
		}
		synchronized(object) {
			removeElement(object);
			EcoreUtil.delete(object);
			DeleteElementCommand cmd = new DeleteElementCommand(this,object);
			this.modelUniverse.pushCommand(cmd);
		}
	}

	public void deleteRelationship(EObject source, EObject target, EReference ref) {
		if(ref.isMany()) {
			((EList<EObject>)source.eGet(ref)).remove(target);
		} else {
			source.eUnset(ref);
		}
		
//		DeleteRelationshipCommand cmd = new DeleteRelationshipCommand(this,source,target,ref,-1);
//		this.modelUniverse.pushCommand(cmd);
	}
	

	/**
	 * get all ids of objects owning the same type
	 * @param type
	 * @return
	 */
	synchronized public int[] getAllElementIDByType(EObject type) {
		int[] ids = typeToAllElementIDMap.get(type);
		if(ids == null) {
			ids = collectAllElementIDList(getAllElementsByType(type));
			typeToAllElementIDMap.put(type, ids);
		}
		return ids;
	}
	
	/**
	 * get all objects from allObjectsMap
	 * @param type
	 * @return
	 */
	synchronized public List<EObject> getAllElementsByType(EObject type) {
		List<EObject> list = typeToAllElementsMap.get(type);
		if(list==null) {
			list = new ArrayList<EObject>();
			typeToAllElementsMap.put(type, list);
		}
		return list;
	}
	
	public List<int[]> getAllTupleIDByReference(EReference ref,boolean initOnDemand) {
		List<int[]> list = referenceToTupleID.get(ref);
		if(list==null) {
			list = new ArrayList<int[]>();
			referenceToTupleID.put(ref, list);
			if(initOnDemand) {
				synchronized(allElements){
					for(EObject o : allElements) {
						if(ref.getEContainingClass().isSuperTypeOf(o.eClass())){
							int s = modelUniverse.getElementID(o);
							int[] tars = modelUniverse.getElementRelationship(o, ref);
							for(int t : tars) {
								list.add(new int[]{s,t});
							}
						}
					}
				}
			}
		}
		
		return list;
	}
	
	public EPackage getMetamodel() {
		return metamodel;
	}
	

	public Resource getModel() {
		return model;
	}
	
	public void initWithResource(Resource resource) {
		this.initWithResource(resource);
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
	
	/**
	 * remove an object from model space and clear the related cache data
	 * @param object
	 */
	protected void removeElement(EObject object) {
		synchronized(allElements){
			allElements.remove(object);
		}
		
		synchronized(object) {
			modelUniverse.getIdObjMap().removeBackward(object);
			object.eAdapters().remove(elementAdapter);
		}
		removeFromAllElementsMap(object.eClass(),object);
	}
	
	/**
	 * remove an object to allObjectsMap
	 * @param type
	 * @param object
	 */
	private void removeFromAllElementsMap(EObject type, EObject object) {
		List<EObject> list = getAllElementsByType(type);
		synchronized(list){
			list.remove(object);
		}
		typeToAllElementIDMap.put(type, null);
		
		for(EObject superType : ((EClass)type).getESuperTypes()) {
			removeFromAllElementsMap(superType, object);
		}
	}
	/**
	 * reset the relationship cache
	 * @param source
	 * @param feature
	 */
	public void resetElementRelationshipMap(EObject source, EReference feature) {
		modelUniverse.getElemRelMap().put(source, feature, null);
		referenceToTupleID.remove(feature);
	}
	
	public void save() {
		for(EObject obj : allElements) {
			if(obj.eContainer()==null && obj.eResource()==null)
				model.getContents().add(obj);
			assert(obj.eResource()==model);
		}
		try {
			model.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setMetamodel(EPackage metamodel) {
		this.metamodel = metamodel;
	}
	
	public void setModel(Resource model) {
		this.model = model;
	}

}
