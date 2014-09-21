/**
 */
package edu.ustb.sei.mde.morel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Let Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.LetExp#getVariables <em>Variables</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.morel.LetExp#getInExp <em>In Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getLetExp()
 * @model
 * @generated
 */
public interface LetExp extends Expression, ImperativeExp {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.morel.VariableWithInit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getLetExp_Variables()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<VariableWithInit> getVariables();

	/**
	 * Returns the value of the '<em><b>In Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>In Exp</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>In Exp</em>' containment reference.
	 * @see #setInExp(Expression)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getLetExp_InExp()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getInExp();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.LetExp#getInExp <em>In Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>In Exp</em>' containment reference.
	 * @see #getInExp()
	 * @generated
	 */
	void setInExp(Expression value);

} // LetExp
