/**
 */
package edu.ustb.sei.mde.xmu2.expression.impl;

import edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression;
import edu.ustb.sei.mde.xmu2.expression.BooleanAndExpressionChild;
import edu.ustb.sei.mde.xmu2.expression.ExpressionPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean And Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.impl.BooleanAndExpressionImpl#getOperands <em>Operands</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BooleanAndExpressionImpl extends BooleanOrExpressionChildImpl implements BooleanAndExpression {
	/**
	 * The cached value of the '{@link #getOperands() <em>Operands</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperands()
	 * @generated
	 * @ordered
	 */
	protected EList<BooleanAndExpressionChild> operands;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanAndExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.BOOLEAN_AND_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BooleanAndExpressionChild> getOperands() {
		if (operands == null) {
			operands = new EObjectContainmentEList<BooleanAndExpressionChild>(BooleanAndExpressionChild.class, this, ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS);
		}
		return operands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS:
				return ((InternalEList<?>)getOperands()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS:
				return getOperands();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS:
				getOperands().clear();
				getOperands().addAll((Collection<? extends BooleanAndExpressionChild>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS:
				getOperands().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExpressionPackage.BOOLEAN_AND_EXPRESSION__OPERANDS:
				return operands != null && !operands.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BooleanAndExpressionImpl
