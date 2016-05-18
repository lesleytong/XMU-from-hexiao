/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.analysis;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.util.ResolverUtil;
import edu.ustb.sei.mde.xmu2.TransformationModel;
import edu.ustb.sei.mde.xmu2.Xmu2Package;

public class TypedElementTypeReferenceResolver implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<edu.ustb.sei.mde.xmu2.TypedElement, org.eclipse.emf.ecore.EClassifier> {
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.TypedElement, org.eclipse.emf.ecore.EClassifier> delegate = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultResolverDelegate<edu.ustb.sei.mde.xmu2.TypedElement, org.eclipse.emf.ecore.EClassifier>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.xmu2.TypedElement container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolveResult<org.eclipse.emf.ecore.EClassifier> result) {
		if(resolveFuzzy) {
			for(int i = 0; i < ResolverUtil.primitiveTypeNames.length ; i++) {
				String s = ResolverUtil.primitiveTypeNames[i];
				if(ResolverUtil.identifierMatchFuzzy(identifier, s)) {
					result.addMapping(identifier, ResolverUtil.primitiveTypes[i]);
				}
			}
			
			for(int i = 0; i < ResolverUtil.reservedTypeNames.length ; i++) {
				String s = ResolverUtil.reservedTypeNames[i];
				if(ResolverUtil.identifierMatchFuzzy(identifier, s)) {
					result.addMapping(identifier, ResolverUtil.reservedTypes[i]);
				}
			}
			
			TransformationModel model = (TransformationModel) ResolverUtil.getAncestor(container, Xmu2Package.eINSTANCE.getTransformationModel());
			if(model!=null) {
				if(identifier.contains("!")) {
					//package has been typed
					String[] names = identifier.split("!");
					
					for(EPackage p : model.getPackages()) {
						if(ResolverUtil.identifierMatch(names[0], p.getName())) {
							TreeIterator<EObject> it = p.eAllContents();
							while(it.hasNext()) {
								EObject o = it.next();
								if(o instanceof EClassifier) {
									if(names.length==1 || ResolverUtil.identifierMatchFuzzy(names[1], ((EClassifier)o).getName())){
										result.addMapping(names[0]+"!"+((EClassifier)o).getName(), (EClassifier)o);
									}
								}
							}
						}
					}
				} else {
					//package is not typed
					
					for(EPackage p : model.getPackages()) {
						if(ResolverUtil.identifierMatchFuzzy(identifier, p.getName())) {
							TreeIterator<EObject> it = p.eAllContents();
							while(it.hasNext()) {
								EObject o = it.next();
								if(o instanceof EClassifier) {
									result.addMapping(p.getName()+"!"+((EClassifier)o).getName(), (EClassifier)o);
								}
							}
						}
					}
					
				}
			}

			
		} else {
			EDataType dt = ResolverUtil.getPrimitiveDataType(identifier);
			if (dt != null) {
				result.addMapping(identifier, dt);
				return;
			} else {
				EClassifier type = ResolverUtil.getReservedType(identifier);
				if (type == null) {
					TransformationModel model = (TransformationModel) ResolverUtil.getAncestor(container,
							Xmu2Package.eINSTANCE.getTransformationModel());
					if (model == null)
						return;
					type = ResolverUtil.getEClassifier(identifier, model.getPackages());
					if (type == null)
						return;
				}
				result.addMapping(identifier, type);
			}
		}
	}
	
	public String deResolve(org.eclipse.emf.ecore.EClassifier element, edu.ustb.sei.mde.xmu2.TypedElement container, org.eclipse.emf.ecore.EReference reference) {
		if (element instanceof EDataType) {
			return ResolverUtil.getPrimitiveDataTypeName(element);
		} else {
			if (ResolverUtil.isReservedType(element)) {
				return ResolverUtil.getReservedTypeName(element);
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
