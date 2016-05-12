/**
 */
package edu.ustb.sei.mde.xmu2core.impl;

import edu.ustb.sei.mde.xmu2core.AlignStatement;
import edu.ustb.sei.mde.xmu2core.Pattern;
import edu.ustb.sei.mde.xmu2core.Statement;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

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
 * An implementation of the model object '<em><b>Align Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.AlignStatementImpl#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.AlignStatementImpl#getView <em>View</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.AlignStatementImpl#getMatch <em>Match</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.AlignStatementImpl#getUnmatchv <em>Unmatchv</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.AlignStatementImpl#getUnmatchs <em>Unmatchs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AlignStatementImpl extends StatementImpl implements AlignStatement {
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
	 * The cached value of the '{@link #getMatch() <em>Match</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatch()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> match;

	/**
	 * The cached value of the '{@link #getUnmatchv() <em>Unmatchv</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnmatchv()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> unmatchv;

	/**
	 * The cached value of the '{@link #getUnmatchs() <em>Unmatchs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnmatchs()
	 * @generated
	 * @ordered
	 */
	protected EList<Statement> unmatchs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AlignStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2corePackage.Literals.ALIGN_STATEMENT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ALIGN_STATEMENT__SOURCE, oldSource, newSource);
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
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.ALIGN_STATEMENT__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.ALIGN_STATEMENT__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ALIGN_STATEMENT__SOURCE, newSource, newSource));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ALIGN_STATEMENT__VIEW, oldView, newView);
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
				msgs = ((InternalEObject)view).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.ALIGN_STATEMENT__VIEW, null, msgs);
			if (newView != null)
				msgs = ((InternalEObject)newView).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.ALIGN_STATEMENT__VIEW, null, msgs);
			msgs = basicSetView(newView, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ALIGN_STATEMENT__VIEW, newView, newView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getMatch() {
		if (match == null) {
			match = new EObjectContainmentEList<Statement>(Statement.class, this, Xmu2corePackage.ALIGN_STATEMENT__MATCH);
		}
		return match;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getUnmatchv() {
		if (unmatchv == null) {
			unmatchv = new EObjectContainmentEList<Statement>(Statement.class, this, Xmu2corePackage.ALIGN_STATEMENT__UNMATCHV);
		}
		return unmatchv;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statement> getUnmatchs() {
		if (unmatchs == null) {
			unmatchs = new EObjectContainmentEList<Statement>(Statement.class, this, Xmu2corePackage.ALIGN_STATEMENT__UNMATCHS);
		}
		return unmatchs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Xmu2corePackage.ALIGN_STATEMENT__SOURCE:
				return basicSetSource(null, msgs);
			case Xmu2corePackage.ALIGN_STATEMENT__VIEW:
				return basicSetView(null, msgs);
			case Xmu2corePackage.ALIGN_STATEMENT__MATCH:
				return ((InternalEList<?>)getMatch()).basicRemove(otherEnd, msgs);
			case Xmu2corePackage.ALIGN_STATEMENT__UNMATCHV:
				return ((InternalEList<?>)getUnmatchv()).basicRemove(otherEnd, msgs);
			case Xmu2corePackage.ALIGN_STATEMENT__UNMATCHS:
				return ((InternalEList<?>)getUnmatchs()).basicRemove(otherEnd, msgs);
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
			case Xmu2corePackage.ALIGN_STATEMENT__SOURCE:
				return getSource();
			case Xmu2corePackage.ALIGN_STATEMENT__VIEW:
				return getView();
			case Xmu2corePackage.ALIGN_STATEMENT__MATCH:
				return getMatch();
			case Xmu2corePackage.ALIGN_STATEMENT__UNMATCHV:
				return getUnmatchv();
			case Xmu2corePackage.ALIGN_STATEMENT__UNMATCHS:
				return getUnmatchs();
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
			case Xmu2corePackage.ALIGN_STATEMENT__SOURCE:
				setSource((Pattern)newValue);
				return;
			case Xmu2corePackage.ALIGN_STATEMENT__VIEW:
				setView((Pattern)newValue);
				return;
			case Xmu2corePackage.ALIGN_STATEMENT__MATCH:
				getMatch().clear();
				getMatch().addAll((Collection<? extends Statement>)newValue);
				return;
			case Xmu2corePackage.ALIGN_STATEMENT__UNMATCHV:
				getUnmatchv().clear();
				getUnmatchv().addAll((Collection<? extends Statement>)newValue);
				return;
			case Xmu2corePackage.ALIGN_STATEMENT__UNMATCHS:
				getUnmatchs().clear();
				getUnmatchs().addAll((Collection<? extends Statement>)newValue);
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
			case Xmu2corePackage.ALIGN_STATEMENT__SOURCE:
				setSource((Pattern)null);
				return;
			case Xmu2corePackage.ALIGN_STATEMENT__VIEW:
				setView((Pattern)null);
				return;
			case Xmu2corePackage.ALIGN_STATEMENT__MATCH:
				getMatch().clear();
				return;
			case Xmu2corePackage.ALIGN_STATEMENT__UNMATCHV:
				getUnmatchv().clear();
				return;
			case Xmu2corePackage.ALIGN_STATEMENT__UNMATCHS:
				getUnmatchs().clear();
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
			case Xmu2corePackage.ALIGN_STATEMENT__SOURCE:
				return source != null;
			case Xmu2corePackage.ALIGN_STATEMENT__VIEW:
				return view != null;
			case Xmu2corePackage.ALIGN_STATEMENT__MATCH:
				return match != null && !match.isEmpty();
			case Xmu2corePackage.ALIGN_STATEMENT__UNMATCHV:
				return unmatchv != null && !unmatchv.isEmpty();
			case Xmu2corePackage.ALIGN_STATEMENT__UNMATCHS:
				return unmatchs != null && !unmatchs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AlignStatementImpl
