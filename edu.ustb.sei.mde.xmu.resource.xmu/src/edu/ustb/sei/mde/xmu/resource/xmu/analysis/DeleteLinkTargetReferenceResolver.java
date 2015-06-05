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

public class DeleteLinkTargetReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.DeleteLink, edu.ustb.sei.mde.xmu.Variable> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.DeleteLink, edu.ustb.sei.mde.xmu.Variable> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.DeleteLink, edu.ustb.sei.mde.xmu.Variable>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.DeleteLink container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<edu.ustb.sei.mde.xmu.Variable> result) {
		if(resolveFuzzy) {
			if(container==null) return;
			Rule rule = Util.getRule(container);
			if(rule==null) return;
			
			if(identifier==null) {
				for(ObjectVariable v : rule.getSpVars()) {
					result.addMapping(v.getName(), v);
				}
				for(Variable v : rule.getNVars()) {
					result.addMapping(v.getName(), v);
				}
			} else {
				for(ObjectVariable v : rule.getSpVars()) {
					if(v.getName().startsWith(identifier))
						result.addMapping(v.getName(), v);
				}
				for(Variable v : rule.getNVars()) {
					if(v.getName().startsWith(identifier))
						result.addMapping(v.getName(), v);
				}
			}
		} else {
			if(identifier==null || container==null) return;
			
			Rule rule = Util.getRule(container);
			
			if(rule==null) return;
			
			if(identifier.endsWith(Util.POST_FLAG)) {
				Variable var = Util.getVariable(identifier, rule.getSpVars());
				if(var==null) return;
				result.addMapping(identifier,  var);			
			} else {
				Variable var = Util.getVariable(identifier, rule.getNVars());
				if(var!=null) {
					result.addMapping(identifier, var);
				} else {
					identifier = identifier.concat(Util.POST_FLAG);
					var = Util.getVariable(identifier, rule.getSpVars());
					if(var==null) return;
					result.addMapping(identifier, var);				
				}
			}			
		}
		
	}
	
	public String deResolve(edu.ustb.sei.mde.xmu.Variable element, edu.ustb.sei.mde.xmu.DeleteLink container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
