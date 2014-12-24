/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

public class MorelSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypedModel(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQuery(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariable(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariable(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getObjectVariableWithInit(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPrimitiveVariableWithInit(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getSimpleLinkConstraint(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getEnclosureLinkConstraint(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPathConstraint(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getVariableExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getNestedExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIntegerLiteralExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRealLiteralExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getStringLiteralExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanLiteralExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUndefinedLiteralExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTypeLiteralExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getCollectionLiteralExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getEnumLiteralExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getArrayLiteralExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getFeaturePathExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOperationPathExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIteratorPathExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getLetExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getConditionExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanImpliesExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanOrExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBooleanAndExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRelationalExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAdditiveExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getMultiplicativeExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getUnaryExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBindExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedBindExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getDeclarativeStatement(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getIfStatement(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getForStatement(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getBlockStatement(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRule(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getRuleGroup(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPattern(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getPredefinedVariableExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getReflectiveVariableExp(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getOrderConstraint(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getAllDifferentConstraint(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getQueryModel(),
			edu.ustb.sei.mde.morel.MorelPackage.eINSTANCE.getTransformationModel(),
		};
	}
	
}
