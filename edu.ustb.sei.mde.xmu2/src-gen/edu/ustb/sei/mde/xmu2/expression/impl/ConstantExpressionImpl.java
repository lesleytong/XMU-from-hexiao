/**
 */
package edu.ustb.sei.mde.xmu2.expression.impl;

import edu.ustb.sei.mde.xmu2.expression.ConstantExpression;
import edu.ustb.sei.mde.xmu2.expression.ExpressionPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constant Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class ConstantExpressionImpl extends AtomicExpressionImpl implements ConstantExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConstantExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.CONSTANT_EXPRESSION;
	}

} //ConstantExpressionImpl
