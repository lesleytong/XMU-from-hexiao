/**
 */
package edu.ustb.sei.mde.xmu2core;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Ocl Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.OclCollection#getElementType <em>Element Type</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getOclCollection()
 * @model abstract="true"
 * @generated
 */
public interface OclCollection extends EObject {
	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' reference.
	 * @see #setElementType(EClassifier)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getOclCollection_ElementType()
	 * @model required="true"
	 * @generated
	 */
	EClassifier getElementType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.OclCollection#getElementType <em>Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type</em>' reference.
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(EClassifier value);

} // OclCollection
