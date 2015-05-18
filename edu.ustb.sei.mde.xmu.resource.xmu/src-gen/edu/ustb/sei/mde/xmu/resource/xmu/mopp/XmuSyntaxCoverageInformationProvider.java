/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

public class XmuSyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStartStatement(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStartRoot(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRule(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParameter(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrimitiveVariable(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getForStatement(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUpdatedStatement(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVStatement(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPattern(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternNode(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternReferenceExpr(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPatternEqualExpr(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getVariableExp(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getFeaturePath(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getLoopPath(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getOperationPath(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getStringLiteral(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getEmptyLiteral(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getIntegerLiteral(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanLiteral(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getEnumLiteral(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBlockStatement(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getSwitchStatement(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCasePatternStatement(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getCaseValueStatement(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRuleCallStatement(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUpdatePattern(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getDeleteNode(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getDeleteLink(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanOrExpr(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getBooleanAndExpr(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getRelationalExpr(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAdditiveExpr(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getMultiplicativeExpr(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getParenExpr(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getUnaryExpr(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getPrintStatement(),
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getAllInstanceExpr(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			edu.ustb.sei.mde.xmu.XmuPackage.eINSTANCE.getXMUModel(),
		};
	}
	
}
