/**
 */
package edu.ustb.sei.mde.xmu2common;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2common.DomainElement#getTag <em>Tag</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2common.Xmu2commonPackage#getDomainElement()
 * @model abstract="true"
 * @generated
 */
public interface DomainElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Tag</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.xmu2common.DomainTag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tag</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tag</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu2common.DomainTag
	 * @see #setTag(DomainTag)
	 * @see edu.ustb.sei.mde.xmu2common.Xmu2commonPackage#getDomainElement_Tag()
	 * @model
	 * @generated
	 */
	DomainTag getTag();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2common.DomainElement#getTag <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu2common.DomainTag
	 * @see #getTag()
	 * @generated
	 */
	void setTag(DomainTag value);

} // DomainElement
