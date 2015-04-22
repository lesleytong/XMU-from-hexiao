/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Additive Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.AdditiveExpr#getOperands <em>Operands</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.AdditiveExpr#getOperators <em>Operators</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getAdditiveExpr()
 * @model
 * @generated
 */
public interface AdditiveExpr extends RelationalExprChild {
	/**
	 * Returns the value of the '<em><b>Operands</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.AdditiveExprChild}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operands</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operands</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getAdditiveExpr_Operands()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<AdditiveExprChild> getOperands();

	/**
	 * Returns the value of the '<em><b>Operators</b></em>' attribute list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.AdditiveOperator}.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.xmu.AdditiveOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' attribute list.
	 * @see edu.ustb.sei.mde.xmu.AdditiveOperator
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getAdditiveExpr_Operators()
	 * @model unique="false" required="true"
	 * @generated
	 */
	EList<AdditiveOperator> getOperators();

} // AdditiveExpr
