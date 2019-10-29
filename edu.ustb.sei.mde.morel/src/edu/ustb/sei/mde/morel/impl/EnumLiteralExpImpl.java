/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.EnumLiteralExp;
import edu.ustb.sei.mde.morel.MorelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Literal Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.EnumLiteralExpImpl#getEnumType <em>Enum Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.EnumLiteralExpImpl#getEnumSymbol <em>Enum Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumLiteralExpImpl extends LiteralExpImpl implements EnumLiteralExp {
	/**
	 * The cached value of the '{@link #getEnumType() <em>Enum Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumType()
	 * @generated
	 * @ordered
	 */
	protected EEnum enumType;

	/**
	 * The cached value of the '{@link #getEnumSymbol() <em>Enum Symbol</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnumSymbol()
	 * @generated
	 * @ordered
	 */
	protected EEnumLiteral enumSymbol;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumLiteralExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorelPackage.Literals.ENUM_LITERAL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEnumType() {
		if (enumType != null && enumType.eIsProxy()) {
			InternalEObject oldEnumType = (InternalEObject)enumType;
			enumType = (EEnum)eResolveProxy(oldEnumType);
			if (enumType != oldEnumType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MorelPackage.ENUM_LITERAL_EXP__ENUM_TYPE, oldEnumType, enumType));
			}
		}
		return enumType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum basicGetEnumType() {
		return enumType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnumType(EEnum newEnumType) {
		EEnum oldEnumType = enumType;
		enumType = newEnumType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.ENUM_LITERAL_EXP__ENUM_TYPE, oldEnumType, enumType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnumLiteral getEnumSymbol() {
		if (enumSymbol != null && enumSymbol.eIsProxy()) {
			InternalEObject oldEnumSymbol = (InternalEObject)enumSymbol;
			enumSymbol = (EEnumLiteral)eResolveProxy(oldEnumSymbol);
			if (enumSymbol != oldEnumSymbol) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MorelPackage.ENUM_LITERAL_EXP__ENUM_SYMBOL, oldEnumSymbol, enumSymbol));
			}
		}
		return enumSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnumLiteral basicGetEnumSymbol() {
		return enumSymbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnumSymbol(EEnumLiteral newEnumSymbol) {
		EEnumLiteral oldEnumSymbol = enumSymbol;
		enumSymbol = newEnumSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.ENUM_LITERAL_EXP__ENUM_SYMBOL, oldEnumSymbol, enumSymbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MorelPackage.ENUM_LITERAL_EXP__ENUM_TYPE:
				if (resolve) return getEnumType();
				return basicGetEnumType();
			case MorelPackage.ENUM_LITERAL_EXP__ENUM_SYMBOL:
				if (resolve) return getEnumSymbol();
				return basicGetEnumSymbol();
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
			case MorelPackage.ENUM_LITERAL_EXP__ENUM_TYPE:
				setEnumType((EEnum)newValue);
				return;
			case MorelPackage.ENUM_LITERAL_EXP__ENUM_SYMBOL:
				setEnumSymbol((EEnumLiteral)newValue);
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
			case MorelPackage.ENUM_LITERAL_EXP__ENUM_TYPE:
				setEnumType((EEnum)null);
				return;
			case MorelPackage.ENUM_LITERAL_EXP__ENUM_SYMBOL:
				setEnumSymbol((EEnumLiteral)null);
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
			case MorelPackage.ENUM_LITERAL_EXP__ENUM_TYPE:
				return enumType != null;
			case MorelPackage.ENUM_LITERAL_EXP__ENUM_SYMBOL:
				return enumSymbol != null;
		}
		return super.eIsSet(featureID);
	}

} //EnumLiteralExpImpl
