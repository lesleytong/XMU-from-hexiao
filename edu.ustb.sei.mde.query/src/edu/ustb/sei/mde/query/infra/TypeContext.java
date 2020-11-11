package edu.ustb.sei.mde.query.infra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import edu.ustb.sei.mde.query.structure.BiMap;
import edu.ustb.sei.mde.query.structure.MultiMap;
import edu.ustb.sei.mde.query.structure.UncontrolledMultiMap;

/**
 * An abstraction of metamodels
 * @author hexiao
 *
 * @param <CLS>
 * @param <REF>
 * @param <ATTR>
 * @param <DAT>
 */
public abstract class TypeContext<PKG,C,CLS extends C, DAT extends C, F, REF extends F, ATTR extends F> {
	protected List<PKG> packageList;
	protected BiMap<C,Integer> typeIdMap;
	protected BiMap<F,Integer> featureIdMap;
	
	protected List<CLS> sortedTypeList;
	
	 
	
	protected UncontrolledMultiMap<CLS, CLS> subClassMap;
	protected UncontrolledMultiMap<CLS, CLS> supClassMap;
	
	protected UncontrolledMultiMap<CLS, REF> allReferencesMap;
	protected UncontrolledMultiMap<CLS, ATTR> allAttributesMap;
	
	protected MultiMap<CLS, REF> allInverseReferencesMap;
	
	public TypeContext() {
		this.packageList = new ArrayList<>();
		this.typeIdMap = new BiMap<>();
		this.featureIdMap = new BiMap<>();
		this.subClassMap = new UncontrolledMultiMap<>();
		this.supClassMap = new UncontrolledMultiMap<>();
		this.sortedTypeList = new ArrayList<>();
		
		this.allReferencesMap = new UncontrolledMultiMap<>();
		this.allAttributesMap = new UncontrolledMultiMap<>();
		
		this.allInverseReferencesMap = new MultiMap<>();
	}
	
	public boolean isSuperTypeOf(CLS par, CLS child) {
		Collection<CLS> sups = this.supClassMap.get(child, Collections.emptySet());
		return sups.contains(par);
	}
	
	public void addPackage(PKG pkg) {
		if(!packageList.contains(pkg)) {
			packageList.add(pkg);
			resolvePackage(pkg);
		}
	}
	
	protected void addTypeIdMap(C type, Integer id) {
		this.typeIdMap.forwardPut(type, id);
	}
	
	public Integer getTypeId(C type) {
		return this.typeIdMap.forwardGet(type);
	}
	
	protected void addFeatureIdMap(F feature, Integer id) {
		this.featureIdMap.forwardPut(feature, id);
	}
	
	public Integer getFeatureId(F feature) {
		return this.featureIdMap.forwardGet(feature);
	}
	
	protected abstract void resolvePackage(PKG pkg);
	
	public abstract boolean isClass(C c);
	public abstract F getInverseFeature(F feature);
	
	protected void addSubclasses(CLS par, CLS chl) {
		this.subClassMap.put(par, chl, HashSet::new);
	}
	
	protected void addSupClasses(CLS chl, List<CLS> pars) {
		this.supClassMap.set(chl, new HashSet<>(pars));
	}
	
	protected void addReferences(CLS cls, List<REF> refs) {
		this.allReferencesMap.set(cls, refs);
	}
	
	public Collection<REF> getInverseReferences(CLS cls) {
		return this.allInverseReferencesMap.get(cls);
	}
	
	protected void addInverseReference(CLS cls, REF ref) {
		this.allInverseReferencesMap.put(cls, ref);
	}
	
	protected void addAttributes(CLS cls, List<ATTR> refs) {
		this.allAttributesMap.set(cls, refs);
	}
	
	protected void addToSortedList(CLS type) {
		for(int i=0;i<sortedTypeList.size();i++) {
			CLS ci = sortedTypeList.get(i);
			if(isSuperTypeOf(type, ci)) {
				sortedTypeList.add(i, type);
				return;
			}
		}
		sortedTypeList.add(type);
	}

	public Collection<CLS> getAllSuperTypes(CLS cls) {
		return supClassMap.getOrDefault(cls, Collections.emptySet());
	}
	
	public Collection<CLS> getAllSubTypes(CLS cls) {
		return subClassMap.getOrDefault(cls, Collections.emptySet());
	}

	public Collection<REF> getAllReferences(CLS type) {
		return allReferencesMap.getOrDefault(type, Collections.emptySet());
	}
	
	public Collection<ATTR> getAllAttributes(CLS type) {
		return allAttributesMap.getOrDefault(type, Collections.emptySet());
	}

	public abstract boolean isReference(F type);
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		sortedTypeList.forEach(t->{
			builder.append(typeIdMap.forwardGet(t));
			builder.append("\t->\t");
			builder.append(t);
			builder.append("\n");
			builder.append("\tSub-types: ");
			getAllSubTypes(t).forEach(sbt->{
				builder.append(typeIdMap.forwardGet(sbt));
				builder.append(" ");
			});
			builder.append("\n");
			builder.append("\tReferences:\n");
			getAllReferences(t).forEach(ref->{
				builder.append("\t");
				builder.append(featureIdMap.forwardGet(ref));
				builder.append("\t->\t");
				builder.append(ref);
				builder.append("\n");
			});
			builder.append("\n");
		});
		return builder.toString();
	}
}
