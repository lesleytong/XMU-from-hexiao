/**
 */
package edu.ustb.sei.mde.morel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atomic Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.AtomicExp#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getAtomicExp()
 * @model abstract="true"
 * @generated
 */
public interface AtomicExp extends UnaryExpChild {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' containment reference.
	 * @see #setPath(CallPathExp)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getAtomicExp_Path()
	 * @model containment="true"
	 * @generated
	 */
	CallPathExp getPath();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.AtomicExp#getPath <em>Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' containment reference.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(CallPathExp value);

} // AtomicExp
