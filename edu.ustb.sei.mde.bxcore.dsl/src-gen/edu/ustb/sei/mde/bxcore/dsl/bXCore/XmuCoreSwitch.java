/**
 * generated by Xtext 2.18.0.M3
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Xmu Core Switch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreSwitch#getBranches <em>Branches</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreSwitch#getAdaptions <em>Adaptions</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreSwitch()
 * @model
 * @generated
 */
public interface XmuCoreSwitch extends XmuCoreCompositionChildStatement
{
  /**
   * Returns the value of the '<em><b>Branches</b></em>' containment reference list.
   * The list contents are of type {@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreSwitchBranch}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Branches</em>' containment reference list.
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreSwitch_Branches()
   * @model containment="true"
   * @generated
   */
  EList<XmuCoreSwitchBranch> getBranches();

  /**
   * Returns the value of the '<em><b>Adaptions</b></em>' containment reference list.
   * The list contents are of type {@link edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreSwitchAdaption}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Adaptions</em>' containment reference list.
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getXmuCoreSwitch_Adaptions()
   * @model containment="true"
   * @generated
   */
  EList<XmuCoreSwitchAdaption> getAdaptions();

} // XmuCoreSwitch
