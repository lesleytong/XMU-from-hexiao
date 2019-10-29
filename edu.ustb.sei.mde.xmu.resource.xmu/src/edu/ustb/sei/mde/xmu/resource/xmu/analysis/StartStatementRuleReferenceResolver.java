/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

public class StartStatementRuleReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.StartStatement, edu.ustb.sei.mde.xmu.Rule> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.StartStatement, edu.ustb.sei.mde.xmu.Rule> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.StartStatement, edu.ustb.sei.mde.xmu.Rule>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.StartStatement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<edu.ustb.sei.mde.xmu.Rule> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(edu.ustb.sei.mde.xmu.Rule element, edu.ustb.sei.mde.xmu.StartStatement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
