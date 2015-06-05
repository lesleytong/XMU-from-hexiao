/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Initial Mapping Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.InitialMappingStatement#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.InitialMappingStatement#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getInitialMappingStatement()
 * @model
 * @generated
 */
public interface InitialMappingStatement extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.Expr}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getInitialMappingStatement_Source()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Expr> getSource();

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(Expr)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getInitialMappingStatement_Target()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expr getTarget();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.InitialMappingStatement#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Expr value);

} // InitialMappingStatement
