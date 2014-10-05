/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.analysis;

import org.eclipse.emf.ecore.EClassifier;

public class TypeLiteralExpValueReferenceResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.TypeLiteralExp, org.eclipse.emf.ecore.EClassifier> {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.TypeLiteralExp, org.eclipse.emf.ecore.EClassifier> delegate = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.TypeLiteralExp, org.eclipse.emf.ecore.EClassifier>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.morel.TypeLiteralExp container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<org.eclipse.emf.ecore.EClassifier> result) {
		EClassifier type = TypeResolver.resolve(identifier, container);
		if(type==null) return;
		result.addMapping(identifier, type);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EClassifier element, edu.ustb.sei.mde.morel.TypeLiteralExp container, org.eclipse.emf.ecore.EReference reference) {
		return TypeResolver.deResolve(element);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
