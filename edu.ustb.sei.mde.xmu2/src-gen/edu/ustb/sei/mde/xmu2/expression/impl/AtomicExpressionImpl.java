/**
 */
package edu.ustb.sei.mde.xmu2.expression.impl;

import edu.ustb.sei.mde.xmu2.expression.AtomicExpression;
import edu.ustb.sei.mde.xmu2.expression.ExpressionPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atomic Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class AtomicExpressionImpl extends UnaryExpressionChildImpl implements AtomicExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AtomicExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.ATOMIC_EXPRESSION;
	}

} //AtomicExpressionImpl
