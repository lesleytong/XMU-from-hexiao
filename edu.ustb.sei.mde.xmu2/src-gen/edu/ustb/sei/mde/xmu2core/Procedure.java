/**
 */
package edu.ustb.sei.mde.xmu2core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Procedure</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.Procedure#getBackwardStatements <em>Backward Statements</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.Procedure#getForwardStatements <em>Forward Statements</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getProcedure()
 * @model
 * @generated
 */
public interface Procedure extends Callable {
	/**
	 * Returns the value of the '<em><b>Backward Statements</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Backward Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Backward Statements</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getProcedure_BackwardStatements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getBackwardStatements();

	/**
	 * Returns the value of the '<em><b>Forward Statements</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forward Statements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forward Statements</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getProcedure_ForwardStatements()
	 * @model containment="true"
	 * @generated
	 */
	EList<Statement> getForwardStatements();

} // Procedure
