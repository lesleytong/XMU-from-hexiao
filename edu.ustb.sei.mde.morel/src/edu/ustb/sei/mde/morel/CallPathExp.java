/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Path Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.CallPathExp#getNext <em>Next</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getCallPathExp()
 * @model abstract="true"
 * @generated
 */
public interface CallPathExp extends EObject {
	/**
	 * Returns the value of the '<em><b>Next</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next</em>' containment reference.
	 * @see #setNext(CallPathExp)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getCallPathExp_Next()
	 * @model containment="true"
	 * @generated
	 */
	CallPathExp getNext();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.CallPathExp#getNext <em>Next</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next</em>' containment reference.
	 * @see #getNext()
	 * @generated
	 */
	void setNext(CallPathExp value);

} // CallPathExp
