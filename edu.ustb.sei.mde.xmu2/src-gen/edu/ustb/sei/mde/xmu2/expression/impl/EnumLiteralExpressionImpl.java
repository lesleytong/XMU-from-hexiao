/**
 */
package edu.ustb.sei.mde.xmu2.expression.impl;

import edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression;
import edu.ustb.sei.mde.xmu2.expression.ExpressionPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Literal Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.impl.EnumLiteralExpressionImpl#getType <em>Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.impl.EnumLiteralExpressionImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnumLiteralExpressionImpl extends ConstantExpressionImpl implements EnumLiteralExpression {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EEnum type;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected EEnumLiteral value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumLiteralExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.ENUM_LITERAL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (EEnum)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionPackage.ENUM_LITERAL_EXPRESSION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EEnum newType) {
		EEnum oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.ENUM_LITERAL_EXPRESSION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnumLiteral getValue() {
		if (value != null && value.eIsProxy()) {
			InternalEObject oldValue = (InternalEObject)value;
			value = (EEnumLiteral)eResolveProxy(oldValue);
			if (value != oldValue) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionPackage.ENUM_LITERAL_EXPRESSION__VALUE, oldValue, value));
			}
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnumLiteral basicGetValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(EEnumLiteral newValue) {
		EEnumLiteral oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.ENUM_LITERAL_EXPRESSION__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionPackage.ENUM_LITERAL_EXPRESSION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ExpressionPackage.ENUM_LITERAL_EXPRESSION__VALUE:
				if (resolve) return getValue();
				return basicGetValue();
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
			case ExpressionPackage.ENUM_LITERAL_EXPRESSION__TYPE:
				setType((EEnum)newValue);
				return;
			case ExpressionPackage.ENUM_LITERAL_EXPRESSION__VALUE:
				setValue((EEnumLiteral)newValue);
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
			case ExpressionPackage.ENUM_LITERAL_EXPRESSION__TYPE:
				setType((EEnum)null);
				return;
			case ExpressionPackage.ENUM_LITERAL_EXPRESSION__VALUE:
				setValue((EEnumLiteral)null);
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
			case ExpressionPackage.ENUM_LITERAL_EXPRESSION__TYPE:
				return type != null;
			case ExpressionPackage.ENUM_LITERAL_EXPRESSION__VALUE:
				return value != null;
		}
		return super.eIsSet(featureID);
	}

} //EnumLiteralExpressionImpl
