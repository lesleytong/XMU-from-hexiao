/**
 * generated by Xtext 2.18.0.M3
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmFormalParameter;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customized Bi GUL Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.CustomizedBiGULDefinition#getSourceParams <em>Source Params</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.CustomizedBiGULDefinition#getViewParams <em>View Params</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.CustomizedBiGULDefinition#getGet <em>Get</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.CustomizedBiGULDefinition#getPut <em>Put</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getCustomizedBiGULDefinition()
 * @model
 * @generated
 */
public interface CustomizedBiGULDefinition extends Definition
{
  /**
   * Returns the value of the '<em><b>Source Params</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.common.types.JvmFormalParameter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source Params</em>' containment reference list.
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getCustomizedBiGULDefinition_SourceParams()
   * @model containment="true"
   * @generated
   */
  EList<JvmFormalParameter> getSourceParams();

  /**
   * Returns the value of the '<em><b>View Params</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.xtext.common.types.JvmFormalParameter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>View Params</em>' containment reference list.
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getCustomizedBiGULDefinition_ViewParams()
   * @model containment="true"
   * @generated
   */
  EList<JvmFormalParameter> getViewParams();

  /**
   * Returns the value of the '<em><b>Get</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Get</em>' containment reference.
   * @see #setGet(XExpression)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getCustomizedBiGULDefinition_Get()
   * @model containment="true"
   * @generated
   */
  XExpression getGet();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.CustomizedBiGULDefinition#getGet <em>Get</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Get</em>' containment reference.
   * @see #getGet()
   * @generated
   */
  void setGet(XExpression value);

  /**
   * Returns the value of the '<em><b>Put</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Put</em>' containment reference.
   * @see #setPut(XExpression)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getCustomizedBiGULDefinition_Put()
   * @model containment="true"
   * @generated
   */
  XExpression getPut();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.CustomizedBiGULDefinition#getPut <em>Put</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Put</em>' containment reference.
   * @see #getPut()
   * @generated
   */
  void setPut(XExpression value);

} // CustomizedBiGULDefinition
