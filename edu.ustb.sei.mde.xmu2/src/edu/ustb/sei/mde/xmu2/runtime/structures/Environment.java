package edu.ustb.sei.mde.xmu2.runtime.structures;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.resource.impl.URIConverterImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.XMLResource;

import com.beust.jcommander.converters.URIConverter;

import edu.ustb.sei.commonutil.util.CacheMap;
import edu.ustb.sei.mde.xmu2.datatypes.impl.ResourceImpl;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;
import edu.ustb.sei.mde.xmu2.util.AnalysisUtil;
import edu.ustb.sei.mde.xmu2.util.ModelModificationEngine;
import edu.ustb.sei.mde.xmu2.util.TransformationTrace;
import edu.ustb.sei.mde.xmu2.util.Tuple;
import edu.ustb.sei.mde.xmu2common.DomainTag;
import edu.ustb.sei.mde.xmu2core.CallStatement;
import edu.ustb.sei.mde.xmu2core.Procedure;
import edu.ustb.sei.mde.xmu2core.Statement;
import edu.ustb.sei.mde.xmu2core.Transformation;
import edu.ustb.sei.mde.xmu2core.Variable;

public class Environment {
	protected List<Resource> sources = new ArrayList<Resource>();
	List<Resource> getSources() {
		return sources;
	}

	protected List<Resource> views = new ArrayList<Resource>();
	List<Resource> getViews() {
		return views;
	}

	protected List<Resource> updatedSources = new ArrayList<Resource>();
	List<Resource> getUpdatedSources() {
		return updatedSources;
	}

	protected Transformation transformation = null;
	protected CacheMap externalData = new CacheMap();
	
	public Transformation getTransformation() {
		return this.transformation;
	}
	
	private Map<Resource, edu.ustb.sei.mde.xmu2.datatypes.Resource> resourceMap = new HashMap<Resource, edu.ustb.sei.mde.xmu2.datatypes.Resource>();
	private void loadModels(ResourceSet set, List<Resource> list, String[] paths,boolean create) {
		for(String str : paths) {
			URI uri = URI.createURI(str,true);
			Resource resource = AnalysisUtil.loadOrCreateResource(set, uri, create);
			list.add(resource);
			
			edu.ustb.sei.mde.xmu2.datatypes.Resource oclResource = new ResourceImpl(resource);
			oclResource.setTag(DomainTag.SOURCE);
			resourceMap.put(resource,oclResource);
		}
	}
	
	protected ResourceSet resourceSet;
	
	ResourceSet getResourceSet() {
		return resourceSet;
	}
	
	private PrintStream printer = System.out;
	
	public PrintStream getPrinter() {
		return printer;
	}

	public void setPrinter(PrintStream printer) {
		this.printer = printer;
	}

	protected void loadSourceModels(String[] paths) {
		this.loadModels(resourceSet, sources, paths, true);
	}
	
	protected void initUpdatedSource() {
		for(Resource sr : sources) {
			URI spuri = URI.createURI(sr.getURI().trimFileExtension().toString()+"_updated."+sr.getURI().fileExtension());

			Resource spr = resourceSet.createResource(spuri);
			
			Copier copier = new Copier();
		    Collection<EObject> result = copier.copyAll(sr.getContents());
		    copier.copyReferences();
		    
		    spr.getContents().addAll(result);
		    updatedSources.add(spr);
		    
		    TreeIterator<EObject> it = sr.getAllContents();
		    while(it.hasNext()) {
		    	EObject so = it.next();
		    	EObject spo = copier.get(so);
		    	this.putDefault(so, spo);
		    }
		    
		    edu.ustb.sei.mde.xmu2.datatypes.Resource oclResource = new ResourceImpl(spr);
		    oclResource.setTag(DomainTag.UPDATED_SOURCE);
			resourceMap.put(spr,oclResource);
			this.putDefault(resourceMap.get(sr), oclResource);
		}
	}
	
	protected void loadViewModels(String[] paths) {
		this.loadModels(resourceSet, views, paths, true);
	}
	
	protected void createViewModels(String[] paths) {
		
		for(String str : paths) {
			URI uri = URI.createURI(str,true);
			Resource res = resourceSet.createResource(uri);
			views.add(res);
			
			edu.ustb.sei.mde.xmu2.datatypes.Resource oclResource = new ResourceImpl(res);
			oclResource.setTag(DomainTag.VIEW);
			resourceMap.put(res,oclResource);
		}
	}
	
	static public Environment createForwardEnvironment(URI executable,String[] sourcePaths, String[] viewPaths) {
		Environment env = new Environment(true);
		env.transformation = env.loadSpecification(executable);
		env.loadSourceModels(sourcePaths);
		env.updatedSources.addAll(env.sources);
		env.createViewModels(viewPaths);
		env.engine.setFocusedResources(env.views);
		return env;
	}
	
	static public Environment createBackwardEnvironment(URI executable,String[] sourcePaths, String[] viewPaths) {
		Environment env = new Environment(false);
		env.transformation = env.loadSpecification(executable);
		env.loadSourceModels(sourcePaths);
		env.initUpdatedSource();
		env.loadViewModels(viewPaths);
		env.engine.setFocusedResources(env.updatedSources);
		return env;
	}
	
