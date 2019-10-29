/**
 */
package edu.ustb.sei.mde.xmu2core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case Pattern Clause</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.CasePatternClause#getCondition <em>Condition</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getCasePatternClause()
 * @model
 * @generated
 */
public interface CasePatternClause extends CaseClause {
	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Pattern)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getCasePatternClause_Condition()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Pattern getCondition();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.CasePatternClause#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Pattern value);

} // CasePatternClause
