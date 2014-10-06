/**
 */
package edu.ustb.sei.mde.morel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Predefined Variable Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.morel.PredefinedVariableExp#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.morel.MorelPackage#getPredefinedVariableExp()
 * @model
 * @generated
 */
public interface PredefinedVariableExp extends AtomicExp {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' attribute.
	 * The literals are from the enumeration {@link edu.ustb.sei.mde.morel.PredefinedVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.PredefinedVariable
	 * @see #setVariable(PredefinedVariable)
	 * @see edu.ustb.sei.mde.morel.MorelPackage#getPredefinedVariableExp_Variable()
	 * @model required="true"
	 * @generated
	 */
	PredefinedVariable getVariable();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.morel.PredefinedVariableExp#getVariable <em>Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' attribute.
	 * @see edu.ustb.sei.mde.morel.PredefinedVariable
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(PredefinedVariable value);

} // PredefinedVariableExp
