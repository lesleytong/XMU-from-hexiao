/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.analysis;

public class TypedModelPackageReferenceResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.TypedModel, org.eclipse.emf.ecore.EPackage> {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.TypedModel, org.eclipse.emf.ecore.EPackage> delegate = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.TypedModel, org.eclipse.emf.ecore.EPackage>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.morel.TypedModel container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<org.eclipse.emf.ecore.EPackage> result) {
		String uri = identifier.substring(1, identifier.length()-1);
		delegate.resolve(uri, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EPackage element, edu.ustb.sei.mde.morel.TypedModel container, org.eclipse.emf.ecore.EReference reference) {
		return "<"+element.getNsURI()+">";
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
