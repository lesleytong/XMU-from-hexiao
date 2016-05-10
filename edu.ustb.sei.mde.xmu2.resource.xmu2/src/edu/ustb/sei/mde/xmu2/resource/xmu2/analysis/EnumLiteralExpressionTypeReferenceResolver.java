/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.analysis;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import edu.ustb.sei.mde.xmu2.TransformationModel;
import edu.ustb.sei.mde.xmu2.Xmu2Package;
import edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.util.ResolverUtil;

public class EnumLiteralExpressionTypeReferenceResolver implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression, org.eclipse.emf.ecore.EEnum> {
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression, org.eclipse.emf.ecore.EEnum> delegate = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression, org.eclipse.emf.ecore.EEnum>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolveResult<org.eclipse.emf.ecore.EEnum> result) {
		TransformationModel model = (TransformationModel) ResolverUtil.getAncestor(container, Xmu2Package.eINSTANCE.getTransformationModel());
		if(model==null) return;
		EEnum e = ResolverUtil.getEnum(identifier, model.getPackages());
		if(e!=null) {
			result.addMapping(identifier, e);
			return;
		}
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(org.eclipse.emf.ecore.EEnum element, edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression container, org.eclipse.emf.ecore.EReference reference) {
		TransformationModel model = (TransformationModel) ResolverUtil.getAncestor(container, Xmu2Package.eINSTANCE.getTransformationModel());
		for(EPackage p : model.getPackages()) {
			if(p.eResource() == element.eResource()) 
				return p.getName()+"!"+element.getName();
		}
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
