/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.VariableExp#getVar <em>Var</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.VariableExp#getPath <em>Path</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getVariableExp()
 * @model
 * @generated
 */
public interface VariableExp extends AtomicExpr {
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
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getVariableExp_Var()
	 * @model required="true"
	 * @generated
	 */
	Variable getVar();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.VariableExp#getVar <em>Var</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Var</em>' reference.
	 * @see #getVar()
	 * @generated
	 */
	void setVar(Variable value);

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
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getVariableExp_Path()
	 * @model containment="true"
	 * @generated
	 */
	EList<Path> getPath();

} // VariableExp
