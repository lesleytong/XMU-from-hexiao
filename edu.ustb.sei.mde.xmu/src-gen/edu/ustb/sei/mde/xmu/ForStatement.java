/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.ForStatement#getSPattern <em>SPattern</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.ForStatement#getVPattern <em>VPattern</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.ForStatement#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getForStatement()
 * @model
 * @generated
 */
public interface ForStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>SPattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SPattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SPattern</em>' containment reference.
	 * @see #setSPattern(Pattern)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getForStatement_SPattern()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Pattern getSPattern();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.ForStatement#getSPattern <em>SPattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SPattern</em>' containment reference.
	 * @see #getSPattern()
	 * @generated
	 */
	void setSPattern(Pattern value);

	/**
	 * Returns the value of the '<em><b>VPattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>VPattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VPattern</em>' containment reference.
	 * @see #setVPattern(Pattern)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getForStatement_VPattern()
	 * @model containment="true"
	 * @generated
	 */
	Pattern getVPattern();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.ForStatement#getVPattern <em>VPattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>VPattern</em>' containment reference.
	 * @see #getVPattern()
	 * @generated
	 */
	void setVPattern(Pattern value);

	/**
	 * Returns the value of the '<em><b>Actions</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.VStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actions</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getForStatement_Actions()
	 * @model containment="true" required="true" upper="3"
	 * @generated
	 */
	EList<VStatement> getActions();

} // ForStatement
