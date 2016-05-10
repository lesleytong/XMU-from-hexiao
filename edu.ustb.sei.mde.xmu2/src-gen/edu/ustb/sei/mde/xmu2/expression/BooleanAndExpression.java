/**
 */
package edu.ustb.sei.mde.xmu2.expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Boolean And Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression#getOperands <em>Operands</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getBooleanAndExpression()
 * @model
 * @generated
 */
public interface BooleanAndExpression extends BooleanOrExpressionChild {
	/**
	 * Returns the value of the '<em><b>Operands</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2.expression.BooleanAndExpressionChild}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operands</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operands</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage#getBooleanAndExpression_Operands()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<BooleanAndExpressionChild> getOperands();

} // BooleanAndExpression
