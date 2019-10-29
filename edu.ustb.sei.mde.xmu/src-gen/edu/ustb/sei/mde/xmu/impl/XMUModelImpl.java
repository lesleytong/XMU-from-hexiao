/**
 */
package edu.ustb.sei.mde.xmu.impl;

import edu.ustb.sei.mde.xmu.HelperMapping;
import edu.ustb.sei.mde.xmu.InitialMappingStatement;
import edu.ustb.sei.mde.xmu.Rule;
import edu.ustb.sei.mde.xmu.StartStatement;
import edu.ustb.sei.mde.xmu.XMUModel;
import edu.ustb.sei.mde.xmu.XmuPackage;
import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>XMU Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.XMUModelImpl#getInitialMappings <em>Initial Mappings</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.XMUModelImpl#getHelperMappings <em>Helper Mappings</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.XMUModelImpl#getRules <em>Rules</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.XMUModelImpl#getPackages <em>Packages</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.XMUModelImpl#getStart <em>Start</em>}</li>
 * </ul>
 *
 * @generated
 */
public class XMUModelImpl extends MinimalEObjectImpl.Container implements XMUModel {
	/**
	 * The cached value of the '{@link #getInitialMappings() <em>Initial Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<InitialMappingStatement> initialMappings;

	/**
	 * The cached value of the '{@link #getHelperMappings() <em>Helper Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelperMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<HelperMapping> helperMappings;

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
	 * The cached value of the '{@link #getPackages() <em>Packages</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackages()
	 * @generated
	 * @ordered
	 */
	protected EList<EPackage> packages;

	/**
	 * The cached value of the '{@link #getStart() <em>Start</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected EList<StartStatement> start;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected XMUModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmuPackage.Literals.XMU_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<InitialMappingStatement> getInitialMappings() {
		if (initialMappings == null) {
			initialMappings = new EObjectContainmentEList<InitialMappingStatement>(InitialMappingStatement.class, this, XmuPackage.XMU_MODEL__INITIAL_MAPPINGS);
		}
		return initialMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HelperMapping> getHelperMappings() {
		if (helperMappings == null) {
			helperMappings = new EObjectContainmentEList<HelperMapping>(HelperMapping.class, this, XmuPackage.XMU_MODEL__HELPER_MAPPINGS);
		}
		return helperMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Rule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<Rule>(Rule.class, this, XmuPackage.XMU_MODEL__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPackage> getPackages() {
		if (packages == null) {
			packages = new EObjectResolvingEList<EPackage>(EPackage.class, this, XmuPackage.XMU_MODEL__PACKAGES);
		}
		return packages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StartStatement> getStart() {
		if (start == null) {
			start = new EObjectContainmentEList<StartStatement>(StartStatement.class, this, XmuPackage.XMU_MODEL__START);
		}
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XmuPackage.XMU_MODEL__INITIAL_MAPPINGS:
				return ((InternalEList<?>)getInitialMappings()).basicRemove(otherEnd, msgs);
			case XmuPackage.XMU_MODEL__HELPER_MAPPINGS:
				return ((InternalEList<?>)getHelperMappings()).basicRemove(otherEnd, msgs);
			case XmuPackage.XMU_MODEL__RULES:
				return ((InternalEList<?>)getRules()).basicRemove(otherEnd, msgs);
			case XmuPackage.XMU_MODEL__START:
				return ((InternalEList<?>)getStart()).basicRemove(otherEnd, msgs);
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
			case XmuPackage.XMU_MODEL__INITIAL_MAPPINGS:
				return getInitialMappings();
			case XmuPackage.XMU_MODEL__HELPER_MAPPINGS:
				return getHelperMappings();
			case XmuPackage.XMU_MODEL__RULES:
				return getRules();
			case XmuPackage.XMU_MODEL__PACKAGES:
				return getPackages();
			case XmuPackage.XMU_MODEL__START:
				return getStart();
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
			case XmuPackage.XMU_MODEL__INITIAL_MAPPINGS:
				getInitialMappings().clear();
				getInitialMappings().addAll((Collection<? extends InitialMappingStatement>)newValue);
				return;
			case XmuPackage.XMU_MODEL__HELPER_MAPPINGS:
				getHelperMappings().clear();
				getHelperMappings().addAll((Collection<? extends HelperMapping>)newValue);
				return;
			case XmuPackage.XMU_MODEL__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends Rule>)newValue);
				return;
			case XmuPackage.XMU_MODEL__PACKAGES:
				getPackages().clear();
				getPackages().addAll((Collection<? extends EPackage>)newValue);
				return;
			case XmuPackage.XMU_MODEL__START:
				getStart().clear();
				getStart().addAll((Collection<? extends StartStatement>)newValue);
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
			case XmuPackage.XMU_MODEL__INITIAL_MAPPINGS:
				getInitialMappings().clear();
				return;
			case XmuPackage.XMU_MODEL__HELPER_MAPPINGS:
				getHelperMappings().clear();
				return;
			case XmuPackage.XMU_MODEL__RULES:
				getRules().clear();
				return;
			case XmuPackage.XMU_MODEL__PACKAGES:
				getPackages().clear();
				return;
			case XmuPackage.XMU_MODEL__START:
				getStart().clear();
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
			case XmuPackage.XMU_MODEL__INITIAL_MAPPINGS:
				return initialMappings != null && !initialMappings.isEmpty();
			case XmuPackage.XMU_MODEL__HELPER_MAPPINGS:
				return helperMappings != null && !helperMappings.isEmpty();
			case XmuPackage.XMU_MODEL__RULES:
				return rules != null && !rules.isEmpty();
			case XmuPackage.XMU_MODEL__PACKAGES:
				return packages != null && !packages.isEmpty();
			case XmuPackage.XMU_MODEL__START:
				return start != null && !start.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //XMUModelImpl
