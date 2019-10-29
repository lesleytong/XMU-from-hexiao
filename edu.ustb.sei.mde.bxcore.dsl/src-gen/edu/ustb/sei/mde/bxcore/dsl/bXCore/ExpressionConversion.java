/**
 * generated by Xtext 2.18.0.M3
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expression Conversion</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.ExpressionConversion#getMetamodel <em>Metamodel</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.ExpressionConversion#getType <em>Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.ExpressionConversion#isMany <em>Many</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.ExpressionConversion#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getExpressionConversion()
 * @model
 * @generated
 */
public interface ExpressionConversion extends ContextPrimaryExpression
{
  /**
   * Returns the value of the '<em><b>Metamodel</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Metamodel</em>' reference.
   * @see #setMetamodel(ImportSection)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getExpressionConversion_Metamodel()
   * @model
   * @generated
   */
  ImportSection getMetamodel();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.ExpressionConversion#getMetamodel <em>Metamodel</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Metamodel</em>' reference.
   * @see #getMetamodel()
   * @generated
   */
  void setMetamodel(ImportSection value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EClass)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getExpressionConversion_Type()
   * @model
   * @generated
   */
  EClass getType();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.ExpressionConversion#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(EClass value);

  /**
   * Returns the value of the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Many</em>' attribute.
   * @see #setMany(boolean)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getExpressionConversion_Many()
   * @model
   * @generated
   */
  boolean isMany();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.ExpressionConversion#isMany <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Many</em>' attribute.
   * @see #isMany()
   * @generated
   */
  void setMany(boolean value);

  /**
   * Returns the value of the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression</em>' containment reference.
   * @see #setExpression(XExpression)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getExpressionConversion_Expression()
   * @model containment="true"
   * @generated
   */
  XExpression getExpression();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.ExpressionConversion#getExpression <em>Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression</em>' containment reference.
   * @see #getExpression()
   * @generated
   */
  void setExpression(XExpression value);

} // ExpressionConversion
