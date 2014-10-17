/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.analysis;

public class ReflectiveVariableExpVariableReferenceResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.ReflectiveVariableExp, edu.ustb.sei.mde.morel.Variable> {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.ReflectiveVariableExp, edu.ustb.sei.mde.morel.Variable> delegate = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.ReflectiveVariableExp, edu.ustb.sei.mde.morel.Variable>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.morel.ReflectiveVariableExp container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<edu.ustb.sei.mde.morel.Variable> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(edu.ustb.sei.mde.morel.Variable element, edu.ustb.sei.mde.morel.ReflectiveVariableExp container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
