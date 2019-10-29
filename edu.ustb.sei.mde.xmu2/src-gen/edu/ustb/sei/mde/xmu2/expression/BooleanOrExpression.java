/**
 */
package edu.ustb.sei.mde.xmu2.expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean Or Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression#getOperands <em>Operands</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getBooleanOrExpression()
 * @model
 * @generated
 */
public interface BooleanOrExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Operands</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2.expression.BooleanOrExpressionChild}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operands</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operands</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getBooleanOrExpression_Operands()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<BooleanOrExpressionChild> getOperands();

} // BooleanOrExpression
