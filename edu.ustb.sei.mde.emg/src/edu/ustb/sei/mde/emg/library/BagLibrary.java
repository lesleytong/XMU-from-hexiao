package edu.ustb.sei.mde.emg.library;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.emg.runtime.datatype.OclCollection;
import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;
import edu.ustb.sei.mde.morel.BagType;

public class BagLibrary extends CollectionLibrary {

	public BagLibrary(LibrarySpace librarySpace) {
		super(librarySpace);
		
	}

	@Override
	public boolean adaptFor(Object type) {
		return type instanceof BagType;
	}

	@Override
	public Object execute(String operation, Object self, Object... params) {
		switch(operation) {
		case "union":
			return union(self,params[0]);
		case "intersection":
			return intersection(self,params[0]);
		case "including":
			return including(self,params[0]);
		case "excluding":
			return excluding(self,params[0]);
		default:
			return super.execute(operation, self, params);
		}
	}
	
	public Object equal(Object self, Object right) {
		try {
			if(self==null && right==null) return true;
			else if(self==OclUndefined.INVALIDED || right==OclUndefined.INVALIDED) return OclUndefined.INVALIDED;
			else if(self==null || right==null) return false;
			else {
				Collection<?> col = (Collection<?>)self;
				Collection<?> rightCol = (Collection<?>)right;

				if(col.containsAll(rightCol)&&rightCol.containsAll(col)) {
					for(Object o : col) {
						if(super.count(col, o)!=super.count(rightCol, o)) return false;;
					}
					return true;
				} else return false;
				
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public Object union(Object self, Object right) {
		try {
			OclCollection result = super.createSameTypeCollection((Collection<?>) self);
			//result.setType((EObject) super.oclType(self));
			
			result.addAll((Collection<?>) self);
			result.addAll((Collection<?>) right);
			return result;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}

	public Object intersection(Object self, Object right) {
		try {
			Collection<?> col = (Collection<?>)self;
			Collection<?> rightCol = (Collection<?>)right;
			OclCollection result = super.createSameTypeCollection(rightCol);
			//result.setType((EObject) super.oclType(right));
			
			result.addAll((Collection<?>) self);
			
			result.addAll(col);
			result.retainAll(rightCol);
			
			return result;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
}
