/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicative Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.MultiplicativeExp#getChildren <em>Children</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.MultiplicativeExp#getOperators <em>Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getMultiplicativeExp()
 * @model
 * @generated
 */
public interface MultiplicativeExp extends AdditiveExpChild {
	/**
	 * Returns the value of the '<em><b>Children</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.MultiplicativeExpChild}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getMultiplicativeExp_Children()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<MultiplicativeExpChild> getChildren();

	/**
	 * Returns the value of the '<em><b>Operators</b></em>' attribute list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.MultiplicativeOperator}.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.MultiplicativeOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' attribute list.
	 * @see edu.ustb.sei.mde.morel.MultiplicativeOperator
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getMultiplicativeExp_Operators()
	 * @model unique="false"
	 * @generated
	 */
	EList<MultiplicativeOperator> getOperators();

} // MultiplicativeExp
