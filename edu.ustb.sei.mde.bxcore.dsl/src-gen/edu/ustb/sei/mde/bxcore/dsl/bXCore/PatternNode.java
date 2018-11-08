/**
 * generated by Xtext 2.14.0
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNode#getName <em>Name</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNode#getType <em>Type</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNode#isMany <em>Many</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNode#getEdges <em>Edges</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getPatternNode()
 * @model
 * @generated
 */
public interface PatternNode extends PatternValueCondition
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
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getPatternNode_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNode#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(EClassifier)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getPatternNode_Type()
   * @model
   * @generated
   */
  EClassifier getType();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNode#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(EClassifier value);

  /**
   * Returns the value of the '<em><b>Many</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Many</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Many</em>' attribute.
   * @see #setMany(boolean)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getPatternNode_Many()
   * @model
   * @generated
   */
  boolean isMany();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNode#isMany <em>Many</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Many</em>' attribute.
   * @see #isMany()
   * @generated
   */
  void setMany(boolean value);

  /**
   * Returns the value of the '<em><b>Edges</b></em>' containment reference list.
   * The list contents are of type {@link edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternEdge}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Edges</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Edges</em>' containment reference list.
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getPatternNode_Edges()
   * @model containment="true"
   * @generated
   */
  EList<PatternEdge> getEdges();

} // PatternNode
