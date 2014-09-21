/**
 */
package edu.ustb.sei.mde.morel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean And Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.BooleanAndExp#getLeft <em>Left</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BooleanAndExp#getRight <em>Right</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BooleanAndExp#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getBooleanAndExp()
 * @model
 * @generated
 */
public interface BooleanAndExp extends BooleanOrExpChild {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(BooleanAndExpChild)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBooleanAndExp_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BooleanAndExpChild getLeft();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BooleanAndExp#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(BooleanAndExpChild value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(BooleanAndExpChild)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBooleanAndExp_Right()
	 * @model containment="true"
	 * @generated
	 */
	BooleanAndExpChild getRight();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BooleanAndExp#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(BooleanAndExpChild value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.BooleanOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.BooleanOperator
	 * @see #setOperator(BooleanOperator)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBooleanAndExp_Operator()
	 * @model
	 * @generated
	 */
	BooleanOperator getOperator();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BooleanAndExp#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.BooleanOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(BooleanOperator value);

} // BooleanAndExp
