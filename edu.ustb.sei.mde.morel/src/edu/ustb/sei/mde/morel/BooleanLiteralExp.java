/**
 */
package edu.ustb.sei.mde.morel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.BooleanLiteralExp#isBoolSymbol <em>Bool Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getBooleanLiteralExp()
 * @model
 * @generated
 */
public interface BooleanLiteralExp extends LiteralExp {
	/**
	 * Returns the value of the '<em><b>Bool Symbol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bool Symbol</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bool Symbol</em>' attribute.
	 * @see #setBoolSymbol(boolean)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBooleanLiteralExp_BoolSymbol()
	 * @model required="true"
	 * @generated
	 */
	boolean isBoolSymbol();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.BooleanLiteralExp#isBoolSymbol <em>Bool Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bool Symbol</em>' attribute.
	 * @see #isBoolSymbol()
	 * @generated
	 */
	void setBoolSymbol(boolean value);

} // BooleanLiteralExp
