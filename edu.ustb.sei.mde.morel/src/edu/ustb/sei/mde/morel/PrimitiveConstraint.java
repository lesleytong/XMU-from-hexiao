/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.PrimitiveConstraint#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getPrimitiveConstraint()
 * @model abstract="true"
 * @generated
 */
public interface PrimitiveConstraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(PrimitiveVariable)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getPrimitiveConstraint_Variable()
	 * @model required="true"
	 * @generated
	 */
	PrimitiveVariable getVariable();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.PrimitiveConstraint#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(PrimitiveVariable value);

} // PrimitiveConstraint
