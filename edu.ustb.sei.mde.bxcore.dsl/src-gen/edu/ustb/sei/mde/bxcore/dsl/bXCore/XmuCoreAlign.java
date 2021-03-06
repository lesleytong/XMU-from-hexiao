/**
 * generated by Xtext 2.18.0.M3
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xmu Core Align</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreAlign#getSourcePattern <em>Source Pattern</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreAlign#getViewPattern <em>View Pattern</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreAlign#getAlignment <em>Alignment</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreAlign#getMatch <em>Match</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreAlign#getUnmatchS <em>Unmatch S</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreAlign#getUnmatchV <em>Unmatch V</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreAlign()
 * @model
 * @generated
 */
public interface XmuCoreAlign extends XmuCoreCompositionChildStatement
{
  /**
   * Returns the value of the '<em><b>Source Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source Pattern</em>' containment reference.
   * @see #setSourcePattern(Pattern)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreAlign_SourcePattern()
   * @model containment="true"
   * @generated
   */
  Pattern getSourcePattern();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreAlign#getSourcePattern <em>Source Pattern</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source Pattern</em>' containment reference.
   * @see #getSourcePattern()
   * @generated
   */
  void setSourcePattern(Pattern value);

  /**
   * Returns the value of the '<em><b>View Pattern</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>View Pattern</em>' containment reference.
   * @see #setViewPattern(Pattern)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreAlign_ViewPattern()
   * @model containment="true"
   * @generated
   */
  Pattern getViewPattern();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreAlign#getViewPattern <em>View Pattern</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>View Pattern</em>' containment reference.
   * @see #getViewPattern()
   * @generated
   */
  void setViewPattern(Pattern value);

  /**
   * Returns the value of the '<em><b>Alignment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alignment</em>' containment reference.
   * @see #setAlignment(ContextAwareCondition)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreAlign_Alignment()
   * @model containment="true"
   * @generated
   */
  ContextAwareCondition getAlignment();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreAlign#getAlignment <em>Alignment</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Alignment</em>' containment reference.
   * @see #getAlignment()
   * @generated
   */
  void setAlignment(ContextAwareCondition value);

  /**
   * Returns the value of the '<em><b>Match</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Match</em>' containment reference.
   * @see #setMatch(XmuCoreStatement)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreAlign_Match()
   * @model containment="true"
   * @generated
   */
  XmuCoreStatement getMatch();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreAlign#getMatch <em>Match</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Match</em>' containment reference.
   * @see #getMatch()
   * @generated
   */
  void setMatch(XmuCoreStatement value);

  /**
   * Returns the value of the '<em><b>Unmatch S</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unmatch S</em>' containment reference.
   * @see #setUnmatchS(ContextAwareUnidirectionalAction)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreAlign_UnmatchS()
   * @model containment="true"
   * @generated
   */
  ContextAwareUnidirectionalAction getUnmatchS();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreAlign#getUnmatchS <em>Unmatch S</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unmatch S</em>' containment reference.
   * @see #getUnmatchS()
   * @generated
   */
  void setUnmatchS(ContextAwareUnidirectionalAction value);

  /**
   * Returns the value of the '<em><b>Unmatch V</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unmatch V</em>' containment reference.
   * @see #setUnmatchV(ContextAwareUnidirectionalAction)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreAlign_UnmatchV()
   * @model containment="true"
   * @generated
   */
  ContextAwareUnidirectionalAction getUnmatchV();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreAlign#getUnmatchV <em>Unmatch V</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unmatch V</em>' containment reference.
   * @see #getUnmatchV()
   * @generated
   */
  void setUnmatchV(ContextAwareUnidirectionalAction value);

} // XmuCoreAlign
