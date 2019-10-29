/**
 */
package edu.ustb.sei.mde.xmu2core;

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
 *   <li>{@link edu.ustb.sei.mde.xmu2core.AdditiveExpression#getOperands <em>Operands</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.AdditiveExpression#getOperators <em>Operators</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getAdditiveExpression()
 * @model
 * @generated
 */
public interface AdditiveExpression extends Expression {
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
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getAdditiveExpression_Operands()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getOperands();

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
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getAdditiveExpression_Operators()
	 * @model unique="false"
	 * @generated
	 */
	EList<AdditiveOperator> getOperators();

} // AdditiveExpression
