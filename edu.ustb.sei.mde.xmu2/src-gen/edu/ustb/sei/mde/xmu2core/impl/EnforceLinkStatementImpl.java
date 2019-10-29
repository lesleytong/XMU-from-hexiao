/**
 */
package edu.ustb.sei.mde.xmu2core.impl;

import edu.ustb.sei.mde.xmu2common.DomainElement;
import edu.ustb.sei.mde.xmu2common.DomainTag;
import edu.ustb.sei.mde.xmu2common.Xmu2commonPackage;

import edu.ustb.sei.mde.xmu2core.EnforceLinkStatement;
import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.LoopPath;
import edu.ustb.sei.mde.xmu2core.PositionPath;
import edu.ustb.sei.mde.xmu2core.ReflectiveSupport;
import edu.ustb.sei.mde.xmu2core.Variable;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enforce Link Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.EnforceLinkStatementImpl#getTag <em>Tag</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.EnforceLinkStatementImpl#getReflectiveIdentifier <em>Reflective Identifier</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.EnforceLinkStatementImpl#isReflective <em>Reflective</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.EnforceLinkStatementImpl#isResolve <em>Resolve</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.EnforceLinkStatementImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.EnforceLinkStatementImpl#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.EnforceLinkStatementImpl#getFeature <em>Feature</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.EnforceLinkStatementImpl#getSelector <em>Selector</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.EnforceLinkStatementImpl#getPosition <em>Position</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.EnforceLinkStatementImpl#getSourceType <em>Source Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnforceLinkStatementImpl extends StatementImpl implements EnforceLinkStatement {
	/**
	 * The default value of the '{@link #getTag() <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTag()
	 * @generated
	 * @ordered
	 */
	protected static final DomainTag TAG_EDEFAULT = DomainTag.NORMAL;

	/**
	 * The cached value of the '{@link #getTag() <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTag()
	 * @generated
	 * @ordered
	 */
	protected DomainTag tag = TAG_EDEFAULT;

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
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Expression target;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Variable source;

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
	 * The cached value of the '{@link #getSourceType() <em>Source Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceType()
	 * @generated
	 * @ordered
	 */
	protected EClassifier sourceType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnforceLinkStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2corePackage.Literals.ENFORCE_LINK_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainTag getTag() {
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTag(DomainTag newTag) {
		DomainTag oldTag = tag;
		tag = newTag == null ? TAG_EDEFAULT : newTag;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_LINK_STATEMENT__TAG, oldTag, tag));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER, oldReflectiveIdentifier, newReflectiveIdentifier);
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
				msgs = ((InternalEObject)reflectiveIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER, null, msgs);
			if (newReflectiveIdentifier != null)
				msgs = ((InternalEObject)newReflectiveIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER, null, msgs);
			msgs = basicSetReflectiveIdentifier(newReflectiveIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER, newReflectiveIdentifier, newReflectiveIdentifier));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE, oldReflective, reflective));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_LINK_STATEMENT__RESOLVE, oldResolve, resolve));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(Expression newTarget, NotificationChain msgs) {
		Expression oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_LINK_STATEMENT__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Expression newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.ENFORCE_LINK_STATEMENT__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.ENFORCE_LINK_STATEMENT__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_LINK_STATEMENT__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Variable)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xmu2corePackage.ENFORCE_LINK_STATEMENT__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Variable newSource) {
		Variable oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_LINK_STATEMENT__SOURCE, oldSource, source));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xmu2corePackage.ENFORCE_LINK_STATEMENT__FEATURE, oldFeature, feature));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_LINK_STATEMENT__FEATURE, oldFeature, feature));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_LINK_STATEMENT__SELECTOR, oldSelector, newSelector);
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
				msgs = ((InternalEObject)selector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.ENFORCE_LINK_STATEMENT__SELECTOR, null, msgs);
			if (newSelector != null)
				msgs = ((InternalEObject)newSelector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.ENFORCE_LINK_STATEMENT__SELECTOR, null, msgs);
			msgs = basicSetSelector(newSelector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_LINK_STATEMENT__SELECTOR, newSelector, newSelector));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_LINK_STATEMENT__POSITION, oldPosition, newPosition);
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
				msgs = ((InternalEObject)position).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.ENFORCE_LINK_STATEMENT__POSITION, null, msgs);
			if (newPosition != null)
				msgs = ((InternalEObject)newPosition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.ENFORCE_LINK_STATEMENT__POSITION, null, msgs);
			msgs = basicSetPosition(newPosition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_LINK_STATEMENT__POSITION, newPosition, newPosition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier getSourceType() {
		if (sourceType != null && sourceType.eIsProxy()) {
			InternalEObject oldSourceType = (InternalEObject)sourceType;
			sourceType = (EClassifier)eResolveProxy(oldSourceType);
			if (sourceType != oldSourceType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xmu2corePackage.ENFORCE_LINK_STATEMENT__SOURCE_TYPE, oldSourceType, sourceType));
			}
		}
		return sourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetSourceType() {
		return sourceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceType(EClassifier newSourceType) {
		EClassifier oldSourceType = sourceType;
		sourceType = newSourceType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.ENFORCE_LINK_STATEMENT__SOURCE_TYPE, oldSourceType, sourceType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER:
				return basicSetReflectiveIdentifier(null, msgs);
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__TARGET:
				return basicSetTarget(null, msgs);
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__SELECTOR:
				return basicSetSelector(null, msgs);
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__POSITION:
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
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__TAG:
				return getTag();
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER:
				return getReflectiveIdentifier();
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE:
				return isReflective();
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__RESOLVE:
				return isResolve();
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__TARGET:
				return getTarget();
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__SELECTOR:
				return getSelector();
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__POSITION:
				return getPosition();
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__SOURCE_TYPE:
				if (resolve) return getSourceType();
				return basicGetSourceType();
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
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__TAG:
				setTag((DomainTag)newValue);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER:
				setReflectiveIdentifier((Expression)newValue);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE:
				setReflective((Boolean)newValue);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__RESOLVE:
				setResolve((Boolean)newValue);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__TARGET:
				setTarget((Expression)newValue);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__SOURCE:
				setSource((Variable)newValue);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__FEATURE:
				setFeature((EStructuralFeature)newValue);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__SELECTOR:
				setSelector((LoopPath)newValue);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__POSITION:
				setPosition((PositionPath)newValue);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__SOURCE_TYPE:
				setSourceType((EClassifier)newValue);
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
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__TAG:
				setTag(TAG_EDEFAULT);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER:
				setReflectiveIdentifier((Expression)null);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE:
				setReflective(REFLECTIVE_EDEFAULT);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__RESOLVE:
				setResolve(RESOLVE_EDEFAULT);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__TARGET:
				setTarget((Expression)null);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__SOURCE:
				setSource((Variable)null);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__FEATURE:
				setFeature((EStructuralFeature)null);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__SELECTOR:
				setSelector((LoopPath)null);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__POSITION:
				setPosition((PositionPath)null);
				return;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__SOURCE_TYPE:
				setSourceType((EClassifier)null);
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
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__TAG:
				return tag != TAG_EDEFAULT;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER:
				return reflectiveIdentifier != null;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE:
				return reflective != REFLECTIVE_EDEFAULT;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__RESOLVE:
				return resolve != RESOLVE_EDEFAULT;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__TARGET:
				return target != null;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__SOURCE:
				return source != null;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__FEATURE:
				return feature != null;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__SELECTOR:
				return selector != null;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__POSITION:
				return position != null;
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT__SOURCE_TYPE:
				return sourceType != null;
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
		if (baseClass == DomainElement.class) {
			switch (derivedFeatureID) {
				case Xmu2corePackage.ENFORCE_LINK_STATEMENT__TAG: return Xmu2commonPackage.DOMAIN_ELEMENT__TAG;
				default: return -1;
			}
		}
		if (baseClass == ReflectiveSupport.class) {
			switch (derivedFeatureID) {
				case Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER: return Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER;
				case Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE: return Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE;
				case Xmu2corePackage.ENFORCE_LINK_STATEMENT__RESOLVE: return Xmu2corePackage.REFLECTIVE_SUPPORT__RESOLVE;
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
		if (baseClass == DomainElement.class) {
			switch (baseFeatureID) {
				case Xmu2commonPackage.DOMAIN_ELEMENT__TAG: return Xmu2corePackage.ENFORCE_LINK_STATEMENT__TAG;
				default: return -1;
			}
		}
		if (baseClass == ReflectiveSupport.class) {
			switch (baseFeatureID) {
				case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER: return Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER;
				case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE: return Xmu2corePackage.ENFORCE_LINK_STATEMENT__REFLECTIVE;
				case Xmu2corePackage.REFLECTIVE_SUPPORT__RESOLVE: return Xmu2corePackage.ENFORCE_LINK_STATEMENT__RESOLVE;
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
		result.append(" (tag: ");
		result.append(tag);
		result.append(", reflective: ");
		result.append(reflective);
		result.append(", resolve: ");
		result.append(resolve);
		result.append(')');
		return result.toString();
	}

} //EnforceLinkStatementImpl
