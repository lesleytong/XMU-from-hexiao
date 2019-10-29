/**
 */
package edu.ustb.sei.mde.xmu2.expression;

import edu.ustb.sei.mde.xmu2common.MultiplicativeOperator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicative Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression#getOperators <em>Operators</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression#getOperands <em>Operands</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getMultiplicativeExpression()
 * @model
 * @generated
 */
public interface MultiplicativeExpression extends AdditiveExpressionChild {
	/**
	 * Returns the value of the '<em><b>Operators</b></em>' attribute list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2common.MultiplicativeOperator}.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.xmu2common.MultiplicativeOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' attribute list.
	 * @see edu.ustb.sei.mde.xmu2common.MultiplicativeOperator
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getMultiplicativeExpression_Operators()
	 * @model unique="false" required="true"
	 * @generated
	 */
	EList<MultiplicativeOperator> getOperators();

	/**
	 * Returns the value of the '<em><b>Operands</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpressionChild}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operands</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operands</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getMultiplicativeExpression_Operands()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<MultiplicativeExpressionChild> getOperands();

} // MultiplicativeExpression
