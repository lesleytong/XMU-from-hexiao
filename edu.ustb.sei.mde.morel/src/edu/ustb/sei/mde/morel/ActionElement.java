/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.ActionElement#getActionType <em>Action Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getActionElement()
 * @model abstract="true"
 * @generated
 */
public interface ActionElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Action Type</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.ActionElementType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Action Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Action Type</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.ActionElementType
	 * @see #setActionType(ActionElementType)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getActionElement_ActionType()
	 * @model
	 * @generated
	 */
	ActionElementType getActionType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.ActionElement#getActionType <em>Action Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Action Type</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.ActionElementType
	 * @see #getActionType()
	 * @generated
	 */
	void setActionType(ActionElementType value);

} // ActionElement
