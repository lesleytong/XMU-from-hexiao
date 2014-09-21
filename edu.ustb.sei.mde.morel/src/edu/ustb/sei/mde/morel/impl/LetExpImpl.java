/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.Expression;
import edu.ustb.sei.mde.morel.LetExp;
import edu.ustb.sei.mde.morel.MorelPackage;
import edu.ustb.sei.mde.morel.VariableWithInit;

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
 * An implementation of the model object '<em><b>Let Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.LetExpImpl#getVariables <em>Variables</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.LetExpImpl#getInExp <em>In Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LetExpImpl extends ExpressionImpl implements LetExp {
	/**
	 * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableWithInit> variables;

	/**
	 * The cached value of the '{@link #getInExp() <em>In Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInExp()
	 * @generated
	 * @ordered
	 */
	protected Expression inExp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LetExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorelPackage.Literals.LET_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableWithInit> getVariables() {
		if (variables == null) {
			variables = new EObjectContainmentEList<VariableWithInit>(VariableWithInit.class, this, MorelPackage.LET_EXP__VARIABLES);
		}
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getInExp() {
		return inExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInExp(Expression newInExp, NotificationChain msgs) {
		Expression oldInExp = inExp;
		inExp = newInExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.LET_EXP__IN_EXP, oldInExp, newInExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInExp(Expression newInExp) {
		if (newInExp != inExp) {
			NotificationChain msgs = null;
			if (inExp != null)
				msgs = ((InternalEObject)inExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.LET_EXP__IN_EXP, null, msgs);
			if (newInExp != null)
				msgs = ((InternalEObject)newInExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.LET_EXP__IN_EXP, null, msgs);
			msgs = basicSetInExp(newInExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.LET_EXP__IN_EXP, newInExp, newInExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MorelPackage.LET_EXP__VARIABLES:
				return ((InternalEList<?>)getVariables()).basicRemove(otherEnd, msgs);
			case MorelPackage.LET_EXP__IN_EXP:
				return basicSetInExp(null, msgs);
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
			case MorelPackage.LET_EXP__VARIABLES:
				return getVariables();
			case MorelPackage.LET_EXP__IN_EXP:
				return getInExp();
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
			case MorelPackage.LET_EXP__VARIABLES:
				getVariables().clear();
				getVariables().addAll((Collection<? extends VariableWithInit>)newValue);
				return;
			case MorelPackage.LET_EXP__IN_EXP:
				setInExp((Expression)newValue);
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
			case MorelPackage.LET_EXP__VARIABLES:
				getVariables().clear();
				return;
			case MorelPackage.LET_EXP__IN_EXP:
				setInExp((Expression)null);
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
			case MorelPackage.LET_EXP__VARIABLES:
				return variables != null && !variables.isEmpty();
			case MorelPackage.LET_EXP__IN_EXP:
				return inExp != null;
		}
		return super.eIsSet(featureID);
	}

} //LetExpImpl
