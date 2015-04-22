/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

import edu.ustb.sei.mde.xmu.Rule;
import edu.ustb.sei.mde.xmu.Variable;
import edu.ustb.sei.mde.xmu.VariableFlag;

public class SwitchStatementVarReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.SwitchStatement, edu.ustb.sei.mde.xmu.Variable> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.SwitchStatement, edu.ustb.sei.mde.xmu.Variable> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.SwitchStatement, edu.ustb.sei.mde.xmu.Variable>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.SwitchStatement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<edu.ustb.sei.mde.xmu.Variable> result) {
		if(identifier==null || container ==null) return;
		Rule rule = Util.getRule(container);
		
		if(rule==null) return;
		
		Variable v = null;
		
		v = Util.getVariable(identifier, rule.getNVars());
		if(v!=null) {
			result.addMapping(identifier, v);
			container.setTag(VariableFlag.NORMAL);
			return;
		}
		v = Util.getVariable(identifier, rule.getSVars());
		if(v!=null) {
			result.addMapping(identifier, v);
			container.setTag(VariableFlag.SOURCE);
			return;
		}
		v = Util.getVariable(identifier, rule.getVVars());
		if(v!=null) {
			result.addMapping(identifier, v);
			container.setTag(VariableFlag.VIEW);
			return;
		}
		v = Util.getVariable(identifier, rule.getSpVars());
		if(v!=null) {
			result.addMapping(identifier, v);
			container.setTag(VariableFlag.SOURCE_POST);
			return;
		}
	}
	
	public String deResolve(edu.ustb.sei.mde.xmu.Variable element, edu.ustb.sei.mde.xmu.SwitchStatement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
