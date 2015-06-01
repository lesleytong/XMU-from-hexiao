package edu.ustb.sei.mde.xmu.resource.xmu.interpret;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.ustb.sei.commonutil.util.CacheMap;
import edu.ustb.sei.commonutil.util.Triple;
import edu.ustb.sei.mde.xmu.*;

public class XmuEnvironment {
	private ResourceSet resourceSet; 
	private List<Resource> sources;
	public List<Resource> getSources() {
		return sources;
	}
	private List<Resource> views;
	public List<Resource> getViews() {
		return views;
	}
	private List<Resource> sourcePosts;
	public List<Resource> getSourcePosts() {
		return sourcePosts;
	}
	private boolean isForward;
	
	public boolean isForward() {
		return isForward;
	}

	private XmuEnvironment(boolean forward) {
		resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
			    Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(XmuPackage.eNAME,
				new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuResourceFactory());
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
//				XmuPackage.eNAME, XmuFactory.eINSTANCE);
		sources = new ArrayList<Resource>();
		views = new ArrayList<Resource>();
		sourcePosts = new ArrayList<Resource>();
		isForward = forward;
	}
	
	public XMUModel loadSpecification(URI uri) {
		Resource res = resourceSet.getResource(uri, true);
		
		if(res==null) return null;
		
		java.util.List<org.eclipse.emf.ecore.EObject> contents = res.getContents();
		if (contents == null || contents.isEmpty()) {
			return null;
		}
		
		EcoreUtil.resolveAll(res);
		XMUModel root = (XMUModel)contents.get(0);
		
		for(EPackage p : root.getPackages()) {
			resourceSet.getPackageRegistry().put(p.getNsURI(), p);
		}
		
		return root;
	}
	
	public boolean loadSources(URI[] uris) {
		for(URI u : uris) {
			Resource r = resourceSet.getResource(u,true);
			if(r==null) continue;
			sources.add(r);
		}
		
		
		return true;
	}
	
	public boolean loadViews(URI[] uris) {
		for(URI u : uris) {
			Resource r = resourceSet.getResource(u,true);
			if(r==null) continue;
			views.add(r);
		}
		return true;
	}
	
	public boolean createViews(URI[] uris) {
		for(URI u : uris) {
			Resource r = resourceSet.createResource(u);
			if(r==null) continue;
			views.add(r);
		}
		return true;
	}
	
	public boolean createSourcePost() {
		for(Resource sr : sources) {
			URI spuri = URI.createURI(sr.getURI().trimFileExtension().toString()+"_post."+sr.getURI().fileExtension());

			Resource spr = resourceSet.createResource(spuri);
			
			Copier copier = new Copier();
		    Collection<EObject> result = copier.copyAll(sr.getContents());
		    copier.copyReferences();
		    
		    spr.getContents().addAll(result);
		    sourcePosts.add(spr);
		    
		    TreeIterator<EObject> it = sr.getAllContents();
		    while(it.hasNext()) {
		    	EObject so = it.next();
		    	EObject spo = copier.get(so);
		    	//trace.setCorresponding(so,spo);
		    	trace.putBackward(Collections.singletonList(so), Collections.singletonList(spo));
		    	trace.getDefaultSource().put(spo, so);
		    }
		}
		return true;
	}
	
	public void gather(Resource res) {
		for(Entry<EObject,ObjectModification> e : track.getMap().entrySet()) {
			if(e.getKey() instanceof EResource) continue;
			if(e.getKey().eContainer()==null && e.getKey().eResource()==null){
				if(e.getValue().isDelete()) continue;
				res.getContents().add(e.getKey());
			}
		}
	}
	
