package edu.ustb.sei.mde.xmu.resource.xmu.interpret;

import java.util.HashMap;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class ModificationTrackSystem {
	private HashMap<EObject,ObjectModification> map = new HashMap<EObject,ObjectModification>();
	public HashMap<EObject, ObjectModification> getMap() {
		return map;
	}

	public void create(EObject o) {		
		ObjectModification m = map.get(o);
		if(m==null) {
			m = new ObjectModification(o,false);
			map.put(o, m);
		}
	}
	
	//Test Method
	private boolean hasDeleted(EObject o) {
		ObjectModification m = map.get(o);
		if(m==null || m.isDelete()==false) return false;
		return true;
	}
	
	private boolean hasDeleted(EObject s, EReference ref, EObject t) {
		if(hasDeleted(s) || hasDeleted(t)) return true;
		ObjectModification ms = map.get(s);
		if(ms!=null && ms.checkRemove(ref, t)) return true;
		return false;
	}
	
	private boolean hasDeleted(EObject s, EAttribute att, Object v) {
		if(hasDeleted(s)) return true;
		ObjectModification ms = map.get(s);
		if(ms!=null && ms.checkRemove(att, v)) return true;
		return false;
	}
	
	private boolean hasCreatedOrModified(EObject o) {
		ObjectModification m = map.get(o);
		if(m!=null && m.isDelete()==false) return true;
		return false;
	}
	
	private boolean hasCreated(EObject s, EReference ref, EObject t) {
		ObjectModification ms = map.get(s);
		if(ms==null) return false;
		if(ms.checkAdd(ref, t)) return true;
		return false;
	}
	
	private boolean hasCreated(EObject s, EAttribute att, Object v) {
		ObjectModification ms = map.get(s);
		if(ms==null) return false;
		if(ms.checkAdd(att, v)) return true;
		return false;
	}
	//
	
	//Track Method
	public void delete(EObject o) {
		ObjectModification m = map.get(o);
		if(m==null) {
			m = new ObjectModification(o,true);
			map.put(o, m);
		}
		m.setDelete(true);
	}
	
	public void create(EObject s, EReference ref, EObject t) {
		basicCreate(s,ref,t);
		if(ref.getEOpposite()!=null) {
			basicCreate(t,ref.getEOpposite(),s);
		}
	}
	
	public void create(EObject s, EAttribute att, Object t) {
		basicCreate(s,att,t);
	}
	
	public void delete(EObject s, EReference ref,EObject t) {
		basicDelete(s,ref,t);
		if(ref.getEOpposite()!=null) {
			basicDelete(t,ref.getEOpposite(),s);
		}
	}
	
	public void delete(EObject s, EAttribute att, Object t) {
		basicDelete(s,att,t);
	}
	
	protected void basicCreate(EObject s, EStructuralFeature feature, Object t) {
		ObjectModification m = map.get(s);
		if(m==null) {
			m = new ObjectModification(s,false);
			map.put(s, m);
		}
		
		if(feature.isMany()==false) {
			Object oldValue = s.eGet(feature);
			if(oldValue!=null && oldValue!=t) {
				basicDelete(s,feature,oldValue);
			}
		}
		
		m.addFeature(feature, t);
	}
	
	protected void basicDelete(EObject s, EStructuralFeature feature, Object t) {
		ObjectModification m = map.get(s);
		if(m==null) {
			m = new ObjectModification(s,false);
			map.put(s, m);
		}
		
		m.removeFeature(feature, t);
	}
	//
	
	public boolean canDelete(EObject e) {
		return !hasCreatedOrModified(e);
	}
	
	public boolean canCreate(EObject s, EReference f, EObject t) {
		//s或t没有被删除
		//(s,t)没有被删除
		//(t,s)没有被删除，如果f.opposite!=null
		if(hasDeleted(s) && hasDeleted(t)) return false;
		if(f.isMany()) {
			if(hasDeleted(s,f,t)) return false;
		} else {
			ObjectModification m = map.get(s);
			if(m!=null && m.checkSet(f)) return false;
			if(f.getEOpposite()!=null) {
				if(f.getEOpposite().isMany()) {
					if(hasDeleted(t,f.getEOpposite(),s)) 
						return false;
				} else {
					m = map.get(t);
					if(m!=null && m.checkSet(f.getEOpposite())) return false;					
				}
				
			}
		}
		return true;
	}
	
	public boolean canDelete(EObject s, EReference f, EObject t) {
		//s或t没有被创建
		//(s,t)没有被创建
		//(t,s)没有被创建，如果f.opposite!=null
		//if(hasCreatedOrModified(s) || hasCreatedOrModified(t)) return false;
		if(hasCreated(s,f,t)) return false;
		return true;
	}
	
	public boolean canCreate(EObject s, EAttribute a, Object t) {
		//s或t没有被删除
		//(s,t)没有被删除
		//(t,s)没有被删除，如果f.opposite!=null
		if(hasDeleted(s)) return false;
		if(a.isMany()) {
			if(hasDeleted(s,a,t)) return false;
		} else {
			ObjectModification m = map.get(s);
			if(m!=null && m.checkSet(a)) return false;
		}
		return true;
	}
	
	public boolean canDelete(EObject s, EAttribute f, Object t) {
		//s或t没有被创建
		//(s,t)没有被创建
		//(t,s)没有被创建，如果f.opposite!=null
		//if(hasCreatedOrModified(s)) return false;
		if(hasCreated(s,f,t)) return false;
		return true;
	}
}