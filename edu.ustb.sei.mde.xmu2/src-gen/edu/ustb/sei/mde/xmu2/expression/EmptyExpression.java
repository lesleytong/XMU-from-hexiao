/**
 */
package edu.ustb.sei.mde.xmu2.expression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Empty Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.EmptyExpression#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getEmptyExpression()
 * @model
 * @generated
 */
public interface EmptyExpression extends ConstantExpression {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.xmu2.expression.EmptyValueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu2.expression.EmptyValueType
	 * @see #setType(EmptyValueType)
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getEmptyExpression_Type()
	 * @model required="true"
	 * @generated
	 */
	EmptyValueType getType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.expression.EmptyExpression#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu2.expression.EmptyValueType
	 * @see #getType()
	 * @generated
	 */
	void setType(EmptyValueType value);

} // EmptyExpression
