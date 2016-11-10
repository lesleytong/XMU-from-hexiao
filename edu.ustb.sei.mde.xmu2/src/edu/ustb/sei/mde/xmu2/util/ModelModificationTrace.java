package edu.ustb.sei.mde.xmu2.util;

import java.util.HashMap;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ModelModificationTrace {
	private HashMap<EObject,ObjectModification> map = new HashMap<EObject,ObjectModification>();
	
	public boolean isCreatable(EObject s, EStructuralFeature f, Object v) {
		if(f instanceof EReference)
			return isCreatable(s, (EReference)f, (EObject)v);
		else
			return isCreatable(s, (EAttribute)f, v);
	}
	
	public boolean isCreatable(EObject s, EAttribute a, Object t) {
		//s或t没有被删除
		//(s,t)没有被删除
		//(t,s)没有被删除，如果f.opposite!=null
		if(isDeleted(s)) return false;
		if(a.isMany()) {
			if(isDeleted(s,a,t)) return false;
		} else {
			ObjectModification m = map.get(s);
			if(m!=null && m.checkSet(a)) return false;
		}
		return true;
	}

	public boolean isCreatable(EObject s, EReference f, EObject t) {
		//s或t没有被删除
		//(s,t)没有被删除
		//(t,s)没有被删除，如果f.opposite!=null
		if(isDeleted(s) && isDeleted(t)) return false;
		if(f.isMany()) {
			if(isDeleted(s,f,t)) return false;
		} else {
			ObjectModification m = map.get(s);
			if(m!=null && m.checkSet(f)) return false;
			if(f.getEOpposite()!=null) {
				if(f.getEOpposite().isMany()) {
					if(isDeleted(t,f.getEOpposite(),s)) 
						return false;
				} else {
					m = map.get(t);
					if(m!=null && m.checkSet(f.getEOpposite())) return false;					
				}
				
			}
		}
		return true;
	}
	
	public boolean isDeletable(EObject e) {
		ObjectModification m = map.get(e);
		if(m==null || m.isRequire() ==false) return true;
		return false;
	}
	
	public boolean isDeletable(EObject s, EStructuralFeature f, Object t) {
		if(f instanceof EReference)
			return isDeletable(s, (EReference)f, (EObject)t);
		else 
			return isDeletable(s,(EAttribute)f,t);
	}
	
	public boolean isDeletable(EObject s, EAttribute f, Object t) {
		//s或t没有被创建
		//(s,t)没有被创建
		//(t,s)没有被创建，如果f.opposite!=null
		//if(hasCreatedOrModified(s)) return false;
		if(isCreated(s,f,t)) return false;
		return true;
	}
	
	public boolean isDeletable(EObject s, EReference f, EObject t) {
		//s或t没有被创建
		//(s,t)没有被创建
		//(t,s)没有被创建，如果f.opposite!=null
		//if(hasCreatedOrModified(s) || hasCreatedOrModified(t)) return false;
		if(isCreated(s,f,t)) return false;
		return true;
	}
	
	public HashMap<EObject, ObjectModification> getMap() {
		return map;
	}
	
	private boolean isCreated(EObject s, EAttribute att, Object v) {
		ObjectModification ms = map.get(s);
		if(ms==null) return false;
		if(ms.checkAdd(att, v)) return true;
		return false;
	}
	//
	
	private boolean isCreated(EObject s, EReference ref, EObject t) {
		ObjectModification ms = map.get(s);
		if(ms==null) return false;
		if(ms.checkAdd(ref, t)) return true;
		return false;
	}
	
	@Deprecated
	private boolean isCreatedOrModified(EObject o) {
		ObjectModification m = map.get(o);
		if(m!=null && m.isDelete()==false) return true;
		return false;
	}
	
	//Test Method
	private boolean isDeleted(EObject o) {
		ObjectModification m = map.get(o);
		if(m==null || m.isDelete()==false) return false;
		return true;
	}
	
	private boolean isDeleted(EObject s, EAttribute att, Object v) {
		if(isDeleted(s)) return true;
		ObjectModification ms = map.get(s);
		if(ms!=null && ms.checkRemove(att, v)) return true;
		return false;
	}
	
	private boolean isDeleted(EObject s, EReference ref, EObject t) {
		if(isDeleted(s) || isDeleted(t)) return true;
		ObjectModification ms = map.get(s);
		if(ms!=null && ms.checkRemove(ref, t)) return true;
		return false;
	}
	
	protected void logBasicCreation(EObject s, EStructuralFeature feature, Object t) {
		ObjectModification m = map.get(s);
		if(m==null) {
			m = new ObjectModification(s,false);
			map.put(s, m);
		}
		
		m.setRequire(true);
		
		if(feature.isMany()==false) {
			Object oldValue = s.eGet(feature);
			if(oldValue!=null && oldValue!=t) {
				logBasicDeletion(s,feature,oldValue);
			}
		}
		
		m.addFeature(feature, t);
	}
	
	protected void logBasicDeletion(EObject s, EStructuralFeature feature, Object t) {
		ObjectModification m = map.get(s);
		if(m==null) {
			m = new ObjectModification(s,false);
			map.put(s, m);
		}
		
		m.removeFeature(feature, t);
	}
	//
	
	public void logCreation(EObject o) {		
		ObjectModification m = map.get(o);
		if(m==null) {
			m = new ObjectModification(o,false);
			map.put(o, m);
		}
		m.setRequire(true);
	}
	
	public void logCreation(EObject s, EAttribute att, Object t) {
		logBasicCreation(s,att,t);
	}
	
	public void logCreation(EObject s, EReference ref, EObject t) {
		logBasicCreation(s,ref,t);
		if(ref.getEOpposite()!=null) {
			logBasicCreation(t,ref.getEOpposite(),s);
		}
		logCreation(t);
	}
	
	//Track Method
	public void logDeletion(EObject o) {
		ObjectModification m = map.get(o);
		if(m==null) {
			m = new ObjectModification(o,true);
			map.put(o, m);
		}
		m.setDelete(true);
	}
	
	public void logDeletion(EObject s, EAttribute att, Object t) {
		logBasicDeletion(s,att,t);
	}
	
	public void logDeletion(EObject s, EReference ref,EObject t) {
		logBasicDeletion(s,ref,t);
		if(ref.getEOpposite()!=null) {
			logBasicDeletion(t,ref.getEOpposite(),s);
		}
	}
	
	public void logDeletion(EObject s, EStructuralFeature f, Object v) {
		if(f instanceof EReference)
			logDeletion(s,(EReference)f,(EObject)v);
		else
			logDeletion(s,(EAttribute)f,v);
	}
	
	public void logCreation(EObject s, EStructuralFeature f, Object v) {
		if(f instanceof EReference)
			logCreation(s,(EReference)f,(EObject)v);
		else
			logCreation(s,(EAttribute)f,v);
	}
}