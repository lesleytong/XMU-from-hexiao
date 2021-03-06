/**
 */
package edu.ustb.sei.mde.morel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Implies Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.BooleanImpliesExp#getLeft <em>Left</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BooleanImpliesExp#getRight <em>Right</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BooleanImpliesExp#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getBooleanImpliesExp()
 * @model
 * @generated
 */
public interface BooleanImpliesExp extends Expression {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(BooleanImpliesExpChild)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBooleanImpliesExp_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	BooleanImpliesExpChild getLeft();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BooleanImpliesExp#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(BooleanImpliesExpChild value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(BooleanImpliesExpChild)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBooleanImpliesExp_Right()
	 * @model containment="true"
	 * @generated
	 */
	BooleanImpliesExpChild getRight();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BooleanImpliesExp#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(BooleanImpliesExpChild value);

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
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBooleanImpliesExp_Operator()
	 * @model
	 * @generated
	 */
	BooleanOperator getOperator();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BooleanImpliesExp#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.BooleanOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(BooleanOperator value);

} // BooleanImpliesExp
