/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.Pattern#getVariables <em>Variables</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.Pattern#getLinkConstraints <em>Link Constraints</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.Pattern#getStatements <em>Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getPattern()
 * @model
 * @generated
 */
public interface Pattern extends Section {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getPattern_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getVariables();

	/**
	 * Returns the value of the '<em><b>Link Constraints</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.LinkConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Link Constraints</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Link Constraints</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getPattern_LinkConstraints()
	 * @model containment="true"
	 * @generated
	 */
	EList<LinkConstraint> getLinkConstraints();

	/**
	 * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statements</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getPattern_Statements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getStatements();

} // Pattern
