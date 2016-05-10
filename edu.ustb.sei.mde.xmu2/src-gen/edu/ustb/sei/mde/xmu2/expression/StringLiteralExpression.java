/**
 */
package edu.ustb.sei.mde.xmu2.expression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Literal Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getStringLiteralExpression()
 * @model
 * @generated
 */
public interface StringLiteralExpression extends ConstantExpression {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getStringLiteralExpression_Value()
	 * @model required="true"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // StringLiteralExpression
