/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.analysis;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

public class PathConstraintReferencesReferenceResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.PathConstraint, org.eclipse.emf.ecore.EReference> {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.PathConstraint, org.eclipse.emf.ecore.EReference> delegate = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.PathConstraint, org.eclipse.emf.ecore.EReference>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.morel.PathConstraint container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<org.eclipse.emf.ecore.EReference> result) {
		if(container.getSource()!=null) {
			EClass c = container.getSource().getType();
			EStructuralFeature feature = FeatureResolver.getStructuralFeature(identifier, c);
			if(feature!=null && feature instanceof EReference) {
				result.addMapping(identifier, (EReference) feature);
				return;
			}
		}
		
		for(EReference r: container.getReferences()) {
			EClass c = r.getEReferenceType();
			if(c==null) continue;
			EStructuralFeature feature = FeatureResolver.getStructuralFeature(identifier, c);
			if(feature!=null && feature instanceof EReference) {
				result.addMapping(identifier, (EReference) feature);
				return;
			}
		}
		
		for(EClass c : container.getTypes()) {
			if(c==null) continue;
			EStructuralFeature feature = FeatureResolver.getStructuralFeature(identifier, c);
			if(feature!=null && feature instanceof EReference) {
				result.addMapping(identifier, (EReference) feature);
				return;
			}
		}
	}
	
	public String deResolve(org.eclipse.emf.ecore.EReference element, edu.ustb.sei.mde.morel.PathConstraint container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
