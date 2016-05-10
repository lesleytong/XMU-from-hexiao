/**
 */
package edu.ustb.sei.mde.xmu2.expression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.VariableExpression#getVariable <em>Variable</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getVariableExpression()
 * @model
 * @generated
 */
public interface VariableExpression extends AtomicExpression {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' attribute.
	 * @see #setVariable(String)
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getVariableExpression_Variable()
	 * @model required="true"
	 * @generated
	 */
	String getVariable();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.expression.VariableExpression#getVariable <em>Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' attribute.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(String value);

} // VariableExpression
