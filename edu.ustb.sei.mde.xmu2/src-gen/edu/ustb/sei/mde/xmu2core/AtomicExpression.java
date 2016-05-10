/**
 */
package edu.ustb.sei.mde.xmu2core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Atomic Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.AtomicExpression#getPaths <em>Paths</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getAtomicExpression()
 * @model abstract="true"
 * @generated
 */
public interface AtomicExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Paths</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Path}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Paths</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Paths</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getAtomicExpression_Paths()
	 * @model containment="true"
	 * @generated
	 */
	EList<Path> getPaths();

} // AtomicExpression
