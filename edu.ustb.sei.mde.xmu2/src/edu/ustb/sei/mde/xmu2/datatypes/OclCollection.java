/**
 */
package edu.ustb.sei.mde.xmu2.datatypes;

import org.eclipse.emf.common.util.EList;
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
 *   <li>{@link edu.ustb.sei.mde.xmu2.datatypes.OclCollection#getElements <em>Elements</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.datatypes.OclCollection#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.datatypes.DatatypesPackage#getOclCollection()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface OclCollection extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' attribute list.
	 * @see edu.ustb.sei.mde.xmu2.datatypes.DatatypesPackage#getOclCollection_Elements()
	 * @model unique="false"
	 * @generated
	 */
	EList<Object> getElements();

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see edu.ustb.sei.mde.xmu2.datatypes.DatatypesPackage#getOclCollection_Size()
	 * @model required="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	int getSize();

} // OclCollection
