/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.analysis;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

public class PathConstraintTypesReferenceResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.PathConstraint, org.eclipse.emf.ecore.EClass> {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.PathConstraint, org.eclipse.emf.ecore.EClass> delegate = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.PathConstraint, org.eclipse.emf.ecore.EClass>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.morel.PathConstraint container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		EClassifier type =TypeResolver.resolve(identifier, container);
		if(type!=null)
			result.addMapping(identifier, (EClass) type);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EClass element, edu.ustb.sei.mde.morel.PathConstraint container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
