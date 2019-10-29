/**
 */
package edu.ustb.sei.mde.xmu2core.impl;

import edu.ustb.sei.mde.xmu2core.CallStatement;
import edu.ustb.sei.mde.xmu2core.Callable;
import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

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
 * An implementation of the model object '<em><b>Call Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.CallStatementImpl#getCallable <em>Callable</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.CallStatementImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.CallStatementImpl#getUpdatedParameters <em>Updated Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CallStatementImpl extends StatementImpl implements CallStatement {
	/**
	 * The cached value of the '{@link #getCallable() <em>Callable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallable()
	 * @generated
	 * @ordered
	 */
	protected Callable callable;

	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> parameters;

	/**
	 * The cached value of the '{@link #getUpdatedParameters() <em>Updated Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdatedParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> updatedParameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2corePackage.Literals.CALL_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Callable getCallable() {
		if (callable != null && callable.eIsProxy()) {
			InternalEObject oldCallable = (InternalEObject)callable;
			callable = (Callable)eResolveProxy(oldCallable);
			if (callable != oldCallable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xmu2corePackage.CALL_STATEMENT__CALLABLE, oldCallable, callable));
			}
		}
		return callable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Callable basicGetCallable() {
		return callable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCallable(Callable newCallable) {
		Callable oldCallable = callable;
		callable = newCallable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.CALL_STATEMENT__CALLABLE, oldCallable, callable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Expression>(Expression.class, this, Xmu2corePackage.CALL_STATEMENT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getUpdatedParameters() {
		if (updatedParameters == null) {
			updatedParameters = new EObjectContainmentEList<Expression>(Expression.class, this, Xmu2corePackage.CALL_STATEMENT__UPDATED_PARAMETERS);
		}
		return updatedParameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Xmu2corePackage.CALL_STATEMENT__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case Xmu2corePackage.CALL_STATEMENT__UPDATED_PARAMETERS:
				return ((InternalEList<?>)getUpdatedParameters()).basicRemove(otherEnd, msgs);
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
			case Xmu2corePackage.CALL_STATEMENT__CALLABLE:
				if (resolve) return getCallable();
				return basicGetCallable();
			case Xmu2corePackage.CALL_STATEMENT__PARAMETERS:
				return getParameters();
			case Xmu2corePackage.CALL_STATEMENT__UPDATED_PARAMETERS:
				return getUpdatedParameters();
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
			case Xmu2corePackage.CALL_STATEMENT__CALLABLE:
				setCallable((Callable)newValue);
				return;
			case Xmu2corePackage.CALL_STATEMENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Expression>)newValue);
				return;
			case Xmu2corePackage.CALL_STATEMENT__UPDATED_PARAMETERS:
				getUpdatedParameters().clear();
				getUpdatedParameters().addAll((Collection<? extends Expression>)newValue);
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
			case Xmu2corePackage.CALL_STATEMENT__CALLABLE:
				setCallable((Callable)null);
				return;
			case Xmu2corePackage.CALL_STATEMENT__PARAMETERS:
				getParameters().clear();
				return;
			case Xmu2corePackage.CALL_STATEMENT__UPDATED_PARAMETERS:
				getUpdatedParameters().clear();
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
			case Xmu2corePackage.CALL_STATEMENT__CALLABLE:
				return callable != null;
			case Xmu2corePackage.CALL_STATEMENT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case Xmu2corePackage.CALL_STATEMENT__UPDATED_PARAMETERS:
				return updatedParameters != null && !updatedParameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CallStatementImpl
