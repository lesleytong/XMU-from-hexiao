/**
 */
package edu.ustb.sei.mde.xmu.impl;

import edu.ustb.sei.mde.xmu.*;

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
public class XmuFactoryImpl extends EFactoryImpl implements XmuFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static XmuFactory init() {
		try {
			XmuFactory theXmuFactory = (XmuFactory)EPackage.Registry.INSTANCE.getEFactory(XmuPackage.eNS_URI);
			if (theXmuFactory != null) {
				return theXmuFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new XmuFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XmuFactoryImpl() {
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
			case XmuPackage.OBJECT_VARIABLE: return createObjectVariable();
			case XmuPackage.PRIMITIVE_VARIABLE: return createPrimitiveVariable();
			case XmuPackage.RULE: return createRule();
			case XmuPackage.FOR_STATEMENT: return createForStatement();
			case XmuPackage.DELETE_NODE: return createDeleteNode();
			case XmuPackage.DELETE_LINK: return createDeleteLink();
			case XmuPackage.UPDATE_PATTERN: return createUpdatePattern();
			case XmuPackage.PATTERN: return createPattern();
			case XmuPackage.PATTERN_NODE: return createPatternNode();
			case XmuPackage.PATTERN_REFERENCE_EXPR: return createPatternReferenceExpr();
			case XmuPackage.PATTERN_EQUAL_EXPR: return createPatternEqualExpr();
			case XmuPackage.VARIABLE_EXP: return createVariableExp();
			case XmuPackage.EMPTY_LITERAL: return createEmptyLiteral();
			case XmuPackage.STRING_LITERAL: return createStringLiteral();
			case XmuPackage.INTEGER_LITERAL: return createIntegerLiteral();
			case XmuPackage.BOOLEAN_LITERAL: return createBooleanLiteral();
			case XmuPackage.ENUM_LITERAL: return createEnumLiteral();
			case XmuPackage.VSTATEMENT: return createVStatement();
			case XmuPackage.BLOCK_STATEMENT: return createBlockStatement();
			case XmuPackage.SWITCH_STATEMENT: return createSwitchStatement();
			case XmuPackage.CASE_PATTERN_STATEMENT: return createCasePatternStatement();
			case XmuPackage.CASE_VALUE_STATEMENT: return createCaseValueStatement();
			case XmuPackage.XMU_MODEL: return createXMUModel();
			case XmuPackage.PARAMETER: return createParameter();
			case XmuPackage.RULE_CALL_STATEMENT: return createRuleCallStatement();
			case XmuPackage.UPDATED_STATEMENT: return createUpdatedStatement();
			case XmuPackage.BOOLEAN_OR_EXPR: return createBooleanOrExpr();
			case XmuPackage.BOOLEAN_AND_EXPR: return createBooleanAndExpr();
			case XmuPackage.RELATIONAL_EXPR: return createRelationalExpr();
			case XmuPackage.ADDITIVE_EXPR: return createAdditiveExpr();
			case XmuPackage.MULTIPLICATIVE_EXPR: return createMultiplicativeExpr();
			case XmuPackage.UNARY_EXPR: return createUnaryExpr();
			case XmuPackage.PAREN_EXPR: return createParenExpr();
			case XmuPackage.FEATURE_PATH: return createFeaturePath();
			case XmuPackage.OPERATION_PATH: return createOperationPath();
			case XmuPackage.START_STATEMENT: return createStartStatement();
			case XmuPackage.START_ROOT: return createStartRoot();
			case XmuPackage.ERESOURCE: return createEResource();
			case XmuPackage.PRINT_STATEMENT: return createPrintStatement();
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
			case XmuPackage.VARIABLE_FLAG:
				return createVariableFlagFromString(eDataType, initialValue);
			case XmuPackage.RELATIONAL_OPERATOR:
				return createRelationalOperatorFromString(eDataType, initialValue);
			case XmuPackage.EMPTY_TYPE:
				return createEmptyTypeFromString(eDataType, initialValue);
			case XmuPackage.VSTMT_TYPE:
				return createVStmtTypeFromString(eDataType, initialValue);
			case XmuPackage.ADDITIVE_OPERATOR:
				return createAdditiveOperatorFromString(eDataType, initialValue);
			case XmuPackage.MULTIPLICATIVE_OPERATOR:
				return createMultiplicativeOperatorFromString(eDataType, initialValue);
			case XmuPackage.UNARY_OPERATOR:
				return createUnaryOperatorFromString(eDataType, initialValue);
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
			case XmuPackage.VARIABLE_FLAG:
				return convertVariableFlagToString(eDataType, instanceValue);
			case XmuPackage.RELATIONAL_OPERATOR:
				return convertRelationalOperatorToString(eDataType, instanceValue);
			case XmuPackage.EMPTY_TYPE:
				return convertEmptyTypeToString(eDataType, instanceValue);
			case XmuPackage.VSTMT_TYPE:
				return convertVStmtTypeToString(eDataType, instanceValue);
			case XmuPackage.ADDITIVE_OPERATOR:
				return convertAdditiveOperatorToString(eDataType, instanceValue);
			case XmuPackage.MULTIPLICATIVE_OPERATOR:
				return convertMultiplicativeOperatorToString(eDataType, instanceValue);
			case XmuPackage.UNARY_OPERATOR:
				return convertUnaryOperatorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectVariable createObjectVariable() {
		ObjectVariableImpl objectVariable = new ObjectVariableImpl();
		return objectVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveVariable createPrimitiveVariable() {
		PrimitiveVariableImpl primitiveVariable = new PrimitiveVariableImpl();
		return primitiveVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule createRule() {
		RuleImpl rule = new RuleImpl();
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForStatement createForStatement() {
		ForStatementImpl forStatement = new ForStatementImpl();
		return forStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteNode createDeleteNode() {
		DeleteNodeImpl deleteNode = new DeleteNodeImpl();
		return deleteNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeleteLink createDeleteLink() {
		DeleteLinkImpl deleteLink = new DeleteLinkImpl();
		return deleteLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpdatePattern createUpdatePattern() {
		UpdatePatternImpl updatePattern = new UpdatePatternImpl();
		return updatePattern;
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
	public PatternReferenceExpr createPatternReferenceExpr() {
		PatternReferenceExprImpl patternReferenceExpr = new PatternReferenceExprImpl();
		return patternReferenceExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternEqualExpr createPatternEqualExpr() {
		PatternEqualExprImpl patternEqualExpr = new PatternEqualExprImpl();
		return patternEqualExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableExp createVariableExp() {
		VariableExpImpl variableExp = new VariableExpImpl();
		return variableExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmptyLiteral createEmptyLiteral() {
		EmptyLiteralImpl emptyLiteral = new EmptyLiteralImpl();
		return emptyLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteral createStringLiteral() {
		StringLiteralImpl stringLiteral = new StringLiteralImpl();
		return stringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerLiteral createIntegerLiteral() {
		IntegerLiteralImpl integerLiteral = new IntegerLiteralImpl();
		return integerLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanLiteral createBooleanLiteral() {
		BooleanLiteralImpl booleanLiteral = new BooleanLiteralImpl();
		return booleanLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiteral createEnumLiteral() {
		EnumLiteralImpl enumLiteral = new EnumLiteralImpl();
		return enumLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VStatement createVStatement() {
		VStatementImpl vStatement = new VStatementImpl();
		return vStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BlockStatement createBlockStatement() {
		BlockStatementImpl blockStatement = new BlockStatementImpl();
		return blockStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchStatement createSwitchStatement() {
		SwitchStatementImpl switchStatement = new SwitchStatementImpl();
		return switchStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CasePatternStatement createCasePatternStatement() {
		CasePatternStatementImpl casePatternStatement = new CasePatternStatementImpl();
		return casePatternStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaseValueStatement createCaseValueStatement() {
		CaseValueStatementImpl caseValueStatement = new CaseValueStatementImpl();
		return caseValueStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XMUModel createXMUModel() {
		XMUModelImpl xmuModel = new XMUModelImpl();
		return xmuModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleCallStatement createRuleCallStatement() {
		RuleCallStatementImpl ruleCallStatement = new RuleCallStatementImpl();
		return ruleCallStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpdatedStatement createUpdatedStatement() {
		UpdatedStatementImpl updatedStatement = new UpdatedStatementImpl();
		return updatedStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanOrExpr createBooleanOrExpr() {
		BooleanOrExprImpl booleanOrExpr = new BooleanOrExprImpl();
		return booleanOrExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanAndExpr createBooleanAndExpr() {
		BooleanAndExprImpl booleanAndExpr = new BooleanAndExprImpl();
		return booleanAndExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalExpr createRelationalExpr() {
		RelationalExprImpl relationalExpr = new RelationalExprImpl();
		return relationalExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditiveExpr createAdditiveExpr() {
		AdditiveExprImpl additiveExpr = new AdditiveExprImpl();
		return additiveExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicativeExpr createMultiplicativeExpr() {
		MultiplicativeExprImpl multiplicativeExpr = new MultiplicativeExprImpl();
		return multiplicativeExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryExpr createUnaryExpr() {
		UnaryExprImpl unaryExpr = new UnaryExprImpl();
		return unaryExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParenExpr createParenExpr() {
		ParenExprImpl parenExpr = new ParenExprImpl();
		return parenExpr;
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
	public StartStatement createStartStatement() {
		StartStatementImpl startStatement = new StartStatementImpl();
		return startStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartRoot createStartRoot() {
		StartRootImpl startRoot = new StartRootImpl();
		return startRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EResource createEResource() {
		EResourceImpl eResource = new EResourceImpl();
		return eResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrintStatement createPrintStatement() {
		PrintStatementImpl printStatement = new PrintStatementImpl();
		return printStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableFlag createVariableFlagFromString(EDataType eDataType, String initialValue) {
		VariableFlag result = VariableFlag.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVariableFlagToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalOperator createRelationalOperatorFromString(EDataType eDataType, String initialValue) {
		RelationalOperator result = RelationalOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRelationalOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmptyType createEmptyTypeFromString(EDataType eDataType, String initialValue) {
		EmptyType result = EmptyType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEmptyTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VStmtType createVStmtTypeFromString(EDataType eDataType, String initialValue) {
		VStmtType result = VStmtType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVStmtTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditiveOperator createAdditiveOperatorFromString(EDataType eDataType, String initialValue) {
		AdditiveOperator result = AdditiveOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAdditiveOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicativeOperator createMultiplicativeOperatorFromString(EDataType eDataType, String initialValue) {
		MultiplicativeOperator result = MultiplicativeOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMultiplicativeOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryOperator createUnaryOperatorFromString(EDataType eDataType, String initialValue) {
		UnaryOperator result = UnaryOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnaryOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XmuPackage getXmuPackage() {
		return (XmuPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static XmuPackage getPackage() {
		return XmuPackage.eINSTANCE;
	}

} //XmuFactoryImpl
