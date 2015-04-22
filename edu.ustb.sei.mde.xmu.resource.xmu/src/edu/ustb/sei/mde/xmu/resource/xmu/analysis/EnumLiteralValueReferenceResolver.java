/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.analysis;

import org.eclipse.emf.ecore.EEnumLiteral;

import edu.ustb.sei.mde.xmu.EnumLiteral;

public class EnumLiteralValueReferenceResolver implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.EnumLiteral, org.eclipse.emf.ecore.EEnumLiteral> {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.EnumLiteral, org.eclipse.emf.ecore.EEnumLiteral> delegate = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultResolverDelegate<edu.ustb.sei.mde.xmu.EnumLiteral, org.eclipse.emf.ecore.EEnumLiteral>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu.EnumLiteral container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<org.eclipse.emf.ecore.EEnumLiteral> result) {
		if(identifier == null || container==null) return;
		EnumLiteral l = (EnumLiteral) container.eContainer();
		if(l.getType()==null || l.getType().eIsProxy()) return;
		EEnumLiteral lr = l.getType().getEEnumLiteral(identifier);
		if(lr==null) return;
		result.addMapping(identifier, lr);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EEnumLiteral element, edu.ustb.sei.mde.xmu.EnumLiteral container, org.eclipse.emf.ecore.EReference reference) {
//		return delegate.deResolve(element, container, reference);
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
