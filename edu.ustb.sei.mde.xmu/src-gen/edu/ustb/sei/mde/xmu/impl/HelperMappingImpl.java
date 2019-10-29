/**
 */
package edu.ustb.sei.mde.xmu.impl;

import edu.ustb.sei.mde.xmu.HelperMapping;
import edu.ustb.sei.mde.xmu.HelperMappingEntry;
import edu.ustb.sei.mde.xmu.XmuPackage;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Helper Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.HelperMappingImpl#getEntries <em>Entries</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.HelperMappingImpl#isDefaultEqual <em>Default Equal</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HelperMappingImpl extends NamedElementImpl implements HelperMapping {
	/**
	 * The cached value of the '{@link #getEntries() <em>Entries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntries()
	 * @generated
	 * @ordered
	 */
	protected EList<HelperMappingEntry> entries;

	/**
	 * The default value of the '{@link #isDefaultEqual() <em>Default Equal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefaultEqual()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEFAULT_EQUAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDefaultEqual() <em>Default Equal</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDefaultEqual()
	 * @generated
	 * @ordered
	 */
	protected boolean defaultEqual = DEFAULT_EQUAL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HelperMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmuPackage.Literals.HELPER_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HelperMappingEntry> getEntries() {
		if (entries == null) {
			entries = new EObjectContainmentEList<HelperMappingEntry>(HelperMappingEntry.class, this, XmuPackage.HELPER_MAPPING__ENTRIES);
		}
		return entries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDefaultEqual() {
		return defaultEqual;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultEqual(boolean newDefaultEqual) {
		boolean oldDefaultEqual = defaultEqual;
		defaultEqual = newDefaultEqual;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmuPackage.HELPER_MAPPING__DEFAULT_EQUAL, oldDefaultEqual, defaultEqual));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XmuPackage.HELPER_MAPPING__ENTRIES:
				return ((InternalEList<?>)getEntries()).basicRemove(otherEnd, msgs);
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
			case XmuPackage.HELPER_MAPPING__ENTRIES:
				return getEntries();
			case XmuPackage.HELPER_MAPPING__DEFAULT_EQUAL:
				return isDefaultEqual();
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
			case XmuPackage.HELPER_MAPPING__ENTRIES:
				getEntries().clear();
				getEntries().addAll((Collection<? extends HelperMappingEntry>)newValue);
				return;
			case XmuPackage.HELPER_MAPPING__DEFAULT_EQUAL:
				setDefaultEqual((Boolean)newValue);
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
			case XmuPackage.HELPER_MAPPING__ENTRIES:
				getEntries().clear();
				return;
			case XmuPackage.HELPER_MAPPING__DEFAULT_EQUAL:
				setDefaultEqual(DEFAULT_EQUAL_EDEFAULT);
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
			case XmuPackage.HELPER_MAPPING__ENTRIES:
				return entries != null && !entries.isEmpty();
			case XmuPackage.HELPER_MAPPING__DEFAULT_EQUAL:
				return defaultEqual != DEFAULT_EQUAL_EDEFAULT;
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
		result.append(" (defaultEqual: ");
		result.append(defaultEqual);
		result.append(')');
		return result.toString();
	}

} //HelperMappingImpl
