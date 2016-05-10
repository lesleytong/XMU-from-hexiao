/**
 */
package edu.ustb.sei.mde.xmu2.statement;

import edu.ustb.sei.mde.xmu2.expression.VariableExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delete Node Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement#getNode <em>Node</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getDeleteNodeStatement()
 * @model
 * @generated
 */
public interface DeleteNodeStatement extends UnidirectionalStatement {
	/**
	 * Returns the value of the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' containment reference.
	 * @see #setNode(VariableExpression)
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getDeleteNodeStatement_Node()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VariableExpression getNode();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement#getNode <em>Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' containment reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(VariableExpression value);

} // DeleteNodeStatement
