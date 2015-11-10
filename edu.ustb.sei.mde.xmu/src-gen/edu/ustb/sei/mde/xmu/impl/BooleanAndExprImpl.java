/**
 */
package edu.ustb.sei.mde.xmu.impl;

import edu.ustb.sei.mde.xmu.BooleanAndExpr;
import edu.ustb.sei.mde.xmu.BooleanAndExprChild;
import edu.ustb.sei.mde.xmu.XmuPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean And Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.BooleanAndExprImpl#getOperands <em>Operands</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BooleanAndExprImpl extends BooleanOrExprChildImpl implements BooleanAndExpr {
	/**
	 * The cached value of the '{@link #getOperands() <em>Operands</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperands()
	 * @generated
	 * @ordered
	 */
	protected EList<BooleanAndExprChild> operands;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanAndExprImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmuPackage.Literals.BOOLEAN_AND_EXPR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<BooleanAndExprChild> getOperands() {
		if (operands == null) {
			operands = new EObjectContainmentEList<BooleanAndExprChild>(BooleanAndExprChild.class, this, XmuPackage.BOOLEAN_AND_EXPR__OPERANDS);
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
			case XmuPackage.BOOLEAN_AND_EXPR__OPERANDS:
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
			case XmuPackage.BOOLEAN_AND_EXPR__OPERANDS:
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
			case XmuPackage.BOOLEAN_AND_EXPR__OPERANDS:
				getOperands().clear();
				getOperands().addAll((Collection<? extends BooleanAndExprChild>)newValue);
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
			case XmuPackage.BOOLEAN_AND_EXPR__OPERANDS:
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
			case XmuPackage.BOOLEAN_AND_EXPR__OPERANDS:
				return operands != null && !operands.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BooleanAndExprImpl
