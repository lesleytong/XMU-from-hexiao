package edu.ustb.sei.mde.xmu2.util;

import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.commonutil.util.Pair;

public class ObjectModification {
	@SuppressWarnings("unused")
	private EObject object;
	// if the object has been deleted
	private boolean delete;
	// if the object is required
	// !(require && delete)
	private boolean require;
	
	public boolean isRequire() {
		return require;
	}

	public void setRequire(boolean require) {
		this.require = require;
	}

	public void setDelete(boolean delete) {
		this.delete = delete;
	}

	public boolean isDelete() {
		return delete;
	}

	private HashSet<Pair<EStructuralFeature,Object>> addFeatures;
	private HashSet<Pair<EStructuralFeature,Object>> removeFeatures;
	
	public ObjectModification(EObject o,boolean delete) {
		object = o;
		this.delete = delete;
		addFeatures = new HashSet<Pair<EStructuralFeature,Object>>();
		removeFeatures = new HashSet<Pair<EStructuralFeature,Object>>();
	}
	
	public boolean checkAdd(EStructuralFeature feature, Object v) {
		return addFeatures.contains(new Pair<EStructuralFeature,Object>(feature,v));
	}
	
	public boolean checkRemove(EStructuralFeature feature, Object v) {
		return removeFeatures.contains(new Pair<EStructuralFeature,Object>(feature,v));
	}
	
	public boolean checkSet(EStructuralFeature feature) {
		for(Pair<EStructuralFeature,Object> pair : addFeatures) {
			if(pair.getFirst()==feature) return true;
		}
		return false;
	}
	
	public void addFeature(EStructuralFeature feature, Object value) {
		addFeatures.add(new Pair<EStructuralFeature,Object>(feature,value));
	}
	
	public void removeFeature(EStructuralFeature feature, Object value) {
		removeFeatures.add(new Pair<EStructuralFeature,Object>(feature,value));
	}
}