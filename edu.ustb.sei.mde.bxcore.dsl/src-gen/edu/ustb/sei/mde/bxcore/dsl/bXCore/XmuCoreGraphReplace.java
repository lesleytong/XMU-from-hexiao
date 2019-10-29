/**
 * generated by Xtext 2.18.0.M3
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xmu Core Graph Replace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreGraphReplace#getSource <em>Source</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreGraphReplace#getView <em>View</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreGraphReplace#getConversions <em>Conversions</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreGraphReplace()
 * @model
 * @generated
 */
public interface XmuCoreGraphReplace extends XmuCoreCompositionChildStatement
{
  /**
   * Returns the value of the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' containment reference.
   * @see #setSource(Pattern)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreGraphReplace_Source()
   * @model containment="true"
   * @generated
   */
  Pattern getSource();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreGraphReplace#getSource <em>Source</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' containment reference.
   * @see #getSource()
   * @generated
   */
  void setSource(Pattern value);

  /**
   * Returns the value of the '<em><b>View</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>View</em>' containment reference.
   * @see #setView(Pattern)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreGraphReplace_View()
   * @model containment="true"
   * @generated
   */
  Pattern getView();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreGraphReplace#getView <em>View</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>View</em>' containment reference.
   * @see #getView()
   * @generated
   */
  void setView(Pattern value);

  /**
   * Returns the value of the '<em><b>Conversions</b></em>' containment reference list.
   * The list contents are of type {@link edu.ustb.sei.mde.bxcore.dsl.bXCore.Conversion}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Conversions</em>' containment reference list.
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreGraphReplace_Conversions()
   * @model containment="true"
   * @generated
   */
  EList<Conversion> getConversions();

} // XmuCoreGraphReplace
