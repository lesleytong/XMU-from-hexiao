/**
 */
package edu.ustb.sei.mde.xmu2;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.ModelRule#isActive <em>Active</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.ModelRule#getVariableDeclarations <em>Variable Declarations</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getModelRule()
 * @model
 * @generated
 */
public interface ModelRule extends AbstractRule {
	/**
	 * Returns the value of the '<em><b>Active</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active</em>' attribute.
	 * @see #setActive(boolean)
	 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getModelRule_Active()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isActive();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.ModelRule#isActive <em>Active</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active</em>' attribute.
	 * @see #isActive()
	 * @generated
	 */
	void setActive(boolean value);

	/**
	 * Returns the value of the '<em><b>Variable Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Declarations</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getModelRule_VariableDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<VariableDeclaration> getVariableDeclarations();

} // ModelRule
