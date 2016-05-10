/**
 */
package edu.ustb.sei.mde.xmu2core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.Pattern#getRoot <em>Root</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.Pattern#getGuard <em>Guard</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getPattern()
 * @model
 * @generated
 */
public interface Pattern extends EObject {
	/**
	 * Returns the value of the '<em><b>Root</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root</em>' containment reference.
	 * @see #setRoot(PatternNode)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getPattern_Root()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PatternNode getRoot();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.Pattern#getRoot <em>Root</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root</em>' containment reference.
	 * @see #getRoot()
	 * @generated
	 */
	void setRoot(PatternNode value);

	/**
	 * Returns the value of the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' containment reference.
	 * @see #setGuard(Expression)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getPattern_Guard()
	 * @model containment="true"
	 * @generated
	 */
	Expression getGuard();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.Pattern#getGuard <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' containment reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(Expression value);

} // Pattern
