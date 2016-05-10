/**
 */
package edu.ustb.sei.mde.xmu2.datatypes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.datatypes.FeatureCollection#getSourceElement <em>Source Element</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.datatypes.FeatureCollection#getSourceFeature <em>Source Feature</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.datatypes.DatatypesPackage#getFeatureCollection()
 * @model
 * @generated
 */
public interface FeatureCollection extends OclCollection {
	/**
	 * Returns the value of the '<em><b>Source Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Element</em>' reference.
	 * @see #setSourceElement(EObject)
	 * @see edu.ustb.sei.mde.xmu2.datatypes.DatatypesPackage#getFeatureCollection_SourceElement()
	 * @model required="true"
	 * @generated
	 */
	EObject getSourceElement();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.datatypes.FeatureCollection#getSourceElement <em>Source Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Element</em>' reference.
	 * @see #getSourceElement()
	 * @generated
	 */
	void setSourceElement(EObject value);

	/**
	 * Returns the value of the '<em><b>Source Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Feature</em>' reference.
	 * @see #setSourceFeature(EStructuralFeature)
	 * @see edu.ustb.sei.mde.xmu2.datatypes.DatatypesPackage#getFeatureCollection_SourceFeature()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getSourceFeature();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.datatypes.FeatureCollection#getSourceFeature <em>Source Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Feature</em>' reference.
	 * @see #getSourceFeature()
	 * @generated
	 */
	void setSourceFeature(EStructuralFeature value);

} // FeatureCollection
