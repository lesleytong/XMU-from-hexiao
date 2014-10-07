/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Link Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.SimpleLinkConstraint#getId <em>Id</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.SimpleLinkConstraint#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getSimpleLinkConstraint()
 * @model
 * @generated
 */
public interface SimpleLinkConstraint extends LinkConstraint {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' containment reference.
	 * @see #setId(Expression)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getSimpleLinkConstraint_Id()
	 * @model containment="true"
	 * @generated
	 */
	Expression getId();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.SimpleLinkConstraint#getId <em>Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' containment reference.
	 * @see #getId()
	 * @generated
	 */
	void setId(Expression value);

	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(EReference)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getSimpleLinkConstraint_Reference()
	 * @model required="true"
	 * @generated
	 */
	EReference getReference();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.SimpleLinkConstraint#getReference <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(EReference value);

} // SimpleLinkConstraint
