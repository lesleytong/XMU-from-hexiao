/**
 */
package edu.ustb.sei.mde.xmu;



/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.StartRoot#getId <em>Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getStartRoot()
 * @model
 * @generated
 */
public interface StartRoot extends TaggedElement {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getStartRoot_Id()
	 * @model default="0" required="true"
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.StartRoot#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

} // StartRoot
