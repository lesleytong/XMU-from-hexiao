/**
 */
package edu.ustb.sei.mde.xmu2.expression.impl;

import edu.ustb.sei.mde.xmu2.expression.AdditiveExpression;
import edu.ustb.sei.mde.xmu2.expression.AdditiveExpressionChild;
import edu.ustb.sei.mde.xmu2.expression.ExpressionPackage;

import edu.ustb.sei.mde.xmu2common.AdditiveOperator;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Additive Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.impl.AdditiveExpressionImpl#getOperators <em>Operators</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.impl.AdditiveExpressionImpl#getOperands <em>Operands</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AdditiveExpressionImpl extends RelationalExpressionChildImpl implements AdditiveExpression {
	/**
	 * The cached value of the '{@link #getOperators() <em>Operators</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperators()
	 * @generated
	 * @ordered
	 */
	protected EList<AdditiveOperator> operators;

	/**
	 * The cached value of the '{@link #getOperands() <em>Operands</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperands()
	 * @generated
	 * @ordered
	 */
	protected EList<AdditiveExpressionChild> operands;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AdditiveExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.ADDITIVE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AdditiveOperator> getOperators() {
		if (operators == null) {
			operators = new EDataTypeEList<AdditiveOperator>(AdditiveOperator.class, this, ExpressionPackage.ADDITIVE_EXPRESSION__OPERATORS);
		}
		return operators;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AdditiveExpressionChild> getOperands() {
		if (operands == null) {
			operands = new EObjectContainmentEList<AdditiveExpressionChild>(AdditiveExpressionChild.class, this, ExpressionPackage.ADDITIVE_EXPRESSION__OPERANDS);
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
			case ExpressionPackage.ADDITIVE_EXPRESSION__OPERANDS:
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
			case ExpressionPackage.ADDITIVE_EXPRESSION__OPERATORS:
				return getOperators();
			case ExpressionPackage.ADDITIVE_EXPRESSION__OPERANDS:
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
			case ExpressionPackage.ADDITIVE_EXPRESSION__OPERATORS:
				getOperators().clear();
				getOperators().addAll((Collection<? extends AdditiveOperator>)newValue);
				return;
			case ExpressionPackage.ADDITIVE_EXPRESSION__OPERANDS:
				getOperands().clear();
				getOperands().addAll((Collection<? extends AdditiveExpressionChild>)newValue);
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
			case ExpressionPackage.ADDITIVE_EXPRESSION__OPERATORS:
				getOperators().clear();
				return;
			case ExpressionPackage.ADDITIVE_EXPRESSION__OPERANDS:
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
			case ExpressionPackage.ADDITIVE_EXPRESSION__OPERATORS:
				return operators != null && !operators.isEmpty();
			case ExpressionPackage.ADDITIVE_EXPRESSION__OPERANDS:
				return operands != null && !operands.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (operators: ");
		result.append(operators);
		result.append(')');
		return result.toString();
	}

} //AdditiveExpressionImpl
