/**
 */
package edu.ustb.sei.mde.xmu2core.impl;

import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.LoopPath;
import edu.ustb.sei.mde.xmu2core.PatternExpression;
import edu.ustb.sei.mde.xmu2core.PositionPath;
import edu.ustb.sei.mde.xmu2core.ReflectiveSupport;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.PatternExpressionImpl#getReflectiveIdentifier <em>Reflective Identifier</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.PatternExpressionImpl#isReflective <em>Reflective</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.PatternExpressionImpl#isResolve <em>Resolve</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.PatternExpressionImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.PatternExpressionImpl#getSelector <em>Selector</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.PatternExpressionImpl#getPosition <em>Position</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PatternExpressionImpl extends NullableImpl implements PatternExpression {
	/**
	 * The cached value of the '{@link #getReflectiveIdentifier() <em>Reflective Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReflectiveIdentifier()
	 * @generated
	 * @ordered
	 */
	protected Expression reflectiveIdentifier;

	/**
	 * The default value of the '{@link #isReflective() <em>Reflective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReflective()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REFLECTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReflective() <em>Reflective</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReflective()
	 * @generated
	 * @ordered
	 */
	protected boolean reflective = REFLECTIVE_EDEFAULT;

	/**
	 * The default value of the '{@link #isResolve() <em>Resolve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolve()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESOLVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isResolve() <em>Resolve</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isResolve()
	 * @generated
	 * @ordered
	 */
	protected boolean resolve = RESOLVE_EDEFAULT;

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
		return Xmu2corePackage.Literals.PATTERN_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getReflectiveIdentifier() {
		return reflectiveIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReflectiveIdentifier(Expression newReflectiveIdentifier, NotificationChain msgs) {
		Expression oldReflectiveIdentifier = reflectiveIdentifier;
		reflectiveIdentifier = newReflectiveIdentifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER, oldReflectiveIdentifier, newReflectiveIdentifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReflectiveIdentifier(Expression newReflectiveIdentifier) {
		if (newReflectiveIdentifier != reflectiveIdentifier) {
			NotificationChain msgs = null;
			if (reflectiveIdentifier != null)
				msgs = ((InternalEObject)reflectiveIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER, null, msgs);
			if (newReflectiveIdentifier != null)
				msgs = ((InternalEObject)newReflectiveIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER, null, msgs);
			msgs = basicSetReflectiveIdentifier(newReflectiveIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER, newReflectiveIdentifier, newReflectiveIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReflective() {
		return reflective;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReflective(boolean newReflective) {
		boolean oldReflective = reflective;
		reflective = newReflective;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE, oldReflective, reflective));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isResolve() {
		return resolve;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolve(boolean newResolve) {
		boolean oldResolve = resolve;
		resolve = newResolve;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.PATTERN_EXPRESSION__RESOLVE, oldResolve, resolve));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xmu2corePackage.PATTERN_EXPRESSION__FEATURE, oldFeature, feature));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.PATTERN_EXPRESSION__FEATURE, oldFeature, feature));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR, oldSelector, newSelector);
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
				msgs = ((InternalEObject)selector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR, null, msgs);
			if (newSelector != null)
				msgs = ((InternalEObject)newSelector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR, null, msgs);
			msgs = basicSetSelector(newSelector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR, newSelector, newSelector));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2corePackage.PATTERN_EXPRESSION__POSITION, oldPosition, newPosition);
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
				msgs = ((InternalEObject)position).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.PATTERN_EXPRESSION__POSITION, null, msgs);
			if (newPosition != null)
				msgs = ((InternalEObject)newPosition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.PATTERN_EXPRESSION__POSITION, null, msgs);
			msgs = basicSetPosition(newPosition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.PATTERN_EXPRESSION__POSITION, newPosition, newPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER:
				return basicSetReflectiveIdentifier(null, msgs);
			case Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR:
				return basicSetSelector(null, msgs);
			case Xmu2corePackage.PATTERN_EXPRESSION__POSITION:
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER:
				return getReflectiveIdentifier();
			case Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE:
				return isReflective();
			case Xmu2corePackage.PATTERN_EXPRESSION__RESOLVE:
				return isResolve();
			case Xmu2corePackage.PATTERN_EXPRESSION__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
			case Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR:
				return getSelector();
			case Xmu2corePackage.PATTERN_EXPRESSION__POSITION:
				return getPosition();
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
			case Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER:
				setReflectiveIdentifier((Expression)newValue);
				return;
			case Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE:
				setReflective((Boolean)newValue);
				return;
			case Xmu2corePackage.PATTERN_EXPRESSION__RESOLVE:
				setResolve((Boolean)newValue);
				return;
			case Xmu2corePackage.PATTERN_EXPRESSION__FEATURE:
				setFeature((EStructuralFeature)newValue);
				return;
			case Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR:
				setSelector((LoopPath)newValue);
				return;
			case Xmu2corePackage.PATTERN_EXPRESSION__POSITION:
				setPosition((PositionPath)newValue);
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
			case Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER:
				setReflectiveIdentifier((Expression)null);
				return;
			case Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE:
				setReflective(REFLECTIVE_EDEFAULT);
				return;
			case Xmu2corePackage.PATTERN_EXPRESSION__RESOLVE:
				setResolve(RESOLVE_EDEFAULT);
				return;
			case Xmu2corePackage.PATTERN_EXPRESSION__FEATURE:
				setFeature((EStructuralFeature)null);
				return;
			case Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR:
				setSelector((LoopPath)null);
				return;
			case Xmu2corePackage.PATTERN_EXPRESSION__POSITION:
				setPosition((PositionPath)null);
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
			case Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER:
				return reflectiveIdentifier != null;
			case Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE:
				return reflective != REFLECTIVE_EDEFAULT;
			case Xmu2corePackage.PATTERN_EXPRESSION__RESOLVE:
				return resolve != RESOLVE_EDEFAULT;
			case Xmu2corePackage.PATTERN_EXPRESSION__FEATURE:
				return feature != null;
			case Xmu2corePackage.PATTERN_EXPRESSION__SELECTOR:
				return selector != null;
			case Xmu2corePackage.PATTERN_EXPRESSION__POSITION:
				return position != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ReflectiveSupport.class) {
			switch (derivedFeatureID) {
				case Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER: return Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER;
				case Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE: return Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE;
				case Xmu2corePackage.PATTERN_EXPRESSION__RESOLVE: return Xmu2corePackage.REFLECTIVE_SUPPORT__RESOLVE;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ReflectiveSupport.class) {
			switch (baseFeatureID) {
				case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER: return Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE_IDENTIFIER;
				case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE: return Xmu2corePackage.PATTERN_EXPRESSION__REFLECTIVE;
				case Xmu2corePackage.REFLECTIVE_SUPPORT__RESOLVE: return Xmu2corePackage.PATTERN_EXPRESSION__RESOLVE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (reflective: ");
		result.append(reflective);
		result.append(", resolve: ");
		result.append(resolve);
		result.append(')');
		return result.toString();
	}

} //PatternExpressionImpl
