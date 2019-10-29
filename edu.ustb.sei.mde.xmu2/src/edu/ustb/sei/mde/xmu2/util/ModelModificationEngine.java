package edu.ustb.sei.mde.xmu2.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;
import org.eclipse.emf.ecore.util.FeatureMapUtil;

import edu.ustb.sei.mde.xmu2.runtime.exceptions.InvalidModificationException;
import edu.ustb.sei.mde.xmu2.runtime.values.FeatureList;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;
import edu.ustb.sei.mde.xmu2common.Xmu2commonPackage;

/*
 *  all the modifications on models should be performed through this engine 
 *  in order to avoid conflict modifications. The engine follows a simple
 *  principle that an early modification cannot be reset by a later one.
 *  The engine will check the consistency of modifications, and will throw
 *  a runtime exception when there is an inconsistency.
 */

@SuppressWarnings("unchecked")
public class ModelModificationEngine extends ModelModificationTrace{
	static public boolean equalValue(Object left, Object right) {
		if(left==null) return right==null;
		else return left.equals(right);
	}
	
	private List<Resource> focusedResources = Collections.EMPTY_LIST;
	
	public ModelModificationEngine() {
		super();
	}

	public boolean containFeature(EObject object,EStructuralFeature feature, int id, Object value) {
		if(feature.isMany()) {
			List<?> list = (List<?>) getFeatureAsJavaObject(object, feature);
			if(id==-1) 
				id = list.size() - 1;
			if(value==null && list.size()==0) 
				return true;
			return equalValue(list.get(id),value);
		} else {
			if(id==0 || id==-1)
				return equalValue(getFeatureAsJavaObject(object, feature),value);
			else 
				throw new InvalidModificationException("Invalid collection index: collection size=0, required index="+id);
		}
	}

	public boolean containFeature(EObject object,EStructuralFeature feature, Object value) {
		if(feature.isMany()) {
			List<?> list = (List<?>) getFeatureAsJavaObject(object, feature);
			if(value==null && list.size()==0) return true;
			return list.contains(value);
		} else {
			return equalValue(getFeatureAsJavaObject(object, feature),value);
		}
	}
	
	public EObject createObject(EClass cls) {
		EObject obj = EcoreUtil.create(cls);
		this.logCreation(obj);
		return obj;
	}

	public boolean deleteLink(EObject source, EStructuralFeature feature, Object value) {
		if(containFeature(source, feature, value)) {
			if(this.isDeletable(source, feature, value)) {
				this.logDeletion(source, feature, value);
				if(!feature.isChangeable())
					throw new InvalidModificationException("you are going to delete an unchangeable link");
				
//				if(feature.isMany()) {
//					List<? extends Object> list = (List<? extends Object>)source.eGet(feature);
//					list.remove(value);
//				} else {
//					source.eSet(feature, null);
//				}
				
				if(feature instanceof EAttribute) {
					this.internalRemoveAttributeValue(source, (EAttribute)feature, value);
				} else {
					this.internalRemoveObject(source, (EReference) feature, (EObject) value);
				}
				return true;
				
			} else {
				throw new InvalidModificationException("you are going to delete a newly created link");
			}
		} else return false;
	}

	public void deleteObject(EObject obj) {
		if(isDeletable(obj)) {
			this.logDeletion(obj);
			
			Resource res = obj.eResource();
			
			//if(res!=null)
			internalRemoveObject(null,obj);
//			else {
//				for(Resource r : focusedResources) {
//					Collection<EStructuralFeature.Setting> usages = UsageCrossReferencer.find(obj, r);
//					for (EStructuralFeature.Setting setting : usages)
//				    {
//				      if (setting.getEStructuralFeature().isChangeable())
//				      {
//				        internalRemoveObject(setting, obj);
//				      }
//				    }
//				}
//				internalRemoveObject(null, obj);
//			}
		} else {
			throw new InvalidModificationException("a newly created/modified object is going to be deleted "+obj);
		}
	}
	
	public SafeType getFeature(EObject obj, EStructuralFeature feature) {
		return SafeType.createFromValue(getFeatureAsJavaObject(obj, feature));
	}
	
