/**
 */
package edu.ustb.sei.mde.xmu2.pattern.impl;

import edu.ustb.sei.mde.xmu2.expression.Expression;

import edu.ustb.sei.mde.xmu2.pattern.PatternPackage;
import edu.ustb.sei.mde.xmu2.pattern.PropertyPatternExpression;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Pattern Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.pattern.impl.PropertyPatternExpressionImpl#getTargetExpression <em>Target Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyPatternExpressionImpl extends PatternExpressionImpl implements PropertyPatternExpression {
	/**
	 * The cached value of the '{@link #getTargetExpression() <em>Target Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression targetExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyPatternExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PatternPackage.Literals.PROPERTY_PATTERN_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getTargetExpression() {
		return targetExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetExpression(Expression newTargetExpression, NotificationChain msgs) {
		Expression oldTargetExpression = targetExpression;
		targetExpression = newTargetExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION, oldTargetExpression, newTargetExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetExpression(Expression newTargetExpression) {
		if (newTargetExpression != targetExpression) {
			NotificationChain msgs = null;
			if (targetExpression != null)
				msgs = ((InternalEObject)targetExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION, null, msgs);
			if (newTargetExpression != null)
				msgs = ((InternalEObject)newTargetExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION, null, msgs);
			msgs = basicSetTargetExpression(newTargetExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION, newTargetExpression, newTargetExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION:
				return basicSetTargetExpression(null, msgs);
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
			case PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION:
				return getTargetExpression();
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
			case PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION:
				setTargetExpression((Expression)newValue);
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
			case PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION:
				setTargetExpression((Expression)null);
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
			case PatternPackage.PROPERTY_PATTERN_EXPRESSION__TARGET_EXPRESSION:
				return targetExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //PropertyPatternExpressionImpl
