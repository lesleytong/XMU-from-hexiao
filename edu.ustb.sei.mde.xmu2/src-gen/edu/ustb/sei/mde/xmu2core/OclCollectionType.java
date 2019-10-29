/**
 */
package edu.ustb.sei.mde.xmu2core;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Collection Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.OclCollectionType#getElementtype <em>Elementtype</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getOclCollectionType()
 * @model
 * @generated
 */
public interface OclCollectionType extends EObject, EClass {
	/**
	 * Returns the value of the '<em><b>Elementtype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elementtype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elementtype</em>' reference.
	 * @see #setElementtype(EClassifier)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getOclCollectionType_Elementtype()
	 * @model required="true"
	 * @generated
	 */
	EClassifier getElementtype();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.OclCollectionType#getElementtype <em>Elementtype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Elementtype</em>' reference.
	 * @see #getElementtype()
	 * @generated
	 */
	void setElementtype(EClassifier value);

} // OclCollectionType
