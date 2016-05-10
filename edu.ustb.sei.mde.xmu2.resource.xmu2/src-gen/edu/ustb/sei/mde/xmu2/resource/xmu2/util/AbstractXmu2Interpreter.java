/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.util;

/**
 * This class provides basic infrastructure to interpret models. To implement
 * concrete interpreters, subclass this abstract interpreter and override the
 * interprete_* methods. The interpretation can be customized by binding the two
 * type parameters (ResultType, ContextType). The former is returned by all
 * interprete_* methods, while the latter is passed from method to method while
 * traversing the model. The concrete traversal strategy can also be exchanged.
 * One can use a static traversal strategy by pushing all objects to interpret on
 * the interpretation stack (using addObjectToInterprete()) before calling
 * interprete(). Alternatively, the traversal strategy can be dynamic by pushing
 * objects on the interpretation stack during interpretation.
 */
public class AbstractXmu2Interpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2InterpreterListener> listeners = new java.util.ArrayList<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2InterpreterListener>();
	private org.eclipse.emf.ecore.EObject nextObjectToInterprete;
	private Object currentContext;
	
	public ResultType interprete(ContextType context) {
		ResultType result = null;
		org.eclipse.emf.ecore.EObject next = null;
		currentContext = context;
		while (!interpretationStack.empty()) {
			try {
				next = interpretationStack.pop();
			} catch (java.util.EmptyStackException ese) {
				// this can happen when the interpreter was terminated between the call to empty()
				// and pop()
				break;
			}
			nextObjectToInterprete = next;
			notifyListeners(next);
			result = interprete(next, context);
			if (!continueInterpretation(context, result)) {
				break;
			}
		}
		currentContext = null;
		return result;
	}
	
	/**
	 * Override this method to stop the overall interpretation depending on the result
	 * of the interpretation of a single model elements.
	 */
	public boolean continueInterpretation(ContextType context, ResultType result) {
		return true;
	}
	
	public ResultType interprete(org.eclipse.emf.ecore.EObject object, ContextType context) {
		ResultType result = null;
		if (object instanceof edu.ustb.sei.mde.xmu2.NamedElement) {
			result = interprete_edu_ustb_sei_mde_xmu2_NamedElement((edu.ustb.sei.mde.xmu2.NamedElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.TransformationModel) {
			result = interprete_edu_ustb_sei_mde_xmu2_TransformationModel((edu.ustb.sei.mde.xmu2.TransformationModel) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.EntryPoint) {
			result = interprete_edu_ustb_sei_mde_xmu2_EntryPoint((edu.ustb.sei.mde.xmu2.EntryPoint) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.EntryData) {
			result = interprete_edu_ustb_sei_mde_xmu2_EntryData((edu.ustb.sei.mde.xmu2.EntryData) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.AbstractRule) {
			result = interprete_edu_ustb_sei_mde_xmu2_AbstractRule((edu.ustb.sei.mde.xmu2.AbstractRule) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.Parameter) {
			result = interprete_edu_ustb_sei_mde_xmu2_Parameter((edu.ustb.sei.mde.xmu2.Parameter) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.ModelRule) {
			result = interprete_edu_ustb_sei_mde_xmu2_ModelRule((edu.ustb.sei.mde.xmu2.ModelRule) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.ArithmeticRule) {
			result = interprete_edu_ustb_sei_mde_xmu2_ArithmeticRule((edu.ustb.sei.mde.xmu2.ArithmeticRule) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.VariableDeclaration) {
			result = interprete_edu_ustb_sei_mde_xmu2_VariableDeclaration((edu.ustb.sei.mde.xmu2.VariableDeclaration) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.TypedElement) {
			result = interprete_edu_ustb_sei_mde_xmu2_TypedElement((edu.ustb.sei.mde.xmu2.TypedElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EAttribute) {
			result = interprete_org_eclipse_emf_ecore_EAttribute((org.eclipse.emf.ecore.EAttribute) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EAnnotation) {
			result = interprete_org_eclipse_emf_ecore_EAnnotation((org.eclipse.emf.ecore.EAnnotation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EClass) {
			result = interprete_org_eclipse_emf_ecore_EClass((org.eclipse.emf.ecore.EClass) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EEnum) {
			result = interprete_org_eclipse_emf_ecore_EEnum((org.eclipse.emf.ecore.EEnum) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EDataType) {
			result = interprete_org_eclipse_emf_ecore_EDataType((org.eclipse.emf.ecore.EDataType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EClassifier) {
			result = interprete_org_eclipse_emf_ecore_EClassifier((org.eclipse.emf.ecore.EClassifier) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EEnumLiteral) {
			result = interprete_org_eclipse_emf_ecore_EEnumLiteral((org.eclipse.emf.ecore.EEnumLiteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EFactory) {
			result = interprete_org_eclipse_emf_ecore_EFactory((org.eclipse.emf.ecore.EFactory) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EOperation) {
			result = interprete_org_eclipse_emf_ecore_EOperation((org.eclipse.emf.ecore.EOperation) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.ENamedElement) {
			result = interprete_org_eclipse_emf_ecore_ENamedElement((org.eclipse.emf.ecore.ENamedElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EModelElement) {
			result = interprete_org_eclipse_emf_ecore_EModelElement((org.eclipse.emf.ecore.EModelElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EObject) {
			result = interprete_org_eclipse_emf_ecore_EObject((org.eclipse.emf.ecore.EObject) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EPackage) {
			result = interprete_org_eclipse_emf_ecore_EPackage((org.eclipse.emf.ecore.EPackage) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EParameter) {
			result = interprete_org_eclipse_emf_ecore_EParameter((org.eclipse.emf.ecore.EParameter) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EReference) {
			result = interprete_org_eclipse_emf_ecore_EReference((org.eclipse.emf.ecore.EReference) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EStructuralFeature) {
			result = interprete_org_eclipse_emf_ecore_EStructuralFeature((org.eclipse.emf.ecore.EStructuralFeature) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.ETypedElement) {
			result = interprete_org_eclipse_emf_ecore_ETypedElement((org.eclipse.emf.ecore.ETypedElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof java.util.Map.Entry<?,?>) {
			result = interprete_java_util_Map_Entry((java.util.Map.Entry<?,?>) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.EGenericType) {
			result = interprete_org_eclipse_emf_ecore_EGenericType((org.eclipse.emf.ecore.EGenericType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof org.eclipse.emf.ecore.ETypeParameter) {
			result = interprete_org_eclipse_emf_ecore_ETypeParameter((org.eclipse.emf.ecore.ETypeParameter) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.UpdateStatement) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_UpdateStatement((edu.ustb.sei.mde.xmu2.statement.UpdateStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.SwitchStatement) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_SwitchStatement((edu.ustb.sei.mde.xmu2.statement.SwitchStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_DeleteNodeStatement((edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.Statement) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_Statement((edu.ustb.sei.mde.xmu2.statement.Statement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.UpdateClause) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_UpdateClause((edu.ustb.sei.mde.xmu2.statement.UpdateClause) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.PatternCaseClause) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_PatternCaseClause((edu.ustb.sei.mde.xmu2.statement.PatternCaseClause) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_ExpressionCaseClause((edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.DefaultCaseClause) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_DefaultCaseClause((edu.ustb.sei.mde.xmu2.statement.DefaultCaseClause) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.DefaultCaseStatement) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_DefaultCaseStatement((edu.ustb.sei.mde.xmu2.statement.DefaultCaseStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.CaseClause) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_CaseClause((edu.ustb.sei.mde.xmu2.statement.CaseClause) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_EnforcePatternStatement((edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_DeleteLinkStatement((edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.UnidirectionalStatement) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_UnidirectionalStatement((edu.ustb.sei.mde.xmu2.statement.UnidirectionalStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.BidirectionalStatement) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_BidirectionalStatement((edu.ustb.sei.mde.xmu2.statement.BidirectionalStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.ForEachStatement) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_ForEachStatement((edu.ustb.sei.mde.xmu2.statement.ForEachStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.BlockStatement) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_BlockStatement((edu.ustb.sei.mde.xmu2.statement.BlockStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.RuleCallStatement) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement((edu.ustb.sei.mde.xmu2.statement.RuleCallStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.Skip) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_Skip((edu.ustb.sei.mde.xmu2.statement.Skip) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.statement.PsesudoStatement) {
			result = interprete_edu_ustb_sei_mde_xmu2_statement_PsesudoStatement((edu.ustb.sei.mde.xmu2.statement.PsesudoStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.pattern.Pattern) {
			result = interprete_edu_ustb_sei_mde_xmu2_pattern_Pattern((edu.ustb.sei.mde.xmu2.pattern.Pattern) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.pattern.PatternNode) {
			result = interprete_edu_ustb_sei_mde_xmu2_pattern_PatternNode((edu.ustb.sei.mde.xmu2.pattern.PatternNode) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_pattern_ObjectPatternExpression((edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_pattern_PropertyPatternExpression((edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.pattern.PatternExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_pattern_PatternExpression((edu.ustb.sei.mde.xmu2.pattern.PatternExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression((edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression((edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.RelationalExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_RelationalExpression((edu.ustb.sei.mde.xmu2.expression.RelationalExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.AdditiveExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression((edu.ustb.sei.mde.xmu2.expression.AdditiveExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression((edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.UnaryExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_UnaryExpression((edu.ustb.sei.mde.xmu2.expression.UnaryExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.AtomicExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_AtomicExpression((edu.ustb.sei.mde.xmu2.expression.AtomicExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.PathExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_PathExpression((edu.ustb.sei.mde.xmu2.expression.PathExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.VariableExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_VariableExpression((edu.ustb.sei.mde.xmu2.expression.VariableExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.EmptyExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_EmptyExpression((edu.ustb.sei.mde.xmu2.expression.EmptyExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_StringLiteralExpression((edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_IntegerLiteralExpression((edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_BooleanLiteralExpression((edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_EnumLiteralExpression((edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_ObjectURIExpression((edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.ConstantExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_ConstantExpression((edu.ustb.sei.mde.xmu2.expression.ConstantExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.ParenExpression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_ParenExpression((edu.ustb.sei.mde.xmu2.expression.ParenExpression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.UnaryExpressionChild) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_UnaryExpressionChild((edu.ustb.sei.mde.xmu2.expression.UnaryExpressionChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpressionChild) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpressionChild((edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpressionChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.AdditiveExpressionChild) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_AdditiveExpressionChild((edu.ustb.sei.mde.xmu2.expression.AdditiveExpressionChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.RelationalExpressionChild) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_RelationalExpressionChild((edu.ustb.sei.mde.xmu2.expression.RelationalExpressionChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.BooleanAndExpressionChild) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpressionChild((edu.ustb.sei.mde.xmu2.expression.BooleanAndExpressionChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.BooleanOrExpressionChild) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpressionChild((edu.ustb.sei.mde.xmu2.expression.BooleanOrExpressionChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.Expression) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_Expression((edu.ustb.sei.mde.xmu2.expression.Expression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.FeaturePath) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_FeaturePath((edu.ustb.sei.mde.xmu2.expression.FeaturePath) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.OperationPath) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_OperationPath((edu.ustb.sei.mde.xmu2.expression.OperationPath) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.LoopPath) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_LoopPath((edu.ustb.sei.mde.xmu2.expression.LoopPath) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.PositionPath) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_PositionPath((edu.ustb.sei.mde.xmu2.expression.PositionPath) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2.expression.Path) {
			result = interprete_edu_ustb_sei_mde_xmu2_expression_Path((edu.ustb.sei.mde.xmu2.expression.Path) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2common.DomainElement) {
			result = interprete_edu_ustb_sei_mde_xmu2common_DomainElement((edu.ustb.sei.mde.xmu2common.DomainElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu2common.NamedElement) {
			result = interprete_edu_ustb_sei_mde_xmu2common_NamedElement((edu.ustb.sei.mde.xmu2common.NamedElement) object, context);
		}
		if (result != null) {
			return result;
		}
		return result;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_NamedElement(edu.ustb.sei.mde.xmu2.NamedElement namedElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_TransformationModel(edu.ustb.sei.mde.xmu2.TransformationModel transformationModel, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_EntryPoint(edu.ustb.sei.mde.xmu2.EntryPoint entryPoint, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_EntryData(edu.ustb.sei.mde.xmu2.EntryData entryData, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_AbstractRule(edu.ustb.sei.mde.xmu2.AbstractRule abstractRule, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_Parameter(edu.ustb.sei.mde.xmu2.Parameter parameter, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_ModelRule(edu.ustb.sei.mde.xmu2.ModelRule modelRule, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_ArithmeticRule(edu.ustb.sei.mde.xmu2.ArithmeticRule arithmeticRule, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_VariableDeclaration(edu.ustb.sei.mde.xmu2.VariableDeclaration variableDeclaration, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_TypedElement(edu.ustb.sei.mde.xmu2.TypedElement typedElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EAttribute(org.eclipse.emf.ecore.EAttribute eAttribute, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EAnnotation(org.eclipse.emf.ecore.EAnnotation eAnnotation, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EClass(org.eclipse.emf.ecore.EClass eClass, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EClassifier(org.eclipse.emf.ecore.EClassifier eClassifier, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EDataType(org.eclipse.emf.ecore.EDataType eDataType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EEnum(org.eclipse.emf.ecore.EEnum eEnum, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EEnumLiteral(org.eclipse.emf.ecore.EEnumLiteral eEnumLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EFactory(org.eclipse.emf.ecore.EFactory eFactory, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EModelElement(org.eclipse.emf.ecore.EModelElement eModelElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_ENamedElement(org.eclipse.emf.ecore.ENamedElement eNamedElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EObject(org.eclipse.emf.ecore.EObject eObject, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EOperation(org.eclipse.emf.ecore.EOperation eOperation, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EPackage(org.eclipse.emf.ecore.EPackage ePackage, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EParameter(org.eclipse.emf.ecore.EParameter eParameter, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EReference(org.eclipse.emf.ecore.EReference eReference, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EStructuralFeature(org.eclipse.emf.ecore.EStructuralFeature eStructuralFeature, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_ETypedElement(org.eclipse.emf.ecore.ETypedElement eTypedElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_java_util_Map_Entry(java.util.Map.Entry<?,?> eStringToStringMapEntry, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_EGenericType(org.eclipse.emf.ecore.EGenericType eGenericType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_org_eclipse_emf_ecore_ETypeParameter(org.eclipse.emf.ecore.ETypeParameter eTypeParameter, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_Statement(edu.ustb.sei.mde.xmu2.statement.Statement statement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_UpdateStatement(edu.ustb.sei.mde.xmu2.statement.UpdateStatement updateStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_SwitchStatement(edu.ustb.sei.mde.xmu2.statement.SwitchStatement switchStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_UpdateClause(edu.ustb.sei.mde.xmu2.statement.UpdateClause updateClause, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_CaseClause(edu.ustb.sei.mde.xmu2.statement.CaseClause caseClause, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_PatternCaseClause(edu.ustb.sei.mde.xmu2.statement.PatternCaseClause patternCaseClause, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_ExpressionCaseClause(edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause expressionCaseClause, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_DefaultCaseClause(edu.ustb.sei.mde.xmu2.statement.DefaultCaseClause defaultCaseClause, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_DefaultCaseStatement(edu.ustb.sei.mde.xmu2.statement.DefaultCaseStatement defaultCaseStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_UnidirectionalStatement(edu.ustb.sei.mde.xmu2.statement.UnidirectionalStatement unidirectionalStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_BidirectionalStatement(edu.ustb.sei.mde.xmu2.statement.BidirectionalStatement bidirectionalStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_EnforcePatternStatement(edu.ustb.sei.mde.xmu2.statement.EnforcePatternStatement enforcePatternStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_DeleteNodeStatement(edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement deleteNodeStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_DeleteLinkStatement(edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement deleteLinkStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_ForEachStatement(edu.ustb.sei.mde.xmu2.statement.ForEachStatement forEachStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_BlockStatement(edu.ustb.sei.mde.xmu2.statement.BlockStatement blockStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_RuleCallStatement(edu.ustb.sei.mde.xmu2.statement.RuleCallStatement ruleCallStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_PsesudoStatement(edu.ustb.sei.mde.xmu2.statement.PsesudoStatement psesudoStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_statement_Skip(edu.ustb.sei.mde.xmu2.statement.Skip skip, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_pattern_Pattern(edu.ustb.sei.mde.xmu2.pattern.Pattern pattern, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_pattern_PatternNode(edu.ustb.sei.mde.xmu2.pattern.PatternNode patternNode, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_pattern_PatternExpression(edu.ustb.sei.mde.xmu2.pattern.PatternExpression patternExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_pattern_ObjectPatternExpression(edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression objectPatternExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_pattern_PropertyPatternExpression(edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression propertyPatternExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_Expression(edu.ustb.sei.mde.xmu2.expression.Expression expression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpression(edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression booleanOrExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_BooleanOrExpressionChild(edu.ustb.sei.mde.xmu2.expression.BooleanOrExpressionChild booleanOrExpressionChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpression(edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression booleanAndExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_BooleanAndExpressionChild(edu.ustb.sei.mde.xmu2.expression.BooleanAndExpressionChild booleanAndExpressionChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_RelationalExpression(edu.ustb.sei.mde.xmu2.expression.RelationalExpression relationalExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_RelationalExpressionChild(edu.ustb.sei.mde.xmu2.expression.RelationalExpressionChild relationalExpressionChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_AdditiveExpression(edu.ustb.sei.mde.xmu2.expression.AdditiveExpression additiveExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_AdditiveExpressionChild(edu.ustb.sei.mde.xmu2.expression.AdditiveExpressionChild additiveExpressionChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpression(edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression multiplicativeExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_MultiplicativeExpressionChild(edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpressionChild multiplicativeExpressionChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_UnaryExpression(edu.ustb.sei.mde.xmu2.expression.UnaryExpression unaryExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_UnaryExpressionChild(edu.ustb.sei.mde.xmu2.expression.UnaryExpressionChild unaryExpressionChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_AtomicExpression(edu.ustb.sei.mde.xmu2.expression.AtomicExpression atomicExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_PathExpression(edu.ustb.sei.mde.xmu2.expression.PathExpression pathExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_VariableExpression(edu.ustb.sei.mde.xmu2.expression.VariableExpression variableExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_ConstantExpression(edu.ustb.sei.mde.xmu2.expression.ConstantExpression constantExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_EmptyExpression(edu.ustb.sei.mde.xmu2.expression.EmptyExpression emptyExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_StringLiteralExpression(edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression stringLiteralExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_IntegerLiteralExpression(edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression integerLiteralExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_BooleanLiteralExpression(edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression booleanLiteralExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_EnumLiteralExpression(edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression enumLiteralExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_ParenExpression(edu.ustb.sei.mde.xmu2.expression.ParenExpression parenExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_ObjectURIExpression(edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression objectURIExpression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_Path(edu.ustb.sei.mde.xmu2.expression.Path path, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_FeaturePath(edu.ustb.sei.mde.xmu2.expression.FeaturePath featurePath, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_OperationPath(edu.ustb.sei.mde.xmu2.expression.OperationPath operationPath, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_LoopPath(edu.ustb.sei.mde.xmu2.expression.LoopPath loopPath, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2_expression_PositionPath(edu.ustb.sei.mde.xmu2.expression.PositionPath positionPath, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2common_DomainElement(edu.ustb.sei.mde.xmu2common.DomainElement domainElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu2common_NamedElement(edu.ustb.sei.mde.xmu2common.NamedElement namedElement, ContextType context) {
		return null;
	}
	
	private void notifyListeners(org.eclipse.emf.ecore.EObject element) {
		for (edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2InterpreterListener listener : listeners) {
			listener.handleInterpreteObject(element);
		}
	}
	
	/**
	 * Adds the given object to the interpretation stack. Attention: Objects that are
	 * added first, are interpret last.
	 */
	public void addObjectToInterprete(org.eclipse.emf.ecore.EObject object) {
		interpretationStack.push(object);
	}
	
	/**
	 * Adds the given collection of objects to the interpretation stack. Attention:
	 * Collections that are added first, are interpret last.
	 */
	public void addObjectsToInterprete(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		for (org.eclipse.emf.ecore.EObject object : objects) {
			addObjectToInterprete(object);
		}
	}
	
	/**
	 * Adds the given collection of objects in reverse order to the interpretation
	 * stack.
	 */
	public void addObjectsToInterpreteInReverseOrder(java.util.Collection<? extends org.eclipse.emf.ecore.EObject> objects) {
		java.util.List<org.eclipse.emf.ecore.EObject> reverse = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>(objects.size());
		reverse.addAll(objects);
		java.util.Collections.reverse(reverse);
		addObjectsToInterprete(reverse);
	}
	
	/**
	 * Adds the given object and all its children to the interpretation stack such
	 * that they are interpret in top down order.
	 */
	public void addObjectTreeToInterpreteTopDown(org.eclipse.emf.ecore.EObject root) {
		java.util.List<org.eclipse.emf.ecore.EObject> objects = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		objects.add(root);
		java.util.Iterator<org.eclipse.emf.ecore.EObject> it = root.eAllContents();
		while (it.hasNext()) {
			org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) it.next();
			objects.add(eObject);
		}
		addObjectsToInterpreteInReverseOrder(objects);
	}
	
	public void addListener(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2InterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2InterpreterListener listener) {
		return listeners.remove(listener);
	}
	
	public org.eclipse.emf.ecore.EObject getNextObjectToInterprete() {
		return nextObjectToInterprete;
	}
	
	public java.util.Stack<org.eclipse.emf.ecore.EObject> getInterpretationStack() {
		return interpretationStack;
	}
	
	public void terminate() {
		interpretationStack.clear();
	}
	
	public Object getCurrentContext() {
		return currentContext;
	}
	
}
