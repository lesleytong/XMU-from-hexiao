/**
 */
package edu.ustb.sei.mde.xmu;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case Value Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.CaseValueStatement#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getCaseValueStatement()
 * @model
 * @generated
 */
public interface CaseValueStatement extends CaseSubStatement {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expr)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getCaseValueStatement_Expression()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getExpression();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.CaseValueStatement#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expr value);

} // CaseValueStatement
