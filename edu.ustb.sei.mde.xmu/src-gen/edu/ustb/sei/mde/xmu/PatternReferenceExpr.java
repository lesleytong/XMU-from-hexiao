/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Reference Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.PatternReferenceExpr#getReference <em>Reference</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.PatternReferenceExpr#getNode <em>Node</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.PatternReferenceExpr#getPos <em>Pos</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getPatternReferenceExpr()
 * @model
 * @generated
 */
public interface PatternReferenceExpr extends PatternExpr {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(EReference)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getPatternReferenceExpr_Reference()
	 * @model required="true"
	 * @generated
	 */
	EReference getReference();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.PatternReferenceExpr#getReference <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(EReference value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' containment reference.
	 * @see #setNode(PatternNode)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getPatternReferenceExpr_Node()
	 * @model containment="true" required="true"
	 * @generated
	 */
	PatternNode getNode();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.PatternReferenceExpr#getNode <em>Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' containment reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(PatternNode value);

	/**
	 * Returns the value of the '<em><b>Pos</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pos</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pos</em>' containment reference.
	 * @see #setPos(AtomicExpr)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getPatternReferenceExpr_Pos()
	 * @model containment="true"
	 * @generated
	 */
	AtomicExpr getPos();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.PatternReferenceExpr#getPos <em>Pos</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pos</em>' containment reference.
	 * @see #getPos()
	 * @generated
	 */
	void setPos(AtomicExpr value);

} // PatternReferenceExpr
