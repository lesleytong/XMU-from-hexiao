/**
 */
package edu.ustb.sei.mde.xmu2.expression;

import edu.ustb.sei.mde.xmu2common.RelationalOperator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relational Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.RelationalExpression#getOperator <em>Operator</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.RelationalExpression#getLeft <em>Left</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.RelationalExpression#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getRelationalExpression()
 * @model
 * @generated
 */
public interface RelationalExpression extends BooleanAndExpressionChild {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.xmu2common.RelationalOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu2common.RelationalOperator
	 * @see #setOperator(RelationalOperator)
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getRelationalExpression_Operator()
	 * @model required="true"
	 * @generated
	 */
	RelationalOperator getOperator();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.expression.RelationalExpression#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu2common.RelationalOperator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(RelationalOperator value);

	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(RelationalExpressionChild)
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getRelationalExpression_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RelationalExpressionChild getLeft();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.expression.RelationalExpression#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(RelationalExpressionChild value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(RelationalExpressionChild)
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getRelationalExpression_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	RelationalExpressionChild getRight();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.expression.RelationalExpression#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(RelationalExpressionChild value);

} // RelationalExpression
