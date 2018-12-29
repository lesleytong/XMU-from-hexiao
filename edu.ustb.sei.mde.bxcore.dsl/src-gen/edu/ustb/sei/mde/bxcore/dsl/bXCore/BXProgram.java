/**
 * generated by Xtext 2.14.0
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.xtype.XImportSection;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BX Program</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.BXProgram#getImports <em>Imports</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.BXProgram#getJavaImports <em>Java Imports</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.BXProgram#getSlots <em>Slots</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.BXProgram#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getBXProgram()
 * @model
 * @generated
 */
public interface BXProgram extends EObject
{
  /**
   * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
   * The list contents are of type {@link edu.ustb.sei.mde.bxcore.dsl.bXCore.ImportSection}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Imports</em>' containment reference list.
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getBXProgram_Imports()
   * @model containment="true"
   * @generated
   */
  EList<ImportSection> getImports();

  /**
   * Returns the value of the '<em><b>Java Imports</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Java Imports</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Java Imports</em>' containment reference.
   * @see #setJavaImports(XImportSection)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getBXProgram_JavaImports()
   * @model containment="true"
   * @generated
   */
  XImportSection getJavaImports();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.BXProgram#getJavaImports <em>Java Imports</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Java Imports</em>' containment reference.
   * @see #getJavaImports()
   * @generated
   */
  void setJavaImports(XImportSection value);

  /**
   * Returns the value of the '<em><b>Slots</b></em>' containment reference list.
   * The list contents are of type {@link edu.ustb.sei.mde.bxcore.dsl.bXCore.DataSlot}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Slots</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Slots</em>' containment reference list.
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getBXProgram_Slots()
   * @model containment="true"
   * @generated
   */
  EList<DataSlot> getSlots();

  /**
   * Returns the value of the '<em><b>Definitions</b></em>' containment reference list.
   * The list contents are of type {@link edu.ustb.sei.mde.bxcore.dsl.bXCore.Definition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Definitions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Definitions</em>' containment reference list.
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getBXProgram_Definitions()
   * @model containment="true"
   * @generated
   */
  EList<Definition> getDefinitions();

} // BXProgram
