/**
 */
package edu.ustb.sei.mde.xmu2.expression;

import edu.ustb.sei.mde.xmu2common.UnaryOperator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unary Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.UnaryExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.UnaryExpression#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getUnaryExpression()
 * @model
 * @generated
 */
public interface UnaryExpression extends MultiplicativeExpressionChild {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.xmu2common.UnaryOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu2common.UnaryOperator
	 * @see #setOperator(UnaryOperator)
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getUnaryExpression_Operator()
	 * @model required="true"
	 * @generated
	 */
	UnaryOperator getOperator();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.expression.UnaryExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu2common.UnaryOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(UnaryOperator value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(UnaryExpressionChild)
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getUnaryExpression_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	UnaryExpressionChild getBody();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.expression.UnaryExpression#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(UnaryExpressionChild value);

} // UnaryExpression
