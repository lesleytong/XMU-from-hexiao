/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.mde.xmu.PatternNode;

public class PatternEqualExprFeatureReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.PatternEqualExpr, org.eclipse.emf.ecore.EStructuralFeature> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.PatternEqualExpr, org.eclipse.emf.ecore.EStructuralFeature> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.PatternEqualExpr, org.eclipse.emf.ecore.EStructuralFeature>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.PatternEqualExpr container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<org.eclipse.emf.ecore.EStructuralFeature> result) {
		if(resolveFuzzy) {
			if(container==null) return;
			PatternNode n = (PatternNode) container.eContainer();
			if(n==null || n.getType()==null) return;
			if(identifier==null) {
				for(EStructuralFeature f : n.getType().getEAllStructuralFeatures()) {
					result.addMapping(f.getName(), f);
				}
			} else {
				for(EStructuralFeature f : n.getType().getEAllStructuralFeatures()) {
					if(f.getName().startsWith(identifier))
						result.addMapping(f.getName(), f);
				}
			}
			
		} else {
			if(identifier==null || container==null) return;
			PatternNode n = (PatternNode) container.eContainer();
			if(n==null || n.getType()==null) return;
			EStructuralFeature feature = Util.getFeature(identifier, n.getType());
			
			if(feature==null) return;
			result.addMapping(identifier, feature);			
		}
		
	}
	
	public String deResolve(org.eclipse.emf.ecore.EStructuralFeature element, edu.ustb.sei.mde.xmu.PatternEqualExpr container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
