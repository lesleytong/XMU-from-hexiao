/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.ConstantExpr#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getConstantExpr()
 * @model abstract="true"
 * @generated
 */
public interface ConstantExpr extends AtomicExpr {

	/**
	 * Returns the value of the '<em><b>Path</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.Path}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getConstantExpr_Path()
	 * @model containment="true"
	 * @generated
	 */
	EList<Path> getPath();
} // ConstantExpr
