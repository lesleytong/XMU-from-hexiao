/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;

import edu.ustb.sei.mde.xmu.XMUModel;
import edu.ustb.sei.mde.xmu.XmuPackage;

public class PatternNodeTypeReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.PatternNode, org.eclipse.emf.ecore.EClass> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.PatternNode, org.eclipse.emf.ecore.EClass> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.PatternNode, org.eclipse.emf.ecore.EClass>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.PatternNode container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		if(resolveFuzzy) {
			if(container==null) return;
			XMUModel model = Util.getXMUModel(container);
			if(model==null) return;
			
			if(identifier==null) {
				result.addMapping("Any", EcorePackage.eINSTANCE.getEObject());
				result.addMapping("Resource", XmuPackage.eINSTANCE.getEResource());
				result.addMapping("Set", XmuPackage.eINSTANCE.getESet());
				
				for(EPackage p : model.getPackages()) {
					TreeIterator<EObject> it = p.eAllContents();
					while(it.hasNext()) {
						EObject object = it.next();
						if(object instanceof EClass) 
							result.addMapping(((EClass) object).getName(),(EClass) object);
					}
				}
			} else {
				for(EPackage p : model.getPackages()) {
					TreeIterator<EObject> it = p.eAllContents();
					while(it.hasNext()) {
						EObject object = it.next();
						if(object instanceof EClass) {
							if(((EClass) object).getName().startsWith(identifier))
								result.addMapping(((EClass) object).getName(),(EClass) object);							
						}
					}
				}
			}
		} else {
			if(identifier==null || container==null) {
				return;
			}
			
			XMUModel model = Util.getXMUModel(container);
			
			if(model==null) return;
			
			if(identifier.equals("Any")) {
				result.addMapping(identifier, EcorePackage.eINSTANCE.getEObject());
				return;
			} else if(identifier.equals("Resource")) {
				result.addMapping(identifier, XmuPackage.eINSTANCE.getEResource());
				return;
			} else if(identifier.equals("Set")) {
				result.addMapping(identifier, XmuPackage.eINSTANCE.getESet());
				return;
			}
			
			EClass cls = Util.getEClass(identifier, model.getPackages());
			
			if(cls==null) return;
			
			result.addMapping(identifier, cls);
		}
		
	}
	
	public String deResolve(org.eclipse.emf.ecore.EClass element, edu.ustb.sei.mde.xmu.PatternNode container, org.eclipse.emf.ecore.EReference reference) {
//		
		if(element==EcorePackage.eINSTANCE.getEObject()) return "Any";
		else if(element==XmuPackage.eINSTANCE.getEResource()) return "Resource";
		else if(element==XmuPackage.eINSTANCE.getESet()) return "Set";
		else return element.getName();
//		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
