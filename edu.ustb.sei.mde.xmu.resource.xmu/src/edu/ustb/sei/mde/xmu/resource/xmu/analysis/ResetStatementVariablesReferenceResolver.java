/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

import java.util.List;

import org.eclipse.emf.ecore.EReference;

import edu.ustb.sei.mde.xmu.Pattern;
import edu.ustb.sei.mde.xmu.Rule;
import edu.ustb.sei.mde.xmu.SwitchStatement;
import edu.ustb.sei.mde.xmu.UpdatePattern;
import edu.ustb.sei.mde.xmu.Variable;
import edu.ustb.sei.mde.xmu.VariableFlag;
import edu.ustb.sei.mde.xmu.XmuPackage;

public class ResetStatementVariablesReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.ResetStatement, edu.ustb.sei.mde.xmu.Variable> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.ResetStatement, edu.ustb.sei.mde.xmu.Variable> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.ResetStatement, edu.ustb.sei.mde.xmu.Variable>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.ResetStatement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<edu.ustb.sei.mde.xmu.Variable> result) {
		if(resolveFuzzy) {
			if(container==null) return;
			Rule rule = Util.getRule(container);
			if(rule==null) return;
			
			List<? extends Variable> list = null;
			
			list = rule.getSVars();
			
			if(list==null) return;
			
			if(identifier==null) {
				for(Variable v : list) {
					result.addMapping(v.getName(), v);
				}
			} else {
				for(Variable v : list) {
					if(v.getName().startsWith(identifier))
						result.addMapping(v.getName(), v);
				}
			}
			
		} else {
			if(container==null) return;
			Rule rule = Util.getRule(container);
			if(rule==null) return;
			
			List<? extends Variable> list = null;
			
			list = rule.getSVars();
			
			if(list==null) return;
			
			if(identifier==null) {
				return;
			} else {
				for(Variable v : list) {
					if(v.getName().equals(identifier))
						result.addMapping(v.getName(), v);
				}
			}		
		}
	}
	
	public String deResolve(edu.ustb.sei.mde.xmu.Variable element, edu.ustb.sei.mde.xmu.ResetStatement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
