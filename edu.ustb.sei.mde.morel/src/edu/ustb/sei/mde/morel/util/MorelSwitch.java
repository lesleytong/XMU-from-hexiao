/**
 */
package edu.ustb.sei.mde.morel.util;

import edu.ustb.sei.mde.morel.*;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
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
 * @see edu.ustb.sei.mde.morel.MorelPackage
 * @generated
 */
public class MorelSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MorelPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MorelSwitch() {
		if (modelPackage == null) {
			modelPackage = MorelPackage.eINSTANCE;
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
			case MorelPackage.NAMED_ELEMENT: {
				NamedElement namedElement = (NamedElement)theEObject;
				T result = caseNamedElement(namedElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.SECTION: {
				Section section = (Section)theEObject;
				T result = caseSection(section);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.PATTERN: {
				Pattern pattern = (Pattern)theEObject;
				T result = casePattern(pattern);
				if (result == null) result = caseSection(pattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.CLAUSE: {
				Clause clause = (Clause)theEObject;
				T result = caseClause(clause);
				if (result == null) result = caseSection(clause);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.VARIABLE: {
				Variable variable = (Variable)theEObject;
				T result = caseVariable(variable);
				if (result == null) result = caseNamedElement(variable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.OBJECT_VARIABLE: {
				ObjectVariable objectVariable = (ObjectVariable)theEObject;
				T result = caseObjectVariable(objectVariable);
				if (result == null) result = caseVariable(objectVariable);
				if (result == null) result = caseNamedElement(objectVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.PRIMITIVE_VARIABLE: {
				PrimitiveVariable primitiveVariable = (PrimitiveVariable)theEObject;
				T result = casePrimitiveVariable(primitiveVariable);
				if (result == null) result = caseVariable(primitiveVariable);
				if (result == null) result = caseNamedElement(primitiveVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.LINK_CONSTRAINT: {
				LinkConstraint linkConstraint = (LinkConstraint)theEObject;
				T result = caseLinkConstraint(linkConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.SIMPLE_LINK_CONSTRAINT: {
				SimpleLinkConstraint simpleLinkConstraint = (SimpleLinkConstraint)theEObject;
				T result = caseSimpleLinkConstraint(simpleLinkConstraint);
				if (result == null) result = caseLinkConstraint(simpleLinkConstraint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.QUERY_MODEL: {
				QueryModel queryModel = (QueryModel)theEObject;
				T result = caseQueryModel(queryModel);
				if (result == null) result = caseUnit(queryModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.TYPED_MODEL: {
				TypedModel typedModel = (TypedModel)theEObject;
				T result = caseTypedModel(typedModel);
				if (result == null) result = caseNamedElement(typedModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.QUERY: {
				Query query = (Query)theEObject;
				T result = caseQuery(query);
				if (result == null) result = casePattern(query);
				if (result == null) result = caseNamedElement(query);
				if (result == null) result = caseSection(query);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.UNIT: {
				Unit unit = (Unit)theEObject;
				T result = caseUnit(unit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.EXPRESSION: {
				Expression expression = (Expression)theEObject;
				T result = caseExpression(expression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.ATOMIC_EXP: {
				AtomicExp atomicExp = (AtomicExp)theEObject;
				T result = caseAtomicExp(atomicExp);
				if (result == null) result = caseUnaryExpChild(atomicExp);
				if (result == null) result = caseMultiplicativeExpChild(atomicExp);
				if (result == null) result = caseAdditiveExpChild(atomicExp);
				if (result == null) result = caseRelationalExpChild(atomicExp);
				if (result == null) result = caseBooleanAndExpChild(atomicExp);
				if (result == null) result = caseBooleanOrExpChild(atomicExp);
				if (result == null) result = caseBooleanImpliesExpChild(atomicExp);
				if (result == null) result = caseExpression(atomicExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.LITERAL_EXP: {
				LiteralExp literalExp = (LiteralExp)theEObject;
				T result = caseLiteralExp(literalExp);
				if (result == null) result = caseAtomicExp(literalExp);
				if (result == null) result = caseUnaryExpChild(literalExp);
				if (result == null) result = caseMultiplicativeExpChild(literalExp);
				if (result == null) result = caseAdditiveExpChild(literalExp);
				if (result == null) result = caseRelationalExpChild(literalExp);
				if (result == null) result = caseBooleanAndExpChild(literalExp);
				if (result == null) result = caseBooleanOrExpChild(literalExp);
				if (result == null) result = caseBooleanImpliesExpChild(literalExp);
				if (result == null) result = caseExpression(literalExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.STRING_LITERAL_EXP: {
				StringLiteralExp stringLiteralExp = (StringLiteralExp)theEObject;
				T result = caseStringLiteralExp(stringLiteralExp);
				if (result == null) result = caseLiteralExp(stringLiteralExp);
				if (result == null) result = caseAtomicExp(stringLiteralExp);
				if (result == null) result = caseUnaryExpChild(stringLiteralExp);
				if (result == null) result = caseMultiplicativeExpChild(stringLiteralExp);
				if (result == null) result = caseAdditiveExpChild(stringLiteralExp);
				if (result == null) result = caseRelationalExpChild(stringLiteralExp);
				if (result == null) result = caseBooleanAndExpChild(stringLiteralExp);
				if (result == null) result = caseBooleanOrExpChild(stringLiteralExp);
				if (result == null) result = caseBooleanImpliesExpChild(stringLiteralExp);
				if (result == null) result = caseExpression(stringLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.INTEGER_LITERAL_EXP: {
				IntegerLiteralExp integerLiteralExp = (IntegerLiteralExp)theEObject;
				T result = caseIntegerLiteralExp(integerLiteralExp);
				if (result == null) result = caseLiteralExp(integerLiteralExp);
				if (result == null) result = caseAtomicExp(integerLiteralExp);
				if (result == null) result = caseUnaryExpChild(integerLiteralExp);
				if (result == null) result = caseMultiplicativeExpChild(integerLiteralExp);
				if (result == null) result = caseAdditiveExpChild(integerLiteralExp);
				if (result == null) result = caseRelationalExpChild(integerLiteralExp);
				if (result == null) result = caseBooleanAndExpChild(integerLiteralExp);
				if (result == null) result = caseBooleanOrExpChild(integerLiteralExp);
				if (result == null) result = caseBooleanImpliesExpChild(integerLiteralExp);
				if (result == null) result = caseExpression(integerLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.REAL_LITERAL_EXP: {
				RealLiteralExp realLiteralExp = (RealLiteralExp)theEObject;
				T result = caseRealLiteralExp(realLiteralExp);
				if (result == null) result = caseLiteralExp(realLiteralExp);
				if (result == null) result = caseAtomicExp(realLiteralExp);
				if (result == null) result = caseUnaryExpChild(realLiteralExp);
				if (result == null) result = caseMultiplicativeExpChild(realLiteralExp);
				if (result == null) result = caseAdditiveExpChild(realLiteralExp);
				if (result == null) result = caseRelationalExpChild(realLiteralExp);
				if (result == null) result = caseBooleanAndExpChild(realLiteralExp);
				if (result == null) result = caseBooleanOrExpChild(realLiteralExp);
				if (result == null) result = caseBooleanImpliesExpChild(realLiteralExp);
				if (result == null) result = caseExpression(realLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.BOOLEAN_LITERAL_EXP: {
				BooleanLiteralExp booleanLiteralExp = (BooleanLiteralExp)theEObject;
				T result = caseBooleanLiteralExp(booleanLiteralExp);
				if (result == null) result = caseLiteralExp(booleanLiteralExp);
				if (result == null) result = caseAtomicExp(booleanLiteralExp);
				if (result == null) result = caseUnaryExpChild(booleanLiteralExp);
				if (result == null) result = caseMultiplicativeExpChild(booleanLiteralExp);
				if (result == null) result = caseAdditiveExpChild(booleanLiteralExp);
				if (result == null) result = caseRelationalExpChild(booleanLiteralExp);
				if (result == null) result = caseBooleanAndExpChild(booleanLiteralExp);
				if (result == null) result = caseBooleanOrExpChild(booleanLiteralExp);
				if (result == null) result = caseBooleanImpliesExpChild(booleanLiteralExp);
				if (result == null) result = caseExpression(booleanLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.UNDEFINED_LITERAL_EXP: {
				UndefinedLiteralExp undefinedLiteralExp = (UndefinedLiteralExp)theEObject;
				T result = caseUndefinedLiteralExp(undefinedLiteralExp);
				if (result == null) result = caseLiteralExp(undefinedLiteralExp);
				if (result == null) result = caseAtomicExp(undefinedLiteralExp);
				if (result == null) result = caseUnaryExpChild(undefinedLiteralExp);
				if (result == null) result = caseMultiplicativeExpChild(undefinedLiteralExp);
				if (result == null) result = caseAdditiveExpChild(undefinedLiteralExp);
				if (result == null) result = caseRelationalExpChild(undefinedLiteralExp);
				if (result == null) result = caseBooleanAndExpChild(undefinedLiteralExp);
				if (result == null) result = caseBooleanOrExpChild(undefinedLiteralExp);
				if (result == null) result = caseBooleanImpliesExpChild(undefinedLiteralExp);
				if (result == null) result = caseExpression(undefinedLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.TYPE_LITERAL_EXP: {
				TypeLiteralExp typeLiteralExp = (TypeLiteralExp)theEObject;
				T result = caseTypeLiteralExp(typeLiteralExp);
				if (result == null) result = caseLiteralExp(typeLiteralExp);
				if (result == null) result = caseAtomicExp(typeLiteralExp);
				if (result == null) result = caseUnaryExpChild(typeLiteralExp);
				if (result == null) result = caseMultiplicativeExpChild(typeLiteralExp);
				if (result == null) result = caseAdditiveExpChild(typeLiteralExp);
				if (result == null) result = caseRelationalExpChild(typeLiteralExp);
				if (result == null) result = caseBooleanAndExpChild(typeLiteralExp);
				if (result == null) result = caseBooleanOrExpChild(typeLiteralExp);
				if (result == null) result = caseBooleanImpliesExpChild(typeLiteralExp);
				if (result == null) result = caseExpression(typeLiteralExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.VARIABLE_EXP: {
				VariableExp variableExp = (VariableExp)theEObject;
				T result = caseVariableExp(variableExp);
				if (result == null) result = caseAtomicExp(variableExp);
				if (result == null) result = caseUnaryExpChild(variableExp);
				if (result == null) result = caseMultiplicativeExpChild(variableExp);
				if (result == null) result = caseAdditiveExpChild(variableExp);
				if (result == null) result = caseRelationalExpChild(variableExp);
				if (result == null) result = caseBooleanAndExpChild(variableExp);
				if (result == null) result = caseBooleanOrExpChild(variableExp);
				if (result == null) result = caseBooleanImpliesExpChild(variableExp);
				if (result == null) result = caseExpression(variableExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.PREDEFINED_VARIABLE_EXP: {
				PredefinedVariableExp predefinedVariableExp = (PredefinedVariableExp)theEObject;
				T result = casePredefinedVariableExp(predefinedVariableExp);
				if (result == null) result = caseAtomicExp(predefinedVariableExp);
				if (result == null) result = caseUnaryExpChild(predefinedVariableExp);
				if (result == null) result = caseMultiplicativeExpChild(predefinedVariableExp);
				if (result == null) result = caseAdditiveExpChild(predefinedVariableExp);
				if (result == null) result = caseRelationalExpChild(predefinedVariableExp);
				if (result == null) result = caseBooleanAndExpChild(predefinedVariableExp);
				if (result == null) result = caseBooleanOrExpChild(predefinedVariableExp);
				if (result == null) result = caseBooleanImpliesExpChild(predefinedVariableExp);
				if (result == null) result = caseExpression(predefinedVariableExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.NESTED_EXP: {
				NestedExp nestedExp = (NestedExp)theEObject;
				T result = caseNestedExp(nestedExp);
				if (result == null) result = caseAtomicExp(nestedExp);
				if (result == null) result = caseUnaryExpChild(nestedExp);
				if (result == null) result = caseMultiplicativeExpChild(nestedExp);
				if (result == null) result = caseAdditiveExpChild(nestedExp);
				if (result == null) result = caseRelationalExpChild(nestedExp);
				if (result == null) result = caseBooleanAndExpChild(nestedExp);
				if (result == null) result = caseBooleanOrExpChild(nestedExp);
				if (result == null) result = caseBooleanImpliesExpChild(nestedExp);
				if (result == null) result = caseExpression(nestedExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.CALL_PATH_EXP: {
				CallPathExp callPathExp = (CallPathExp)theEObject;
				T result = caseCallPathExp(callPathExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.FEATURE_PATH_EXP: {
				FeaturePathExp featurePathExp = (FeaturePathExp)theEObject;
				T result = caseFeaturePathExp(featurePathExp);
				if (result == null) result = caseCallPathExp(featurePathExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.OPERATION_PATH_EXP: {
				OperationPathExp operationPathExp = (OperationPathExp)theEObject;
				T result = caseOperationPathExp(operationPathExp);
				if (result == null) result = caseCallPathExp(operationPathExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.LOOP_PATH_EXP: {
				LoopPathExp loopPathExp = (LoopPathExp)theEObject;
				T result = caseLoopPathExp(loopPathExp);
				if (result == null) result = caseCallPathExp(loopPathExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.ITERATOR_PATH_EXP: {
				IteratorPathExp iteratorPathExp = (IteratorPathExp)theEObject;
				T result = caseIteratorPathExp(iteratorPathExp);
				if (result == null) result = caseLoopPathExp(iteratorPathExp);
				if (result == null) result = caseCallPathExp(iteratorPathExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.LET_EXP: {
				LetExp letExp = (LetExp)theEObject;
				T result = caseLetExp(letExp);
				if (result == null) result = caseImperativeExp(letExp);
				if (result == null) result = caseExpression(letExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.VARIABLE_WITH_INIT: {
				VariableWithInit variableWithInit = (VariableWithInit)theEObject;
				T result = caseVariableWithInit(variableWithInit);
				if (result == null) result = caseVariable(variableWithInit);
				if (result == null) result = caseNamedElement(variableWithInit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.OBJECT_VARIABLE_WITH_INIT: {
				ObjectVariableWithInit objectVariableWithInit = (ObjectVariableWithInit)theEObject;
				T result = caseObjectVariableWithInit(objectVariableWithInit);
				if (result == null) result = caseObjectVariable(objectVariableWithInit);
				if (result == null) result = caseVariableWithInit(objectVariableWithInit);
				if (result == null) result = caseVariable(objectVariableWithInit);
				if (result == null) result = caseNamedElement(objectVariableWithInit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT: {
				PrimitiveVariableWithInit primitiveVariableWithInit = (PrimitiveVariableWithInit)theEObject;
				T result = casePrimitiveVariableWithInit(primitiveVariableWithInit);
				if (result == null) result = casePrimitiveVariable(primitiveVariableWithInit);
				if (result == null) result = caseVariableWithInit(primitiveVariableWithInit);
				if (result == null) result = caseVariable(primitiveVariableWithInit);
				if (result == null) result = caseNamedElement(primitiveVariableWithInit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.CONDITION_EXP: {
				ConditionExp conditionExp = (ConditionExp)theEObject;
				T result = caseConditionExp(conditionExp);
				if (result == null) result = caseExpression(conditionExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.BOOLEAN_IMPLIES_EXP: {
				BooleanImpliesExp booleanImpliesExp = (BooleanImpliesExp)theEObject;
				T result = caseBooleanImpliesExp(booleanImpliesExp);
				if (result == null) result = caseExpression(booleanImpliesExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.BOOLEAN_IMPLIES_EXP_CHILD: {
				BooleanImpliesExpChild booleanImpliesExpChild = (BooleanImpliesExpChild)theEObject;
				T result = caseBooleanImpliesExpChild(booleanImpliesExpChild);
				if (result == null) result = caseExpression(booleanImpliesExpChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.BOOLEAN_OR_EXP: {
				BooleanOrExp booleanOrExp = (BooleanOrExp)theEObject;
				T result = caseBooleanOrExp(booleanOrExp);
				if (result == null) result = caseBooleanImpliesExpChild(booleanOrExp);
				if (result == null) result = caseExpression(booleanOrExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.BOOLEAN_OR_EXP_CHILD: {
				BooleanOrExpChild booleanOrExpChild = (BooleanOrExpChild)theEObject;
				T result = caseBooleanOrExpChild(booleanOrExpChild);
				if (result == null) result = caseBooleanImpliesExpChild(booleanOrExpChild);
				if (result == null) result = caseExpression(booleanOrExpChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.BOOLEAN_AND_EXP: {
				BooleanAndExp booleanAndExp = (BooleanAndExp)theEObject;
				T result = caseBooleanAndExp(booleanAndExp);
				if (result == null) result = caseBooleanOrExpChild(booleanAndExp);
				if (result == null) result = caseBooleanImpliesExpChild(booleanAndExp);
				if (result == null) result = caseExpression(booleanAndExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.BOOLEAN_AND_EXP_CHILD: {
				BooleanAndExpChild booleanAndExpChild = (BooleanAndExpChild)theEObject;
				T result = caseBooleanAndExpChild(booleanAndExpChild);
				if (result == null) result = caseBooleanOrExpChild(booleanAndExpChild);
				if (result == null) result = caseBooleanImpliesExpChild(booleanAndExpChild);
				if (result == null) result = caseExpression(booleanAndExpChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.RELATIONAL_EXP: {
				RelationalExp relationalExp = (RelationalExp)theEObject;
				T result = caseRelationalExp(relationalExp);
				if (result == null) result = caseBooleanAndExpChild(relationalExp);
				if (result == null) result = caseBooleanOrExpChild(relationalExp);
				if (result == null) result = caseBooleanImpliesExpChild(relationalExp);
				if (result == null) result = caseExpression(relationalExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.RELATIONAL_EXP_CHILD: {
				RelationalExpChild relationalExpChild = (RelationalExpChild)theEObject;
				T result = caseRelationalExpChild(relationalExpChild);
				if (result == null) result = caseBooleanAndExpChild(relationalExpChild);
				if (result == null) result = caseBooleanOrExpChild(relationalExpChild);
				if (result == null) result = caseBooleanImpliesExpChild(relationalExpChild);
				if (result == null) result = caseExpression(relationalExpChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.ADDITIVE_EXP: {
				AdditiveExp additiveExp = (AdditiveExp)theEObject;
				T result = caseAdditiveExp(additiveExp);
				if (result == null) result = caseRelationalExpChild(additiveExp);
				if (result == null) result = caseBooleanAndExpChild(additiveExp);
				if (result == null) result = caseBooleanOrExpChild(additiveExp);
				if (result == null) result = caseBooleanImpliesExpChild(additiveExp);
				if (result == null) result = caseExpression(additiveExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.ADDITIVE_EXP_CHILD: {
				AdditiveExpChild additiveExpChild = (AdditiveExpChild)theEObject;
				T result = caseAdditiveExpChild(additiveExpChild);
				if (result == null) result = caseRelationalExpChild(additiveExpChild);
				if (result == null) result = caseBooleanAndExpChild(additiveExpChild);
				if (result == null) result = caseBooleanOrExpChild(additiveExpChild);
				if (result == null) result = caseBooleanImpliesExpChild(additiveExpChild);
				if (result == null) result = caseExpression(additiveExpChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.MULTIPLICATIVE_EXP: {
				MultiplicativeExp multiplicativeExp = (MultiplicativeExp)theEObject;
				T result = caseMultiplicativeExp(multiplicativeExp);
				if (result == null) result = caseAdditiveExpChild(multiplicativeExp);
				if (result == null) result = caseRelationalExpChild(multiplicativeExp);
				if (result == null) result = caseBooleanAndExpChild(multiplicativeExp);
				if (result == null) result = caseBooleanOrExpChild(multiplicativeExp);
				if (result == null) result = caseBooleanImpliesExpChild(multiplicativeExp);
				if (result == null) result = caseExpression(multiplicativeExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.MULTIPLICATIVE_EXP_CHILD: {
				MultiplicativeExpChild multiplicativeExpChild = (MultiplicativeExpChild)theEObject;
				T result = caseMultiplicativeExpChild(multiplicativeExpChild);
				if (result == null) result = caseAdditiveExpChild(multiplicativeExpChild);
				if (result == null) result = caseRelationalExpChild(multiplicativeExpChild);
				if (result == null) result = caseBooleanAndExpChild(multiplicativeExpChild);
				if (result == null) result = caseBooleanOrExpChild(multiplicativeExpChild);
				if (result == null) result = caseBooleanImpliesExpChild(multiplicativeExpChild);
				if (result == null) result = caseExpression(multiplicativeExpChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.UNARY_EXP: {
				UnaryExp unaryExp = (UnaryExp)theEObject;
				T result = caseUnaryExp(unaryExp);
				if (result == null) result = caseMultiplicativeExpChild(unaryExp);
				if (result == null) result = caseAdditiveExpChild(unaryExp);
				if (result == null) result = caseRelationalExpChild(unaryExp);
				if (result == null) result = caseBooleanAndExpChild(unaryExp);
				if (result == null) result = caseBooleanOrExpChild(unaryExp);
				if (result == null) result = caseBooleanImpliesExpChild(unaryExp);
				if (result == null) result = caseExpression(unaryExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.UNARY_EXP_CHILD: {
				UnaryExpChild unaryExpChild = (UnaryExpChild)theEObject;
				T result = caseUnaryExpChild(unaryExpChild);
				if (result == null) result = caseMultiplicativeExpChild(unaryExpChild);
				if (result == null) result = caseAdditiveExpChild(unaryExpChild);
				if (result == null) result = caseRelationalExpChild(unaryExpChild);
				if (result == null) result = caseBooleanAndExpChild(unaryExpChild);
				if (result == null) result = caseBooleanOrExpChild(unaryExpChild);
				if (result == null) result = caseBooleanImpliesExpChild(unaryExpChild);
				if (result == null) result = caseExpression(unaryExpChild);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.COLLECTION_TYPE: {
				CollectionType collectionType = (CollectionType)theEObject;
				T result = caseCollectionType(collectionType);
				if (result == null) result = caseEDataType(collectionType);
				if (result == null) result = caseEClassifier(collectionType);
				if (result == null) result = caseENamedElement(collectionType);
				if (result == null) result = caseEModelElement(collectionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.ORDERED_SET_TYPE: {
				OrderedSetType orderedSetType = (OrderedSetType)theEObject;
				T result = caseOrderedSetType(orderedSetType);
				if (result == null) result = caseCollectionType(orderedSetType);
				if (result == null) result = caseEDataType(orderedSetType);
				if (result == null) result = caseEClassifier(orderedSetType);
				if (result == null) result = caseENamedElement(orderedSetType);
				if (result == null) result = caseEModelElement(orderedSetType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.SEQUENCE_TYPE: {
				SequenceType sequenceType = (SequenceType)theEObject;
				T result = caseSequenceType(sequenceType);
				if (result == null) result = caseCollectionType(sequenceType);
				if (result == null) result = caseEDataType(sequenceType);
				if (result == null) result = caseEClassifier(sequenceType);
				if (result == null) result = caseENamedElement(sequenceType);
				if (result == null) result = caseEModelElement(sequenceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.SET_TYPE: {
				SetType setType = (SetType)theEObject;
				T result = caseSetType(setType);
				if (result == null) result = caseCollectionType(setType);
				if (result == null) result = caseEDataType(setType);
				if (result == null) result = caseEClassifier(setType);
				if (result == null) result = caseENamedElement(setType);
				if (result == null) result = caseEModelElement(setType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.BAG_TYPE: {
				BagType bagType = (BagType)theEObject;
				T result = caseBagType(bagType);
				if (result == null) result = caseCollectionType(bagType);
				if (result == null) result = caseEDataType(bagType);
				if (result == null) result = caseEClassifier(bagType);
				if (result == null) result = caseENamedElement(bagType);
				if (result == null) result = caseEModelElement(bagType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.IMPERATIVE_EXP: {
				ImperativeExp imperativeExp = (ImperativeExp)theEObject;
				T result = caseImperativeExp(imperativeExp);
				if (result == null) result = caseExpression(imperativeExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.BIND_EXP: {
				BindExp bindExp = (BindExp)theEObject;
				T result = caseBindExp(bindExp);
				if (result == null) result = caseImperativeExp(bindExp);
				if (result == null) result = caseExpression(bindExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.PREDEFINED_BIND_EXP: {
				PredefinedBindExp predefinedBindExp = (PredefinedBindExp)theEObject;
				T result = casePredefinedBindExp(predefinedBindExp);
				if (result == null) result = caseImperativeExp(predefinedBindExp);
				if (result == null) result = caseExpression(predefinedBindExp);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.IF_STATEMENT: {
				IfStatement ifStatement = (IfStatement)theEObject;
				T result = caseIfStatement(ifStatement);
				if (result == null) result = caseImperativeStatement(ifStatement);
				if (result == null) result = caseStatement(ifStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.FOR_STATEMENT: {
				ForStatement forStatement = (ForStatement)theEObject;
				T result = caseForStatement(forStatement);
				if (result == null) result = caseImperativeStatement(forStatement);
				if (result == null) result = caseStatement(forStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.BLOCK_STATEMENT: {
				BlockStatement blockStatement = (BlockStatement)theEObject;
				T result = caseBlockStatement(blockStatement);
				if (result == null) result = caseImperativeStatement(blockStatement);
				if (result == null) result = caseStatement(blockStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.TRANSFORMATION_MODEL: {
				TransformationModel transformationModel = (TransformationModel)theEObject;
				T result = caseTransformationModel(transformationModel);
				if (result == null) result = caseUnit(transformationModel);
				if (result == null) result = caseNamedElement(transformationModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.RULE: {
				Rule rule = (Rule)theEObject;
				T result = caseRule(rule);
				if (result == null) result = caseNamedElement(rule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.STATEMENT: {
				Statement statement = (Statement)theEObject;
				T result = caseStatement(statement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.DECLARATIVE_STATEMENT: {
				DeclarativeStatement declarativeStatement = (DeclarativeStatement)theEObject;
				T result = caseDeclarativeStatement(declarativeStatement);
				if (result == null) result = caseStatement(declarativeStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MorelPackage.IMPERATIVE_STATEMENT: {
				ImperativeStatement imperativeStatement = (ImperativeStatement)theEObject;
				T result = caseImperativeStatement(imperativeStatement);
				if (result == null) result = caseStatement(imperativeStatement);
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
	 * Returns the result of interpreting the object as an instance of '<em>Section</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Section</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSection(Section object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Clause</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clause</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClause(Clause object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Link Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Link Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLinkConstraint(LinkConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Link Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Link Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleLinkConstraint(SimpleLinkConstraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Query Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQueryModel(QueryModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedModel(TypedModel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Query</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Query</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuery(Query object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnit(Unit object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Atomic Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Atomic Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAtomicExp(AtomicExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiteralExp(LiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringLiteralExp(StringLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerLiteralExp(IntegerLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Real Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRealLiteralExp(RealLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanLiteralExp(BooleanLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Undefined Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Undefined Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUndefinedLiteralExp(UndefinedLiteralExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Literal Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Literal Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeLiteralExp(TypeLiteralExp object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Predefined Variable Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predefined Variable Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePredefinedVariableExp(PredefinedVariableExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nested Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nested Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNestedExp(NestedExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Path Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Path Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallPathExp(CallPathExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature Path Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature Path Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeaturePathExp(FeaturePathExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Path Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Path Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationPathExp(OperationPathExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Path Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Path Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopPathExp(LoopPathExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Iterator Path Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Iterator Path Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIteratorPathExp(IteratorPathExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Let Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Let Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLetExp(LetExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable With Init</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable With Init</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableWithInit(VariableWithInit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Variable With Init</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Variable With Init</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectVariableWithInit(ObjectVariableWithInit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Primitive Variable With Init</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Primitive Variable With Init</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrimitiveVariableWithInit(PrimitiveVariableWithInit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConditionExp(ConditionExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Implies Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Implies Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanImpliesExp(BooleanImpliesExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Implies Exp Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Implies Exp Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanImpliesExpChild(BooleanImpliesExpChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Or Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Or Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanOrExp(BooleanOrExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Or Exp Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Or Exp Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanOrExpChild(BooleanOrExpChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean And Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean And Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanAndExp(BooleanAndExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean And Exp Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean And Exp Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanAndExpChild(BooleanAndExpChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relational Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relational Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationalExp(RelationalExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Relational Exp Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Relational Exp Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRelationalExpChild(RelationalExpChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Additive Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Additive Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdditiveExp(AdditiveExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Additive Exp Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Additive Exp Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdditiveExpChild(AdditiveExpChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplicative Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplicative Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplicativeExp(MultiplicativeExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiplicative Exp Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiplicative Exp Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiplicativeExpChild(MultiplicativeExpChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryExp(UnaryExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unary Exp Child</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unary Exp Child</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnaryExpChild(UnaryExpChild object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionType(CollectionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ordered Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrderedSetType(OrderedSetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sequence Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSequenceType(SequenceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetType(SetType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bag Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bag Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBagType(BagType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeExp(ImperativeExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bind Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bind Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBindExp(BindExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Predefined Bind Exp</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predefined Bind Exp</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePredefinedBindExp(PredefinedBindExp object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>If Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIfStatement(IfStatement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Transformation Model</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transformation Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransformationModel(TransformationModel object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Declarative Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declarative Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclarativeStatement(DeclarativeStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Imperative Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Imperative Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImperativeStatement(ImperativeStatement object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>EData Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EData Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEDataType(EDataType object) {
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

} //MorelSwitch
