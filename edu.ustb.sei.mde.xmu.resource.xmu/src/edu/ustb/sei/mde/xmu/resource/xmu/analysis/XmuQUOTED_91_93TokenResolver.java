/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

public class XmuQUOTED_91_93TokenResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultTokenResolver defaultTokenResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "[", "]", null);
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "[", "]", null);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
