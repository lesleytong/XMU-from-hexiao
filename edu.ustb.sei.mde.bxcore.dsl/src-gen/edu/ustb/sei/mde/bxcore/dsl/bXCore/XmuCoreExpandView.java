/**
 * generated by Xtext 2.18.0.M3
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xmu Core Expand View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreExpandView#getPattern <em>Pattern</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreExpandView#getMappings <em>Mappings</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreExpandView#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreExpandView()
 * @model
 * @generated
 */
public interface XmuCoreExpandView extends XmuCoreCompositionChildStatement
{
  /**
   * Returns the value of the '<em><b>Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Pattern</em>' containment reference.
   * @see #setPattern(Pattern)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreExpandView_Pattern()
   * @model containment="true"
   * @generated
   */
  Pattern getPattern();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreExpandView#getPattern <em>Pattern</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Pattern</em>' containment reference.
   * @see #getPattern()
   * @generated
   */
  void setPattern(Pattern value);

  /**
   * Returns the value of the '<em><b>Mappings</b></em>' containment reference list.
   * The list contents are of type {@link edu.ustb.sei.mde.bxcore.dsl.bXCore.VarMapping}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mappings</em>' containment reference list.
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreExpandView_Mappings()
   * @model containment="true"
   * @generated
   */
  EList<VarMapping> getMappings();

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(XmuCoreStatement)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreExpandView_Body()
   * @model containment="true"
   * @generated
   */
  XmuCoreStatement getBody();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreExpandView#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(XmuCoreStatement value);

} // XmuCoreExpandView
