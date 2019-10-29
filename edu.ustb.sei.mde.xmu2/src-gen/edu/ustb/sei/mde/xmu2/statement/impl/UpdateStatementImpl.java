/**
 */
package edu.ustb.sei.mde.xmu2.statement.impl;

import edu.ustb.sei.mde.xmu2.pattern.Pattern;

import edu.ustb.sei.mde.xmu2.statement.StatementPackage;
import edu.ustb.sei.mde.xmu2.statement.UpdateClause;
import edu.ustb.sei.mde.xmu2.statement.UpdateStatement;

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
 * An implementation of the model object '<em><b>Update Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.impl.UpdateStatementImpl#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.impl.UpdateStatementImpl#getView <em>View</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.impl.UpdateStatementImpl#getClauses <em>Clauses</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UpdateStatementImpl extends BidirectionalStatementImpl implements UpdateStatement {
	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Pattern source;

	/**
	 * The cached value of the '{@link #getView() <em>View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getView()
	 * @generated
	 * @ordered
	 */
	protected Pattern view;

	/**
	 * The cached value of the '{@link #getClauses() <em>Clauses</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClauses()
	 * @generated
	 * @ordered
	 */
	protected EList<UpdateClause> clauses;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UpdateStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatementPackage.Literals.UPDATE_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Pattern newSource, NotificationChain msgs) {
		Pattern oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatementPackage.UPDATE_STATEMENT__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Pattern newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatementPackage.UPDATE_STATEMENT__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatementPackage.UPDATE_STATEMENT__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.UPDATE_STATEMENT__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getView() {
		return view;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetView(Pattern newView, NotificationChain msgs) {
		Pattern oldView = view;
		view = newView;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatementPackage.UPDATE_STATEMENT__VIEW, oldView, newView);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setView(Pattern newView) {
		if (newView != view) {
			NotificationChain msgs = null;
			if (view != null)
				msgs = ((InternalEObject)view).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatementPackage.UPDATE_STATEMENT__VIEW, null, msgs);
			if (newView != null)
				msgs = ((InternalEObject)newView).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatementPackage.UPDATE_STATEMENT__VIEW, null, msgs);
			msgs = basicSetView(newView, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.UPDATE_STATEMENT__VIEW, newView, newView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UpdateClause> getClauses() {
		if (clauses == null) {
			clauses = new EObjectContainmentEList<UpdateClause>(UpdateClause.class, this, StatementPackage.UPDATE_STATEMENT__CLAUSES);
		}
		return clauses;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatementPackage.UPDATE_STATEMENT__SOURCE:
				return basicSetSource(null, msgs);
			case StatementPackage.UPDATE_STATEMENT__VIEW:
				return basicSetView(null, msgs);
			case StatementPackage.UPDATE_STATEMENT__CLAUSES:
				return ((InternalEList<?>)getClauses()).basicRemove(otherEnd, msgs);
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
			case StatementPackage.UPDATE_STATEMENT__SOURCE:
				return getSource();
			case StatementPackage.UPDATE_STATEMENT__VIEW:
				return getView();
			case StatementPackage.UPDATE_STATEMENT__CLAUSES:
				return getClauses();
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
			case StatementPackage.UPDATE_STATEMENT__SOURCE:
				setSource((Pattern)newValue);
				return;
			case StatementPackage.UPDATE_STATEMENT__VIEW:
				setView((Pattern)newValue);
				return;
			case StatementPackage.UPDATE_STATEMENT__CLAUSES:
				getClauses().clear();
				getClauses().addAll((Collection<? extends UpdateClause>)newValue);
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
			case StatementPackage.UPDATE_STATEMENT__SOURCE:
				setSource((Pattern)null);
				return;
			case StatementPackage.UPDATE_STATEMENT__VIEW:
				setView((Pattern)null);
				return;
			case StatementPackage.UPDATE_STATEMENT__CLAUSES:
				getClauses().clear();
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
			case StatementPackage.UPDATE_STATEMENT__SOURCE:
				return source != null;
			case StatementPackage.UPDATE_STATEMENT__VIEW:
				return view != null;
			case StatementPackage.UPDATE_STATEMENT__CLAUSES:
				return clauses != null && !clauses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UpdateStatementImpl