	public List<Object> getFeatureAsFeatureList(EObject obj, EStructuralFeature feature) {
		if(feature == Xmu2commonPackage.Literals.REFLECTIVE_OBJECT__ECONTAINER) {
			return Collections.singletonList(obj.eContainer());
		} else if(feature == Xmu2commonPackage.Literals.REFLECTIVE_OBJECT__ECONTENTS) {
			List<?> list = obj.eContents();
			return (List<Object>) list;
		}  else if(feature == Xmu2commonPackage.Literals.REFLECTIVE_OBJECT__EALL_CONTENTS) {
			TreeIterator<EObject> it = obj.eAllContents();
			List<Object> allContents = new ArrayList<Object>();
			while(it.hasNext()) allContents.add(it.next());
			return allContents;
		} else
			return new FeatureList<Object>(obj,feature,this);
	}

	//original version
	public List<Object> getFeatureAsInternalCollection(EObject obj, EStructuralFeature feature) {
		Object res = this.getFeatureAsJavaObject(obj, feature);
		
		if(res==null)
			return Collections.emptyList();
		
		if(feature.isMany()) {
			return (List<Object>)res;
		} else {
			return (List<Object>) Collections.singletonList(res);
		}
	}
	
	public Object getFeatureAsJavaObject(EObject obj, EStructuralFeature feature) {
		if(feature == Xmu2commonPackage.Literals.REFLECTIVE_OBJECT__ECONTAINER) {
			return obj.eContainer();
		} else if(feature == Xmu2commonPackage.Literals.REFLECTIVE_OBJECT__ECONTENTS) {
			return obj.eContents();
		}  else if(feature == Xmu2commonPackage.Literals.REFLECTIVE_OBJECT__EALL_CONTENTS) {
			TreeIterator<EObject> it = obj.eAllContents();
			List<EObject> allContents = new ArrayList<EObject>();
			while(it.hasNext()) allContents.add(it.next());
			return allContents;
		} else
			return obj.eGet(feature);
	}
	
	public SafeType getFeatureAtIndex(EObject obj,EStructuralFeature feature, int id) {
		return SafeType.createFromValue(getFeatureAtIndexAsJavaObject(obj,feature,id));
	}
	
	public Object getFeatureAtIndexAsJavaObject(EObject obj,EStructuralFeature feature, int id) {
		if(feature.isMany()) {
			List<Object> list = (List<Object>) getFeatureAsJavaObject(obj, feature);
			if(list.size()>id) 
				return list.get(id);
			else
				throw new InvalidModificationException("Invalid collection index: collection size="+list.size()+", required index="+id);
		} else {
			if(id==0)
				return getFeatureAsJavaObject(obj, feature);
			else
				throw new InvalidModificationException("Invalid collection index: collection size=0, required index="+id);
		}
	}
	
	public SafeType getFeatureIndex(EObject object,EStructuralFeature feature, Object value) {
		return SafeType.createFromValue(getFeatureIndexAsJavaObject(object,feature,value));
	}
	
	public int getFeatureIndexAsJavaObject(EObject object,EStructuralFeature feature, Object value) {
		if(feature.isMany()) {
			List<?> list = (List<?>) getFeatureAsJavaObject(object, feature);
			if(value==null && list.size()==0) 
				return -1;
			return list.indexOf(value);
		} else {
			return equalValue(getFeatureAsJavaObject(object, feature),value) ? 0 : -1;
		}
	}
	
	public List<Resource> getFocusedResources() {
		return focusedResources;
	}
	