	public edu.ustb.sei.mde.xmu2.datatypes.Resource getSourceResourceList(int index) {
		return getResourceList(sources,index);
	}
	
	public edu.ustb.sei.mde.xmu2.datatypes.Resource getViewResourceList(int index) {
		return getResourceList(views,index);
	}
	
	public edu.ustb.sei.mde.xmu2.datatypes.Resource getUpdatedSourceResourceList(int index) {
		return getResourceList(updatedSources,index);
	}
	
	private edu.ustb.sei.mde.xmu2.datatypes.Resource getResourceList(List<Resource> resources, int index) {
		Resource rawRes = resources.get(index);
		edu.ustb.sei.mde.xmu2.datatypes.Resource res = resourceMap.get(rawRes);
		return res;
	}
	
	
	
	
	protected Environment(boolean isForward) {
		this();
		forward = isForward;
		cache = new CacheSystem();
		resourceSet = new ResourceSetImpl();
		AnalysisUtil.initializeResourceSet(resourceSet);
	}
	
	public boolean isForward() {
		return forward;
	}
	
	protected CacheSystem cache;
	
	public List<CallStatement> getFromProcedureCallCache(List<? extends Object> f) {
		return cache.getFromProcedureCallCache(f);
	}

	public void putIntoProcedureCallCache(List<? extends Object> f, List<CallStatement> s) {
		cache.putIntoProcedureCallCache(f, s);
	}

	public Object getFromOrderCache(List<Variable> f, Statement s) {
		return cache.getFromOrderCache(f, s);
	}

	public void putIntoOrderCache(List<Variable> f, Statement s, Object t) {
		cache.putIntoOrderCache(f, s, t);
	}

	protected boolean forward;
	protected TransformationTrace trace = null;
	public void putDefault(EObject s, EObject sp) {
		trace.putDefault(s, sp);
	}

	public Object getDefaultUpdated(Object s) {
		return trace.getDefaultUpdated(s);
	}
	
	public Object getDefaultSource(Object sp) {
		return trace.getDefaultSource(sp);
	}

	public void putTrace(Procedure r, Tuple t1, Tuple t2) {
		trace.putTrace(r, t1, t2);
	}

	public Tuple getTrace(Procedure r, Tuple t) {
		return trace.getTrace(r, t);
	}

	protected ModelModificationEngine engine = null;
	
	public Environment() {
		trace = new TransformationTrace();
		engine = new ModelModificationEngine();
	}

	public void replaceObject(EObject oldObj, EObject newObj) {
		engine.replaceObject(oldObj, newObj);
	}

	public boolean isCreatable(EObject s, EAttribute a, Object t) {
		return engine.isCreatable(s, a, t);
	}

	public boolean isCreatable(EObject s, EReference f, EObject t) {
		return engine.isCreatable(s, f, t);
	}

	public EObject createObject(EClass cls) {
		return engine.createObject(cls);
	}

	public void deleteObject(EObject obj) {
		engine.deleteObject(obj);
	}

	public boolean isDeletable(EObject e) {
		return engine.isDeletable(e);
	}

	public boolean isDeletable(EObject s, EAttribute f, Object t) {
		return engine.isDeletable(s, f, t);
	}

	public boolean isDeletable(EObject s, EReference f, EObject t) {
		return engine.isDeletable(s, f, t);
	}

	public void markAsUsed(EObject o) {
		engine.markAsUsed(o);
	}

	public void setFeature(EObject obj, EStructuralFeature feature, Object value) {
		engine.setFeature(obj, feature, value);
	}

	public void logCreation(EObject o) {
		engine.logCreation(o);
	}

	public void logCreation(EObject s, EAttribute att, Object t) {
		engine.logCreation(s, att, t);
	}

	public void logCreation(EObject s, EReference ref, EObject t) {
		engine.logCreation(s, ref, t);
	}

	public void logDeletion(EObject o) {
		engine.logDeletion(o);
	}

	public void logDeletion(EObject s, EAttribute att, Object t) {
		engine.logDeletion(s, att, t);
	}

	public void logDeletion(EObject s, EReference ref, EObject t) {
		engine.logDeletion(s, ref, t);
	}

	public void setFeatureAtIndex(EObject obj, EStructuralFeature feature, Object value, int id) {
		engine.setFeatureAtIndex(obj, feature, value, id);
	}

	public boolean containFeature(EObject object, EStructuralFeature feature, Object value) {
		return engine.containFeature(object, feature, value);
	}

	public boolean containFeature(EObject object, EStructuralFeature feature, int id, Object value) {
		return engine.containFeature(object, feature, id, value);
	}

	public SafeType getFeature(EObject obj, EStructuralFeature feature) {
		return engine.getFeature(obj, feature);
	}

	public Object getFeatureAsJavaObject(EObject obj, EStructuralFeature feature) {
		return engine.getFeatureAsJavaObject(obj, feature);
	}

