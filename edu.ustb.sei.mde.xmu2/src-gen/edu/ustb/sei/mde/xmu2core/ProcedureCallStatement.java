/**
 */
package edu.ustb.sei.mde.xmu2core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Procedure Call Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.ProcedureCallStatement#getProcedure <em>Procedure</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.ProcedureCallStatement#getParameters <em>Parameters</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.ProcedureCallStatement#getUpdatedParameters <em>Updated Parameters</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getProcedureCallStatement()
 * @model
 * @generated
 */
public interface ProcedureCallStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Procedure</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Procedure</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Procedure</em>' reference.
	 * @see #setProcedure(Procedure)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getProcedureCallStatement_Procedure()
	 * @model required="true"
	 * @generated
	 */
	Procedure getProcedure();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.ProcedureCallStatement#getProcedure <em>Procedure</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Procedure</em>' reference.
	 * @see #getProcedure()
	 * @generated
	 */
	void setProcedure(Procedure value);

	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getProcedureCallStatement_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getParameters();

	/**
	 * Returns the value of the '<em><b>Updated Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Updated Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Updated Parameters</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getProcedureCallStatement_UpdatedParameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getUpdatedParameters();

} // ProcedureCallStatement
