/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class XMUModelPackagesReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.XMUModel, org.eclipse.emf.ecore.EPackage> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.XMUModel, org.eclipse.emf.ecore.EPackage> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.XMUModel, org.eclipse.emf.ecore.EPackage>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.XMUModel container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<org.eclipse.emf.ecore.EPackage> result) {
		if(resolveFuzzy==false) {
			if(identifier==null || container==null || container.eResource()==null) return;
			EPackage pkg = Util.loadPackage(identifier, container.eResource());
			if(pkg!=null) {
				result.addMapping(identifier, pkg);
				EcoreUtil.freeze(pkg);
			}
		} else {
			delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
		}
	}
	
	public String deResolve(org.eclipse.emf.ecore.EPackage element, edu.ustb.sei.mde.xmu.XMUModel container, org.eclipse.emf.ecore.EReference reference) {
		//return delegate.deResolve(element, container, reference);
		return element.eResource().getURI().isPlatformPlugin() ? 
				element.getNsURI() : element.eResource().getURI().toString();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
