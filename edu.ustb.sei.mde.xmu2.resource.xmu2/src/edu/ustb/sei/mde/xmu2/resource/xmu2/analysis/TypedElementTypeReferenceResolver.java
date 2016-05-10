/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.analysis;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;

import edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.util.ResolverUtil;
import edu.ustb.sei.mde.xmu2.TransformationModel;
import edu.ustb.sei.mde.xmu2.Xmu2Package;

public class TypedElementTypeReferenceResolver implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<edu.ustb.sei.mde.xmu2.TypedElement, org.eclipse.emf.ecore.EClassifier> {
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.TypedElement, org.eclipse.emf.ecore.EClassifier> delegate = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.TypedElement, org.eclipse.emf.ecore.EClassifier>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu2.TypedElement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolveResult<org.eclipse.emf.ecore.EClassifier> result) {
		EDataType dt = ResolverUtil.getPrimitiveDataType(identifier);
		if(dt!=null) {
			result.addMapping(identifier, dt);
			return;
		} else {
			EClassifier type = ResolverUtil.getReservedType(identifier);
			if(type==null) {
				TransformationModel model = (TransformationModel) ResolverUtil.getAncestor(container, Xmu2Package.eINSTANCE.getTransformationModel());
				if(model==null) return;
				type = ResolverUtil.getEClassifier(identifier, model.getPackages());
				if(type==null) return;
			}
			result.addMapping(identifier, type);
		}
	}
	
	public String deResolve(org.eclipse.emf.ecore.EClassifier element, edu.ustb.sei.mde.xmu2.TypedElement container, org.eclipse.emf.ecore.EReference reference) {
		if (element instanceof EDataType) {
			return ResolverUtil.getPrimitiveDataTypeName(element);
		} else {
			if (ResolverUtil.isReservedType(element)) {
				return element.getName();
			} else {
				TransformationModel model = (TransformationModel) ResolverUtil.getAncestor(container,
						Xmu2Package.eINSTANCE.getTransformationModel());
				for (EPackage p : model.getPackages()) {
					if (p.eResource() == element.eResource())
						return p.getName() + "!" + element.getName();
				}
				return element.getEPackage().getName() + "!" + element.getName();
			}
		}
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
