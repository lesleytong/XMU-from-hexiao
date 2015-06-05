/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

import edu.ustb.sei.mde.xmu.XMUModel;
import edu.ustb.sei.mde.xmu.Rule;

public class RuleCallStatementRuleReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.RuleCallStatement, edu.ustb.sei.mde.xmu.Rule> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.RuleCallStatement, edu.ustb.sei.mde.xmu.Rule> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.RuleCallStatement, edu.ustb.sei.mde.xmu.Rule>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.RuleCallStatement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<edu.ustb.sei.mde.xmu.Rule> result) {
		if(resolveFuzzy) {
			if(container==null) return;
			
			XMUModel m = Util.getXMUModel(container);
			
			if(identifier==null) {
				for(Rule r : m.getRules()) {
					result.addMapping(r.getName(), r);
				}
			} else {
				for(Rule r : m.getRules()) {
					if(r.getName().startsWith(identifier))
						result.addMapping(r.getName(), r);
				}
			}
		} else {
			delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);			
		}
		
	}
	
	public String deResolve(edu.ustb.sei.mde.xmu.Rule element, edu.ustb.sei.mde.xmu.RuleCallStatement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
