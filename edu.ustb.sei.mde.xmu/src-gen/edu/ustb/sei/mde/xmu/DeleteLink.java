/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Delete Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.DeleteLink#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.DeleteLink#getTarget <em>Target</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.DeleteLink#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getDeleteLink()
 * @model
 * @generated
 */
public interface DeleteLink extends Update {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(ObjectVariable)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getDeleteLink_Source()
	 * @model required="true"
	 * @generated
	 */
	ObjectVariable getSource();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.DeleteLink#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(ObjectVariable value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Variable)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getDeleteLink_Target()
	 * @model required="true"
	 * @generated
	 */
	Variable getTarget();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.DeleteLink#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Variable value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(EStructuralFeature)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getDeleteLink_Feature()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getFeature();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.DeleteLink#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(EStructuralFeature value);

} // DeleteLink
