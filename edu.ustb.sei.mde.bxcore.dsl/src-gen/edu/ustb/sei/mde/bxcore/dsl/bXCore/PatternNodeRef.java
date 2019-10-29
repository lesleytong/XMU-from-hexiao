/**
 * generated by Xtext 2.18.0.M3
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Node Ref</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNodeRef#getNode <em>Node</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getPatternNodeRef()
 * @model
 * @generated
 */
public interface PatternNodeRef extends PatternValueCondition
{
  /**
   * Returns the value of the '<em><b>Node</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Node</em>' reference.
   * @see #setNode(PatternNode)
   * @see edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage#getPatternNodeRef_Node()
   * @model
   * @generated
   */
  PatternNode getNode();

  /**
   * Sets the value of the '{@link edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternNodeRef#getNode <em>Node</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Node</em>' reference.
   * @see #getNode()
   * @generated
   */
  void setNode(PatternNode value);

} // PatternNodeRef
