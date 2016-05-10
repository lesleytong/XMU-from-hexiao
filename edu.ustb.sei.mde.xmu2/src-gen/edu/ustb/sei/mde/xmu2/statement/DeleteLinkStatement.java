/**
 */
package edu.ustb.sei.mde.xmu2.statement;

import edu.ustb.sei.mde.xmu2.expression.Expression;
import edu.ustb.sei.mde.xmu2.expression.VariableExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delete Link Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement#getTarget <em>Target</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getDeleteLinkStatement()
 * @model
 * @generated
 */
public interface DeleteLinkStatement extends UnidirectionalStatement {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(VariableExpression)
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getDeleteLinkStatement_Source()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VariableExpression getSource();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(VariableExpression value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(Expression)
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getDeleteLinkStatement_Target()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getTarget();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Expression value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' attribute.
	 * @see #setFeature(String)
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getDeleteLinkStatement_Feature()
	 * @model required="true"
	 * @generated
	 */
	String getFeature();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.statement.DeleteLinkStatement#getFeature <em>Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' attribute.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(String value);

} // DeleteLinkStatement
