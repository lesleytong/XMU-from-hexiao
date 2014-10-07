/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enclosure Link Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.EnclosureLinkConstraint#getForward <em>Forward</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getEnclosureLinkConstraint()
 * @model
 * @generated
 */
public interface EnclosureLinkConstraint extends LinkConstraint {
	/**
	 * Returns the value of the '<em><b>Forward</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forward</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forward</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getEnclosureLinkConstraint_Forward()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<EReference> getForward();

} // EnclosureLinkConstraint
