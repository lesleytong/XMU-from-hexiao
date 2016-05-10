/**
 */
package edu.ustb.sei.mde.xmu2core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.VariableExpression#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getVariableExpression()
 * @model
 * @generated
 */
public interface VariableExpression extends AtomicExpression {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(Variable)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getVariableExpression_Variable()
	 * @model required="true"
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.VariableExpression#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

} // VariableExpression
