/**
 */
package edu.ustb.sei.mde.xmu2core.impl;

import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.Procedure;
import edu.ustb.sei.mde.xmu2core.ProcedureCallStatement;
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
 * An implementation of the model object '<em><b>Procedure Call Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.ProcedureCallStatementImpl#getProcedure <em>Procedure</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.ProcedureCallStatementImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.ProcedureCallStatementImpl#getUpdatedParameters <em>Updated Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcedureCallStatementImpl extends StatementImpl implements ProcedureCallStatement {
	/**
	 * The cached value of the '{@link #getProcedure() <em>Procedure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcedure()
	 * @generated
	 * @ordered
	 */
	protected Procedure procedure;

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
	protected ProcedureCallStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2corePackage.Literals.PROCEDURE_CALL_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Procedure getProcedure() {
		if (procedure != null && procedure.eIsProxy()) {
			InternalEObject oldProcedure = (InternalEObject)procedure;
			procedure = (Procedure)eResolveProxy(oldProcedure);
			if (procedure != oldProcedure) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xmu2corePackage.PROCEDURE_CALL_STATEMENT__PROCEDURE, oldProcedure, procedure));
			}
		}
		return procedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Procedure basicGetProcedure() {
		return procedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcedure(Procedure newProcedure) {
		Procedure oldProcedure = procedure;
		procedure = newProcedure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.PROCEDURE_CALL_STATEMENT__PROCEDURE, oldProcedure, procedure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Expression>(Expression.class, this, Xmu2corePackage.PROCEDURE_CALL_STATEMENT__PARAMETERS);
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
			updatedParameters = new EObjectContainmentEList<Expression>(Expression.class, this, Xmu2corePackage.PROCEDURE_CALL_STATEMENT__UPDATED_PARAMETERS);
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
			case Xmu2corePackage.PROCEDURE_CALL_STATEMENT__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case Xmu2corePackage.PROCEDURE_CALL_STATEMENT__UPDATED_PARAMETERS:
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
			case Xmu2corePackage.PROCEDURE_CALL_STATEMENT__PROCEDURE:
				if (resolve) return getProcedure();
				return basicGetProcedure();
			case Xmu2corePackage.PROCEDURE_CALL_STATEMENT__PARAMETERS:
				return getParameters();
			case Xmu2corePackage.PROCEDURE_CALL_STATEMENT__UPDATED_PARAMETERS:
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
			case Xmu2corePackage.PROCEDURE_CALL_STATEMENT__PROCEDURE:
				setProcedure((Procedure)newValue);
				return;
			case Xmu2corePackage.PROCEDURE_CALL_STATEMENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Expression>)newValue);
				return;
			case Xmu2corePackage.PROCEDURE_CALL_STATEMENT__UPDATED_PARAMETERS:
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
			case Xmu2corePackage.PROCEDURE_CALL_STATEMENT__PROCEDURE:
				setProcedure((Procedure)null);
				return;
			case Xmu2corePackage.PROCEDURE_CALL_STATEMENT__PARAMETERS:
				getParameters().clear();
				return;
			case Xmu2corePackage.PROCEDURE_CALL_STATEMENT__UPDATED_PARAMETERS:
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
			case Xmu2corePackage.PROCEDURE_CALL_STATEMENT__PROCEDURE:
				return procedure != null;
			case Xmu2corePackage.PROCEDURE_CALL_STATEMENT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case Xmu2corePackage.PROCEDURE_CALL_STATEMENT__UPDATED_PARAMETERS:
				return updatedParameters != null && !updatedParameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ProcedureCallStatementImpl
