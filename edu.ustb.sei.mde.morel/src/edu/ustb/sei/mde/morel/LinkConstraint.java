/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Link Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.LinkConstraint#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.LinkConstraint#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getLinkConstraint()
 * @model abstract="true"
 * @generated
 */
public interface LinkConstraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ObjectVariable)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getLinkConstraint_Source()
	 * @model required="true"
	 * @generated
	 */
	ObjectVariable getSource();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.LinkConstraint#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ObjectVariable value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ObjectVariable)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getLinkConstraint_Target()
	 * @model required="true"
	 * @generated
	 */
	ObjectVariable getTarget();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.LinkConstraint#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(ObjectVariable value);

} // LinkConstraint