	public void insertFeatureAtIndex(EObject obj,EStructuralFeature feature, Object value, int id) {
		if(feature.isUnique() && this.containFeature(obj, feature, value)) 
			return;
		
		if(feature instanceof EReference) {
			if(isCreatable(obj, (EReference)feature, (EObject)value)==false)
				throw new InvalidModificationException("a newly inserted relationship is going to be changed");
		} else {
			if(isCreatable(obj, (EAttribute)feature, value)==false)
				throw new InvalidModificationException("a newly changed attribute is going to be changed");
		}
		
		if(feature.isChangeable()==false) 
			throw new InvalidModificationException("you are going to change an unchangeable feature "+feature);
		
		if(feature.isMany()) {
			List<Object> list = (List<Object>) getFeatureAsJavaObject(obj, feature);

			if(id==-1)
				id = list.size() - 1;
			
			if(list.size()>=id) {
				this.logCreation(obj, feature, value);
//				list.add(value);
				if(id==list.size())
					internalAddFeature(obj, feature, value);
				else
					internalInsertAtFeature(obj, feature, value, id);
			} else 
				throw new InvalidModificationException("Invalid collection index: collection size="+list.size()+", required index="+id);
		} else {
			if(id==0 || id==-1) {
				Object old = obj.eGet(feature);
				
				this.logCreation(obj, feature, value);
				
				if(old!=null && old.equals(value)==false) {
					this.logDeletion(obj, feature, old);
				}
				
//				obj.eSet(feature, value);
				internalSetFeature(obj, feature, value);
			}
			else 
				throw new InvalidModificationException("Invalid collection index: collection size=0, required index="+id);
		}
	}
	
	protected void interalReplaceObject(EObject host, EStructuralFeature feature, EObject oldObj, EObject newObj) {
		if(host!=null&&feature!=null) {
			EcoreUtil.replace(host, feature, oldObj, newObj);
		} else {
			EcoreUtil.replace(oldObj,newObj);
		}
	}
	
	protected void internalAddFeature(EObject host, EStructuralFeature feature, Object value) {
		if(feature.isMany()) {
			List<Object> list = (List<Object>) getFeatureAsJavaObject(host, feature);
			list.add(value);
		} else {
			throw new InvalidModificationException("the feature is not a many feature");
		}
	}
	
	protected void internalInsertAtFeature(EObject host, EStructuralFeature feature, Object value, int index) {
		if(feature.isMany()) {
			List<Object> list = (List<Object>) getFeatureAsJavaObject(host, feature);
			list.add(index,value);
		} else {
			throw new InvalidModificationException("the feature is not a many feature");
		}
	}
	
	protected void internalMoveFeature(EObject oldObj, EObject newObj, EStructuralFeature feature) {
		if(feature.isMany()) {
			List<Object> old = (List<Object>) oldObj.eGet(feature);
			List<Object> nv = (List<Object>) newObj.eGet(feature);
			nv.addAll(old);
		} else {
			newObj.eSet(feature, oldObj.eGet(feature));
		}
	}
	
	protected void internalRemoveAttributeValue(EObject host, EAttribute attribute, Object value) {
		if (FeatureMapUtil.isMany(host, attribute)) {
			((List<?>) host.eGet(attribute)).remove(value);
		} else {
			host.eSet(attribute, null);
		}
	}
	
	protected void internalRemoveObject(EObject host, EReference feature, EObject oldObj) {
		if (host != null && feature != null) {
			if (FeatureMapUtil.isMany(host, feature)) {
				((List<?>) host.eGet(feature)).remove(oldObj);
			} else {
				host.eUnset(feature);
			}
		} else
			EcoreUtil.remove(oldObj);
	}
	
	

	/**
	 * Its implementation is dependent on the other version of internalRemoveObject
	 * @param setting
	 * @param oldObj
	 */
	final protected void internalRemoveObject(EStructuralFeature.Setting setting, EObject oldObj) {
		if(setting!=null)
			internalRemoveObject(setting.getEObject(),(EReference) setting.getEStructuralFeature(), oldObj);
		else {
			// remove from model
			for(Resource res : this.focusedResources) {
				Collection<Setting> settings = EcoreUtil.UsageCrossReferencer.find(oldObj, res);
				for(Setting s : settings) {
					if(s.getEStructuralFeature().isChangeable())
						internalRemoveObject(s.getEObject(),(EReference)s.getEStructuralFeature(), oldObj);
				}
			}
			internalRemoveObject(null,null,oldObj);
		}
	}

