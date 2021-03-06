/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.TransformationModel#getRules <em>Rules</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getTransformationModel()
 * @model
 * @generated
 */
public interface TransformationModel extends Unit, NamedElement {
	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.RuleElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rules</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getTransformationModel_Rules()
	 * @model containment="true"
	 * @generated
	 */
	EList<RuleElement> getRules();

} // TransformationModel
