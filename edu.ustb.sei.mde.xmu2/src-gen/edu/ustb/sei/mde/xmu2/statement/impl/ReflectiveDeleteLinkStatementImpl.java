/**
 */
package edu.ustb.sei.mde.xmu2.statement.impl;

import edu.ustb.sei.mde.xmu2.ReflectiveAPI;
import edu.ustb.sei.mde.xmu2.Xmu2Package;

import edu.ustb.sei.mde.xmu2.expression.Expression;

import edu.ustb.sei.mde.xmu2.statement.ReflectiveDeleteLinkStatement;
import edu.ustb.sei.mde.xmu2.statement.StatementPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reflective Delete Link Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.impl.ReflectiveDeleteLinkStatementImpl#getReflectiveIdentifier <em>Reflective Identifier</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.impl.ReflectiveDeleteLinkStatementImpl#isResolve <em>Resolve</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReflectiveDeleteLinkStatementImpl extends DeleteLinkStatementImpl implements ReflectiveDeleteLinkStatement {
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
	 * The default value of the '{@link #isResolve() <em>Resolve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolve()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESOLVE_EDEFAULT = true;
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
	protected ReflectiveDeleteLinkStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatementPackage.Literals.REFLECTIVE_DELETE_LINK_STATEMENT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER, oldReflectiveIdentifier, newReflectiveIdentifier);
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
				msgs = ((InternalEObject)reflectiveIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER, null, msgs);
			if (newReflectiveIdentifier != null)
				msgs = ((InternalEObject)newReflectiveIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER, null, msgs);
			msgs = basicSetReflectiveIdentifier(newReflectiveIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER, newReflectiveIdentifier, newReflectiveIdentifier));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE, oldResolve, resolve));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER:
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
			case StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER:
				return getReflectiveIdentifier();
			case StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE:
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
			case StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER:
				setReflectiveIdentifier((Expression)newValue);
				return;
			case StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE:
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
			case StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER:
				setReflectiveIdentifier((Expression)null);
				return;
			case StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE:
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
			case StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER:
				return reflectiveIdentifier != null;
			case StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE:
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ReflectiveAPI.class) {
			switch (derivedFeatureID) {
				case StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER: return Xmu2Package.REFLECTIVE_API__REFLECTIVE_IDENTIFIER;
				case StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE: return Xmu2Package.REFLECTIVE_API__RESOLVE;
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
		if (baseClass == ReflectiveAPI.class) {
			switch (baseFeatureID) {
				case Xmu2Package.REFLECTIVE_API__REFLECTIVE_IDENTIFIER: return StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER;
				case Xmu2Package.REFLECTIVE_API__RESOLVE: return StatementPackage.REFLECTIVE_DELETE_LINK_STATEMENT__RESOLVE;
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
		result.append(" (resolve: ");
		result.append(resolve);
		result.append(')');
		return result.toString();
	}

} //ReflectiveDeleteLinkStatementImpl
