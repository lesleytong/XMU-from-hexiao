/**
 */
package edu.ustb.sei.mde.xmu2.expression;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage
 * @generated
 */
public interface ExpressionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionFactory eINSTANCE = edu.ustb.sei.mde.xmu2.expression.impl.ExpressionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Boolean Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Or Expression</em>'.
	 * @generated
	 */
	BooleanOrExpression createBooleanOrExpression();

	/**
	 * Returns a new object of class '<em>Boolean And Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean And Expression</em>'.
	 * @generated
	 */
	BooleanAndExpression createBooleanAndExpression();

	/**
	 * Returns a new object of class '<em>Relational Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relational Expression</em>'.
	 * @generated
	 */
	RelationalExpression createRelationalExpression();

	/**
	 * Returns a new object of class '<em>Additive Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Additive Expression</em>'.
	 * @generated
	 */
	AdditiveExpression createAdditiveExpression();

	/**
	 * Returns a new object of class '<em>Multiplicative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiplicative Expression</em>'.
	 * @generated
	 */
	MultiplicativeExpression createMultiplicativeExpression();

	/**
	 * Returns a new object of class '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unary Expression</em>'.
	 * @generated
	 */
	UnaryExpression createUnaryExpression();

	/**
	 * Returns a new object of class '<em>Path Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Path Expression</em>'.
	 * @generated
	 */
	PathExpression createPathExpression();

	/**
	 * Returns a new object of class '<em>Variable Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Expression</em>'.
	 * @generated
	 */
	VariableExpression createVariableExpression();

	/**
	 * Returns a new object of class '<em>Empty Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Empty Expression</em>'.
	 * @generated
	 */
	EmptyExpression createEmptyExpression();

	/**
	 * Returns a new object of class '<em>String Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Literal Expression</em>'.
	 * @generated
	 */
	StringLiteralExpression createStringLiteralExpression();

	/**
	 * Returns a new object of class '<em>Integer Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Literal Expression</em>'.
	 * @generated
	 */
	IntegerLiteralExpression createIntegerLiteralExpression();

	/**
	 * Returns a new object of class '<em>Boolean Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Boolean Literal Expression</em>'.
	 * @generated
	 */
	BooleanLiteralExpression createBooleanLiteralExpression();

	/**
	 * Returns a new object of class '<em>Enum Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enum Literal Expression</em>'.
	 * @generated
	 */
	EnumLiteralExpression createEnumLiteralExpression();

	/**
	 * Returns a new object of class '<em>Paren Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Paren Expression</em>'.
	 * @generated
	 */
	ParenExpression createParenExpression();

	/**
	 * Returns a new object of class '<em>Object URI Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Object URI Expression</em>'.
	 * @generated
	 */
	ObjectURIExpression createObjectURIExpression();

	/**
	 * Returns a new object of class '<em>Feature Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Path</em>'.
	 * @generated
	 */
	FeaturePath createFeaturePath();

	/**
	 * Returns a new object of class '<em>Operation Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Path</em>'.
	 * @generated
	 */
	OperationPath createOperationPath();

	/**
	 * Returns a new object of class '<em>Loop Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Path</em>'.
	 * @generated
	 */
	LoopPath createLoopPath();

	/**
	 * Returns a new object of class '<em>Position Path</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Position Path</em>'.
	 * @generated
	 */
	PositionPath createPositionPath();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExpressionPackage getExpressionPackage();

} //ExpressionFactory
