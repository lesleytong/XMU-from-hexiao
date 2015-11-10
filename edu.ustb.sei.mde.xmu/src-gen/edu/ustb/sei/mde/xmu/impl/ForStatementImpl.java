/**
 */
package edu.ustb.sei.mde.xmu.impl;

import edu.ustb.sei.mde.xmu.ForStatement;
import edu.ustb.sei.mde.xmu.Pattern;
import edu.ustb.sei.mde.xmu.VStatement;
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
 * An implementation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.ForStatementImpl#getSPattern <em>SPattern</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.ForStatementImpl#getVPattern <em>VPattern</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.ForStatementImpl#getActions <em>Actions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForStatementImpl extends StatementImpl implements ForStatement {
	/**
	 * The cached value of the '{@link #getSPattern() <em>SPattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSPattern()
	 * @generated
	 * @ordered
	 */
	protected Pattern sPattern;

	/**
	 * The cached value of the '{@link #getVPattern() <em>VPattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVPattern()
	 * @generated
	 * @ordered
	 */
	protected Pattern vPattern;

	/**
	 * The cached value of the '{@link #getActions() <em>Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActions()
	 * @generated
	 * @ordered
	 */
	protected EList<VStatement> actions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmuPackage.Literals.FOR_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getSPattern() {
		return sPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSPattern(Pattern newSPattern, NotificationChain msgs) {
		Pattern oldSPattern = sPattern;
		sPattern = newSPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XmuPackage.FOR_STATEMENT__SPATTERN, oldSPattern, newSPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSPattern(Pattern newSPattern) {
		if (newSPattern != sPattern) {
			NotificationChain msgs = null;
			if (sPattern != null)
				msgs = ((InternalEObject)sPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XmuPackage.FOR_STATEMENT__SPATTERN, null, msgs);
			if (newSPattern != null)
				msgs = ((InternalEObject)newSPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XmuPackage.FOR_STATEMENT__SPATTERN, null, msgs);
			msgs = basicSetSPattern(newSPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmuPackage.FOR_STATEMENT__SPATTERN, newSPattern, newSPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getVPattern() {
		return vPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVPattern(Pattern newVPattern, NotificationChain msgs) {
		Pattern oldVPattern = vPattern;
		vPattern = newVPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XmuPackage.FOR_STATEMENT__VPATTERN, oldVPattern, newVPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVPattern(Pattern newVPattern) {
		if (newVPattern != vPattern) {
			NotificationChain msgs = null;
			if (vPattern != null)
				msgs = ((InternalEObject)vPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XmuPackage.FOR_STATEMENT__VPATTERN, null, msgs);
			if (newVPattern != null)
				msgs = ((InternalEObject)newVPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XmuPackage.FOR_STATEMENT__VPATTERN, null, msgs);
			msgs = basicSetVPattern(newVPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmuPackage.FOR_STATEMENT__VPATTERN, newVPattern, newVPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VStatement> getActions() {
		if (actions == null) {
			actions = new EObjectContainmentEList<VStatement>(VStatement.class, this, XmuPackage.FOR_STATEMENT__ACTIONS);
		}
		return actions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XmuPackage.FOR_STATEMENT__SPATTERN:
				return basicSetSPattern(null, msgs);
			case XmuPackage.FOR_STATEMENT__VPATTERN:
				return basicSetVPattern(null, msgs);
			case XmuPackage.FOR_STATEMENT__ACTIONS:
				return ((InternalEList<?>)getActions()).basicRemove(otherEnd, msgs);
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
			case XmuPackage.FOR_STATEMENT__SPATTERN:
				return getSPattern();
			case XmuPackage.FOR_STATEMENT__VPATTERN:
				return getVPattern();
			case XmuPackage.FOR_STATEMENT__ACTIONS:
				return getActions();
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
			case XmuPackage.FOR_STATEMENT__SPATTERN:
				setSPattern((Pattern)newValue);
				return;
			case XmuPackage.FOR_STATEMENT__VPATTERN:
				setVPattern((Pattern)newValue);
				return;
			case XmuPackage.FOR_STATEMENT__ACTIONS:
				getActions().clear();
				getActions().addAll((Collection<? extends VStatement>)newValue);
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
			case XmuPackage.FOR_STATEMENT__SPATTERN:
				setSPattern((Pattern)null);
				return;
			case XmuPackage.FOR_STATEMENT__VPATTERN:
				setVPattern((Pattern)null);
				return;
			case XmuPackage.FOR_STATEMENT__ACTIONS:
				getActions().clear();
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
			case XmuPackage.FOR_STATEMENT__SPATTERN:
				return sPattern != null;
			case XmuPackage.FOR_STATEMENT__VPATTERN:
				return vPattern != null;
			case XmuPackage.FOR_STATEMENT__ACTIONS:
				return actions != null && !actions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ForStatementImpl
