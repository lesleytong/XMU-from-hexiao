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
import org.eclipse.emf.ecore.util.EcoreUtil.UsageCrossReferencer;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.ustb.sei.commonutil.util.BidirectionalMap;
import edu.ustb.sei.commonutil.util.CacheMap;
import edu.ustb.sei.commonutil.util.Triple;
import edu.ustb.sei.mde.xmu.*;
import edu.ustb.sei.mde.xmu.resource.xmu.analysis.Util;

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
	
	protected HashMap<String,BidirectionalMap<Object, Object>> helperMappings = new  HashMap<String,BidirectionalMap<Object, Object>>();
	
	public BidirectionalMap<Object, Object> getHelperMappings(String name) {
		BidirectionalMap<Object, Object> map = helperMappings.get(name);
		if(map==null) {
			map = new BidirectionalMap<Object, Object>();
			helperMappings.put(name, map);
		}
		return map;
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
		    	//trace.putBackward(Collections.singletonList(so), Collections.singletonList(spo));
		    	trace.put(so, spo);
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
	
	public boolean isChanged(EObject object, EStructuralFeature feature) {
		ObjectModification m = track.getMap().get(object);
		if(m==null) return false;
		if(m.checkSet(feature)) return true;
		return false;
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
	
//	public EObject createSourcePostElement(EObject source,EObject view, EClass cls) {
//		System.out.println("create "+cls.getName());
//		
//		EObject o = EcoreUtil.create(cls);
//		track.create(o);
////		if(source!=null)
////			trace.setCorresponding(source, o);
////		else if(view!=null)
////			trace.setViewCorresponding(view,o);
//		
//		if(view==null){
//			if(source!=null) 
//				trace.putBackward(Collections.singletonList(source), Collections.singletonList(o));
//		} else
//			trace.putBackward((source==null ? null : Collections.singletonList(source)), 
//				Collections.singletonList(view), 
//				(Collections.singletonList(o)));
//		
//		return o;
//	}
	
	public EObject createViewElement(ObjectVariable vv,EClass cls, EObject current, XmuContext context) {
		if(cls.isAbstract()) return null;
		
		EObject o = EcoreUtil.create(cls);
		track.create(o);
		
		System.out.println("create "+o+" when\n"+context);
		
//		List<UpdatedStatement> updates = ContextUtil.lookupUpdatedStatementsFromView(current, vv);
//		
//		if(updates.size()!=0) {
//			
//			for(UpdatedStatement u : updates) {
//				List<Object> sVals = new ArrayList<Object>();
//				List<Object> vVals = new ArrayList<Object>();
//				for(Variable v : u.getSVar()) {
//					SafeType sv = context.getSafeTypeValue(v);
//					if(sv.isInvalid() || sv.isUndefined()) break;
//					sVals.add(sv.getValue());
//				}
//				if(sVals.size()!=u.getSVar().size()) continue;
//				
//				for(Variable v : u.getVVar()) {
//					if(v==vv) {
//						vVals.add(o);
//					} else {
//						SafeType sv = context.getSafeTypeValue(v);
//						if(sv.isInvalid() || sv.isUndefined()) break;
//						vVals.add(sv.getValue());
//					}
//				}
//				if(vVals.size()!=u.getVVar().size()) continue;
//				
//				trace.putForward(sVals,vVals);
//			}
//		}
		return o;
	}
	
	public EObject createSourcePostElement(ObjectVariable sp, EClass cls, EObject current,XmuContext context) {
		if(cls.isAbstract()) return null;
		
		EObject o = EcoreUtil.create(cls);
		track.create(o);
		
		/*
		 * if need update default link
		 * 	put
		 * else do nothing
		 */
		
//@begin 2016-4-4
//after removing where clause, it is unable to loop up updated statements effectively
//perhaps it is OK to update the default link
		
//		List<RuleCallStatement> updates = ContextUtil.lookupUpdatedStatementsFromSourcePost(current, sp);
//		if(updates.size()==0) {
			Variable s = context.getVariable(sp.getName().substring(0, sp.getName().length()-Util.POST_LENGTH));
//			//should I check if s is a formal parameter?
			if(s!=null) {
				SafeType sv = context.getSafeTypeValue(s);
				if(sv.getValue()!=null) {
					trace.put(sv.getObjectValue(),o);
				}
			}
//		}
//@end
		
//		if(updates.size()==0) {//updateStatement does not exist. try to put a direct link
//			Variable s = context.getVariable(sp.getName().substring(0, sp.getName().length()-Util.POST_LENGTH));
//			if(s!=null) {
//				SafeType sv = context.getSafeTypeValue(s);
//				if(sv.getValue()!=null) {
//					trace.putBackward(Collections.singletonList(sv.getValue()),
//							Collections.singletonList(o));
//				}
//			}
//		} else {
//			for(UpdatedStatement u : updates) {
//				List<Object> spv = new ArrayList<Object>();
//				List<Object> sv = new ArrayList<Object>();
//				
//				for(Variable var : u.getSVar()) {
//					if(var instanceof PrimitiveVariable) {
//						SafeType v = context.getSafeTypeValue(var);
//						sv.add(v.getValue());
//						spv.add(v.getValue());
//					} else {
//						SafeType v = context.getSafeTypeValue(var);
//						sv.add(v.getValue());
//						
//						Variable pv = context.getVariable(var.getName()+Util.POST_FLAG);
//						if(pv!=null) {
//							if(pv==sp) {
//								spv.add(o);
//							} else {
//								// in this case, some source post in the same tuple have not been created yet
//								SafeType vp = context.getSafeTypeValue(pv);
//								if(vp.isUndefined() || vp.isInvalid()){
//									break;
//								}
//								else 
//									spv.add(vp);								
//							}
//						} else {
//							spv.add(null);
//						}
//					}
//				}
//				
//				if(spv.size()!=sv.size()) continue;
//				
//				List<Object> vv = new ArrayList<Object>();
//				for(Variable var : u.getVVar()) {
//					SafeType v = context.getSafeTypeValue(var);
//					vv.add(v.getValue());
//				}
//				
//				trace.putBackward(sv, vv, spv);
//			}
//		}
		
		return o;
	}
	
	public SafeType removeSourcePostElement(EObject source, EObject sourcePost) {
		if(track.canDelete(sourcePost)) {
			track.delete(sourcePost);
			
			//trace.setCorresponding(source, null);
			trace.put(source, null);
			
			Resource res = sourcePost.eResource();
			
			if(res!=null)
				EcoreUtil.delete(sourcePost);
			else {
				for(Resource r : this.getSourcePosts()) {
					Collection<EStructuralFeature.Setting> usages = UsageCrossReferencer.find(sourcePost, r);
					for (EStructuralFeature.Setting setting : usages)
				    {
				      if (setting.getEStructuralFeature().isChangeable())
				      {
				        EcoreUtil.remove(setting, sourcePost);
				      }
				    }
				}
			}
			
			
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
			if(track.canCreate(obj, (EReference)feature, (EObject)value)==false) {
				return SafeType.getInvalid();
			}
		} else {
			if(track.canCreate(obj, (EAttribute)feature, value)==false)
				return SafeType.getInvalid();
		}
		
		if(feature.isChangeable()) {
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
			
		} else {
			if(feature instanceof EAttribute) return SafeType.getInvalid();
			else {
				EReference ref = (EReference)feature;
				if(ref.getEOpposite()!=null) {
					ref = ref.getEOpposite();
					if(value instanceof List) {
						for(EObject src : (List<EObject>)value) {
							if(ref.isMany()) {
								List<Object> list = (List<Object>) src.eGet(ref);
								track.create(src, ref, obj);
								list.add(obj);
							} else {
								track.create(src, ref, obj);
								src.eSet(ref, obj);
							}
						}
					} else {
						EObject src = (EObject)value;
						if(ref.isMany()) {
							List<Object> list = (List<Object>) src.eGet(ref);
							track.create(src, ref, obj);
							list.add(obj);
						} else {
							track.create(src, ref, obj);
							src.eSet(ref, obj);
						}
						
					}
				} else return SafeType.getInvalid();
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
		System.out.println("remove feature "+value);
		if(feature instanceof EReference) {
			if(track.canDelete(sourcePost, (EReference)feature, (EObject)value)==false) return SafeType.getInvalid();
		} else if(feature instanceof EAttribute) {
			if(track.canDelete(sourcePost, (EAttribute)feature, value)==false) return SafeType.getInvalid();
		}
		
		if(feature.isChangeable()) {
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
					}
				} else {
					if(sourcePost.eGet(feature)==value) {
						if(feature instanceof EReference) {
							track.delete(sourcePost, (EReference)feature, (EObject)value);
						} else {
							track.delete(sourcePost, (EAttribute)feature, value);
						}
						sourcePost.eSet(feature,null);
					}
				}
			}
		} else {
			if(feature instanceof EAttribute) return SafeType.getInvalid();
			else {
				EReference ref = (EReference)feature;
				if(ref.getEOpposite()!=null) {
					ref = ref.getEOpposite();
					if(value instanceof List) {
						for(EObject src : (List<EObject>)value) {
							if(ref.isMany()) {
								List<Object> list = (List<Object>) src.eGet(ref);
								track.delete(src, ref, sourcePost);
								list.remove(sourcePost);
							} else {
								track.delete(src, ref, sourcePost);
								src.eSet(ref, null);
							}
						}
					} else {
						EObject src = (EObject)value;
						if(ref.isMany()) {
							List<Object> list = (List<Object>) src.eGet(ref);
							track.delete(src, ref, sourcePost);
							list.remove(sourcePost);
						} else {
							track.delete(src, ref, sourcePost);
							src.eSet(ref, null);
						}
						
					}
				} else return SafeType.getInvalid();
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

	private Map<Expr,Expr> spExpMap = new HashMap<Expr,Expr>();
	public Expr getSourcePostExpression(Expr ap) {
		if(spExpMap.containsKey(ap)) return spExpMap.get(ap);
		
		if(ap instanceof VariableExp) {
			Rule rule = Util.getRule(ap);
			for(ObjectVariable v : rule.getSpVars()) {
				if(v.getName().startsWith(((VariableExp) ap).getVar().getName())
						&& v.getName().length() == ((VariableExp) ap).getVar().getName().length()+Util.POST_LENGTH) {
					VariableExp nap = XmuFactory.eINSTANCE.createVariableExp();
					nap.setVar(v);
					nap.getPath().addAll(((VariableExp) ap).getPath());
					spExpMap.put(ap, nap);
					return nap;
				}
			}
			return null;
		} else {
			return null;
		}
	}

//	public EObject createViewElement(Object source, EClass type) {
//		if(type.isAbstract()) return null;
//		
//		EObject o = EcoreUtil.create(type);
//		track.create(o);
//		if(source!=null) {
////			trace.setCorresponding(source, o);
//			trace.putForward(Collections.singletonList(source), 
//					Collections.singletonList(o));
//		}
//		return o;
//	}
	
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