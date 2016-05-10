/**
 */
package edu.ustb.sei.mde.xmu2core.impl;

import edu.ustb.sei.mde.xmu2core.*;

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
public class Xmu2coreFactoryImpl extends EFactoryImpl implements Xmu2coreFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Xmu2coreFactory init() {
		try {
			Xmu2coreFactory theXmu2coreFactory = (Xmu2coreFactory)EPackage.Registry.INSTANCE.getEFactory(Xmu2corePackage.eNS_URI);
			if (theXmu2coreFactory != null) {
				return theXmu2coreFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Xmu2coreFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xmu2coreFactoryImpl() {
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
			case Xmu2corePackage.PROCEDURE: return createProcedure();
			case Xmu2corePackage.VARIABLE: return createVariable();
			case Xmu2corePackage.ALIGN_STATEMENT: return createAlignStatement();
			case Xmu2corePackage.CASE_STATEMENT: return createCaseStatement();
			case Xmu2corePackage.CASE_PATTERN_CLAUSE: return createCasePatternClause();
			case Xmu2corePackage.CASE_EXPRESSION_CLAUSE: return createCaseExpressionClause();
			case Xmu2corePackage.CASE_STATEMENT_CLAUSE: return createCaseStatementClause();
			case Xmu2corePackage.PATTERN: return createPattern();
			case Xmu2corePackage.PATTERN_NODE: return createPatternNode();
			case Xmu2corePackage.OBJECT_PATTERN_EXPRESSION: return createObjectPatternExpression();
			case Xmu2corePackage.PROPERTY_PATTERN_EXPRESSION: return createPropertyPatternExpression();
			case Xmu2corePackage.BOOLEAN_OR_EXPRESSION: return createBooleanOrExpression();
			case Xmu2corePackage.BOOLEAN_AND_EXPRESSION: return createBooleanAndExpression();
			case Xmu2corePackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
			case Xmu2corePackage.ADDITIVE_EXPRESSION: return createAdditiveExpression();
			case Xmu2corePackage.MULTIPLICATIVE_EXPRESSION: return createMultiplicativeExpression();
			case Xmu2corePackage.UNARY_EXPRESSION: return createUnaryExpression();
			case Xmu2corePackage.TYPE_CAST_EXPRESSION: return createTypeCastExpression();
			case Xmu2corePackage.STRING_VALUE_EXPRESSION: return createStringValueExpression();
			case Xmu2corePackage.BOOLEAN_VALUE_EXPRESSION: return createBooleanValueExpression();
			case Xmu2corePackage.INTEGER_VALUE_EXPRESSION: return createIntegerValueExpression();
			case Xmu2corePackage.ENUM_VALUE_EXPRESSION: return createEnumValueExpression();
			case Xmu2corePackage.EMPTY_VALUE_EXPRESSION: return createEmptyValueExpression();
			case Xmu2corePackage.OBJECT_VALUE_EXPRESSION: return createObjectValueExpression();
			case Xmu2corePackage.VARIABLE_EXPRESSION: return createVariableExpression();
			case Xmu2corePackage.FEATURE_PATH: return createFeaturePath();
			case Xmu2corePackage.OPERATION_PATH: return createOperationPath();
			case Xmu2corePackage.LOOP_PATH: return createLoopPath();
			case Xmu2corePackage.POSITION_PATH: return createPositionPath();
			case Xmu2corePackage.PROCEDURE_CALL_STATEMENT: return createProcedureCallStatement();
			case Xmu2corePackage.TRANSFORMATION: return createTransformation();
			case Xmu2corePackage.ENTRY_RULE_PARAMETER: return createEntryRuleParameter();
			case Xmu2corePackage.FOR_EACH_STATEMENT: return createForEachStatement();
			case Xmu2corePackage.DELETE_NODE_STATEMENT: return createDeleteNodeStatement();
			case Xmu2corePackage.DELETE_LINK_STATEMENT: return createDeleteLinkStatement();
			case Xmu2corePackage.ENFORCE_NODE_STATEMENT: return createEnforceNodeStatement();
			case Xmu2corePackage.ENFORCE_LINK_STATEMENT: return createEnforceLinkStatement();
			case Xmu2corePackage.OCL_COLLECTION_TYPE: return createOclCollectionType();
			case Xmu2corePackage.MATCH_PATTERN: return createMatchPattern();
			case Xmu2corePackage.CHECK_EXPRESSION_STATEMENT: return createCheckExpressionStatement();
			case Xmu2corePackage.ENFORCE_EXPRESSION_STATEMENT: return createEnforceExpressionStatement();
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
			case Xmu2corePackage.NULL:
				return createNullFromString(eDataType, initialValue);
			case Xmu2corePackage.UNDEFINED:
				return createUndefinedFromString(eDataType, initialValue);
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
			case Xmu2corePackage.NULL:
				return convertNullToString(eDataType, instanceValue);
			case Xmu2corePackage.UNDEFINED:
				return convertUndefinedToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Procedure createProcedure() {
		ProcedureImpl procedure = new ProcedureImpl();
		return procedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable createVariable() {
		VariableImpl variable = new VariableImpl();
		return variable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlignStatement createAlignStatement() {
		AlignStatementImpl alignStatement = new AlignStatementImpl();
		return alignStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaseStatement createCaseStatement() {
		CaseStatementImpl caseStatement = new CaseStatementImpl();
		return caseStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CasePatternClause createCasePatternClause() {
		CasePatternClauseImpl casePatternClause = new CasePatternClauseImpl();
		return casePatternClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaseExpressionClause createCaseExpressionClause() {
		CaseExpressionClauseImpl caseExpressionClause = new CaseExpressionClauseImpl();
		return caseExpressionClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaseStatementClause createCaseStatementClause() {
		CaseStatementClauseImpl caseStatementClause = new CaseStatementClauseImpl();
		return caseStatementClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Pattern createPattern() {
		PatternImpl pattern = new PatternImpl();
		return pattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternNode createPatternNode() {
		PatternNodeImpl patternNode = new PatternNodeImpl();
		return patternNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectPatternExpression createObjectPatternExpression() {
		ObjectPatternExpressionImpl objectPatternExpression = new ObjectPatternExpressionImpl();
		return objectPatternExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyPatternExpression createPropertyPatternExpression() {
		PropertyPatternExpressionImpl propertyPatternExpression = new PropertyPatternExpressionImpl();
		return propertyPatternExpression;
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
	public TypeCastExpression createTypeCastExpression() {
		TypeCastExpressionImpl typeCastExpression = new TypeCastExpressionImpl();
		return typeCastExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringValueExpression createStringValueExpression() {
		StringValueExpressionImpl stringValueExpression = new StringValueExpressionImpl();
		return stringValueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanValueExpression createBooleanValueExpression() {
		BooleanValueExpressionImpl booleanValueExpression = new BooleanValueExpressionImpl();
		return booleanValueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerValueExpression createIntegerValueExpression() {
		IntegerValueExpressionImpl integerValueExpression = new IntegerValueExpressionImpl();
		return integerValueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumValueExpression createEnumValueExpression() {
		EnumValueExpressionImpl enumValueExpression = new EnumValueExpressionImpl();
		return enumValueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmptyValueExpression createEmptyValueExpression() {
		EmptyValueExpressionImpl emptyValueExpression = new EmptyValueExpressionImpl();
		return emptyValueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectValueExpression createObjectValueExpression() {
		ObjectValueExpressionImpl objectValueExpression = new ObjectValueExpressionImpl();
		return objectValueExpression;
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
	public ProcedureCallStatement createProcedureCallStatement() {
		ProcedureCallStatementImpl procedureCallStatement = new ProcedureCallStatementImpl();
		return procedureCallStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transformation createTransformation() {
		TransformationImpl transformation = new TransformationImpl();
		return transformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EntryRuleParameter createEntryRuleParameter() {
		EntryRuleParameterImpl entryRuleParameter = new EntryRuleParameterImpl();
		return entryRuleParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForEachStatement createForEachStatement() {
		ForEachStatementImpl forEachStatement = new ForEachStatementImpl();
		return forEachStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteNodeStatement createDeleteNodeStatement() {
		DeleteNodeStatementImpl deleteNodeStatement = new DeleteNodeStatementImpl();
		return deleteNodeStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteLinkStatement createDeleteLinkStatement() {
		DeleteLinkStatementImpl deleteLinkStatement = new DeleteLinkStatementImpl();
		return deleteLinkStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnforceNodeStatement createEnforceNodeStatement() {
		EnforceNodeStatementImpl enforceNodeStatement = new EnforceNodeStatementImpl();
		return enforceNodeStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnforceLinkStatement createEnforceLinkStatement() {
		EnforceLinkStatementImpl enforceLinkStatement = new EnforceLinkStatementImpl();
		return enforceLinkStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclCollectionType createOclCollectionType() {
		OclCollectionTypeImpl oclCollectionType = new OclCollectionTypeImpl();
		return oclCollectionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MatchPattern createMatchPattern() {
		MatchPatternImpl matchPattern = new MatchPatternImpl();
		return matchPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CheckExpressionStatement createCheckExpressionStatement() {
		CheckExpressionStatementImpl checkExpressionStatement = new CheckExpressionStatementImpl();
		return checkExpressionStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnforceExpressionStatement createEnforceExpressionStatement() {
		EnforceExpressionStatementImpl enforceExpressionStatement = new EnforceExpressionStatementImpl();
		return enforceExpressionStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createNullFromString(EDataType eDataType, String initialValue) {
		return super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNullToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createUndefinedFromString(EDataType eDataType, String initialValue) {
		return super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUndefinedToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xmu2corePackage getXmu2corePackage() {
		return (Xmu2corePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Xmu2corePackage getPackage() {
		return Xmu2corePackage.eINSTANCE;
	}

} //Xmu2coreFactoryImpl
