/**
 */
package edu.ustb.sei.mde.xmu;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pseudo Update</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.PseudoUpdate#getMessage <em>Message</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getPseudoUpdate()
 * @model abstract="true"
 * @generated
 */
public interface PseudoUpdate extends Update {
	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getPseudoUpdate_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.PseudoUpdate#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

} // PseudoUpdate
