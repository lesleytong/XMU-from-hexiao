/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Additive Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.AdditiveExp#getChildren <em>Children</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.AdditiveExp#getOperators <em>Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getAdditiveExp()
 * @model
 * @generated
 */
public interface AdditiveExp extends RelationalExpChild {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.AdditiveExpChild}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getAdditiveExp_Children()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<AdditiveExpChild> getChildren();

	/**
	 * Returns the value of the '<em><b>Operators</b></em>' attribute list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.AdditiveOperator}.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.AdditiveOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' attribute list.
	 * @see edu.ustb.sei.mde.morel.AdditiveOperator
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getAdditiveExp_Operators()
	 * @model unique="false"
	 * @generated
	 */
	EList<AdditiveOperator> getOperators();

} // AdditiveExp
