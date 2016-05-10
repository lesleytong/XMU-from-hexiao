/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.analysis;

public class Xmu2QUOTED_60_62_92TokenResolver implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver {
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultTokenResolver defaultTokenResolver = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultTokenResolver(true);
	
	public String deResolve(Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		// By default token de-resolving is delegated to the DefaultTokenResolver.
		String result = defaultTokenResolver.deResolve(value, feature, container, "<", ">", "\\");
		return result;
	}
	
	public void resolve(String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult result) {
		// By default token resolving is delegated to the DefaultTokenResolver.
		defaultTokenResolver.resolve(lexem, feature, result, "<", ">", "\\");
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
