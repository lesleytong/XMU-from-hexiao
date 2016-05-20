package edu.ustb.sei.mde.xmu2.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;

import edu.ustb.sei.mde.xmu2.datatypes.OclCollection;
import edu.ustb.sei.mde.xmu2.runtime.exceptions.InvalidModificationException;
import edu.ustb.sei.mde.xmu2.runtime.values.FeatureList;
import edu.ustb.sei.mde.xmu2.runtime.values.ModelList;
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
	public ModelModificationEngine() {
		super();
	}
	
	private List<Resource> focusedResources = Collections.EMPTY_LIST;
	
	public List<Resource> getFocusedResources() {
		return focusedResources;
	}

	public void setFocusedResources(List<Resource> focusedResources) {
		this.focusedResources = focusedResources;
	}

	public EObject createObject(EClass cls) {
		EObject obj = EcoreUtil.create(cls);
		this.logCreation(obj);
		return obj;
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
							EcoreUtil.replace(setting, oldObj, newObj);
						else 
							EcoreUtil.remove(setting, oldObj);
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
					if(f.isMany()) {
						List<Object> old = (List<Object>) oldObj.eGet(f);
						List<Object> nv = (List<Object>) newObj.eGet(f);
						nv.addAll(old);
					} else {
						newObj.eSet(f, oldObj.eGet(f));
					}
				}
			}
			
			if(AnalysisUtil.isSuperTypeOf(((EClass)oldObj.eContainmentFeature().getEType()),newObj.eClass())) {
				EcoreUtil.replace(oldObj, newObj);
			} else {
				EcoreUtil.remove(oldObj);
			}
			
		} else {
			throw new InvalidModificationException("a newly created/modified object is going to be replaced "+oldObj);
		}
	}
	
	public void deleteObject(EObject obj) {
		if(isDeletable(obj)) {
			this.logDeletion(obj);
			
			Resource res = obj.eResource();
			
			if(res!=null)
				EcoreUtil.delete(obj);
			else {
				for(Resource r : focusedResources) {
					Collection<EStructuralFeature.Setting> usages = UsageCrossReferencer.find(obj, r);
					for (EStructuralFeature.Setting setting : usages)
				    {
				      if (setting.getEStructuralFeature().isChangeable())
				      {
				        EcoreUtil.remove(setting, obj);
				      }
				    }
				}
			}
		} else {
			throw new InvalidModificationException("a newly created/modified object is going to be deleted "+obj);
		}
	}
	
	public void markAsUsed(EObject o) {
		if(o==null) return;
		this.logCreation(o);
	}
	
	public void setFeature(EObject obj,EStructuralFeature feature, Object value) {
		if(feature.isChangeable()) {
			if(feature.isMany()) {
				List<Object> list = (List<Object>) getFeatureAsJavaObject(obj, feature);
				if(value instanceof List) {
					for(Object tar : (List<?>)value) {
						if(feature.isUnique() 
								&& this.containFeature(obj, feature, tar)) 
							continue;
						if(!isCreatable(obj, feature, tar)) {
							throw new InvalidModificationException("a newly inserted feature is going to be changed");
						}
						
						logCreation(obj, feature, tar);
						
						list.add(tar);
					}
				} else{
					if(feature.isUnique() 
							&& this.containFeature(obj, feature, value)) 
						return;
					if(!isCreatable(obj, feature, value)) {
						throw new InvalidModificationException("a newly inserted feature is going to be changed");
					}
					this.logCreation(obj, feature, value);
					
					list.add(value);
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
				
				obj.eSet(feature, newValue);
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

							if(ref.isMany()) {
								List<Object> list = (List<Object>) src.eGet(ref);								
								list.add(obj);
							} else {
								src.eSet(ref, obj);
							}
						}
					} else {
						EObject src = (EObject)value;
						
						logCreation(src, ref, obj);
						
						if(ref.isMany()) {
							List<Object> list = (List<Object>) src.eGet(ref);
							list.add(obj);
						} else {
							src.eSet(ref, obj);
						}
						
					}
				} else 
					throw new InvalidModificationException("you are going to change an unchangeable relationship "+feature);
			}
		}
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
				list.add(value);
			} else 
				throw new InvalidModificationException("Invalid collection index: collection size="+list.size()+", required index="+id);
		} else {
			if(id==0 || id==-1) {
				Object old = obj.eGet(feature);
				
				this.logCreation(obj, feature, value);
				
				if(old!=null && old.equals(value)==false) {
					this.logDeletion(obj, feature, old);
				}
				
				obj.eSet(feature, value);
				
			}
			else 
				throw new InvalidModificationException("Invalid collection index: collection size=0, required index="+id);
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
				list.add(value);
			}
			else if(list.size()>id){
				Object old = list.get(id);
				
				if(isDeletable(obj, feature, old)==false)
					throw new InvalidModificationException("a newly created/changed feature is going to be deleted");
				
				logDeletion(obj, feature, old);
				logCreation(obj, feature, value);
				
				list.set(id, value);
				
			} else 
				throw new InvalidModificationException("Invalid collection index: collection size="+list.size()+", required index="+id);
		} else {
			if(id==0 || id==-1) {
				Object old = obj.eGet(feature);
				
				if(isDeletable(obj, feature, old)==false)
					throw new InvalidModificationException("a newly created/changed feature is going to be deleted");
				
				logDeletion(obj, feature, old);
				logCreation(obj, feature, value);
				
				obj.eSet(feature, value);
			}
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
	
	static public boolean equalValue(Object left, Object right) {
		if(left==null) return right==null;
		else return left.equals(right);
	}
	
	

	public SafeType getFeature(EObject obj, EStructuralFeature feature) {
		return SafeType.createFromValue(getFeatureAsJavaObject(obj, feature));
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
	
	public SafeType getFeatureAtIndex(EObject obj,EStructuralFeature feature, int id) {
		return SafeType.createFromValue(getFeatureAtIndexAsJavaObject(obj,feature,id));
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
	
	public SafeType getFeatureIndex(EObject object,EStructuralFeature feature, Object value) {
		return SafeType.createFromValue(getFeatureIndexAsJavaObject(object,feature,value));
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
	
//	public OclCollection getFeatureAsOclCollection(EObject obj, EStructuralFeature feature) {
//		return OclCollection.createFeatureSourceCollection(obj, feature);
//	}
	
//	public SafeType getFeatureAsCollection(EObject obj, EStructuralFeature feature) {
//		return SafeType.createFromValue(getFeatureAsOclCollection(obj,feature));
//	}
	
	public boolean deleteLink(EObject source, EStructuralFeature feature, Object value) {
		if(containFeature(source, feature, value)) {
			if(this.isDeletable(source, feature, value)) {
				this.logDeletion(source, feature, value);
				if(!feature.isChangeable())
					throw new InvalidModificationException("you are going to delete an unchangeable link");
				
				if(feature.isMany()) {
					List<? extends Object> list = (List<? extends Object>)source.eGet(feature);
					list.remove(value);
				} else {
					source.eSet(feature, null);
				}
				return true;
				
			} else {
				throw new InvalidModificationException("you are going to delete a newly created link");
			}
		} else return false;
	}

	
}
