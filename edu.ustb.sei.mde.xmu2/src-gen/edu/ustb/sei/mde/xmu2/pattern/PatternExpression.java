/**
 */
package edu.ustb.sei.mde.xmu2.pattern;

import edu.ustb.sei.mde.xmu2.expression.LoopPath;
import edu.ustb.sei.mde.xmu2.expression.PositionPath;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getOwnerNode <em>Owner Node</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getFeature <em>Feature</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getSelector <em>Selector</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getPosition <em>Position</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2.pattern.PatternPackage#getPatternExpression()
 * @model abstract="true"
 * @generated
 */
public interface PatternExpression extends EObject {
	/**
	 * Returns the value of the '<em><b>Owner Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link edu.ustb.sei.mde.xmu2.pattern.PatternNode#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner Node</em>' container reference.
	 * @see #setOwnerNode(PatternNode)
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternPackage#getPatternExpression_OwnerNode()
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternNode#getExpressions
	 * @model opposite="expressions" required="true" transient="false"
	 * @generated
	 */
	PatternNode getOwnerNode();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getOwnerNode <em>Owner Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner Node</em>' container reference.
	 * @see #getOwnerNode()
	 * @generated
	 */
	void setOwnerNode(PatternNode value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(EStructuralFeature)
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternPackage#getPatternExpression_Feature()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getFeature();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Selector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Selector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Selector</em>' containment reference.
	 * @see #setSelector(LoopPath)
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternPackage#getPatternExpression_Selector()
	 * @model containment="true"
	 * @generated
	 */
	LoopPath getSelector();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getSelector <em>Selector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Selector</em>' containment reference.
	 * @see #getSelector()
	 * @generated
	 */
	void setSelector(LoopPath value);

	/**
	 * Returns the value of the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Position</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Position</em>' containment reference.
	 * @see #setPosition(PositionPath)
	 * @see edu.ustb.sei.mde.xmu2.pattern.PatternPackage#getPatternExpression_Position()
	 * @model containment="true"
	 * @generated
	 */
	PositionPath getPosition();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2.pattern.PatternExpression#getPosition <em>Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' containment reference.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(PositionPath value);

} // PatternExpression
