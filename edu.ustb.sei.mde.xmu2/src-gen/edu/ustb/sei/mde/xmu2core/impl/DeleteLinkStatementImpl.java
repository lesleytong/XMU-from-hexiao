/**
 */
package edu.ustb.sei.mde.xmu2core.impl;

import edu.ustb.sei.mde.xmu2core.DeleteLinkStatement;
import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.ReflectiveSupport;
import edu.ustb.sei.mde.xmu2core.Variable;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delete Link Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.DeleteLinkStatementImpl#getReflectiveIdentifier <em>Reflective Identifier</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.DeleteLinkStatementImpl#isReflective <em>Reflective</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.DeleteLinkStatementImpl#isResolve <em>Resolve</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.DeleteLinkStatementImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.DeleteLinkStatementImpl#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.DeleteLinkStatementImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeleteLinkStatementImpl extends StatementImpl implements DeleteLinkStatement {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeleteLinkStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2corePackage.Literals.DELETE_LINK_STATEMENT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER, oldReflectiveIdentifier, newReflectiveIdentifier);
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
				msgs = ((InternalEObject)reflectiveIdentifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER, null, msgs);
			if (newReflectiveIdentifier != null)
				msgs = ((InternalEObject)newReflectiveIdentifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER, null, msgs);
			msgs = basicSetReflectiveIdentifier(newReflectiveIdentifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER, newReflectiveIdentifier, newReflectiveIdentifier));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE, oldReflective, reflective));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.DELETE_LINK_STATEMENT__RESOLVE, oldResolve, resolve));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Xmu2corePackage.DELETE_LINK_STATEMENT__TARGET, oldTarget, newTarget);
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
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.DELETE_LINK_STATEMENT__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Xmu2corePackage.DELETE_LINK_STATEMENT__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.DELETE_LINK_STATEMENT__TARGET, newTarget, newTarget));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xmu2corePackage.DELETE_LINK_STATEMENT__SOURCE, oldSource, source));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.DELETE_LINK_STATEMENT__SOURCE, oldSource, source));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Xmu2corePackage.DELETE_LINK_STATEMENT__FEATURE, oldFeature, feature));
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
			eNotify(new ENotificationImpl(this, Notification.SET, Xmu2corePackage.DELETE_LINK_STATEMENT__FEATURE, oldFeature, feature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER:
				return basicSetReflectiveIdentifier(null, msgs);
			case Xmu2corePackage.DELETE_LINK_STATEMENT__TARGET:
				return basicSetTarget(null, msgs);
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
			case Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER:
				return getReflectiveIdentifier();
			case Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE:
				return isReflective();
			case Xmu2corePackage.DELETE_LINK_STATEMENT__RESOLVE:
				return isResolve();
			case Xmu2corePackage.DELETE_LINK_STATEMENT__TARGET:
				return getTarget();
			case Xmu2corePackage.DELETE_LINK_STATEMENT__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case Xmu2corePackage.DELETE_LINK_STATEMENT__FEATURE:
				if (resolve) return getFeature();
				return basicGetFeature();
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
			case Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER:
				setReflectiveIdentifier((Expression)newValue);
				return;
			case Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE:
				setReflective((Boolean)newValue);
				return;
			case Xmu2corePackage.DELETE_LINK_STATEMENT__RESOLVE:
				setResolve((Boolean)newValue);
				return;
			case Xmu2corePackage.DELETE_LINK_STATEMENT__TARGET:
				setTarget((Expression)newValue);
				return;
			case Xmu2corePackage.DELETE_LINK_STATEMENT__SOURCE:
				setSource((Variable)newValue);
				return;
			case Xmu2corePackage.DELETE_LINK_STATEMENT__FEATURE:
				setFeature((EStructuralFeature)newValue);
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
			case Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER:
				setReflectiveIdentifier((Expression)null);
				return;
			case Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE:
				setReflective(REFLECTIVE_EDEFAULT);
				return;
			case Xmu2corePackage.DELETE_LINK_STATEMENT__RESOLVE:
				setResolve(RESOLVE_EDEFAULT);
				return;
			case Xmu2corePackage.DELETE_LINK_STATEMENT__TARGET:
				setTarget((Expression)null);
				return;
			case Xmu2corePackage.DELETE_LINK_STATEMENT__SOURCE:
				setSource((Variable)null);
				return;
			case Xmu2corePackage.DELETE_LINK_STATEMENT__FEATURE:
				setFeature((EStructuralFeature)null);
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
			case Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER:
				return reflectiveIdentifier != null;
			case Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE:
				return reflective != REFLECTIVE_EDEFAULT;
			case Xmu2corePackage.DELETE_LINK_STATEMENT__RESOLVE:
				return resolve != RESOLVE_EDEFAULT;
			case Xmu2corePackage.DELETE_LINK_STATEMENT__TARGET:
				return target != null;
			case Xmu2corePackage.DELETE_LINK_STATEMENT__SOURCE:
				return source != null;
			case Xmu2corePackage.DELETE_LINK_STATEMENT__FEATURE:
				return feature != null;
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
				case Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER: return Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER;
				case Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE: return Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE;
				case Xmu2corePackage.DELETE_LINK_STATEMENT__RESOLVE: return Xmu2corePackage.REFLECTIVE_SUPPORT__RESOLVE;
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
				case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER: return Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE_IDENTIFIER;
				case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE: return Xmu2corePackage.DELETE_LINK_STATEMENT__REFLECTIVE;
				case Xmu2corePackage.REFLECTIVE_SUPPORT__RESOLVE: return Xmu2corePackage.DELETE_LINK_STATEMENT__RESOLVE;
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

} //DeleteLinkStatementImpl
