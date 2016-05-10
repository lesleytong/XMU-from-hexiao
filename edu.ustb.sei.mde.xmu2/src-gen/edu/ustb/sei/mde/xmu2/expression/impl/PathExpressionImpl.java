/**
 */
package edu.ustb.sei.mde.xmu2.expression.impl;

import edu.ustb.sei.mde.xmu2.expression.AtomicExpression;
import edu.ustb.sei.mde.xmu2.expression.ExpressionPackage;
import edu.ustb.sei.mde.xmu2.expression.Path;
import edu.ustb.sei.mde.xmu2.expression.PathExpression;

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
 * An implementation of the model object '<em><b>Path Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.impl.PathExpressionImpl#getPath <em>Path</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.expression.impl.PathExpressionImpl#getHost <em>Host</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PathExpressionImpl extends UnaryExpressionChildImpl implements PathExpression {
	/**
	 * The cached value of the '{@link #getPath() <em>Path</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPath()
	 * @generated
	 * @ordered
	 */
	protected EList<Path> path;

	/**
	 * The cached value of the '{@link #getHost() <em>Host</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected AtomicExpression host;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PathExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionPackage.Literals.PATH_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Path> getPath() {
		if (path == null) {
			path = new EObjectContainmentEList<Path>(Path.class, this, ExpressionPackage.PATH_EXPRESSION__PATH);
		}
		return path;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicExpression getHost() {
		return host;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHost(AtomicExpression newHost, NotificationChain msgs) {
		AtomicExpression oldHost = host;
		host = newHost;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionPackage.PATH_EXPRESSION__HOST, oldHost, newHost);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHost(AtomicExpression newHost) {
		if (newHost != host) {
			NotificationChain msgs = null;
			if (host != null)
				msgs = ((InternalEObject)host).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.PATH_EXPRESSION__HOST, null, msgs);
			if (newHost != null)
				msgs = ((InternalEObject)newHost).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionPackage.PATH_EXPRESSION__HOST, null, msgs);
			msgs = basicSetHost(newHost, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionPackage.PATH_EXPRESSION__HOST, newHost, newHost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionPackage.PATH_EXPRESSION__PATH:
				return ((InternalEList<?>)getPath()).basicRemove(otherEnd, msgs);
			case ExpressionPackage.PATH_EXPRESSION__HOST:
				return basicSetHost(null, msgs);
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
			case ExpressionPackage.PATH_EXPRESSION__PATH:
				return getPath();
			case ExpressionPackage.PATH_EXPRESSION__HOST:
				return getHost();
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
			case ExpressionPackage.PATH_EXPRESSION__PATH:
				getPath().clear();
				getPath().addAll((Collection<? extends Path>)newValue);
				return;
			case ExpressionPackage.PATH_EXPRESSION__HOST:
				setHost((AtomicExpression)newValue);
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
			case ExpressionPackage.PATH_EXPRESSION__PATH:
				getPath().clear();
				return;
			case ExpressionPackage.PATH_EXPRESSION__HOST:
				setHost((AtomicExpression)null);
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
			case ExpressionPackage.PATH_EXPRESSION__PATH:
				return path != null && !path.isEmpty();
			case ExpressionPackage.PATH_EXPRESSION__HOST:
				return host != null;
		}
		return super.eIsSet(featureID);
	}

} //PathExpressionImpl
