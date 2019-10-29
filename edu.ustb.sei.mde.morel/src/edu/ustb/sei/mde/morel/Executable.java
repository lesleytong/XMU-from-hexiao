/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Executable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.Executable#isActive <em>Active</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.Executable#getParameters <em>Parameters</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.Executable#getPrimitiveVariables <em>Primitive Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getExecutable()
 * @model abstract="true"
 * @generated
 */
public interface Executable extends EObject {
	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #setActive(boolean)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getExecutable_Active()
	 * @model default="true"
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.Executable#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' attribute list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getExecutable_Parameters()
	 * @model
	 * @generated
	 */
	EList<String> getParameters();

	/**
	 * Returns the value of the '<em><b>Primitive Variables</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.PrimitiveVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive Variables</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getExecutable_PrimitiveVariables()
	 * @model containment="true"
	 * @generated
	 */
	EList<PrimitiveVariable> getPrimitiveVariables();

} // Executable
