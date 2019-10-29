/**
 */
package edu.ustb.sei.mde.xmu2;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry Point</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.EntryPoint#getRule <em>Rule</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.EntryPoint#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getEntryPoint()
 * @model
 * @generated
 */
public interface EntryPoint extends EObject {
	/**
	 * Returns the value of the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' reference.
	 * @see #setRule(ModelRule)
	 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getEntryPoint_Rule()
	 * @model required="true"
	 * @generated
	 */
	ModelRule getRule();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.EntryPoint#getRule <em>Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' reference.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(ModelRule value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2.EntryData}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getEntryPoint_Parameters()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<EntryData> getParameters();

} // EntryPoint
