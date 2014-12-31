/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.BXRewritingRule;
import edu.ustb.sei.mde.morel.Clause;
import edu.ustb.sei.mde.morel.MorelPackage;
import edu.ustb.sei.mde.morel.Pattern;

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
 * An implementation of the model object '<em><b>BX Rewriting Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.BXRewritingRuleImpl#getNac <em>Nac</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.BXRewritingRuleImpl#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.BXRewritingRuleImpl#getView <em>View</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.BXRewritingRuleImpl#getWhen <em>When</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.BXRewritingRuleImpl#getUpdate <em>Update</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.BXRewritingRuleImpl#getUnmatchSrc <em>Unmatch Src</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.BXRewritingRuleImpl#getUnmatchView <em>Unmatch View</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BXRewritingRuleImpl extends RuleElementImpl implements BXRewritingRule {
	/**
	 * The cached value of the '{@link #getNac() <em>Nac</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNac()
	 * @generated
	 * @ordered
	 */
	protected EList<Pattern> nac;

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
	 * The cached value of the '{@link #getWhen() <em>When</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhen()
	 * @generated
	 * @ordered
	 */
	protected Clause when;

	/**
	 * The cached value of the '{@link #getUpdate() <em>Update</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdate()
	 * @generated
	 * @ordered
	 */
	protected Clause update;

	/**
	 * The cached value of the '{@link #getUnmatchSrc() <em>Unmatch Src</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnmatchSrc()
	 * @generated
	 * @ordered
	 */
	protected Pattern unmatchSrc;

	/**
	 * The cached value of the '{@link #getUnmatchView() <em>Unmatch View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnmatchView()
	 * @generated
	 * @ordered
	 */
	protected Pattern unmatchView;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BXRewritingRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorelPackage.Literals.BX_REWRITING_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Pattern> getNac() {
		if (nac == null) {
			nac = new EObjectContainmentEList<Pattern>(Pattern.class, this, MorelPackage.BX_REWRITING_RULE__NAC);
		}
		return nac;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.BX_REWRITING_RULE__SOURCE, oldSource, newSource);
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
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_REWRITING_RULE__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_REWRITING_RULE__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.BX_REWRITING_RULE__SOURCE, newSource, newSource));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.BX_REWRITING_RULE__VIEW, oldView, newView);
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
				msgs = ((InternalEObject)view).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_REWRITING_RULE__VIEW, null, msgs);
			if (newView != null)
				msgs = ((InternalEObject)newView).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_REWRITING_RULE__VIEW, null, msgs);
			msgs = basicSetView(newView, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.BX_REWRITING_RULE__VIEW, newView, newView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clause getWhen() {
		return when;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetWhen(Clause newWhen, NotificationChain msgs) {
		Clause oldWhen = when;
		when = newWhen;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.BX_REWRITING_RULE__WHEN, oldWhen, newWhen);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWhen(Clause newWhen) {
		if (newWhen != when) {
			NotificationChain msgs = null;
			if (when != null)
				msgs = ((InternalEObject)when).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_REWRITING_RULE__WHEN, null, msgs);
			if (newWhen != null)
				msgs = ((InternalEObject)newWhen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_REWRITING_RULE__WHEN, null, msgs);
			msgs = basicSetWhen(newWhen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.BX_REWRITING_RULE__WHEN, newWhen, newWhen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Clause getUpdate() {
		return update;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUpdate(Clause newUpdate, NotificationChain msgs) {
		Clause oldUpdate = update;
		update = newUpdate;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.BX_REWRITING_RULE__UPDATE, oldUpdate, newUpdate);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdate(Clause newUpdate) {
		if (newUpdate != update) {
			NotificationChain msgs = null;
			if (update != null)
				msgs = ((InternalEObject)update).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_REWRITING_RULE__UPDATE, null, msgs);
			if (newUpdate != null)
				msgs = ((InternalEObject)newUpdate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_REWRITING_RULE__UPDATE, null, msgs);
			msgs = basicSetUpdate(newUpdate, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.BX_REWRITING_RULE__UPDATE, newUpdate, newUpdate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getUnmatchSrc() {
		return unmatchSrc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnmatchSrc(Pattern newUnmatchSrc, NotificationChain msgs) {
		Pattern oldUnmatchSrc = unmatchSrc;
		unmatchSrc = newUnmatchSrc;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.BX_REWRITING_RULE__UNMATCH_SRC, oldUnmatchSrc, newUnmatchSrc);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnmatchSrc(Pattern newUnmatchSrc) {
		if (newUnmatchSrc != unmatchSrc) {
			NotificationChain msgs = null;
			if (unmatchSrc != null)
				msgs = ((InternalEObject)unmatchSrc).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_REWRITING_RULE__UNMATCH_SRC, null, msgs);
			if (newUnmatchSrc != null)
				msgs = ((InternalEObject)newUnmatchSrc).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_REWRITING_RULE__UNMATCH_SRC, null, msgs);
			msgs = basicSetUnmatchSrc(newUnmatchSrc, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.BX_REWRITING_RULE__UNMATCH_SRC, newUnmatchSrc, newUnmatchSrc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern getUnmatchView() {
		return unmatchView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnmatchView(Pattern newUnmatchView, NotificationChain msgs) {
		Pattern oldUnmatchView = unmatchView;
		unmatchView = newUnmatchView;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.BX_REWRITING_RULE__UNMATCH_VIEW, oldUnmatchView, newUnmatchView);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnmatchView(Pattern newUnmatchView) {
		if (newUnmatchView != unmatchView) {
			NotificationChain msgs = null;
			if (unmatchView != null)
				msgs = ((InternalEObject)unmatchView).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_REWRITING_RULE__UNMATCH_VIEW, null, msgs);
			if (newUnmatchView != null)
				msgs = ((InternalEObject)newUnmatchView).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_REWRITING_RULE__UNMATCH_VIEW, null, msgs);
			msgs = basicSetUnmatchView(newUnmatchView, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.BX_REWRITING_RULE__UNMATCH_VIEW, newUnmatchView, newUnmatchView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MorelPackage.BX_REWRITING_RULE__NAC:
				return ((InternalEList<?>)getNac()).basicRemove(otherEnd, msgs);
			case MorelPackage.BX_REWRITING_RULE__SOURCE:
				return basicSetSource(null, msgs);
			case MorelPackage.BX_REWRITING_RULE__VIEW:
				return basicSetView(null, msgs);
			case MorelPackage.BX_REWRITING_RULE__WHEN:
				return basicSetWhen(null, msgs);
			case MorelPackage.BX_REWRITING_RULE__UPDATE:
				return basicSetUpdate(null, msgs);
			case MorelPackage.BX_REWRITING_RULE__UNMATCH_SRC:
				return basicSetUnmatchSrc(null, msgs);
			case MorelPackage.BX_REWRITING_RULE__UNMATCH_VIEW:
				return basicSetUnmatchView(null, msgs);
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
			case MorelPackage.BX_REWRITING_RULE__NAC:
				return getNac();
			case MorelPackage.BX_REWRITING_RULE__SOURCE:
				return getSource();
			case MorelPackage.BX_REWRITING_RULE__VIEW:
				return getView();
			case MorelPackage.BX_REWRITING_RULE__WHEN:
				return getWhen();
			case MorelPackage.BX_REWRITING_RULE__UPDATE:
				return getUpdate();
			case MorelPackage.BX_REWRITING_RULE__UNMATCH_SRC:
				return getUnmatchSrc();
			case MorelPackage.BX_REWRITING_RULE__UNMATCH_VIEW:
				return getUnmatchView();
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
			case MorelPackage.BX_REWRITING_RULE__NAC:
				getNac().clear();
				getNac().addAll((Collection<? extends Pattern>)newValue);
				return;
			case MorelPackage.BX_REWRITING_RULE__SOURCE:
				setSource((Pattern)newValue);
				return;
			case MorelPackage.BX_REWRITING_RULE__VIEW:
				setView((Pattern)newValue);
				return;
			case MorelPackage.BX_REWRITING_RULE__WHEN:
				setWhen((Clause)newValue);
				return;
			case MorelPackage.BX_REWRITING_RULE__UPDATE:
				setUpdate((Clause)newValue);
				return;
			case MorelPackage.BX_REWRITING_RULE__UNMATCH_SRC:
				setUnmatchSrc((Pattern)newValue);
				return;
			case MorelPackage.BX_REWRITING_RULE__UNMATCH_VIEW:
				setUnmatchView((Pattern)newValue);
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
			case MorelPackage.BX_REWRITING_RULE__NAC:
				getNac().clear();
				return;
			case MorelPackage.BX_REWRITING_RULE__SOURCE:
				setSource((Pattern)null);
				return;
			case MorelPackage.BX_REWRITING_RULE__VIEW:
				setView((Pattern)null);
				return;
			case MorelPackage.BX_REWRITING_RULE__WHEN:
				setWhen((Clause)null);
				return;
			case MorelPackage.BX_REWRITING_RULE__UPDATE:
				setUpdate((Clause)null);
				return;
			case MorelPackage.BX_REWRITING_RULE__UNMATCH_SRC:
				setUnmatchSrc((Pattern)null);
				return;
			case MorelPackage.BX_REWRITING_RULE__UNMATCH_VIEW:
				setUnmatchView((Pattern)null);
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
			case MorelPackage.BX_REWRITING_RULE__NAC:
				return nac != null && !nac.isEmpty();
			case MorelPackage.BX_REWRITING_RULE__SOURCE:
				return source != null;
			case MorelPackage.BX_REWRITING_RULE__VIEW:
				return view != null;
			case MorelPackage.BX_REWRITING_RULE__WHEN:
				return when != null;
			case MorelPackage.BX_REWRITING_RULE__UPDATE:
				return update != null;
			case MorelPackage.BX_REWRITING_RULE__UNMATCH_SRC:
				return unmatchSrc != null;
			case MorelPackage.BX_REWRITING_RULE__UNMATCH_VIEW:
				return unmatchView != null;
		}
		return super.eIsSet(featureID);
	}

} //BXRewritingRuleImpl
