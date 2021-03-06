/**
 */
package edu.ustb.sei.mde.morel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable With Init</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.VariableWithInit#getInitExp <em>Init Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getVariableWithInit()
 * @model abstract="true"
 * @generated
 */
public interface VariableWithInit extends Variable {

	/**
	 * Returns the value of the '<em><b>Init Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Exp</em>' containment reference.
	 * @see #setInitExp(Expression)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getVariableWithInit_InitExp()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getInitExp();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.VariableWithInit#getInitExp <em>Init Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Exp</em>' containment reference.
	 * @see #getInitExp()
	 * @generated
	 */
	void setInitExp(Expression value);
} // VariableWithInit
