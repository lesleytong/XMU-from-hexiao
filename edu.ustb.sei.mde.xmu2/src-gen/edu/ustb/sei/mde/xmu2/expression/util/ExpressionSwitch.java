/**
 */
package edu.ustb.sei.mde.xmu2.expression.util;

import edu.ustb.sei.mde.xmu2.expression.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu2.expression.ExpressionPackage
 * @generated
 */
public class ExpressionSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExpressionPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionSwitch() {
		if (modelPackage == null) {
			modelPackage = ExpressionPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ExpressionPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.BOOLEAN_OR_EXPRESSION: {
				BooleanOrExpression booleanOrExpression = (BooleanOrExpression)theEObject;
				T result = caseBooleanOrExpression(booleanOrExpression);
				if (result == null) result = caseExpression(booleanOrExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.BOOLEAN_OR_EXPRESSION_CHILD: {
				BooleanOrExpressionChild booleanOrExpressionChild = (BooleanOrExpressionChild)theEObject;
				T result = caseBooleanOrExpressionChild(booleanOrExpressionChild);
				if (result == null) result = caseExpression(booleanOrExpressionChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.BOOLEAN_AND_EXPRESSION: {
				BooleanAndExpression booleanAndExpression = (BooleanAndExpression)theEObject;
				T result = caseBooleanAndExpression(booleanAndExpression);
				if (result == null) result = caseBooleanOrExpressionChild(booleanAndExpression);
				if (result == null) result = caseExpression(booleanAndExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.BOOLEAN_AND_EXPRESSION_CHILD: {
				BooleanAndExpressionChild booleanAndExpressionChild = (BooleanAndExpressionChild)theEObject;
				T result = caseBooleanAndExpressionChild(booleanAndExpressionChild);
				if (result == null) result = caseBooleanOrExpressionChild(booleanAndExpressionChild);
				if (result == null) result = caseExpression(booleanAndExpressionChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.RELATIONAL_EXPRESSION: {
				RelationalExpression relationalExpression = (RelationalExpression)theEObject;
				T result = caseRelationalExpression(relationalExpression);
				if (result == null) result = caseBooleanAndExpressionChild(relationalExpression);
				if (result == null) result = caseBooleanOrExpressionChild(relationalExpression);
				if (result == null) result = caseExpression(relationalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.RELATIONAL_EXPRESSION_CHILD: {
				RelationalExpressionChild relationalExpressionChild = (RelationalExpressionChild)theEObject;
				T result = caseRelationalExpressionChild(relationalExpressionChild);
				if (result == null) result = caseBooleanAndExpressionChild(relationalExpressionChild);
				if (result == null) result = caseBooleanOrExpressionChild(relationalExpressionChild);
				if (result == null) result = caseExpression(relationalExpressionChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.ADDITIVE_EXPRESSION: {
				AdditiveExpression additiveExpression = (AdditiveExpression)theEObject;
				T result = caseAdditiveExpression(additiveExpression);
				if (result == null) result = caseRelationalExpressionChild(additiveExpression);
				if (result == null) result = caseBooleanAndExpressionChild(additiveExpression);
				if (result == null) result = caseBooleanOrExpressionChild(additiveExpression);
				if (result == null) result = caseExpression(additiveExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.ADDITIVE_EXPRESSION_CHILD: {
				AdditiveExpressionChild additiveExpressionChild = (AdditiveExpressionChild)theEObject;
				T result = caseAdditiveExpressionChild(additiveExpressionChild);
				if (result == null) result = caseRelationalExpressionChild(additiveExpressionChild);
				if (result == null) result = caseBooleanAndExpressionChild(additiveExpressionChild);
				if (result == null) result = caseBooleanOrExpressionChild(additiveExpressionChild);
				if (result == null) result = caseExpression(additiveExpressionChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.MULTIPLICATIVE_EXPRESSION: {
				MultiplicativeExpression multiplicativeExpression = (MultiplicativeExpression)theEObject;
				T result = caseMultiplicativeExpression(multiplicativeExpression);
				if (result == null) result = caseAdditiveExpressionChild(multiplicativeExpression);
				if (result == null) result = caseRelationalExpressionChild(multiplicativeExpression);
				if (result == null) result = caseBooleanAndExpressionChild(multiplicativeExpression);
				if (result == null) result = caseBooleanOrExpressionChild(multiplicativeExpression);
				if (result == null) result = caseExpression(multiplicativeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.MULTIPLICATIVE_EXPRESSION_CHILD: {
				MultiplicativeExpressionChild multiplicativeExpressionChild = (MultiplicativeExpressionChild)theEObject;
				T result = caseMultiplicativeExpressionChild(multiplicativeExpressionChild);
				if (result == null) result = caseAdditiveExpressionChild(multiplicativeExpressionChild);
				if (result == null) result = caseRelationalExpressionChild(multiplicativeExpressionChild);
				if (result == null) result = caseBooleanAndExpressionChild(multiplicativeExpressionChild);
				if (result == null) result = caseBooleanOrExpressionChild(multiplicativeExpressionChild);
				if (result == null) result = caseExpression(multiplicativeExpressionChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.UNARY_EXPRESSION: {
				UnaryExpression unaryExpression = (UnaryExpression)theEObject;
				T result = caseUnaryExpression(unaryExpression);
				if (result == null) result = caseMultiplicativeExpressionChild(unaryExpression);
				if (result == null) result = caseAdditiveExpressionChild(unaryExpression);
				if (result == null) result = caseRelationalExpressionChild(unaryExpression);
				if (result == null) result = caseBooleanAndExpressionChild(unaryExpression);
				if (result == null) result = caseBooleanOrExpressionChild(unaryExpression);
				if (result == null) result = caseExpression(unaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.UNARY_EXPRESSION_CHILD: {
				UnaryExpressionChild unaryExpressionChild = (UnaryExpressionChild)theEObject;
				T result = caseUnaryExpressionChild(unaryExpressionChild);
				if (result == null) result = caseMultiplicativeExpressionChild(unaryExpressionChild);
				if (result == null) result = caseAdditiveExpressionChild(unaryExpressionChild);
				if (result == null) result = caseRelationalExpressionChild(unaryExpressionChild);
				if (result == null) result = caseBooleanAndExpressionChild(unaryExpressionChild);
				if (result == null) result = caseBooleanOrExpressionChild(unaryExpressionChild);
				if (result == null) result = caseExpression(unaryExpressionChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.ATOMIC_EXPRESSION: {
				AtomicExpression atomicExpression = (AtomicExpression)theEObject;
				T result = caseAtomicExpression(atomicExpression);
				if (result == null) result = caseUnaryExpressionChild(atomicExpression);
				if (result == null) result = caseMultiplicativeExpressionChild(atomicExpression);
				if (result == null) result = caseAdditiveExpressionChild(atomicExpression);
				if (result == null) result = caseRelationalExpressionChild(atomicExpression);
				if (result == null) result = caseBooleanAndExpressionChild(atomicExpression);
				if (result == null) result = caseBooleanOrExpressionChild(atomicExpression);
				if (result == null) result = caseExpression(atomicExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.PATH_EXPRESSION: {
				PathExpression pathExpression = (PathExpression)theEObject;
				T result = casePathExpression(pathExpression);
				if (result == null) result = caseUnaryExpressionChild(pathExpression);
				if (result == null) result = caseMultiplicativeExpressionChild(pathExpression);
				if (result == null) result = caseAdditiveExpressionChild(pathExpression);
				if (result == null) result = caseRelationalExpressionChild(pathExpression);
				if (result == null) result = caseBooleanAndExpressionChild(pathExpression);
				if (result == null) result = caseBooleanOrExpressionChild(pathExpression);
				if (result == null) result = caseExpression(pathExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.VARIABLE_EXPRESSION: {
				VariableExpression variableExpression = (VariableExpression)theEObject;
				T result = caseVariableExpression(variableExpression);
				if (result == null) result = caseAtomicExpression(variableExpression);
				if (result == null) result = caseUnaryExpressionChild(variableExpression);
				if (result == null) result = caseMultiplicativeExpressionChild(variableExpression);
				if (result == null) result = caseAdditiveExpressionChild(variableExpression);
				if (result == null) result = caseRelationalExpressionChild(variableExpression);
				if (result == null) result = caseBooleanAndExpressionChild(variableExpression);
				if (result == null) result = caseBooleanOrExpressionChild(variableExpression);
				if (result == null) result = caseExpression(variableExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.CONSTANT_EXPRESSION: {
				ConstantExpression constantExpression = (ConstantExpression)theEObject;
				T result = caseConstantExpression(constantExpression);
				if (result == null) result = caseAtomicExpression(constantExpression);
				if (result == null) result = caseUnaryExpressionChild(constantExpression);
				if (result == null) result = caseMultiplicativeExpressionChild(constantExpression);
				if (result == null) result = caseAdditiveExpressionChild(constantExpression);
				if (result == null) result = caseRelationalExpressionChild(constantExpression);
				if (result == null) result = caseBooleanAndExpressionChild(constantExpression);
				if (result == null) result = caseBooleanOrExpressionChild(constantExpression);
				if (result == null) result = caseExpression(constantExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.EMPTY_EXPRESSION: {
				EmptyExpression emptyExpression = (EmptyExpression)theEObject;
				T result = caseEmptyExpression(emptyExpression);
				if (result == null) result = caseConstantExpression(emptyExpression);
				if (result == null) result = caseAtomicExpression(emptyExpression);
				if (result == null) result = caseUnaryExpressionChild(emptyExpression);
				if (result == null) result = caseMultiplicativeExpressionChild(emptyExpression);
				if (result == null) result = caseAdditiveExpressionChild(emptyExpression);
				if (result == null) result = caseRelationalExpressionChild(emptyExpression);
				if (result == null) result = caseBooleanAndExpressionChild(emptyExpression);
				if (result == null) result = caseBooleanOrExpressionChild(emptyExpression);
				if (result == null) result = caseExpression(emptyExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.STRING_LITERAL_EXPRESSION: {
				StringLiteralExpression stringLiteralExpression = (StringLiteralExpression)theEObject;
				T result = caseStringLiteralExpression(stringLiteralExpression);
				if (result == null) result = caseConstantExpression(stringLiteralExpression);
				if (result == null) result = caseAtomicExpression(stringLiteralExpression);
				if (result == null) result = caseUnaryExpressionChild(stringLiteralExpression);
				if (result == null) result = caseMultiplicativeExpressionChild(stringLiteralExpression);
				if (result == null) result = caseAdditiveExpressionChild(stringLiteralExpression);
				if (result == null) result = caseRelationalExpressionChild(stringLiteralExpression);
				if (result == null) result = caseBooleanAndExpressionChild(stringLiteralExpression);
				if (result == null) result = caseBooleanOrExpressionChild(stringLiteralExpression);
				if (result == null) result = caseExpression(stringLiteralExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.INTEGER_LITERAL_EXPRESSION: {
				IntegerLiteralExpression integerLiteralExpression = (IntegerLiteralExpression)theEObject;
				T result = caseIntegerLiteralExpression(integerLiteralExpression);
				if (result == null) result = caseConstantExpression(integerLiteralExpression);
				if (result == null) result = caseAtomicExpression(integerLiteralExpression);
				if (result == null) result = caseUnaryExpressionChild(integerLiteralExpression);
				if (result == null) result = caseMultiplicativeExpressionChild(integerLiteralExpression);
				if (result == null) result = caseAdditiveExpressionChild(integerLiteralExpression);
				if (result == null) result = caseRelationalExpressionChild(integerLiteralExpression);
				if (result == null) result = caseBooleanAndExpressionChild(integerLiteralExpression);
				if (result == null) result = caseBooleanOrExpressionChild(integerLiteralExpression);
				if (result == null) result = caseExpression(integerLiteralExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.BOOLEAN_LITERAL_EXPRESSION: {
				BooleanLiteralExpression booleanLiteralExpression = (BooleanLiteralExpression)theEObject;
				T result = caseBooleanLiteralExpression(booleanLiteralExpression);
				if (result == null) result = caseConstantExpression(booleanLiteralExpression);
				if (result == null) result = caseAtomicExpression(booleanLiteralExpression);
				if (result == null) result = caseUnaryExpressionChild(booleanLiteralExpression);
				if (result == null) result = caseMultiplicativeExpressionChild(booleanLiteralExpression);
				if (result == null) result = caseAdditiveExpressionChild(booleanLiteralExpression);
				if (result == null) result = caseRelationalExpressionChild(booleanLiteralExpression);
				if (result == null) result = caseBooleanAndExpressionChild(booleanLiteralExpression);
				if (result == null) result = caseBooleanOrExpressionChild(booleanLiteralExpression);
				if (result == null) result = caseExpression(booleanLiteralExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.ENUM_LITERAL_EXPRESSION: {
				EnumLiteralExpression enumLiteralExpression = (EnumLiteralExpression)theEObject;
				T result = caseEnumLiteralExpression(enumLiteralExpression);
				if (result == null) result = caseConstantExpression(enumLiteralExpression);
				if (result == null) result = caseAtomicExpression(enumLiteralExpression);
				if (result == null) result = caseUnaryExpressionChild(enumLiteralExpression);
				if (result == null) result = caseMultiplicativeExpressionChild(enumLiteralExpression);
				if (result == null) result = caseAdditiveExpressionChild(enumLiteralExpression);
				if (result == null) result = caseRelationalExpressionChild(enumLiteralExpression);
				if (result == null) result = caseBooleanAndExpressionChild(enumLiteralExpression);
				if (result == null) result = caseBooleanOrExpressionChild(enumLiteralExpression);
				if (result == null) result = caseExpression(enumLiteralExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.PAREN_EXPRESSION: {
				ParenExpression parenExpression = (ParenExpression)theEObject;
				T result = caseParenExpression(parenExpression);
				if (result == null) result = caseAtomicExpression(parenExpression);
				if (result == null) result = caseUnaryExpressionChild(parenExpression);
				if (result == null) result = caseMultiplicativeExpressionChild(parenExpression);
				if (result == null) result = caseAdditiveExpressionChild(parenExpression);
				if (result == null) result = caseRelationalExpressionChild(parenExpression);
				if (result == null) result = caseBooleanAndExpressionChild(parenExpression);
				if (result == null) result = caseBooleanOrExpressionChild(parenExpression);
				if (result == null) result = caseExpression(parenExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.OBJECT_URI_EXPRESSION: {
				ObjectURIExpression objectURIExpression = (ObjectURIExpression)theEObject;
				T result = caseObjectURIExpression(objectURIExpression);
				if (result == null) result = caseConstantExpression(objectURIExpression);
				if (result == null) result = caseAtomicExpression(objectURIExpression);
				if (result == null) result = caseUnaryExpressionChild(objectURIExpression);
				if (result == null) result = caseMultiplicativeExpressionChild(objectURIExpression);
				if (result == null) result = caseAdditiveExpressionChild(objectURIExpression);
				if (result == null) result = caseRelationalExpressionChild(objectURIExpression);
				if (result == null) result = caseBooleanAndExpressionChild(objectURIExpression);
				if (result == null) result = caseBooleanOrExpressionChild(objectURIExpression);
				if (result == null) result = caseExpression(objectURIExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.PATH: {
				Path path = (Path)theEObject;
				T result = casePath(path);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.FEATURE_PATH: {
				FeaturePath featurePath = (FeaturePath)theEObject;
				T result = caseFeaturePath(featurePath);
				if (result == null) result = casePath(featurePath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.OPERATION_PATH: {
				OperationPath operationPath = (OperationPath)theEObject;
				T result = caseOperationPath(operationPath);
				if (result == null) result = casePath(operationPath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.LOOP_PATH: {
				LoopPath loopPath = (LoopPath)theEObject;
				T result = caseLoopPath(loopPath);
				if (result == null) result = casePath(loopPath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ExpressionPackage.POSITION_PATH: {
				PositionPath positionPath = (PositionPath)theEObject;
				T result = casePositionPath(positionPath);
				if (result == null) result = casePath(positionPath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Or Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Or Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanOrExpression(BooleanOrExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Or Expression Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Or Expression Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanOrExpressionChild(BooleanOrExpressionChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean And Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean And Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanAndExpression(BooleanAndExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean And Expression Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean And Expression Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanAndExpressionChild(BooleanAndExpressionChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relational Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationalExpression(RelationalExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relational Expression Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relational Expression Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationalExpressionChild(RelationalExpressionChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Additive Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Additive Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdditiveExpression(AdditiveExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Additive Expression Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Additive Expression Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdditiveExpressionChild(AdditiveExpressionChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplicative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplicative Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplicativeExpression(MultiplicativeExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplicative Expression Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplicative Expression Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplicativeExpressionChild(MultiplicativeExpressionChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryExpression(UnaryExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Expression Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Expression Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryExpressionChild(UnaryExpressionChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Atomic Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Atomic Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAtomicExpression(AtomicExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePathExpression(PathExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableExpression(VariableExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constant Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constant Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstantExpression(ConstantExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Empty Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Empty Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmptyExpression(EmptyExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteralExpression(StringLiteralExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerLiteralExpression(IntegerLiteralExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteralExpression(BooleanLiteralExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumLiteralExpression(EnumLiteralExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Paren Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Paren Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParenExpression(ParenExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object URI Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object URI Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectURIExpression(ObjectURIExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePath(Path object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeaturePath(FeaturePath object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationPath(OperationPath object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopPath(LoopPath object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Position Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Position Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePositionPath(PositionPath object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ExpressionSwitch
