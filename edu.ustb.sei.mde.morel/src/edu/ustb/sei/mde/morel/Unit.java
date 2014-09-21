/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.Unit#getModels <em>Models</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.Unit#getDataTypes <em>Data Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getUnit()
 * @model abstract="true"
 * @generated
 */
public interface Unit extends EObject {
	/**
	 * Returns the value of the '<em><b>Models</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.TypedModel}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Models</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Models</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getUnit_Models()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TypedModel> getModels();

	/**
	 * Returns the value of the '<em><b>Data Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EDataType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Types</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getUnit_DataTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<EDataType> getDataTypes();

} // Unit
