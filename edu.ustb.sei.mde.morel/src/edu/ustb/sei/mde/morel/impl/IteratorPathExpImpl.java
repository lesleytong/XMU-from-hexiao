/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.Expression;
import edu.ustb.sei.mde.morel.IteratorPathExp;
import edu.ustb.sei.mde.morel.IteratorType;
import edu.ustb.sei.mde.morel.MorelPackage;
import edu.ustb.sei.mde.morel.Variable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterator Path Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.IteratorPathExpImpl#getType <em>Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.IteratorPathExpImpl#getFirstVar <em>First Var</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.IteratorPathExpImpl#getSecondVar <em>Second Var</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.IteratorPathExpImpl#getBodyExp <em>Body Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IteratorPathExpImpl extends LoopPathExpImpl implements IteratorPathExp {
	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final IteratorType TYPE_EDEFAULT = IteratorType.FOR_ALL;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected IteratorType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFirstVar() <em>First Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstVar()
	 * @generated
	 * @ordered
	 */
	protected Variable firstVar;

	/**
	 * The cached value of the '{@link #getSecondVar() <em>Second Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondVar()
	 * @generated
	 * @ordered
	 */
	protected Variable secondVar;

	/**
	 * The cached value of the '{@link #getBodyExp() <em>Body Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyExp()
	 * @generated
	 * @ordered
	 */
	protected Expression bodyExp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IteratorPathExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorelPackage.Literals.ITERATOR_PATH_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IteratorType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(IteratorType newType) {
		IteratorType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.ITERATOR_PATH_EXP__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getFirstVar() {
		return firstVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirstVar(Variable newFirstVar, NotificationChain msgs) {
		Variable oldFirstVar = firstVar;
		firstVar = newFirstVar;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.ITERATOR_PATH_EXP__FIRST_VAR, oldFirstVar, newFirstVar);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstVar(Variable newFirstVar) {
		if (newFirstVar != firstVar) {
			NotificationChain msgs = null;
			if (firstVar != null)
				msgs = ((InternalEObject)firstVar).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.ITERATOR_PATH_EXP__FIRST_VAR, null, msgs);
			if (newFirstVar != null)
				msgs = ((InternalEObject)newFirstVar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.ITERATOR_PATH_EXP__FIRST_VAR, null, msgs);
			msgs = basicSetFirstVar(newFirstVar, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.ITERATOR_PATH_EXP__FIRST_VAR, newFirstVar, newFirstVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getSecondVar() {
		return secondVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSecondVar(Variable newSecondVar, NotificationChain msgs) {
		Variable oldSecondVar = secondVar;
		secondVar = newSecondVar;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.ITERATOR_PATH_EXP__SECOND_VAR, oldSecondVar, newSecondVar);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondVar(Variable newSecondVar) {
		if (newSecondVar != secondVar) {
			NotificationChain msgs = null;
			if (secondVar != null)
				msgs = ((InternalEObject)secondVar).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.ITERATOR_PATH_EXP__SECOND_VAR, null, msgs);
			if (newSecondVar != null)
				msgs = ((InternalEObject)newSecondVar).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.ITERATOR_PATH_EXP__SECOND_VAR, null, msgs);
			msgs = basicSetSecondVar(newSecondVar, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.ITERATOR_PATH_EXP__SECOND_VAR, newSecondVar, newSecondVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getBodyExp() {
		return bodyExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodyExp(Expression newBodyExp, NotificationChain msgs) {
		Expression oldBodyExp = bodyExp;
		bodyExp = newBodyExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.ITERATOR_PATH_EXP__BODY_EXP, oldBodyExp, newBodyExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyExp(Expression newBodyExp) {
		if (newBodyExp != bodyExp) {
			NotificationChain msgs = null;
			if (bodyExp != null)
				msgs = ((InternalEObject)bodyExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.ITERATOR_PATH_EXP__BODY_EXP, null, msgs);
			if (newBodyExp != null)
				msgs = ((InternalEObject)newBodyExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.ITERATOR_PATH_EXP__BODY_EXP, null, msgs);
			msgs = basicSetBodyExp(newBodyExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.ITERATOR_PATH_EXP__BODY_EXP, newBodyExp, newBodyExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MorelPackage.ITERATOR_PATH_EXP__FIRST_VAR:
				return basicSetFirstVar(null, msgs);
			case MorelPackage.ITERATOR_PATH_EXP__SECOND_VAR:
				return basicSetSecondVar(null, msgs);
			case MorelPackage.ITERATOR_PATH_EXP__BODY_EXP:
				return basicSetBodyExp(null, msgs);
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
			case MorelPackage.ITERATOR_PATH_EXP__TYPE:
				return getType();
			case MorelPackage.ITERATOR_PATH_EXP__FIRST_VAR:
				return getFirstVar();
			case MorelPackage.ITERATOR_PATH_EXP__SECOND_VAR:
				return getSecondVar();
			case MorelPackage.ITERATOR_PATH_EXP__BODY_EXP:
				return getBodyExp();
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
			case MorelPackage.ITERATOR_PATH_EXP__TYPE:
				setType((IteratorType)newValue);
				return;
			case MorelPackage.ITERATOR_PATH_EXP__FIRST_VAR:
				setFirstVar((Variable)newValue);
				return;
			case MorelPackage.ITERATOR_PATH_EXP__SECOND_VAR:
				setSecondVar((Variable)newValue);
				return;
			case MorelPackage.ITERATOR_PATH_EXP__BODY_EXP:
				setBodyExp((Expression)newValue);
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
			case MorelPackage.ITERATOR_PATH_EXP__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case MorelPackage.ITERATOR_PATH_EXP__FIRST_VAR:
				setFirstVar((Variable)null);
				return;
			case MorelPackage.ITERATOR_PATH_EXP__SECOND_VAR:
				setSecondVar((Variable)null);
				return;
			case MorelPackage.ITERATOR_PATH_EXP__BODY_EXP:
				setBodyExp((Expression)null);
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
			case MorelPackage.ITERATOR_PATH_EXP__TYPE:
				return type != TYPE_EDEFAULT;
			case MorelPackage.ITERATOR_PATH_EXP__FIRST_VAR:
				return firstVar != null;
			case MorelPackage.ITERATOR_PATH_EXP__SECOND_VAR:
				return secondVar != null;
			case MorelPackage.ITERATOR_PATH_EXP__BODY_EXP:
				return bodyExp != null;
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //IteratorPathExpImpl
