/**
 */
package edu.ustb.sei.mde.xmu;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Paren Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.ParenExpr#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getParenExpr()
 * @model
 * @generated
 */
public interface ParenExpr extends AtomicExpr {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Expr)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getParenExpr_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getBody();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.ParenExpr#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Expr value);

} // ParenExpr
