/**
 */
package edu.ustb.sei.mde.xmu.impl;

import edu.ustb.sei.mde.xmu.CaseSubStatement;
import edu.ustb.sei.mde.xmu.RuleCallStatement;
import edu.ustb.sei.mde.xmu.Statement;
import edu.ustb.sei.mde.xmu.XmuPackage;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Case Sub Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.CaseSubStatementImpl#getStatement <em>Statement</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.CaseSubStatementImpl#getWhen <em>When</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CaseSubStatementImpl extends MinimalEObjectImpl.Container implements CaseSubStatement {
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
	 * The cached value of the '{@link #getWhen() <em>When</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhen()
	 * @generated
	 * @ordered
	 */
	protected EList<RuleCallStatement> when;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CaseSubStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmuPackage.Literals.CASE_SUB_STATEMENT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XmuPackage.CASE_SUB_STATEMENT__STATEMENT, oldStatement, newStatement);
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
				msgs = ((InternalEObject)statement).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XmuPackage.CASE_SUB_STATEMENT__STATEMENT, null, msgs);
			if (newStatement != null)
				msgs = ((InternalEObject)newStatement).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XmuPackage.CASE_SUB_STATEMENT__STATEMENT, null, msgs);
			msgs = basicSetStatement(newStatement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmuPackage.CASE_SUB_STATEMENT__STATEMENT, newStatement, newStatement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RuleCallStatement> getWhen() {
		if (when == null) {
			when = new EObjectContainmentEList<RuleCallStatement>(RuleCallStatement.class, this, XmuPackage.CASE_SUB_STATEMENT__WHEN);
		}
		return when;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XmuPackage.CASE_SUB_STATEMENT__STATEMENT:
				return basicSetStatement(null, msgs);
			case XmuPackage.CASE_SUB_STATEMENT__WHEN:
				return ((InternalEList<?>)getWhen()).basicRemove(otherEnd, msgs);
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
			case XmuPackage.CASE_SUB_STATEMENT__STATEMENT:
				return getStatement();
			case XmuPackage.CASE_SUB_STATEMENT__WHEN:
				return getWhen();
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
			case XmuPackage.CASE_SUB_STATEMENT__STATEMENT:
				setStatement((Statement)newValue);
				return;
			case XmuPackage.CASE_SUB_STATEMENT__WHEN:
				getWhen().clear();
				getWhen().addAll((Collection<? extends RuleCallStatement>)newValue);
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
			case XmuPackage.CASE_SUB_STATEMENT__STATEMENT:
				setStatement((Statement)null);
				return;
			case XmuPackage.CASE_SUB_STATEMENT__WHEN:
				getWhen().clear();
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
			case XmuPackage.CASE_SUB_STATEMENT__STATEMENT:
				return statement != null;
			case XmuPackage.CASE_SUB_STATEMENT__WHEN:
				return when != null && !when.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CaseSubStatementImpl
