/**
 */
package edu.ustb.sei.mde.xmu2.statement.impl;

import edu.ustb.sei.mde.xmu2.AbstractRule;

import edu.ustb.sei.mde.xmu2.expression.Expression;

import edu.ustb.sei.mde.xmu2.statement.RuleCallStatement;
import edu.ustb.sei.mde.xmu2.statement.StatementPackage;

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
 * An implementation of the model object '<em><b>Rule Call Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.impl.RuleCallStatementImpl#getRule <em>Rule</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.impl.RuleCallStatementImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleCallStatementImpl extends BidirectionalStatementImpl implements RuleCallStatement {
	/**
	 * The cached value of the '{@link #getRule() <em>Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRule()
	 * @generated
	 * @ordered
	 */
	protected AbstractRule rule;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleCallStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatementPackage.Literals.RULE_CALL_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractRule getRule() {
		if (rule != null && rule.eIsProxy()) {
			InternalEObject oldRule = (InternalEObject)rule;
			rule = (AbstractRule)eResolveProxy(oldRule);
			if (rule != oldRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StatementPackage.RULE_CALL_STATEMENT__RULE, oldRule, rule));
			}
		}
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractRule basicGetRule() {
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRule(AbstractRule newRule) {
		AbstractRule oldRule = rule;
		rule = newRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.RULE_CALL_STATEMENT__RULE, oldRule, rule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Expression> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Expression>(Expression.class, this, StatementPackage.RULE_CALL_STATEMENT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatementPackage.RULE_CALL_STATEMENT__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case StatementPackage.RULE_CALL_STATEMENT__RULE:
				if (resolve) return getRule();
				return basicGetRule();
			case StatementPackage.RULE_CALL_STATEMENT__PARAMETERS:
				return getParameters();
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
			case StatementPackage.RULE_CALL_STATEMENT__RULE:
				setRule((AbstractRule)newValue);
				return;
			case StatementPackage.RULE_CALL_STATEMENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Expression>)newValue);
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
			case StatementPackage.RULE_CALL_STATEMENT__RULE:
				setRule((AbstractRule)null);
				return;
			case StatementPackage.RULE_CALL_STATEMENT__PARAMETERS:
				getParameters().clear();
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
			case StatementPackage.RULE_CALL_STATEMENT__RULE:
				return rule != null;
			case StatementPackage.RULE_CALL_STATEMENT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RuleCallStatementImpl
