/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.common.util.EList;




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
	 * Returns the value of the '<em><b>SVar</b></em>' reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SVar</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SVar</em>' reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getUpdatedStatement_SVar()
	 * @model required="true"
	 * @generated
	 */
	EList<Variable> getSVar();

	/**
	 * Returns the value of the '<em><b>VVar</b></em>' reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.ObjectVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>VVar</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VVar</em>' reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getUpdatedStatement_VVar()
	 * @model required="true"
	 * @generated
	 */
	EList<ObjectVariable> getVVar();

} // UpdatedStatement
