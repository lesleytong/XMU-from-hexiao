/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Call Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.RuleCallStatement#getActualParameters <em>Actual Parameters</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.RuleCallStatement#getRule <em>Rule</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getRuleCallStatement()
 * @model
 * @generated
 */
public interface RuleCallStatement extends Statement, TaggedElement {
	/**
	 * Returns the value of the '<em><b>Actual Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.Expr}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Parameters</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getRuleCallStatement_ActualParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expr> getActualParameters();

	/**
	 * Returns the value of the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule</em>' reference.
	 * @see #setRule(Rule)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getRuleCallStatement_Rule()
	 * @model required="true"
	 * @generated
	 */
	Rule getRule();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.RuleCallStatement#getRule <em>Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rule</em>' reference.
	 * @see #getRule()
	 * @generated
	 */
	void setRule(Rule value);

} // RuleCallStatement
