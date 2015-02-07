/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.Action;
import edu.ustb.sei.mde.morel.BxMorelRule;
import edu.ustb.sei.mde.morel.Clause;
import edu.ustb.sei.mde.morel.MorelPackage;
import edu.ustb.sei.mde.morel.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bx Morel Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.BxMorelRuleImpl#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.BxMorelRuleImpl#getView <em>View</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.BxMorelRuleImpl#getWhen <em>When</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.BxMorelRuleImpl#getMatch <em>Match</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.BxMorelRuleImpl#getUnmatchSrc <em>Unmatch Src</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.BxMorelRuleImpl#getUnmatchView <em>Unmatch View</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BxMorelRuleImpl extends RuleElementImpl implements BxMorelRule {
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
	 * The cached value of the '{@link #getMatch() <em>Match</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatch()
	 * @generated
	 * @ordered
	 */
	protected Action match;

	/**
	 * The cached value of the '{@link #getUnmatchSrc() <em>Unmatch Src</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnmatchSrc()
	 * @generated
	 * @ordered
	 */
	protected Action unmatchSrc;

	/**
	 * The cached value of the '{@link #getUnmatchView() <em>Unmatch View</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUnmatchView()
	 * @generated
	 * @ordered
	 */
	protected Action unmatchView;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BxMorelRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorelPackage.Literals.BX_MOREL_RULE;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.BX_MOREL_RULE__SOURCE, oldSource, newSource);
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
				msgs = ((InternalEObject)source).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_MOREL_RULE__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_MOREL_RULE__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.BX_MOREL_RULE__SOURCE, newSource, newSource));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.BX_MOREL_RULE__VIEW, oldView, newView);
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
				msgs = ((InternalEObject)view).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_MOREL_RULE__VIEW, null, msgs);
			if (newView != null)
				msgs = ((InternalEObject)newView).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_MOREL_RULE__VIEW, null, msgs);
			msgs = basicSetView(newView, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.BX_MOREL_RULE__VIEW, newView, newView));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.BX_MOREL_RULE__WHEN, oldWhen, newWhen);
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
				msgs = ((InternalEObject)when).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_MOREL_RULE__WHEN, null, msgs);
			if (newWhen != null)
				msgs = ((InternalEObject)newWhen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_MOREL_RULE__WHEN, null, msgs);
			msgs = basicSetWhen(newWhen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.BX_MOREL_RULE__WHEN, newWhen, newWhen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getMatch() {
		return match;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMatch(Action newMatch, NotificationChain msgs) {
		Action oldMatch = match;
		match = newMatch;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.BX_MOREL_RULE__MATCH, oldMatch, newMatch);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMatch(Action newMatch) {
		if (newMatch != match) {
			NotificationChain msgs = null;
			if (match != null)
				msgs = ((InternalEObject)match).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_MOREL_RULE__MATCH, null, msgs);
			if (newMatch != null)
				msgs = ((InternalEObject)newMatch).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_MOREL_RULE__MATCH, null, msgs);
			msgs = basicSetMatch(newMatch, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.BX_MOREL_RULE__MATCH, newMatch, newMatch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getUnmatchSrc() {
		return unmatchSrc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnmatchSrc(Action newUnmatchSrc, NotificationChain msgs) {
		Action oldUnmatchSrc = unmatchSrc;
		unmatchSrc = newUnmatchSrc;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.BX_MOREL_RULE__UNMATCH_SRC, oldUnmatchSrc, newUnmatchSrc);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnmatchSrc(Action newUnmatchSrc) {
		if (newUnmatchSrc != unmatchSrc) {
			NotificationChain msgs = null;
			if (unmatchSrc != null)
				msgs = ((InternalEObject)unmatchSrc).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_MOREL_RULE__UNMATCH_SRC, null, msgs);
			if (newUnmatchSrc != null)
				msgs = ((InternalEObject)newUnmatchSrc).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_MOREL_RULE__UNMATCH_SRC, null, msgs);
			msgs = basicSetUnmatchSrc(newUnmatchSrc, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.BX_MOREL_RULE__UNMATCH_SRC, newUnmatchSrc, newUnmatchSrc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Action getUnmatchView() {
		return unmatchView;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUnmatchView(Action newUnmatchView, NotificationChain msgs) {
		Action oldUnmatchView = unmatchView;
		unmatchView = newUnmatchView;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MorelPackage.BX_MOREL_RULE__UNMATCH_VIEW, oldUnmatchView, newUnmatchView);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUnmatchView(Action newUnmatchView) {
		if (newUnmatchView != unmatchView) {
			NotificationChain msgs = null;
			if (unmatchView != null)
				msgs = ((InternalEObject)unmatchView).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_MOREL_RULE__UNMATCH_VIEW, null, msgs);
			if (newUnmatchView != null)
				msgs = ((InternalEObject)newUnmatchView).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - MorelPackage.BX_MOREL_RULE__UNMATCH_VIEW, null, msgs);
			msgs = basicSetUnmatchView(newUnmatchView, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.BX_MOREL_RULE__UNMATCH_VIEW, newUnmatchView, newUnmatchView));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MorelPackage.BX_MOREL_RULE__SOURCE:
				return basicSetSource(null, msgs);
			case MorelPackage.BX_MOREL_RULE__VIEW:
				return basicSetView(null, msgs);
			case MorelPackage.BX_MOREL_RULE__WHEN:
				return basicSetWhen(null, msgs);
			case MorelPackage.BX_MOREL_RULE__MATCH:
				return basicSetMatch(null, msgs);
			case MorelPackage.BX_MOREL_RULE__UNMATCH_SRC:
				return basicSetUnmatchSrc(null, msgs);
			case MorelPackage.BX_MOREL_RULE__UNMATCH_VIEW:
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
			case MorelPackage.BX_MOREL_RULE__SOURCE:
				return getSource();
			case MorelPackage.BX_MOREL_RULE__VIEW:
				return getView();
			case MorelPackage.BX_MOREL_RULE__WHEN:
				return getWhen();
			case MorelPackage.BX_MOREL_RULE__MATCH:
				return getMatch();
			case MorelPackage.BX_MOREL_RULE__UNMATCH_SRC:
				return getUnmatchSrc();
			case MorelPackage.BX_MOREL_RULE__UNMATCH_VIEW:
				return getUnmatchView();
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
			case MorelPackage.BX_MOREL_RULE__SOURCE:
				setSource((Pattern)newValue);
				return;
			case MorelPackage.BX_MOREL_RULE__VIEW:
				setView((Pattern)newValue);
				return;
			case MorelPackage.BX_MOREL_RULE__WHEN:
				setWhen((Clause)newValue);
				return;
			case MorelPackage.BX_MOREL_RULE__MATCH:
				setMatch((Action)newValue);
				return;
			case MorelPackage.BX_MOREL_RULE__UNMATCH_SRC:
				setUnmatchSrc((Action)newValue);
				return;
			case MorelPackage.BX_MOREL_RULE__UNMATCH_VIEW:
				setUnmatchView((Action)newValue);
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
			case MorelPackage.BX_MOREL_RULE__SOURCE:
				setSource((Pattern)null);
				return;
			case MorelPackage.BX_MOREL_RULE__VIEW:
				setView((Pattern)null);
				return;
			case MorelPackage.BX_MOREL_RULE__WHEN:
				setWhen((Clause)null);
				return;
			case MorelPackage.BX_MOREL_RULE__MATCH:
				setMatch((Action)null);
				return;
			case MorelPackage.BX_MOREL_RULE__UNMATCH_SRC:
				setUnmatchSrc((Action)null);
				return;
			case MorelPackage.BX_MOREL_RULE__UNMATCH_VIEW:
				setUnmatchView((Action)null);
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
			case MorelPackage.BX_MOREL_RULE__SOURCE:
				return source != null;
			case MorelPackage.BX_MOREL_RULE__VIEW:
				return view != null;
			case MorelPackage.BX_MOREL_RULE__WHEN:
				return when != null;
			case MorelPackage.BX_MOREL_RULE__MATCH:
				return match != null;
			case MorelPackage.BX_MOREL_RULE__UNMATCH_SRC:
				return unmatchSrc != null;
			case MorelPackage.BX_MOREL_RULE__UNMATCH_VIEW:
				return unmatchView != null;
		}
		return super.eIsSet(featureID);
	}

} //BxMorelRuleImpl
