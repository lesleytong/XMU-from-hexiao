/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

public class MorelReferenceResolverSwitch implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected edu.ustb.sei.mde.morel.resource.morel.analysis.TypedModelPackageReferenceResolver typedModelPackageReferenceResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.TypedModelPackageReferenceResolver();
	protected edu.ustb.sei.mde.morel.resource.morel.analysis.ObjectVariableModelReferenceResolver objectVariableModelReferenceResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.ObjectVariableModelReferenceResolver();
	protected edu.ustb.sei.mde.morel.resource.morel.analysis.ObjectVariableTypeReferenceResolver objectVariableTypeReferenceResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.ObjectVariableTypeReferenceResolver();
	protected edu.ustb.sei.mde.morel.resource.morel.analysis.PrimitiveVariableTypeReferenceResolver primitiveVariableTypeReferenceResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.PrimitiveVariableTypeReferenceResolver();
	protected edu.ustb.sei.mde.morel.resource.morel.analysis.LinkConstraintSourceReferenceResolver linkConstraintSourceReferenceResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.LinkConstraintSourceReferenceResolver();
	protected edu.ustb.sei.mde.morel.resource.morel.analysis.SimpleLinkConstraintReferenceReferenceResolver simpleLinkConstraintReferenceReferenceResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.SimpleLinkConstraintReferenceReferenceResolver();
	protected edu.ustb.sei.mde.morel.resource.morel.analysis.LinkConstraintTargetReferenceResolver linkConstraintTargetReferenceResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.LinkConstraintTargetReferenceResolver();
	protected edu.ustb.sei.mde.morel.resource.morel.analysis.EnclosureLinkConstraintForwardReferenceResolver enclosureLinkConstraintForwardReferenceResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.EnclosureLinkConstraintForwardReferenceResolver();
	protected edu.ustb.sei.mde.morel.resource.morel.analysis.EnclosureLinkConstraintTypesReferenceResolver enclosureLinkConstraintTypesReferenceResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.EnclosureLinkConstraintTypesReferenceResolver();
	protected edu.ustb.sei.mde.morel.resource.morel.analysis.PathConstraintReferencesReferenceResolver pathConstraintReferencesReferenceResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.PathConstraintReferencesReferenceResolver();
	protected edu.ustb.sei.mde.morel.resource.morel.analysis.PathConstraintTypesReferenceResolver pathConstraintTypesReferenceResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.PathConstraintTypesReferenceResolver();
	protected edu.ustb.sei.mde.morel.resource.morel.analysis.PathConstraintPathVariableReferenceResolver pathConstraintPathVariableReferenceResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.PathConstraintPathVariableReferenceResolver();
	protected edu.ustb.sei.mde.morel.resource.morel.analysis.VariableExpReferredVariableReferenceResolver variableExpReferredVariableReferenceResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.VariableExpReferredVariableReferenceResolver();
	protected edu.ustb.sei.mde.morel.resource.morel.analysis.TypeLiteralExpValueReferenceResolver typeLiteralExpValueReferenceResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.TypeLiteralExpValueReferenceResolver();
	protected edu.ustb.sei.mde.morel.resource.morel.analysis.EnumLiteralExpEnumTypeReferenceResolver enumLiteralExpEnumTypeReferenceResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.EnumLiteralExpEnumTypeReferenceResolver();
	protected edu.ustb.sei.mde.morel.resource.morel.analysis.EnumLiteralExpEnumSymbolReferenceResolver enumLiteralExpEnumSymbolReferenceResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.EnumLiteralExpEnumSymbolReferenceResolver();
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.TypedModel, org.eclipse.emf.ecore.EPackage> getTypedModelPackageReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypedModel_Package(), typedModelPackageReferenceResolver);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.ObjectVariable, edu.ustb.sei.mde.morel.TypedModel> getObjectVariableModelReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariable_Model(), objectVariableModelReferenceResolver);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.ObjectVariable, org.eclipse.emf.ecore.EClass> getObjectVariableTypeReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariable_Type(), objectVariableTypeReferenceResolver);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.PrimitiveVariable, org.eclipse.emf.ecore.EDataType> getPrimitiveVariableTypeReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariable_Type(), primitiveVariableTypeReferenceResolver);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.LinkConstraint, edu.ustb.sei.mde.morel.ObjectVariable> getLinkConstraintSourceReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLinkConstraint_Source(), linkConstraintSourceReferenceResolver);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.SimpleLinkConstraint, org.eclipse.emf.ecore.EReference> getSimpleLinkConstraintReferenceReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint_Reference(), simpleLinkConstraintReferenceReferenceResolver);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.LinkConstraint, edu.ustb.sei.mde.morel.ObjectVariable> getLinkConstraintTargetReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLinkConstraint_Target(), linkConstraintTargetReferenceResolver);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.EnclosureLinkConstraint, org.eclipse.emf.ecore.EReference> getEnclosureLinkConstraintForwardReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getEnclosureLinkConstraint_Forward(), enclosureLinkConstraintForwardReferenceResolver);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.EnclosureLinkConstraint, org.eclipse.emf.ecore.EClass> getEnclosureLinkConstraintTypesReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getEnclosureLinkConstraint_Types(), enclosureLinkConstraintTypesReferenceResolver);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.PathConstraint, org.eclipse.emf.ecore.EReference> getPathConstraintReferencesReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPathConstraint_References(), pathConstraintReferencesReferenceResolver);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.PathConstraint, org.eclipse.emf.ecore.EClass> getPathConstraintTypesReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPathConstraint_Types(), pathConstraintTypesReferenceResolver);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.PathConstraint, edu.ustb.sei.mde.morel.Variable> getPathConstraintPathVariableReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPathConstraint_PathVariable(), pathConstraintPathVariableReferenceResolver);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.VariableExp, edu.ustb.sei.mde.morel.Variable> getVariableExpReferredVariableReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getVariableExp_ReferredVariable(), variableExpReferredVariableReferenceResolver);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.TypeLiteralExp, org.eclipse.emf.ecore.EClassifier> getTypeLiteralExpValueReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypeLiteralExp_Value(), typeLiteralExpValueReferenceResolver);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.EnumLiteralExp, org.eclipse.emf.ecore.EEnum> getEnumLiteralExpEnumTypeReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getEnumLiteralExp_EnumType(), enumLiteralExpEnumTypeReferenceResolver);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.EnumLiteralExp, org.eclipse.emf.ecore.EEnumLiteral> getEnumLiteralExpEnumSymbolReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getEnumLiteralExp_EnumSymbol(), enumLiteralExpEnumSymbolReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		typedModelPackageReferenceResolver.setOptions(options);
		objectVariableModelReferenceResolver.setOptions(options);
		objectVariableTypeReferenceResolver.setOptions(options);
		primitiveVariableTypeReferenceResolver.setOptions(options);
		linkConstraintSourceReferenceResolver.setOptions(options);
		simpleLinkConstraintReferenceReferenceResolver.setOptions(options);
		linkConstraintTargetReferenceResolver.setOptions(options);
		enclosureLinkConstraintForwardReferenceResolver.setOptions(options);
		enclosureLinkConstraintTypesReferenceResolver.setOptions(options);
		pathConstraintReferencesReferenceResolver.setOptions(options);
		pathConstraintTypesReferenceResolver.setOptions(options);
		pathConstraintPathVariableReferenceResolver.setOptions(options);
		variableExpReferredVariableReferenceResolver.setOptions(options);
		typeLiteralExpValueReferenceResolver.setOptions(options);
		enumLiteralExpEnumTypeReferenceResolver.setOptions(options);
		enumLiteralExpEnumSymbolReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypedModel().isInstance(container)) {
			MorelFuzzyResolveResult<org.eclipse.emf.ecore.EPackage> frr = new MorelFuzzyResolveResult<org.eclipse.emf.ecore.EPackage>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("package")) {
				typedModelPackageReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.morel.TypedModel) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariable().isInstance(container)) {
			MorelFuzzyResolveResult<edu.ustb.sei.mde.morel.TypedModel> frr = new MorelFuzzyResolveResult<edu.ustb.sei.mde.morel.TypedModel>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("model")) {
				objectVariableModelReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.morel.ObjectVariable) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariable().isInstance(container)) {
			MorelFuzzyResolveResult<org.eclipse.emf.ecore.EClass> frr = new MorelFuzzyResolveResult<org.eclipse.emf.ecore.EClass>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("type")) {
				objectVariableTypeReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.morel.ObjectVariable) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariable().isInstance(container)) {
			MorelFuzzyResolveResult<org.eclipse.emf.ecore.EDataType> frr = new MorelFuzzyResolveResult<org.eclipse.emf.ecore.EDataType>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("type")) {
				primitiveVariableTypeReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.morel.PrimitiveVariable) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLinkConstraint().isInstance(container)) {
			MorelFuzzyResolveResult<edu.ustb.sei.mde.morel.ObjectVariable> frr = new MorelFuzzyResolveResult<edu.ustb.sei.mde.morel.ObjectVariable>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("source")) {
				linkConstraintSourceReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.morel.LinkConstraint) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint().isInstance(container)) {
			MorelFuzzyResolveResult<org.eclipse.emf.ecore.EReference> frr = new MorelFuzzyResolveResult<org.eclipse.emf.ecore.EReference>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("reference")) {
				simpleLinkConstraintReferenceReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.morel.SimpleLinkConstraint) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLinkConstraint().isInstance(container)) {
			MorelFuzzyResolveResult<edu.ustb.sei.mde.morel.ObjectVariable> frr = new MorelFuzzyResolveResult<edu.ustb.sei.mde.morel.ObjectVariable>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("target")) {
				linkConstraintTargetReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.morel.LinkConstraint) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getEnclosureLinkConstraint().isInstance(container)) {
			MorelFuzzyResolveResult<org.eclipse.emf.ecore.EReference> frr = new MorelFuzzyResolveResult<org.eclipse.emf.ecore.EReference>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("forward")) {
				enclosureLinkConstraintForwardReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.morel.EnclosureLinkConstraint) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getEnclosureLinkConstraint().isInstance(container)) {
			MorelFuzzyResolveResult<org.eclipse.emf.ecore.EClass> frr = new MorelFuzzyResolveResult<org.eclipse.emf.ecore.EClass>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("types")) {
				enclosureLinkConstraintTypesReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.morel.EnclosureLinkConstraint) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPathConstraint().isInstance(container)) {
			MorelFuzzyResolveResult<org.eclipse.emf.ecore.EReference> frr = new MorelFuzzyResolveResult<org.eclipse.emf.ecore.EReference>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("references")) {
				pathConstraintReferencesReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.morel.PathConstraint) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPathConstraint().isInstance(container)) {
			MorelFuzzyResolveResult<org.eclipse.emf.ecore.EClass> frr = new MorelFuzzyResolveResult<org.eclipse.emf.ecore.EClass>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("types")) {
				pathConstraintTypesReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.morel.PathConstraint) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPathConstraint().isInstance(container)) {
			MorelFuzzyResolveResult<edu.ustb.sei.mde.morel.Variable> frr = new MorelFuzzyResolveResult<edu.ustb.sei.mde.morel.Variable>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("pathVariable")) {
				pathConstraintPathVariableReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.morel.PathConstraint) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getVariableExp().isInstance(container)) {
			MorelFuzzyResolveResult<edu.ustb.sei.mde.morel.Variable> frr = new MorelFuzzyResolveResult<edu.ustb.sei.mde.morel.Variable>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("referredVariable")) {
				variableExpReferredVariableReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.morel.VariableExp) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypeLiteralExp().isInstance(container)) {
			MorelFuzzyResolveResult<org.eclipse.emf.ecore.EClassifier> frr = new MorelFuzzyResolveResult<org.eclipse.emf.ecore.EClassifier>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("value")) {
				typeLiteralExpValueReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.morel.TypeLiteralExp) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getEnumLiteralExp().isInstance(container)) {
			MorelFuzzyResolveResult<org.eclipse.emf.ecore.EEnum> frr = new MorelFuzzyResolveResult<org.eclipse.emf.ecore.EEnum>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("enumType")) {
				enumLiteralExpEnumTypeReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.morel.EnumLiteralExp) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getEnumLiteralExp().isInstance(container)) {
			MorelFuzzyResolveResult<org.eclipse.emf.ecore.EEnumLiteral> frr = new MorelFuzzyResolveResult<org.eclipse.emf.ecore.EEnumLiteral>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("enumSymbol")) {
				enumLiteralExpEnumSymbolReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.morel.EnumLiteralExp) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypedModel_Package()) {
			return getResolverChain(reference, typedModelPackageReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariable_Model()) {
			return getResolverChain(reference, objectVariableModelReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariable_Type()) {
			return getResolverChain(reference, objectVariableTypeReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariable_Type()) {
			return getResolverChain(reference, primitiveVariableTypeReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLinkConstraint_Source()) {
			return getResolverChain(reference, linkConstraintSourceReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint_Reference()) {
			return getResolverChain(reference, simpleLinkConstraintReferenceReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLinkConstraint_Target()) {
			return getResolverChain(reference, linkConstraintTargetReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getEnclosureLinkConstraint_Forward()) {
			return getResolverChain(reference, enclosureLinkConstraintForwardReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getEnclosureLinkConstraint_Types()) {
			return getResolverChain(reference, enclosureLinkConstraintTypesReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPathConstraint_References()) {
			return getResolverChain(reference, pathConstraintReferencesReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPathConstraint_Types()) {
			return getResolverChain(reference, pathConstraintTypesReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPathConstraint_PathVariable()) {
			return getResolverChain(reference, pathConstraintPathVariableReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getVariableExp_ReferredVariable()) {
			return getResolverChain(reference, variableExpReferredVariableReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypeLiteralExp_Value()) {
			return getResolverChain(reference, typeLiteralExpValueReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getEnumLiteralExp_EnumType()) {
			return getResolverChain(reference, enumLiteralExpEnumTypeReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getEnumLiteralExp_EnumSymbol()) {
			return getResolverChain(reference, enumLiteralExpEnumSymbolReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(edu.ustb.sei.mde.morel.resource.morel.IMorelOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new edu.ustb.sei.mde.morel.resource.morel.util.MorelRuntimeUtil().logWarning("Found value with invalid type for option " + edu.ustb.sei.mde.morel.resource.morel.IMorelOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver) {
			edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver replacingResolver = (edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver) resolverValue;
			if (replacingResolver instanceof edu.ustb.sei.mde.morel.resource.morel.IMorelDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((edu.ustb.sei.mde.morel.resource.morel.IMorelDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceCache) {
					edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver nextResolver = (edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver) next;
					if (nextResolver instanceof edu.ustb.sei.mde.morel.resource.morel.IMorelDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((edu.ustb.sei.mde.morel.resource.morel.IMorelDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new edu.ustb.sei.mde.morel.resource.morel.util.MorelRuntimeUtil().logWarning("Found value with invalid type in value map for option " + edu.ustb.sei.mde.morel.resource.morel.IMorelOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + edu.ustb.sei.mde.morel.resource.morel.IMorelDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new edu.ustb.sei.mde.morel.resource.morel.util.MorelRuntimeUtil().logWarning("Found value with invalid type in value map for option " + edu.ustb.sei.mde.morel.resource.morel.IMorelOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + edu.ustb.sei.mde.morel.resource.morel.IMorelDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
