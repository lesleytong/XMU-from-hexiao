/**
 */
package edu.ustb.sei.mde.xmu.impl;

import edu.ustb.sei.mde.xmu.ObjectVariable;
import edu.ustb.sei.mde.xmu.UpdatedStatement;
import edu.ustb.sei.mde.xmu.XmuPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Updated Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.UpdatedStatementImpl#getSVar <em>SVar</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.UpdatedStatementImpl#getVVar <em>VVar</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UpdatedStatementImpl extends StatementImpl implements UpdatedStatement {
	/**
	 * The cached value of the '{@link #getSVar() <em>SVar</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSVar()
	 * @generated
	 * @ordered
	 */
	protected ObjectVariable sVar;

	/**
	 * The cached value of the '{@link #getVVar() <em>VVar</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVVar()
	 * @generated
	 * @ordered
	 */
	protected ObjectVariable vVar;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UpdatedStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmuPackage.Literals.UPDATED_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectVariable getSVar() {
		if (sVar != null && sVar.eIsProxy()) {
			InternalEObject oldSVar = (InternalEObject)sVar;
			sVar = (ObjectVariable)eResolveProxy(oldSVar);
			if (sVar != oldSVar) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XmuPackage.UPDATED_STATEMENT__SVAR, oldSVar, sVar));
			}
		}
		return sVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectVariable basicGetSVar() {
		return sVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSVar(ObjectVariable newSVar) {
		ObjectVariable oldSVar = sVar;
		sVar = newSVar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmuPackage.UPDATED_STATEMENT__SVAR, oldSVar, sVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectVariable getVVar() {
		if (vVar != null && vVar.eIsProxy()) {
			InternalEObject oldVVar = (InternalEObject)vVar;
			vVar = (ObjectVariable)eResolveProxy(oldVVar);
			if (vVar != oldVVar) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XmuPackage.UPDATED_STATEMENT__VVAR, oldVVar, vVar));
			}
		}
		return vVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectVariable basicGetVVar() {
		return vVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVVar(ObjectVariable newVVar) {
		ObjectVariable oldVVar = vVar;
		vVar = newVVar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmuPackage.UPDATED_STATEMENT__VVAR, oldVVar, vVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case XmuPackage.UPDATED_STATEMENT__SVAR:
				if (resolve) return getSVar();
				return basicGetSVar();
			case XmuPackage.UPDATED_STATEMENT__VVAR:
				if (resolve) return getVVar();
				return basicGetVVar();
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
			case XmuPackage.UPDATED_STATEMENT__SVAR:
				setSVar((ObjectVariable)newValue);
				return;
			case XmuPackage.UPDATED_STATEMENT__VVAR:
				setVVar((ObjectVariable)newValue);
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
			case XmuPackage.UPDATED_STATEMENT__SVAR:
				setSVar((ObjectVariable)null);
				return;
			case XmuPackage.UPDATED_STATEMENT__VVAR:
				setVVar((ObjectVariable)null);
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
			case XmuPackage.UPDATED_STATEMENT__SVAR:
				return sVar != null;
			case XmuPackage.UPDATED_STATEMENT__VVAR:
				return vVar != null;
		}
		return super.eIsSet(featureID);
	}

} //UpdatedStatementImpl
