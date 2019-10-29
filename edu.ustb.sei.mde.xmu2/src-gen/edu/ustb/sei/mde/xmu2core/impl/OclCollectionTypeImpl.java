/**
 */
package edu.ustb.sei.mde.xmu2core.impl;

import edu.ustb.sei.mde.xmu2core.OclCollectionType;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EClassImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ocl Collection Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.OclCollectionTypeImpl#getElementtype <em>Elementtype</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OclCollectionTypeImpl extends EClassImpl implements OclCollectionType {
	/**
	 * The cached value of the '{@link #getElementtype() <em>Elementtype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementtype()
	 * @generated
	 * @ordered
	 */
	protected EClassifier elementtype;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OclCollectionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2corePackage.Literals.OCL_COLLECTION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier getElementtype() {
		if (elementtype != null && elementtype.eIsProxy()) {
			InternalEObject oldElementtype = (InternalEObject)elementtype;
			elementtype = (EClassifier)eResolveProxy(oldElementtype);
			if (elementtype != oldElementtype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xmu2corePackage.OCL_COLLECTION_TYPE__ELEMENTTYPE, oldElementtype, elementtype));
			}
		}
		return elementtype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetElementtype() {
		return elementtype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementtype(EClassifier newElementtype) {
		EClassifier oldElementtype = elementtype;
		elementtype = newElementtype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.OCL_COLLECTION_TYPE__ELEMENTTYPE, oldElementtype, elementtype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Xmu2corePackage.OCL_COLLECTION_TYPE__ELEMENTTYPE:
				if (resolve) return getElementtype();
				return basicGetElementtype();
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
			case Xmu2corePackage.OCL_COLLECTION_TYPE__ELEMENTTYPE:
				setElementtype((EClassifier)newValue);
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
			case Xmu2corePackage.OCL_COLLECTION_TYPE__ELEMENTTYPE:
				setElementtype((EClassifier)null);
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
			case Xmu2corePackage.OCL_COLLECTION_TYPE__ELEMENTTYPE:
				return elementtype != null;
		}
		return super.eIsSet(featureID);
	}

} //OclCollectionTypeImpl
