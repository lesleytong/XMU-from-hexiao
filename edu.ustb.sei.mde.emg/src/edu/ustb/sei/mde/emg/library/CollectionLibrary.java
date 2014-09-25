package edu.ustb.sei.mde.emg.library;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.emg.runtime.datatype.OclBag;
import edu.ustb.sei.mde.emg.runtime.datatype.OclOrderedSet;
import edu.ustb.sei.mde.emg.runtime.datatype.OclSequence;
import edu.ustb.sei.mde.emg.runtime.datatype.OclSet;
import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;
import edu.ustb.sei.mde.morel.MorelPackage;

public class CollectionLibrary extends AnyLibrary {

	public CollectionLibrary(LibrarySpace librarySpace) {
		super(librarySpace);
		// TODO Auto-generated constructor stub
	}
	public boolean adaptFor(Object type) {
		if(type==MorelPackage.eINSTANCE.getCollectionType()) return true;
		return false;
	}
	public Object execute(String operation, Object self, Object... params) {
		switch(operation) {
		case "size":
			return size(self);
		case "includes":
			return includes(self,params[0]);
		case "excludes":
			return excludes(self,params[0]);
		case "count":
			return count(self,params[0]);
		case "includesAll":
			return includesAll(self,params[0]);
		case "excludesAll":
			return excludesAll(self,params[0]);
		case "isEmpty":
			return isEmpty(self);
		case "notEmpty":
			return notEmpty(self);
		case "asSet":
			return asSet(self);
		case "asBag":
			return asBag(self);
		case "asSequence":
			return asSequence(self);
		case "asOrderedSet":
			return asOrderedSet(self);
		default:
			throw new UnsupportedOperationException(operation);
		}
	}
//	@Override
//	public Object equal(Object self, Object right) {
//		return self.equals(right);
//	}
//	@Override
//	public Object notEqual(Object self, Object right) {
//		// TODO Auto-generated method stub
//		return super.notEqual(self, right);
//	}
	
	public Object includes(Object self, Object object) {
		try {
			Collection<?> col = (Collection<?>)self;
			return col.contains(object);
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object excludes(Object self, Object object) {
		try {
			Collection<?> col = (Collection<?>)self;
			return !col.contains(object);
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}

	public Object count(Object self, Object object) {
		try {
			Collection<?> col = (Collection<?>)self;
			return Collections.frequency(col, object);
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}

	public Object includesAll(Object self, Object object) {
		try {
			Collection<?> col = (Collection<?>)self;
			Collection<?> right = (Collection<?>)object;
			
			return col.containsAll(right);
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object excludesAll(Object self, Object object) {
		try {
			Collection<?> col = (Collection<?>)self;
			Collection<?> right = (Collection<?>)object;
			
			return Collections.disjoint(col, right);
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object size(Object self) {
		try {
			Collection<?> col = (Collection<?>)self;
			return col.size();
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object isEmpty(Object self) {
		try {
			if(self==null)
				return true;
			Collection<?> col = (Collection<?>)self;
			return col.isEmpty();
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object notEmpty(Object self) {
		try {
			if(self==null)
				return false;
			Collection<?> col = (Collection<?>)self;
			return !col.isEmpty();
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object asSet(Object self) {
		try {
			Collection<?> col = (Collection<?>)self;
			EObject type = (EObject)super.oclType(this);
			
			OclSet set = new OclSet(col);
			set.setType(type);
			
			return set;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}	
	}
	
	public Object asBag(Object self) {
		try {
			Collection<?> col = (Collection<?>)self;
			EObject type = (EObject)super.oclType(this);
			
			OclBag bag = new OclBag(col);
			bag.setType(type);
			
			return bag;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object asSequence(Object self) {
		try {
			Collection<?> col = (Collection<?>)self;
			EObject type = (EObject)super.oclType(this);
			
			OclSequence seq = new OclSequence(col);
			seq.setType(type);
			
			return seq;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object asOrderedSet(Object self) {
		try {
			Collection<?> col = (Collection<?>)self;
			EObject type = (EObject)super.oclType(this);
			
			OclOrderedSet oSet = new OclOrderedSet(col);
			oSet.setType(type);

			return oSet;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
}
