/**
 */
package edu.ustb.sei.mde.xmu2common;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reflective Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2common.ReflectiveObject#getEContainer <em>EContainer</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2common.ReflectiveObject#getEContents <em>EContents</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2common.ReflectiveObject#getEAllContents <em>EAll Contents</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2common.ReflectiveObject#getEDynamticFeature <em>EDynamtic Feature</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2common.Xmu2commonPackage#getReflectiveObject()
 * @model abstract="true"
 * @generated
 */
public interface ReflectiveObject extends EObject {
	/**
	 * Returns the value of the '<em><b>EContainer</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EContainer</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EContainer</em>' reference.
	 * @see edu.ustb.sei.mde.xmu2common.Xmu2commonPackage#getReflectiveObject_EContainer()
	 * @model changeable="false"
	 * @generated
	 */
	EObject getEContainer();

	/**
	 * Returns the value of the '<em><b>EContents</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EContents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EContents</em>' reference list.
	 * @see edu.ustb.sei.mde.xmu2common.Xmu2commonPackage#getReflectiveObject_EContents()
	 * @model changeable="false"
	 * @generated
	 */
	EList<EObject> getEContents();

	/**
	 * Returns the value of the '<em><b>EAll Contents</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EAll Contents</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EAll Contents</em>' reference list.
	 * @see edu.ustb.sei.mde.xmu2common.Xmu2commonPackage#getReflectiveObject_EAllContents()
	 * @model changeable="false"
	 * @generated
	 */
	EList<EObject> getEAllContents();

	/**
	 * Returns the value of the '<em><b>EDynamtic Feature</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EDynamtic Feature</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>EDynamtic Feature</em>' attribute list.
	 * @see edu.ustb.sei.mde.xmu2common.Xmu2commonPackage#getReflectiveObject_EDynamticFeature()
	 * @model
	 * @generated
	 */
	EList<Object> getEDynamticFeature();

} // ReflectiveObject
