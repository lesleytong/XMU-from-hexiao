/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.analysis;

import org.eclipse.emf.ecore.EPackage;

import edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.util.ResolverUtil;

public class TransformationModelPackagesReferenceResolver implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<edu.ustb.sei.mde.xmu2.TransformationModel, org.eclipse.emf.ecore.EPackage> {
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.TransformationModel, org.eclipse.emf.ecore.EPackage> delegate = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.TransformationModel, org.eclipse.emf.ecore.EPackage>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu2.TransformationModel container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolveResult<org.eclipse.emf.ecore.EPackage> result) {
		try{
			EPackage p = ResolverUtil.loadPackage(identifier, container.eResource());
			if(p!=null) {
				result.addMapping(identifier, p);
				return;
			}
			
		} catch(Exception e) {}
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EPackage element, edu.ustb.sei.mde.xmu2.TransformationModel container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
