/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.Expression;
import edu.ustb.sei.mde.morel.MorelPackage;
import edu.ustb.sei.mde.morel.PredefinedBindExp;
import edu.ustb.sei.mde.morel.PredefinedVariableExp;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predefined Bind Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.PredefinedBindExpImpl#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.PredefinedBindExpImpl#getValueExp <em>Value Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PredefinedBindExpImpl extends ImperativeExpImpl implements PredefinedBindExp {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected PredefinedVariableExp source;

	/**
	 * The cached value of the '{@link #getValueExp() <em>Value Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueExp()
	 * @generated
	 * @ordered
	 */
	protected Expression valueExp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PredefinedBindExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorelPackage.Literals.PREDEFINED_BIND_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredefinedVariableExp getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(PredefinedVariableExp newSource, NotificationChain msgs) {
		PredefinedVariableExp oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.PREDEFINED_BIND_EXP__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(PredefinedVariableExp newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.PREDEFINED_BIND_EXP__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.PREDEFINED_BIND_EXP__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.PREDEFINED_BIND_EXP__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getValueExp() {
		return valueExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueExp(Expression newValueExp, NotificationChain msgs) {
		Expression oldValueExp = valueExp;
		valueExp = newValueExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.PREDEFINED_BIND_EXP__VALUE_EXP, oldValueExp, newValueExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueExp(Expression newValueExp) {
		if (newValueExp != valueExp) {
			NotificationChain msgs = null;
			if (valueExp != null)
				msgs = ((InternalEObject)valueExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.PREDEFINED_BIND_EXP__VALUE_EXP, null, msgs);
			if (newValueExp != null)
				msgs = ((InternalEObject)newValueExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.PREDEFINED_BIND_EXP__VALUE_EXP, null, msgs);
			msgs = basicSetValueExp(newValueExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.PREDEFINED_BIND_EXP__VALUE_EXP, newValueExp, newValueExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MorelPackage.PREDEFINED_BIND_EXP__SOURCE:
				return basicSetSource(null, msgs);
			case MorelPackage.PREDEFINED_BIND_EXP__VALUE_EXP:
				return basicSetValueExp(null, msgs);
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
			case MorelPackage.PREDEFINED_BIND_EXP__SOURCE:
				return getSource();
			case MorelPackage.PREDEFINED_BIND_EXP__VALUE_EXP:
				return getValueExp();
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
			case MorelPackage.PREDEFINED_BIND_EXP__SOURCE:
				setSource((PredefinedVariableExp)newValue);
				return;
			case MorelPackage.PREDEFINED_BIND_EXP__VALUE_EXP:
				setValueExp((Expression)newValue);
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
			case MorelPackage.PREDEFINED_BIND_EXP__SOURCE:
				setSource((PredefinedVariableExp)null);
				return;
			case MorelPackage.PREDEFINED_BIND_EXP__VALUE_EXP:
				setValueExp((Expression)null);
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
			case MorelPackage.PREDEFINED_BIND_EXP__SOURCE:
				return source != null;
			case MorelPackage.PREDEFINED_BIND_EXP__VALUE_EXP:
				return valueExp != null;
		}
		return super.eIsSet(featureID);
	}

} //PredefinedBindExpImpl
