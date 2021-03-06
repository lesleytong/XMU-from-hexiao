/**
 * generated by Xtext 2.18.0.M3
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xmu Core Derive Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreDeriveSource#getDerivedType <em>Derived Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreDeriveSource#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreDeriveSource()
 * @model
 * @generated
 */
public interface XmuCoreDeriveSource extends XmuCoreCompositionChildStatement
{
  /**
   * Returns the value of the '<em><b>Derived Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Derived Type</em>' containment reference.
   * @see #setDerivedType(UnorderedTupleTypeLiteral)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreDeriveSource_DerivedType()
   * @model containment="true"
   * @generated
   */
  UnorderedTupleTypeLiteral getDerivedType();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreDeriveSource#getDerivedType <em>Derived Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Derived Type</em>' containment reference.
   * @see #getDerivedType()
   * @generated
   */
  void setDerivedType(UnorderedTupleTypeLiteral value);

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(XmuCoreStatement)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreDeriveSource_Body()
   * @model containment="true"
   * @generated
   */
  XmuCoreStatement getBody();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreDeriveSource#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(XmuCoreStatement value);

} // XmuCoreDeriveSource
