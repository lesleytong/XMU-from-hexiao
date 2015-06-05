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

import edu.ustb.sei.mde.xmu.XMUModel;

public class EnumLiteralTypeReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.EnumLiteral, org.eclipse.emf.ecore.EEnum> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.EnumLiteral, org.eclipse.emf.ecore.EEnum> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.EnumLiteral, org.eclipse.emf.ecore.EEnum>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.EnumLiteral container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<org.eclipse.emf.ecore.EEnum> result) {
		if(resolveFuzzy) {
			if(container==null) return;
			XMUModel model = Util.getXMUModel(container);
			
			if(model==null) return;
			
			if(identifier==null) {
				for(EPackage p : model.getPackages()) {
					TreeIterator<EObject> it = p.eAllContents();
					while(it.hasNext()) {
						EObject object = it.next();
						if(object instanceof EEnum) 
							result.addMapping(((EEnum) object).getName(),(EEnum) object);
					}
				}
			} else {
				for(EPackage p : model.getPackages()) {
					TreeIterator<EObject> it = p.eAllContents();
					while(it.hasNext()) {
						EObject object = it.next();
						if(object instanceof EEnum) {
							if(((EEnum) object).getName().startsWith(identifier))
								result.addMapping(((EEnum) object).getName(),(EEnum) object);
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
			
			EEnum cls = Util.getEnum(identifier, model.getPackages());
			
			if(cls==null) return;
			
			result.addMapping(identifier, cls);
		}		
	}
	
	public String deResolve(org.eclipse.emf.ecore.EEnum element, edu.ustb.sei.mde.xmu.EnumLiteral container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
