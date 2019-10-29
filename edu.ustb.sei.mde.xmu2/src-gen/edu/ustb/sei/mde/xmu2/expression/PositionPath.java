/**
 */
package edu.ustb.sei.mde.xmu2.expression;

import edu.ustb.sei.mde.xmu2common.PositionOperator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Position Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.PositionPath#getType <em>Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.PositionPath#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getPositionPath()
 * @model
 * @generated
 */
public interface PositionPath extends Path {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.xmu2common.PositionOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu2common.PositionOperator
	 * @see #setType(PositionOperator)
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getPositionPath_Type()
	 * @model required="true"
	 * @generated
	 */
	PositionOperator getType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.expression.PositionPath#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu2common.PositionOperator
	 * @see #getType()
	 * @generated
	 */
	void setType(PositionOperator value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Expression)
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getPositionPath_Value()
	 * @model containment="true"
	 * @generated
	 */
	Expression getValue();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.expression.PositionPath#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Expression value);

} // PositionPath
