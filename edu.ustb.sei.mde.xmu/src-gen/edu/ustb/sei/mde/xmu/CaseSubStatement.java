/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case Sub Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.CaseSubStatement#getStatement <em>Statement</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.CaseSubStatement#getWhen <em>When</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getCaseSubStatement()
 * @model abstract="true"
 * @generated
 */
public interface CaseSubStatement extends EObject {
	/**
	 * Returns the value of the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statement</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statement</em>' containment reference.
	 * @see #setStatement(Statement)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getCaseSubStatement_Statement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Statement getStatement();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.CaseSubStatement#getStatement <em>Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statement</em>' containment reference.
	 * @see #getStatement()
	 * @generated
	 */
	void setStatement(Statement value);

	/**
	 * Returns the value of the '<em><b>When</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.RuleCallStatement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getCaseSubStatement_When()
	 * @model containment="true"
	 * @generated
	 */
	EList<RuleCallStatement> getWhen();

} // CaseSubStatement
