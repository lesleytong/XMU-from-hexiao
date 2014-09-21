/**
 */
package edu.ustb.sei.mde.morel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bind Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.BindExp#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BindExp#getValueExp <em>Value Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getBindExp()
 * @model
 * @generated
 */
public interface BindExp extends ImperativeExp {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(VariableExp)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBindExp_Source()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VariableExp getSource();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BindExp#getSource <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(VariableExp value);

	/**
	 * Returns the value of the '<em><b>Value Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Exp</em>' containment reference.
	 * @see #setValueExp(Expression)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBindExp_ValueExp()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getValueExp();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BindExp#getValueExp <em>Value Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Exp</em>' containment reference.
	 * @see #getValueExp()
	 * @generated
	 */
	void setValueExp(Expression value);

} // BindExp
