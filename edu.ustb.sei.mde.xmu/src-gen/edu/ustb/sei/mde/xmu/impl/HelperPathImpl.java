/**
 */
package edu.ustb.sei.mde.xmu.impl;

import edu.ustb.sei.mde.xmu.HelperMapping;
import edu.ustb.sei.mde.xmu.HelperPath;
import edu.ustb.sei.mde.xmu.XmuPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Helper Path</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.HelperPathImpl#getHelper <em>Helper</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HelperPathImpl extends PathImpl implements HelperPath {
	/**
	 * The cached value of the '{@link #getHelper() <em>Helper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelper()
	 * @generated
	 * @ordered
	 */
	protected HelperMapping helper;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HelperPathImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmuPackage.Literals.HELPER_PATH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HelperMapping getHelper() {
		if (helper != null && helper.eIsProxy()) {
			InternalEObject oldHelper = (InternalEObject)helper;
			helper = (HelperMapping)eResolveProxy(oldHelper);
			if (helper != oldHelper) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XmuPackage.HELPER_PATH__HELPER, oldHelper, helper));
			}
		}
		return helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HelperMapping basicGetHelper() {
		return helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHelper(HelperMapping newHelper) {
		HelperMapping oldHelper = helper;
		helper = newHelper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmuPackage.HELPER_PATH__HELPER, oldHelper, helper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XmuPackage.HELPER_PATH__HELPER:
				if (resolve) return getHelper();
				return basicGetHelper();
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
			case XmuPackage.HELPER_PATH__HELPER:
				setHelper((HelperMapping)newValue);
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
			case XmuPackage.HELPER_PATH__HELPER:
				setHelper((HelperMapping)null);
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
			case XmuPackage.HELPER_PATH__HELPER:
				return helper != null;
		}
		return super.eIsSet(featureID);
	}

} //HelperPathImpl
