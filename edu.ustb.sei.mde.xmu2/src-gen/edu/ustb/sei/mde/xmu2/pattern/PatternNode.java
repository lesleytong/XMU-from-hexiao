/**
 */
package edu.ustb.sei.mde.xmu2.pattern;

import edu.ustb.sei.mde.xmu2.VariableDeclaration;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.pattern.PatternNode#getVariable <em>Variable</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.pattern.PatternNode#getExpressions <em>Expressions</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.pattern.PatternPackage#getPatternNode()
 * @model
 * @generated
 */
public interface PatternNode extends EObject {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference.
	 * @see #setVariable(VariableDeclaration)
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternPackage#getPatternNode_Variable()
	 * @model containment="true" required="true"
	 * @generated
	 */
	VariableDeclaration getVariable();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.pattern.PatternNode#getVariable <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' containment reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(VariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2.pattern.PatternExpression}.
	 * It is bidirectional and its opposite is '{@link edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getOwnerNode <em>Owner Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternPackage#getPatternNode_Expressions()
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getOwnerNode
	 * @model opposite="ownerNode" containment="true"
	 * @generated
	 */
	EList<PatternExpression> getExpressions();

} // PatternNode
