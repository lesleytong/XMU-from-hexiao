/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

import edu.ustb.sei.mde.xmu.ObjectVariable;
import edu.ustb.sei.mde.xmu.PatternNode;
import edu.ustb.sei.mde.xmu.Rule;
import edu.ustb.sei.mde.xmu.Variable;

public class DeleteLinkSourceReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.DeleteLink, edu.ustb.sei.mde.xmu.ObjectVariable> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.DeleteLink, edu.ustb.sei.mde.xmu.ObjectVariable> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.DeleteLink, edu.ustb.sei.mde.xmu.ObjectVariable>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.DeleteLink container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<edu.ustb.sei.mde.xmu.ObjectVariable> result) {
		if(identifier==null || container==null) return;
		
		Rule rule = Util.getRule(container);
		
		if(rule==null) return;
		
//		ObjectVariable v = (ObjectVariable) (Util.getVariable(identifier, rule.getSpVars()));
//		
//		if(v==null) return;
//		
//		result.addMapping(identifier, v);
		
		if(identifier.endsWith(Util.POST_FLAG)) {
			Variable var = Util.getVariable(identifier, rule.getSpVars());
			if(var==null) return;
			result.addMapping(identifier, (ObjectVariable) var);			
		} else {
			identifier = identifier.concat(Util.POST_FLAG);
			Variable var = Util.getVariable(identifier, rule.getSpVars());
			if(var==null) return;
			result.addMapping(identifier, (ObjectVariable) var);
		}
	}
	
	public String deResolve(edu.ustb.sei.mde.xmu.ObjectVariable element, edu.ustb.sei.mde.xmu.DeleteLink container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
