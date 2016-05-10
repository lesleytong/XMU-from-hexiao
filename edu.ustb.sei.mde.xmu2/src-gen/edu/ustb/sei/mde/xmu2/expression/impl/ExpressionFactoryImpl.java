/**
 */
package edu.ustb.sei.mde.xmu2.expression.impl;

import edu.ustb.sei.mde.xmu2.expression.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionFactoryImpl extends EFactoryImpl implements ExpressionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExpressionFactory init() {
		try {
			ExpressionFactory theExpressionFactory = (ExpressionFactory)EPackage.Registry.INSTANCE.getEFactory(ExpressionPackage.eNS_URI);
			if (theExpressionFactory != null) {
				return theExpressionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExpressionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ExpressionPackage.BOOLEAN_OR_EXPRESSION: return createBooleanOrExpression();
			case ExpressionPackage.BOOLEAN_AND_EXPRESSION: return createBooleanAndExpression();
			case ExpressionPackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
			case ExpressionPackage.ADDITIVE_EXPRESSION: return createAdditiveExpression();
			case ExpressionPackage.MULTIPLICATIVE_EXPRESSION: return createMultiplicativeExpression();
			case ExpressionPackage.UNARY_EXPRESSION: return createUnaryExpression();
			case ExpressionPackage.PATH_EXPRESSION: return createPathExpression();
			case ExpressionPackage.VARIABLE_EXPRESSION: return createVariableExpression();
			case ExpressionPackage.EMPTY_EXPRESSION: return createEmptyExpression();
			case ExpressionPackage.STRING_LITERAL_EXPRESSION: return createStringLiteralExpression();
			case ExpressionPackage.INTEGER_LITERAL_EXPRESSION: return createIntegerLiteralExpression();
			case ExpressionPackage.BOOLEAN_LITERAL_EXPRESSION: return createBooleanLiteralExpression();
			case ExpressionPackage.ENUM_LITERAL_EXPRESSION: return createEnumLiteralExpression();
			case ExpressionPackage.PAREN_EXPRESSION: return createParenExpression();
			case ExpressionPackage.OBJECT_URI_EXPRESSION: return createObjectURIExpression();
			case ExpressionPackage.FEATURE_PATH: return createFeaturePath();
			case ExpressionPackage.OPERATION_PATH: return createOperationPath();
			case ExpressionPackage.LOOP_PATH: return createLoopPath();
			case ExpressionPackage.POSITION_PATH: return createPositionPath();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ExpressionPackage.EMPTY_VALUE_TYPE:
				return createEmptyValueTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ExpressionPackage.EMPTY_VALUE_TYPE:
				return convertEmptyValueTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanOrExpression createBooleanOrExpression() {
		BooleanOrExpressionImpl booleanOrExpression = new BooleanOrExpressionImpl();
		return booleanOrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanAndExpression createBooleanAndExpression() {
		BooleanAndExpressionImpl booleanAndExpression = new BooleanAndExpressionImpl();
		return booleanAndExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalExpression createRelationalExpression() {
		RelationalExpressionImpl relationalExpression = new RelationalExpressionImpl();
		return relationalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditiveExpression createAdditiveExpression() {
		AdditiveExpressionImpl additiveExpression = new AdditiveExpressionImpl();
		return additiveExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicativeExpression createMultiplicativeExpression() {
		MultiplicativeExpressionImpl multiplicativeExpression = new MultiplicativeExpressionImpl();
		return multiplicativeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryExpression createUnaryExpression() {
		UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
		return unaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathExpression createPathExpression() {
		PathExpressionImpl pathExpression = new PathExpressionImpl();
		return pathExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableExpression createVariableExpression() {
		VariableExpressionImpl variableExpression = new VariableExpressionImpl();
		return variableExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmptyExpression createEmptyExpression() {
		EmptyExpressionImpl emptyExpression = new EmptyExpressionImpl();
		return emptyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteralExpression createStringLiteralExpression() {
		StringLiteralExpressionImpl stringLiteralExpression = new StringLiteralExpressionImpl();
		return stringLiteralExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerLiteralExpression createIntegerLiteralExpression() {
		IntegerLiteralExpressionImpl integerLiteralExpression = new IntegerLiteralExpressionImpl();
		return integerLiteralExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanLiteralExpression createBooleanLiteralExpression() {
		BooleanLiteralExpressionImpl booleanLiteralExpression = new BooleanLiteralExpressionImpl();
		return booleanLiteralExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiteralExpression createEnumLiteralExpression() {
		EnumLiteralExpressionImpl enumLiteralExpression = new EnumLiteralExpressionImpl();
		return enumLiteralExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParenExpression createParenExpression() {
		ParenExpressionImpl parenExpression = new ParenExpressionImpl();
		return parenExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectURIExpression createObjectURIExpression() {
		ObjectURIExpressionImpl objectURIExpression = new ObjectURIExpressionImpl();
		return objectURIExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeaturePath createFeaturePath() {
		FeaturePathImpl featurePath = new FeaturePathImpl();
		return featurePath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationPath createOperationPath() {
		OperationPathImpl operationPath = new OperationPathImpl();
		return operationPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopPath createLoopPath() {
		LoopPathImpl loopPath = new LoopPathImpl();
		return loopPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PositionPath createPositionPath() {
		PositionPathImpl positionPath = new PositionPathImpl();
		return positionPath;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmptyValueType createEmptyValueTypeFromString(EDataType eDataType, String initialValue) {
		EmptyValueType result = EmptyValueType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEmptyValueTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionPackage getExpressionPackage() {
		return (ExpressionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExpressionPackage getPackage() {
		return ExpressionPackage.eINSTANCE;
	}

} //ExpressionFactoryImpl
