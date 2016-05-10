/**
 */
package edu.ustb.sei.mde.xmu2.impl;

import edu.ustb.sei.mde.xmu2.AbstractRule;
import edu.ustb.sei.mde.xmu2.Parameter;
import edu.ustb.sei.mde.xmu2.Xmu2Package;

import edu.ustb.sei.mde.xmu2.statement.Statement;

import edu.ustb.sei.mde.xmu2common.impl.NamedElementImpl;

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
 * An implementation of the model object '<em><b>Abstract Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.impl.AbstractRuleImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.impl.AbstractRuleImpl#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractRuleImpl extends NamedElementImpl implements AbstractRule {
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * The cached value of the '{@link #getStatement() <em>Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatement()
	 * @generated
	 * @ordered
	 */
	protected Statement statement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2Package.Literals.ABSTRACT_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, Xmu2Package.ABSTRACT_RULE__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement getStatement() {
		return statement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStatement(Statement newStatement, NotificationChain msgs) {
		Statement oldStatement = statement;
		statement = newStatement;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2Package.ABSTRACT_RULE__STATEMENT, oldStatement, newStatement);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatement(Statement newStatement) {
		if (newStatement != statement) {
			NotificationChain msgs = null;
			if (statement != null)
				msgs = ((InternalEObject)statement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2Package.ABSTRACT_RULE__STATEMENT, null, msgs);
			if (newStatement != null)
				msgs = ((InternalEObject)newStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2Package.ABSTRACT_RULE__STATEMENT, null, msgs);
			msgs = basicSetStatement(newStatement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2Package.ABSTRACT_RULE__STATEMENT, newStatement, newStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Xmu2Package.ABSTRACT_RULE__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case Xmu2Package.ABSTRACT_RULE__STATEMENT:
				return basicSetStatement(null, msgs);
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
			case Xmu2Package.ABSTRACT_RULE__PARAMETERS:
				return getParameters();
			case Xmu2Package.ABSTRACT_RULE__STATEMENT:
				return getStatement();
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
			case Xmu2Package.ABSTRACT_RULE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case Xmu2Package.ABSTRACT_RULE__STATEMENT:
				setStatement((Statement)newValue);
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
			case Xmu2Package.ABSTRACT_RULE__PARAMETERS:
				getParameters().clear();
				return;
			case Xmu2Package.ABSTRACT_RULE__STATEMENT:
				setStatement((Statement)null);
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
			case Xmu2Package.ABSTRACT_RULE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case Xmu2Package.ABSTRACT_RULE__STATEMENT:
				return statement != null;
		}
		return super.eIsSet(featureID);
	}

} //AbstractRuleImpl
