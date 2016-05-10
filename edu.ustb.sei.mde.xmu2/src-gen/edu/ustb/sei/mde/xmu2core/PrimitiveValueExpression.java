/**
 */
package edu.ustb.sei.mde.xmu2core;

import org.eclipse.emf.ecore.EDataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Value Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.PrimitiveValueExpression#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getPrimitiveValueExpression()
 * @model abstract="true"
 * @generated
 */
public interface PrimitiveValueExpression extends AtomicExpression {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EDataType)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getPrimitiveValueExpression_Type()
	 * @model
	 * @generated
	 */
	EDataType getType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.PrimitiveValueExpression#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EDataType value);

} // PrimitiveValueExpression
