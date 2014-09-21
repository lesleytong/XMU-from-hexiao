/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

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
 *   <li>{@link edu.ustb.sei.mde.morel.LinkConstraint#getId <em>Id</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.LinkConstraint#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getLinkConstraint()
 * @model
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
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getLinkConstraint_Id()
	 * @model containment="true"
	 * @generated
	 */
	Expression getId();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.LinkConstraint#getId <em>Id</em>}' containment reference.
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
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getLinkConstraint_Reference()
	 * @model required="true"
	 * @generated
	 */
	EReference getReference();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.LinkConstraint#getReference <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(EReference value);

} // LinkConstraint
