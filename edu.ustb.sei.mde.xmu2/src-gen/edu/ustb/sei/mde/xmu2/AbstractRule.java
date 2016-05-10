/**
 */
package edu.ustb.sei.mde.xmu2;

import edu.ustb.sei.mde.xmu2.statement.Statement;

import edu.ustb.sei.mde.xmu2common.NamedElement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.AbstractRule#getParameters <em>Parameters</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.AbstractRule#getStatement <em>Statement</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getAbstractRule()
 * @model abstract="true"
 * @generated
 */
public interface AbstractRule extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getAbstractRule_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

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
	 * @see edu.ustb.sei.mde.xmu2.Xmu2Package#getAbstractRule_Statement()
	 * @model containment="true"
	 * @generated
	 */
	Statement getStatement();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.AbstractRule#getStatement <em>Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statement</em>' containment reference.
	 * @see #getStatement()
	 * @generated
	 */
	void setStatement(Statement value);

} // AbstractRule
