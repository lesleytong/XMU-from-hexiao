package edu.ustb.sei.mde.emg.library;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.emg.runtime.datatype.OclCollection;
import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;
import edu.ustb.sei.mde.morel.CollectionType;
import edu.ustb.sei.mde.morel.SetType;

public class SetLibrary extends CollectionLibrary {

	public SetLibrary(LibrarySpace librarySpace) {
		super(librarySpace);
		
	}

	@Override
	public boolean adaptFor(Object type) {
		return type instanceof SetType;
	}

	@Override
	public Object execute(String operation, Object self, Object... params) {
		
		switch(operation){
		case "union":
			return union(self,params[0]);
		case "intersection":
			return intersection(self,params[0]);
		case "-":
			return removeAll(self,params[0]);
		case "including":
			return including(self,params[0]);
		case "excluding":
			return excluding(self,params[0]);
		}
		return super.execute(operation, self, params);
	}


	public Object union(Object self, Object right) {
		try {
			OclCollection result = super.createSameTypeCollection((Collection<?>) right);
			//result.setType((EObject) super.oclType(right));
			
			result.addAll((Collection<?>) self);
			result.addAll((Collection<?>) right);
			return result;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
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
				return (col.containsAll(rightCol)&&rightCol.containsAll(col));
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public Object intersection(Object self, Object right) {
		try {
			Collection<?> col = (Collection<?>)self;
			Collection<?> rightCol = (Collection<?>)right;
			OclCollection result = super.createSameTypeCollection(col);
			//result.setType((EObject) super.oclType(col));
			
			result.addAll((Collection<?>) self);
			
			result.addAll(col);
			result.retainAll(rightCol);
			
			return result;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object removeAll(Object self, Object right) {
		try {
			Collection<?> col = (Collection<?>)self;
			Collection<?> rightCol = (Collection<?>)right;
			OclCollection result = super.createSameTypeCollection(col);
			//result.setType((EObject) super.oclType(col));
			
			result.addAll((Collection<?>) self);
			result.removeAll(rightCol);
			
			return result;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
}
