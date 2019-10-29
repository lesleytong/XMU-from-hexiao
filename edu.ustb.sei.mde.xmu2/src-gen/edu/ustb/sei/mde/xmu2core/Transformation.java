/**
 */
package edu.ustb.sei.mde.xmu2core;

import edu.ustb.sei.mde.xmu2common.NamedElement;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.Transformation#getCallables <em>Callables</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.Transformation#getDeclaredTypes <em>Declared Types</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.Transformation#getEntryRules <em>Entry Rules</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.Transformation#getPackages <em>Packages</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getTransformation()
 * @model
 * @generated
 */
public interface Transformation extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Callables</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Callable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Callables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Callables</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getTransformation_Callables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Callable> getCallables();

	/**
	 * Returns the value of the '<em><b>Declared Types</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EClassifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declared Types</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Types</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getTransformation_DeclaredTypes()
	 * @model containment="true"
	 * @generated
	 */
	EList<EClassifier> getDeclaredTypes();

	/**
	 * Returns the value of the '<em><b>Entry Rules</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.CallStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Rules</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getTransformation_EntryRules()
	 * @model containment="true"
	 * @generated
	 */
	EList<CallStatement> getEntryRules();

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
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getTransformation_Packages()
	 * @model
	 * @generated
	 */
	EList<EPackage> getPackages();

} // Transformation
