/**
 */
package edu.ustb.sei.mde.xmu2.impl;

import edu.ustb.sei.mde.xmu2.AbstractRule;
import edu.ustb.sei.mde.xmu2.EntryPoint;
import edu.ustb.sei.mde.xmu2.TransformationModel;
import edu.ustb.sei.mde.xmu2.Xmu2Package;

import edu.ustb.sei.mde.xmu2common.impl.NamedElementImpl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.impl.TransformationModelImpl#getPackages <em>Packages</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.impl.TransformationModelImpl#getEntryPoints <em>Entry Points</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.impl.TransformationModelImpl#getRules <em>Rules</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransformationModelImpl extends NamedElementImpl implements TransformationModel {
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
	 * The cached value of the '{@link #getEntryPoints() <em>Entry Points</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<EntryPoint> entryPoints;

	/**
	 * The cached value of the '{@link #getRules() <em>Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRules()
	 * @generated
	 * @ordered
	 */
	protected EList<AbstractRule> rules;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2Package.Literals.TRANSFORMATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPackage> getPackages() {
		if (packages == null) {
			packages = new EObjectResolvingEList<EPackage>(EPackage.class, this, Xmu2Package.TRANSFORMATION_MODEL__PACKAGES);
		}
		return packages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EntryPoint> getEntryPoints() {
		if (entryPoints == null) {
			entryPoints = new EObjectContainmentEList<EntryPoint>(EntryPoint.class, this, Xmu2Package.TRANSFORMATION_MODEL__ENTRY_POINTS);
		}
		return entryPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AbstractRule> getRules() {
		if (rules == null) {
			rules = new EObjectContainmentEList<AbstractRule>(AbstractRule.class, this, Xmu2Package.TRANSFORMATION_MODEL__RULES);
		}
		return rules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Xmu2Package.TRANSFORMATION_MODEL__ENTRY_POINTS:
				return ((InternalEList<?>)getEntryPoints()).basicRemove(otherEnd, msgs);
			case Xmu2Package.TRANSFORMATION_MODEL__RULES:
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
			case Xmu2Package.TRANSFORMATION_MODEL__PACKAGES:
				return getPackages();
			case Xmu2Package.TRANSFORMATION_MODEL__ENTRY_POINTS:
				return getEntryPoints();
			case Xmu2Package.TRANSFORMATION_MODEL__RULES:
				return getRules();
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
			case Xmu2Package.TRANSFORMATION_MODEL__PACKAGES:
				getPackages().clear();
				getPackages().addAll((Collection<? extends EPackage>)newValue);
				return;
			case Xmu2Package.TRANSFORMATION_MODEL__ENTRY_POINTS:
				getEntryPoints().clear();
				getEntryPoints().addAll((Collection<? extends EntryPoint>)newValue);
				return;
			case Xmu2Package.TRANSFORMATION_MODEL__RULES:
				getRules().clear();
				getRules().addAll((Collection<? extends AbstractRule>)newValue);
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
			case Xmu2Package.TRANSFORMATION_MODEL__PACKAGES:
				getPackages().clear();
				return;
			case Xmu2Package.TRANSFORMATION_MODEL__ENTRY_POINTS:
				getEntryPoints().clear();
				return;
			case Xmu2Package.TRANSFORMATION_MODEL__RULES:
				getRules().clear();
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
			case Xmu2Package.TRANSFORMATION_MODEL__PACKAGES:
				return packages != null && !packages.isEmpty();
			case Xmu2Package.TRANSFORMATION_MODEL__ENTRY_POINTS:
				return entryPoints != null && !entryPoints.isEmpty();
			case Xmu2Package.TRANSFORMATION_MODEL__RULES:
				return rules != null && !rules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TransformationModelImpl
