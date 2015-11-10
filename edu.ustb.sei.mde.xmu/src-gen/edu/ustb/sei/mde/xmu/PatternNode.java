/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.PatternNode#getVariable <em>Variable</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.PatternNode#getType <em>Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.PatternNode#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getPatternNode()
 * @model
 * @generated
 */
public interface PatternNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' reference.
	 * @see #setVariable(Variable)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getPatternNode_Variable()
	 * @model required="true"
	 * @generated
	 */
	Variable getVariable();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.PatternNode#getVariable <em>Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EClass)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getPatternNode_Type()
	 * @model required="true"
	 * @generated
	 */
	EClass getType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.PatternNode#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EClass value);

	/**
	 * Returns the value of the '<em><b>Expr</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu.PatternExpr}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getPatternNode_Expr()
	 * @model containment="true"
	 * @generated
	 */
	EList<PatternExpr> getExpr();

} // PatternNode
