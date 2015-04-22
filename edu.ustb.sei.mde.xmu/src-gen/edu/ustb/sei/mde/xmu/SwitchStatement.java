/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.SwitchStatement#getVar <em>Var</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.SwitchStatement#getCases <em>Cases</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.SwitchStatement#getWhen <em>When</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getSwitchStatement()
 * @model
 * @generated
 */
public interface SwitchStatement extends Statement, TaggedElement {
	/**
	 * Returns the value of the '<em><b>Var</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var</em>' reference.
	 * @see #setVar(Variable)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getSwitchStatement_Var()
	 * @model required="true"
	 * @generated
	 */
	Variable getVar();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.SwitchStatement#getVar <em>Var</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var</em>' reference.
	 * @see #getVar()
	 * @generated
	 */
	void setVar(Variable value);

	/**
	 * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.CaseSubStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cases</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getSwitchStatement_Cases()
	 * @model containment="true"
	 * @generated
	 */
	EList<CaseSubStatement> getCases();

	/**
	 * Returns the value of the '<em><b>When</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.UpdatedStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getSwitchStatement_When()
	 * @model containment="true"
	 * @generated
	 */
	EList<UpdatedStatement> getWhen();

} // SwitchStatement
