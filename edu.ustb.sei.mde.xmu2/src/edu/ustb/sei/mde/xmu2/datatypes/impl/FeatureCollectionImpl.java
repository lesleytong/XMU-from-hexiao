/**
 */
package edu.ustb.sei.mde.xmu2.datatypes.impl;

import edu.ustb.sei.mde.xmu2.datatypes.DatatypesPackage;
import edu.ustb.sei.mde.xmu2.datatypes.FeatureCollection;
import edu.ustb.sei.mde.xmu2.runtime.values.FeatureList;
import edu.ustb.sei.mde.xmu2.util.ModelModificationEngine;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.datatypes.impl.FeatureCollectionImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.datatypes.impl.FeatureCollectionImpl#getSize <em>Size</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.datatypes.impl.FeatureCollectionImpl#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.datatypes.impl.FeatureCollectionImpl#getSourceFeature <em>Source Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeatureCollectionImpl extends MinimalEObjectImpl.Container implements FeatureCollection {
	public FeatureCollectionImpl(EObject source, EStructuralFeature feature, ModelModificationEngine engine) {
		super();
		this.sourceElement = source;
		this.sourceFeature = feature;
		this.elements = new FeatureList<Object>(source,feature,engine);
	}
	
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> elements;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SIZE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getSourceElement() <em>Source Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceElement()
	 * @generated
	 * @ordered
	 */
	protected EObject sourceElement;

	/**
	 * The cached value of the '{@link #getSourceFeature() <em>Source Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature sourceFeature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureCollectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DatatypesPackage.Literals.FEATURE_COLLECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Object> getElements() {
		if (elements == null) {
			elements = new EDataTypeEList<Object>(Object.class, this, DatatypesPackage.FEATURE_COLLECTION__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getSize() {
		return getElements().size();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSourceElement() {
		if (sourceElement != null && sourceElement.eIsProxy()) {
			InternalEObject oldSourceElement = (InternalEObject)sourceElement;
			sourceElement = eResolveProxy(oldSourceElement);
			if (sourceElement != oldSourceElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DatatypesPackage.FEATURE_COLLECTION__SOURCE_ELEMENT, oldSourceElement, sourceElement));
			}
		}
		return sourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSourceElement() {
		return sourceElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceElement(EObject newSourceElement) {
		EObject oldSourceElement = sourceElement;
		sourceElement = newSourceElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.FEATURE_COLLECTION__SOURCE_ELEMENT, oldSourceElement, sourceElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getSourceFeature() {
		if (sourceFeature != null && sourceFeature.eIsProxy()) {
			InternalEObject oldSourceFeature = (InternalEObject)sourceFeature;
			sourceFeature = (EStructuralFeature)eResolveProxy(oldSourceFeature);
			if (sourceFeature != oldSourceFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DatatypesPackage.FEATURE_COLLECTION__SOURCE_FEATURE, oldSourceFeature, sourceFeature));
			}
		}
		return sourceFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetSourceFeature() {
		return sourceFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceFeature(EStructuralFeature newSourceFeature) {
		EStructuralFeature oldSourceFeature = sourceFeature;
		sourceFeature = newSourceFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DatatypesPackage.FEATURE_COLLECTION__SOURCE_FEATURE, oldSourceFeature, sourceFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DatatypesPackage.FEATURE_COLLECTION__ELEMENTS:
				return getElements();
			case DatatypesPackage.FEATURE_COLLECTION__SIZE:
				return getSize();
			case DatatypesPackage.FEATURE_COLLECTION__SOURCE_ELEMENT:
				if (resolve) return getSourceElement();
				return basicGetSourceElement();
			case DatatypesPackage.FEATURE_COLLECTION__SOURCE_FEATURE:
				if (resolve) return getSourceFeature();
				return basicGetSourceFeature();
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
			case DatatypesPackage.FEATURE_COLLECTION__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends Object>)newValue);
				return;
			case DatatypesPackage.FEATURE_COLLECTION__SOURCE_ELEMENT:
				setSourceElement((EObject)newValue);
				return;
			case DatatypesPackage.FEATURE_COLLECTION__SOURCE_FEATURE:
				setSourceFeature((EStructuralFeature)newValue);
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
			case DatatypesPackage.FEATURE_COLLECTION__ELEMENTS:
				getElements().clear();
				return;
			case DatatypesPackage.FEATURE_COLLECTION__SOURCE_ELEMENT:
				setSourceElement((EObject)null);
				return;
			case DatatypesPackage.FEATURE_COLLECTION__SOURCE_FEATURE:
				setSourceFeature((EStructuralFeature)null);
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
			case DatatypesPackage.FEATURE_COLLECTION__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case DatatypesPackage.FEATURE_COLLECTION__SIZE:
				return getSize() != SIZE_EDEFAULT;
			case DatatypesPackage.FEATURE_COLLECTION__SOURCE_ELEMENT:
				return sourceElement != null;
			case DatatypesPackage.FEATURE_COLLECTION__SOURCE_FEATURE:
				return sourceFeature != null;
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
		result.append(" (elements: ");
		result.append(elements);
		result.append(')');
		return result.toString();
	}

} //FeatureCollectionImpl
