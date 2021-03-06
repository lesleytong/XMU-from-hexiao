package edu.ustb.sei.mde.emg.library;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreEList;

import edu.ustb.sei.mde.emg.runtime.datatype.OclBag;
import edu.ustb.sei.mde.emg.runtime.datatype.OclOrderedSet;
import edu.ustb.sei.mde.emg.runtime.datatype.OclSequence;
import edu.ustb.sei.mde.emg.runtime.datatype.OclSet;
import edu.ustb.sei.mde.emg.runtime.datatype.OclUndefined;
import edu.ustb.sei.mde.modeling.ui.ConsoleUtil;
import edu.ustb.sei.mde.morel.CollectionType;
import edu.ustb.sei.mde.morel.MorelFactory;
import edu.ustb.sei.mde.morel.MorelPackage;
import edu.ustb.sei.mde.morel.SequenceType;

public class AnyLibrary extends ReflectiveLibrary {

	public AnyLibrary(LibrarySpace librarySpace) {
		super(librarySpace);
		
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
			return notEqual(self,params[0]);
		case "oclType":
			return oclType(self);
		case "oclIsTypeOf":
			return oclIsTypeOf(self,params[0]);
		case "oclIsKindOf":
			return oclIsKindOf(self,params[0]);
		case "println":
			ConsoleUtil.printToConsole(self.toString(), "AnyLibrary", true);
			return true;
		default:
			return super.execute(operation, self, params);
		}
	}

	private Object oclIsKindOf(Object self, Object object) {
		try {
			EClassifier type = (EClassifier)object;
			return type.isInstance(self);
		} catch (Exception e) {
			return OclUndefined.INVALIDED;
		}
	}

	public Object oclIsTypeOf(Object self, Object object) {
		try {
			EClassifier type = (EClassifier)object;
			EClassifier sType = (EClassifier)this.oclType(self);
			return type.equals(sType);
		} catch (Exception e) {
			return false;
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
	
	static private HashMap<EStructuralFeature, CollectionType> ecoreListType = new HashMap<EStructuralFeature, CollectionType>();
	static final private CollectionType defaultCollectionType;
	static {
		defaultCollectionType = MorelFactory.eINSTANCE.createSequenceType();
		defaultCollectionType.setElementType(EcorePackage.eINSTANCE.getEJavaObject());
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
		} else if(self instanceof OclOrderedSet) {
			return ((OclOrderedSet) self).getType();
		} else if(self instanceof OclSet) {
			return ((OclSet) self).getType();
		} else if(self instanceof OclBag) {
			return ((OclBag) self).getType();
		} else if(self instanceof OclSequence) {
			return ((OclSequence) self).getType();
		} else if(self instanceof List) {
			if(self instanceof EStructuralFeature.Setting) {
				EStructuralFeature feature = ((EStructuralFeature.Setting) self).getEStructuralFeature();
				CollectionType type = ecoreListType.get(feature);
				
				if(type==null) {
					if(feature.isUnique() && feature.isOrdered())
						type = MorelFactory.eINSTANCE.createOrderedSetType();
					else if(!feature.isUnique() && feature.isOrdered())
						type = MorelFactory.eINSTANCE.createSequenceType();
					else if(feature.isUnique() && !feature.isOrdered())
						type = MorelFactory.eINSTANCE.createSetType();
					else if(!feature.isUnique() && !feature.isOrdered())
						type = MorelFactory.eINSTANCE.createBagType();
					type.setElementType(feature.getEType());
					
					ecoreListType.put(feature, type);
				}
				return type;
			} else {
				return defaultCollectionType;
			}
		}
		else if(self instanceof EObject){
			return ((EObject)self).eClass();
		} else if(self instanceof IModuleProvider)
			return IModuleProvider.class;
		else 
			return EcorePackage.eINSTANCE.getEJavaObject();//OclAny
	}
}
