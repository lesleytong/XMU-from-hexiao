/**
 */
package edu.ustb.sei.mde.xmu2core.impl;

import edu.ustb.sei.mde.xmu2core.CaseClause;
import edu.ustb.sei.mde.xmu2core.Statement;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Case Clause</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.CaseClauseImpl#getViewCreationStatements <em>View Creation Statements</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.CaseClauseImpl#getSourceCheckStatements <em>Source Check Statements</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.CaseClauseImpl#getAction <em>Action</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class CaseClauseImpl extends MinimalEObjectImpl.Container implements CaseClause {
	/**
	 * The cached value of the '{@link #getViewCreationStatements() <em>View Creation Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getViewCreationStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> viewCreationStatements;

	/**
	 * The cached value of the '{@link #getSourceCheckStatements() <em>Source Check Statements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceCheckStatements()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> sourceCheckStatements;

	/**
	 * The cached value of the '{@link #getAction() <em>Action</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAction()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> action;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CaseClauseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2corePackage.Literals.CASE_CLAUSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getViewCreationStatements() {
		if (viewCreationStatements == null) {
			viewCreationStatements = new EObjectContainmentEList<Statement>(Statement.class, this, Xmu2corePackage.CASE_CLAUSE__VIEW_CREATION_STATEMENTS);
		}
		return viewCreationStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getSourceCheckStatements() {
		if (sourceCheckStatements == null) {
			sourceCheckStatements = new EObjectContainmentEList<Statement>(Statement.class, this, Xmu2corePackage.CASE_CLAUSE__SOURCE_CHECK_STATEMENTS);
		}
		return sourceCheckStatements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getAction() {
		if (action == null) {
			action = new EObjectContainmentEList<Statement>(Statement.class, this, Xmu2corePackage.CASE_CLAUSE__ACTION);
		}
		return action;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Xmu2corePackage.CASE_CLAUSE__VIEW_CREATION_STATEMENTS:
				return ((InternalEList<?>)getViewCreationStatements()).basicRemove(otherEnd, msgs);
			case Xmu2corePackage.CASE_CLAUSE__SOURCE_CHECK_STATEMENTS:
				return ((InternalEList<?>)getSourceCheckStatements()).basicRemove(otherEnd, msgs);
			case Xmu2corePackage.CASE_CLAUSE__ACTION:
				return ((InternalEList<?>)getAction()).basicRemove(otherEnd, msgs);
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
			case Xmu2corePackage.CASE_CLAUSE__VIEW_CREATION_STATEMENTS:
				return getViewCreationStatements();
			case Xmu2corePackage.CASE_CLAUSE__SOURCE_CHECK_STATEMENTS:
				return getSourceCheckStatements();
			case Xmu2corePackage.CASE_CLAUSE__ACTION:
				return getAction();
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
			case Xmu2corePackage.CASE_CLAUSE__VIEW_CREATION_STATEMENTS:
				getViewCreationStatements().clear();
				getViewCreationStatements().addAll((Collection<? extends Statement>)newValue);
				return;
			case Xmu2corePackage.CASE_CLAUSE__SOURCE_CHECK_STATEMENTS:
				getSourceCheckStatements().clear();
				getSourceCheckStatements().addAll((Collection<? extends Statement>)newValue);
				return;
			case Xmu2corePackage.CASE_CLAUSE__ACTION:
				getAction().clear();
				getAction().addAll((Collection<? extends Statement>)newValue);
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
			case Xmu2corePackage.CASE_CLAUSE__VIEW_CREATION_STATEMENTS:
				getViewCreationStatements().clear();
				return;
			case Xmu2corePackage.CASE_CLAUSE__SOURCE_CHECK_STATEMENTS:
				getSourceCheckStatements().clear();
				return;
			case Xmu2corePackage.CASE_CLAUSE__ACTION:
				getAction().clear();
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
			case Xmu2corePackage.CASE_CLAUSE__VIEW_CREATION_STATEMENTS:
				return viewCreationStatements != null && !viewCreationStatements.isEmpty();
			case Xmu2corePackage.CASE_CLAUSE__SOURCE_CHECK_STATEMENTS:
				return sourceCheckStatements != null && !sourceCheckStatements.isEmpty();
			case Xmu2corePackage.CASE_CLAUSE__ACTION:
				return action != null && !action.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CaseClauseImpl
