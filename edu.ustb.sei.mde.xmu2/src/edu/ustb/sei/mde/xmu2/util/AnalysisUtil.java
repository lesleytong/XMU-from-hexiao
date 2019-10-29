package edu.ustb.sei.mde.xmu2.util;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.ustb.sei.mde.xmu2.Xmu2Package;
import edu.ustb.sei.mde.xmu2.datatypes.DatatypesPackage;
import edu.ustb.sei.mde.xmu2.datatypes.OclCollection;
import edu.ustb.sei.mde.xmu2.expression.ExpressionPackage;
import edu.ustb.sei.mde.xmu2.pattern.PatternPackage;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;
import edu.ustb.sei.mde.xmu2.statement.StatementPackage;
import edu.ustb.sei.mde.xmu2core.OclCollectionType;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

final public class AnalysisUtil {

	static public EObject getAncestor(EObject obj, EClass type) {
		while(obj!=null) {
			if(obj.eClass().equals(type)) break;
			obj = obj.eContainer();
		}
		return obj;
	}
	
	final static public String XMU_EXTENSION = "xmu2";
	final static public String CORE_EXTENSION = "xmu2core";
	
	static public void initializeResourceSet(ResourceSet res) {
		res.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
			    Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		res.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				CORE_EXTENSION, new XMIResourceFactoryImpl());
		
		res.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		res.getPackageRegistry().put(Xmu2Package.eNS_URI, Xmu2Package.eINSTANCE);
		res.getPackageRegistry().put(Xmu2corePackage.eNS_URI, Xmu2corePackage.eINSTANCE);
		
		res.getPackageRegistry().put(PatternPackage.eNS_URI, PatternPackage.eINSTANCE);
		res.getPackageRegistry().put(StatementPackage.eNS_URI, StatementPackage.eINSTANCE);
		res.getPackageRegistry().put(ExpressionPackage.eNS_URI, ExpressionPackage.eINSTANCE);
		res.getPackageRegistry().put(DatatypesPackage.eNS_URI, DatatypesPackage.eINSTANCE);
	}
	
	static public Resource loadOrCreateResource(ResourceSet resSet, URI uri, boolean create) {
		Resource res = null;
		try{
		  res = resSet.getResource(uri, true);
		} catch(Exception e) {
			res = null;
		}
		if(res==null && create)
			res = resSet.createResource(uri);
		return res;
	}

	public static boolean isValidNonUpdatedSourceVariableName(String name) {
		return !name.endsWith(Constants.POST);
	}
	
	static public String getUpdatedSourceVariableName(String name) {
		if(name.endsWith(Constants.POST)) return name;
		else return name+Constants.POST;
	}
	
	static public String getNonUpdatedSourceVariableName(String name) {
		if(name.endsWith(Constants.POST))
			return name.substring(0,name.length() - Constants.POST.length());
		else return name;
	}
	
	@Deprecated
	static protected boolean isCompatible(EClassifier typeA, EClassifier typeB) {
		if(typeA==Constants.OCLANY)
			return true;
		
		if(typeA instanceof EClass) {
			if(typeB instanceof EClass) {
				return ((EClass) typeA).isSuperTypeOf((EClass)typeB);
			} else {
				return false;
			}
		} else {
			if(typeB instanceof EClass) {
				if(typeA==Constants.STRING)
					return true;
				else return false;
			} else {
				if(typeA==Constants.BOOLEAN) {
					if(typeB==Constants.BOOLEAN )
						return true;
					else return false;
				} else if(typeA==Constants.INT) {
					if(typeB==Constants.INT)
						return true;
					else return false;
				} else if(typeA==Constants.STRING) {
					return true;
				}
				else return false;
			}
		}
		
	}
	
	@Deprecated
	static public boolean isCompatible(EClassifier type, SafeType value) {
		if(type==Constants.OCLANY
				|| value==Constants.NULL 
				|| value==Constants.UNDEFINED)
			return true;
		else {
			
			Object v = value.getValue();
			
			if(type instanceof OclCollectionType) {
				if(v instanceof OclCollection) {
					return true;//FIXME: I should check the element type. but v does not record its element type now
				} else 
					return false;
			} else if(type instanceof EClass){
				if(v instanceof EObject) {
					return ((EClass) type).isSuperTypeOf(((EObject) v).eClass());
				} else
					return false;
			} else if(type instanceof EDataType) {
				return isTypeOf(value, (EDataType)type);
			}
			return false;
		}
	}
	
	static public boolean isType(EClassifier cls, Class<?> t) {
		Class<?> c = cls.getInstanceClass();
		
		if(c==t) return true;
		
		if(t==int.class) {
			return c==Integer.class;
		} else if(t==boolean.class) {
			return c==Boolean.class;
		} else if(t==double.class) {
			return c==Double.class;
		} else if(t==float.class) {
			return c==Float.class;
		} else if(t==long.class) {
			return c==Long.class;
		} else if(t==short.class) {
			return c==Short.class;
		} else if(t==byte.class) {
			return c==Byte.class;
		} else if(t==char.class) {
			return c==Character.class;
		} else if(t==Enumerator.class) {
			return true;
		}
		return false;
	}
	
	static public boolean isTypeOf(SafeType value, EDataType type) {
		Object v = value.getValue();
		
		if(v==null) return true;
		Class<?> cls = type.getInstanceClass();
		if(v instanceof Integer) {
			return cls==int.class || cls==Integer.class;
		} else if(v instanceof Boolean) {
			return cls==boolean.class || cls==Boolean.class;
		} else if(v instanceof Double) {
			return cls==double.class || cls==Double.class;
		} else if(v instanceof Float) {
			return cls==float.class || cls==Float.class;
		} else if(v instanceof Long) {
			return cls==long.class || cls==Long.class;
		} else if(v instanceof Short) {
			return cls==short.class || cls==Short.class;
		} else if(v instanceof Byte) {
			return cls==byte.class || cls==Byte.class;
		} else if(v instanceof Character) {
			return cls==char.class || cls==Character.class;
		} else if(v instanceof String) {
			return cls==String.class;
		} else if(value instanceof Enumerator) {
			return true;
		}
		return false;
	}
	
	static public boolean isSuperTypeOf(EClassifier parent, EClassifier child) {
		if(parent==Constants.OCLANY || child==Constants.REFLECTIVE_OBJECT) return true;
		else if(parent==Constants.EOBJECT || parent == Constants.REFLECTIVE_OBJECT) {
			return child instanceof EClass;
		} else {
			if(parent instanceof EClass && child instanceof EClass)
				return ((EClass)parent).isSuperTypeOf(((EClass)child));
			else if(parent instanceof EEnum && child instanceof EEnum) {
				return parent == child;
			} else if(parent instanceof EDataType && child instanceof EDataType) {
				//FIXME: type checking of primitve types should be enhanced
				return true;
			} else 
				return false;
		}
	}
}