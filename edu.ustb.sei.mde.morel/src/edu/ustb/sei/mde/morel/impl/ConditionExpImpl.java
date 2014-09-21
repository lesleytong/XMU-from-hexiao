/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.BooleanImpliesExp;
import edu.ustb.sei.mde.morel.ConditionExp;
import edu.ustb.sei.mde.morel.Expression;
import edu.ustb.sei.mde.morel.MorelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Condition Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.ConditionExpImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.ConditionExpImpl#getThenBranch <em>Then Branch</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.ConditionExpImpl#getElseBranch <em>Else Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionExpImpl extends ExpressionImpl implements ConditionExp {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected BooleanImpliesExp condition;

	/**
	 * The cached value of the '{@link #getThenBranch() <em>Then Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenBranch()
	 * @generated
	 * @ordered
	 */
	protected Expression thenBranch;

	/**
	 * The cached value of the '{@link #getElseBranch() <em>Else Branch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseBranch()
	 * @generated
	 * @ordered
	 */
	protected Expression elseBranch;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorelPackage.Literals.CONDITION_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanImpliesExp getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(BooleanImpliesExp newCondition, NotificationChain msgs) {
		BooleanImpliesExp oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.CONDITION_EXP__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(BooleanImpliesExp newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.CONDITION_EXP__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.CONDITION_EXP__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.CONDITION_EXP__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getThenBranch() {
		return thenBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThenBranch(Expression newThenBranch, NotificationChain msgs) {
		Expression oldThenBranch = thenBranch;
		thenBranch = newThenBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.CONDITION_EXP__THEN_BRANCH, oldThenBranch, newThenBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThenBranch(Expression newThenBranch) {
		if (newThenBranch != thenBranch) {
			NotificationChain msgs = null;
			if (thenBranch != null)
				msgs = ((InternalEObject)thenBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.CONDITION_EXP__THEN_BRANCH, null, msgs);
			if (newThenBranch != null)
				msgs = ((InternalEObject)newThenBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.CONDITION_EXP__THEN_BRANCH, null, msgs);
			msgs = basicSetThenBranch(newThenBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.CONDITION_EXP__THEN_BRANCH, newThenBranch, newThenBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getElseBranch() {
		return elseBranch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElseBranch(Expression newElseBranch, NotificationChain msgs) {
		Expression oldElseBranch = elseBranch;
		elseBranch = newElseBranch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.CONDITION_EXP__ELSE_BRANCH, oldElseBranch, newElseBranch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElseBranch(Expression newElseBranch) {
		if (newElseBranch != elseBranch) {
			NotificationChain msgs = null;
			if (elseBranch != null)
				msgs = ((InternalEObject)elseBranch).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.CONDITION_EXP__ELSE_BRANCH, null, msgs);
			if (newElseBranch != null)
				msgs = ((InternalEObject)newElseBranch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.CONDITION_EXP__ELSE_BRANCH, null, msgs);
			msgs = basicSetElseBranch(newElseBranch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.CONDITION_EXP__ELSE_BRANCH, newElseBranch, newElseBranch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MorelPackage.CONDITION_EXP__CONDITION:
				return basicSetCondition(null, msgs);
			case MorelPackage.CONDITION_EXP__THEN_BRANCH:
				return basicSetThenBranch(null, msgs);
			case MorelPackage.CONDITION_EXP__ELSE_BRANCH:
				return basicSetElseBranch(null, msgs);
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
			case MorelPackage.CONDITION_EXP__CONDITION:
				return getCondition();
			case MorelPackage.CONDITION_EXP__THEN_BRANCH:
				return getThenBranch();
			case MorelPackage.CONDITION_EXP__ELSE_BRANCH:
				return getElseBranch();
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
			case MorelPackage.CONDITION_EXP__CONDITION:
				setCondition((BooleanImpliesExp)newValue);
				return;
			case MorelPackage.CONDITION_EXP__THEN_BRANCH:
				setThenBranch((Expression)newValue);
				return;
			case MorelPackage.CONDITION_EXP__ELSE_BRANCH:
				setElseBranch((Expression)newValue);
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
			case MorelPackage.CONDITION_EXP__CONDITION:
				setCondition((BooleanImpliesExp)null);
				return;
			case MorelPackage.CONDITION_EXP__THEN_BRANCH:
				setThenBranch((Expression)null);
				return;
			case MorelPackage.CONDITION_EXP__ELSE_BRANCH:
				setElseBranch((Expression)null);
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
			case MorelPackage.CONDITION_EXP__CONDITION:
				return condition != null;
			case MorelPackage.CONDITION_EXP__THEN_BRANCH:
				return thenBranch != null;
			case MorelPackage.CONDITION_EXP__ELSE_BRANCH:
				return elseBranch != null;
		}
		return super.eIsSet(featureID);
	}

} //ConditionExpImpl
