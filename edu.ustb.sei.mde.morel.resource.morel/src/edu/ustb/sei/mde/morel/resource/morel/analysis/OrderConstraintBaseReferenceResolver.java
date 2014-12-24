/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.analysis;

import edu.ustb.sei.mde.morel.ObjectVariable;
import edu.ustb.sei.mde.morel.Pattern;
import edu.ustb.sei.mde.morel.Variable;

public class OrderConstraintBaseReferenceResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.OrderConstraint, edu.ustb.sei.mde.morel.ObjectVariable> {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.OrderConstraint, edu.ustb.sei.mde.morel.ObjectVariable> delegate = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.OrderConstraint, edu.ustb.sei.mde.morel.ObjectVariable>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.morel.OrderConstraint container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<edu.ustb.sei.mde.morel.ObjectVariable> result) {
		Pattern pattern = (Pattern)container.eContainer();
		if(pattern==null) return;
		for(Variable v : pattern.getVariables()) {
			if(v.getName().equals(identifier) && v instanceof ObjectVariable) {
				result.addMapping(identifier, (ObjectVariable)v);
			}
		}
	}
	
	public String deResolve(edu.ustb.sei.mde.morel.ObjectVariable element, edu.ustb.sei.mde.morel.OrderConstraint container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
