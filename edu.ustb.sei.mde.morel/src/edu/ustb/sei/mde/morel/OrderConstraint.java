/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Order Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.OrderConstraint#getBase <em>Base</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.OrderConstraint#getReferences <em>References</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.OrderConstraint#getTypes <em>Types</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getOrderConstraint()
 * @model
 * @generated
 */
public interface OrderConstraint extends AdditionalConstraint {
	/**
	 * Returns the value of the '<em><b>Base</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base</em>' reference.
	 * @see #setBase(ObjectVariable)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getOrderConstraint_Base()
	 * @model required="true"
	 * @generated
	 */
	ObjectVariable getBase();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.OrderConstraint#getBase <em>Base</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base</em>' reference.
	 * @see #getBase()
	 * @generated
	 */
	void setBase(ObjectVariable value);

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
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getOrderConstraint_References()
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
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getOrderConstraint_Types()
	 * @model required="true"
	 * @generated
	 */
	EList<EClass> getTypes();

} // OrderConstraint
