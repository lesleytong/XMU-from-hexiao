package edu.ustb.sei.mde.xmu2.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.mde.xmu2.datatypes.DatatypesPackage;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;
import edu.ustb.sei.mde.xmu2common.Xmu2commonPackage;

final public class Constants {
	final static public SafeType TRUE = SafeType.TRUE;
	final static public SafeType FALSE = SafeType.FALSE;
	final static public SafeType NULL = SafeType.NULL;
	final static public SafeType UNDEFINED = SafeType.UNDEFINED;
	final static public String POST = "@post";
	
	final static public EDataType INT = EcorePackage.eINSTANCE.getEInt();
	final static public EDataType BOOLEAN = EcorePackage.eINSTANCE.getEBoolean();
	final static public EDataType STRING = EcorePackage.eINSTANCE.getEString();
	final static public EDataType OCLANY = EcorePackage.eINSTANCE.getEJavaObject(); 
	final static public EClass EOBJECT = EcorePackage.eINSTANCE.getEObject();
	public static final EClass RESOURCE = DatatypesPackage.eINSTANCE.getResource();
	public static final EClass REFLECTIVE_OBJECT = Xmu2commonPackage.eINSTANCE.getReflectiveObject();
	
	public static final String BOOLEAN_NAME = "Boolean";
	public static final String INTEGER_NAME = "Integer";
	public static final String STRING_NAME = "String";
	public static final String OCLANY_NAME = "OclAny";
	public static final String RESOURCE_NAME = "Resource";
	public static final String OCLOBJECT_NAME = "OclObject";
	
	final static public Object[] EMPTYARRAY = new Object[0];
}
