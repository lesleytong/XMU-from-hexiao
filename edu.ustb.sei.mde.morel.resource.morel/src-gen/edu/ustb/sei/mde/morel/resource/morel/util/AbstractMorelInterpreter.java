/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.util;

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
public class AbstractMorelInterpreter<ResultType, ContextType> {
	
	private java.util.Stack<org.eclipse.emf.ecore.EObject> interpretationStack = new java.util.Stack<org.eclipse.emf.ecore.EObject>();
	private java.util.List<edu.ustb.sei.mde.morel.resource.morel.IMorelInterpreterListener> listeners = new java.util.ArrayList<edu.ustb.sei.mde.morel.resource.morel.IMorelInterpreterListener>();
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
		if (object instanceof edu.ustb.sei.mde.morel.NamedElement) {
			result = interprete_edu_ustb_sei_mde_morel_NamedElement((edu.ustb.sei.mde.morel.NamedElement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.Pattern) {
			result = interprete_edu_ustb_sei_mde_morel_Pattern((edu.ustb.sei.mde.morel.Pattern) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.Clause) {
			result = interprete_edu_ustb_sei_mde_morel_Clause((edu.ustb.sei.mde.morel.Clause) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.Section) {
			result = interprete_edu_ustb_sei_mde_morel_Section((edu.ustb.sei.mde.morel.Section) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.ObjectVariable) {
			result = interprete_edu_ustb_sei_mde_morel_ObjectVariable((edu.ustb.sei.mde.morel.ObjectVariable) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.PrimitiveVariable) {
			result = interprete_edu_ustb_sei_mde_morel_PrimitiveVariable((edu.ustb.sei.mde.morel.PrimitiveVariable) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.Variable) {
			result = interprete_edu_ustb_sei_mde_morel_Variable((edu.ustb.sei.mde.morel.Variable) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.LinkConstraint) {
			result = interprete_edu_ustb_sei_mde_morel_LinkConstraint((edu.ustb.sei.mde.morel.LinkConstraint) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.QueryModel) {
			result = interprete_edu_ustb_sei_mde_morel_QueryModel((edu.ustb.sei.mde.morel.QueryModel) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.TypedModel) {
			result = interprete_edu_ustb_sei_mde_morel_TypedModel((edu.ustb.sei.mde.morel.TypedModel) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.Query) {
			result = interprete_edu_ustb_sei_mde_morel_Query((edu.ustb.sei.mde.morel.Query) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.Unit) {
			result = interprete_edu_ustb_sei_mde_morel_Unit((edu.ustb.sei.mde.morel.Unit) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.StringLiteralExp) {
			result = interprete_edu_ustb_sei_mde_morel_StringLiteralExp((edu.ustb.sei.mde.morel.StringLiteralExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.IntegerLiteralExp) {
			result = interprete_edu_ustb_sei_mde_morel_IntegerLiteralExp((edu.ustb.sei.mde.morel.IntegerLiteralExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.RealLiteralExp) {
			result = interprete_edu_ustb_sei_mde_morel_RealLiteralExp((edu.ustb.sei.mde.morel.RealLiteralExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.BooleanLiteralExp) {
			result = interprete_edu_ustb_sei_mde_morel_BooleanLiteralExp((edu.ustb.sei.mde.morel.BooleanLiteralExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.UndefinedLiteralExp) {
			result = interprete_edu_ustb_sei_mde_morel_UndefinedLiteralExp((edu.ustb.sei.mde.morel.UndefinedLiteralExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.TypeLiteralExp) {
			result = interprete_edu_ustb_sei_mde_morel_TypeLiteralExp((edu.ustb.sei.mde.morel.TypeLiteralExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.LiteralExp) {
			result = interprete_edu_ustb_sei_mde_morel_LiteralExp((edu.ustb.sei.mde.morel.LiteralExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.VariableExp) {
			result = interprete_edu_ustb_sei_mde_morel_VariableExp((edu.ustb.sei.mde.morel.VariableExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.PredefinedVariableExp) {
			result = interprete_edu_ustb_sei_mde_morel_PredefinedVariableExp((edu.ustb.sei.mde.morel.PredefinedVariableExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.NestedExp) {
			result = interprete_edu_ustb_sei_mde_morel_NestedExp((edu.ustb.sei.mde.morel.NestedExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.AtomicExp) {
			result = interprete_edu_ustb_sei_mde_morel_AtomicExp((edu.ustb.sei.mde.morel.AtomicExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.FeaturePathExp) {
			result = interprete_edu_ustb_sei_mde_morel_FeaturePathExp((edu.ustb.sei.mde.morel.FeaturePathExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.OperationPathExp) {
			result = interprete_edu_ustb_sei_mde_morel_OperationPathExp((edu.ustb.sei.mde.morel.OperationPathExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.IteratorPathExp) {
			result = interprete_edu_ustb_sei_mde_morel_IteratorPathExp((edu.ustb.sei.mde.morel.IteratorPathExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.LoopPathExp) {
			result = interprete_edu_ustb_sei_mde_morel_LoopPathExp((edu.ustb.sei.mde.morel.LoopPathExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.CallPathExp) {
			result = interprete_edu_ustb_sei_mde_morel_CallPathExp((edu.ustb.sei.mde.morel.CallPathExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.LetExp) {
			result = interprete_edu_ustb_sei_mde_morel_LetExp((edu.ustb.sei.mde.morel.LetExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.ObjectVariableWithInit) {
			result = interprete_edu_ustb_sei_mde_morel_ObjectVariableWithInit((edu.ustb.sei.mde.morel.ObjectVariableWithInit) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.PrimitiveVariableWithInit) {
			result = interprete_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit((edu.ustb.sei.mde.morel.PrimitiveVariableWithInit) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.VariableWithInit) {
			result = interprete_edu_ustb_sei_mde_morel_VariableWithInit((edu.ustb.sei.mde.morel.VariableWithInit) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.ConditionExp) {
			result = interprete_edu_ustb_sei_mde_morel_ConditionExp((edu.ustb.sei.mde.morel.ConditionExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.BooleanImpliesExp) {
			result = interprete_edu_ustb_sei_mde_morel_BooleanImpliesExp((edu.ustb.sei.mde.morel.BooleanImpliesExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.BooleanOrExp) {
			result = interprete_edu_ustb_sei_mde_morel_BooleanOrExp((edu.ustb.sei.mde.morel.BooleanOrExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.BooleanAndExp) {
			result = interprete_edu_ustb_sei_mde_morel_BooleanAndExp((edu.ustb.sei.mde.morel.BooleanAndExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.RelationalExp) {
			result = interprete_edu_ustb_sei_mde_morel_RelationalExp((edu.ustb.sei.mde.morel.RelationalExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.AdditiveExp) {
			result = interprete_edu_ustb_sei_mde_morel_AdditiveExp((edu.ustb.sei.mde.morel.AdditiveExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.MultiplicativeExp) {
			result = interprete_edu_ustb_sei_mde_morel_MultiplicativeExp((edu.ustb.sei.mde.morel.MultiplicativeExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.UnaryExp) {
			result = interprete_edu_ustb_sei_mde_morel_UnaryExp((edu.ustb.sei.mde.morel.UnaryExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.UnaryExpChild) {
			result = interprete_edu_ustb_sei_mde_morel_UnaryExpChild((edu.ustb.sei.mde.morel.UnaryExpChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.MultiplicativeExpChild) {
			result = interprete_edu_ustb_sei_mde_morel_MultiplicativeExpChild((edu.ustb.sei.mde.morel.MultiplicativeExpChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.AdditiveExpChild) {
			result = interprete_edu_ustb_sei_mde_morel_AdditiveExpChild((edu.ustb.sei.mde.morel.AdditiveExpChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.RelationalExpChild) {
			result = interprete_edu_ustb_sei_mde_morel_RelationalExpChild((edu.ustb.sei.mde.morel.RelationalExpChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.BooleanAndExpChild) {
			result = interprete_edu_ustb_sei_mde_morel_BooleanAndExpChild((edu.ustb.sei.mde.morel.BooleanAndExpChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.BooleanOrExpChild) {
			result = interprete_edu_ustb_sei_mde_morel_BooleanOrExpChild((edu.ustb.sei.mde.morel.BooleanOrExpChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.BooleanImpliesExpChild) {
			result = interprete_edu_ustb_sei_mde_morel_BooleanImpliesExpChild((edu.ustb.sei.mde.morel.BooleanImpliesExpChild) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.Expression) {
			result = interprete_edu_ustb_sei_mde_morel_Expression((edu.ustb.sei.mde.morel.Expression) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.OrderedSetType) {
			result = interprete_edu_ustb_sei_mde_morel_OrderedSetType((edu.ustb.sei.mde.morel.OrderedSetType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.SequenceType) {
			result = interprete_edu_ustb_sei_mde_morel_SequenceType((edu.ustb.sei.mde.morel.SequenceType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.SetType) {
			result = interprete_edu_ustb_sei_mde_morel_SetType((edu.ustb.sei.mde.morel.SetType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.BagType) {
			result = interprete_edu_ustb_sei_mde_morel_BagType((edu.ustb.sei.mde.morel.BagType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.CollectionType) {
			result = interprete_edu_ustb_sei_mde_morel_CollectionType((edu.ustb.sei.mde.morel.CollectionType) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.BindExp) {
			result = interprete_edu_ustb_sei_mde_morel_BindExp((edu.ustb.sei.mde.morel.BindExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.PredefinedBindExp) {
			result = interprete_edu_ustb_sei_mde_morel_PredefinedBindExp((edu.ustb.sei.mde.morel.PredefinedBindExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.ImperativeExp) {
			result = interprete_edu_ustb_sei_mde_morel_ImperativeExp((edu.ustb.sei.mde.morel.ImperativeExp) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.IfStatement) {
			result = interprete_edu_ustb_sei_mde_morel_IfStatement((edu.ustb.sei.mde.morel.IfStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.ForStatement) {
			result = interprete_edu_ustb_sei_mde_morel_ForStatement((edu.ustb.sei.mde.morel.ForStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.BlockStatement) {
			result = interprete_edu_ustb_sei_mde_morel_BlockStatement((edu.ustb.sei.mde.morel.BlockStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.TransformationModel) {
			result = interprete_edu_ustb_sei_mde_morel_TransformationModel((edu.ustb.sei.mde.morel.TransformationModel) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.Rule) {
			result = interprete_edu_ustb_sei_mde_morel_Rule((edu.ustb.sei.mde.morel.Rule) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.DeclarativeStatement) {
			result = interprete_edu_ustb_sei_mde_morel_DeclarativeStatement((edu.ustb.sei.mde.morel.DeclarativeStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.ImperativeStatement) {
			result = interprete_edu_ustb_sei_mde_morel_ImperativeStatement((edu.ustb.sei.mde.morel.ImperativeStatement) object, context);
		}
		if (result != null) {
			return result;
		}
		if (object instanceof edu.ustb.sei.mde.morel.Statement) {
			result = interprete_edu_ustb_sei_mde_morel_Statement((edu.ustb.sei.mde.morel.Statement) object, context);
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
	
	public ResultType interprete_edu_ustb_sei_mde_morel_NamedElement(edu.ustb.sei.mde.morel.NamedElement namedElement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_Section(edu.ustb.sei.mde.morel.Section section, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_Pattern(edu.ustb.sei.mde.morel.Pattern pattern, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_Clause(edu.ustb.sei.mde.morel.Clause clause, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_Variable(edu.ustb.sei.mde.morel.Variable variable, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_ObjectVariable(edu.ustb.sei.mde.morel.ObjectVariable objectVariable, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_PrimitiveVariable(edu.ustb.sei.mde.morel.PrimitiveVariable primitiveVariable, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_LinkConstraint(edu.ustb.sei.mde.morel.LinkConstraint linkConstraint, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_QueryModel(edu.ustb.sei.mde.morel.QueryModel queryModel, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_TypedModel(edu.ustb.sei.mde.morel.TypedModel typedModel, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_Query(edu.ustb.sei.mde.morel.Query query, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_Unit(edu.ustb.sei.mde.morel.Unit unit, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_Expression(edu.ustb.sei.mde.morel.Expression expression, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_AtomicExp(edu.ustb.sei.mde.morel.AtomicExp atomicExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_LiteralExp(edu.ustb.sei.mde.morel.LiteralExp literalExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_StringLiteralExp(edu.ustb.sei.mde.morel.StringLiteralExp stringLiteralExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_IntegerLiteralExp(edu.ustb.sei.mde.morel.IntegerLiteralExp integerLiteralExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_RealLiteralExp(edu.ustb.sei.mde.morel.RealLiteralExp realLiteralExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_BooleanLiteralExp(edu.ustb.sei.mde.morel.BooleanLiteralExp booleanLiteralExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_UndefinedLiteralExp(edu.ustb.sei.mde.morel.UndefinedLiteralExp undefinedLiteralExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_TypeLiteralExp(edu.ustb.sei.mde.morel.TypeLiteralExp typeLiteralExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_VariableExp(edu.ustb.sei.mde.morel.VariableExp variableExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_PredefinedVariableExp(edu.ustb.sei.mde.morel.PredefinedVariableExp predefinedVariableExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_NestedExp(edu.ustb.sei.mde.morel.NestedExp nestedExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_CallPathExp(edu.ustb.sei.mde.morel.CallPathExp callPathExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_FeaturePathExp(edu.ustb.sei.mde.morel.FeaturePathExp featurePathExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_OperationPathExp(edu.ustb.sei.mde.morel.OperationPathExp operationPathExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_LoopPathExp(edu.ustb.sei.mde.morel.LoopPathExp loopPathExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_IteratorPathExp(edu.ustb.sei.mde.morel.IteratorPathExp iteratorPathExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_LetExp(edu.ustb.sei.mde.morel.LetExp letExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_VariableWithInit(edu.ustb.sei.mde.morel.VariableWithInit variableWithInit, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_ObjectVariableWithInit(edu.ustb.sei.mde.morel.ObjectVariableWithInit objectVariableWithInit, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_PrimitiveVariableWithInit(edu.ustb.sei.mde.morel.PrimitiveVariableWithInit primitiveVariableWithInit, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_ConditionExp(edu.ustb.sei.mde.morel.ConditionExp conditionExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_BooleanImpliesExp(edu.ustb.sei.mde.morel.BooleanImpliesExp booleanImpliesExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_BooleanImpliesExpChild(edu.ustb.sei.mde.morel.BooleanImpliesExpChild booleanImpliesExpChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_BooleanOrExp(edu.ustb.sei.mde.morel.BooleanOrExp booleanOrExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_BooleanOrExpChild(edu.ustb.sei.mde.morel.BooleanOrExpChild booleanOrExpChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_BooleanAndExp(edu.ustb.sei.mde.morel.BooleanAndExp booleanAndExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_BooleanAndExpChild(edu.ustb.sei.mde.morel.BooleanAndExpChild booleanAndExpChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_RelationalExp(edu.ustb.sei.mde.morel.RelationalExp relationalExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_RelationalExpChild(edu.ustb.sei.mde.morel.RelationalExpChild relationalExpChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_AdditiveExp(edu.ustb.sei.mde.morel.AdditiveExp additiveExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_AdditiveExpChild(edu.ustb.sei.mde.morel.AdditiveExpChild additiveExpChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_MultiplicativeExp(edu.ustb.sei.mde.morel.MultiplicativeExp multiplicativeExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_MultiplicativeExpChild(edu.ustb.sei.mde.morel.MultiplicativeExpChild multiplicativeExpChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_UnaryExp(edu.ustb.sei.mde.morel.UnaryExp unaryExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_UnaryExpChild(edu.ustb.sei.mde.morel.UnaryExpChild unaryExpChild, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_CollectionType(edu.ustb.sei.mde.morel.CollectionType collectionType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_OrderedSetType(edu.ustb.sei.mde.morel.OrderedSetType orderedSetType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_SequenceType(edu.ustb.sei.mde.morel.SequenceType sequenceType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_SetType(edu.ustb.sei.mde.morel.SetType setType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_BagType(edu.ustb.sei.mde.morel.BagType bagType, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_ImperativeExp(edu.ustb.sei.mde.morel.ImperativeExp imperativeExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_BindExp(edu.ustb.sei.mde.morel.BindExp bindExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_PredefinedBindExp(edu.ustb.sei.mde.morel.PredefinedBindExp predefinedBindExp, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_IfStatement(edu.ustb.sei.mde.morel.IfStatement ifStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_ForStatement(edu.ustb.sei.mde.morel.ForStatement forStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_BlockStatement(edu.ustb.sei.mde.morel.BlockStatement blockStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_TransformationModel(edu.ustb.sei.mde.morel.TransformationModel transformationModel, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_Rule(edu.ustb.sei.mde.morel.Rule rule, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_Statement(edu.ustb.sei.mde.morel.Statement statement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_DeclarativeStatement(edu.ustb.sei.mde.morel.DeclarativeStatement declarativeStatement, ContextType context) {
		return null;
	}
	
	public ResultType interprete_edu_ustb_sei_mde_morel_ImperativeStatement(edu.ustb.sei.mde.morel.ImperativeStatement imperativeStatement, ContextType context) {
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
		for (edu.ustb.sei.mde.morel.resource.morel.IMorelInterpreterListener listener : listeners) {
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
	
	public void addListener(edu.ustb.sei.mde.morel.resource.morel.IMorelInterpreterListener newListener) {
		listeners.add(newListener);
	}
	
	public boolean removeListener(edu.ustb.sei.mde.morel.resource.morel.IMorelInterpreterListener listener) {
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
