/**
 */
package edu.ustb.sei.mde.morel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relational Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.RelationalExp#getLeft <em>Left</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.RelationalExp#getRight <em>Right</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.RelationalExp#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getRelationalExp()
 * @model
 * @generated
 */
public interface RelationalExp extends BooleanAndExpChild {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(RelationalExpChild)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getRelationalExp_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RelationalExpChild getLeft();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.RelationalExp#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(RelationalExpChild value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(RelationalExpChild)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getRelationalExp_Right()
	 * @model containment="true"
	 * @generated
	 */
	RelationalExpChild getRight();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.RelationalExp#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(RelationalExpChild value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.RelationalOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.RelationalOperator
	 * @see #setOperator(RelationalOperator)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getRelationalExp_Operator()
	 * @model
	 * @generated
	 */
	RelationalOperator getOperator();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.RelationalExp#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.RelationalOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(RelationalOperator value);

} // RelationalExp
