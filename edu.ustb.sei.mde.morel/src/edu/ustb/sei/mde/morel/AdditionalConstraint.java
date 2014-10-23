/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Additional Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.AdditionalConstraint#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getAdditionalConstraint()
 * @model abstract="true"
 * @generated
 */
public interface AdditionalConstraint extends EObject {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getAdditionalConstraint_Variables()
	 * @model
	 * @generated
	 */
	EList<Variable> getVariables();

} // AdditionalConstraint
