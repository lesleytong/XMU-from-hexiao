package edu.ustb.sei.mde.emg.library;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.mde.emg.runtime.datatype.Bag;
import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;
import edu.ustb.sei.mde.morel.MorelPackage;

public class AnyLibrary extends Library {

	public AnyLibrary(LibrarySpace librarySpace) {
		super(librarySpace);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean adaptFor(Object type) {
		return true;
	}

	@Override
	public Object execute(String operation, Object self, Object... params) {
		switch(operation) {
		case "=":
			return equal(self,params[0]);
		case "<>":
			return equal(self,params[0]);
		default:
			throw new UnsupportedOperationException(operation);
		}
	}

	public Object equal(Object self, Object right){
		if(self==null && right==null) return true;
		else if(self==OclUndefined.INVALIDED || right==OclUndefined.INVALIDED) return OclUndefined.INVALIDED;
		else if(self==null || right==null) return false;
		else return self.equals(right);
	}
	
	public Object notEqual(Object self, Object right){
		try {
			boolean ret = (Boolean)(equal(self,right));
			return !ret;
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}
	
	public Object oclType(Object self) {
		if(self==null) {
			return OclUndefined.INVALIDED;
		} else if(self==OclUndefined.INVALIDED) {
			return OclUndefined.INVALIDED;
		} else if(self instanceof String) {
			return EcorePackage.eINSTANCE.getEString();
		} else if(self instanceof Integer) {
			return EcorePackage.eINSTANCE.getEIntegerObject();
		} else if(self instanceof Double) {
			return EcorePackage.eINSTANCE.getEDoubleObject();
		} else if(self instanceof Boolean) {
			return EcorePackage.eINSTANCE.getEBooleanObject();
		} else if(self instanceof UniqueEList) {
			return MorelPackage.eINSTANCE.getOrderedSetType();
		} else if(self instanceof Set) {
			return MorelPackage.eINSTANCE.getSetType();
		} else if(self instanceof Bag) {
			return MorelPackage.eINSTANCE.getBagType();
		} else if(self instanceof List) {
			return MorelPackage.eINSTANCE.getSequenceType();
		} else if(self instanceof EObject){
			return ((EObject)self).eClass();
		} else 
			return EcorePackage.eINSTANCE.getEJavaObject();//OclAny
	}
}
