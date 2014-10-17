/**
 */
package edu.ustb.sei.mde.morel.impl;

import edu.ustb.sei.mde.morel.*;

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
public class MorelFactoryImpl extends EFactoryImpl implements MorelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MorelFactory init() {
		try {
			MorelFactory theMorelFactory = (MorelFactory)EPackage.Registry.INSTANCE.getEFactory(MorelPackage.eNS_URI);
			if (theMorelFactory != null) {
				return theMorelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MorelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MorelFactoryImpl() {
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
			case MorelPackage.PATTERN: return createPattern();
			case MorelPackage.CLAUSE: return createClause();
			case MorelPackage.OBJECT_VARIABLE: return createObjectVariable();
			case MorelPackage.PRIMITIVE_VARIABLE: return createPrimitiveVariable();
			case MorelPackage.SIMPLE_LINK_CONSTRAINT: return createSimpleLinkConstraint();
			case MorelPackage.ENCLOSURE_LINK_CONSTRAINT: return createEnclosureLinkConstraint();
			case MorelPackage.PATH_CONSTRAINT: return createPathConstraint();
			case MorelPackage.QUERY_MODEL: return createQueryModel();
			case MorelPackage.TYPED_MODEL: return createTypedModel();
			case MorelPackage.QUERY: return createQuery();
			case MorelPackage.STRING_LITERAL_EXP: return createStringLiteralExp();
			case MorelPackage.INTEGER_LITERAL_EXP: return createIntegerLiteralExp();
			case MorelPackage.REAL_LITERAL_EXP: return createRealLiteralExp();
			case MorelPackage.BOOLEAN_LITERAL_EXP: return createBooleanLiteralExp();
			case MorelPackage.UNDEFINED_LITERAL_EXP: return createUndefinedLiteralExp();
			case MorelPackage.COLLECTION_LITERAL_EXP: return createCollectionLiteralExp();
			case MorelPackage.ENUM_LITERAL_EXP: return createEnumLiteralExp();
			case MorelPackage.TYPE_LITERAL_EXP: return createTypeLiteralExp();
			case MorelPackage.VARIABLE_EXP: return createVariableExp();
			case MorelPackage.PREDEFINED_VARIABLE_EXP: return createPredefinedVariableExp();
			case MorelPackage.NESTED_EXP: return createNestedExp();
			case MorelPackage.FEATURE_PATH_EXP: return createFeaturePathExp();
			case MorelPackage.OPERATION_PATH_EXP: return createOperationPathExp();
			case MorelPackage.ITERATOR_PATH_EXP: return createIteratorPathExp();
			case MorelPackage.LET_EXP: return createLetExp();
			case MorelPackage.OBJECT_VARIABLE_WITH_INIT: return createObjectVariableWithInit();
			case MorelPackage.PRIMITIVE_VARIABLE_WITH_INIT: return createPrimitiveVariableWithInit();
			case MorelPackage.CONDITION_EXP: return createConditionExp();
			case MorelPackage.BOOLEAN_IMPLIES_EXP: return createBooleanImpliesExp();
			case MorelPackage.BOOLEAN_OR_EXP: return createBooleanOrExp();
			case MorelPackage.BOOLEAN_AND_EXP: return createBooleanAndExp();
			case MorelPackage.RELATIONAL_EXP: return createRelationalExp();
			case MorelPackage.ADDITIVE_EXP: return createAdditiveExp();
			case MorelPackage.MULTIPLICATIVE_EXP: return createMultiplicativeExp();
			case MorelPackage.UNARY_EXP: return createUnaryExp();
			case MorelPackage.ORDERED_SET_TYPE: return createOrderedSetType();
			case MorelPackage.SEQUENCE_TYPE: return createSequenceType();
			case MorelPackage.SET_TYPE: return createSetType();
			case MorelPackage.BAG_TYPE: return createBagType();
			case MorelPackage.BIND_EXP: return createBindExp();
			case MorelPackage.PREDEFINED_BIND_EXP: return createPredefinedBindExp();
			case MorelPackage.IF_STATEMENT: return createIfStatement();
			case MorelPackage.FOR_STATEMENT: return createForStatement();
			case MorelPackage.BLOCK_STATEMENT: return createBlockStatement();
			case MorelPackage.TRANSFORMATION_MODEL: return createTransformationModel();
			case MorelPackage.RULE: return createRule();
			case MorelPackage.DECLARATIVE_STATEMENT: return createDeclarativeStatement();
			case MorelPackage.REFLECTIVE_VARIABLE_EXP: return createReflectiveVariableExp();
			case MorelPackage.ARRAY_LITERAL_EXP: return createArrayLiteralExp();
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
			case MorelPackage.SECTION_TYPE:
				return createSectionTypeFromString(eDataType, initialValue);
			case MorelPackage.UNDEFINED_LITERAL:
				return createUndefinedLiteralFromString(eDataType, initialValue);
			case MorelPackage.PREDEFINED_VARIABLE:
				return createPredefinedVariableFromString(eDataType, initialValue);
			case MorelPackage.OPERATION_SEPARATOR:
				return createOperationSeparatorFromString(eDataType, initialValue);
			case MorelPackage.ITERATOR_TYPE:
				return createIteratorTypeFromString(eDataType, initialValue);
			case MorelPackage.BOOLEAN_OPERATOR:
				return createBooleanOperatorFromString(eDataType, initialValue);
			case MorelPackage.RELATIONAL_OPERATOR:
				return createRelationalOperatorFromString(eDataType, initialValue);
			case MorelPackage.ADDITIVE_OPERATOR:
				return createAdditiveOperatorFromString(eDataType, initialValue);
			case MorelPackage.MULTIPLICATIVE_OPERATOR:
				return createMultiplicativeOperatorFromString(eDataType, initialValue);
			case MorelPackage.UNARY_OPERATOR:
				return createUnaryOperatorFromString(eDataType, initialValue);
			case MorelPackage.EXECUTION_MODE:
				return createExecutionModeFromString(eDataType, initialValue);
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
			case MorelPackage.SECTION_TYPE:
				return convertSectionTypeToString(eDataType, instanceValue);
			case MorelPackage.UNDEFINED_LITERAL:
				return convertUndefinedLiteralToString(eDataType, instanceValue);
			case MorelPackage.PREDEFINED_VARIABLE:
				return convertPredefinedVariableToString(eDataType, instanceValue);
			case MorelPackage.OPERATION_SEPARATOR:
				return convertOperationSeparatorToString(eDataType, instanceValue);
			case MorelPackage.ITERATOR_TYPE:
				return convertIteratorTypeToString(eDataType, instanceValue);
			case MorelPackage.BOOLEAN_OPERATOR:
				return convertBooleanOperatorToString(eDataType, instanceValue);
			case MorelPackage.RELATIONAL_OPERATOR:
				return convertRelationalOperatorToString(eDataType, instanceValue);
			case MorelPackage.ADDITIVE_OPERATOR:
				return convertAdditiveOperatorToString(eDataType, instanceValue);
			case MorelPackage.MULTIPLICATIVE_OPERATOR:
				return convertMultiplicativeOperatorToString(eDataType, instanceValue);
			case MorelPackage.UNARY_OPERATOR:
				return convertUnaryOperatorToString(eDataType, instanceValue);
			case MorelPackage.EXECUTION_MODE:
				return convertExecutionModeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
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
	public Clause createClause() {
		ClauseImpl clause = new ClauseImpl();
		return clause;
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
	public SimpleLinkConstraint createSimpleLinkConstraint() {
		SimpleLinkConstraintImpl simpleLinkConstraint = new SimpleLinkConstraintImpl();
		return simpleLinkConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnclosureLinkConstraint createEnclosureLinkConstraint() {
		EnclosureLinkConstraintImpl enclosureLinkConstraint = new EnclosureLinkConstraintImpl();
		return enclosureLinkConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PathConstraint createPathConstraint() {
		PathConstraintImpl pathConstraint = new PathConstraintImpl();
		return pathConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QueryModel createQueryModel() {
		QueryModelImpl queryModel = new QueryModelImpl();
		return queryModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel createTypedModel() {
		TypedModelImpl typedModel = new TypedModelImpl();
		return typedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Query createQuery() {
		QueryImpl query = new QueryImpl();
		return query;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringLiteralExp createStringLiteralExp() {
		StringLiteralExpImpl stringLiteralExp = new StringLiteralExpImpl();
		return stringLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerLiteralExp createIntegerLiteralExp() {
		IntegerLiteralExpImpl integerLiteralExp = new IntegerLiteralExpImpl();
		return integerLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RealLiteralExp createRealLiteralExp() {
		RealLiteralExpImpl realLiteralExp = new RealLiteralExpImpl();
		return realLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanLiteralExp createBooleanLiteralExp() {
		BooleanLiteralExpImpl booleanLiteralExp = new BooleanLiteralExpImpl();
		return booleanLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UndefinedLiteralExp createUndefinedLiteralExp() {
		UndefinedLiteralExpImpl undefinedLiteralExp = new UndefinedLiteralExpImpl();
		return undefinedLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionLiteralExp createCollectionLiteralExp() {
		CollectionLiteralExpImpl collectionLiteralExp = new CollectionLiteralExpImpl();
		return collectionLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumLiteralExp createEnumLiteralExp() {
		EnumLiteralExpImpl enumLiteralExp = new EnumLiteralExpImpl();
		return enumLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeLiteralExp createTypeLiteralExp() {
		TypeLiteralExpImpl typeLiteralExp = new TypeLiteralExpImpl();
		return typeLiteralExp;
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
	public PredefinedVariableExp createPredefinedVariableExp() {
		PredefinedVariableExpImpl predefinedVariableExp = new PredefinedVariableExpImpl();
		return predefinedVariableExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NestedExp createNestedExp() {
		NestedExpImpl nestedExp = new NestedExpImpl();
		return nestedExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeaturePathExp createFeaturePathExp() {
		FeaturePathExpImpl featurePathExp = new FeaturePathExpImpl();
		return featurePathExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationPathExp createOperationPathExp() {
		OperationPathExpImpl operationPathExp = new OperationPathExpImpl();
		return operationPathExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IteratorPathExp createIteratorPathExp() {
		IteratorPathExpImpl iteratorPathExp = new IteratorPathExpImpl();
		return iteratorPathExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetExp createLetExp() {
		LetExpImpl letExp = new LetExpImpl();
		return letExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectVariableWithInit createObjectVariableWithInit() {
		ObjectVariableWithInitImpl objectVariableWithInit = new ObjectVariableWithInitImpl();
		return objectVariableWithInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveVariableWithInit createPrimitiveVariableWithInit() {
		PrimitiveVariableWithInitImpl primitiveVariableWithInit = new PrimitiveVariableWithInitImpl();
		return primitiveVariableWithInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConditionExp createConditionExp() {
		ConditionExpImpl conditionExp = new ConditionExpImpl();
		return conditionExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanImpliesExp createBooleanImpliesExp() {
		BooleanImpliesExpImpl booleanImpliesExp = new BooleanImpliesExpImpl();
		return booleanImpliesExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanOrExp createBooleanOrExp() {
		BooleanOrExpImpl booleanOrExp = new BooleanOrExpImpl();
		return booleanOrExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanAndExp createBooleanAndExp() {
		BooleanAndExpImpl booleanAndExp = new BooleanAndExpImpl();
		return booleanAndExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalExp createRelationalExp() {
		RelationalExpImpl relationalExp = new RelationalExpImpl();
		return relationalExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditiveExp createAdditiveExp() {
		AdditiveExpImpl additiveExp = new AdditiveExpImpl();
		return additiveExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicativeExp createMultiplicativeExp() {
		MultiplicativeExpImpl multiplicativeExp = new MultiplicativeExpImpl();
		return multiplicativeExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryExp createUnaryExp() {
		UnaryExpImpl unaryExp = new UnaryExpImpl();
		return unaryExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrderedSetType createOrderedSetType() {
		OrderedSetTypeImpl orderedSetType = new OrderedSetTypeImpl();
		return orderedSetType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequenceType createSequenceType() {
		SequenceTypeImpl sequenceType = new SequenceTypeImpl();
		return sequenceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetType createSetType() {
		SetTypeImpl setType = new SetTypeImpl();
		return setType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BagType createBagType() {
		BagTypeImpl bagType = new BagTypeImpl();
		return bagType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BindExp createBindExp() {
		BindExpImpl bindExp = new BindExpImpl();
		return bindExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredefinedBindExp createPredefinedBindExp() {
		PredefinedBindExpImpl predefinedBindExp = new PredefinedBindExpImpl();
		return predefinedBindExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfStatement createIfStatement() {
		IfStatementImpl ifStatement = new IfStatementImpl();
		return ifStatement;
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
	public BlockStatement createBlockStatement() {
		BlockStatementImpl blockStatement = new BlockStatementImpl();
		return blockStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TransformationModel createTransformationModel() {
		TransformationModelImpl transformationModel = new TransformationModelImpl();
		return transformationModel;
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
	public DeclarativeStatement createDeclarativeStatement() {
		DeclarativeStatementImpl declarativeStatement = new DeclarativeStatementImpl();
		return declarativeStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReflectiveVariableExp createReflectiveVariableExp() {
		ReflectiveVariableExpImpl reflectiveVariableExp = new ReflectiveVariableExpImpl();
		return reflectiveVariableExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayLiteralExp createArrayLiteralExp() {
		ArrayLiteralExpImpl arrayLiteralExp = new ArrayLiteralExpImpl();
		return arrayLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SectionType createSectionTypeFromString(EDataType eDataType, String initialValue) {
		SectionType result = SectionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSectionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UndefinedLiteral createUndefinedLiteralFromString(EDataType eDataType, String initialValue) {
		UndefinedLiteral result = UndefinedLiteral.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUndefinedLiteralToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PredefinedVariable createPredefinedVariableFromString(EDataType eDataType, String initialValue) {
		PredefinedVariable result = PredefinedVariable.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPredefinedVariableToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationSeparator createOperationSeparatorFromString(EDataType eDataType, String initialValue) {
		OperationSeparator result = OperationSeparator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperationSeparatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IteratorType createIteratorTypeFromString(EDataType eDataType, String initialValue) {
		IteratorType result = IteratorType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIteratorTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanOperator createBooleanOperatorFromString(EDataType eDataType, String initialValue) {
		BooleanOperator result = BooleanOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBooleanOperatorToString(EDataType eDataType, Object instanceValue) {
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
	public ExecutionMode createExecutionModeFromString(EDataType eDataType, String initialValue) {
		ExecutionMode result = ExecutionMode.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExecutionModeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MorelPackage getMorelPackage() {
		return (MorelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MorelPackage getPackage() {
		return MorelPackage.eINSTANCE;
	}

} //MorelFactoryImpl
