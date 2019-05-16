/**
 * generated by Xtext 2.14.0
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dashed Path Type Segment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.DashedPathTypeSegment#getTypes <em>Types</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.DashedPathTypeSegment#getRepeat <em>Repeat</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getDashedPathTypeSegment()
 * @model
 * @generated
 */
public interface DashedPathTypeSegment extends EObject
{
  /**
   * Returns the value of the '<em><b>Types</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EStructuralFeature}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Types</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Types</em>' reference list.
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getDashedPathTypeSegment_Types()
   * @model
   * @generated
   */
  EList<EStructuralFeature> getTypes();

  /**
   * Returns the value of the '<em><b>Repeat</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Repeat</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Repeat</em>' attribute.
   * @see #setRepeat(String)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getDashedPathTypeSegment_Repeat()
   * @model
   * @generated
   */
  String getRepeat();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.DashedPathTypeSegment#getRepeat <em>Repeat</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Repeat</em>' attribute.
   * @see #getRepeat()
   * @generated
   */
  void setRepeat(String value);

} // DashedPathTypeSegment
