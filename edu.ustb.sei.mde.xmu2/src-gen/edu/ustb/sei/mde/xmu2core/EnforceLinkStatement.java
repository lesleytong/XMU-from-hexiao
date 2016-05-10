/**
 */
package edu.ustb.sei.mde.xmu2core;

import edu.ustb.sei.mde.xmu2common.DomainElement;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enforce Link Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getTarget <em>Target</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getFeature <em>Feature</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getSelector <em>Selector</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getPosition <em>Position</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getSourceType <em>Source Type</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getEnforceLinkStatement()
 * @model
 * @generated
 */
public interface EnforceLinkStatement extends Statement, DomainElement {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(Expression)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getEnforceLinkStatement_Target()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getTarget();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Expression value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Variable)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getEnforceLinkStatement_Source()
	 * @model required="true"
	 * @generated
	 */
	Variable getSource();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Variable value);

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
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getEnforceLinkStatement_Feature()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getFeature();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getFeature <em>Feature</em>}' reference.
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
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getEnforceLinkStatement_Selector()
	 * @model containment="true"
	 * @generated
	 */
	LoopPath getSelector();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getSelector <em>Selector</em>}' containment reference.
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
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getEnforceLinkStatement_Position()
	 * @model containment="true"
	 * @generated
	 */
	PositionPath getPosition();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getPosition <em>Position</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Position</em>' containment reference.
	 * @see #getPosition()
	 * @generated
	 */
	void setPosition(PositionPath value);

	/**
	 * Returns the value of the '<em><b>Source Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Type</em>' reference.
	 * @see #setSourceType(EClassifier)
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getEnforceLinkStatement_SourceType()
	 * @model required="true"
	 * @generated
	 */
	EClassifier getSourceType();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu2core.EnforceLinkStatement#getSourceType <em>Source Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Type</em>' reference.
	 * @see #getSourceType()
	 * @generated
	 */
	void setSourceType(EClassifier value);

} // EnforceLinkStatement
