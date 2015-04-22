/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

import edu.ustb.sei.mde.xmu.ObjectVariable;
import edu.ustb.sei.mde.xmu.Rule;
import edu.ustb.sei.mde.xmu.Variable;

public class UpdatedStatementVVarReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.UpdatedStatement, edu.ustb.sei.mde.xmu.ObjectVariable> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.UpdatedStatement, edu.ustb.sei.mde.xmu.ObjectVariable> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.UpdatedStatement, edu.ustb.sei.mde.xmu.ObjectVariable>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.UpdatedStatement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<edu.ustb.sei.mde.xmu.ObjectVariable> result) {
		if(identifier==null || container ==null) return;
		Rule rule = Util.getRule(container);
		
		if(rule==null) return;
		
		Variable v = null;
		
		v = Util.getVariable(identifier, rule.getVVars());
		if(v!=null) {
			result.addMapping(identifier, (ObjectVariable) v);
			return;
		}
	}
	
	public String deResolve(edu.ustb.sei.mde.xmu.ObjectVariable element, edu.ustb.sei.mde.xmu.UpdatedStatement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
