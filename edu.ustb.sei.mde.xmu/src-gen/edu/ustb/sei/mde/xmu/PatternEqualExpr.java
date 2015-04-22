/**
 */
package edu.ustb.sei.mde.xmu;

import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Equal Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.PatternEqualExpr#getFeature <em>Feature</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.PatternEqualExpr#getValue <em>Value</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.PatternEqualExpr#getPos <em>Pos</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getPatternEqualExpr()
 * @model
 * @generated
 */
public interface PatternEqualExpr extends PatternExpr {
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
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getPatternEqualExpr_Feature()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getFeature();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.PatternEqualExpr#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(AtomicExpr)
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getPatternEqualExpr_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AtomicExpr getValue();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.PatternEqualExpr#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(AtomicExpr value);

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
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#getPatternEqualExpr_Pos()
	 * @model containment="true"
	 * @generated
	 */
	AtomicExpr getPos();

	/**
	 * Sets the value of the '{@link edu.ustb.sei.mde.xmu.PatternEqualExpr#getPos <em>Pos</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pos</em>' containment reference.
	 * @see #getPos()
	 * @generated
	 */
	void setPos(AtomicExpr value);

} // PatternEqualExpr
