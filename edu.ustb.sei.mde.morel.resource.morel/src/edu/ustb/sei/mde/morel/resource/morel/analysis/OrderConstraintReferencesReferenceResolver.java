/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.analysis;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

public class OrderConstraintReferencesReferenceResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.OrderConstraint, org.eclipse.emf.ecore.EReference> {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.OrderConstraint, org.eclipse.emf.ecore.EReference> delegate = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<edu.ustb.sei.mde.morel.OrderConstraint, org.eclipse.emf.ecore.EReference>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.morel.OrderConstraint container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<org.eclipse.emf.ecore.EReference> result) {
		try {
			EClass cls = container.getTypes().get(position);
			if(resolveFuzzy) {
				for(EReference ref : cls.getEAllReferences()) {
					if(ref.getName().indexOf(identifier)!=-1) {
						result.addMapping(ref.getName(), ref);
					}
				}				

			} else {
				EReference ref = (EReference) FeatureResolver.getStructuralFeature(identifier, cls);
				if(ref!=null) {
					result.addMapping(identifier, ref);
				}
//				
//				for(EReference ref : cls.getEAllReferences()) {
//					if(ref.getName().equals(identifier)) {
//						result.addMapping(identifier, ref);
//					}
//				}				
			}
		} catch (Exception e) {
		}
	}
	
	public String deResolve(org.eclipse.emf.ecore.EReference element, edu.ustb.sei.mde.morel.OrderConstraint container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
