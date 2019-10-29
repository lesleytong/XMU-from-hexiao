/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicative Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.MultiplicativeExpr#getOperands <em>Operands</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.MultiplicativeExpr#getOperators <em>Operators</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getMultiplicativeExpr()
 * @model
 * @generated
 */
public interface MultiplicativeExpr extends AdditiveExprChild {
	/**
	 * Returns the value of the '<em><b>Operands</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.MultiplicativeExprChild}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operands</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operands</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getMultiplicativeExpr_Operands()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<MultiplicativeExprChild> getOperands();

	/**
	 * Returns the value of the '<em><b>Operators</b></em>' attribute list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.MultiplicativeOperator}.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.xmu.MultiplicativeOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' attribute list.
	 * @see edu.ustb.sei.mde.xmu.MultiplicativeOperator
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getMultiplicativeExpr_Operators()
	 * @model unique="false" required="true"
	 * @generated
	 */
	EList<MultiplicativeOperator> getOperators();

} // MultiplicativeExpr
