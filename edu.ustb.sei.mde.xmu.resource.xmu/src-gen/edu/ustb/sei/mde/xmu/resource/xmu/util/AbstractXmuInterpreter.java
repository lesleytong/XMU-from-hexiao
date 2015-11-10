/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.util;

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
public class AbstractXmuInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<edu.ustb.sei.mde.xmu.resource.xmu.IXmuInterpreterListener> listeners = new java.util.ArrayList<edu.ustb.sei.mde.xmu.resource.xmu.IXmuInterpreterListener>();
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
		if (object instanceof edu.ustb.sei.mde.xmu.ObjectVariable) {
			result = interprete_edu_ustb_sei_mde_xmu_ObjectVariable((edu.ustb.sei.mde.xmu.ObjectVariable) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.PrimitiveVariable) {
			result = interprete_edu_ustb_sei_mde_xmu_PrimitiveVariable((edu.ustb.sei.mde.xmu.PrimitiveVariable) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.Variable) {
			result = interprete_edu_ustb_sei_mde_xmu_Variable((edu.ustb.sei.mde.xmu.Variable) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.Rule) {
			result = interprete_edu_ustb_sei_mde_xmu_Rule((edu.ustb.sei.mde.xmu.Rule) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.NamedElement) {
			result = interprete_edu_ustb_sei_mde_xmu_NamedElement((edu.ustb.sei.mde.xmu.NamedElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.ForStatement) {
			result = interprete_edu_ustb_sei_mde_xmu_ForStatement((edu.ustb.sei.mde.xmu.ForStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.DeleteNode) {
			result = interprete_edu_ustb_sei_mde_xmu_DeleteNode((edu.ustb.sei.mde.xmu.DeleteNode) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.DeleteLink) {
			result = interprete_edu_ustb_sei_mde_xmu_DeleteLink((edu.ustb.sei.mde.xmu.DeleteLink) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.UpdatePattern) {
			result = interprete_edu_ustb_sei_mde_xmu_UpdatePattern((edu.ustb.sei.mde.xmu.UpdatePattern) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.Update) {
			result = interprete_edu_ustb_sei_mde_xmu_Update((edu.ustb.sei.mde.xmu.Update) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.Statement) {
			result = interprete_edu_ustb_sei_mde_xmu_Statement((edu.ustb.sei.mde.xmu.Statement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.Pattern) {
			result = interprete_edu_ustb_sei_mde_xmu_Pattern((edu.ustb.sei.mde.xmu.Pattern) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.PatternNode) {
			result = interprete_edu_ustb_sei_mde_xmu_PatternNode((edu.ustb.sei.mde.xmu.PatternNode) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.PatternReferenceExpr) {
			result = interprete_edu_ustb_sei_mde_xmu_PatternReferenceExpr((edu.ustb.sei.mde.xmu.PatternReferenceExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.PatternEqualExpr) {
			result = interprete_edu_ustb_sei_mde_xmu_PatternEqualExpr((edu.ustb.sei.mde.xmu.PatternEqualExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.PatternExpr) {
			result = interprete_edu_ustb_sei_mde_xmu_PatternExpr((edu.ustb.sei.mde.xmu.PatternExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.VariableExp) {
			result = interprete_edu_ustb_sei_mde_xmu_VariableExp((edu.ustb.sei.mde.xmu.VariableExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.EmptyLiteral) {
			result = interprete_edu_ustb_sei_mde_xmu_EmptyLiteral((edu.ustb.sei.mde.xmu.EmptyLiteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.StringLiteral) {
			result = interprete_edu_ustb_sei_mde_xmu_StringLiteral((edu.ustb.sei.mde.xmu.StringLiteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.IntegerLiteral) {
			result = interprete_edu_ustb_sei_mde_xmu_IntegerLiteral((edu.ustb.sei.mde.xmu.IntegerLiteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.BooleanLiteral) {
			result = interprete_edu_ustb_sei_mde_xmu_BooleanLiteral((edu.ustb.sei.mde.xmu.BooleanLiteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.EnumLiteral) {
			result = interprete_edu_ustb_sei_mde_xmu_EnumLiteral((edu.ustb.sei.mde.xmu.EnumLiteral) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.ConstantExpr) {
			result = interprete_edu_ustb_sei_mde_xmu_ConstantExpr((edu.ustb.sei.mde.xmu.ConstantExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.DefaultVStatement) {
			result = interprete_edu_ustb_sei_mde_xmu_DefaultVStatement((edu.ustb.sei.mde.xmu.DefaultVStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.TaggedVStatement) {
			result = interprete_edu_ustb_sei_mde_xmu_TaggedVStatement((edu.ustb.sei.mde.xmu.TaggedVStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.VStatement) {
			result = interprete_edu_ustb_sei_mde_xmu_VStatement((edu.ustb.sei.mde.xmu.VStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.BlockStatement) {
			result = interprete_edu_ustb_sei_mde_xmu_BlockStatement((edu.ustb.sei.mde.xmu.BlockStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.SwitchStatement) {
			result = interprete_edu_ustb_sei_mde_xmu_SwitchStatement((edu.ustb.sei.mde.xmu.SwitchStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.Parameter) {
			result = interprete_edu_ustb_sei_mde_xmu_Parameter((edu.ustb.sei.mde.xmu.Parameter) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.TaggedElement) {
			result = interprete_edu_ustb_sei_mde_xmu_TaggedElement((edu.ustb.sei.mde.xmu.TaggedElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.CasePatternStatement) {
			result = interprete_edu_ustb_sei_mde_xmu_CasePatternStatement((edu.ustb.sei.mde.xmu.CasePatternStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.CaseDefaultStatement) {
			result = interprete_edu_ustb_sei_mde_xmu_CaseDefaultStatement((edu.ustb.sei.mde.xmu.CaseDefaultStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.CaseValueStatement) {
			result = interprete_edu_ustb_sei_mde_xmu_CaseValueStatement((edu.ustb.sei.mde.xmu.CaseValueStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.CaseSubStatement) {
			result = interprete_edu_ustb_sei_mde_xmu_CaseSubStatement((edu.ustb.sei.mde.xmu.CaseSubStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.XMUModel) {
			result = interprete_edu_ustb_sei_mde_xmu_XMUModel((edu.ustb.sei.mde.xmu.XMUModel) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.RuleCallStatement) {
			result = interprete_edu_ustb_sei_mde_xmu_RuleCallStatement((edu.ustb.sei.mde.xmu.RuleCallStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.BooleanOrExpr) {
			result = interprete_edu_ustb_sei_mde_xmu_BooleanOrExpr((edu.ustb.sei.mde.xmu.BooleanOrExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.BooleanAndExpr) {
			result = interprete_edu_ustb_sei_mde_xmu_BooleanAndExpr((edu.ustb.sei.mde.xmu.BooleanAndExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.RelationalExpr) {
			result = interprete_edu_ustb_sei_mde_xmu_RelationalExpr((edu.ustb.sei.mde.xmu.RelationalExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.AdditiveExpr) {
			result = interprete_edu_ustb_sei_mde_xmu_AdditiveExpr((edu.ustb.sei.mde.xmu.AdditiveExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.MultiplicativeExpr) {
			result = interprete_edu_ustb_sei_mde_xmu_MultiplicativeExpr((edu.ustb.sei.mde.xmu.MultiplicativeExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.UnaryExpr) {
			result = interprete_edu_ustb_sei_mde_xmu_UnaryExpr((edu.ustb.sei.mde.xmu.UnaryExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.ParenExpr) {
			result = interprete_edu_ustb_sei_mde_xmu_ParenExpr((edu.ustb.sei.mde.xmu.ParenExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.AtomicExpr) {
			result = interprete_edu_ustb_sei_mde_xmu_AtomicExpr((edu.ustb.sei.mde.xmu.AtomicExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.UnaryExprChild) {
			result = interprete_edu_ustb_sei_mde_xmu_UnaryExprChild((edu.ustb.sei.mde.xmu.UnaryExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.MultiplicativeExprChild) {
			result = interprete_edu_ustb_sei_mde_xmu_MultiplicativeExprChild((edu.ustb.sei.mde.xmu.MultiplicativeExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.AdditiveExprChild) {
			result = interprete_edu_ustb_sei_mde_xmu_AdditiveExprChild((edu.ustb.sei.mde.xmu.AdditiveExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.RelationalExprChild) {
			result = interprete_edu_ustb_sei_mde_xmu_RelationalExprChild((edu.ustb.sei.mde.xmu.RelationalExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.BooleanAndExprChild) {
			result = interprete_edu_ustb_sei_mde_xmu_BooleanAndExprChild((edu.ustb.sei.mde.xmu.BooleanAndExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.BooleanOrExprChild) {
			result = interprete_edu_ustb_sei_mde_xmu_BooleanOrExprChild((edu.ustb.sei.mde.xmu.BooleanOrExprChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.Expr) {
			result = interprete_edu_ustb_sei_mde_xmu_Expr((edu.ustb.sei.mde.xmu.Expr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.HelperPath) {
			result = interprete_edu_ustb_sei_mde_xmu_HelperPath((edu.ustb.sei.mde.xmu.HelperPath) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.FeaturePath) {
			result = interprete_edu_ustb_sei_mde_xmu_FeaturePath((edu.ustb.sei.mde.xmu.FeaturePath) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.OperationPath) {
			result = interprete_edu_ustb_sei_mde_xmu_OperationPath((edu.ustb.sei.mde.xmu.OperationPath) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.LoopPath) {
			result = interprete_edu_ustb_sei_mde_xmu_LoopPath((edu.ustb.sei.mde.xmu.LoopPath) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.Path) {
			result = interprete_edu_ustb_sei_mde_xmu_Path((edu.ustb.sei.mde.xmu.Path) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.StartStatement) {
			result = interprete_edu_ustb_sei_mde_xmu_StartStatement((edu.ustb.sei.mde.xmu.StartStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.StartRoot) {
			result = interprete_edu_ustb_sei_mde_xmu_StartRoot((edu.ustb.sei.mde.xmu.StartRoot) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.EResource) {
			result = interprete_edu_ustb_sei_mde_xmu_EResource((edu.ustb.sei.mde.xmu.EResource) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.PrintStatement) {
			result = interprete_edu_ustb_sei_mde_xmu_PrintStatement((edu.ustb.sei.mde.xmu.PrintStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.AllInstanceExpr) {
			result = interprete_edu_ustb_sei_mde_xmu_AllInstanceExpr((edu.ustb.sei.mde.xmu.AllInstanceExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.ESet) {
			result = interprete_edu_ustb_sei_mde_xmu_ESet((edu.ustb.sei.mde.xmu.ESet) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.ObjectPathExpr) {
			result = interprete_edu_ustb_sei_mde_xmu_ObjectPathExpr((edu.ustb.sei.mde.xmu.ObjectPathExpr) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.InitialMappingStatement) {
			result = interprete_edu_ustb_sei_mde_xmu_InitialMappingStatement((edu.ustb.sei.mde.xmu.InitialMappingStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.HelperMapping) {
			result = interprete_edu_ustb_sei_mde_xmu_HelperMapping((edu.ustb.sei.mde.xmu.HelperMapping) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.HelperMappingEntry) {
			result = interprete_edu_ustb_sei_mde_xmu_HelperMappingEntry((edu.ustb.sei.mde.xmu.HelperMappingEntry) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.Skip) {
			result = interprete_edu_ustb_sei_mde_xmu_Skip((edu.ustb.sei.mde.xmu.Skip) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.Fail) {
			result = interprete_edu_ustb_sei_mde_xmu_Fail((edu.ustb.sei.mde.xmu.Fail) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.xmu.PseudoUpdate) {
			result = interprete_edu_ustb_sei_mde_xmu_PseudoUpdate((edu.ustb.sei.mde.xmu.PseudoUpdate) object, context);
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
		if (object instanceof org.eclipse.emf.ecore.ETypeParameter) {
			result = interprete_org_eclipse_emf_ecore_ETypeParameter((org.eclipse.emf.ecore.ETypeParameter) object, context);
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
		return result;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_NamedElement(edu.ustb.sei.mde.xmu.NamedElement namedElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_Variable(edu.ustb.sei.mde.xmu.Variable variable, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_ObjectVariable(edu.ustb.sei.mde.xmu.ObjectVariable objectVariable, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_PrimitiveVariable(edu.ustb.sei.mde.xmu.PrimitiveVariable primitiveVariable, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_Rule(edu.ustb.sei.mde.xmu.Rule rule, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_Statement(edu.ustb.sei.mde.xmu.Statement statement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_ForStatement(edu.ustb.sei.mde.xmu.ForStatement forStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_Update(edu.ustb.sei.mde.xmu.Update update, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_DeleteNode(edu.ustb.sei.mde.xmu.DeleteNode deleteNode, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_DeleteLink(edu.ustb.sei.mde.xmu.DeleteLink deleteLink, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_UpdatePattern(edu.ustb.sei.mde.xmu.UpdatePattern updatePattern, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_Pattern(edu.ustb.sei.mde.xmu.Pattern pattern, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_PatternNode(edu.ustb.sei.mde.xmu.PatternNode patternNode, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_PatternExpr(edu.ustb.sei.mde.xmu.PatternExpr patternExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_PatternReferenceExpr(edu.ustb.sei.mde.xmu.PatternReferenceExpr patternReferenceExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_PatternEqualExpr(edu.ustb.sei.mde.xmu.PatternEqualExpr patternEqualExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_Expr(edu.ustb.sei.mde.xmu.Expr expr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_VariableExp(edu.ustb.sei.mde.xmu.VariableExp variableExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_ConstantExpr(edu.ustb.sei.mde.xmu.ConstantExpr constantExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_EmptyLiteral(edu.ustb.sei.mde.xmu.EmptyLiteral emptyLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_StringLiteral(edu.ustb.sei.mde.xmu.StringLiteral stringLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_IntegerLiteral(edu.ustb.sei.mde.xmu.IntegerLiteral integerLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_BooleanLiteral(edu.ustb.sei.mde.xmu.BooleanLiteral booleanLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_EnumLiteral(edu.ustb.sei.mde.xmu.EnumLiteral enumLiteral, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_VStatement(edu.ustb.sei.mde.xmu.VStatement vStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_DefaultVStatement(edu.ustb.sei.mde.xmu.DefaultVStatement defaultVStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_TaggedVStatement(edu.ustb.sei.mde.xmu.TaggedVStatement taggedVStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_BlockStatement(edu.ustb.sei.mde.xmu.BlockStatement blockStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_SwitchStatement(edu.ustb.sei.mde.xmu.SwitchStatement switchStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_TaggedElement(edu.ustb.sei.mde.xmu.TaggedElement taggedElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_CaseSubStatement(edu.ustb.sei.mde.xmu.CaseSubStatement caseSubStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_CasePatternStatement(edu.ustb.sei.mde.xmu.CasePatternStatement casePatternStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_CaseValueStatement(edu.ustb.sei.mde.xmu.CaseValueStatement caseValueStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_CaseDefaultStatement(edu.ustb.sei.mde.xmu.CaseDefaultStatement caseDefaultStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_XMUModel(edu.ustb.sei.mde.xmu.XMUModel xMUModel, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_Parameter(edu.ustb.sei.mde.xmu.Parameter parameter, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_RuleCallStatement(edu.ustb.sei.mde.xmu.RuleCallStatement ruleCallStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_BooleanOrExpr(edu.ustb.sei.mde.xmu.BooleanOrExpr booleanOrExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_BooleanOrExprChild(edu.ustb.sei.mde.xmu.BooleanOrExprChild booleanOrExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_BooleanAndExpr(edu.ustb.sei.mde.xmu.BooleanAndExpr booleanAndExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_BooleanAndExprChild(edu.ustb.sei.mde.xmu.BooleanAndExprChild booleanAndExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_RelationalExpr(edu.ustb.sei.mde.xmu.RelationalExpr relationalExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_RelationalExprChild(edu.ustb.sei.mde.xmu.RelationalExprChild relationalExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_AdditiveExpr(edu.ustb.sei.mde.xmu.AdditiveExpr additiveExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_AdditiveExprChild(edu.ustb.sei.mde.xmu.AdditiveExprChild additiveExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_MultiplicativeExpr(edu.ustb.sei.mde.xmu.MultiplicativeExpr multiplicativeExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_MultiplicativeExprChild(edu.ustb.sei.mde.xmu.MultiplicativeExprChild multiplicativeExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_UnaryExpr(edu.ustb.sei.mde.xmu.UnaryExpr unaryExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_UnaryExprChild(edu.ustb.sei.mde.xmu.UnaryExprChild unaryExprChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_AtomicExpr(edu.ustb.sei.mde.xmu.AtomicExpr atomicExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_ParenExpr(edu.ustb.sei.mde.xmu.ParenExpr parenExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_Path(edu.ustb.sei.mde.xmu.Path path, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_HelperPath(edu.ustb.sei.mde.xmu.HelperPath helperPath, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_FeaturePath(edu.ustb.sei.mde.xmu.FeaturePath featurePath, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_OperationPath(edu.ustb.sei.mde.xmu.OperationPath operationPath, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_LoopPath(edu.ustb.sei.mde.xmu.LoopPath loopPath, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_StartStatement(edu.ustb.sei.mde.xmu.StartStatement startStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_StartRoot(edu.ustb.sei.mde.xmu.StartRoot startRoot, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_EResource(edu.ustb.sei.mde.xmu.EResource eResource, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_PrintStatement(edu.ustb.sei.mde.xmu.PrintStatement printStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_AllInstanceExpr(edu.ustb.sei.mde.xmu.AllInstanceExpr allInstanceExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_ESet(edu.ustb.sei.mde.xmu.ESet eSet, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_ObjectPathExpr(edu.ustb.sei.mde.xmu.ObjectPathExpr objectPathExpr, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_InitialMappingStatement(edu.ustb.sei.mde.xmu.InitialMappingStatement initialMappingStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_HelperMapping(edu.ustb.sei.mde.xmu.HelperMapping helperMapping, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_HelperMappingEntry(edu.ustb.sei.mde.xmu.HelperMappingEntry helperMappingEntry, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_PseudoUpdate(edu.ustb.sei.mde.xmu.PseudoUpdate pseudoUpdate, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_Skip(edu.ustb.sei.mde.xmu.Skip skip, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_xmu_Fail(edu.ustb.sei.mde.xmu.Fail fail, ContextType context) {
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
	
	private void notifyListeners(org.eclipse.emf.ecore.EObject element) {
		for (edu.ustb.sei.mde.xmu.resource.xmu.IXmuInterpreterListener listener : listeners) {
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
	
	public void addListener(edu.ustb.sei.mde.xmu.resource.xmu.IXmuInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(edu.ustb.sei.mde.xmu.resource.xmu.IXmuInterpreterListener listener) {
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
