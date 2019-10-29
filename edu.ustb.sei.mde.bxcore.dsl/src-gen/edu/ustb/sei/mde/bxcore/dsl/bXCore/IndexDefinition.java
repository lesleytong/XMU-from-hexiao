/**
 * generated by Xtext 2.18.0.M3
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Index Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.IndexDefinition#getSourceType <em>Source Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.IndexDefinition#getViewType <em>View Type</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getIndexDefinition()
 * @model
 * @generated
 */
public interface IndexDefinition extends Definition
{
  /**
   * Returns the value of the '<em><b>Source Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source Type</em>' containment reference.
   * @see #setSourceType(ContextTypeRef)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getIndexDefinition_SourceType()
   * @model containment="true"
   * @generated
   */
  ContextTypeRef getSourceType();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.IndexDefinition#getSourceType <em>Source Type</em>}' containment reference.
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
   * <!-- end-user-doc -->
   * @return the value of the '<em>View Type</em>' containment reference.
   * @see #setViewType(ContextTypeRef)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getIndexDefinition_ViewType()
   * @model containment="true"
   * @generated
   */
  ContextTypeRef getViewType();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.IndexDefinition#getViewType <em>View Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>View Type</em>' containment reference.
   * @see #getViewType()
   * @generated
   */
  void setViewType(ContextTypeRef value);

} // IndexDefinition
