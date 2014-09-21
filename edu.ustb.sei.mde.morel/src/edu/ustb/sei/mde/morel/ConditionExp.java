/**
 */
package edu.ustb.sei.mde.morel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Condition Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.ConditionExp#getCondition <em>Condition</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.ConditionExp#getThenBranch <em>Then Branch</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.ConditionExp#getElseBranch <em>Else Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getConditionExp()
 * @model
 * @generated
 */
public interface ConditionExp extends Expression {
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
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getConditionExp_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BooleanImpliesExp getCondition();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.ConditionExp#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(BooleanImpliesExp value);

	/**
	 * Returns the value of the '<em><b>Then Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Then Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Then Branch</em>' containment reference.
	 * @see #setThenBranch(Expression)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getConditionExp_ThenBranch()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getThenBranch();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.ConditionExp#getThenBranch <em>Then Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Then Branch</em>' containment reference.
	 * @see #getThenBranch()
	 * @generated
	 */
	void setThenBranch(Expression value);

	/**
	 * Returns the value of the '<em><b>Else Branch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Else Branch</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Else Branch</em>' containment reference.
	 * @see #setElseBranch(Expression)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getConditionExp_ElseBranch()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getElseBranch();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.ConditionExp#getElseBranch <em>Else Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Else Branch</em>' containment reference.
	 * @see #getElseBranch()
	 * @generated
	 */
	void setElseBranch(Expression value);

} // ConditionExp
