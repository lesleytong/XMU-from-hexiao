/**
 */
package edu.ustb.sei.mde.xmu;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Helper Path</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.HelperPath#getHelper <em>Helper</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getHelperPath()
 * @model
 * @generated
 */
public interface HelperPath extends Path {
	/**
	 * Returns the value of the '<em><b>Helper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Helper</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Helper</em>' reference.
	 * @see #setHelper(HelperMapping)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getHelperPath_Helper()
	 * @model required="true"
	 * @generated
	 */
	HelperMapping getHelper();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.HelperPath#getHelper <em>Helper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Helper</em>' reference.
	 * @see #getHelper()
	 * @generated
	 */
	void setHelper(HelperMapping value);

} // HelperPath
