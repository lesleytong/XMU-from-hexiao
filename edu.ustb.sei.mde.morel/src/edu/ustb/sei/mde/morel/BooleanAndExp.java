/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean And Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.BooleanAndExp#getChildren <em>Children</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.BooleanAndExp#getOperators <em>Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getBooleanAndExp()
 * @model
 * @generated
 */
public interface BooleanAndExp extends BooleanOrExpChild {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.BooleanAndExpChild}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBooleanAndExp_Children()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<BooleanAndExpChild> getChildren();

	/**
	 * Returns the value of the '<em><b>Operators</b></em>' attribute list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.BooleanOperator}.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.BooleanOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' attribute list.
	 * @see edu.ustb.sei.mde.morel.BooleanOperator
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getBooleanAndExp_Operators()
	 * @model unique="false"
	 * @generated
	 */
	EList<BooleanOperator> getOperators();

} // BooleanAndExp
