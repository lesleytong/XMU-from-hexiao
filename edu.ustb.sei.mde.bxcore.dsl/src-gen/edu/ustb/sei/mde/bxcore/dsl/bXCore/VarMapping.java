/**
 * generated by Xtext 2.14.0
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Var Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.VarMapping#getTo <em>To</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.VarMapping#getFrom <em>From</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getVarMapping()
 * @model
 * @generated
 */
public interface VarMapping extends EObject
{
  /**
   * Returns the value of the '<em><b>To</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To</em>' attribute.
   * @see #setTo(String)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getVarMapping_To()
   * @model
   * @generated
   */
  String getTo();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.VarMapping#getTo <em>To</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To</em>' attribute.
   * @see #getTo()
   * @generated
   */
  void setTo(String value);

  /**
   * Returns the value of the '<em><b>From</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>From</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>From</em>' attribute.
   * @see #setFrom(String)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getVarMapping_From()
   * @model
   * @generated
   */
  String getFrom();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.VarMapping#getFrom <em>From</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>From</em>' attribute.
   * @see #getFrom()
   * @generated
   */
  void setFrom(String value);

} // VarMapping
