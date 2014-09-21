/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.analysis;

import org.eclipse.emf.ecore.EDataType;

public class PrimitiveVariableTypeReferenceResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.PrimitiveVariable, org.eclipse.emf.ecore.EDataType> {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.PrimitiveVariable, org.eclipse.emf.ecore.EDataType> delegate = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.PrimitiveVariable, org.eclipse.emf.ecore.EDataType>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.morel.PrimitiveVariable container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<org.eclipse.emf.ecore.EDataType> result) {
		EDataType type = (EDataType) TypeResolver.resolve(identifier, container);
		if(type==null) return;
		result.addMapping(identifier, type);
		//delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EDataType element, edu.ustb.sei.mde.morel.PrimitiveVariable container, org.eclipse.emf.ecore.EReference reference) {
		//return delegate.deResolve(element, container, reference);
		return TypeResolver.deResolve(element);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
