/**
 */
package edu.ustb.sei.mde.xmu2.statement;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage
 * @generated
 */
public interface StatementFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StatementFactory eINSTANCE = edu.ustb.sei.mde.xmu2.statement.impl.StatementFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Update Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update Statement</em>'.
	 * @generated
	 */
	UpdateStatement createUpdateStatement();

	/**
	 * Returns a new object of class '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Statement</em>'.
	 * @generated
	 */
	SwitchStatement createSwitchStatement();

	/**
	 * Returns a new object of class '<em>Update Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Update Clause</em>'.
	 * @generated
	 */
	UpdateClause createUpdateClause();

	/**
	 * Returns a new object of class '<em>Pattern Case Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pattern Case Clause</em>'.
	 * @generated
	 */
	PatternCaseClause createPatternCaseClause();

	/**
	 * Returns a new object of class '<em>Expression Case Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression Case Clause</em>'.
	 * @generated
	 */
	ExpressionCaseClause createExpressionCaseClause();

	/**
	 * Returns a new object of class '<em>Default Case Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Case Clause</em>'.
	 * @generated
	 */
	DefaultCaseClause createDefaultCaseClause();

	/**
	 * Returns a new object of class '<em>Default Case Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Case Statement</em>'.
	 * @generated
	 */
	DefaultCaseStatement createDefaultCaseStatement();

	/**
	 * Returns a new object of class '<em>Enforce Pattern Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enforce Pattern Statement</em>'.
	 * @generated
	 */
	EnforcePatternStatement createEnforcePatternStatement();

	/**
	 * Returns a new object of class '<em>Delete Node Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Delete Node Statement</em>'.
	 * @generated
	 */
	DeleteNodeStatement createDeleteNodeStatement();

	/**
	 * Returns a new object of class '<em>Concrete Delete Link Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Concrete Delete Link Statement</em>'.
	 * @generated
	 */
	ConcreteDeleteLinkStatement createConcreteDeleteLinkStatement();

	/**
	 * Returns a new object of class '<em>Reflective Delete Link Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reflective Delete Link Statement</em>'.
	 * @generated
	 */
	ReflectiveDeleteLinkStatement createReflectiveDeleteLinkStatement();

	/**
	 * Returns a new object of class '<em>For Each Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Each Statement</em>'.
	 * @generated
	 */
	ForEachStatement createForEachStatement();

	/**
	 * Returns a new object of class '<em>Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Statement</em>'.
	 * @generated
	 */
	BlockStatement createBlockStatement();

	/**
	 * Returns a new object of class '<em>Rule Call Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Call Statement</em>'.
	 * @generated
	 */
	RuleCallStatement createRuleCallStatement();

	/**
	 * Returns a new object of class '<em>Fail</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fail</em>'.
	 * @generated
	 */
	Fail createFail();

	/**
	 * Returns a new object of class '<em>Skip</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Skip</em>'.
	 * @generated
	 */
	Skip createSkip();

	/**
	 * Returns a new object of class '<em>Assign Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assign Statement</em>'.
	 * @generated
	 */
	AssignStatement createAssignStatement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StatementPackage getStatementPackage();

} //StatementFactory
