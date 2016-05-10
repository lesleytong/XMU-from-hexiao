/**
 */
package edu.ustb.sei.mde.xmu2.expression;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Literal Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression#getType <em>Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getEnumLiteralExpression()
 * @model
 * @generated
 */
public interface EnumLiteralExpression extends ConstantExpression {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EEnum)
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getEnumLiteralExpression_Type()
	 * @model required="true"
	 * @generated
	 */
	EEnum getType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EEnum value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' reference.
	 * @see #setValue(EEnumLiteral)
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getEnumLiteralExpression_Value()
	 * @model required="true"
	 * @generated
	 */
	EEnumLiteral getValue();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EEnumLiteral value);

} // EnumLiteralExpression
