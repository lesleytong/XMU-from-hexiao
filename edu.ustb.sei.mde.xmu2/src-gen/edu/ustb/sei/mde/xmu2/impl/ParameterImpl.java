/**
 */
package edu.ustb.sei.mde.xmu2.impl;

import edu.ustb.sei.mde.xmu2.Parameter;
import edu.ustb.sei.mde.xmu2.TypedElement;
import edu.ustb.sei.mde.xmu2.Xmu2Package;

import edu.ustb.sei.mde.xmu2common.DomainElement;
import edu.ustb.sei.mde.xmu2common.DomainTag;
import edu.ustb.sei.mde.xmu2common.Xmu2commonPackage;

import edu.ustb.sei.mde.xmu2common.impl.NamedElementImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.impl.ParameterImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.impl.ParameterImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ParameterImpl extends NamedElementImpl implements Parameter {
	/**
	 * The default value of the '{@link #getTag() <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTag()
	 * @generated
	 * @ordered
	 */
	protected static final DomainTag TAG_EDEFAULT = DomainTag.NORMAL;

	/**
	 * The cached value of the '{@link #getTag() <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTag()
	 * @generated
	 * @ordered
	 */
	protected DomainTag tag = TAG_EDEFAULT;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EClassifier type;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2Package.Literals.PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainTag getTag() {
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTag(DomainTag newTag) {
		DomainTag oldTag = tag;
		tag = newTag == null ? TAG_EDEFAULT : newTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2Package.PARAMETER__TAG, oldTag, tag));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (EClassifier)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xmu2Package.PARAMETER__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EClassifier newType) {
		EClassifier oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2Package.PARAMETER__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Xmu2Package.PARAMETER__TAG:
				return getTag();
			case Xmu2Package.PARAMETER__TYPE:
				if (resolve) return getType();
				return basicGetType();
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
			case Xmu2Package.PARAMETER__TAG:
				setTag((DomainTag)newValue);
				return;
			case Xmu2Package.PARAMETER__TYPE:
				setType((EClassifier)newValue);
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
			case Xmu2Package.PARAMETER__TAG:
				setTag(TAG_EDEFAULT);
				return;
			case Xmu2Package.PARAMETER__TYPE:
				setType((EClassifier)null);
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
			case Xmu2Package.PARAMETER__TAG:
				return tag != TAG_EDEFAULT;
			case Xmu2Package.PARAMETER__TYPE:
				return type != null;
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
		if (baseClass == DomainElement.class) {
			switch (derivedFeatureID) {
				case Xmu2Package.PARAMETER__TAG: return Xmu2commonPackage.DOMAIN_ELEMENT__TAG;
				default: return -1;
			}
		}
		if (baseClass == TypedElement.class) {
			switch (derivedFeatureID) {
				case Xmu2Package.PARAMETER__TYPE: return Xmu2Package.TYPED_ELEMENT__TYPE;
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
		if (baseClass == DomainElement.class) {
			switch (baseFeatureID) {
				case Xmu2commonPackage.DOMAIN_ELEMENT__TAG: return Xmu2Package.PARAMETER__TAG;
				default: return -1;
			}
		}
		if (baseClass == TypedElement.class) {
			switch (baseFeatureID) {
				case Xmu2Package.TYPED_ELEMENT__TYPE: return Xmu2Package.PARAMETER__TYPE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (tag: ");
		result.append(tag);
		result.append(')');
		return result.toString();
	}

} //ParameterImpl
