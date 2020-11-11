package edu.ustb.sei.mde.query.infra.ecore;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ustb.sei.mde.query.indexing.BitProfile;
import edu.ustb.sei.mde.query.indexing.Profile;
import edu.ustb.sei.mde.query.infra.IQueryIntrastructure;
import edu.ustb.sei.mde.query.infra.TypeContext;
import edu.ustb.sei.mde.query.structure.CompositeCollection;
import edu.ustb.sei.mde.query.structure.ContainerCreator;
import edu.ustb.sei.mde.query.structure.MultiMap;
import edu.ustb.sei.mde.query.structure.PairMap;
import edu.ustb.sei.mde.query.structure.PairMultiMap;

/**
 * indexing and monitoring the changes from models
 * @author hexiao
 *
 */
public class EcoreQueryInfrastructure implements
		IQueryIntrastructure<EPackage, Resource, EClassifier, EClass, EObject, EDataType, Object, EStructuralFeature, EReference, Setting, EAttribute, Setting> {

	protected MultiMap<EClass, EObject> allObjectsMap = new MultiMap<>();
	protected MultiMap<EClass, Profile<EObject>> allObjectProfilesMap = new MultiMap<>();
	protected Map<EObject,Profile<EObject>> obj2Profile = ContainerCreator.autoMap();
	protected PairMultiMap<EObject, EReference, Setting> allLinksMap = new PairMultiMap<>();
	protected PairMultiMap<EObject, EReference, Setting> allInverseLinksMap = new PairMultiMap<>();
	protected PairMultiMap<EObject, EAttribute, Setting> allSlotLinksMap = new PairMultiMap<>();
	protected EcoreTypeContext typeContext;
	
	public EcoreQueryInfrastructure() {
		
	}
	
	protected void addObject(EObject obj) {
		allObjectsMap.put(obj.eClass(), obj);
		getContext().getAllSuperTypes(obj.eClass()).forEach(c->{
			allObjectsMap.put(c, obj);
		});
	}

	protected void createProfile(EObject obj) {
		BitProfile<EObject> profile = computeProfile(obj);
		allObjectProfilesMap.put(obj.eClass(), profile);
		getContext().getAllSuperTypes(obj.eClass()).forEach(c->{
			allObjectProfilesMap.put(c, profile);
		});
		obj2Profile.put(obj, profile);
	}
	
	/**
	 * we do not check boundary now
	 * @param obj
	 * @return
	 */
	private BitProfile<EObject> computeProfile(EObject obj) {
		BitProfile<EObject> profile = new BitProfile<>();
		profile.setReferredObject(obj);
		EClass cls = obj.eClass();
		
		profile.setTypeMask(typeContext.getTypeId(cls));
		
		Collection<EReference> refs = typeContext.getAllReferences(cls);
		Collection<EReference> invRefs = typeContext.getInverseReferences(cls);
		
		refs.forEach(r->{
			Collection<?> col = this.getTargets(obj, r);
			if(col!=null && !col.isEmpty())
				profile.setNeighborEdgeMask(typeContext.getFeatureId(r));
		});
		
		invRefs.forEach(r->{
			Collection<?> col = this.getSources(obj, r);
			if(col!=null && !col.isEmpty())
				profile.setNeighborEdgeMask(typeContext.getFeatureId(typeContext.getInverseFeature(r)));
		});
		
		return profile;
	}

	protected void addLink(EObject source, EReference ref, EObject target) {
		Link l = new Link();
		l.source = source;
		l.reference = ref;
		l.target = target;
		
		allLinksMap.put(source, ref, l);
		allInverseLinksMap.put(target, ref, l);
	}
	
	protected void addSlotLink(EObject source, EAttribute ref, Object value) {
		SlotLink l = new SlotLink();
		l.source = source;
		l.attribute = ref;
		l.value = value;
		
		allSlotLinksMap.put(source, ref, l);
	}
	
	class SlotLink implements Setting {
		private EObject source;
		private Object value;
		private EAttribute attribute;

		@Override
		public EObject getEObject() {
			return source;
		}

		@Override
		public EStructuralFeature getEStructuralFeature() {
			return attribute;
		}

		@Override
		public Object get(boolean resolve) {
			return value;
		}

		@Override
		public void set(Object newValue) {
			this.value = newValue;
		}

		@Override
		public boolean isSet() {
			return this.value!=null;
		}

		@Override
		public void unset() {
			EcoreUtil.remove(source, attribute, value);
		}
		
	}
	
	class Link implements Setting {
		private EObject source;
		private EObject target;
		private EReference reference;

		@Override
		public EObject getEObject() {
			return source;
		}

		@Override
		public EStructuralFeature getEStructuralFeature() {
			return reference;
		}

		@Override
		public EObject get(boolean resolve) {
			return target;
		}

		@Override
		public void set(Object newValue) {
			this.target = (EObject) newValue;
		}

		@Override
		public boolean isSet() {
			return this.target!=null;
		}

		@Override
		public void unset() {
			EcoreUtil.remove(source, reference, target);
		}
		
	}
	
	@Override
	public Collection<EObject> getAllObjectsOf(EClass type) {
		return allObjectsMap.get(type);
	}

	@Override
	public Collection<Setting> getLinksOf(EReference ref) {
		Collection<EObject> srcs = getAllObjectsOf(ref.getEContainingClass());
		CompositeCollection<Setting> col = new CompositeCollection<>(srcs.stream().map(src->allLinksMap.get(src, ref)));
		return col;
	}

	@Override
	public PairMap<EObject, EObject, Boolean> getLinksMapOf(EReference ref) {
		PairMap<EObject, EObject, Boolean> map = new PairMap<>();
		Collection<Setting> cols = getLinksOf(ref);
		cols.forEach(set->{
			map.put(set.getEObject(), (EObject) set.get(false), true);
		});
		return map;
	}

	@Override
	public Collection<Setting> getLinksFrom(EObject source, EReference ref) {
		return allLinksMap.get(source, ref);
	}


	@Override
	public Collection<Setting> getLinksTo(EObject target, EReference ref) {
		return allInverseLinksMap.get(target, ref);
	}


	@Override
	public Collection<Setting> getSlotLinksOf(EAttribute ref) {
		Collection<EObject> srcs = getAllObjectsOf(ref.getEContainingClass());
		CompositeCollection<Setting> col = new CompositeCollection<>(srcs.stream().map(src->getSlotLinksFrom(src, ref)));
		return col;
	}


	@Override
	public Collection<Setting> getSlotLinksFrom(EObject source, EAttribute ref) {
		return allSlotLinksMap.get(source, ref);
	}


	@SuppressWarnings("unchecked")
	@Override
	public Collection<EObject> getTargets(EObject source, EReference ref) {
		if(ref.isMany())
			return ((Collection<EObject>)source.eGet(ref));
		else {
			EObject t = (EObject) source.eGet(ref);
			List<EObject> col;
			if(t==null) col = Collections.emptyList();
			else col = Collections.singletonList(t);
			
			return col;
		}
	}
	
	@Override
	public Collection<EObject> getSources(EObject target, EReference ref) {
		return this.getLinksTo(target, ref).stream().map(l->l.getEObject()).collect(Collectors.toSet());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Object> getSlots(EObject source, EAttribute ref) {
		if(ref.isMany())
			return ((Collection<Object>)source.eGet(ref));
		else {
			Object t = source.eGet(ref);
			List<Object> col;
			if(t==null) col = Collections.emptyList();
			else col = Collections.singletonList(t);
			
			return col;
		}
	}

	@Override
	public TypeContext<EPackage, EClassifier, EClass, EDataType, EStructuralFeature, EReference, EAttribute> getContext() {
		return typeContext;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void addModel(Resource model) {
		model.getAllContents().forEachRemaining(e->{
			addObject(e);
			EClass type = e.eClass();
			getContext().getAllReferences(type).forEach(ref->{
				Object raw = e.eGet(ref);
				if(ref.isMany()) {
					((Collection<EObject>)raw).forEach(tar->addLink(e, ref, tar));
				} else {
					if(raw!=null) addLink(e, ref, (EObject) raw); 
				}
			});
			getContext().getAllAttributes(type).forEach(attr->{
				Object raw = e.eGet(attr);
				if(attr.isMany()) {
					((Collection<Object>)raw).forEach(tar->addSlotLink(e, attr, tar));
				} else {
					if(raw!=null) addSlotLink(e, attr, raw); 
				}
			});
		});
		
		// indexing
		model.getAllContents().forEachRemaining(e->{
			createProfile(e);
		});
	}

	@Override
	public Collection<Profile<EObject>> getAllObjectProfilesOf(EClass type) {
		return this.allObjectProfilesMap.get(type);
	}

	@Override
	public List<EObject> getSourceList(EObject target, EReference ref) {
		return this.getLinksTo(target, ref).stream().map(l->l.getEObject()).collect(Collectors.toList());
	}

	@Override
	public Collection<EObject> getSlotSources(Object slot, EAttribute ref) {
		Collection<EObject> allObjects = this.getAllObjectsOf(ref.getEContainingClass());
		Set<EObject> sources = new HashSet<>();
		
		allObjects.forEach(o->{
			Collection<Setting> slotLinks = getSlotLinksFrom(o, ref);
			if(slotLinks.stream().anyMatch(sl->sl.get(true).equals(slot))) {
				sources.add(o);
			}
		});
		return sources;
	}

	@Override
	public void setContext(TypeContext<EPackage,EClassifier,EClass, EDataType,EStructuralFeature,EReference,EAttribute> context) {
		typeContext = (EcoreTypeContext) context;
	}

	

}
