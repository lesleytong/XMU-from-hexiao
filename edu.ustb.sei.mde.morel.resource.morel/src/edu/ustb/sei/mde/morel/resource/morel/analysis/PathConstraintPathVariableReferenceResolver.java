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

public class PathConstraintPathVariableReferenceResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.PathConstraint, edu.ustb.sei.mde.morel.Variable> {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.PathConstraint, edu.ustb.sei.mde.morel.Variable> delegate = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.PathConstraint, edu.ustb.sei.mde.morel.Variable>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.morel.PathConstraint container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<edu.ustb.sei.mde.morel.Variable> result) {
		Pattern pattern = (Pattern)container.eContainer();
		for(Variable v : pattern.getVariables()) {
			if(v.getName().equals(identifier)) {
				result.addMapping(identifier, v);
			}
		}
	}
	
	public String deResolve(edu.ustb.sei.mde.morel.Variable element, edu.ustb.sei.mde.morel.PathConstraint container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
