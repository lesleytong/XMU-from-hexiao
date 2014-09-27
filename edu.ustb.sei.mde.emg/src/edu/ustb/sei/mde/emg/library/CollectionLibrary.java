package edu.ustb.sei.mde.emg.library;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.emg.runtime.datatype.OclBag;
import edu.ustb.sei.mde.emg.runtime.datatype.OclCollection;
import edu.ustb.sei.mde.emg.runtime.datatype.OclOrderedSet;
import edu.ustb.sei.mde.emg.runtime.datatype.OclSequence;
import edu.ustb.sei.mde.emg.runtime.datatype.OclSet;
import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;
import edu.ustb.sei.mde.morel.BagType;
import edu.ustb.sei.mde.morel.CollectionType;
import edu.ustb.sei.mde.morel.MorelFactory;
import edu.ustb.sei.mde.morel.MorelPackage;
import edu.ustb.sei.mde.morel.OrderedSetType;
import edu.ustb.sei.mde.morel.SequenceType;
import edu.ustb.sei.mde.morel.SetType;

public abstract class CollectionLibrary extends AnyLibrary {

	public CollectionLibrary(LibrarySpace librarySpace) {
		super(librarySpace);
		// TODO Auto-generated constructor stub
	}
	public boolean adaptFor(Object type) {
		if(type instanceof CollectionType) return true;
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
		case "selectByKind":
			return selectByKind(self,params[0]);
		case "selectByType":
			return selectByType(self,params[0]);
		case "flatten":
			return flatten(self);
		case "createNewCollection":
			return this.createSameTypeCollection((Collection<?>) self);
		default:
			return super.execute(operation, self, params);
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
	
	public Object selectByType(Object self, Object type) {
		try {
			Collection<?> col = (Collection<?>)self;
			OclCollection result = null;
			
			result = createSameTypeCollection(col);
			
			//result.setType((EObject) super.oclType(col));
			
			EClassifier kind = (EClassifier)type;
			
			for(Object o : col) {
				
				try {
					EClassifier oKind = (EClassifier) super.oclType(o);
					if(oKind.equals(kind)) 
						result.add(o);
				} catch (Exception e) {
					continue;
				}
			}
			
			return result;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	protected OclCollection createSameTypeCollection(Collection<?> col) {
		OclCollection result;
		if(col instanceof OclSet)
			result = new OclSet();
		else if(col instanceof OclBag)
			result = new OclBag();
		else if(col instanceof OclSequence)
			result = new OclSequence();
		else if(col instanceof OclOrderedSet)
			result = new OclOrderedSet();
		else result = null;
		result.setType((EObject) super.oclType(col));
		return result;
	}
	
	public Object selectByKind(Object self, Object type) {
		try {
			Collection<?> col = (Collection<?>)self;
			OclCollection result = null;
			
			result = createSameTypeCollection(col);
			
			//result.setType((EObject) super.oclType(col));
			
			EClassifier kind = (EClassifier)type;
			
			for(Object o : col) {
				try {
					EClassifier oKind = (EClassifier) super.oclType(o);
					if(kind instanceof EClass) {
						if(((EClass) kind).isSuperTypeOf((EClass) oKind))
							result.add(o);
					} else if(oKind.equals(kind))
							result.add(o);
				} catch (Exception e) {
					continue;
				}
			}
			return result;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object flatten(Object self) {
		try {
			Collection<?> col = (Collection<?>)self;
			OclCollection result = null;
			result = createSameTypeCollection(col);
			CollectionType type = (CollectionType) super.oclType(self);
			result.setType(createFlattenType(type));
			flatten(col,result);
			return result;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	private void flatten(Collection<?> col, OclCollection result) {
		for(Object o : col) {
			if(o instanceof Collection<?>)
				flatten((Collection<?>) o, result);
			else if(o!=OclUndefined.INVALIDED)
				result.add(o);
		}
	}
	
	static public CollectionType createFlattenType(CollectionType type) {
		CollectionType result = null;
		if(type instanceof SetType)
			result = MorelFactory.eINSTANCE.createSetType();
		else if(type instanceof BagType)
			result = MorelFactory.eINSTANCE.createBagType();
		else if(type instanceof SequenceType)
			result = MorelFactory.eINSTANCE.createSequenceType();
		else if(type instanceof OrderedSetType)
			result = MorelFactory.eINSTANCE.createOrderedSetType();
		else result = null;
		
		while(type.getElementType() instanceof CollectionType) {
			type = (CollectionType) type.getElementType();
		}
		
		result.setElementType(type.getElementType());
		return result;
	}
	
	public Object including(Object self, Object obj) {
		try {
			Collection<?> col = (Collection<?>)self;
			OclCollection result = null;
			result = createSameTypeCollection(col);
			//result.setType((EObject) super.oclType(col));
			result.addAll(col);
			result.add(obj);
			return result;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object excluding(Object self, Object obj) {
		try {
			Collection<?> col = (Collection<?>)self;
			OclCollection result = null;
			result = createSameTypeCollection(col);
			//result.setType((EObject) super.oclType(col));
			
			result.addAll(col);
			
			while(result.remove(obj));
			
			return result;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	public Object prepend(Object self, Object obj) {
		try {
			Collection<?> col = (Collection<?>)self;
			OclCollection result = null;
			result = createSameTypeCollection(col);
			//result.setType((EObject) super.oclType(col));
			result.add(obj);
			result.addAll(col);
			return result;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	public Object insertAt(Object self, Object index, Object obj) {
		try {
			Collection<?> col = (Collection<?>)self;
			OclCollection result = null;
			Integer i = (Integer)obj;
			
			result = createSameTypeCollection(col);
			//result.setType((EObject) super.oclType(col));
			result.addAll(col);
			result.add(i,obj);
			return result;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	public Object subCollection(Object self, Object start, Object end) {
		try {
			Integer s = (Integer)start;
			Integer e = (Integer)end;
			List<?> col = (List<?>)self;
			OclCollection result = createSameTypeCollection(col);
			//result.setType((EObject) super.oclType(col));
			for(int i = s-1; i<e; i++)
				result.add(col.get(i));
			return result;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	public Object at(Object self, Object index) {
		try {
			Integer s = (Integer)index;
			List<?> col = (List<?>)self;
			return col.get(s);
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	public Object indexOf(Object self, Object obj) {
		try {
			List<?> col = (List<?>)self;
			return col.indexOf(obj);
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	public Object first(Object self) {
		try {
			List<?> col = (List<?>)self;
			return col.get(0);
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	public Object last(Object self) {
		try {
			List<?> col = (List<?>)self;
			return col.get(col.size()-1);
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object reverse(Object self) {
		try {
			List<?> col = (List<?>)self;
			OclCollection result = createSameTypeCollection(col);
			//result.setType((EObject) super.oclType(col));
			result.addAll(col);
			Collections.reverse(result);
			return result;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
}
