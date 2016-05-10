package edu.ustb.sei.mde.xmu2.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.mde.xmu2.datatypes.DatatypesPackage;
import edu.ustb.sei.mde.xmu2.runtime.values.SafeType;

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
	
	final static public Object[] EMPTYARRAY = new Object[0];
	public static final EClass RESOURCE = DatatypesPackage.eINSTANCE.getResource();
}