	public void saveViews() {
		Map<Object,Object> options  = new HashMap<Object,Object>();
		
		options.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, true);
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, true);
		
		for(Resource r : views) {
			try {
				//gather(r);
				r.save(options);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void saveSourcePosts() {
		Map<Object,Object> options  = new HashMap<Object,Object>();
		
		options.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, true);
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, true);
		
		for(Resource r : sourcePosts) {
			try {
				gather(r);
				r.save(options);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	static public XmuEnvironment createForwardEnvironment() {
		XmuEnvironment e = new XmuEnvironment(true);
		e.trace = new XmuTraceSystem();
		e.track = new ModificationTrackSystem();
		return e;
	}
	
	static public XmuEnvironment createBackwardEnvironment() {
		XmuEnvironment e = new XmuEnvironment(false);
		e.trace = new XmuTraceSystem();
		e.track = new ModificationTrackSystem();
		return e;
	}
	
	public XmuTraceSystem getTrace() {
		return trace;
	}
	private XmuTraceSystem trace = null;
	private ModificationTrackSystem track = null;
	
	public EObject createSourcePostElement(EObject source,EObject view, EClass cls) {
		System.out.println("create "+cls.getName());
		
		EObject o = EcoreUtil.create(cls);
		track.create(o);
//		if(source!=null)
//			trace.setCorresponding(source, o);
//		else if(view!=null)
//			trace.setViewCorresponding(view,o);
		
		if(view==null){
			if(source!=null) 
				trace.putBackward(Collections.singletonList(source), Collections.singletonList(o));
		} else
			trace.putBackward((source==null ? null : Collections.singletonList(source)), 
				Collections.singletonList(view), 
				(Collections.singletonList(o)));
		
		return o;
	}
	
	public SafeType removeSourcePostElement(EObject source, EObject sourcePost) {
		if(track.canDelete(sourcePost)) {
			track.delete(sourcePost);
			
			//trace.setCorresponding(source, null);
			trace.removeBackward(Collections.singletonList(source));
			
			EcoreUtil.delete(sourcePost);
			return Just.TRUE;
		}
		return SafeType.getInvalid();
	}
	
	public void markUsed(EObject o) {
		track.create(o);
	}
	
	static private boolean equalValue(Object left, Object right) {
		if(left==null) return right==null;
		else return left.equals(right);
	}
	
	public boolean containFeature(EObject object,EStructuralFeature feature, Object value) {
		if(feature.isMany()) {
			List<?> list = (List<?>) object.eGet(feature);
			if(value==null && list.size()==0) return true;
			return list.contains(value);
		} else {
			return equalValue(object.eGet(feature),value);
		}
	}
	
	public int getFeatureIndex(EObject object,EStructuralFeature feature, Object value) {
		if(feature.isMany()) {
			List<?> list = (List<?>) object.eGet(feature);
			if(value==null && list.size()==0) return -1;
			return list.indexOf(value);
		} else {
			return equalValue(object.eGet(feature),value) ? 0 : -1;
		}
	}
	
	public boolean containFeature(EObject object,EStructuralFeature feature, int id, Object value) {
		if(feature.isMany()) {
			List<?> list = (List<?>) object.eGet(feature);
			if(value==null && list.size()==0) return true;
			return equalValue(list.get(id),value);
		} else {
			if(id==0)
				return equalValue(object.eGet(feature),value);
			else throw new RuntimeException("Out of bound error");
		}
	}
	
	public SafeType getFeature(EObject obj, EStructuralFeature feature) {
		//if(!obj.eIsSet(feature)) return SafeType.getUndefined();
		return SafeType.createFromValue(obj.eGet(feature));
	}
	
	public SafeType getFeatureAtIndex(EObject obj,EStructuralFeature feature, int id) {
		if(feature.isMany()) {
			List<Object> list = (List<Object>) obj.eGet(feature);
			if(list.size()>id) return SafeType.createFromValue(list.get(id));
			return SafeType.getInvalid();
		} else {
			if(id==0)
				return SafeType.createFromValue(obj.eGet(feature));
			return SafeType.getInvalid();
		}
	}
	
	public SafeType setFeature(EObject obj,EStructuralFeature feature, Object value) {
		
		if(this.containFeature(obj, feature, value)) return Just.TRUE;
		if(feature instanceof EReference) {
			if(track.canCreate(obj, (EReference)feature, (EObject)value)==false)
				return SafeType.getInvalid();
		} else {
			if(track.canCreate(obj, (EAttribute)feature, value)==false)
				return SafeType.getInvalid();
		}
		
		if(feature.isMany()) {
			List<Object> list = (List<Object>) obj.eGet(feature);
			if(value instanceof List) {
				if(feature instanceof EReference) {
					for(Object tar : (List<?>)value) {
						track.create(obj, (EReference)feature, (EObject)tar);
					}
				} else {
					for(Object tar : (List<?>)value) {
						track.create(obj, (EAttribute)feature, tar);
					}
				}
				list.addAll((List<?>)value);
			} else{
				if(feature instanceof EReference) {
					track.create(obj, (EReference)feature, (EObject)value);
				} else {
					track.create(obj, (EAttribute)feature, value);
				}
				list.add(value);
			}
		} else {
			if(value instanceof List) {
				Object f = ((List<?>) value).get(0);
				if(feature instanceof EReference) {
					track.create(obj, (EReference)feature, (EObject)f);
				} else {
					track.create(obj, (EAttribute)feature, f);
				}
				obj.eSet(feature, f);
			} else {
				if(feature instanceof EReference) {
					track.create(obj, (EReference)feature, (EObject)value);
				} else {
					track.create(obj, (EAttribute)feature, value);
				}
				obj.eSet(feature, value);
			}
		}
		
		
		
		return Just.TRUE;
	}
	
	public SafeType setFeatureAtIndex(EObject obj,EStructuralFeature feature, Object value, int id) {
		if(this.containFeature(obj, feature, value)) return Just.TRUE;
		if(feature instanceof EReference) {
			if(track.canCreate(obj, (EReference)feature, (EObject)value)==false)
				return SafeType.getInvalid();
		} else {
			if(track.canCreate(obj, (EAttribute)feature, value)==false)
				return SafeType.getInvalid();
		}
		
		if(feature.isMany()) {
			List<Object> list = (List<Object>) obj.eGet(feature);
			if(list.size()==id) {
				if(feature instanceof EReference) {
					track.create(obj, (EReference)feature, (EObject)value);
				} else {
					track.create(obj, (EAttribute)feature, value);
				}
				list.add(value);
			}
			else if(list.size()>id){
				if(feature instanceof EReference) {
					track.create(obj, (EReference)feature, (EObject)value);
				} else {
					track.create(obj, (EAttribute)feature, value);
				}
				list.set(id, value);
			} else 
				throw new RuntimeException("Out of bound error");
		} else {
			if(id==0) {
				if(feature instanceof EReference) {
					track.create(obj, (EReference)feature, (EObject)value);
				} else {
					track.create(obj, (EAttribute)feature, value);
				}
				obj.eSet(feature, value);
			}
			else 
				throw new RuntimeException("Out of bound error");
		}
		
		return Just.TRUE;
	}
	
	public SafeType removeFeature(EObject sourcePost,EStructuralFeature feature, Object value) {
		if(feature instanceof EReference) {
			if(track.canDelete(sourcePost, (EReference)feature, (EObject)value)==false) return SafeType.getInvalid();
		} else if(feature instanceof EAttribute) {
			if(track.canDelete(sourcePost, (EAttribute)feature, value)==false) return SafeType.getInvalid();
		}
		
		if(feature.isMany()) {
			List<Object> list = (List<Object>) sourcePost.eGet(feature);
			if(value instanceof List) {
				if(feature instanceof EReference) {
					for(Object tar : (List<?>)value) {
						track.delete(sourcePost, (EReference)feature, (EObject)tar);
					}
				} else {
					for(Object tar : (List<?>)value) {
						track.delete(sourcePost, (EAttribute)feature, tar);
					}
				}
				list.removeAll((List<?>)value);
			} else {
				if(feature instanceof EReference) {
					track.delete(sourcePost, (EReference)feature, (EObject)value);
				} else {
					track.delete(sourcePost, (EAttribute)feature, value);
				}
				list.remove(value);
			}
		} else {
			if(value instanceof List) {
				Object f = ((List<?>) value).get(0);
				if(sourcePost.eGet(feature)==f) {
					if(feature instanceof EReference) {
						track.delete(sourcePost, (EReference)feature, (EObject)f);
					} else {
						track.delete(sourcePost, (EAttribute)feature, f);
					}
					sourcePost.eUnset(feature);
				}
			} else {
				if(sourcePost.eGet(feature)==value) {
					if(feature instanceof EReference) {
						track.delete(sourcePost, (EReference)feature, (EObject)value);
					} else {
						track.delete(sourcePost, (EAttribute)feature, value);
					}
					sourcePost.eUnset(feature);
				}
			}
		}
		
		//trace.backwardSolidLink(source, view, sourcePost);
		
		return Just.TRUE;
	}
	
	public void removeFeatureAtIndex(EObject obj, EStructuralFeature feature, int id, Object value) {
		if(feature.isMany()) {
			List<Object> list = (List<Object>) obj.eGet(feature);
			if(list.size()>id) {
				Object oldValue = list.get(id);
				if(oldValue==value) list.remove(id);
			} else 
				throw new RuntimeException("Out of bound error");
		} else {
			if(id!=0) throw new RuntimeException("Out of bound error");
			
			if(value instanceof List) {
				Object f = ((List<?>) value).get(0);
				if(obj.eGet(feature)==f) 
					obj.eUnset(feature);
			} else {
				if(obj.eGet(feature)==value) 
					obj.eUnset(feature);
			}
		}
	}

	public List<Object> getFeatureAsCollection(EObject obj, EStructuralFeature feature) {
		SafeType res = this.getFeature(obj, feature);
		if(res==SafeType.getUndefined() || res.isNull())
			return Collections.emptyList();
		
		if(feature.isMany()) {
			return (List<Object>)res.getValue();
		} else {
			return (List<Object>) Collections.singletonList(res.getValue());
		}
	}

	public EObject createViewElement(Object source, EClass type) {
		if(type.isAbstract()) return null;
		
		EObject o = EcoreUtil.create(type);
		track.create(o);
		if(source!=null) {
//			trace.setCorresponding(source, o);
			trace.putForward(Collections.singletonList(source), 
					Collections.singletonList(o));
		}
		return o;
	}
	
//	public EObject createViewElement(EClass type, List<UpdatedStatement> statements, XmuContext context) {
//		if(type.isAbstract()) return null;
//		EObject o = EcoreUtil.create(type);
//		track.create(o);
//		
//		for(UpdatedStatement u : statements) {
//			List<Object> sources = new ArrayList<Object>();
//			
//		}
//	}
	
	
	
	
}