/**
 */
package edu.ustb.sei.mde.xmu2.statement.util;

import edu.ustb.sei.mde.xmu2.ReflectiveAPI;
import edu.ustb.sei.mde.xmu2.statement.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage
 * @generated
 */
public class StatementSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StatementPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatementSwitch() {
		if (modelPackage == null) {
			modelPackage = StatementPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case StatementPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.UPDATE_STATEMENT: {
				UpdateStatement updateStatement = (UpdateStatement)theEObject;
				T result = caseUpdateStatement(updateStatement);
				if (result == null) result = caseBidirectionalStatement(updateStatement);
				if (result == null) result = caseStatement(updateStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.SWITCH_STATEMENT: {
				SwitchStatement switchStatement = (SwitchStatement)theEObject;
				T result = caseSwitchStatement(switchStatement);
				if (result == null) result = caseBidirectionalStatement(switchStatement);
				if (result == null) result = caseStatement(switchStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.UPDATE_CLAUSE: {
				UpdateClause updateClause = (UpdateClause)theEObject;
				T result = caseUpdateClause(updateClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.CASE_CLAUSE: {
				CaseClause caseClause = (CaseClause)theEObject;
				T result = caseCaseClause(caseClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.PATTERN_CASE_CLAUSE: {
				PatternCaseClause patternCaseClause = (PatternCaseClause)theEObject;
				T result = casePatternCaseClause(patternCaseClause);
				if (result == null) result = caseCaseClause(patternCaseClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.EXPRESSION_CASE_CLAUSE: {
				ExpressionCaseClause expressionCaseClause = (ExpressionCaseClause)theEObject;
				T result = caseExpressionCaseClause(expressionCaseClause);
				if (result == null) result = caseCaseClause(expressionCaseClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.DEFAULT_CASE_CLAUSE: {
				DefaultCaseClause defaultCaseClause = (DefaultCaseClause)theEObject;
				T result = caseDefaultCaseClause(defaultCaseClause);
				if (result == null) result = caseCaseClause(defaultCaseClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.DEFAULT_CASE_STATEMENT: {
				DefaultCaseStatement defaultCaseStatement = (DefaultCaseStatement)theEObject;
				T result = caseDefaultCaseStatement(defaultCaseStatement);
				if (result == null) result = caseCaseClause(defaultCaseStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.UNIDIRECTIONAL_STATEMENT: {
				UnidirectionalStatement unidirectionalStatement = (UnidirectionalStatement)theEObject;
				T result = caseUnidirectionalStatement(unidirectionalStatement);
				if (result == null) result = caseStatement(unidirectionalStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.BIDIRECTIONAL_STATEMENT: {
				BidirectionalStatement bidirectionalStatement = (BidirectionalStatement)theEObject;
				T result = caseBidirectionalStatement(bidirectionalStatement);
				if (result == null) result = caseStatement(bidirectionalStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.ENFORCE_PATTERN_STATEMENT: {
				EnforcePatternStatement enforcePatternStatement = (EnforcePatternStatement)theEObject;
				T result = caseEnforcePatternStatement(enforcePatternStatement);
				if (result == null) result = caseUnidirectionalStatement(enforcePatternStatement);
				if (result == null) result = caseStatement(enforcePatternStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.DELETE_NODE_STATEMENT: {
				DeleteNodeStatement deleteNodeStatement = (DeleteNodeStatement)theEObject;
				T result = caseDeleteNodeStatement(deleteNodeStatement);
				if (result == null) result = caseUnidirectionalStatement(deleteNodeStatement);
				if (result == null) result = caseStatement(deleteNodeStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.DELETE_LINK_STATEMENT: {
				DeleteLinkStatement deleteLinkStatement = (DeleteLinkStatement)theEObject;
				T result = caseDeleteLinkStatement(deleteLinkStatement);
				if (result == null) result = caseUnidirectionalStatement(deleteLinkStatement);
				if (result == null) result = caseStatement(deleteLinkStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.CONCRETE_DELETE_LINK_STATEMENT: {
				ConcreteDeleteLinkStatement concreteDeleteLinkStatement = (ConcreteDeleteLinkStatement)theEObject;
				T result = caseConcreteDeleteLinkStatement(concreteDeleteLinkStatement);
				if (result == null) result = caseDeleteLinkStatement(concreteDeleteLinkStatement);
				if (result == null) result = caseUnidirectionalStatement(concreteDeleteLinkStatement);
				if (result == null) result = caseStatement(concreteDeleteLinkStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT: {
				ReflectiveDeleteLinkStatement reflectiveDeleteLinkStatement = (ReflectiveDeleteLinkStatement)theEObject;
				T result = caseReflectiveDeleteLinkStatement(reflectiveDeleteLinkStatement);
				if (result == null) result = caseDeleteLinkStatement(reflectiveDeleteLinkStatement);
				if (result == null) result = caseReflectiveAPI(reflectiveDeleteLinkStatement);
				if (result == null) result = caseUnidirectionalStatement(reflectiveDeleteLinkStatement);
				if (result == null) result = caseStatement(reflectiveDeleteLinkStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.FOR_EACH_STATEMENT: {
				ForEachStatement forEachStatement = (ForEachStatement)theEObject;
				T result = caseForEachStatement(forEachStatement);
				if (result == null) result = caseUnidirectionalStatement(forEachStatement);
				if (result == null) result = caseStatement(forEachStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.BLOCK_STATEMENT: {
				BlockStatement blockStatement = (BlockStatement)theEObject;
				T result = caseBlockStatement(blockStatement);
				if (result == null) result = caseStatement(blockStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.RULE_CALL_STATEMENT: {
				RuleCallStatement ruleCallStatement = (RuleCallStatement)theEObject;
				T result = caseRuleCallStatement(ruleCallStatement);
				if (result == null) result = caseBidirectionalStatement(ruleCallStatement);
				if (result == null) result = caseStatement(ruleCallStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.PSESUDO_STATEMENT: {
				PsesudoStatement psesudoStatement = (PsesudoStatement)theEObject;
				T result = casePsesudoStatement(psesudoStatement);
				if (result == null) result = caseStatement(psesudoStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.FAIL: {
				Fail fail = (Fail)theEObject;
				T result = caseFail(fail);
				if (result == null) result = casePsesudoStatement(fail);
				if (result == null) result = caseStatement(fail);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.SKIP: {
				Skip skip = (Skip)theEObject;
				T result = caseSkip(skip);
				if (result == null) result = casePsesudoStatement(skip);
				if (result == null) result = caseStatement(skip);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StatementPackage.ASSIGN_STATEMENT: {
				AssignStatement assignStatement = (AssignStatement)theEObject;
				T result = caseAssignStatement(assignStatement);
				if (result == null) result = caseStatement(assignStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatement(Statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateStatement(UpdateStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchStatement(SwitchStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdateClause(UpdateClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCaseClause(CaseClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Case Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Case Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternCaseClause(PatternCaseClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression Case Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression Case Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressionCaseClause(ExpressionCaseClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Case Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Case Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultCaseClause(DefaultCaseClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Case Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Case Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultCaseStatement(DefaultCaseStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unidirectional Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unidirectional Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnidirectionalStatement(UnidirectionalStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bidirectional Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bidirectional Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBidirectionalStatement(BidirectionalStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enforce Pattern Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enforce Pattern Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnforcePatternStatement(EnforcePatternStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Node Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Node Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeleteNodeStatement(DeleteNodeStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Link Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Link Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeleteLinkStatement(DeleteLinkStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Concrete Delete Link Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Concrete Delete Link Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConcreteDeleteLinkStatement(ConcreteDeleteLinkStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reflective Delete Link Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reflective Delete Link Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReflectiveDeleteLinkStatement(ReflectiveDeleteLinkStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Each Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Each Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForEachStatement(ForEachStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockStatement(BlockStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Call Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Call Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleCallStatement(RuleCallStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Psesudo Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Psesudo Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePsesudoStatement(PsesudoStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fail</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fail</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFail(Fail object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Skip</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Skip</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSkip(Skip object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assign Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assign Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignStatement(AssignStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reflective API</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reflective API</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReflectiveAPI(ReflectiveAPI object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //StatementSwitch
