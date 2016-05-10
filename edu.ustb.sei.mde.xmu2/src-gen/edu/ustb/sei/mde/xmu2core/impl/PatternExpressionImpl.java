/**
 */
package edu.ustb.sei.mde.xmu2core.impl;

import edu.ustb.sei.mde.xmu2core.LoopPath;
import edu.ustb.sei.mde.xmu2core.PatternExpression;
import edu.ustb.sei.mde.xmu2core.PositionPath;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.PatternExpressionImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.PatternExpressionImpl#getSelector <em>Selector</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.PatternExpressionImpl#getPosition <em>Position</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PatternExpressionImpl extends MinimalEObjectImpl.Container implements PatternExpression {
	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature feature;

	/**
	 * The cached value of the '{@link #getSelector() <em>Selector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelector()
	 * @generated
	 * @ordered
	 */
	protected LoopPath selector;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected PositionPath position;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2corePackage.Literals.PATTERN_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getFeature() {
		if (feature != null && feature.eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject)feature;
			feature = (EStructuralFeature)eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xmu2corePackage.PATTERN_EXPRESSION__FEATURE, oldFeature, feature));
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(EStructuralFeature newFeature) {
		EStructuralFeature oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.PATTERN_EXPRESSION__FEATURE, oldFeature, feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopPath getSelector() {
		return selector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSelector(LoopPath newSelector, NotificationChain msgs) {
		LoopPath oldSelector = selector;
		selector = newSelector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR, oldSelector, newSelector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelector(LoopPath newSelector) {
		if (newSelector != selector) {
			NotificationChain msgs = null;
			if (selector != null)
				msgs = ((InternalEObject)selector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR, null, msgs);
			if (newSelector != null)
				msgs = ((InternalEObject)newSelector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR, null, msgs);
			msgs = basicSetSelector(newSelector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR, newSelector, newSelector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PositionPath getPosition() {
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPosition(PositionPath newPosition, NotificationChain msgs) {
		PositionPath oldPosition = position;
		position = newPosition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2corePackage.PATTERN_EXPRESSION__POSITION, oldPosition, newPosition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(PositionPath newPosition) {
		if (newPosition != position) {
			NotificationChain msgs = null;
			if (position != null)
				msgs = ((InternalEObject)position).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.PATTERN_EXPRESSION__POSITION, null, msgs);
			if (newPosition != null)
				msgs = ((InternalEObject)newPosition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.PATTERN_EXPRESSION__POSITION, null, msgs);
			msgs = basicSetPosition(newPosition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.PATTERN_EXPRESSION__POSITION, newPosition, newPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR:
				return basicSetSelector(null, msgs);
			case Xmu2corePackage.PATTERN_EXPRESSION__POSITION:
				return basicSetPosition(null, msgs);
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
			case Xmu2corePackage.PATTERN_EXPRESSION__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
			case Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR:
				return getSelector();
			case Xmu2corePackage.PATTERN_EXPRESSION__POSITION:
				return getPosition();
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
			case Xmu2corePackage.PATTERN_EXPRESSION__FEATURE:
				setFeature((EStructuralFeature)newValue);
				return;
			case Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR:
				setSelector((LoopPath)newValue);
				return;
			case Xmu2corePackage.PATTERN_EXPRESSION__POSITION:
				setPosition((PositionPath)newValue);
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
			case Xmu2corePackage.PATTERN_EXPRESSION__FEATURE:
				setFeature((EStructuralFeature)null);
				return;
			case Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR:
				setSelector((LoopPath)null);
				return;
			case Xmu2corePackage.PATTERN_EXPRESSION__POSITION:
				setPosition((PositionPath)null);
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
			case Xmu2corePackage.PATTERN_EXPRESSION__FEATURE:
				return feature != null;
			case Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR:
				return selector != null;
			case Xmu2corePackage.PATTERN_EXPRESSION__POSITION:
				return position != null;
		}
		return super.eIsSet(featureID);
	}

} //PatternExpressionImpl
