/**
 */
package edu.ustb.sei.mde.xmu2common.impl;

import edu.ustb.sei.mde.xmu2common.ReflectiveObject;
import edu.ustb.sei.mde.xmu2common.Xmu2commonPackage;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reflective Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2common.impl.ReflectiveObjectImpl#getEContainer <em>EContainer</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2common.impl.ReflectiveObjectImpl#getEContents <em>EContents</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2common.impl.ReflectiveObjectImpl#getEAllContents <em>EAll Contents</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2common.impl.ReflectiveObjectImpl#getEDynamticFeature <em>EDynamtic Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ReflectiveObjectImpl extends MinimalEObjectImpl.Container implements ReflectiveObject {
	/**
	 * The cached value of the '{@link #getEContainer() <em>EContainer</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEContainer()
	 * @generated
	 * @ordered
	 */
	protected EObject eContainer;

	/**
	 * The cached value of the '{@link #getEContents() <em>EContents</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEContents()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> eContents;

	/**
	 * The cached value of the '{@link #getEAllContents() <em>EAll Contents</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEAllContents()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> eAllContents;

	/**
	 * The cached value of the '{@link #getEDynamticFeature() <em>EDynamtic Feature</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEDynamticFeature()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> eDynamticFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReflectiveObjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2commonPackage.Literals.REFLECTIVE_OBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getEContainer() {
		if (eContainer != null && eContainer.eIsProxy()) {
			InternalEObject oldEContainer = (InternalEObject)eContainer;
			eContainer = eResolveProxy(oldEContainer);
			if (eContainer != oldEContainer) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xmu2commonPackage.REFLECTIVE_OBJECT__ECONTAINER, oldEContainer, eContainer));
			}
		}
		return eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetEContainer() {
		return eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getEContents() {
		if (eContents == null) {
			eContents = new EObjectResolvingEList<EObject>(EObject.class, this, Xmu2commonPackage.REFLECTIVE_OBJECT__ECONTENTS);
		}
		return eContents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getEAllContents() {
		if (eAllContents == null) {
			eAllContents = new EObjectResolvingEList<EObject>(EObject.class, this, Xmu2commonPackage.REFLECTIVE_OBJECT__EALL_CONTENTS);
		}
		return eAllContents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getEDynamticFeature() {
		if (eDynamticFeature == null) {
			eDynamticFeature = new EDataTypeUniqueEList<Object>(Object.class, this, Xmu2commonPackage.REFLECTIVE_OBJECT__EDYNAMTIC_FEATURE);
		}
		return eDynamticFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Xmu2commonPackage.REFLECTIVE_OBJECT__ECONTAINER:
				if (resolve) return getEContainer();
				return basicGetEContainer();
			case Xmu2commonPackage.REFLECTIVE_OBJECT__ECONTENTS:
				return getEContents();
			case Xmu2commonPackage.REFLECTIVE_OBJECT__EALL_CONTENTS:
				return getEAllContents();
			case Xmu2commonPackage.REFLECTIVE_OBJECT__EDYNAMTIC_FEATURE:
				return getEDynamticFeature();
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
			case Xmu2commonPackage.REFLECTIVE_OBJECT__EDYNAMTIC_FEATURE:
				getEDynamticFeature().clear();
				getEDynamticFeature().addAll((Collection<? extends Object>)newValue);
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
			case Xmu2commonPackage.REFLECTIVE_OBJECT__EDYNAMTIC_FEATURE:
				getEDynamticFeature().clear();
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
			case Xmu2commonPackage.REFLECTIVE_OBJECT__ECONTAINER:
				return eContainer != null;
			case Xmu2commonPackage.REFLECTIVE_OBJECT__ECONTENTS:
				return eContents != null && !eContents.isEmpty();
			case Xmu2commonPackage.REFLECTIVE_OBJECT__EALL_CONTENTS:
				return eAllContents != null && !eAllContents.isEmpty();
			case Xmu2commonPackage.REFLECTIVE_OBJECT__EDYNAMTIC_FEATURE:
				return eDynamticFeature != null && !eDynamticFeature.isEmpty();
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
		result.append(" (eDynamticFeature: ");
		result.append(eDynamticFeature);
		result.append(')');
		return result.toString();
	}

} //ReflectiveObjectImpl
