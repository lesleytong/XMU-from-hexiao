/**
 */
package edu.ustb.sei.mde.xmu2.expression;

import edu.ustb.sei.mde.xmu2common.AdditiveOperator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Additive Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.AdditiveExpression#getOperators <em>Operators</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.AdditiveExpression#getOperands <em>Operands</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getAdditiveExpression()
 * @model
 * @generated
 */
public interface AdditiveExpression extends RelationalExpressionChild {
	/**
	 * Returns the value of the '<em><b>Operators</b></em>' attribute list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2common.AdditiveOperator}.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.xmu2common.AdditiveOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' attribute list.
	 * @see edu.ustb.sei.mde.xmu2common.AdditiveOperator
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getAdditiveExpression_Operators()
	 * @model unique="false" required="true"
	 * @generated
	 */
	EList<AdditiveOperator> getOperators();

	/**
	 * Returns the value of the '<em><b>Operands</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2.expression.AdditiveExpressionChild}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operands</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operands</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getAdditiveExpression_Operands()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<AdditiveExpressionChild> getOperands();

} // AdditiveExpression
