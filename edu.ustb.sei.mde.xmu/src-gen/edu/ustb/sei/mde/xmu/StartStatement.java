/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Start Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.StartStatement#getRule <em>Rule</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.StartStatement#getRoot <em>Root</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getStartStatement()
 * @model
 * @generated
 */
public interface StartStatement extends EObject {
	/**
	 * Returns the value of the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' reference.
	 * @see #setRule(Rule)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getStartStatement_Rule()
	 * @model required="true"
	 * @generated
	 */
	Rule getRule();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.StartStatement#getRule <em>Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' reference.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(Rule value);

	/**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.StartRoot}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getStartStatement_Root()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<StartRoot> getRoot();

} // StartStatement
