/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.ecore.EDataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.PrimitiveVariable#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getPrimitiveVariable()
 * @model
 * @generated
 */
public interface PrimitiveVariable extends Variable {
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
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getPrimitiveVariable_Type()
	 * @model required="true"
	 * @generated
	 */
	EDataType getType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.PrimitiveVariable#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EDataType value);

} // PrimitiveVariable
