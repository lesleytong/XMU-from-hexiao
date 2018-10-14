/**
 * generated by Xtext 2.14.0
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Var</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeVar#getName <em>Name</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeVar#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getTypeVar()
 * @model
 * @generated
 */
public interface TypeVar extends EObject
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
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getTypeVar_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeVar#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(TypeRef)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getTypeVar_Type()
   * @model containment="true"
   * @generated
   */
  TypeRef getType();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeVar#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(TypeRef value);

} // TypeVar
