/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Helper Mapping Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.HelperMappingEntry#getLeft <em>Left</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.HelperMappingEntry#getRight <em>Right</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getHelperMappingEntry()
 * @model
 * @generated
 */
public interface HelperMappingEntry extends EObject {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(Expr)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getHelperMappingEntry_Left()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getLeft();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.HelperMappingEntry#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(Expr value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(Expr)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getHelperMappingEntry_Right()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getRight();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.HelperMappingEntry#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(Expr value);

} // HelperMappingEntry
