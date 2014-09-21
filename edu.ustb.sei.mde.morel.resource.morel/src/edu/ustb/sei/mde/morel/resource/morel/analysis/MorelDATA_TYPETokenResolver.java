/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.analysis;

public class MorelDATA_TYPETokenResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultTokenResolver defaultTokenResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, null, null, null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, null, null, null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
