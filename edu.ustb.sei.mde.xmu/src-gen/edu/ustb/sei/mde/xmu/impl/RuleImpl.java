/**
 */
package edu.ustb.sei.mde.xmu.impl;

import edu.ustb.sei.mde.xmu.ObjectVariable;
import edu.ustb.sei.mde.xmu.Parameter;
import edu.ustb.sei.mde.xmu.PrimitiveVariable;
import edu.ustb.sei.mde.xmu.Rule;
import edu.ustb.sei.mde.xmu.Statement;
import edu.ustb.sei.mde.xmu.XmuPackage;

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
 * An implementation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.RuleImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.RuleImpl#getNVars <em>NVars</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.RuleImpl#getSVars <em>SVars</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.RuleImpl#getSpVars <em>Sp Vars</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.RuleImpl#getVVars <em>VVars</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.RuleImpl#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RuleImpl extends NamedElementImpl implements Rule {
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
	 * The cached value of the '{@link #getNVars() <em>NVars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNVars()
	 * @generated
	 * @ordered
	 */
	protected EList<PrimitiveVariable> nVars;

	/**
	 * The cached value of the '{@link #getSVars() <em>SVars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSVars()
	 * @generated
	 * @ordered
	 */
	protected EList<ObjectVariable> sVars;

	/**
	 * The cached value of the '{@link #getSpVars() <em>Sp Vars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpVars()
	 * @generated
	 * @ordered
	 */
	protected EList<ObjectVariable> spVars;

	/**
	 * The cached value of the '{@link #getVVars() <em>VVars</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVVars()
	 * @generated
	 * @ordered
	 */
	protected EList<ObjectVariable> vVars;

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
	protected RuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmuPackage.Literals.RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PrimitiveVariable> getNVars() {
		if (nVars == null) {
			nVars = new EObjectContainmentEList<PrimitiveVariable>(PrimitiveVariable.class, this, XmuPackage.RULE__NVARS);
		}
		return nVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjectVariable> getSVars() {
		if (sVars == null) {
			sVars = new EObjectContainmentEList<ObjectVariable>(ObjectVariable.class, this, XmuPackage.RULE__SVARS);
		}
		return sVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjectVariable> getSpVars() {
		if (spVars == null) {
			spVars = new EObjectContainmentEList<ObjectVariable>(ObjectVariable.class, this, XmuPackage.RULE__SP_VARS);
		}
		return spVars;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ObjectVariable> getVVars() {
		if (vVars == null) {
			vVars = new EObjectContainmentEList<ObjectVariable>(ObjectVariable.class, this, XmuPackage.RULE__VVARS);
		}
		return vVars;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XmuPackage.RULE__STATEMENT, oldStatement, newStatement);
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
				msgs = ((InternalEObject)statement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XmuPackage.RULE__STATEMENT, null, msgs);
			if (newStatement != null)
				msgs = ((InternalEObject)newStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XmuPackage.RULE__STATEMENT, null, msgs);
			msgs = basicSetStatement(newStatement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmuPackage.RULE__STATEMENT, newStatement, newStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, XmuPackage.RULE__PARAMETERS);
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
			case XmuPackage.RULE__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
			case XmuPackage.RULE__NVARS:
				return ((InternalEList<?>)getNVars()).basicRemove(otherEnd, msgs);
			case XmuPackage.RULE__SVARS:
				return ((InternalEList<?>)getSVars()).basicRemove(otherEnd, msgs);
			case XmuPackage.RULE__SP_VARS:
				return ((InternalEList<?>)getSpVars()).basicRemove(otherEnd, msgs);
			case XmuPackage.RULE__VVARS:
				return ((InternalEList<?>)getVVars()).basicRemove(otherEnd, msgs);
			case XmuPackage.RULE__STATEMENT:
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
			case XmuPackage.RULE__PARAMETERS:
				return getParameters();
			case XmuPackage.RULE__NVARS:
				return getNVars();
			case XmuPackage.RULE__SVARS:
				return getSVars();
			case XmuPackage.RULE__SP_VARS:
				return getSpVars();
			case XmuPackage.RULE__VVARS:
				return getVVars();
			case XmuPackage.RULE__STATEMENT:
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
			case XmuPackage.RULE__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
				return;
			case XmuPackage.RULE__NVARS:
				getNVars().clear();
				getNVars().addAll((Collection<? extends PrimitiveVariable>)newValue);
				return;
			case XmuPackage.RULE__SVARS:
				getSVars().clear();
				getSVars().addAll((Collection<? extends ObjectVariable>)newValue);
				return;
			case XmuPackage.RULE__SP_VARS:
				getSpVars().clear();
				getSpVars().addAll((Collection<? extends ObjectVariable>)newValue);
				return;
			case XmuPackage.RULE__VVARS:
				getVVars().clear();
				getVVars().addAll((Collection<? extends ObjectVariable>)newValue);
				return;
			case XmuPackage.RULE__STATEMENT:
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
			case XmuPackage.RULE__PARAMETERS:
				getParameters().clear();
				return;
			case XmuPackage.RULE__NVARS:
				getNVars().clear();
				return;
			case XmuPackage.RULE__SVARS:
				getSVars().clear();
				return;
			case XmuPackage.RULE__SP_VARS:
				getSpVars().clear();
				return;
			case XmuPackage.RULE__VVARS:
				getVVars().clear();
				return;
			case XmuPackage.RULE__STATEMENT:
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
			case XmuPackage.RULE__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case XmuPackage.RULE__NVARS:
				return nVars != null && !nVars.isEmpty();
			case XmuPackage.RULE__SVARS:
				return sVars != null && !sVars.isEmpty();
			case XmuPackage.RULE__SP_VARS:
				return spVars != null && !spVars.isEmpty();
			case XmuPackage.RULE__VVARS:
				return vVars != null && !vVars.isEmpty();
			case XmuPackage.RULE__STATEMENT:
				return statement != null;
		}
		return super.eIsSet(featureID);
	}

} //RuleImpl
