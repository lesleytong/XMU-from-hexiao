/**
 * generated by Xtext 2.18.0.M3
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xmu Core Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreStatement#getTypeIndicator <em>Type Indicator</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreStatement()
 * @model
 * @generated
 */
public interface XmuCoreStatement extends EObject
{
  /**
   * Returns the value of the '<em><b>Type Indicator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type Indicator</em>' containment reference.
   * @see #setTypeIndicator(TypeIndicator)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreStatement_TypeIndicator()
   * @model containment="true"
   * @generated
   */
  TypeIndicator getTypeIndicator();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreStatement#getTypeIndicator <em>Type Indicator</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type Indicator</em>' containment reference.
   * @see #getTypeIndicator()
   * @generated
   */
  void setTypeIndicator(TypeIndicator value);

} // XmuCoreStatement
