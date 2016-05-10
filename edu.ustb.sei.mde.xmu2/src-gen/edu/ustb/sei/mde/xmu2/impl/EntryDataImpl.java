/**
 */
package edu.ustb.sei.mde.xmu2.impl;

import edu.ustb.sei.mde.xmu2.EntryData;
import edu.ustb.sei.mde.xmu2.Xmu2Package;

import edu.ustb.sei.mde.xmu2common.impl.DomainElementImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.impl.EntryDataImpl#getIndex <em>Index</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.impl.EntryDataImpl#getFragment <em>Fragment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntryDataImpl extends DomainElementImpl implements EntryData {
	/**
	 * The default value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getIndex() <em>Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIndex()
	 * @generated
	 * @ordered
	 */
	protected int index = INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getFragment() <em>Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragment()
	 * @generated
	 * @ordered
	 */
	protected static final String FRAGMENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFragment() <em>Fragment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragment()
	 * @generated
	 * @ordered
	 */
	protected String fragment = FRAGMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntryDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2Package.Literals.ENTRY_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIndex(int newIndex) {
		int oldIndex = index;
		index = newIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2Package.ENTRY_DATA__INDEX, oldIndex, index));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFragment() {
		return fragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFragment(String newFragment) {
		String oldFragment = fragment;
		fragment = newFragment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2Package.ENTRY_DATA__FRAGMENT, oldFragment, fragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Xmu2Package.ENTRY_DATA__INDEX:
				return getIndex();
			case Xmu2Package.ENTRY_DATA__FRAGMENT:
				return getFragment();
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
			case Xmu2Package.ENTRY_DATA__INDEX:
				setIndex((Integer)newValue);
				return;
			case Xmu2Package.ENTRY_DATA__FRAGMENT:
				setFragment((String)newValue);
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
			case Xmu2Package.ENTRY_DATA__INDEX:
				setIndex(INDEX_EDEFAULT);
				return;
			case Xmu2Package.ENTRY_DATA__FRAGMENT:
				setFragment(FRAGMENT_EDEFAULT);
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
			case Xmu2Package.ENTRY_DATA__INDEX:
				return index != INDEX_EDEFAULT;
			case Xmu2Package.ENTRY_DATA__FRAGMENT:
				return FRAGMENT_EDEFAULT == null ? fragment != null : !FRAGMENT_EDEFAULT.equals(fragment);
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
		result.append(" (index: ");
		result.append(index);
		result.append(", fragment: ");
		result.append(fragment);
		result.append(')');
		return result.toString();
	}

} //EntryDataImpl
