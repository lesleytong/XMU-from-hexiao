/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.Expression;
import edu.ustb.sei.mde.morel.MorelPackage;
import edu.ustb.sei.mde.morel.ObjectVariableWithInit;

import edu.ustb.sei.mde.morel.VariableWithInit;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Variable With Init</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.ObjectVariableWithInitImpl#getInitExp <em>Init Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectVariableWithInitImpl extends ObjectVariableImpl implements ObjectVariableWithInit {
	/**
	 * The cached value of the '{@link #getInitExp() <em>Init Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitExp()
	 * @generated
	 * @ordered
	 */
	protected Expression initExp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectVariableWithInitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorelPackage.Literals.OBJECT_VARIABLE_WITH_INIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getInitExp() {
		return initExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitExp(Expression newInitExp, NotificationChain msgs) {
		Expression oldInitExp = initExp;
		initExp = newInitExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.OBJECT_VARIABLE_WITH_INIT__INIT_EXP, oldInitExp, newInitExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitExp(Expression newInitExp) {
		if (newInitExp != initExp) {
			NotificationChain msgs = null;
			if (initExp != null)
				msgs = ((InternalEObject)initExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.OBJECT_VARIABLE_WITH_INIT__INIT_EXP, null, msgs);
			if (newInitExp != null)
				msgs = ((InternalEObject)newInitExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.OBJECT_VARIABLE_WITH_INIT__INIT_EXP, null, msgs);
			msgs = basicSetInitExp(newInitExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.OBJECT_VARIABLE_WITH_INIT__INIT_EXP, newInitExp, newInitExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MorelPackage.OBJECT_VARIABLE_WITH_INIT__INIT_EXP:
				return basicSetInitExp(null, msgs);
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
			case MorelPackage.OBJECT_VARIABLE_WITH_INIT__INIT_EXP:
				return getInitExp();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case MorelPackage.OBJECT_VARIABLE_WITH_INIT__INIT_EXP:
				setInitExp((Expression)newValue);
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
			case MorelPackage.OBJECT_VARIABLE_WITH_INIT__INIT_EXP:
				setInitExp((Expression)null);
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
			case MorelPackage.OBJECT_VARIABLE_WITH_INIT__INIT_EXP:
				return initExp != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == VariableWithInit.class) {
			switch (derivedFeatureID) {
				case MorelPackage.OBJECT_VARIABLE_WITH_INIT__INIT_EXP: return MorelPackage.VARIABLE_WITH_INIT__INIT_EXP;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == VariableWithInit.class) {
			switch (baseFeatureID) {
				case MorelPackage.VARIABLE_WITH_INIT__INIT_EXP: return MorelPackage.OBJECT_VARIABLE_WITH_INIT__INIT_EXP;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //ObjectVariableWithInitImpl
