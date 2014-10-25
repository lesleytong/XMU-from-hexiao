/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.analysis;

import org.eclipse.emf.ecore.EEnumLiteral;

public class EnumLiteralExpEnumSymbolReferenceResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.EnumLiteralExp, org.eclipse.emf.ecore.EEnumLiteral> {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.EnumLiteralExp, org.eclipse.emf.ecore.EEnumLiteral> delegate = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.EnumLiteralExp, org.eclipse.emf.ecore.EEnumLiteral>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.morel.EnumLiteralExp container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<org.eclipse.emf.ecore.EEnumLiteral> result) {
		if(container.getEnumType()==null) {
			return;
		} else {
			if(resolveFuzzy) {
				for(EEnumLiteral lit : container.getEnumType().getELiterals()){
					result.addMapping(lit.getLiteral(), lit);
				}
			} else {
				EEnumLiteral literal = container.getEnumType().getEEnumLiteral(identifier);
				if(literal!=null)
					result.addMapping(identifier, literal);
			}
		}
//		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EEnumLiteral element, edu.ustb.sei.mde.morel.EnumLiteralExp container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
