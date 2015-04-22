/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.Rule#getNVars <em>NVars</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.Rule#getSVars <em>SVars</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.Rule#getSpVars <em>Sp Vars</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.Rule#getVVars <em>VVars</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.Rule#getStatement <em>Statement</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.Rule#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getRule()
 * @model
 * @generated
 */
public interface Rule extends NamedElement {
	/**
	 * Returns the value of the '<em><b>NVars</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.PrimitiveVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>NVars</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>NVars</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getRule_NVars()
	 * @model containment="true"
	 * @generated
	 */
	EList<PrimitiveVariable> getNVars();

	/**
	 * Returns the value of the '<em><b>SVars</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.ObjectVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>SVars</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>SVars</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getRule_SVars()
	 * @model containment="true"
	 * @generated
	 */
	EList<ObjectVariable> getSVars();

	/**
	 * Returns the value of the '<em><b>Sp Vars</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.ObjectVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sp Vars</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sp Vars</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getRule_SpVars()
	 * @model containment="true"
	 * @generated
	 */
	EList<ObjectVariable> getSpVars();

	/**
	 * Returns the value of the '<em><b>VVars</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.ObjectVariable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>VVars</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>VVars</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getRule_VVars()
	 * @model containment="true"
	 * @generated
	 */
	EList<ObjectVariable> getVVars();

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
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getRule_Statement()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Statement getStatement();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.Rule#getStatement <em>Statement</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statement</em>' containment reference.
	 * @see #getStatement()
	 * @generated
	 */
	void setStatement(Statement value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.Parameter}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getRule_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Parameter> getParameters();

} // Rule
