/**
 */
package edu.ustb.sei.mde.xmu;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relational Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.RelationalExpr#getLeft <em>Left</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.RelationalExpr#getRight <em>Right</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.RelationalExpr#getOperator <em>Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getRelationalExpr()
 * @model
 * @generated
 */
public interface RelationalExpr extends BooleanAndExprChild {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(RelationalExprChild)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getRelationalExpr_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RelationalExprChild getLeft();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.RelationalExpr#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(RelationalExprChild value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(RelationalExprChild)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getRelationalExpr_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RelationalExprChild getRight();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.RelationalExpr#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(RelationalExprChild value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.xmu.RelationalOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu.RelationalOperator
	 * @see #setOperator(RelationalOperator)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getRelationalExpr_Operator()
	 * @model required="true"
	 * @generated
	 */
	RelationalOperator getOperator();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.RelationalExpr#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu.RelationalOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(RelationalOperator value);

} // RelationalExpr
