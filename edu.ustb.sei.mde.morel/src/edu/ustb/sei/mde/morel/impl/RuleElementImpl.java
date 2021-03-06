/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.Executable;
import edu.ustb.sei.mde.morel.MorelPackage;
import edu.ustb.sei.mde.morel.PrimitiveVariable;
import edu.ustb.sei.mde.morel.RuleElement;
import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.RuleElementImpl#isActive <em>Active</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.RuleElementImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.impl.RuleElementImpl#getPrimitiveVariables <em>Primitive Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RuleElementImpl extends NamedElementImpl implements RuleElement {
	/**
	 * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ACTIVE_EDEFAULT = true;
	/**
	 * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isActive()
	 * @generated
	 * @ordered
	 */
	protected boolean active = ACTIVE_EDEFAULT;
	/**
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<String> parameters;

	/**
	 * The cached value of the '{@link #getPrimitiveVariables() <em>Primitive Variables</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitiveVariables()
	 * @generated
	 * @ordered
	 */
	protected EList<PrimitiveVariable> primitiveVariables;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RuleElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MorelPackage.Literals.RULE_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setActive(boolean newActive) {
		boolean oldActive = active;
		active = newActive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MorelPackage.RULE_ELEMENT__ACTIVE, oldActive, active));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getParameters() {
		if (parameters == null) {
			parameters = new EDataTypeUniqueEList<String>(String.class, this, MorelPackage.RULE_ELEMENT__PARAMETERS);
		}
		return parameters;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PrimitiveVariable> getPrimitiveVariables() {
		if (primitiveVariables == null) {
			primitiveVariables = new EObjectContainmentEList<PrimitiveVariable>(PrimitiveVariable.class, this, MorelPackage.RULE_ELEMENT__PRIMITIVE_VARIABLES);
		}
		return primitiveVariables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MorelPackage.RULE_ELEMENT__PRIMITIVE_VARIABLES:
				return ((InternalEList<?>)getPrimitiveVariables()).basicRemove(otherEnd, msgs);
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
			case MorelPackage.RULE_ELEMENT__ACTIVE:
				return isActive();
			case MorelPackage.RULE_ELEMENT__PARAMETERS:
				return getParameters();
			case MorelPackage.RULE_ELEMENT__PRIMITIVE_VARIABLES:
				return getPrimitiveVariables();
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
			case MorelPackage.RULE_ELEMENT__ACTIVE:
				setActive((Boolean)newValue);
				return;
			case MorelPackage.RULE_ELEMENT__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends String>)newValue);
				return;
			case MorelPackage.RULE_ELEMENT__PRIMITIVE_VARIABLES:
				getPrimitiveVariables().clear();
				getPrimitiveVariables().addAll((Collection<? extends PrimitiveVariable>)newValue);
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
			case MorelPackage.RULE_ELEMENT__ACTIVE:
				setActive(ACTIVE_EDEFAULT);
				return;
			case MorelPackage.RULE_ELEMENT__PARAMETERS:
				getParameters().clear();
				return;
			case MorelPackage.RULE_ELEMENT__PRIMITIVE_VARIABLES:
				getPrimitiveVariables().clear();
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
			case MorelPackage.RULE_ELEMENT__ACTIVE:
				return active != ACTIVE_EDEFAULT;
			case MorelPackage.RULE_ELEMENT__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
			case MorelPackage.RULE_ELEMENT__PRIMITIVE_VARIABLES:
				return primitiveVariables != null && !primitiveVariables.isEmpty();
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
		if (baseClass == Executable.class) {
			switch (derivedFeatureID) {
				case MorelPackage.RULE_ELEMENT__ACTIVE: return MorelPackage.EXECUTABLE__ACTIVE;
				case MorelPackage.RULE_ELEMENT__PARAMETERS: return MorelPackage.EXECUTABLE__PARAMETERS;
				case MorelPackage.RULE_ELEMENT__PRIMITIVE_VARIABLES: return MorelPackage.EXECUTABLE__PRIMITIVE_VARIABLES;
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
		if (baseClass == Executable.class) {
			switch (baseFeatureID) {
				case MorelPackage.EXECUTABLE__ACTIVE: return MorelPackage.RULE_ELEMENT__ACTIVE;
				case MorelPackage.EXECUTABLE__PARAMETERS: return MorelPackage.RULE_ELEMENT__PARAMETERS;
				case MorelPackage.EXECUTABLE__PRIMITIVE_VARIABLES: return MorelPackage.RULE_ELEMENT__PRIMITIVE_VARIABLES;
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
		result.append(" (active: ");
		result.append(active);
		result.append(", parameters: ");
		result.append(parameters);
		result.append(')');
		return result.toString();
	}

} //RuleElementImpl
