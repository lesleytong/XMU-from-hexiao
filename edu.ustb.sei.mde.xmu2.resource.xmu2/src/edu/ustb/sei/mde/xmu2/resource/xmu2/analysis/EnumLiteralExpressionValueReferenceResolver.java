/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.analysis;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;

import edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.util.ResolverUtil;

public class EnumLiteralExpressionValueReferenceResolver implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression, org.eclipse.emf.ecore.EEnumLiteral> {
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression, org.eclipse.emf.ecore.EEnumLiteral> delegate = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression, org.eclipse.emf.ecore.EEnumLiteral>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolveResult<org.eclipse.emf.ecore.EEnumLiteral> result) {
		if(container==null) return;
		EEnum e = container.getType();
		if(e==null) return;
		
		if(resolveFuzzy) {
			for(EEnumLiteral l : e.getELiterals()) {
				if(ResolverUtil.identifierMatchFuzzy(identifier, l.getName())) {
					result.addMapping(ResolverUtil.keywordSafeString(l.getName()), l);
				}
			}
			return;
		} else {
//			EEnumLiteral l = ResolverUtil.getEnumLiteral(identifier, e);
			
			for(EEnumLiteral l : e.getELiterals()) {
				if(ResolverUtil.identifierMatch(identifier, l.getName())) {
					result.addMapping(identifier, l);
					return;
				}
			}		
		}
//		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EEnumLiteral element, edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression container, org.eclipse.emf.ecore.EReference reference) {
		return ResolverUtil.keywordSafeString(element.getName());
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
