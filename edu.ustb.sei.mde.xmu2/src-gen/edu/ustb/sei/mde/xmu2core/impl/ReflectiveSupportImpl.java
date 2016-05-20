/**
 */
package edu.ustb.sei.mde.xmu2core.impl;

import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.ReflectiveSupport;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reflective Support</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.ReflectiveSupportImpl#getReflectiveIdentifier <em>Reflective Identifier</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.ReflectiveSupportImpl#isReflective <em>Reflective</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.ReflectiveSupportImpl#isResolve <em>Resolve</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ReflectiveSupportImpl extends MinimalEObjectImpl.Container implements ReflectiveSupport {
	/**
	 * The cached value of the '{@link #getReflectiveIdentifier() <em>Reflective Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReflectiveIdentifier()
	 * @generated
	 * @ordered
	 */
	protected Expression reflectiveIdentifier;

	/**
	 * The default value of the '{@link #isReflective() <em>Reflective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReflective()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REFLECTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReflective() <em>Reflective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReflective()
	 * @generated
	 * @ordered
	 */
	protected boolean reflective = REFLECTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isResolve() <em>Resolve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolve()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESOLVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isResolve() <em>Resolve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolve()
	 * @generated
	 * @ordered
	 */
	protected boolean resolve = RESOLVE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReflectiveSupportImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2corePackage.Literals.REFLECTIVE_SUPPORT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getReflectiveIdentifier() {
		return reflectiveIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReflectiveIdentifier(Expression newReflectiveIdentifier, NotificationChain msgs) {
		Expression oldReflectiveIdentifier = reflectiveIdentifier;
		reflectiveIdentifier = newReflectiveIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER, oldReflectiveIdentifier, newReflectiveIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReflectiveIdentifier(Expression newReflectiveIdentifier) {
		if (newReflectiveIdentifier != reflectiveIdentifier) {
			NotificationChain msgs = null;
			if (reflectiveIdentifier != null)
				msgs = ((InternalEObject)reflectiveIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER, null, msgs);
			if (newReflectiveIdentifier != null)
				msgs = ((InternalEObject)newReflectiveIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER, null, msgs);
			msgs = basicSetReflectiveIdentifier(newReflectiveIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER, newReflectiveIdentifier, newReflectiveIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReflective() {
		return reflective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReflective(boolean newReflective) {
		boolean oldReflective = reflective;
		reflective = newReflective;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE, oldReflective, reflective));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResolve() {
		return resolve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolve(boolean newResolve) {
		boolean oldResolve = resolve;
		resolve = newResolve;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.REFLECTIVE_SUPPORT__RESOLVE, oldResolve, resolve));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER:
				return basicSetReflectiveIdentifier(null, msgs);
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
			case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER:
				return getReflectiveIdentifier();
			case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE:
				return isReflective();
			case Xmu2corePackage.REFLECTIVE_SUPPORT__RESOLVE:
				return isResolve();
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
			case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER:
				setReflectiveIdentifier((Expression)newValue);
				return;
			case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE:
				setReflective((Boolean)newValue);
				return;
			case Xmu2corePackage.REFLECTIVE_SUPPORT__RESOLVE:
				setResolve((Boolean)newValue);
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
			case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER:
				setReflectiveIdentifier((Expression)null);
				return;
			case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE:
				setReflective(REFLECTIVE_EDEFAULT);
				return;
			case Xmu2corePackage.REFLECTIVE_SUPPORT__RESOLVE:
				setResolve(RESOLVE_EDEFAULT);
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
			case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER:
				return reflectiveIdentifier != null;
			case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE:
				return reflective != REFLECTIVE_EDEFAULT;
			case Xmu2corePackage.REFLECTIVE_SUPPORT__RESOLVE:
				return resolve != RESOLVE_EDEFAULT;
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
		result.append(" (reflective: ");
		result.append(reflective);
		result.append(", resolve: ");
		result.append(resolve);
		result.append(')');
		return result.toString();
	}

} //ReflectiveSupportImpl
