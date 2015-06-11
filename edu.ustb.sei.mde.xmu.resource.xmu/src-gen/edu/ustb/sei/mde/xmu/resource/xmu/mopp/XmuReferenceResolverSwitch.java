/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

public class XmuReferenceResolverSwitch implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolverSwitch {
	
	/**
	 * This map stores a copy of the options the were set for loading the resource.
	 */
	private java.util.Map<Object, Object> options;
	
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.XMUModelPackagesReferenceResolver xMUModelPackagesReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XMUModelPackagesReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.StartStatementRuleReferenceResolver startStatementRuleReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.StartStatementRuleReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.ParameterVariableReferenceResolver parameterVariableReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.ParameterVariableReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.PrimitiveVariableTypeReferenceResolver primitiveVariableTypeReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.PrimitiveVariableTypeReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.UpdatedStatementSVarReferenceResolver updatedStatementSVarReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.UpdatedStatementSVarReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.UpdatedStatementVVarReferenceResolver updatedStatementVVarReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.UpdatedStatementVVarReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.PatternNodeVariableReferenceResolver patternNodeVariableReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.PatternNodeVariableReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.PatternNodeTypeReferenceResolver patternNodeTypeReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.PatternNodeTypeReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.PatternReferenceExprReferenceReferenceResolver patternReferenceExprReferenceReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.PatternReferenceExprReferenceReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.PatternEqualExprFeatureReferenceResolver patternEqualExprFeatureReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.PatternEqualExprFeatureReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.VariableExpVarReferenceResolver variableExpVarReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.VariableExpVarReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.EnumLiteralTypeReferenceResolver enumLiteralTypeReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.EnumLiteralTypeReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.EnumLiteralValueReferenceResolver enumLiteralValueReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.EnumLiteralValueReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.SwitchStatementVarReferenceResolver switchStatementVarReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.SwitchStatementVarReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.RuleCallStatementRuleReferenceResolver ruleCallStatementRuleReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.RuleCallStatementRuleReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.DeleteNodeVariableReferenceResolver deleteNodeVariableReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.DeleteNodeVariableReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.DeleteLinkSourceReferenceResolver deleteLinkSourceReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.DeleteLinkSourceReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.DeleteLinkFeatureReferenceResolver deleteLinkFeatureReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.DeleteLinkFeatureReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.DeleteLinkTargetReferenceResolver deleteLinkTargetReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.DeleteLinkTargetReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.AllInstanceExprTypeReferenceResolver allInstanceExprTypeReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.AllInstanceExprTypeReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.ObjectPathExprObjectReferenceResolver objectPathExprObjectReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.ObjectPathExprObjectReferenceResolver();
	protected edu.ustb.sei.mde.xmu.resource.xmu.analysis.HelperPathHelperReferenceResolver helperPathHelperReferenceResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.HelperPathHelperReferenceResolver();
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.XMUModel, org.eclipse.emf.ecore.EPackage> getXMUModelPackagesReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel_Packages(), xMUModelPackagesReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.StartStatement, edu.ustb.sei.mde.xmu.Rule> getStartStatementRuleReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStartStatement_Rule(), startStatementRuleReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.Parameter, edu.ustb.sei.mde.xmu.Variable> getParameterVariableReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParameter_Variable(), parameterVariableReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.PrimitiveVariable, org.eclipse.emf.ecore.EDataType> getPrimitiveVariableTypeReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrimitiveVariable_Type(), primitiveVariableTypeReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.UpdatedStatement, edu.ustb.sei.mde.xmu.Variable> getUpdatedStatementSVarReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUpdatedStatement_SVar(), updatedStatementSVarReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.UpdatedStatement, edu.ustb.sei.mde.xmu.Variable> getUpdatedStatementVVarReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUpdatedStatement_VVar(), updatedStatementVVarReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.PatternNode, edu.ustb.sei.mde.xmu.Variable> getPatternNodeVariableReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode_Variable(), patternNodeVariableReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.PatternNode, org.eclipse.emf.ecore.EClass> getPatternNodeTypeReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode_Type(), patternNodeTypeReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.PatternReferenceExpr, org.eclipse.emf.ecore.EReference> getPatternReferenceExprReferenceReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr_Reference(), patternReferenceExprReferenceReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.PatternEqualExpr, org.eclipse.emf.ecore.EStructuralFeature> getPatternEqualExprFeatureReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr_Feature(), patternEqualExprFeatureReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.VariableExp, edu.ustb.sei.mde.xmu.Variable> getVariableExpVarReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp_Var(), variableExpVarReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.EnumLiteral, org.eclipse.emf.ecore.EEnum> getEnumLiteralTypeReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getEnumLiteral_Type(), enumLiteralTypeReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.EnumLiteral, org.eclipse.emf.ecore.EEnumLiteral> getEnumLiteralValueReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getEnumLiteral_Value(), enumLiteralValueReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.SwitchStatement, edu.ustb.sei.mde.xmu.Variable> getSwitchStatementVarReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement_Var(), switchStatementVarReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.RuleCallStatement, edu.ustb.sei.mde.xmu.Rule> getRuleCallStatementRuleReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement_Rule(), ruleCallStatementRuleReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.DeleteNode, edu.ustb.sei.mde.xmu.ObjectVariable> getDeleteNodeVariableReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getDeleteNode_Variable(), deleteNodeVariableReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.DeleteLink, edu.ustb.sei.mde.xmu.ObjectVariable> getDeleteLinkSourceReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getDeleteLink_Source(), deleteLinkSourceReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.DeleteLink, org.eclipse.emf.ecore.EStructuralFeature> getDeleteLinkFeatureReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getDeleteLink_Feature(), deleteLinkFeatureReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.DeleteLink, edu.ustb.sei.mde.xmu.Variable> getDeleteLinkTargetReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getDeleteLink_Target(), deleteLinkTargetReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.AllInstanceExpr, org.eclipse.emf.ecore.EClass> getAllInstanceExprTypeReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAllInstanceExpr_Type(), allInstanceExprTypeReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.ObjectPathExpr, org.eclipse.emf.ecore.EObject> getObjectPathExprObjectReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getObjectPathExpr_Object(), objectPathExprObjectReferenceResolver);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<edu.ustb.sei.mde.xmu.HelperPath, edu.ustb.sei.mde.xmu.HelperMapping> getHelperPathHelperReferenceResolver() {
		return getResolverChain(edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getHelperPath_Helper(), helperPathHelperReferenceResolver);
	}
	
	public void setOptions(java.util.Map<?, ?> options) {
		if (options != null) {
			this.options = new java.util.LinkedHashMap<Object, Object>();
			this.options.putAll(options);
		}
		xMUModelPackagesReferenceResolver.setOptions(options);
		startStatementRuleReferenceResolver.setOptions(options);
		parameterVariableReferenceResolver.setOptions(options);
		primitiveVariableTypeReferenceResolver.setOptions(options);
		updatedStatementSVarReferenceResolver.setOptions(options);
		updatedStatementVVarReferenceResolver.setOptions(options);
		patternNodeVariableReferenceResolver.setOptions(options);
		patternNodeTypeReferenceResolver.setOptions(options);
		patternReferenceExprReferenceReferenceResolver.setOptions(options);
		patternEqualExprFeatureReferenceResolver.setOptions(options);
		variableExpVarReferenceResolver.setOptions(options);
		enumLiteralTypeReferenceResolver.setOptions(options);
		enumLiteralValueReferenceResolver.setOptions(options);
		switchStatementVarReferenceResolver.setOptions(options);
		ruleCallStatementRuleReferenceResolver.setOptions(options);
		deleteNodeVariableReferenceResolver.setOptions(options);
		deleteLinkSourceReferenceResolver.setOptions(options);
		deleteLinkFeatureReferenceResolver.setOptions(options);
		deleteLinkTargetReferenceResolver.setOptions(options);
		allInstanceExprTypeReferenceResolver.setOptions(options);
		objectPathExprObjectReferenceResolver.setOptions(options);
		helperPathHelperReferenceResolver.setOptions(options);
	}
	
	public void resolveFuzzy(String identifier, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, int position, edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolveResult<org.eclipse.emf.ecore.EObject> result) {
		if (container == null) {
			return;
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel().isInstance(container)) {
			XmuFuzzyResolveResult<org.eclipse.emf.ecore.EPackage> frr = new XmuFuzzyResolveResult<org.eclipse.emf.ecore.EPackage>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("packages")) {
				xMUModelPackagesReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.XMUModel) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStartStatement().isInstance(container)) {
			XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Rule> frr = new XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Rule>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("rule")) {
				startStatementRuleReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.StartStatement) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParameter().isInstance(container)) {
			XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Variable> frr = new XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Variable>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("variable")) {
				parameterVariableReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.Parameter) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrimitiveVariable().isInstance(container)) {
			XmuFuzzyResolveResult<org.eclipse.emf.ecore.EDataType> frr = new XmuFuzzyResolveResult<org.eclipse.emf.ecore.EDataType>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("type")) {
				primitiveVariableTypeReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.PrimitiveVariable) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUpdatedStatement().isInstance(container)) {
			XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Variable> frr = new XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Variable>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("sVar")) {
				updatedStatementSVarReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.UpdatedStatement) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUpdatedStatement().isInstance(container)) {
			XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Variable> frr = new XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Variable>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("vVar")) {
				updatedStatementVVarReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.UpdatedStatement) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode().isInstance(container)) {
			XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Variable> frr = new XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Variable>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("variable")) {
				patternNodeVariableReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.PatternNode) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode().isInstance(container)) {
			XmuFuzzyResolveResult<org.eclipse.emf.ecore.EClass> frr = new XmuFuzzyResolveResult<org.eclipse.emf.ecore.EClass>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("type")) {
				patternNodeTypeReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.PatternNode) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr().isInstance(container)) {
			XmuFuzzyResolveResult<org.eclipse.emf.ecore.EReference> frr = new XmuFuzzyResolveResult<org.eclipse.emf.ecore.EReference>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("reference")) {
				patternReferenceExprReferenceReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.PatternReferenceExpr) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr().isInstance(container)) {
			XmuFuzzyResolveResult<org.eclipse.emf.ecore.EStructuralFeature> frr = new XmuFuzzyResolveResult<org.eclipse.emf.ecore.EStructuralFeature>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("feature")) {
				patternEqualExprFeatureReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.PatternEqualExpr) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp().isInstance(container)) {
			XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Variable> frr = new XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Variable>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("var")) {
				variableExpVarReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.VariableExp) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getEnumLiteral().isInstance(container)) {
			XmuFuzzyResolveResult<org.eclipse.emf.ecore.EEnum> frr = new XmuFuzzyResolveResult<org.eclipse.emf.ecore.EEnum>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("type")) {
				enumLiteralTypeReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.EnumLiteral) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getEnumLiteral().isInstance(container)) {
			XmuFuzzyResolveResult<org.eclipse.emf.ecore.EEnumLiteral> frr = new XmuFuzzyResolveResult<org.eclipse.emf.ecore.EEnumLiteral>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("value")) {
				enumLiteralValueReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.EnumLiteral) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement().isInstance(container)) {
			XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Variable> frr = new XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Variable>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("var")) {
				switchStatementVarReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.SwitchStatement) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement().isInstance(container)) {
			XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Rule> frr = new XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Rule>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("rule")) {
				ruleCallStatementRuleReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.RuleCallStatement) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getDeleteNode().isInstance(container)) {
			XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.ObjectVariable> frr = new XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.ObjectVariable>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("variable")) {
				deleteNodeVariableReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.DeleteNode) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getDeleteLink().isInstance(container)) {
			XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.ObjectVariable> frr = new XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.ObjectVariable>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("source")) {
				deleteLinkSourceReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.DeleteLink) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getDeleteLink().isInstance(container)) {
			XmuFuzzyResolveResult<org.eclipse.emf.ecore.EStructuralFeature> frr = new XmuFuzzyResolveResult<org.eclipse.emf.ecore.EStructuralFeature>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("feature")) {
				deleteLinkFeatureReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.DeleteLink) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getDeleteLink().isInstance(container)) {
			XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Variable> frr = new XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.Variable>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("target")) {
				deleteLinkTargetReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.DeleteLink) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAllInstanceExpr().isInstance(container)) {
			XmuFuzzyResolveResult<org.eclipse.emf.ecore.EClass> frr = new XmuFuzzyResolveResult<org.eclipse.emf.ecore.EClass>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("type")) {
				allInstanceExprTypeReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.AllInstanceExpr) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getObjectPathExpr().isInstance(container)) {
			XmuFuzzyResolveResult<org.eclipse.emf.ecore.EObject> frr = new XmuFuzzyResolveResult<org.eclipse.emf.ecore.EObject>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("object")) {
				objectPathExprObjectReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.ObjectPathExpr) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
		if (edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getHelperPath().isInstance(container)) {
			XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.HelperMapping> frr = new XmuFuzzyResolveResult<edu.ustb.sei.mde.xmu.HelperMapping>(result);
			String referenceName = reference.getName();
			org.eclipse.emf.ecore.EStructuralFeature feature = container.eClass().getEStructuralFeature(referenceName);
			if (feature != null && feature instanceof org.eclipse.emf.ecore.EReference && referenceName != null && referenceName.equals("helper")) {
				helperPathHelperReferenceResolver.resolve(identifier, (edu.ustb.sei.mde.xmu.HelperPath) container, (org.eclipse.emf.ecore.EReference) feature, position, true, frr);
			}
		}
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<? extends org.eclipse.emf.ecore.EObject, ? extends org.eclipse.emf.ecore.EObject> getResolver(org.eclipse.emf.ecore.EStructuralFeature reference) {
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel_Packages()) {
			return getResolverChain(reference, xMUModelPackagesReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStartStatement_Rule()) {
			return getResolverChain(reference, startStatementRuleReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParameter_Variable()) {
			return getResolverChain(reference, parameterVariableReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrimitiveVariable_Type()) {
			return getResolverChain(reference, primitiveVariableTypeReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUpdatedStatement_SVar()) {
			return getResolverChain(reference, updatedStatementSVarReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUpdatedStatement_VVar()) {
			return getResolverChain(reference, updatedStatementVVarReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode_Variable()) {
			return getResolverChain(reference, patternNodeVariableReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode_Type()) {
			return getResolverChain(reference, patternNodeTypeReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr_Reference()) {
			return getResolverChain(reference, patternReferenceExprReferenceReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr_Feature()) {
			return getResolverChain(reference, patternEqualExprFeatureReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp_Var()) {
			return getResolverChain(reference, variableExpVarReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getEnumLiteral_Type()) {
			return getResolverChain(reference, enumLiteralTypeReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getEnumLiteral_Value()) {
			return getResolverChain(reference, enumLiteralValueReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement_Var()) {
			return getResolverChain(reference, switchStatementVarReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement_Rule()) {
			return getResolverChain(reference, ruleCallStatementRuleReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getDeleteNode_Variable()) {
			return getResolverChain(reference, deleteNodeVariableReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getDeleteLink_Source()) {
			return getResolverChain(reference, deleteLinkSourceReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getDeleteLink_Feature()) {
			return getResolverChain(reference, deleteLinkFeatureReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getDeleteLink_Target()) {
			return getResolverChain(reference, deleteLinkTargetReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAllInstanceExpr_Type()) {
			return getResolverChain(reference, allInstanceExprTypeReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getObjectPathExpr_Object()) {
			return getResolverChain(reference, objectPathExprObjectReferenceResolver);
		}
		if (reference == edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getHelperPath_Helper()) {
			return getResolverChain(reference, helperPathHelperReferenceResolver);
		}
		return null;
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})	
	public <ContainerType extends org.eclipse.emf.ecore.EObject, ReferenceType extends org.eclipse.emf.ecore.EObject> edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<ContainerType, ReferenceType> getResolverChain(org.eclipse.emf.ecore.EStructuralFeature reference, edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver<ContainerType, ReferenceType> originalResolver) {
		if (options == null) {
			return originalResolver;
		}
		Object value = options.get(edu.ustb.sei.mde.xmu.resource.xmu.IXmuOptions.ADDITIONAL_REFERENCE_RESOLVERS);
		if (value == null) {
			return originalResolver;
		}
		if (!(value instanceof java.util.Map)) {
			// send this to the error log
			new edu.ustb.sei.mde.xmu.resource.xmu.util.XmuRuntimeUtil().logWarning("Found value with invalid type for option " + edu.ustb.sei.mde.xmu.resource.xmu.IXmuOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + java.util.Map.class.getName() + ", but was " + value.getClass().getName() + ")", null);
			return originalResolver;
		}
		java.util.Map<?,?> resolverMap = (java.util.Map<?,?>) value;
		Object resolverValue = resolverMap.get(reference);
		if (resolverValue == null) {
			return originalResolver;
		}
		if (resolverValue instanceof edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver) {
			edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver replacingResolver = (edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver) resolverValue;
			if (replacingResolver instanceof edu.ustb.sei.mde.xmu.resource.xmu.IXmuDelegatingReferenceResolver) {
				// pass original resolver to the replacing one
				((edu.ustb.sei.mde.xmu.resource.xmu.IXmuDelegatingReferenceResolver) replacingResolver).setDelegate(originalResolver);
			}
			return replacingResolver;
		} else if (resolverValue instanceof java.util.Collection) {
			java.util.Collection replacingResolvers = (java.util.Collection) resolverValue;
			edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver replacingResolver = originalResolver;
			for (Object next : replacingResolvers) {
				if (next instanceof edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceCache) {
					edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver nextResolver = (edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolver) next;
					if (nextResolver instanceof edu.ustb.sei.mde.xmu.resource.xmu.IXmuDelegatingReferenceResolver) {
						// pass original resolver to the replacing one
						((edu.ustb.sei.mde.xmu.resource.xmu.IXmuDelegatingReferenceResolver) nextResolver).setDelegate(replacingResolver);
					}
					replacingResolver = nextResolver;
				} else {
					// The collection contains a non-resolver. Send a warning to the error log.
					new edu.ustb.sei.mde.xmu.resource.xmu.util.XmuRuntimeUtil().logWarning("Found value with invalid type in value map for option " + edu.ustb.sei.mde.xmu.resource.xmu.IXmuOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + edu.ustb.sei.mde.xmu.resource.xmu.IXmuDelegatingReferenceResolver.class.getName() + ", but was " + next.getClass().getName() + ")", null);
				}
			}
			return replacingResolver;
		} else {
			// The value for the option ADDITIONAL_REFERENCE_RESOLVERS has an unknown type.
			new edu.ustb.sei.mde.xmu.resource.xmu.util.XmuRuntimeUtil().logWarning("Found value with invalid type in value map for option " + edu.ustb.sei.mde.xmu.resource.xmu.IXmuOptions.ADDITIONAL_REFERENCE_RESOLVERS + " (expected " + edu.ustb.sei.mde.xmu.resource.xmu.IXmuDelegatingReferenceResolver.class.getName() + ", but was " + resolverValue.getClass().getName() + ")", null);
			return originalResolver;
		}
	}
	
}