	protected void internalReplaceAtFeature(EObject host, EStructuralFeature feature, Object value, int index) {
		if(feature.isMany()) {
			List<Object> list = (List<Object>) getFeatureAsJavaObject(host, feature);
			if(index==list.size())
				list.add(value);
			else 
				list.set(index,value);
		} else {
			host.eSet(feature, value);
		}
	}
	
	/**
	 * Its implementation is dependent on the other version of interalReplaceObject
	 * @param setting
	 * @param oldObj
	 * @param newObj
	 */
	final protected void internalReplaceObject(EStructuralFeature.Setting setting, EObject oldObj, EObject newObj) {
		if(setting!=null)
			interalReplaceObject(setting.getEObject(),setting.getEStructuralFeature(), oldObj, newObj);
		else
			interalReplaceObject(null,null,oldObj,newObj);
	}
	
	protected void internalSetFeature(EObject host, EStructuralFeature feature, Object value) {
		if(feature.isMany()) {
			throw new InvalidModificationException("the feature is a many feature");
		} else {
			host.eSet(feature, value);
		}
	}
	
	public void markAsUsed(EObject o) {
		if(o==null) return;
		this.logCreation(o);
	}
	
	public void replaceObject(EObject oldObj, EObject newObj) {
		if(isDeletable(oldObj)) {
			this.logDeletion(oldObj);
			
			for(Resource r : focusedResources) {
				Collection<EStructuralFeature.Setting> usages = UsageCrossReferencer.find(oldObj, r);
				for (EStructuralFeature.Setting setting : usages)
				{
					if (setting.getEStructuralFeature().isChangeable())
					{
						if(AnalysisUtil.isSuperTypeOf(((EClass)setting.getEStructuralFeature().getEType()),newObj.eClass()))
							internalReplaceObject(setting, oldObj, newObj);
						else
							internalRemoveObject(setting, oldObj);
					}
				}
			}
			
			List<EStructuralFeature> allFeatures = oldObj.eClass().getEAllStructuralFeatures();
			for(EStructuralFeature f : allFeatures) {
				if(newObj.eClass().getEAllStructuralFeatures().contains(f)) {
					if(!f.isChangeable()) continue;
					if(f instanceof EReference) {
						if(((EReference) f).isContainer()) continue;
					}
					internalMoveFeature(oldObj, newObj, f);
				}
			}
			
			if(AnalysisUtil.isSuperTypeOf(((EClass)oldObj.eContainmentFeature().getEType()),newObj.eClass())) {
				internalReplaceObject(null, oldObj, newObj);
			} else {
				internalRemoveObject(null,oldObj);
			}
			
		} else {
			throw new InvalidModificationException("a newly created/modified object is going to be replaced "+oldObj);
		}
	}
	
	public void setFeature(EObject obj,EStructuralFeature feature, Object value) {
		if(feature.isChangeable()) {
			if(feature.isMany()) {
//				List<Object> list = (List<Object>) getFeatureAsJavaObject(obj, feature);
				if(value instanceof List) {
					for(Object tar : (List<?>)value) {
						if(feature.isUnique() 
								&& this.containFeature(obj, feature, tar)) 
							continue;
						if(!isCreatable(obj, feature, tar)) {
							throw new InvalidModificationException("a newly inserted feature is going to be changed");
						}
						
						logCreation(obj, feature, tar);
						
						internalAddFeature(obj,feature,tar);
					}
				} else{
					if(feature.isUnique() 
							&& this.containFeature(obj, feature, value)) 
						return;
					if(!isCreatable(obj, feature, value)) {
						throw new InvalidModificationException("a newly inserted feature is going to be changed");
					}
					this.logCreation(obj, feature, value);
					
					internalAddFeature(obj,feature,value);
				}
			} else {
				Object newValue = null;
				if(value instanceof List) {
					newValue = ((List<?>) value).get(0);
				} else newValue = value;
				
				if(feature.isUnique() 
						&& this.containFeature(obj, feature, newValue)) 
					return;
				if(!isCreatable(obj, feature, newValue)) {
					throw new InvalidModificationException("a newly inserted feature is going to be changed");
				}
				
				this.logCreation(obj, feature, newValue);
				
				internalSetFeature(obj,feature,newValue);
			}
			
		} else {
			if(feature instanceof EAttribute) 
				throw new InvalidModificationException("you are going to change an unchangeable attribute "+feature);
			else {
				EReference ref = (EReference)feature;
				if(ref.getEOpposite()!=null) {
					ref = ref.getEOpposite();
					if(value instanceof List) {
						for(EObject src : (List<EObject>)value) {
							if(ref.isUnique() 
									&& this.containFeature(src, ref, obj)) 
								continue;
							
							if(!isCreatable(src, ref, obj)) {
								throw new InvalidModificationException("a newly inserted feature is going to be changed");
							}
							
							logCreation(src, ref, obj);
							if(ref.isMany())
								internalAddFeature(src, ref, obj);
							else 
								internalSetFeature(src, ref, obj);
						}
					} else {
						EObject src = (EObject)value;
						
						logCreation(src, ref, obj);
						
						if(ref.isMany())
							internalAddFeature(src, ref, obj);
						else 
							internalSetFeature(src, ref, obj);
					}
				} else 
					throw new InvalidModificationException("you are going to change an unchangeable relationship "+feature);
			}
		}
	}
	
