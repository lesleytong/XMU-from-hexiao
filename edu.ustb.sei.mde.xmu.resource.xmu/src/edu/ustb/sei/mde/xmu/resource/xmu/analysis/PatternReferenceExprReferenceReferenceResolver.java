/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.mde.xmu.PatternNode;

public class PatternReferenceExprReferenceReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.PatternReferenceExpr, org.eclipse.emf.ecore.EReference> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.PatternReferenceExpr, org.eclipse.emf.ecore.EReference> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.PatternReferenceExpr, org.eclipse.emf.ecore.EReference>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.PatternReferenceExpr container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<org.eclipse.emf.ecore.EReference> result) {
		if(resolveFuzzy) {
			if(container==null) return;
			PatternNode n = (PatternNode) container.eContainer();
			if(n==null || n.getType()==null) return;
			
			if(identifier==null) {
				for(EReference f : n.getType().getEAllReferences()) {
					result.addMapping(f.getName(), f);
				}
			} else {
				for(EReference f : n.getType().getEAllReferences()) {
					if(f.getName().startsWith(identifier))
						result.addMapping(f.getName(), f);
				}
			}
		} else {
			if(identifier==null || container==null) return;
			PatternNode n = (PatternNode) container.eContainer();
			if(n==null || n.getType()==null) return;
			EStructuralFeature ref = Util.getFeature(identifier, n.getType());
			
			if(ref==null || !(ref instanceof EReference)) return;
			result.addMapping(identifier, (EReference)ref);
		}		
	}
	
	public String deResolve(org.eclipse.emf.ecore.EReference element, edu.ustb.sei.mde.xmu.PatternReferenceExpr container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
