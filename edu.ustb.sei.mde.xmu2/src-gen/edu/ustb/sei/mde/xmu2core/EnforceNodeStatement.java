/**
 */
package edu.ustb.sei.mde.xmu2core;

import edu.ustb.sei.mde.xmu2common.DomainElement;

import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enforce Node Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.EnforceNodeStatement#getNode <em>Node</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.EnforceNodeStatement#getType <em>Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.EnforceNodeStatement#getCandidate <em>Candidate</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getEnforceNodeStatement()
 * @model
 * @generated
 */
public interface EnforceNodeStatement extends Statement, DomainElement, Nullable {
	/**
	 * Returns the value of the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' reference.
	 * @see #setNode(Variable)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getEnforceNodeStatement_Node()
	 * @model required="true"
	 * @generated
	 */
	Variable getNode();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.EnforceNodeStatement#getNode <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(Variable value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EClassifier)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getEnforceNodeStatement_Type()
	 * @model required="true"
	 * @generated
	 */
	EClassifier getType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.EnforceNodeStatement#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClassifier value);

	/**
	 * Returns the value of the '<em><b>Candidate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Candidate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Candidate</em>' containment reference.
	 * @see #setCandidate(VariableExpression)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getEnforceNodeStatement_Candidate()
	 * @model containment="true"
	 * @generated
	 */
	VariableExpression getCandidate();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.EnforceNodeStatement#getCandidate <em>Candidate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Candidate</em>' containment reference.
	 * @see #getCandidate()
	 * @generated
	 */
	void setCandidate(VariableExpression value);

} // EnforceNodeStatement
