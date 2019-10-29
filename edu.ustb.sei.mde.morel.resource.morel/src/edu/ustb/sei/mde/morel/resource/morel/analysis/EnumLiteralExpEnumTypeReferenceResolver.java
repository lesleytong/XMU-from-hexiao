/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.analysis;

import org.eclipse.emf.ecore.EEnum;

public class EnumLiteralExpEnumTypeReferenceResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.EnumLiteralExp, org.eclipse.emf.ecore.EEnum> {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.EnumLiteralExp, org.eclipse.emf.ecore.EEnum> delegate = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.EnumLiteralExp, org.eclipse.emf.ecore.EEnum>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.morel.EnumLiteralExp container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<org.eclipse.emf.ecore.EEnum> result) {
		try {
			EEnum type = (EEnum)TypeResolver.resolveClassifier(identifier, container);
			if(type!=null)
				result.addMapping(identifier, (EEnum)type);
		} catch (Exception e) {
			return;
		}
		
		//delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EEnum element, edu.ustb.sei.mde.morel.EnumLiteralExp container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
