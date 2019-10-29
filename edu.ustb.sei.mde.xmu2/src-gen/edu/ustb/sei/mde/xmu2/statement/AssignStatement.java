/**
 */
package edu.ustb.sei.mde.xmu2.statement;

import edu.ustb.sei.mde.xmu2.expression.Expression;
import edu.ustb.sei.mde.xmu2.expression.VariableExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assign Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.AssignStatement#getUpdatedVariable <em>Updated Variable</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.AssignStatement#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getAssignStatement()
 * @model
 * @generated
 */
public interface AssignStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Updated Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Updated Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Updated Variable</em>' containment reference.
	 * @see #setUpdatedVariable(VariableExpression)
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getAssignStatement_UpdatedVariable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VariableExpression getUpdatedVariable();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.statement.AssignStatement#getUpdatedVariable <em>Updated Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Updated Variable</em>' containment reference.
	 * @see #getUpdatedVariable()
	 * @generated
	 */
	void setUpdatedVariable(VariableExpression value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Expression)
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getAssignStatement_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getValue();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.statement.AssignStatement#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Expression value);

} // AssignStatement
