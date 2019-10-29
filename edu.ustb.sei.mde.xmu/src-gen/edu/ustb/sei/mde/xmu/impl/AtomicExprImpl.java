/**
 */
package edu.ustb.sei.mde.xmu.impl;

import edu.ustb.sei.mde.xmu.AtomicExpr;
import edu.ustb.sei.mde.xmu.XmuPackage;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Atomic Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class AtomicExprImpl extends UnaryExprChildImpl implements AtomicExpr {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AtomicExprImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmuPackage.Literals.ATOMIC_EXPR;
	}

} //AtomicExprImpl
