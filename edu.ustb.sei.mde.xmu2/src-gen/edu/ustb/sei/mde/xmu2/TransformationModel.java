/**
 */
package edu.ustb.sei.mde.xmu2;

import edu.ustb.sei.mde.xmu2common.NamedElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.TransformationModel#getPackages <em>Packages</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.TransformationModel#getEntryPoints <em>Entry Points</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.TransformationModel#getRules <em>Rules</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getTransformationModel()
 * @model
 * @generated
 */
public interface TransformationModel extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Packages</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EPackage}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packages</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packages</em>' reference list.
	 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getTransformationModel_Packages()
	 * @model
	 * @generated
	 */
	EList<EPackage> getPackages();

	/**
	 * Returns the value of the '<em><b>Entry Points</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2.EntryPoint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Points</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getTransformationModel_EntryPoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<EntryPoint> getEntryPoints();

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2.AbstractRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getTransformationModel_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractRule> getRules();

} // TransformationModel
