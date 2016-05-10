/**
 */
package edu.ustb.sei.mde.xmu2core;

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
 *   <li>{@link edu.ustb.sei.mde.xmu2core.UnaryExpression#getBody <em>Body</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.UnaryExpression#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getUnaryExpression()
 * @model
 * @generated
 */
public interface UnaryExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Expression)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getUnaryExpression_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getBody();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.UnaryExpression#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Expression value);

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
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getUnaryExpression_Operator()
	 * @model required="true"
	 * @generated
	 */
	UnaryOperator getOperator();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.UnaryExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu2common.UnaryOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(UnaryOperator value);

} // UnaryExpression
