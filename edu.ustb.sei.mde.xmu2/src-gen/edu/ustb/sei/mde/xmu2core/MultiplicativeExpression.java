/**
 */
package edu.ustb.sei.mde.xmu2core;

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
 *   <li>{@link edu.ustb.sei.mde.xmu2core.MultiplicativeExpression#getOperands <em>Operands</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.MultiplicativeExpression#getOperators <em>Operators</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getMultiplicativeExpression()
 * @model
 * @generated
 */
public interface MultiplicativeExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Operands</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operands</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operands</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getMultiplicativeExpression_Operands()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getOperands();

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
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getMultiplicativeExpression_Operators()
	 * @model unique="false"
	 * @generated
	 */
	EList<MultiplicativeOperator> getOperators();

} // MultiplicativeExpression
