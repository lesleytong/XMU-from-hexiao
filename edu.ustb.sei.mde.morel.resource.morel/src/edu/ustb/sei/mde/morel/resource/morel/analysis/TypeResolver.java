package edu.ustb.sei.mde.morel.resource.morel.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ustb.sei.mde.morel.CollectionType;
import edu.ustb.sei.mde.morel.MorelPackage;
import edu.ustb.sei.mde.morel.TypedModel;
import edu.ustb.sei.mde.morel.Unit;

public class TypeResolver {
	static public EClassifier resolve(String type, EObject obj) {
		Unit unit = getUnit(obj);
		EList<EDataType> types = unit.getDataTypes();
		
		if(type.startsWith("OrderedSet")){
			EClassifier result = checkExists(type,types);
			if(result!=null) return result;
			String elementType = type.substring(10,type.length()-1);
			EClassifier et = resolve(elementType, obj);
			CollectionType t = (CollectionType) EcoreUtil.create(MorelPackage.eINSTANCE.getOrderedSetType());
			t.setElementType(et);
			t.setName(type);
			types.add(t);
			return t;
		} else if(type.startsWith("Sequence")) {
			EClassifier result = checkExists(type,types);
			if(result!=null) return result;
			String elementType = type.substring(8,type.length()-1);
			EClassifier et = resolve(elementType, obj);
			CollectionType t = (CollectionType) EcoreUtil.create(MorelPackage.eINSTANCE.getSequenceType());
			t.setElementType(et);
			t.setName(type);
			types.add(t);
			return t;
		} else if(type.startsWith("Set")) {
			EClassifier result = checkExists(type,types);
			if(result!=null) return result;
			String elementType = type.substring(3,type.length()-1);
			EClassifier et = resolve(elementType, obj);
			CollectionType t = (CollectionType) EcoreUtil.create(MorelPackage.eINSTANCE.getSetType());
			t.setElementType(et);
			t.setName(type);
			types.add(t);
			return t;
		} else if(type.startsWith("Bag")) {
			EClassifier result = checkExists(type,types);
			if(result!=null) return result;
			String elementType = type.substring(3,type.length()-1);
			EClassifier et = resolve(elementType, obj);
			CollectionType t = (CollectionType) EcoreUtil.create(MorelPackage.eINSTANCE.getBagType());
			t.setElementType(et);
			t.setName(type);
			types.add(t);
			return t;
		} else if("String".equals(type))
			return (org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEString());
		else if("Integer".equals(type))
			return (org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEIntegerObject());
		else if("Real".equals(type))
			return (org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEDoubleObject());
		else if("Boolean".equals(type))
			return (org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEBooleanObject());
		else if("Char".equals(type))
			return (org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getECharacterObject());
		else if("Any".equals(type))
			return (org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEJavaObject());
		else {
			return resolveClassType(type, unit);
		}
	}

	static private EDataType checkExists(String type, EList<EDataType> types) {
		for(EDataType t : types) {
			if(type.equals(t.getName()))
				return t;
		}
		return null;
	}
	
	static public String deResolve(EClassifier element) {
		if(element==org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEString()) return "String";
		else if(element==org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEIntegerObject()) return "Integer";
		else if(element==org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEDoubleObject()) return "Real";
		else if(element==org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEBooleanObject()) return "Boolean";
		else if(element==org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getECharacterObject()) return "Char";
		else if(element==org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEJavaObject()) return "Any";
		else return element.getName();
	}

	static private Unit getUnit(EObject container) {
		while(container instanceof EObject) {
			if(container instanceof Unit) {
				return (Unit) container;
			}
			container = container.eContainer();
		}
		return null;
	}
	
	static private EClass resolveClassType(String type, Unit unit) {
		int sep = type.indexOf('!');
		if(sep!=-1) {
			String modelName = type.substring(0, sep);
			String typeName = type.substring(sep+1);
			
			for(TypedModel m : unit.getModels()) {
				if(m.getName().equals(modelName)) {
					TreeIterator<EObject> it = m.getPackage().eAllContents();
					while(it.hasNext()) {
						EObject o = it.next();
						if(o instanceof EClass) {
							if(((EClass) o).getName().equals(typeName))
								return (EClass) o;
						}
					}
				}
			}
		} else {
			for(TypedModel m : unit.getModels()) {
				TreeIterator<EObject> it = m.getPackage().eAllContents();
				while(it.hasNext()) {
					EObject o = it.next();
					if(o instanceof EClass) {
						if(((EClass) o).getName().equals(type))
							return (EClass) o;
					}
				}
			}
		
		}
		return null;
	}
}