	public void setFeatureAtIndex(EObject obj,EStructuralFeature feature, Object value, int id) {
		if(feature.isUnique() && this.containFeature(obj, feature, value)) 
			return;
		
		if(isCreatable(obj, feature, value)==false)
			throw new InvalidModificationException("a newly deleted feature is going to be created again");
		
		if(feature.isChangeable()==false) 
			throw new InvalidModificationException("you are going to change an unchangeable feature "+feature);
		
		if(feature.isMany()) {
			List<Object> list = (List<Object>) getFeatureAsJavaObject(obj, feature);

			if(id==-1)
				id = list.size() - 1;
			
			if(list.size()==id) {
				this.logCreation(obj, feature, value);
//				list.add(value);
				this.internalAddFeature(obj, feature, value);
			}
			else if(list.size()>id){
				Object old = list.get(id);
				
				if(isDeletable(obj, feature, old)==false)
					throw new InvalidModificationException("a newly created/changed feature is going to be deleted");
				
				logDeletion(obj, feature, old);
				logCreation(obj, feature, value);
				
//				list.set(id, value);
				this.internalReplaceAtFeature(obj, feature, value, id);
				
			} else 
				throw new InvalidModificationException("Invalid collection index: collection size="+list.size()+", required index="+id);
		} else {
			if(id==0 || id==-1) {
				Object old = obj.eGet(feature);
				
				if(isDeletable(obj, feature, old)==false)
					throw new InvalidModificationException("a newly created/changed feature is going to be deleted");
				
				logDeletion(obj, feature, old);
				logCreation(obj, feature, value);
				
//				obj.eSet(feature, value);
				this.internalSetFeature(obj, feature, value);
			}
			else 
				throw new InvalidModificationException("Invalid collection index: collection size=0, required index="+id);
		}
	}
	
//	public OclCollection getFeatureAsOclCollection(EObject obj, EStructuralFeature feature) {
//		return OclCollection.createFeatureSourceCollection(obj, feature);
//	}
	
//	public SafeType getFeatureAsCollection(EObject obj, EStructuralFeature feature) {
//		return SafeType.createFromValue(getFeatureAsOclCollection(obj,feature));
//	}
	
	public void setFocusedResources(List<Resource> focusedResources) {
		this.focusedResources = focusedResources;
	}

	public void deleteObjectFromModel(EObject eo, ResourceSet resourceSet) {
	    Collection<EStructuralFeature.Setting> usages;
	    usages = UsageCrossReferencer.find(eo, resourceSet);

	    for (EStructuralFeature.Setting setting : usages)
	    {
	      if (setting.getEStructuralFeature().isChangeable())
	      {
	        EcoreUtil.remove(setting, eo);
	      }
	    }

	    EcoreUtil.remove(eo);
	}
}
