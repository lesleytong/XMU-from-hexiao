/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

public class Xmu2ReferenceResolverSwitch implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.TransformationModelPackagesReferenceResolver transformationModelPackagesReferenceResolver = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.TransformationModelPackagesReferenceResolver();
	protected edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.EntryPointRuleReferenceResolver entryPointRuleReferenceResolver = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.EntryPointRuleReferenceResolver();
	protected edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.TypedElementTypeReferenceResolver typedElementTypeReferenceResolver = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.TypedElementTypeReferenceResolver();
	protected edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.PatternExpressionFeatureReferenceResolver patternExpressionFeatureReferenceResolver = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.PatternExpressionFeatureReferenceResolver();
	protected edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.EnumLiteralExpressionTypeReferenceResolver enumLiteralExpressionTypeReferenceResolver = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.EnumLiteralExpressionTypeReferenceResolver();
	protected edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.EnumLiteralExpressionValueReferenceResolver enumLiteralExpressionValueReferenceResolver = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.EnumLiteralExpressionValueReferenceResolver();
	protected edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.ObjectURIExpressionObjectReferenceResolver objectURIExpressionObjectReferenceResolver = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.ObjectURIExpressionObjectReferenceResolver();
	protected edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.RuleCallStatementRuleReferenceResolver ruleCallStatementRuleReferenceResolver = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.RuleCallStatementRuleReferenceResolver();
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<edu.ustb.sei.mde.xmu2.TransformationModel, org.eclipse.emf.ecore.EPackage> getTransformationModelPackagesReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel_Packages(), transformationModelPackagesReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<edu.ustb.sei.mde.xmu2.EntryPoint, edu.ustb.sei.mde.xmu2.ModelRule> getEntryPointRuleReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getEntryPoint_Rule(), entryPointRuleReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<edu.ustb.sei.mde.xmu2.TypedElement, org.eclipse.emf.ecore.EClassifier> getTypedElementTypeReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTypedElement_Type(), typedElementTypeReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<edu.ustb.sei.mde.xmu2.pattern.PatternExpression, org.eclipse.emf.ecore.EStructuralFeature> getPatternExpressionFeatureReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPatternExpression_Feature(), patternExpressionFeatureReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression, org.eclipse.emf.ecore.EEnum> getEnumLiteralExpressionTypeReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getEnumLiteralExpression_Type(), enumLiteralExpressionTypeReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression, org.eclipse.emf.ecore.EEnumLiteral> getEnumLiteralExpressionValueReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getEnumLiteralExpression_Value(), enumLiteralExpressionValueReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression, org.eclipse.emf.ecore.EObject> getObjectURIExpressionObjectReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getObjectURIExpression_Object(), objectURIExpressionObjectReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<edu.ustb.sei.mde.xmu2.statement.RuleCallStatement, edu.ustb.sei.mde.xmu2.AbstractRule> getRuleCallStatementRuleReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement_Rule(), ruleCallStatementRuleReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		transformationModelPackagesReferenceResolver.setOptions(options);
		entryPointRuleReferenceResolver.setOptions(options);
		typedElementTypeReferenceResolver.setOptions(options);
		patternExpressionFeatureReferenceResolver.setOptions(options);
		enumLiteralExpressionTypeReferenceResolver.setOptions(options);
		enumLiteralExpressionValueReferenceResolver.setOptions(options);
		objectURIExpressionObjectReferenceResolver.setOptions(options);
		ruleCallStatementRuleReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel().isInstance(container)) {
			Xmu2FuzzyResolveResult<org.eclipse.emf.ecore.EPackage> frr = new Xmu2FuzzyResolveResult<org.eclipse.emf.ecore.EPackage>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("packages")) {
				transformationModelPackagesReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu2.TransformationModel) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getEntryPoint().isInstance(container)) {
			Xmu2FuzzyResolveResult<edu.ustb.sei.mde.xmu2.ModelRule> frr = new Xmu2FuzzyResolveResult<edu.ustb.sei.mde.xmu2.ModelRule>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("rule")) {
				entryPointRuleReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu2.EntryPoint) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTypedElement().isInstance(container)) {
			Xmu2FuzzyResolveResult<org.eclipse.emf.ecore.EClassifier> frr = new Xmu2FuzzyResolveResult<org.eclipse.emf.ecore.EClassifier>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("type")) {
				typedElementTypeReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu2.TypedElement) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPatternExpression().isInstance(container)) {
			Xmu2FuzzyResolveResult<org.eclipse.emf.ecore.EStructuralFeature> frr = new Xmu2FuzzyResolveResult<org.eclipse.emf.ecore.EStructuralFeature>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("feature")) {
				patternExpressionFeatureReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu2.pattern.PatternExpression) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getEnumLiteralExpression().isInstance(container)) {
			Xmu2FuzzyResolveResult<org.eclipse.emf.ecore.EEnum> frr = new Xmu2FuzzyResolveResult<org.eclipse.emf.ecore.EEnum>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("type")) {
				enumLiteralExpressionTypeReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getEnumLiteralExpression().isInstance(container)) {
			Xmu2FuzzyResolveResult<org.eclipse.emf.ecore.EEnumLiteral> frr = new Xmu2FuzzyResolveResult<org.eclipse.emf.ecore.EEnumLiteral>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("value")) {
				enumLiteralExpressionValueReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getObjectURIExpression().isInstance(container)) {
			Xmu2FuzzyResolveResult<org.eclipse.emf.ecore.EObject> frr = new Xmu2FuzzyResolveResult<org.eclipse.emf.ecore.EObject>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("object")) {
				objectURIExpressionObjectReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement().isInstance(container)) {
			Xmu2FuzzyResolveResult<edu.ustb.sei.mde.xmu2.AbstractRule> frr = new Xmu2FuzzyResolveResult<edu.ustb.sei.mde.xmu2.AbstractRule>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("rule")) {
				ruleCallStatementRuleReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu2.statement.RuleCallStatement) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel_Packages()) {
			return getResolverChain(reference, transformationModelPackagesReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getEntryPoint_Rule()) {
			return getResolverChain(reference, entryPointRuleReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTypedElement_Type()) {
			return getResolverChain(reference, typedElementTypeReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPatternExpression_Feature()) {
			return getResolverChain(reference, patternExpressionFeatureReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getEnumLiteralExpression_Type()) {
			return getResolverChain(reference, enumLiteralExpressionTypeReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getEnumLiteralExpression_Value()) {
			return getResolverChain(reference, enumLiteralExpressionValueReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getObjectURIExpression_Object()) {
			return getResolverChain(reference, objectURIExpressionObjectReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement_Rule()) {
			return getResolverChain(reference, ruleCallStatementRuleReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Options.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2RuntimeUtil().logWarning("Found value with invalid type for option " + edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Options.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver) {
			edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver replacingResolver = (edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver) resolverValue;
			if (replacingResolver instanceof edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2DelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2DelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceCache) {
					edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver nextResolver = (edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolver) next;
					if (nextResolver instanceof edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2DelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2DelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2RuntimeUtil().logWarning("Found value with invalid type in value map for option " + edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Options.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2DelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2RuntimeUtil().logWarning("Found value with invalid type in value map for option " + edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Options.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2DelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
