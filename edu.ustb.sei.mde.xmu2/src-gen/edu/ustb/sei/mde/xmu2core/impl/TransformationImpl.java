/**
 */
package edu.ustb.sei.mde.xmu2core.impl;

import edu.ustb.sei.mde.xmu2common.impl.NamedElementImpl;

import edu.ustb.sei.mde.xmu2core.Procedure;
import edu.ustb.sei.mde.xmu2core.ProcedureCallStatement;
import edu.ustb.sei.mde.xmu2core.Transformation;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.TransformationImpl#getProcedures <em>Procedures</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.TransformationImpl#getDeclaredTypes <em>Declared Types</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.TransformationImpl#getEntryRules <em>Entry Rules</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.impl.TransformationImpl#getPackages <em>Packages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TransformationImpl extends NamedElementImpl implements Transformation {
	/**
	 * The cached value of the '{@link #getProcedures() <em>Procedures</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcedures()
	 * @generated
	 * @ordered
	 */
	protected EList<Procedure> procedures;

	/**
	 * The cached value of the '{@link #getDeclaredTypes() <em>Declared Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeclaredTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<EClassifier> declaredTypes;

	/**
	 * The cached value of the '{@link #getEntryRules() <em>Entry Rules</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntryRules()
	 * @generated
	 * @ordered
	 */
	protected EList<ProcedureCallStatement> entryRules;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Xmu2corePackage.Literals.TRANSFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Procedure> getProcedures() {
		if (procedures == null) {
			procedures = new EObjectContainmentEList<Procedure>(Procedure.class, this, Xmu2corePackage.TRANSFORMATION__PROCEDURES);
		}
		return procedures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EClassifier> getDeclaredTypes() {
		if (declaredTypes == null) {
			declaredTypes = new EObjectContainmentEList<EClassifier>(EClassifier.class, this, Xmu2corePackage.TRANSFORMATION__DECLARED_TYPES);
		}
		return declaredTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ProcedureCallStatement> getEntryRules() {
		if (entryRules == null) {
			entryRules = new EObjectContainmentEList<ProcedureCallStatement>(ProcedureCallStatement.class, this, Xmu2corePackage.TRANSFORMATION__ENTRY_RULES);
		}
		return entryRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EPackage> getPackages() {
		if (packages == null) {
			packages = new EObjectResolvingEList<EPackage>(EPackage.class, this, Xmu2corePackage.TRANSFORMATION__PACKAGES);
		}
		return packages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Xmu2corePackage.TRANSFORMATION__PROCEDURES:
				return ((InternalEList<?>)getProcedures()).basicRemove(otherEnd, msgs);
			case Xmu2corePackage.TRANSFORMATION__DECLARED_TYPES:
				return ((InternalEList<?>)getDeclaredTypes()).basicRemove(otherEnd, msgs);
			case Xmu2corePackage.TRANSFORMATION__ENTRY_RULES:
				return ((InternalEList<?>)getEntryRules()).basicRemove(otherEnd, msgs);
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
			case Xmu2corePackage.TRANSFORMATION__PROCEDURES:
				return getProcedures();
			case Xmu2corePackage.TRANSFORMATION__DECLARED_TYPES:
				return getDeclaredTypes();
			case Xmu2corePackage.TRANSFORMATION__ENTRY_RULES:
				return getEntryRules();
			case Xmu2corePackage.TRANSFORMATION__PACKAGES:
				return getPackages();
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
			case Xmu2corePackage.TRANSFORMATION__PROCEDURES:
				getProcedures().clear();
				getProcedures().addAll((Collection<? extends Procedure>)newValue);
				return;
			case Xmu2corePackage.TRANSFORMATION__DECLARED_TYPES:
				getDeclaredTypes().clear();
				getDeclaredTypes().addAll((Collection<? extends EClassifier>)newValue);
				return;
			case Xmu2corePackage.TRANSFORMATION__ENTRY_RULES:
				getEntryRules().clear();
				getEntryRules().addAll((Collection<? extends ProcedureCallStatement>)newValue);
				return;
			case Xmu2corePackage.TRANSFORMATION__PACKAGES:
				getPackages().clear();
				getPackages().addAll((Collection<? extends EPackage>)newValue);
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
			case Xmu2corePackage.TRANSFORMATION__PROCEDURES:
				getProcedures().clear();
				return;
			case Xmu2corePackage.TRANSFORMATION__DECLARED_TYPES:
				getDeclaredTypes().clear();
				return;
			case Xmu2corePackage.TRANSFORMATION__ENTRY_RULES:
				getEntryRules().clear();
				return;
			case Xmu2corePackage.TRANSFORMATION__PACKAGES:
				getPackages().clear();
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
			case Xmu2corePackage.TRANSFORMATION__PROCEDURES:
				return procedures != null && !procedures.isEmpty();
			case Xmu2corePackage.TRANSFORMATION__DECLARED_TYPES:
				return declaredTypes != null && !declaredTypes.isEmpty();
			case Xmu2corePackage.TRANSFORMATION__ENTRY_RULES:
				return entryRules != null && !entryRules.isEmpty();
			case Xmu2corePackage.TRANSFORMATION__PACKAGES:
				return packages != null && !packages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TransformationImpl
