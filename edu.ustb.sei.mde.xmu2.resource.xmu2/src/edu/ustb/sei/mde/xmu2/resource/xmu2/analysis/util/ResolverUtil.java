package edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.util;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import edu.ustb.sei.mde.xmu2.util.AnalysisUtil;
import edu.ustb.sei.mde.xmu2.util.Constants;


public class ResolverUtil {
	final static String[] reservedWords = new String[]{
			Constants.BOOLEAN_NAME,Constants.INTEGER_NAME,Constants.STRING_NAME,Constants.OCLANY_NAME,Constants.RESOURCE_NAME,Constants.OCLOBJECT_NAME,
			"update","enforce","delete","with","by","switch","case","otherwise","match","unmatchs","unmatchv",
			"source","view","entry","module","import","rule","function","select","forAll","exists","first","last",
			"at","null","undefined","not","skip","foreach","default"
			};
	
	static public EObject getAncestor(EObject obj, EClass type) {
		while(obj!=null) {
			if(obj.eClass().equals(type)) break;
			obj = obj.eContainer();
		}
		return obj;
	}
	static public EClassifier getClassifier(String identifier, EPackage pkg) {
		TreeIterator<EObject> it = pkg.eAllContents();
		while(it.hasNext()) {
			EObject o = it.next();
			if(o instanceof EClassifier) {
				if(identifierMatch(identifier, ((EClassifier)o).getName()))
					return (EClassifier) o;
			}
		}
		return null;
	}
	
	static public EStructuralFeature getFeature(String identifier, EClass cls) {
		EClass ro = Constants.REFLECTIVE_OBJECT;
		
		for(EStructuralFeature f : ro.getEAllStructuralFeatures()) {
			if(identifierMatch(identifier, f.getName()))
				return f;
		}
		
		for(EStructuralFeature f : cls.getEAllStructuralFeatures()) {
			if(identifierMatch(identifier, f.getName()))
				return f;
		}
		return null;
	}
	
	static public EDataType getPrimitiveDataType(String identifier) {
		for(int i = 0; i < primitiveTypeNames.length ; i++) {
			if(primitiveTypeNames[i].equals(identifier))
				return primitiveTypes[i];
		}
		return null;
		
//		if(Constants.STRING_NAME.equals(identifier))
//			return Constants.STRING;
//		else if(Constants.INTEGER_NAME.equals(identifier))
//			return Constants.INT;
//		else if(Constants.BOOLEAN_NAME.equals(identifier))
//			return Constants.BOOLEAN;
//		else if(Constants.OCLANY_NAME.equals(identifier))
//			return Constants.OCLANY;
//		else return null;
	}
	
	static public EEnum getEnum(String identifier, EList<EPackage> packages) {
		for(EPackage pkg : packages) {
			EEnum cls = getEnum(identifier, pkg);
			if(cls !=null ) return cls;
		}
		return null;
	}
	
	static public Object getEnumLiteral(String identifier, EEnum e) {
		return EcoreFactory.eINSTANCE.createFromString(e, identifier);
	}
	
	static public EEnum getEnum(String identifier, EPackage pkg) {
		TreeIterator<EObject> it = pkg.eAllContents();
		while(it.hasNext()) {
			EObject o = it.next();
			if(o instanceof EEnum) {
				if(identifierMatch(identifier, ((EEnum)o).getName()))
					return (EEnum) o;
			}
		}
		return null;
	}

	public static EClassifier getEClassifier(
			String identifier, EList<EPackage> packages) {
		int indexOf = identifier.indexOf("!");
		if(indexOf==-1) {
			for(EPackage pkg : packages) {
				EClassifier cls = getClassifier(identifier, pkg);
				if(cls !=null ) return cls;
			}		
		} else {
			String[] buf = identifier.split("!");
			for(EPackage pkg : packages) {
				if(pkg.eIsProxy()==false && pkg.getName().equals(buf[0]))
					return getClassifier(buf[1],pkg);
			}
		}
		return null;
	}
	
	static public boolean identifierMatch(String identifier, String str) {
		if(identifier.equals(str)) return true;
		if(identifier.length()==0) return false;
		if(identifier.charAt(0)=='_') {
			if(identifier.substring(1).equals(str))
				return true;
		}
		return false;
	}
	
	static public boolean identifierMatchFuzzy(String identifier, String str) {
		if(str.startsWith(identifier)) return true;
		if(identifier.length()==0) return true;
		if(identifier.charAt(0)=='_') {
			if(str.startsWith(identifier.substring(1)))
				return true;
		}
		return false;
	}
	
	static public EPackage loadPackage(String uri, Resource resource) {
		try {
			ResourceSet set = resource.getResourceSet();
			
			Map<String, URI> map = EcorePlugin.getEPackageNsURIToGenModelLocationMap(false);
			for(Entry<String,URI> uriEntry : map.entrySet()) {
				if(uriEntry.getKey().indexOf(uri)!=-1) {	
					if(uri.equals(uriEntry.getKey())) {
						URI u = URI.createURI(uriEntry.getKey());
						Resource res = set.getResource(u, true);
						EObject target = res.getContents().get(0);
						return (EPackage) target;
					}
				}
			}
			
			URI u = URI.createURI(uri);
			
			if(u.isRelative())
				u = u.resolve(resource.getURI());
			
			Resource res = set.getResource(u, true);
			EObject target = res.getContents().get(0);
			return (EPackage)target;
			
		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	static public String keywordSafeString(String str) {
		for(String s : reservedWords) {
			if(s.equals(str))
				return "_"+str;
		}
		return str;
	}
	
	
	
	public static String getPrimitiveDataTypeName(EClassifier element) {
		for(int i = 0 ; i< primitiveTypes.length ; i++) {
			if(element==primitiveTypes[i])
				return primitiveTypeNames[i];
		}
		return null;
//		
//		if(AnalysisUtil.isType(element, String.class))
//			return Constants.STRING_NAME;
//		else if(AnalysisUtil.isType(element, int.class))
//			return Constants.INTEGER_NAME;
//		else if(AnalysisUtil.isType(element, boolean.class))
//			return Constants.BOOLEAN_NAME;
//		else if(AnalysisUtil.isType(element, Object.class))
//			return Constants.OCLANY_NAME;
//		return null;
	}
	

	
	
	public static EClassifier getReservedType(String identifier) {
		for(int i = 0; i < reservedTypeNames.length; i++) {
			if(reservedTypeNames[i].equals(identifier))
				return reservedTypes[i];
		}
		return null;
	}
	public static boolean isReservedType(EClassifier element) {
		for(int i = 0; i < reservedTypes.length ; i ++) {
			if(element==reservedTypes[i])
				return true;
		}
		return false;
	}
	public static String getReservedTypeName(EClassifier element) {
		for(int i = 0; i < reservedTypes.length ; i ++) {
			if(element==reservedTypes[i])
				return reservedTypeNames[i];
		}
		return null;
	}
	
	final static public String[] primitiveTypeNames = new String[]{Constants.STRING_NAME,Constants.BOOLEAN_NAME,Constants.INTEGER_NAME,Constants.OCLANY_NAME};
	final static public EDataType[] primitiveTypes = new EDataType[]{Constants.STRING,Constants.BOOLEAN,Constants.INT,Constants.OCLANY};
	
	final static public String[] reservedTypeNames = new String[]{Constants.RESOURCE_NAME,Constants.OCLOBJECT_NAME};
	final static public EClassifier[] reservedTypes = new EClassifier[]{Constants.RESOURCE,Constants.EOBJECT};

}
