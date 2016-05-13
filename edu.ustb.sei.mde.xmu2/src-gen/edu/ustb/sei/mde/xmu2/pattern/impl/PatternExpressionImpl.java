/**
 */
package edu.ustb.sei.mde.xmu2.pattern.impl;

import edu.ustb.sei.mde.xmu2.expression.LoopPath;
import edu.ustb.sei.mde.xmu2.expression.PositionPath;

import edu.ustb.sei.mde.xmu2.pattern.PatternExpression;
import edu.ustb.sei.mde.xmu2.pattern.PatternNode;
import edu.ustb.sei.mde.xmu2.pattern.PatternPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.pattern.impl.PatternExpressionImpl#getOwnerNode <em>Owner Node</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.pattern.impl.PatternExpressionImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.pattern.impl.PatternExpressionImpl#getSelector <em>Selector</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.pattern.impl.PatternExpressionImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.pattern.impl.PatternExpressionImpl#isNullable <em>Nullable</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PatternExpressionImpl extends EObjectImpl implements PatternExpression {
	/**
	 * The cached value of the '{@link #getFeature() <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature feature;

	/**
	 * The cached value of the '{@link #getSelector() <em>Selector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelector()
	 * @generated
	 * @ordered
	 */
	protected LoopPath selector;

	/**
	 * The cached value of the '{@link #getPosition() <em>Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPosition()
	 * @generated
	 * @ordered
	 */
	protected PositionPath position;

	/**
	 * The default value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean NULLABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isNullable() <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isNullable()
	 * @generated
	 * @ordered
	 */
	protected boolean nullable = NULLABLE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PatternPackage.Literals.PATTERN_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternNode getOwnerNode() {
		if (eContainerFeatureID() != PatternPackage.PATTERN_EXPRESSION__OWNER_NODE) return null;
		return (PatternNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnerNode(PatternNode newOwnerNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwnerNode, PatternPackage.PATTERN_EXPRESSION__OWNER_NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwnerNode(PatternNode newOwnerNode) {
		if (newOwnerNode != eInternalContainer() || (eContainerFeatureID() != PatternPackage.PATTERN_EXPRESSION__OWNER_NODE && newOwnerNode != null)) {
			if (EcoreUtil.isAncestor(this, newOwnerNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwnerNode != null)
				msgs = ((InternalEObject)newOwnerNode).eInverseAdd(this, PatternPackage.PATTERN_NODE__EXPRESSIONS, PatternNode.class, msgs);
			msgs = basicSetOwnerNode(newOwnerNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN_EXPRESSION__OWNER_NODE, newOwnerNode, newOwnerNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getFeature() {
		if (feature != null && feature.eIsProxy()) {
			InternalEObject oldFeature = (InternalEObject)feature;
			feature = (EStructuralFeature)eResolveProxy(oldFeature);
			if (feature != oldFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PatternPackage.PATTERN_EXPRESSION__FEATURE, oldFeature, feature));
			}
		}
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetFeature() {
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeature(EStructuralFeature newFeature) {
		EStructuralFeature oldFeature = feature;
		feature = newFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN_EXPRESSION__FEATURE, oldFeature, feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopPath getSelector() {
		return selector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSelector(LoopPath newSelector, NotificationChain msgs) {
		LoopPath oldSelector = selector;
		selector = newSelector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN_EXPRESSION__SELECTOR, oldSelector, newSelector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelector(LoopPath newSelector) {
		if (newSelector != selector) {
			NotificationChain msgs = null;
			if (selector != null)
				msgs = ((InternalEObject)selector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PatternPackage.PATTERN_EXPRESSION__SELECTOR, null, msgs);
			if (newSelector != null)
				msgs = ((InternalEObject)newSelector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PatternPackage.PATTERN_EXPRESSION__SELECTOR, null, msgs);
			msgs = basicSetSelector(newSelector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN_EXPRESSION__SELECTOR, newSelector, newSelector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PositionPath getPosition() {
		return position;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPosition(PositionPath newPosition, NotificationChain msgs) {
		PositionPath oldPosition = position;
		position = newPosition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN_EXPRESSION__POSITION, oldPosition, newPosition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPosition(PositionPath newPosition) {
		if (newPosition != position) {
			NotificationChain msgs = null;
			if (position != null)
				msgs = ((InternalEObject)position).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PatternPackage.PATTERN_EXPRESSION__POSITION, null, msgs);
			if (newPosition != null)
				msgs = ((InternalEObject)newPosition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PatternPackage.PATTERN_EXPRESSION__POSITION, null, msgs);
			msgs = basicSetPosition(newPosition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN_EXPRESSION__POSITION, newPosition, newPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isNullable() {
		return nullable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNullable(boolean newNullable) {
		boolean oldNullable = nullable;
		nullable = newNullable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.PATTERN_EXPRESSION__NULLABLE, oldNullable, nullable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PatternPackage.PATTERN_EXPRESSION__OWNER_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwnerNode((PatternNode)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PatternPackage.PATTERN_EXPRESSION__OWNER_NODE:
				return basicSetOwnerNode(null, msgs);
			case PatternPackage.PATTERN_EXPRESSION__SELECTOR:
				return basicSetSelector(null, msgs);
			case PatternPackage.PATTERN_EXPRESSION__POSITION:
				return basicSetPosition(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case PatternPackage.PATTERN_EXPRESSION__OWNER_NODE:
				return eInternalContainer().eInverseRemove(this, PatternPackage.PATTERN_NODE__EXPRESSIONS, PatternNode.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PatternPackage.PATTERN_EXPRESSION__OWNER_NODE:
				return getOwnerNode();
			case PatternPackage.PATTERN_EXPRESSION__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
			case PatternPackage.PATTERN_EXPRESSION__SELECTOR:
				return getSelector();
			case PatternPackage.PATTERN_EXPRESSION__POSITION:
				return getPosition();
			case PatternPackage.PATTERN_EXPRESSION__NULLABLE:
				return isNullable();
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
			case PatternPackage.PATTERN_EXPRESSION__OWNER_NODE:
				setOwnerNode((PatternNode)newValue);
				return;
			case PatternPackage.PATTERN_EXPRESSION__FEATURE:
				setFeature((EStructuralFeature)newValue);
				return;
			case PatternPackage.PATTERN_EXPRESSION__SELECTOR:
				setSelector((LoopPath)newValue);
				return;
			case PatternPackage.PATTERN_EXPRESSION__POSITION:
				setPosition((PositionPath)newValue);
				return;
			case PatternPackage.PATTERN_EXPRESSION__NULLABLE:
				setNullable((Boolean)newValue);
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
			case PatternPackage.PATTERN_EXPRESSION__OWNER_NODE:
				setOwnerNode((PatternNode)null);
				return;
			case PatternPackage.PATTERN_EXPRESSION__FEATURE:
				setFeature((EStructuralFeature)null);
				return;
			case PatternPackage.PATTERN_EXPRESSION__SELECTOR:
				setSelector((LoopPath)null);
				return;
			case PatternPackage.PATTERN_EXPRESSION__POSITION:
				setPosition((PositionPath)null);
				return;
			case PatternPackage.PATTERN_EXPRESSION__NULLABLE:
				setNullable(NULLABLE_EDEFAULT);
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
			case PatternPackage.PATTERN_EXPRESSION__OWNER_NODE:
				return getOwnerNode() != null;
			case PatternPackage.PATTERN_EXPRESSION__FEATURE:
				return feature != null;
			case PatternPackage.PATTERN_EXPRESSION__SELECTOR:
				return selector != null;
			case PatternPackage.PATTERN_EXPRESSION__POSITION:
				return position != null;
			case PatternPackage.PATTERN_EXPRESSION__NULLABLE:
				return nullable != NULLABLE_EDEFAULT;
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
		result.append(" (nullable: ");
		result.append(nullable);
		result.append(')');
		return result.toString();
	}

} //PatternExpressionImpl
