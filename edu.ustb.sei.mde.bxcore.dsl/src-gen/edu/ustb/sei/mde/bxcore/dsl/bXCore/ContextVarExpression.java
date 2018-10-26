/**
 * generated by Xtext 2.14.0
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Var Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextVarExpression#getName <em>Name</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextVarExpression#getSide <em>Side</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getContextVarExpression()
 * @model
 * @generated
 */
public interface ContextVarExpression extends ContextExpression
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getContextVarExpression_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextVarExpression#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Side</b></em>' attribute.
   * The literals are from the enumeration {@link edu.ustb.sei.mde.bxcore.dsl.bXCore.SideEnum}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Side</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Side</em>' attribute.
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.SideEnum
   * @see #setSide(SideEnum)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getContextVarExpression_Side()
   * @model
   * @generated
   */
  SideEnum getSide();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextVarExpression#getSide <em>Side</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Side</em>' attribute.
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.SideEnum
   * @see #getSide()
   * @generated
   */
  void setSide(SideEnum value);

} // ContextVarExpression
