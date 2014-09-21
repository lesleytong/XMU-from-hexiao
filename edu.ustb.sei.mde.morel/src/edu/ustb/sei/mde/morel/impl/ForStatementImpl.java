/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.BooleanImpliesExp;
import edu.ustb.sei.mde.morel.Expression;
import edu.ustb.sei.mde.morel.ForStatement;
import edu.ustb.sei.mde.morel.ImperativeStatement;
import edu.ustb.sei.mde.morel.MorelPackage;
import edu.ustb.sei.mde.morel.VariableWithInit;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.ForStatementImpl#getIterator <em>Iterator</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.ForStatementImpl#getTerminationExp <em>Termination Exp</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.ForStatementImpl#getStepExp <em>Step Exp</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.ForStatementImpl#getBodyStatement <em>Body Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForStatementImpl extends ImperativeStatementImpl implements ForStatement {
	/**
	 * The cached value of the '{@link #getIterator() <em>Iterator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterator()
	 * @generated
	 * @ordered
	 */
	protected VariableWithInit iterator;

	/**
	 * The cached value of the '{@link #getTerminationExp() <em>Termination Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTerminationExp()
	 * @generated
	 * @ordered
	 */
	protected BooleanImpliesExp terminationExp;

	/**
	 * The cached value of the '{@link #getStepExp() <em>Step Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepExp()
	 * @generated
	 * @ordered
	 */
	protected Expression stepExp;

	/**
	 * The cached value of the '{@link #getBodyStatement() <em>Body Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodyStatement()
	 * @generated
	 * @ordered
	 */
	protected ImperativeStatement bodyStatement;

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
		return MorelPackage.Literals.FOR_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableWithInit getIterator() {
		return iterator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterator(VariableWithInit newIterator, NotificationChain msgs) {
		VariableWithInit oldIterator = iterator;
		iterator = newIterator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.FOR_STATEMENT__ITERATOR, oldIterator, newIterator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterator(VariableWithInit newIterator) {
		if (newIterator != iterator) {
			NotificationChain msgs = null;
			if (iterator != null)
				msgs = ((InternalEObject)iterator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.FOR_STATEMENT__ITERATOR, null, msgs);
			if (newIterator != null)
				msgs = ((InternalEObject)newIterator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.FOR_STATEMENT__ITERATOR, null, msgs);
			msgs = basicSetIterator(newIterator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.FOR_STATEMENT__ITERATOR, newIterator, newIterator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanImpliesExp getTerminationExp() {
		return terminationExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTerminationExp(BooleanImpliesExp newTerminationExp, NotificationChain msgs) {
		BooleanImpliesExp oldTerminationExp = terminationExp;
		terminationExp = newTerminationExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.FOR_STATEMENT__TERMINATION_EXP, oldTerminationExp, newTerminationExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTerminationExp(BooleanImpliesExp newTerminationExp) {
		if (newTerminationExp != terminationExp) {
			NotificationChain msgs = null;
			if (terminationExp != null)
				msgs = ((InternalEObject)terminationExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.FOR_STATEMENT__TERMINATION_EXP, null, msgs);
			if (newTerminationExp != null)
				msgs = ((InternalEObject)newTerminationExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.FOR_STATEMENT__TERMINATION_EXP, null, msgs);
			msgs = basicSetTerminationExp(newTerminationExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.FOR_STATEMENT__TERMINATION_EXP, newTerminationExp, newTerminationExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getStepExp() {
		return stepExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStepExp(Expression newStepExp, NotificationChain msgs) {
		Expression oldStepExp = stepExp;
		stepExp = newStepExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.FOR_STATEMENT__STEP_EXP, oldStepExp, newStepExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepExp(Expression newStepExp) {
		if (newStepExp != stepExp) {
			NotificationChain msgs = null;
			if (stepExp != null)
				msgs = ((InternalEObject)stepExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.FOR_STATEMENT__STEP_EXP, null, msgs);
			if (newStepExp != null)
				msgs = ((InternalEObject)newStepExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.FOR_STATEMENT__STEP_EXP, null, msgs);
			msgs = basicSetStepExp(newStepExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.FOR_STATEMENT__STEP_EXP, newStepExp, newStepExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeStatement getBodyStatement() {
		return bodyStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodyStatement(ImperativeStatement newBodyStatement, NotificationChain msgs) {
		ImperativeStatement oldBodyStatement = bodyStatement;
		bodyStatement = newBodyStatement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.FOR_STATEMENT__BODY_STATEMENT, oldBodyStatement, newBodyStatement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodyStatement(ImperativeStatement newBodyStatement) {
		if (newBodyStatement != bodyStatement) {
			NotificationChain msgs = null;
			if (bodyStatement != null)
				msgs = ((InternalEObject)bodyStatement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.FOR_STATEMENT__BODY_STATEMENT, null, msgs);
			if (newBodyStatement != null)
				msgs = ((InternalEObject)newBodyStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.FOR_STATEMENT__BODY_STATEMENT, null, msgs);
			msgs = basicSetBodyStatement(newBodyStatement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.FOR_STATEMENT__BODY_STATEMENT, newBodyStatement, newBodyStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MorelPackage.FOR_STATEMENT__ITERATOR:
				return basicSetIterator(null, msgs);
			case MorelPackage.FOR_STATEMENT__TERMINATION_EXP:
				return basicSetTerminationExp(null, msgs);
			case MorelPackage.FOR_STATEMENT__STEP_EXP:
				return basicSetStepExp(null, msgs);
			case MorelPackage.FOR_STATEMENT__BODY_STATEMENT:
				return basicSetBodyStatement(null, msgs);
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
			case MorelPackage.FOR_STATEMENT__ITERATOR:
				return getIterator();
			case MorelPackage.FOR_STATEMENT__TERMINATION_EXP:
				return getTerminationExp();
			case MorelPackage.FOR_STATEMENT__STEP_EXP:
				return getStepExp();
			case MorelPackage.FOR_STATEMENT__BODY_STATEMENT:
				return getBodyStatement();
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
			case MorelPackage.FOR_STATEMENT__ITERATOR:
				setIterator((VariableWithInit)newValue);
				return;
			case MorelPackage.FOR_STATEMENT__TERMINATION_EXP:
				setTerminationExp((BooleanImpliesExp)newValue);
				return;
			case MorelPackage.FOR_STATEMENT__STEP_EXP:
				setStepExp((Expression)newValue);
				return;
			case MorelPackage.FOR_STATEMENT__BODY_STATEMENT:
				setBodyStatement((ImperativeStatement)newValue);
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
			case MorelPackage.FOR_STATEMENT__ITERATOR:
				setIterator((VariableWithInit)null);
				return;
			case MorelPackage.FOR_STATEMENT__TERMINATION_EXP:
				setTerminationExp((BooleanImpliesExp)null);
				return;
			case MorelPackage.FOR_STATEMENT__STEP_EXP:
				setStepExp((Expression)null);
				return;
			case MorelPackage.FOR_STATEMENT__BODY_STATEMENT:
				setBodyStatement((ImperativeStatement)null);
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
			case MorelPackage.FOR_STATEMENT__ITERATOR:
				return iterator != null;
			case MorelPackage.FOR_STATEMENT__TERMINATION_EXP:
				return terminationExp != null;
			case MorelPackage.FOR_STATEMENT__STEP_EXP:
				return stepExp != null;
			case MorelPackage.FOR_STATEMENT__BODY_STATEMENT:
				return bodyStatement != null;
		}
		return super.eIsSet(featureID);
	}

} //ForStatementImpl
