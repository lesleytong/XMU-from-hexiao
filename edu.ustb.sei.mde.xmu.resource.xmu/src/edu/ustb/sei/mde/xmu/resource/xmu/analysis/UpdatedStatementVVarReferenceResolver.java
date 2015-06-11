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

public class UpdatedStatementVVarReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.UpdatedStatement, edu.ustb.sei.mde.xmu.Variable> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.UpdatedStatement, edu.ustb.sei.mde.xmu.Variable> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.UpdatedStatement, edu.ustb.sei.mde.xmu.Variable>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.UpdatedStatement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<edu.ustb.sei.mde.xmu.Variable> result) {
		if(resolveFuzzy) {
			if(container==null) return;
			Rule rule = Util.getRule(container);
			if(rule==null) return;
			if(identifier==null) {
				for(ObjectVariable v : rule.getVVars()) {
					result.addMapping(v.getName(), v);
				}
				for(Variable v : rule.getNVars()) {
					result.addMapping(v.getName(), v);
				}
			} else {
				for(ObjectVariable v : rule.getVVars()) {
					if(v.getName().startsWith(identifier))
						result.addMapping(v.getName(), v);
				}
				for(Variable v : rule.getNVars()) {
					if(v.getName().startsWith(identifier))
						result.addMapping(v.getName(), v);
				}
			}
		} else {
			if(identifier==null || container ==null) return;
			Rule rule = Util.getRule(container);
			
			if(rule==null) return;
			
			Variable v = null;
			
			v = Util.getVariable(identifier, rule.getVVars());
			if(v!=null) {
				result.addMapping(identifier, (ObjectVariable) v);
				return;
			}
			v = Util.getVariable(identifier, rule.getNVars());
			if(v!=null) {
				result.addMapping(identifier, v);
				return;
			}
		}
	}
	
	public String deResolve(edu.ustb.sei.mde.xmu.Variable element, edu.ustb.sei.mde.xmu.UpdatedStatement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
