/**
 * generated by Xtext 2.14.0
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Indicator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeIndicator#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeIndicator#getViewType <em>View Type</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getTypeIndicator()
 * @model
 * @generated
 */
public interface TypeIndicator extends EObject
{
  /**
   * Returns the value of the '<em><b>Source Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source Type</em>' containment reference.
   * @see #setSourceType(ContextTypeRef)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getTypeIndicator_SourceType()
   * @model containment="true"
   * @generated
   */
  ContextTypeRef getSourceType();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeIndicator#getSourceType <em>Source Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source Type</em>' containment reference.
   * @see #getSourceType()
   * @generated
   */
  void setSourceType(ContextTypeRef value);

  /**
   * Returns the value of the '<em><b>View Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>View Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>View Type</em>' containment reference.
   * @see #setViewType(ContextTypeRef)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getTypeIndicator_ViewType()
   * @model containment="true"
   * @generated
   */
  ContextTypeRef getViewType();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeIndicator#getViewType <em>View Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>View Type</em>' containment reference.
   * @see #getViewType()
   * @generated
   */
  void setViewType(ContextTypeRef value);

} // TypeIndicator
