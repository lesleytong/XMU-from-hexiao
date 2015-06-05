/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>XMU Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.XMUModel#getInitialMappings <em>Initial Mappings</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.XMUModel#getHelperMappings <em>Helper Mappings</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.XMUModel#getRules <em>Rules</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.XMUModel#getPackages <em>Packages</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.XMUModel#getStart <em>Start</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getXMUModel()
 * @model
 * @generated
 */
public interface XMUModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Initial Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.InitialMappingStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Mappings</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getXMUModel_InitialMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<InitialMappingStatement> getInitialMappings();

	/**
	 * Returns the value of the '<em><b>Helper Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.HelperMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Helper Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Helper Mappings</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getXMUModel_HelperMappings()
	 * @model containment="true"
	 * @generated
	 */
	EList<HelperMapping> getHelperMappings();

	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.Rule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getXMUModel_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<Rule> getRules();

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
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getXMUModel_Packages()
	 * @model
	 * @generated
	 */
	EList<EPackage> getPackages();

	/**
	 * Returns the value of the '<em><b>Start</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.StartStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getXMUModel_Start()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<StartStatement> getStart();

} // XMUModel
