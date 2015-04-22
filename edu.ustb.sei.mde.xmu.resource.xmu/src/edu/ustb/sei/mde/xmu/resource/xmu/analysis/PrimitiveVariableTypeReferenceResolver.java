/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcorePackage;

public class PrimitiveVariableTypeReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.PrimitiveVariable, org.eclipse.emf.ecore.EDataType> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.PrimitiveVariable, org.eclipse.emf.ecore.EDataType> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.PrimitiveVariable, org.eclipse.emf.ecore.EDataType>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.PrimitiveVariable container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<org.eclipse.emf.ecore.EDataType> result) {
		if(identifier==null) return;
		EDataType cls = Util.getPrimitiveDataType(identifier);
		if(cls==null) return;
		
		result.addMapping(identifier, cls);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EDataType element, edu.ustb.sei.mde.xmu.PrimitiveVariable container, org.eclipse.emf.ecore.EReference reference) {
		//return delegate.deResolve(element, container, reference);
		
		if(element==EcorePackage.eINSTANCE.getEBooleanObject()) return "Boolean";
		else if(element == EcorePackage.eINSTANCE.getEIntegerObject()) return "Integer";
		else if(element == EcorePackage.eINSTANCE.getEString()) return "String";
		else return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
