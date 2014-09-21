/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.Section#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getSection()
 * @model abstract="true"
 * @generated
 */
public interface Section extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.SectionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.SectionType
	 * @see #setType(SectionType)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getSection_Type()
	 * @model required="true"
	 * @generated
	 */
	SectionType getType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.Section#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.SectionType
	 * @see #getType()
	 * @generated
	 */
	void setType(SectionType value);

} // Section
