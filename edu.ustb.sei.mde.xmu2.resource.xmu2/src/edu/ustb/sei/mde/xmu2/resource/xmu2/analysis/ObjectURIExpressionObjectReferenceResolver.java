/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.analysis;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.util.ResolverUtil;
import edu.ustb.sei.mde.xmu2.TransformationModel;
import edu.ustb.sei.mde.xmu2.Xmu2Package;

public class ObjectURIExpressionObjectReferenceResolver implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression, org.eclipse.emf.ecore.EObject> {
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression, org.eclipse.emf.ecore.EObject> delegate = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression, org.eclipse.emf.ecore.EObject>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if(resolveFuzzy) {
			if(container==null) return;
			TransformationModel model = (TransformationModel) ResolverUtil.getAncestor(container,Xmu2Package.eINSTANCE.getTransformationModel());
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
			
			try {
				EObject obj = container.eResource().getResourceSet().getEObject(URI.createURI(str), false);

				if (obj == null)
					return;

				result.addMapping(identifier, obj);
			} catch (Exception e) {

			}
		}
	}
	
	public String deResolve(org.eclipse.emf.ecore.EObject element, edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression container, org.eclipse.emf.ecore.EReference reference) {
		return "@"+delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
