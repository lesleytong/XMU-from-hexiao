/**
 */
package edu.ustb.sei.mde.xmu2.statement;

import edu.ustb.sei.mde.xmu2.expression.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Case Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getExpressionCaseClause()
 * @model
 * @generated
 */
public interface ExpressionCaseClause extends CaseClause {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Expression)
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getExpressionCaseClause_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getCondition();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.statement.ExpressionCaseClause#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Expression value);

} // ExpressionCaseClause
