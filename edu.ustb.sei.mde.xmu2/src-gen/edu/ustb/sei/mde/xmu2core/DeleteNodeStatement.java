/**
 */
package edu.ustb.sei.mde.xmu2core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delete Node Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.DeleteNodeStatement#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getDeleteNodeStatement()
 * @model
 * @generated
 */
public interface DeleteNodeStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Variable)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getDeleteNodeStatement_Target()
	 * @model required="true"
	 * @generated
	 */
	Variable getTarget();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.DeleteNodeStatement#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Variable value);

} // DeleteNodeStatement
