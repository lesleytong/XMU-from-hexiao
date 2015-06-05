/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ustb.sei.mde.xmu.XMUModel;

public class ObjectPathExprObjectReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.ObjectPathExpr, org.eclipse.emf.ecore.EObject> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.ObjectPathExpr, org.eclipse.emf.ecore.EObject> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.ObjectPathExpr, org.eclipse.emf.ecore.EObject>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.ObjectPathExpr container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if(resolveFuzzy) {
			if(container==null) return;
			XMUModel model = Util.getXMUModel(container);
			if(model==null) return;
			
			for(EPackage p : model.getPackages()) {
				TreeIterator<EObject> it = p.eAllContents();
				while(it.hasNext()) {
					EObject o = it.next();
					URI u = EcoreUtil.getURI(o);
					result.addMapping("@"+u.toString(), o);
				}
			}
		} else {
			if(identifier==null ||identifier.length()==0 || container==null) return;
			String str = identifier.substring(1);
			
			EObject obj = container.eResource().getResourceSet().getEObject(URI.createURI(str), false);
			
			if(obj==null) return;
			
			result.addMapping(identifier, obj);			
		}
		
		
	}
	
	public String deResolve(org.eclipse.emf.ecore.EObject element, edu.ustb.sei.mde.xmu.ObjectPathExpr container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
