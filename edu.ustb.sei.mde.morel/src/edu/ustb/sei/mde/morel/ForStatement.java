/**
 */
package edu.ustb.sei.mde.morel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.ForStatement#getIterator <em>Iterator</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.ForStatement#getTerminationExp <em>Termination Exp</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.ForStatement#getStepExp <em>Step Exp</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.ForStatement#getBodyStatement <em>Body Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getForStatement()
 * @model
 * @generated
 */
public interface ForStatement extends ImperativeStatement {
	/**
	 * Returns the value of the '<em><b>Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterator</em>' containment reference.
	 * @see #setIterator(VariableWithInit)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getForStatement_Iterator()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VariableWithInit getIterator();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.ForStatement#getIterator <em>Iterator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterator</em>' containment reference.
	 * @see #getIterator()
	 * @generated
	 */
	void setIterator(VariableWithInit value);

	/**
	 * Returns the value of the '<em><b>Termination Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Termination Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Termination Exp</em>' containment reference.
	 * @see #setTerminationExp(BooleanImpliesExp)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getForStatement_TerminationExp()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BooleanImpliesExp getTerminationExp();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.ForStatement#getTerminationExp <em>Termination Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Termination Exp</em>' containment reference.
	 * @see #getTerminationExp()
	 * @generated
	 */
	void setTerminationExp(BooleanImpliesExp value);

	/**
	 * Returns the value of the '<em><b>Step Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Exp</em>' containment reference.
	 * @see #setStepExp(Expression)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getForStatement_StepExp()
	 * @model containment="true"
	 * @generated
	 */
	Expression getStepExp();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.ForStatement#getStepExp <em>Step Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Exp</em>' containment reference.
	 * @see #getStepExp()
	 * @generated
	 */
	void setStepExp(Expression value);

	/**
	 * Returns the value of the '<em><b>Body Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body Statement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body Statement</em>' containment reference.
	 * @see #setBodyStatement(ImperativeStatement)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getForStatement_BodyStatement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ImperativeStatement getBodyStatement();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.ForStatement#getBodyStatement <em>Body Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body Statement</em>' containment reference.
	 * @see #getBodyStatement()
	 * @generated
	 */
	void setBodyStatement(ImperativeStatement value);

} // ForStatement
