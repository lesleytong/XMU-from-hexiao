/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.PathConstraint#getMaxLength <em>Max Length</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.PathConstraint#getPathVariable <em>Path Variable</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.PathConstraint#getReferences <em>References</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.PathConstraint#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getPathConstraint()
 * @model
 * @generated
 */
public interface PathConstraint extends LinkConstraint {
	/**
	 * Returns the value of the '<em><b>Max Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Length</em>' attribute.
	 * @see #setMaxLength(int)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getPathConstraint_MaxLength()
	 * @model
	 * @generated
	 */
	int getMaxLength();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.PathConstraint#getMaxLength <em>Max Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Length</em>' attribute.
	 * @see #getMaxLength()
	 * @generated
	 */
	void setMaxLength(int value);

	/**
	 * Returns the value of the '<em><b>Path Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path Variable</em>' reference.
	 * @see #setPathVariable(Variable)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getPathConstraint_PathVariable()
	 * @model required="true"
	 * @generated
	 */
	Variable getPathVariable();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.PathConstraint#getPathVariable <em>Path Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path Variable</em>' reference.
	 * @see #getPathVariable()
	 * @generated
	 */
	void setPathVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>References</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>References</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getPathConstraint_References()
	 * @model required="true"
	 * @generated
	 */
	EList<EReference> getReferences();

	/**
	 * Returns the value of the '<em><b>Types</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Types</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Types</em>' reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getPathConstraint_Types()
	 * @model
	 * @generated
	 */
	EList<EClass> getTypes();

} // PathConstraint
