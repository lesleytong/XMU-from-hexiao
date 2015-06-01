/**
 */
package edu.ustb.sei.mde.xmu;




/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Updated Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.UpdatedStatement#getSVar <em>SVar</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.UpdatedStatement#getVVar <em>VVar</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getUpdatedStatement()
 * @model
 * @generated
 */
public interface UpdatedStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>SVar</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SVar</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SVar</em>' reference.
	 * @see #setSVar(Variable)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getUpdatedStatement_SVar()
	 * @model required="true"
	 * @generated
	 */
	Variable getSVar();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.UpdatedStatement#getSVar <em>SVar</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SVar</em>' reference.
	 * @see #getSVar()
	 * @generated
	 */
	void setSVar(Variable value);

	/**
	 * Returns the value of the '<em><b>VVar</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>VVar</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VVar</em>' reference.
	 * @see #setVVar(ObjectVariable)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getUpdatedStatement_VVar()
	 * @model required="true"
	 * @generated
	 */
	ObjectVariable getVVar();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.UpdatedStatement#getVVar <em>VVar</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>VVar</em>' reference.
	 * @see #getVVar()
	 * @generated
	 */
	void setVVar(ObjectVariable value);

} // UpdatedStatement
