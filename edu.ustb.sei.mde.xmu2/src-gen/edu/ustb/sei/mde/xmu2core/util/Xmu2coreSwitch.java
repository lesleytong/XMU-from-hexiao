/**
 */
package edu.ustb.sei.mde.xmu2core.util;

import edu.ustb.sei.mde.xmu2common.DomainElement;
import edu.ustb.sei.mde.xmu2common.NamedElement;

import edu.ustb.sei.mde.xmu2core.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
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
 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage
 * @generated
 */
public class Xmu2coreSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static Xmu2corePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xmu2coreSwitch() {
		if (modelPackage == null) {
			modelPackage = Xmu2corePackage.eINSTANCE;
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
			case Xmu2corePackage.TYPED_ELEMENT: {
				TypedElement typedElement = (TypedElement)theEObject;
				T result = caseTypedElement(typedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.NULLABLE: {
				Nullable nullable = (Nullable)theEObject;
				T result = caseNullable(nullable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.CALLABLE: {
				Callable callable = (Callable)theEObject;
				T result = caseCallable(callable);
				if (result == null) result = caseNamedElement(callable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.PROCEDURE: {
				Procedure procedure = (Procedure)theEObject;
				T result = caseProcedure(procedure);
				if (result == null) result = caseCallable(procedure);
				if (result == null) result = caseNamedElement(procedure);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				T result = caseVariable(variable);
				if (result == null) result = caseNamedElement(variable);
				if (result == null) result = caseTypedElement(variable);
				if (result == null) result = caseDomainElement(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.ALIGN_STATEMENT: {
				AlignStatement alignStatement = (AlignStatement)theEObject;
				T result = caseAlignStatement(alignStatement);
				if (result == null) result = caseStatement(alignStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.CASE_STATEMENT: {
				CaseStatement caseStatement = (CaseStatement)theEObject;
				T result = caseCaseStatement(caseStatement);
				if (result == null) result = caseStatement(caseStatement);
				if (result == null) result = caseDomainElement(caseStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.CASE_CLAUSE: {
				CaseClause caseClause = (CaseClause)theEObject;
				T result = caseCaseClause(caseClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.CASE_PATTERN_CLAUSE: {
				CasePatternClause casePatternClause = (CasePatternClause)theEObject;
				T result = caseCasePatternClause(casePatternClause);
				if (result == null) result = caseCaseClause(casePatternClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.CASE_EXPRESSION_CLAUSE: {
				CaseExpressionClause caseExpressionClause = (CaseExpressionClause)theEObject;
				T result = caseCaseExpressionClause(caseExpressionClause);
				if (result == null) result = caseCaseClause(caseExpressionClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.CASE_STATEMENT_CLAUSE: {
				CaseStatementClause caseStatementClause = (CaseStatementClause)theEObject;
				T result = caseCaseStatementClause(caseStatementClause);
				if (result == null) result = caseCaseClause(caseStatementClause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.PATTERN: {
				Pattern pattern = (Pattern)theEObject;
				T result = casePattern(pattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.PATTERN_NODE: {
				PatternNode patternNode = (PatternNode)theEObject;
				T result = casePatternNode(patternNode);
				if (result == null) result = caseReflectiveSupport(patternNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.PATTERN_EXPRESSION: {
				PatternExpression patternExpression = (PatternExpression)theEObject;
				T result = casePatternExpression(patternExpression);
				if (result == null) result = caseNullable(patternExpression);
				if (result == null) result = caseReflectiveSupport(patternExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.OBJECT_PATTERN_EXPRESSION: {
				ObjectPatternExpression objectPatternExpression = (ObjectPatternExpression)theEObject;
				T result = caseObjectPatternExpression(objectPatternExpression);
				if (result == null) result = casePatternExpression(objectPatternExpression);
				if (result == null) result = caseNullable(objectPatternExpression);
				if (result == null) result = caseReflectiveSupport(objectPatternExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.PROPERTY_PATTERN_EXPRESSION: {
				PropertyPatternExpression propertyPatternExpression = (PropertyPatternExpression)theEObject;
				T result = casePropertyPatternExpression(propertyPatternExpression);
				if (result == null) result = casePatternExpression(propertyPatternExpression);
				if (result == null) result = caseNullable(propertyPatternExpression);
				if (result == null) result = caseReflectiveSupport(propertyPatternExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.BOOLEAN_OR_EXPRESSION: {
				BooleanOrExpression booleanOrExpression = (BooleanOrExpression)theEObject;
				T result = caseBooleanOrExpression(booleanOrExpression);
				if (result == null) result = caseExpression(booleanOrExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.BOOLEAN_AND_EXPRESSION: {
				BooleanAndExpression booleanAndExpression = (BooleanAndExpression)theEObject;
				T result = caseBooleanAndExpression(booleanAndExpression);
				if (result == null) result = caseExpression(booleanAndExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.RELATIONAL_EXPRESSION: {
				RelationalExpression relationalExpression = (RelationalExpression)theEObject;
				T result = caseRelationalExpression(relationalExpression);
				if (result == null) result = caseExpression(relationalExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.ADDITIVE_EXPRESSION: {
				AdditiveExpression additiveExpression = (AdditiveExpression)theEObject;
				T result = caseAdditiveExpression(additiveExpression);
				if (result == null) result = caseExpression(additiveExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.MULTIPLICATIVE_EXPRESSION: {
				MultiplicativeExpression multiplicativeExpression = (MultiplicativeExpression)theEObject;
				T result = caseMultiplicativeExpression(multiplicativeExpression);
				if (result == null) result = caseExpression(multiplicativeExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.UNARY_EXPRESSION: {
				UnaryExpression unaryExpression = (UnaryExpression)theEObject;
				T result = caseUnaryExpression(unaryExpression);
				if (result == null) result = caseExpression(unaryExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.ATOMIC_EXPRESSION: {
				AtomicExpression atomicExpression = (AtomicExpression)theEObject;
				T result = caseAtomicExpression(atomicExpression);
				if (result == null) result = caseExpression(atomicExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.TYPE_CAST_EXPRESSION: {
				TypeCastExpression typeCastExpression = (TypeCastExpression)theEObject;
				T result = caseTypeCastExpression(typeCastExpression);
				if (result == null) result = caseAtomicExpression(typeCastExpression);
				if (result == null) result = caseExpression(typeCastExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.PRIMITIVE_VALUE_EXPRESSION: {
				PrimitiveValueExpression primitiveValueExpression = (PrimitiveValueExpression)theEObject;
				T result = casePrimitiveValueExpression(primitiveValueExpression);
				if (result == null) result = caseAtomicExpression(primitiveValueExpression);
				if (result == null) result = caseExpression(primitiveValueExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.STRING_VALUE_EXPRESSION: {
				StringValueExpression stringValueExpression = (StringValueExpression)theEObject;
				T result = caseStringValueExpression(stringValueExpression);
				if (result == null) result = casePrimitiveValueExpression(stringValueExpression);
				if (result == null) result = caseAtomicExpression(stringValueExpression);
				if (result == null) result = caseExpression(stringValueExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.BOOLEAN_VALUE_EXPRESSION: {
				BooleanValueExpression booleanValueExpression = (BooleanValueExpression)theEObject;
				T result = caseBooleanValueExpression(booleanValueExpression);
				if (result == null) result = casePrimitiveValueExpression(booleanValueExpression);
				if (result == null) result = caseAtomicExpression(booleanValueExpression);
				if (result == null) result = caseExpression(booleanValueExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.INTEGER_VALUE_EXPRESSION: {
				IntegerValueExpression integerValueExpression = (IntegerValueExpression)theEObject;
				T result = caseIntegerValueExpression(integerValueExpression);
				if (result == null) result = casePrimitiveValueExpression(integerValueExpression);
				if (result == null) result = caseAtomicExpression(integerValueExpression);
				if (result == null) result = caseExpression(integerValueExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.ENUM_VALUE_EXPRESSION: {
				EnumValueExpression enumValueExpression = (EnumValueExpression)theEObject;
				T result = caseEnumValueExpression(enumValueExpression);
				if (result == null) result = casePrimitiveValueExpression(enumValueExpression);
				if (result == null) result = caseAtomicExpression(enumValueExpression);
				if (result == null) result = caseExpression(enumValueExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.EMPTY_VALUE_EXPRESSION: {
				EmptyValueExpression emptyValueExpression = (EmptyValueExpression)theEObject;
				T result = caseEmptyValueExpression(emptyValueExpression);
				if (result == null) result = casePrimitiveValueExpression(emptyValueExpression);
				if (result == null) result = caseAtomicExpression(emptyValueExpression);
				if (result == null) result = caseExpression(emptyValueExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.OBJECT_VALUE_EXPRESSION: {
				ObjectValueExpression objectValueExpression = (ObjectValueExpression)theEObject;
				T result = caseObjectValueExpression(objectValueExpression);
				if (result == null) result = caseAtomicExpression(objectValueExpression);
				if (result == null) result = caseExpression(objectValueExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.VARIABLE_EXPRESSION: {
				VariableExpression variableExpression = (VariableExpression)theEObject;
				T result = caseVariableExpression(variableExpression);
				if (result == null) result = caseAtomicExpression(variableExpression);
				if (result == null) result = caseExpression(variableExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.PATH: {
				Path path = (Path)theEObject;
				T result = casePath(path);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.FEATURE_PATH: {
				FeaturePath featurePath = (FeaturePath)theEObject;
				T result = caseFeaturePath(featurePath);
				if (result == null) result = casePath(featurePath);
				if (result == null) result = caseReflectiveSupport(featurePath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.OPERATION_PATH: {
				OperationPath operationPath = (OperationPath)theEObject;
				T result = caseOperationPath(operationPath);
				if (result == null) result = casePath(operationPath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.LOOP_PATH: {
				LoopPath loopPath = (LoopPath)theEObject;
				T result = caseLoopPath(loopPath);
				if (result == null) result = casePath(loopPath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.POSITION_PATH: {
				PositionPath positionPath = (PositionPath)theEObject;
				T result = casePositionPath(positionPath);
				if (result == null) result = casePath(positionPath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.CALL_STATEMENT: {
				CallStatement callStatement = (CallStatement)theEObject;
				T result = caseCallStatement(callStatement);
				if (result == null) result = caseStatement(callStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.TRANSFORMATION: {
				Transformation transformation = (Transformation)theEObject;
				T result = caseTransformation(transformation);
				if (result == null) result = caseNamedElement(transformation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.ENTRY_RULE_PARAMETER: {
				EntryRuleParameter entryRuleParameter = (EntryRuleParameter)theEObject;
				T result = caseEntryRuleParameter(entryRuleParameter);
				if (result == null) result = caseExpression(entryRuleParameter);
				if (result == null) result = caseDomainElement(entryRuleParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.FOR_EACH_STATEMENT: {
				ForEachStatement forEachStatement = (ForEachStatement)theEObject;
				T result = caseForEachStatement(forEachStatement);
				if (result == null) result = caseStatement(forEachStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.DELETE_NODE_STATEMENT: {
				DeleteNodeStatement deleteNodeStatement = (DeleteNodeStatement)theEObject;
				T result = caseDeleteNodeStatement(deleteNodeStatement);
				if (result == null) result = caseStatement(deleteNodeStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.DELETE_LINK_STATEMENT: {
				DeleteLinkStatement deleteLinkStatement = (DeleteLinkStatement)theEObject;
				T result = caseDeleteLinkStatement(deleteLinkStatement);
				if (result == null) result = caseStatement(deleteLinkStatement);
				if (result == null) result = caseReflectiveSupport(deleteLinkStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT: {
				EnforceNodeStatement enforceNodeStatement = (EnforceNodeStatement)theEObject;
				T result = caseEnforceNodeStatement(enforceNodeStatement);
				if (result == null) result = caseStatement(enforceNodeStatement);
				if (result == null) result = caseDomainElement(enforceNodeStatement);
				if (result == null) result = caseNullable(enforceNodeStatement);
				if (result == null) result = caseReflectiveSupport(enforceNodeStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT: {
				EnforceLinkStatement enforceLinkStatement = (EnforceLinkStatement)theEObject;
				T result = caseEnforceLinkStatement(enforceLinkStatement);
				if (result == null) result = caseStatement(enforceLinkStatement);
				if (result == null) result = caseDomainElement(enforceLinkStatement);
				if (result == null) result = caseReflectiveSupport(enforceLinkStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.OCL_COLLECTION_TYPE: {
				OclCollectionType oclCollectionType = (OclCollectionType)theEObject;
				T result = caseOclCollectionType(oclCollectionType);
				if (result == null) result = caseEClass(oclCollectionType);
				if (result == null) result = caseEClassifier(oclCollectionType);
				if (result == null) result = caseENamedElement(oclCollectionType);
				if (result == null) result = caseEModelElement(oclCollectionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.OCL_COLLECTION: {
				OclCollection oclCollection = (OclCollection)theEObject;
				T result = caseOclCollection(oclCollection);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.MATCH_PATTERN: {
				MatchPattern matchPattern = (MatchPattern)theEObject;
				T result = caseMatchPattern(matchPattern);
				if (result == null) result = caseStatement(matchPattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.CHECK_EXPRESSION_STATEMENT: {
				CheckExpressionStatement checkExpressionStatement = (CheckExpressionStatement)theEObject;
				T result = caseCheckExpressionStatement(checkExpressionStatement);
				if (result == null) result = caseStatement(checkExpressionStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.ENFORCE_EXPRESSION_STATEMENT: {
				EnforceExpressionStatement enforceExpressionStatement = (EnforceExpressionStatement)theEObject;
				T result = caseEnforceExpressionStatement(enforceExpressionStatement);
				if (result == null) result = caseStatement(enforceExpressionStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.FUNCTION: {
				Function function = (Function)theEObject;
				T result = caseFunction(function);
				if (result == null) result = caseCallable(function);
				if (result == null) result = caseNamedElement(function);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.SOLVE_CONSTRAINT_STATEMENT: {
				SolveConstraintStatement solveConstraintStatement = (SolveConstraintStatement)theEObject;
				T result = caseSolveConstraintStatement(solveConstraintStatement);
				if (result == null) result = caseStatement(solveConstraintStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.COMMAND_STATEMENT: {
				CommandStatement commandStatement = (CommandStatement)theEObject;
				T result = caseCommandStatement(commandStatement);
				if (result == null) result = caseStatement(commandStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Xmu2corePackage.REFLECTIVE_SUPPORT: {
				ReflectiveSupport reflectiveSupport = (ReflectiveSupport)theEObject;
				T result = caseReflectiveSupport(reflectiveSupport);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nullable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nullable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNullable(Nullable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Callable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Callable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallable(Callable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Procedure</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Procedure</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcedure(Procedure object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatement(Statement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Align Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Align Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlignStatement(AlignStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCaseStatement(CaseStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCaseClause(CaseClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case Pattern Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Pattern Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCasePatternClause(CasePatternClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case Expression Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Expression Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCaseExpressionClause(CaseExpressionClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case Statement Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Statement Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCaseStatementClause(CaseStatementClause object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePattern(Pattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternNode(PatternNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternExpression(PatternExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Pattern Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Pattern Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectPatternExpression(ObjectPatternExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Pattern Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Pattern Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyPatternExpression(PropertyPatternExpression object) {
		return null;
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
	 * Returns the result of interpreting the object as an instance of '<em>Type Cast Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Cast Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeCastExpression(TypeCastExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Value Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Value Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveValueExpression(PrimitiveValueExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Value Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Value Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringValueExpression(StringValueExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Value Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Value Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanValueExpression(BooleanValueExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Value Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Value Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerValueExpression(IntegerValueExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Value Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Value Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumValueExpression(EnumValueExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Empty Value Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Empty Value Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmptyValueExpression(EmptyValueExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Value Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Value Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectValueExpression(ObjectValueExpression object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Call Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallStatement(CallStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transformation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransformation(Transformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entry Rule Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entry Rule Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntryRuleParameter(EntryRuleParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>For Each Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Each Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForEachStatement(ForEachStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Node Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Node Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeleteNodeStatement(DeleteNodeStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Link Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Link Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeleteLinkStatement(DeleteLinkStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enforce Node Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enforce Node Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnforceNodeStatement(EnforceNodeStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enforce Link Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enforce Link Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnforceLinkStatement(EnforceLinkStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Collection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclCollectionType(OclCollectionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ocl Collection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ocl Collection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOclCollection(OclCollection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Match Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Match Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMatchPattern(MatchPattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Check Expression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Check Expression Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCheckExpressionStatement(CheckExpressionStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enforce Expression Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enforce Expression Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnforceExpressionStatement(EnforceExpressionStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunction(Function object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Solve Constraint Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Solve Constraint Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSolveConstraintStatement(SolveConstraintStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Command Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Command Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommandStatement(CommandStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reflective Support</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reflective Support</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReflectiveSupport(ReflectiveSupport object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Domain Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Domain Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDomainElement(DomainElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EModel Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEModelElement(EModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ENamed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ENamed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseENamedElement(ENamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EClassifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EClassifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEClassifier(EClassifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EClass</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EClass</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEClass(EClass object) {
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

} //Xmu2coreSwitch
