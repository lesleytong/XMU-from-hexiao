/**
 */
package edu.ustb.sei.mde.xmu2core.impl;

import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.TypeCastExpression;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Cast Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.TypeCastExpressionImpl#getTargetType <em>Target Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.TypeCastExpressionImpl#getBody <em>Body</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.TypeCastExpressionImpl#getSourceType <em>Source Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeCastExpressionImpl extends AtomicExpressionImpl implements TypeCastExpression {
	/**
	 * The cached value of the '{@link #getTargetType() <em>Target Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetType()
	 * @generated
	 * @ordered
	 */
	protected EClassifier targetType;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected Expression body;

	/**
	 * The cached value of the '{@link #getSourceType() <em>Source Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceType()
	 * @generated
	 * @ordered
	 */
	protected EClassifier sourceType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeCastExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2corePackage.Literals.TYPE_CAST_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier getTargetType() {
		if (targetType != null && targetType.eIsProxy()) {
			InternalEObject oldTargetType = (InternalEObject)targetType;
			targetType = (EClassifier)eResolveProxy(oldTargetType);
			if (targetType != oldTargetType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xmu2corePackage.TYPE_CAST_EXPRESSION__TARGET_TYPE, oldTargetType, targetType));
			}
		}
		return targetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetTargetType() {
		return targetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetType(EClassifier newTargetType) {
		EClassifier oldTargetType = targetType;
		targetType = newTargetType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.TYPE_CAST_EXPRESSION__TARGET_TYPE, oldTargetType, targetType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(Expression newBody, NotificationChain msgs) {
		Expression oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2corePackage.TYPE_CAST_EXPRESSION__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(Expression newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.TYPE_CAST_EXPRESSION__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.TYPE_CAST_EXPRESSION__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.TYPE_CAST_EXPRESSION__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier getSourceType() {
		if (sourceType != null && sourceType.eIsProxy()) {
			InternalEObject oldSourceType = (InternalEObject)sourceType;
			sourceType = (EClassifier)eResolveProxy(oldSourceType);
			if (sourceType != oldSourceType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xmu2corePackage.TYPE_CAST_EXPRESSION__SOURCE_TYPE, oldSourceType, sourceType));
			}
		}
		return sourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetSourceType() {
		return sourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceType(EClassifier newSourceType) {
		EClassifier oldSourceType = sourceType;
		sourceType = newSourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.TYPE_CAST_EXPRESSION__SOURCE_TYPE, oldSourceType, sourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Xmu2corePackage.TYPE_CAST_EXPRESSION__BODY:
				return basicSetBody(null, msgs);
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
			case Xmu2corePackage.TYPE_CAST_EXPRESSION__TARGET_TYPE:
				if (resolve) return getTargetType();
				return basicGetTargetType();
			case Xmu2corePackage.TYPE_CAST_EXPRESSION__BODY:
				return getBody();
			case Xmu2corePackage.TYPE_CAST_EXPRESSION__SOURCE_TYPE:
				if (resolve) return getSourceType();
				return basicGetSourceType();
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
			case Xmu2corePackage.TYPE_CAST_EXPRESSION__TARGET_TYPE:
				setTargetType((EClassifier)newValue);
				return;
			case Xmu2corePackage.TYPE_CAST_EXPRESSION__BODY:
				setBody((Expression)newValue);
				return;
			case Xmu2corePackage.TYPE_CAST_EXPRESSION__SOURCE_TYPE:
				setSourceType((EClassifier)newValue);
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
			case Xmu2corePackage.TYPE_CAST_EXPRESSION__TARGET_TYPE:
				setTargetType((EClassifier)null);
				return;
			case Xmu2corePackage.TYPE_CAST_EXPRESSION__BODY:
				setBody((Expression)null);
				return;
			case Xmu2corePackage.TYPE_CAST_EXPRESSION__SOURCE_TYPE:
				setSourceType((EClassifier)null);
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
			case Xmu2corePackage.TYPE_CAST_EXPRESSION__TARGET_TYPE:
				return targetType != null;
			case Xmu2corePackage.TYPE_CAST_EXPRESSION__BODY:
				return body != null;
			case Xmu2corePackage.TYPE_CAST_EXPRESSION__SOURCE_TYPE:
				return sourceType != null;
		}
		return super.eIsSet(featureID);
	}

} //TypeCastExpressionImpl
