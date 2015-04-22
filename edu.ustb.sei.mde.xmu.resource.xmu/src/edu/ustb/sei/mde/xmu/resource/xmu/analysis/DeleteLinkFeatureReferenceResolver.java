/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.mde.xmu.ObjectVariable;
import edu.ustb.sei.mde.xmu.PatternNode;

public class DeleteLinkFeatureReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.DeleteLink, org.eclipse.emf.ecore.EStructuralFeature> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.DeleteLink, org.eclipse.emf.ecore.EStructuralFeature> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.DeleteLink, org.eclipse.emf.ecore.EStructuralFeature>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.DeleteLink container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<org.eclipse.emf.ecore.EStructuralFeature> result) {
		if(identifier==null || container==null) return;
		
		ObjectVariable ov = container.getSource();
		
		if(ov==null || ov.eIsProxy()) return;
		
		PatternNode n = Util.getNearestPatternNode(container.eContainer(), ov);
		
		if(n==null) return;
		
		EStructuralFeature feature = Util.getFeature(identifier, n.getType());
		
		result.addMapping(identifier, feature);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EStructuralFeature element, edu.ustb.sei.mde.xmu.DeleteLink container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
