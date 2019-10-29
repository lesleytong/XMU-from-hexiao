/**
 */
package edu.ustb.sei.mde.xmu2.expression;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "expression";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ustb.edu.cn/sei/mde/xmu2/expression";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "expression";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionPackage eINSTANCE = edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.BooleanOrExpressionImpl <em>Boolean Or Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.BooleanOrExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getBooleanOrExpression()
	 * @generated
	 */
	int BOOLEAN_OR_EXPRESSION = 1;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_EXPRESSION__OPERANDS = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Or Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.BooleanOrExpressionChildImpl <em>Boolean Or Expression Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.BooleanOrExpressionChildImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getBooleanOrExpressionChild()
	 * @generated
	 */
	int BOOLEAN_OR_EXPRESSION_CHILD = 2;

	/**
	 * The number of structural features of the '<em>Boolean Or Expression Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_OR_EXPRESSION_CHILD_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.BooleanAndExpressionImpl <em>Boolean And Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.BooleanAndExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getBooleanAndExpression()
	 * @generated
	 */
	int BOOLEAN_AND_EXPRESSION = 3;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_EXPRESSION__OPERANDS = BOOLEAN_OR_EXPRESSION_CHILD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_EXPRESSION_FEATURE_COUNT = BOOLEAN_OR_EXPRESSION_CHILD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.BooleanAndExpressionChildImpl <em>Boolean And Expression Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.BooleanAndExpressionChildImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getBooleanAndExpressionChild()
	 * @generated
	 */
	int BOOLEAN_AND_EXPRESSION_CHILD = 4;

	/**
	 * The number of structural features of the '<em>Boolean And Expression Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_AND_EXPRESSION_CHILD_FEATURE_COUNT = BOOLEAN_OR_EXPRESSION_CHILD_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.RelationalExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getRelationalExpression()
	 * @generated
	 */
	int RELATIONAL_EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPRESSION__OPERATOR = BOOLEAN_AND_EXPRESSION_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPRESSION__LEFT = BOOLEAN_AND_EXPRESSION_CHILD_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPRESSION__RIGHT = BOOLEAN_AND_EXPRESSION_CHILD_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Relational Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPRESSION_FEATURE_COUNT = BOOLEAN_AND_EXPRESSION_CHILD_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.RelationalExpressionChildImpl <em>Relational Expression Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.RelationalExpressionChildImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getRelationalExpressionChild()
	 * @generated
	 */
	int RELATIONAL_EXPRESSION_CHILD = 6;

	/**
	 * The number of structural features of the '<em>Relational Expression Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPRESSION_CHILD_FEATURE_COUNT = BOOLEAN_AND_EXPRESSION_CHILD_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.AdditiveExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getAdditiveExpression()
	 * @generated
	 */
	int ADDITIVE_EXPRESSION = 7;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPRESSION__OPERATORS = RELATIONAL_EXPRESSION_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPRESSION__OPERANDS = RELATIONAL_EXPRESSION_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Additive Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPRESSION_FEATURE_COUNT = RELATIONAL_EXPRESSION_CHILD_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.AdditiveExpressionChildImpl <em>Additive Expression Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.AdditiveExpressionChildImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getAdditiveExpressionChild()
	 * @generated
	 */
	int ADDITIVE_EXPRESSION_CHILD = 8;

	/**
	 * The number of structural features of the '<em>Additive Expression Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPRESSION_CHILD_FEATURE_COUNT = RELATIONAL_EXPRESSION_CHILD_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.MultiplicativeExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getMultiplicativeExpression()
	 * @generated
	 */
	int MULTIPLICATIVE_EXPRESSION = 9;

	/**
	 * The feature id for the '<em><b>Operators</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPRESSION__OPERATORS = ADDITIVE_EXPRESSION_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPRESSION__OPERANDS = ADDITIVE_EXPRESSION_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Multiplicative Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPRESSION_FEATURE_COUNT = ADDITIVE_EXPRESSION_CHILD_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.MultiplicativeExpressionChildImpl <em>Multiplicative Expression Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.MultiplicativeExpressionChildImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getMultiplicativeExpressionChild()
	 * @generated
	 */
	int MULTIPLICATIVE_EXPRESSION_CHILD = 10;

	/**
	 * The number of structural features of the '<em>Multiplicative Expression Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPRESSION_CHILD_FEATURE_COUNT = ADDITIVE_EXPRESSION_CHILD_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.UnaryExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getUnaryExpression()
	 * @generated
	 */
	int UNARY_EXPRESSION = 11;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__OPERATOR = MULTIPLICATIVE_EXPRESSION_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__BODY = MULTIPLICATIVE_EXPRESSION_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION_FEATURE_COUNT = MULTIPLICATIVE_EXPRESSION_CHILD_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.UnaryExpressionChildImpl <em>Unary Expression Child</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.UnaryExpressionChildImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getUnaryExpressionChild()
	 * @generated
	 */
	int UNARY_EXPRESSION_CHILD = 12;

	/**
	 * The number of structural features of the '<em>Unary Expression Child</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION_CHILD_FEATURE_COUNT = MULTIPLICATIVE_EXPRESSION_CHILD_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.AtomicExpressionImpl <em>Atomic Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.AtomicExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getAtomicExpression()
	 * @generated
	 */
	int ATOMIC_EXPRESSION = 13;

	/**
	 * The number of structural features of the '<em>Atomic Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATOMIC_EXPRESSION_FEATURE_COUNT = UNARY_EXPRESSION_CHILD_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.PathExpressionImpl <em>Path Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.PathExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getPathExpression()
	 * @generated
	 */
	int PATH_EXPRESSION = 14;

	/**
	 * The feature id for the '<em><b>Path</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_EXPRESSION__PATH = UNARY_EXPRESSION_CHILD_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_EXPRESSION__HOST = UNARY_EXPRESSION_CHILD_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Path Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_EXPRESSION_FEATURE_COUNT = UNARY_EXPRESSION_CHILD_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.VariableExpressionImpl <em>Variable Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.VariableExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getVariableExpression()
	 * @generated
	 */
	int VARIABLE_EXPRESSION = 15;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXPRESSION__VARIABLE = ATOMIC_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXPRESSION_FEATURE_COUNT = ATOMIC_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.ConstantExpressionImpl <em>Constant Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ConstantExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getConstantExpression()
	 * @generated
	 */
	int CONSTANT_EXPRESSION = 16;

	/**
	 * The number of structural features of the '<em>Constant Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTANT_EXPRESSION_FEATURE_COUNT = ATOMIC_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.EmptyExpressionImpl <em>Empty Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.EmptyExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getEmptyExpression()
	 * @generated
	 */
	int EMPTY_EXPRESSION = 17;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_EXPRESSION__TYPE = CONSTANT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Empty Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMPTY_EXPRESSION_FEATURE_COUNT = CONSTANT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.StringLiteralExpressionImpl <em>String Literal Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.StringLiteralExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getStringLiteralExpression()
	 * @generated
	 */
	int STRING_LITERAL_EXPRESSION = 18;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXPRESSION__VALUE = CONSTANT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_EXPRESSION_FEATURE_COUNT = CONSTANT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.IntegerLiteralExpressionImpl <em>Integer Literal Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.IntegerLiteralExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getIntegerLiteralExpression()
	 * @generated
	 */
	int INTEGER_LITERAL_EXPRESSION = 19;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXPRESSION__VALUE = CONSTANT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Literal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_LITERAL_EXPRESSION_FEATURE_COUNT = CONSTANT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.BooleanLiteralExpressionImpl <em>Boolean Literal Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.BooleanLiteralExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getBooleanLiteralExpression()
	 * @generated
	 */
	int BOOLEAN_LITERAL_EXPRESSION = 20;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXPRESSION__VALUE = CONSTANT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_EXPRESSION_FEATURE_COUNT = CONSTANT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.EnumLiteralExpressionImpl <em>Enum Literal Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.EnumLiteralExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getEnumLiteralExpression()
	 * @generated
	 */
	int ENUM_LITERAL_EXPRESSION = 21;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXPRESSION__TYPE = CONSTANT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXPRESSION__VALUE = CONSTANT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Enum Literal Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_EXPRESSION_FEATURE_COUNT = CONSTANT_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.ParenExpressionImpl <em>Paren Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ParenExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getParenExpression()
	 * @generated
	 */
	int PAREN_EXPRESSION = 22;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAREN_EXPRESSION__BODY = ATOMIC_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Paren Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAREN_EXPRESSION_FEATURE_COUNT = ATOMIC_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.ObjectURIExpressionImpl <em>Object URI Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ObjectURIExpressionImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getObjectURIExpression()
	 * @generated
	 */
	int OBJECT_URI_EXPRESSION = 23;

	/**
	 * The feature id for the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_URI_EXPRESSION__OBJECT = CONSTANT_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Object URI Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_URI_EXPRESSION_FEATURE_COUNT = CONSTANT_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.PathImpl <em>Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.PathImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getPath()
	 * @generated
	 */
	int PATH = 24;

	/**
	 * The number of structural features of the '<em>Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATH_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.FeaturePathImpl <em>Feature Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.FeaturePathImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getFeaturePath()
	 * @generated
	 */
	int FEATURE_PATH = 25;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PATH__FEATURE = PATH_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PATH_FEATURE_COUNT = PATH_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.OperationPathImpl <em>Operation Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.OperationPathImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getOperationPath()
	 * @generated
	 */
	int OPERATION_PATH = 26;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATH__OPERATION = PATH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATH__PARAMETERS = PATH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PATH_FEATURE_COUNT = PATH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.LoopPathImpl <em>Loop Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.LoopPathImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getLoopPath()
	 * @generated
	 */
	int LOOP_PATH = 27;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PATH__OPERATOR = PATH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PATH__VARIABLE = PATH_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PATH__BODY = PATH_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Loop Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PATH_FEATURE_COUNT = PATH_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.PositionPathImpl <em>Position Path</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.PositionPathImpl
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getPositionPath()
	 * @generated
	 */
	int POSITION_PATH = 28;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_PATH__TYPE = PATH_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_PATH__VALUE = PATH_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Position Path</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSITION_PATH_FEATURE_COUNT = PATH_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.expression.EmptyValueType <em>Empty Value Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.expression.EmptyValueType
	 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getEmptyValueType()
	 * @generated
	 */
	int EMPTY_VALUE_TYPE = 29;


	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression <em>Boolean Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Or Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression
	 * @generated
	 */
	EClass getBooleanOrExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.BooleanOrExpression#getOperands()
	 * @see #getBooleanOrExpression()
	 * @generated
	 */
	EReference getBooleanOrExpression_Operands();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.BooleanOrExpressionChild <em>Boolean Or Expression Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Or Expression Child</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.BooleanOrExpressionChild
	 * @generated
	 */
	EClass getBooleanOrExpressionChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression <em>Boolean And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean And Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression
	 * @generated
	 */
	EClass getBooleanAndExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.BooleanAndExpression#getOperands()
	 * @see #getBooleanAndExpression()
	 * @generated
	 */
	EReference getBooleanAndExpression_Operands();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.BooleanAndExpressionChild <em>Boolean And Expression Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean And Expression Child</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.BooleanAndExpressionChild
	 * @generated
	 */
	EClass getBooleanAndExpressionChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.RelationalExpression <em>Relational Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relational Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.RelationalExpression
	 * @generated
	 */
	EClass getRelationalExpression();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.expression.RelationalExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.RelationalExpression#getOperator()
	 * @see #getRelationalExpression()
	 * @generated
	 */
	EAttribute getRelationalExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.expression.RelationalExpression#getLeft <em>Left</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.RelationalExpression#getLeft()
	 * @see #getRelationalExpression()
	 * @generated
	 */
	EReference getRelationalExpression_Left();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.expression.RelationalExpression#getRight <em>Right</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.RelationalExpression#getRight()
	 * @see #getRelationalExpression()
	 * @generated
	 */
	EReference getRelationalExpression_Right();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.RelationalExpressionChild <em>Relational Expression Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relational Expression Child</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.RelationalExpressionChild
	 * @generated
	 */
	EClass getRelationalExpressionChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.AdditiveExpression <em>Additive Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Additive Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.AdditiveExpression
	 * @generated
	 */
	EClass getAdditiveExpression();

	/**
	 * Returns the meta object for the attribute list '{@link edu.ustb.sei.mde.xmu2.expression.AdditiveExpression#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.AdditiveExpression#getOperators()
	 * @see #getAdditiveExpression()
	 * @generated
	 */
	EAttribute getAdditiveExpression_Operators();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2.expression.AdditiveExpression#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.AdditiveExpression#getOperands()
	 * @see #getAdditiveExpression()
	 * @generated
	 */
	EReference getAdditiveExpression_Operands();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.AdditiveExpressionChild <em>Additive Expression Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Additive Expression Child</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.AdditiveExpressionChild
	 * @generated
	 */
	EClass getAdditiveExpressionChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicative Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression
	 * @generated
	 */
	EClass getMultiplicativeExpression();

	/**
	 * Returns the meta object for the attribute list '{@link edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression#getOperators <em>Operators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Operators</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression#getOperators()
	 * @see #getMultiplicativeExpression()
	 * @generated
	 */
	EAttribute getMultiplicativeExpression_Operators();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpression#getOperands()
	 * @see #getMultiplicativeExpression()
	 * @generated
	 */
	EReference getMultiplicativeExpression_Operands();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpressionChild <em>Multiplicative Expression Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicative Expression Child</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.MultiplicativeExpressionChild
	 * @generated
	 */
	EClass getMultiplicativeExpressionChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.UnaryExpression <em>Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.UnaryExpression
	 * @generated
	 */
	EClass getUnaryExpression();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.expression.UnaryExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.UnaryExpression#getOperator()
	 * @see #getUnaryExpression()
	 * @generated
	 */
	EAttribute getUnaryExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.expression.UnaryExpression#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.UnaryExpression#getBody()
	 * @see #getUnaryExpression()
	 * @generated
	 */
	EReference getUnaryExpression_Body();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.UnaryExpressionChild <em>Unary Expression Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Expression Child</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.UnaryExpressionChild
	 * @generated
	 */
	EClass getUnaryExpressionChild();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.AtomicExpression <em>Atomic Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Atomic Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.AtomicExpression
	 * @generated
	 */
	EClass getAtomicExpression();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.PathExpression <em>Path Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.PathExpression
	 * @generated
	 */
	EClass getPathExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2.expression.PathExpression#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Path</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.PathExpression#getPath()
	 * @see #getPathExpression()
	 * @generated
	 */
	EReference getPathExpression_Path();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.expression.PathExpression#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Host</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.PathExpression#getHost()
	 * @see #getPathExpression()
	 * @generated
	 */
	EReference getPathExpression_Host();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.VariableExpression <em>Variable Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.VariableExpression
	 * @generated
	 */
	EClass getVariableExpression();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.expression.VariableExpression#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.VariableExpression#getVariable()
	 * @see #getVariableExpression()
	 * @generated
	 */
	EAttribute getVariableExpression_Variable();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.ConstantExpression <em>Constant Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constant Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.ConstantExpression
	 * @generated
	 */
	EClass getConstantExpression();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.EmptyExpression <em>Empty Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Empty Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.EmptyExpression
	 * @generated
	 */
	EClass getEmptyExpression();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.expression.EmptyExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.EmptyExpression#getType()
	 * @see #getEmptyExpression()
	 * @generated
	 */
	EAttribute getEmptyExpression_Type();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression <em>String Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression
	 * @generated
	 */
	EClass getStringLiteralExpression();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.StringLiteralExpression#getValue()
	 * @see #getStringLiteralExpression()
	 * @generated
	 */
	EAttribute getStringLiteralExpression_Value();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression <em>Integer Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Literal Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression
	 * @generated
	 */
	EClass getIntegerLiteralExpression();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.IntegerLiteralExpression#getValue()
	 * @see #getIntegerLiteralExpression()
	 * @generated
	 */
	EAttribute getIntegerLiteralExpression_Value();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression <em>Boolean Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression
	 * @generated
	 */
	EClass getBooleanLiteralExpression();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.BooleanLiteralExpression#isValue()
	 * @see #getBooleanLiteralExpression()
	 * @generated
	 */
	EAttribute getBooleanLiteralExpression_Value();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression <em>Enum Literal Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression
	 * @generated
	 */
	EClass getEnumLiteralExpression();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression#getType()
	 * @see #getEnumLiteralExpression()
	 * @generated
	 */
	EReference getEnumLiteralExpression_Type();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.EnumLiteralExpression#getValue()
	 * @see #getEnumLiteralExpression()
	 * @generated
	 */
	EReference getEnumLiteralExpression_Value();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.ParenExpression <em>Paren Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Paren Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.ParenExpression
	 * @generated
	 */
	EClass getParenExpression();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.expression.ParenExpression#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.ParenExpression#getBody()
	 * @see #getParenExpression()
	 * @generated
	 */
	EReference getParenExpression_Body();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression <em>Object URI Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object URI Expression</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression
	 * @generated
	 */
	EClass getObjectURIExpression();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Object</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.ObjectURIExpression#getObject()
	 * @see #getObjectURIExpression()
	 * @generated
	 */
	EReference getObjectURIExpression_Object();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.Path <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Path</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.Path
	 * @generated
	 */
	EClass getPath();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.FeaturePath <em>Feature Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Path</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.FeaturePath
	 * @generated
	 */
	EClass getFeaturePath();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.expression.FeaturePath#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.FeaturePath#getFeature()
	 * @see #getFeaturePath()
	 * @generated
	 */
	EAttribute getFeaturePath_Feature();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.OperationPath <em>Operation Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Path</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.OperationPath
	 * @generated
	 */
	EClass getOperationPath();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.expression.OperationPath#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.OperationPath#getOperation()
	 * @see #getOperationPath()
	 * @generated
	 */
	EAttribute getOperationPath_Operation();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2.expression.OperationPath#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.OperationPath#getParameters()
	 * @see #getOperationPath()
	 * @generated
	 */
	EReference getOperationPath_Parameters();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.LoopPath <em>Loop Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Path</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.LoopPath
	 * @generated
	 */
	EClass getLoopPath();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.expression.LoopPath#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.LoopPath#getOperator()
	 * @see #getLoopPath()
	 * @generated
	 */
	EAttribute getLoopPath_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.expression.LoopPath#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Variable</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.LoopPath#getVariable()
	 * @see #getLoopPath()
	 * @generated
	 */
	EReference getLoopPath_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.expression.LoopPath#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.LoopPath#getBody()
	 * @see #getLoopPath()
	 * @generated
	 */
	EReference getLoopPath_Body();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.expression.PositionPath <em>Position Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Position Path</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.PositionPath
	 * @generated
	 */
	EClass getPositionPath();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.expression.PositionPath#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.PositionPath#getType()
	 * @see #getPositionPath()
	 * @generated
	 */
	EAttribute getPositionPath_Type();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.expression.PositionPath#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.PositionPath#getValue()
	 * @see #getPositionPath()
	 * @generated
	 */
	EReference getPositionPath_Value();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.xmu2.expression.EmptyValueType <em>Empty Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Empty Value Type</em>'.
	 * @see edu.ustb.sei.mde.xmu2.expression.EmptyValueType
	 * @generated
	 */
	EEnum getEmptyValueType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExpressionFactory getExpressionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.BooleanOrExpressionImpl <em>Boolean Or Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.BooleanOrExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getBooleanOrExpression()
		 * @generated
		 */
		EClass BOOLEAN_OR_EXPRESSION = eINSTANCE.getBooleanOrExpression();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_OR_EXPRESSION__OPERANDS = eINSTANCE.getBooleanOrExpression_Operands();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.BooleanOrExpressionChildImpl <em>Boolean Or Expression Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.BooleanOrExpressionChildImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getBooleanOrExpressionChild()
		 * @generated
		 */
		EClass BOOLEAN_OR_EXPRESSION_CHILD = eINSTANCE.getBooleanOrExpressionChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.BooleanAndExpressionImpl <em>Boolean And Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.BooleanAndExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getBooleanAndExpression()
		 * @generated
		 */
		EClass BOOLEAN_AND_EXPRESSION = eINSTANCE.getBooleanAndExpression();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOOLEAN_AND_EXPRESSION__OPERANDS = eINSTANCE.getBooleanAndExpression_Operands();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.BooleanAndExpressionChildImpl <em>Boolean And Expression Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.BooleanAndExpressionChildImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getBooleanAndExpressionChild()
		 * @generated
		 */
		EClass BOOLEAN_AND_EXPRESSION_CHILD = eINSTANCE.getBooleanAndExpressionChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.RelationalExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getRelationalExpression()
		 * @generated
		 */
		EClass RELATIONAL_EXPRESSION = eINSTANCE.getRelationalExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATIONAL_EXPRESSION__OPERATOR = eINSTANCE.getRelationalExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Left</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_EXPRESSION__LEFT = eINSTANCE.getRelationalExpression_Left();

		/**
		 * The meta object literal for the '<em><b>Right</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_EXPRESSION__RIGHT = eINSTANCE.getRelationalExpression_Right();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.RelationalExpressionChildImpl <em>Relational Expression Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.RelationalExpressionChildImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getRelationalExpressionChild()
		 * @generated
		 */
		EClass RELATIONAL_EXPRESSION_CHILD = eINSTANCE.getRelationalExpressionChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.AdditiveExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getAdditiveExpression()
		 * @generated
		 */
		EClass ADDITIVE_EXPRESSION = eINSTANCE.getAdditiveExpression();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDITIVE_EXPRESSION__OPERATORS = eINSTANCE.getAdditiveExpression_Operators();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDITIVE_EXPRESSION__OPERANDS = eINSTANCE.getAdditiveExpression_Operands();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.AdditiveExpressionChildImpl <em>Additive Expression Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.AdditiveExpressionChildImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getAdditiveExpressionChild()
		 * @generated
		 */
		EClass ADDITIVE_EXPRESSION_CHILD = eINSTANCE.getAdditiveExpressionChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.MultiplicativeExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getMultiplicativeExpression()
		 * @generated
		 */
		EClass MULTIPLICATIVE_EXPRESSION = eINSTANCE.getMultiplicativeExpression();

		/**
		 * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICATIVE_EXPRESSION__OPERATORS = eINSTANCE.getMultiplicativeExpression_Operators();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLICATIVE_EXPRESSION__OPERANDS = eINSTANCE.getMultiplicativeExpression_Operands();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.MultiplicativeExpressionChildImpl <em>Multiplicative Expression Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.MultiplicativeExpressionChildImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getMultiplicativeExpressionChild()
		 * @generated
		 */
		EClass MULTIPLICATIVE_EXPRESSION_CHILD = eINSTANCE.getMultiplicativeExpressionChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.UnaryExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getUnaryExpression()
		 * @generated
		 */
		EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNARY_EXPRESSION__OPERATOR = eINSTANCE.getUnaryExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_EXPRESSION__BODY = eINSTANCE.getUnaryExpression_Body();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.UnaryExpressionChildImpl <em>Unary Expression Child</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.UnaryExpressionChildImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getUnaryExpressionChild()
		 * @generated
		 */
		EClass UNARY_EXPRESSION_CHILD = eINSTANCE.getUnaryExpressionChild();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.AtomicExpressionImpl <em>Atomic Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.AtomicExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getAtomicExpression()
		 * @generated
		 */
		EClass ATOMIC_EXPRESSION = eINSTANCE.getAtomicExpression();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.PathExpressionImpl <em>Path Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.PathExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getPathExpression()
		 * @generated
		 */
		EClass PATH_EXPRESSION = eINSTANCE.getPathExpression();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_EXPRESSION__PATH = eINSTANCE.getPathExpression_Path();

		/**
		 * The meta object literal for the '<em><b>Host</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATH_EXPRESSION__HOST = eINSTANCE.getPathExpression_Host();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.VariableExpressionImpl <em>Variable Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.VariableExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getVariableExpression()
		 * @generated
		 */
		EClass VARIABLE_EXPRESSION = eINSTANCE.getVariableExpression();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_EXPRESSION__VARIABLE = eINSTANCE.getVariableExpression_Variable();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.ConstantExpressionImpl <em>Constant Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ConstantExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getConstantExpression()
		 * @generated
		 */
		EClass CONSTANT_EXPRESSION = eINSTANCE.getConstantExpression();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.EmptyExpressionImpl <em>Empty Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.EmptyExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getEmptyExpression()
		 * @generated
		 */
		EClass EMPTY_EXPRESSION = eINSTANCE.getEmptyExpression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EMPTY_EXPRESSION__TYPE = eINSTANCE.getEmptyExpression_Type();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.StringLiteralExpressionImpl <em>String Literal Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.StringLiteralExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getStringLiteralExpression()
		 * @generated
		 */
		EClass STRING_LITERAL_EXPRESSION = eINSTANCE.getStringLiteralExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL_EXPRESSION__VALUE = eINSTANCE.getStringLiteralExpression_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.IntegerLiteralExpressionImpl <em>Integer Literal Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.IntegerLiteralExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getIntegerLiteralExpression()
		 * @generated
		 */
		EClass INTEGER_LITERAL_EXPRESSION = eINSTANCE.getIntegerLiteralExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_LITERAL_EXPRESSION__VALUE = eINSTANCE.getIntegerLiteralExpression_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.BooleanLiteralExpressionImpl <em>Boolean Literal Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.BooleanLiteralExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getBooleanLiteralExpression()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL_EXPRESSION = eINSTANCE.getBooleanLiteralExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL_EXPRESSION__VALUE = eINSTANCE.getBooleanLiteralExpression_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.EnumLiteralExpressionImpl <em>Enum Literal Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.EnumLiteralExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getEnumLiteralExpression()
		 * @generated
		 */
		EClass ENUM_LITERAL_EXPRESSION = eINSTANCE.getEnumLiteralExpression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_LITERAL_EXPRESSION__TYPE = eINSTANCE.getEnumLiteralExpression_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_LITERAL_EXPRESSION__VALUE = eINSTANCE.getEnumLiteralExpression_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.ParenExpressionImpl <em>Paren Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ParenExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getParenExpression()
		 * @generated
		 */
		EClass PAREN_EXPRESSION = eINSTANCE.getParenExpression();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAREN_EXPRESSION__BODY = eINSTANCE.getParenExpression_Body();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.ObjectURIExpressionImpl <em>Object URI Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ObjectURIExpressionImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getObjectURIExpression()
		 * @generated
		 */
		EClass OBJECT_URI_EXPRESSION = eINSTANCE.getObjectURIExpression();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT_URI_EXPRESSION__OBJECT = eINSTANCE.getObjectURIExpression_Object();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.PathImpl <em>Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.PathImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getPath()
		 * @generated
		 */
		EClass PATH = eINSTANCE.getPath();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.FeaturePathImpl <em>Feature Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.FeaturePathImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getFeaturePath()
		 * @generated
		 */
		EClass FEATURE_PATH = eINSTANCE.getFeaturePath();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_PATH__FEATURE = eINSTANCE.getFeaturePath_Feature();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.OperationPathImpl <em>Operation Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.OperationPathImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getOperationPath()
		 * @generated
		 */
		EClass OPERATION_PATH = eINSTANCE.getOperationPath();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_PATH__OPERATION = eINSTANCE.getOperationPath_Operation();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_PATH__PARAMETERS = eINSTANCE.getOperationPath_Parameters();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.LoopPathImpl <em>Loop Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.LoopPathImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getLoopPath()
		 * @generated
		 */
		EClass LOOP_PATH = eINSTANCE.getLoopPath();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOP_PATH__OPERATOR = eINSTANCE.getLoopPath_Operator();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_PATH__VARIABLE = eINSTANCE.getLoopPath_Variable();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_PATH__BODY = eINSTANCE.getLoopPath_Body();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.impl.PositionPathImpl <em>Position Path</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.PositionPathImpl
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getPositionPath()
		 * @generated
		 */
		EClass POSITION_PATH = eINSTANCE.getPositionPath();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSITION_PATH__TYPE = eINSTANCE.getPositionPath_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POSITION_PATH__VALUE = eINSTANCE.getPositionPath_Value();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.expression.EmptyValueType <em>Empty Value Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.expression.EmptyValueType
		 * @see edu.ustb.sei.mde.xmu2.expression.impl.ExpressionPackageImpl#getEmptyValueType()
		 * @generated
		 */
		EEnum EMPTY_VALUE_TYPE = eINSTANCE.getEmptyValueType();

	}

} //ExpressionPackage
