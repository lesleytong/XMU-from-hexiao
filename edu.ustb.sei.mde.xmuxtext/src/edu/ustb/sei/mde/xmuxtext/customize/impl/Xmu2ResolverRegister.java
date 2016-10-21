package edu.ustb.sei.mde.xmuxtext.customize.impl;

import edu.ustb.sei.mde.xmu2.Xmu2Package;
import edu.ustb.sei.mde.xmu2.expression.ExpressionPackage;
import edu.ustb.sei.mde.xmu2.pattern.PatternPackage;
import edu.ustb.sei.mde.xmuxtext.customize.common.DefaultResolverRegister;

public class Xmu2ResolverRegister extends DefaultResolverRegister{

	public Xmu2ResolverRegister() {
		super();
	}

	@Override
	public void init() {
		this.referenceResolverForLinkingService.put(Xmu2Package.Literals.TRANSFORMATION_MODEL__PACKAGES, new TransformationModelPackagesResolver());
		
		this.referenceResolverForScopingService.put(Xmu2Package.Literals.TYPED_ELEMENT__TYPE, new TypeResolver());
		this.referenceResolverForScopingService.put(ExpressionPackage.Literals.ENUM_LITERAL_EXPRESSION__TYPE, new EnumTypeResolver());
		this.referenceResolverForScopingService.put(ExpressionPackage.Literals.ENUM_LITERAL_EXPRESSION__VALUE, new EnumLiteralResolver());
		this.referenceResolverForScopingService.put(PatternPackage.Literals.PATTERN_EXPRESSION__FEATURE, new PatternExpressionFeatureResolver());
	}
}
