/**
 */
package edu.ustb.sei.mde.xmu2core;

import org.eclipse.emf.ecore.EEnumLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Value Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.EnumValueExpression#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getEnumValueExpression()
 * @model
 * @generated
 */
public interface EnumValueExpression extends PrimitiveValueExpression {
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
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getEnumValueExpression_Value()
	 * @model required="true"
	 * @generated
	 */
	EEnumLiteral getValue();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.EnumValueExpression#getValue <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(EEnumLiteral value);

} // EnumValueExpression
