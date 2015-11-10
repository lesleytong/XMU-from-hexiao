/**
 */
package edu.ustb.sei.mde.xmu;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.UnaryExpr#getBody <em>Body</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.UnaryExpr#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getUnaryExpr()
 * @model
 * @generated
 */
public interface UnaryExpr extends MultiplicativeExprChild {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(UnaryExprChild)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getUnaryExpr_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	UnaryExprChild getBody();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.UnaryExpr#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(UnaryExprChild value);

	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The default value is <code>"not"</code>.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.xmu.UnaryOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu.UnaryOperator
	 * @see #setOperator(UnaryOperator)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getUnaryExpr_Operator()
	 * @model default="not" required="true"
	 * @generated
	 */
	UnaryOperator getOperator();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.UnaryExpr#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu.UnaryOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(UnaryOperator value);

} // UnaryExpr
