/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.IterationType;
import edu.ustb.sei.mde.morel.MorelPackage;
import edu.ustb.sei.mde.morel.OrderType;
import edu.ustb.sei.mde.morel.RepetitionType;
import edu.ustb.sei.mde.morel.Rule;
import edu.ustb.sei.mde.morel.RuleGroup;
import edu.ustb.sei.mde.morel.ScopeType;
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
 * An implementation of the model object '<em><b>Rule Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.RuleGroupImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.RuleGroupImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.RuleGroupImpl#getScopeSize <em>Scope Size</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.RuleGroupImpl#getOrder <em>Order</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.RuleGroupImpl#getIteration <em>Iteration</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.RuleGroupImpl#getMaxIteration <em>Max Iteration</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.RuleGroupImpl#getRepetition <em>Repetition</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleGroupImpl extends RuleElementImpl implements RuleGroup {
	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<Rule> rules;

	/**
	 * The default value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected static final ScopeType SCOPE_EDEFAULT = ScopeType.ALL;

	/**
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected ScopeType scope = SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getScopeSize() <em>Scope Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopeSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SCOPE_SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getScopeSize() <em>Scope Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScopeSize()
	 * @generated
	 * @ordered
	 */
	protected int scopeSize = SCOPE_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected static final OrderType ORDER_EDEFAULT = OrderType.DEFAULT;

	/**
	 * The cached value of the '{@link #getOrder() <em>Order</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrder()
	 * @generated
	 * @ordered
	 */
	protected OrderType order = ORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getIteration() <em>Iteration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIteration()
	 * @generated
	 * @ordered
	 */
	protected static final IterationType ITERATION_EDEFAULT = IterationType.DEFAULT;

	/**
	 * The cached value of the '{@link #getIteration() <em>Iteration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIteration()
	 * @generated
	 * @ordered
	 */
	protected IterationType iteration = ITERATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxIteration() <em>Max Iteration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxIteration()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_ITERATION_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxIteration() <em>Max Iteration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxIteration()
	 * @generated
	 * @ordered
	 */
	protected int maxIteration = MAX_ITERATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getRepetition() <em>Repetition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepetition()
	 * @generated
	 * @ordered
	 */
	protected static final RepetitionType REPETITION_EDEFAULT = RepetitionType.ALL_MATCHES;

	/**
	 * The cached value of the '{@link #getRepetition() <em>Repetition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepetition()
	 * @generated
	 * @ordered
	 */
	protected RepetitionType repetition = REPETITION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorelPackage.Literals.RULE_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<Rule>(Rule.class, this, MorelPackage.RULE_GROUP__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScopeType getScope() {
		return scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScope(ScopeType newScope) {
		ScopeType oldScope = scope;
		scope = newScope == null ? SCOPE_EDEFAULT : newScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.RULE_GROUP__SCOPE, oldScope, scope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getScopeSize() {
		return scopeSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScopeSize(int newScopeSize) {
		int oldScopeSize = scopeSize;
		scopeSize = newScopeSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.RULE_GROUP__SCOPE_SIZE, oldScopeSize, scopeSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderType getOrder() {
		return order;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrder(OrderType newOrder) {
		OrderType oldOrder = order;
		order = newOrder == null ? ORDER_EDEFAULT : newOrder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.RULE_GROUP__ORDER, oldOrder, order));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterationType getIteration() {
		return iteration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIteration(IterationType newIteration) {
		IterationType oldIteration = iteration;
		iteration = newIteration == null ? ITERATION_EDEFAULT : newIteration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.RULE_GROUP__ITERATION, oldIteration, iteration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxIteration() {
		return maxIteration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxIteration(int newMaxIteration) {
		int oldMaxIteration = maxIteration;
		maxIteration = newMaxIteration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.RULE_GROUP__MAX_ITERATION, oldMaxIteration, maxIteration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepetitionType getRepetition() {
		return repetition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepetition(RepetitionType newRepetition) {
		RepetitionType oldRepetition = repetition;
		repetition = newRepetition == null ? REPETITION_EDEFAULT : newRepetition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.RULE_GROUP__REPETITION, oldRepetition, repetition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MorelPackage.RULE_GROUP__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
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
			case MorelPackage.RULE_GROUP__RULES:
				return getRules();
			case MorelPackage.RULE_GROUP__SCOPE:
				return getScope();
			case MorelPackage.RULE_GROUP__SCOPE_SIZE:
				return getScopeSize();
			case MorelPackage.RULE_GROUP__ORDER:
				return getOrder();
			case MorelPackage.RULE_GROUP__ITERATION:
				return getIteration();
			case MorelPackage.RULE_GROUP__MAX_ITERATION:
				return getMaxIteration();
			case MorelPackage.RULE_GROUP__REPETITION:
				return getRepetition();
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
			case MorelPackage.RULE_GROUP__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends Rule>)newValue);
				return;
			case MorelPackage.RULE_GROUP__SCOPE:
				setScope((ScopeType)newValue);
				return;
			case MorelPackage.RULE_GROUP__SCOPE_SIZE:
				setScopeSize((Integer)newValue);
				return;
			case MorelPackage.RULE_GROUP__ORDER:
				setOrder((OrderType)newValue);
				return;
			case MorelPackage.RULE_GROUP__ITERATION:
				setIteration((IterationType)newValue);
				return;
			case MorelPackage.RULE_GROUP__MAX_ITERATION:
				setMaxIteration((Integer)newValue);
				return;
			case MorelPackage.RULE_GROUP__REPETITION:
				setRepetition((RepetitionType)newValue);
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
			case MorelPackage.RULE_GROUP__RULES:
				getRules().clear();
				return;
			case MorelPackage.RULE_GROUP__SCOPE:
				setScope(SCOPE_EDEFAULT);
				return;
			case MorelPackage.RULE_GROUP__SCOPE_SIZE:
				setScopeSize(SCOPE_SIZE_EDEFAULT);
				return;
			case MorelPackage.RULE_GROUP__ORDER:
				setOrder(ORDER_EDEFAULT);
				return;
			case MorelPackage.RULE_GROUP__ITERATION:
				setIteration(ITERATION_EDEFAULT);
				return;
			case MorelPackage.RULE_GROUP__MAX_ITERATION:
				setMaxIteration(MAX_ITERATION_EDEFAULT);
				return;
			case MorelPackage.RULE_GROUP__REPETITION:
				setRepetition(REPETITION_EDEFAULT);
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
			case MorelPackage.RULE_GROUP__RULES:
				return rules != null && !rules.isEmpty();
			case MorelPackage.RULE_GROUP__SCOPE:
				return scope != SCOPE_EDEFAULT;
			case MorelPackage.RULE_GROUP__SCOPE_SIZE:
				return scopeSize != SCOPE_SIZE_EDEFAULT;
			case MorelPackage.RULE_GROUP__ORDER:
				return order != ORDER_EDEFAULT;
			case MorelPackage.RULE_GROUP__ITERATION:
				return iteration != ITERATION_EDEFAULT;
			case MorelPackage.RULE_GROUP__MAX_ITERATION:
				return maxIteration != MAX_ITERATION_EDEFAULT;
			case MorelPackage.RULE_GROUP__REPETITION:
				return repetition != REPETITION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (scope: ");
		result.append(scope);
		result.append(", scopeSize: ");
		result.append(scopeSize);
		result.append(", order: ");
		result.append(order);
		result.append(", iteration: ");
		result.append(iteration);
		result.append(", maxIteration: ");
		result.append(maxIteration);
		result.append(", repetition: ");
		result.append(repetition);
		result.append(')');
		return result.toString();
	}

} //RuleGroupImpl
