/**
 */
package edu.ustb.sei.mde.xmu2core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tuple Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2core.TupleExpression#getTuples <em>Tuples</em>}</li>
 * </ul>
 *
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getTupleExpression()
 * @model
 * @generated
 */
public interface TupleExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Tuples</b></em>' containment reference list.
	 * The list contents are of type {@link edu.ustb.sei.mde.xmu2core.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tuples</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tuples</em>' containment reference list.
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#getTupleExpression_Tuples()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Expression> getTuples();

} // TupleExpression
