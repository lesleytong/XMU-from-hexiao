/**
 */
package edu.ustb.sei.mde.xmu2.statement;

import edu.ustb.sei.mde.xmu2.expression.VariableExpression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.SwitchStatement#getRoot <em>Root</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.SwitchStatement#getCases <em>Cases</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getSwitchStatement()
 * @model
 * @generated
 */
public interface SwitchStatement extends BidirectionalStatement {
	/**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(VariableExpression)
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getSwitchStatement_Root()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VariableExpression getRoot();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.statement.SwitchStatement#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(VariableExpression value);

	/**
	 * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2.statement.CaseClause}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cases</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2.statement.StatementPackage#getSwitchStatement_Cases()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<CaseClause> getCases();

} // SwitchStatement
