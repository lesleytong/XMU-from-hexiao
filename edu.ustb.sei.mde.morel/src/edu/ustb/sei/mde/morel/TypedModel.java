/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.TypedModel#getPackage <em>Package</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.TypedModel#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getTypedModel()
 * @model
 * @generated
 */
public interface TypedModel extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' reference.
	 * @see #setPackage(EPackage)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getTypedModel_Package()
	 * @model required="true"
	 * @generated
	 */
	EPackage getPackage();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.TypedModel#getPackage <em>Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(EPackage value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"normal"</code>.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.TypedModelAction}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.TypedModelAction
	 * @see #setType(TypedModelAction)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getTypedModel_Type()
	 * @model default="normal" required="true"
	 * @generated
	 */
	TypedModelAction getType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.TypedModel#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.TypedModelAction
	 * @see #getType()
	 * @generated
	 */
	void setType(TypedModelAction value);

} // TypedModel
