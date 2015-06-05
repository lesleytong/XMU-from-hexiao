/**
 */
package edu.ustb.sei.mde.xmu.util;

import edu.ustb.sei.mde.xmu.*;

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
 * @see edu.ustb.sei.mde.xmu.XmuPackage
 * @generated
 */
public class XmuSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static XmuPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XmuSwitch() {
		if (modelPackage == null) {
			modelPackage = XmuPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
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
			case XmuPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				T result = caseVariable(variable);
				if (result == null) result = caseNamedElement(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.OBJECT_VARIABLE: {
				ObjectVariable objectVariable = (ObjectVariable)theEObject;
				T result = caseObjectVariable(objectVariable);
				if (result == null) result = caseVariable(objectVariable);
				if (result == null) result = caseNamedElement(objectVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.PRIMITIVE_VARIABLE: {
				PrimitiveVariable primitiveVariable = (PrimitiveVariable)theEObject;
				T result = casePrimitiveVariable(primitiveVariable);
				if (result == null) result = caseVariable(primitiveVariable);
				if (result == null) result = caseNamedElement(primitiveVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.RULE: {
				Rule rule = (Rule)theEObject;
				T result = caseRule(rule);
				if (result == null) result = caseNamedElement(rule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.FOR_STATEMENT: {
				ForStatement forStatement = (ForStatement)theEObject;
				T result = caseForStatement(forStatement);
				if (result == null) result = caseStatement(forStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.UPDATE: {
				Update update = (Update)theEObject;
				T result = caseUpdate(update);
				if (result == null) result = caseStatement(update);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.DELETE_NODE: {
				DeleteNode deleteNode = (DeleteNode)theEObject;
				T result = caseDeleteNode(deleteNode);
				if (result == null) result = caseUpdate(deleteNode);
				if (result == null) result = caseStatement(deleteNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.DELETE_LINK: {
				DeleteLink deleteLink = (DeleteLink)theEObject;
				T result = caseDeleteLink(deleteLink);
				if (result == null) result = caseUpdate(deleteLink);
				if (result == null) result = caseStatement(deleteLink);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.UPDATE_PATTERN: {
				UpdatePattern updatePattern = (UpdatePattern)theEObject;
				T result = caseUpdatePattern(updatePattern);
				if (result == null) result = casePattern(updatePattern);
				if (result == null) result = caseUpdate(updatePattern);
				if (result == null) result = caseTaggedElement(updatePattern);
				if (result == null) result = caseStatement(updatePattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.PATTERN: {
				Pattern pattern = (Pattern)theEObject;
				T result = casePattern(pattern);
				if (result == null) result = caseTaggedElement(pattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.PATTERN_NODE: {
				PatternNode patternNode = (PatternNode)theEObject;
				T result = casePatternNode(patternNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.PATTERN_EXPR: {
				PatternExpr patternExpr = (PatternExpr)theEObject;
				T result = casePatternExpr(patternExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.PATTERN_REFERENCE_EXPR: {
				PatternReferenceExpr patternReferenceExpr = (PatternReferenceExpr)theEObject;
				T result = casePatternReferenceExpr(patternReferenceExpr);
				if (result == null) result = casePatternExpr(patternReferenceExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.PATTERN_EQUAL_EXPR: {
				PatternEqualExpr patternEqualExpr = (PatternEqualExpr)theEObject;
				T result = casePatternEqualExpr(patternEqualExpr);
				if (result == null) result = casePatternExpr(patternEqualExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.EXPR: {
				Expr expr = (Expr)theEObject;
				T result = caseExpr(expr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.VARIABLE_EXP: {
				VariableExp variableExp = (VariableExp)theEObject;
				T result = caseVariableExp(variableExp);
				if (result == null) result = caseAtomicExpr(variableExp);
				if (result == null) result = caseUnaryExprChild(variableExp);
				if (result == null) result = caseMultiplicativeExprChild(variableExp);
				if (result == null) result = caseAdditiveExprChild(variableExp);
				if (result == null) result = caseRelationalExprChild(variableExp);
				if (result == null) result = caseBooleanAndExprChild(variableExp);
				if (result == null) result = caseBooleanOrExprChild(variableExp);
				if (result == null) result = caseExpr(variableExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.CONSTANT_EXPR: {
				ConstantExpr constantExpr = (ConstantExpr)theEObject;
				T result = caseConstantExpr(constantExpr);
				if (result == null) result = caseAtomicExpr(constantExpr);
				if (result == null) result = caseUnaryExprChild(constantExpr);
				if (result == null) result = caseMultiplicativeExprChild(constantExpr);
				if (result == null) result = caseAdditiveExprChild(constantExpr);
				if (result == null) result = caseRelationalExprChild(constantExpr);
				if (result == null) result = caseBooleanAndExprChild(constantExpr);
				if (result == null) result = caseBooleanOrExprChild(constantExpr);
				if (result == null) result = caseExpr(constantExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.EMPTY_LITERAL: {
				EmptyLiteral emptyLiteral = (EmptyLiteral)theEObject;
				T result = caseEmptyLiteral(emptyLiteral);
				if (result == null) result = caseConstantExpr(emptyLiteral);
				if (result == null) result = caseAtomicExpr(emptyLiteral);
				if (result == null) result = caseUnaryExprChild(emptyLiteral);
				if (result == null) result = caseMultiplicativeExprChild(emptyLiteral);
				if (result == null) result = caseAdditiveExprChild(emptyLiteral);
				if (result == null) result = caseRelationalExprChild(emptyLiteral);
				if (result == null) result = caseBooleanAndExprChild(emptyLiteral);
				if (result == null) result = caseBooleanOrExprChild(emptyLiteral);
				if (result == null) result = caseExpr(emptyLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.STRING_LITERAL: {
				StringLiteral stringLiteral = (StringLiteral)theEObject;
				T result = caseStringLiteral(stringLiteral);
				if (result == null) result = caseConstantExpr(stringLiteral);
				if (result == null) result = caseAtomicExpr(stringLiteral);
				if (result == null) result = caseUnaryExprChild(stringLiteral);
				if (result == null) result = caseMultiplicativeExprChild(stringLiteral);
				if (result == null) result = caseAdditiveExprChild(stringLiteral);
				if (result == null) result = caseRelationalExprChild(stringLiteral);
				if (result == null) result = caseBooleanAndExprChild(stringLiteral);
				if (result == null) result = caseBooleanOrExprChild(stringLiteral);
				if (result == null) result = caseExpr(stringLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.INTEGER_LITERAL: {
				IntegerLiteral integerLiteral = (IntegerLiteral)theEObject;
				T result = caseIntegerLiteral(integerLiteral);
				if (result == null) result = caseConstantExpr(integerLiteral);
				if (result == null) result = caseAtomicExpr(integerLiteral);
				if (result == null) result = caseUnaryExprChild(integerLiteral);
				if (result == null) result = caseMultiplicativeExprChild(integerLiteral);
				if (result == null) result = caseAdditiveExprChild(integerLiteral);
				if (result == null) result = caseRelationalExprChild(integerLiteral);
				if (result == null) result = caseBooleanAndExprChild(integerLiteral);
				if (result == null) result = caseBooleanOrExprChild(integerLiteral);
				if (result == null) result = caseExpr(integerLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.BOOLEAN_LITERAL: {
				BooleanLiteral booleanLiteral = (BooleanLiteral)theEObject;
				T result = caseBooleanLiteral(booleanLiteral);
				if (result == null) result = caseConstantExpr(booleanLiteral);
				if (result == null) result = caseAtomicExpr(booleanLiteral);
				if (result == null) result = caseUnaryExprChild(booleanLiteral);
				if (result == null) result = caseMultiplicativeExprChild(booleanLiteral);
				if (result == null) result = caseAdditiveExprChild(booleanLiteral);
				if (result == null) result = caseRelationalExprChild(booleanLiteral);
				if (result == null) result = caseBooleanAndExprChild(booleanLiteral);
				if (result == null) result = caseBooleanOrExprChild(booleanLiteral);
				if (result == null) result = caseExpr(booleanLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.ENUM_LITERAL: {
				EnumLiteral enumLiteral = (EnumLiteral)theEObject;
				T result = caseEnumLiteral(enumLiteral);
				if (result == null) result = caseConstantExpr(enumLiteral);
				if (result == null) result = caseAtomicExpr(enumLiteral);
				if (result == null) result = caseUnaryExprChild(enumLiteral);
				if (result == null) result = caseMultiplicativeExprChild(enumLiteral);
				if (result == null) result = caseAdditiveExprChild(enumLiteral);
				if (result == null) result = caseRelationalExprChild(enumLiteral);
				if (result == null) result = caseBooleanAndExprChild(enumLiteral);
				if (result == null) result = caseBooleanOrExprChild(enumLiteral);
				if (result == null) result = caseExpr(enumLiteral);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.VSTATEMENT: {
				VStatement vStatement = (VStatement)theEObject;
				T result = caseVStatement(vStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.BLOCK_STATEMENT: {
				BlockStatement blockStatement = (BlockStatement)theEObject;
				T result = caseBlockStatement(blockStatement);
				if (result == null) result = caseStatement(blockStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.SWITCH_STATEMENT: {
				SwitchStatement switchStatement = (SwitchStatement)theEObject;
				T result = caseSwitchStatement(switchStatement);
				if (result == null) result = caseStatement(switchStatement);
				if (result == null) result = caseTaggedElement(switchStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.TAGGED_ELEMENT: {
				TaggedElement taggedElement = (TaggedElement)theEObject;
				T result = caseTaggedElement(taggedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.CASE_SUB_STATEMENT: {
				CaseSubStatement caseSubStatement = (CaseSubStatement)theEObject;
				T result = caseCaseSubStatement(caseSubStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.CASE_PATTERN_STATEMENT: {
				CasePatternStatement casePatternStatement = (CasePatternStatement)theEObject;
				T result = caseCasePatternStatement(casePatternStatement);
				if (result == null) result = caseCaseSubStatement(casePatternStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.CASE_VALUE_STATEMENT: {
				CaseValueStatement caseValueStatement = (CaseValueStatement)theEObject;
				T result = caseCaseValueStatement(caseValueStatement);
				if (result == null) result = caseCaseSubStatement(caseValueStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.XMU_MODEL: {
				XMUModel xmuModel = (XMUModel)theEObject;
				T result = caseXMUModel(xmuModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.PARAMETER: {
				Parameter parameter = (Parameter)theEObject;
				T result = caseParameter(parameter);
				if (result == null) result = caseTaggedElement(parameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.RULE_CALL_STATEMENT: {
				RuleCallStatement ruleCallStatement = (RuleCallStatement)theEObject;
				T result = caseRuleCallStatement(ruleCallStatement);
				if (result == null) result = caseStatement(ruleCallStatement);
				if (result == null) result = caseTaggedElement(ruleCallStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.UPDATED_STATEMENT: {
				UpdatedStatement updatedStatement = (UpdatedStatement)theEObject;
				T result = caseUpdatedStatement(updatedStatement);
				if (result == null) result = caseStatement(updatedStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.BOOLEAN_OR_EXPR: {
				BooleanOrExpr booleanOrExpr = (BooleanOrExpr)theEObject;
				T result = caseBooleanOrExpr(booleanOrExpr);
				if (result == null) result = caseExpr(booleanOrExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.BOOLEAN_OR_EXPR_CHILD: {
				BooleanOrExprChild booleanOrExprChild = (BooleanOrExprChild)theEObject;
				T result = caseBooleanOrExprChild(booleanOrExprChild);
				if (result == null) result = caseExpr(booleanOrExprChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.BOOLEAN_AND_EXPR: {
				BooleanAndExpr booleanAndExpr = (BooleanAndExpr)theEObject;
				T result = caseBooleanAndExpr(booleanAndExpr);
				if (result == null) result = caseBooleanOrExprChild(booleanAndExpr);
				if (result == null) result = caseExpr(booleanAndExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.BOOLEAN_AND_EXPR_CHILD: {
				BooleanAndExprChild booleanAndExprChild = (BooleanAndExprChild)theEObject;
				T result = caseBooleanAndExprChild(booleanAndExprChild);
				if (result == null) result = caseBooleanOrExprChild(booleanAndExprChild);
				if (result == null) result = caseExpr(booleanAndExprChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.RELATIONAL_EXPR: {
				RelationalExpr relationalExpr = (RelationalExpr)theEObject;
				T result = caseRelationalExpr(relationalExpr);
				if (result == null) result = caseBooleanAndExprChild(relationalExpr);
				if (result == null) result = caseBooleanOrExprChild(relationalExpr);
				if (result == null) result = caseExpr(relationalExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.RELATIONAL_EXPR_CHILD: {
				RelationalExprChild relationalExprChild = (RelationalExprChild)theEObject;
				T result = caseRelationalExprChild(relationalExprChild);
				if (result == null) result = caseBooleanAndExprChild(relationalExprChild);
				if (result == null) result = caseBooleanOrExprChild(relationalExprChild);
				if (result == null) result = caseExpr(relationalExprChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.ADDITIVE_EXPR: {
				AdditiveExpr additiveExpr = (AdditiveExpr)theEObject;
				T result = caseAdditiveExpr(additiveExpr);
				if (result == null) result = caseRelationalExprChild(additiveExpr);
				if (result == null) result = caseBooleanAndExprChild(additiveExpr);
				if (result == null) result = caseBooleanOrExprChild(additiveExpr);
				if (result == null) result = caseExpr(additiveExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.ADDITIVE_EXPR_CHILD: {
				AdditiveExprChild additiveExprChild = (AdditiveExprChild)theEObject;
				T result = caseAdditiveExprChild(additiveExprChild);
				if (result == null) result = caseRelationalExprChild(additiveExprChild);
				if (result == null) result = caseBooleanAndExprChild(additiveExprChild);
				if (result == null) result = caseBooleanOrExprChild(additiveExprChild);
				if (result == null) result = caseExpr(additiveExprChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.MULTIPLICATIVE_EXPR: {
				MultiplicativeExpr multiplicativeExpr = (MultiplicativeExpr)theEObject;
				T result = caseMultiplicativeExpr(multiplicativeExpr);
				if (result == null) result = caseAdditiveExprChild(multiplicativeExpr);
				if (result == null) result = caseRelationalExprChild(multiplicativeExpr);
				if (result == null) result = caseBooleanAndExprChild(multiplicativeExpr);
				if (result == null) result = caseBooleanOrExprChild(multiplicativeExpr);
				if (result == null) result = caseExpr(multiplicativeExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.MULTIPLICATIVE_EXPR_CHILD: {
				MultiplicativeExprChild multiplicativeExprChild = (MultiplicativeExprChild)theEObject;
				T result = caseMultiplicativeExprChild(multiplicativeExprChild);
				if (result == null) result = caseAdditiveExprChild(multiplicativeExprChild);
				if (result == null) result = caseRelationalExprChild(multiplicativeExprChild);
				if (result == null) result = caseBooleanAndExprChild(multiplicativeExprChild);
				if (result == null) result = caseBooleanOrExprChild(multiplicativeExprChild);
				if (result == null) result = caseExpr(multiplicativeExprChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.UNARY_EXPR: {
				UnaryExpr unaryExpr = (UnaryExpr)theEObject;
				T result = caseUnaryExpr(unaryExpr);
				if (result == null) result = caseMultiplicativeExprChild(unaryExpr);
				if (result == null) result = caseAdditiveExprChild(unaryExpr);
				if (result == null) result = caseRelationalExprChild(unaryExpr);
				if (result == null) result = caseBooleanAndExprChild(unaryExpr);
				if (result == null) result = caseBooleanOrExprChild(unaryExpr);
				if (result == null) result = caseExpr(unaryExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.UNARY_EXPR_CHILD: {
				UnaryExprChild unaryExprChild = (UnaryExprChild)theEObject;
				T result = caseUnaryExprChild(unaryExprChild);
				if (result == null) result = caseMultiplicativeExprChild(unaryExprChild);
				if (result == null) result = caseAdditiveExprChild(unaryExprChild);
				if (result == null) result = caseRelationalExprChild(unaryExprChild);
				if (result == null) result = caseBooleanAndExprChild(unaryExprChild);
				if (result == null) result = caseBooleanOrExprChild(unaryExprChild);
				if (result == null) result = caseExpr(unaryExprChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.ATOMIC_EXPR: {
				AtomicExpr atomicExpr = (AtomicExpr)theEObject;
				T result = caseAtomicExpr(atomicExpr);
				if (result == null) result = caseUnaryExprChild(atomicExpr);
				if (result == null) result = caseMultiplicativeExprChild(atomicExpr);
				if (result == null) result = caseAdditiveExprChild(atomicExpr);
				if (result == null) result = caseRelationalExprChild(atomicExpr);
				if (result == null) result = caseBooleanAndExprChild(atomicExpr);
				if (result == null) result = caseBooleanOrExprChild(atomicExpr);
				if (result == null) result = caseExpr(atomicExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.PAREN_EXPR: {
				ParenExpr parenExpr = (ParenExpr)theEObject;
				T result = caseParenExpr(parenExpr);
				if (result == null) result = caseAtomicExpr(parenExpr);
				if (result == null) result = caseUnaryExprChild(parenExpr);
				if (result == null) result = caseMultiplicativeExprChild(parenExpr);
				if (result == null) result = caseAdditiveExprChild(parenExpr);
				if (result == null) result = caseRelationalExprChild(parenExpr);
				if (result == null) result = caseBooleanAndExprChild(parenExpr);
				if (result == null) result = caseBooleanOrExprChild(parenExpr);
				if (result == null) result = caseExpr(parenExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.PATH: {
				Path path = (Path)theEObject;
				T result = casePath(path);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.HELPER_PATH: {
				HelperPath helperPath = (HelperPath)theEObject;
				T result = caseHelperPath(helperPath);
				if (result == null) result = casePath(helperPath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.FEATURE_PATH: {
				FeaturePath featurePath = (FeaturePath)theEObject;
				T result = caseFeaturePath(featurePath);
				if (result == null) result = casePath(featurePath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.OPERATION_PATH: {
				OperationPath operationPath = (OperationPath)theEObject;
				T result = caseOperationPath(operationPath);
				if (result == null) result = casePath(operationPath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.LOOP_PATH: {
				LoopPath loopPath = (LoopPath)theEObject;
				T result = caseLoopPath(loopPath);
				if (result == null) result = casePath(loopPath);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.START_STATEMENT: {
				StartStatement startStatement = (StartStatement)theEObject;
				T result = caseStartStatement(startStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.START_ROOT: {
				StartRoot startRoot = (StartRoot)theEObject;
				T result = caseStartRoot(startRoot);
				if (result == null) result = caseTaggedElement(startRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.ERESOURCE: {
				EResource eResource = (EResource)theEObject;
				T result = caseEResource(eResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.PRINT_STATEMENT: {
				PrintStatement printStatement = (PrintStatement)theEObject;
				T result = casePrintStatement(printStatement);
				if (result == null) result = caseStatement(printStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.ALL_INSTANCE_EXPR: {
				AllInstanceExpr allInstanceExpr = (AllInstanceExpr)theEObject;
				T result = caseAllInstanceExpr(allInstanceExpr);
				if (result == null) result = caseExpr(allInstanceExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.ESET: {
				ESet eSet = (ESet)theEObject;
				T result = caseESet(eSet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.OBJECT_PATH_EXPR: {
				ObjectPathExpr objectPathExpr = (ObjectPathExpr)theEObject;
				T result = caseObjectPathExpr(objectPathExpr);
				if (result == null) result = caseExpr(objectPathExpr);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.INITIAL_MAPPING_STATEMENT: {
				InitialMappingStatement initialMappingStatement = (InitialMappingStatement)theEObject;
				T result = caseInitialMappingStatement(initialMappingStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case XmuPackage.HELPER_MAPPING: {
				HelperMapping helperMapping = (HelperMapping)theEObject;
				T result = caseHelperMapping(helperMapping);
				if (result == null) result = caseNamedElement(helperMapping);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
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
	 * Returns the result of interpreting the object as an instance of '<em>Object Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectVariable(ObjectVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveVariable(PrimitiveVariable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRule(Rule object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>For Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForStatement(ForStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdate(Update object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeleteNode(DeleteNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Delete Link</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Delete Link</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeleteLink(DeleteLink object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Update Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Update Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdatePattern(UpdatePattern object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternExpr(PatternExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Reference Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Reference Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternReferenceExpr(PatternReferenceExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern Equal Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern Equal Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternEqualExpr(PatternEqualExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpr(Expr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableExp(VariableExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constant Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constant Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstantExpr(ConstantExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Empty Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Empty Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmptyLiteral(EmptyLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteral(StringLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerLiteral(IntegerLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteral(BooleanLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enum Literal</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enum Literal</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEnumLiteral(EnumLiteral object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>VStatement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VStatement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVStatement(VStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlockStatement(BlockStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Switch Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSwitchStatement(SwitchStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tagged Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tagged Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaggedElement(TaggedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case Sub Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Sub Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCaseSubStatement(CaseSubStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case Pattern Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Pattern Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCasePatternStatement(CasePatternStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Case Value Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Value Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCaseValueStatement(CaseValueStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XMU Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XMU Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXMUModel(XMUModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameter(Parameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule Call Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule Call Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleCallStatement(RuleCallStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Updated Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Updated Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpdatedStatement(UpdatedStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Or Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Or Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanOrExpr(BooleanOrExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Or Expr Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Or Expr Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanOrExprChild(BooleanOrExprChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean And Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean And Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanAndExpr(BooleanAndExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean And Expr Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean And Expr Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanAndExprChild(BooleanAndExprChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relational Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relational Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationalExpr(RelationalExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relational Expr Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relational Expr Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationalExprChild(RelationalExprChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Additive Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Additive Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdditiveExpr(AdditiveExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Additive Expr Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Additive Expr Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdditiveExprChild(AdditiveExprChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplicative Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplicative Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplicativeExpr(MultiplicativeExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplicative Expr Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplicative Expr Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplicativeExprChild(MultiplicativeExprChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryExpr(UnaryExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Expr Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Expr Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryExprChild(UnaryExprChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Atomic Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Atomic Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAtomicExpr(AtomicExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Paren Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Paren Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParenExpr(ParenExpr object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Helper Path</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Helper Path</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHelperPath(HelperPath object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Start Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStartStatement(StartStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Start Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStartRoot(StartRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EResource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EResource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEResource(EResource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Print Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Print Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrintStatement(PrintStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>All Instance Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>All Instance Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllInstanceExpr(AllInstanceExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ESet</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ESet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseESet(ESet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Path Expr</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Path Expr</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectPathExpr(ObjectPathExpr object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Initial Mapping Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Initial Mapping Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInitialMappingStatement(InitialMappingStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Helper Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Helper Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHelperMapping(HelperMapping object) {
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

} //XmuSwitch
