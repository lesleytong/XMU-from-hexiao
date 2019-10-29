/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

public class Xmu2SyntaxCoverageInformationProvider {
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new org.eclipse.emf.ecore.EClass[] {
			edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(),
			edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getEntryPoint(),
			edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getEntryData(),
			edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getModelRule(),
			edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getArithmeticRule(),
			edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getConcreteVariableDeclaration(),
			edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getParameter(),
			edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPattern(),
			edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPatternNode(),
			edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getObjectPatternExpression(),
			edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getPropertyPatternExpression(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getLoopPath(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getFeaturePath(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getOperationPath(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPositionPath(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getVariableExpression(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getPathExpression(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getEmptyExpression(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getStringLiteralExpression(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getIntegerLiteralExpression(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanLiteralExpression(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getEnumLiteralExpression(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getObjectURIExpression(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getParenExpression(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getUnaryExpression(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getMultiplicativeExpression(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getAdditiveExpression(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getRelationalExpression(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanAndExpression(),
			edu.ustb.sei.mde.xmu2.expression.ExpressionPackage.eINSTANCE.getBooleanOrExpression(),
			edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getBlockStatement(),
			edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateStatement(),
			edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSwitchStatement(),
			edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getUpdateClause(),
			edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getPatternCaseClause(),
			edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getExpressionCaseClause(),
			edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDeleteNodeStatement(),
			edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getConcreteDeleteLinkStatement(),
			edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getEnforcePatternStatement(),
			edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getForEachStatement(),
			edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getRuleCallStatement(),
			edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getSkip(),
			edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getFail(),
			edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getDefaultCaseClause(),
			edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getAssignStatement(),
			edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getReflectiveVariableDeclaration(),
			edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePatternNode(),
			edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectiveObjectPatternExpression(),
			edu.ustb.sei.mde.xmu2.pattern.PatternPackage.eINSTANCE.getReflectivePropertyPatternExpression(),
			edu.ustb.sei.mde.xmu2.statement.StatementPackage.eINSTANCE.getReflectiveDeleteLinkStatement(),
		};
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new org.eclipse.emf.ecore.EClass[] {
			edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(),
		};
	}
	
}