	public Object getFeatureAtIndexAsJavaObject(EObject obj, EStructuralFeature feature, int id) {
		return engine.getFeatureAtIndexAsJavaObject(obj, feature, id);
	}

	public SafeType getFeatureAtIndex(EObject obj, EStructuralFeature feature, int id) {
		return engine.getFeatureAtIndex(obj, feature, id);
	}

	public int getFeatureIndexAsJavaObject(EObject object, EStructuralFeature feature, Object value) {
		return engine.getFeatureIndexAsJavaObject(object, feature, value);
	}

	public SafeType getFeatureIndex(EObject object, EStructuralFeature feature, Object value) {
		return engine.getFeatureIndex(object, feature, value);
	}

	public List<Object> getFeatureAsInternalCollection(EObject obj, EStructuralFeature feature) {
		return engine.getFeatureAsInternalCollection(obj, feature);
	}

//	public OclCollection<?> getFeatureAsOclCollection(EObject obj, EStructuralFeature feature) {
//		return engine.getFeatureAsOclCollection(obj, feature);
//	}
//
//	public SafeType getFeatureAsCollection(EObject obj, EStructuralFeature feature) {
//		return engine.getFeatureAsCollection(obj, feature);
//	}

	public boolean isCreatable(EObject s, EStructuralFeature f, Object v) {
		return engine.isCreatable(s, f, v);
	}

	public boolean isDeletable(EObject s, EStructuralFeature f, Object t) {
		return engine.isDeletable(s, f, t);
	}

	public void insertFeatureAtIndex(EObject obj, EStructuralFeature feature, Object value, int id) {
		engine.insertFeatureAtIndex(obj, feature, value, id);
	}

	public void logDeletion(EObject s, EStructuralFeature f, Object v) {
		engine.logDeletion(s, f, v);
	}

	public void logCreation(EObject s, EStructuralFeature f, Object v) {
		engine.logCreation(s, f, v);
	}

	public List<Object> getFeatureAsFeatureList(EObject obj, EStructuralFeature feature) {
		return engine.getFeatureAsFeatureList(obj, feature);
	}

	public boolean deleteLink(EObject source, EStructuralFeature feature, Object value) {
		return engine.deleteLink(source, feature, value);
	}

	public Tuple getTrace(Procedure rule, List<Object> parameterList) {
		Tuple t = new Tuple(parameterList.toArray());
		return getTrace(rule,t);
	}

	public void putTrace(Procedure rule, List<Object> parameterList, List<Object> viewList) {
		Tuple t1 = new Tuple(parameterList.toArray());
		Tuple t2 = new Tuple(viewList.toArray());
		putTrace(rule, t1, t2);
	}

	public Transformation loadSpecification(URI buildFile) {
		Resource res = resourceSet.getResource(buildFile, true);
		EcoreUtil.resolveAll(res);
		Transformation t =  (Transformation) res.getContents().get(0);
		for(EPackage p : t.getPackages()) {
			resourceSet.getPackageRegistry().put(p.getNsURI(), p);
		}
		return t;
	}

	public void save() {
		Map<Object,Object> options  = new HashMap<Object,Object>();
		options.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, true);
		options.put(XMLResource.OPTION_SCHEMA_LOCATION, true);
		
		transformation.eResource().setModified(false);
		
		for(EPackage p : this.transformation.getPackages()) {
			p.eResource().setModified(false);
		}
		
		if(this.forward) {
			for(Resource res : this.views) {
				saveResource(res, options);
			}
		} else {
			for(Resource res : this.updatedSources) {
				saveResource(res, options);
			}
		}
	}
	
	private Resource getFinalResource(EObject o) {
		if(o.eContainer()==null) {
			Resource eResource = o.eResource();
			if(eResource==null) return null;
			else return eResource.getContents().contains(o) ? eResource : null;
		} else
			return getFinalResource(o.eContainer());
	}

	protected void saveResource(Resource res, Map<Object, Object> options) {
		
		TreeIterator<EObject> it = res.getAllContents();
		while (it.hasNext()) {
			EObject o = it.next();
			EClass cls = o.eClass();
			for (EReference r : cls.getEAllReferences()) {
				if (r.isContainment() == false) {
					if (r.isMany()) {
						List<EObject> list = (List) o.eGet(r);
						for (EObject eo : list) {
							if (eo.eResource() == null) {
								this.engine.deleteObjectFromModel(eo,this.resourceSet);
							}
						}
					} else {
						EObject eo = (EObject) o.eGet(r);
						if (eo != null && eo.eResource() == null) {
							System.out.println("a dangling object " + eo);
							this.engine.deleteObjectFromModel(eo,this.resourceSet);
						}
					}
				}
			}

		}
		
		try {
			res.save(options);
		} catch (IOException e) {
			e.printStackTrace(this.printer);
		}
	}

//	public boolean deleteSourcePostElement(EObject source, EObject sourcePost) {
//		return engine.deleteSourcePostElement(source, sourcePost);
//	}
	
	public Object getExternalData(Object... keys) {
		return this.externalData.get(keys);
	}
	
	public void putExternalData(Object value, Object... keys) {
		this.externalData.put(value, keys);
	}
	
}
