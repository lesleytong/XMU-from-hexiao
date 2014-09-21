/**
 */
package edu.ustb.sei.mde.morel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.IfStatement#getCondition <em>Condition</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.IfStatement#getThenStatement <em>Then Statement</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.IfStatement#getElseStatement <em>Else Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends ImperativeStatement {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(BooleanImpliesExp)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getIfStatement_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BooleanImpliesExp getCondition();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.IfStatement#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(BooleanImpliesExp value);

	/**
	 * Returns the value of the '<em><b>Then Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Statement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Statement</em>' containment reference.
	 * @see #setThenStatement(ImperativeStatement)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getIfStatement_ThenStatement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ImperativeStatement getThenStatement();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.IfStatement#getThenStatement <em>Then Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Statement</em>' containment reference.
	 * @see #getThenStatement()
	 * @generated
	 */
	void setThenStatement(ImperativeStatement value);

	/**
	 * Returns the value of the '<em><b>Else Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Statement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Statement</em>' containment reference.
	 * @see #setElseStatement(ImperativeStatement)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getIfStatement_ElseStatement()
	 * @model containment="true"
	 * @generated
	 */
	ImperativeStatement getElseStatement();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.IfStatement#getElseStatement <em>Else Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Statement</em>' containment reference.
	 * @see #getElseStatement()
	 * @generated
	 */
	void setElseStatement(ImperativeStatement value);

} // IfStatement
