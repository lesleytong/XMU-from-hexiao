/**
 * generated by Xtext 2.14.0
 */
package edu.ustb.sei.mde.bxcore.dsl.bXCore.impl;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.*;

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
public class BXCoreFactoryImpl extends EFactoryImpl implements BXCoreFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static BXCoreFactory init()
  {
    try
    {
      BXCoreFactory theBXCoreFactory = (BXCoreFactory)EPackage.Registry.INSTANCE.getEFactory(BXCorePackage.eNS_URI);
      if (theBXCoreFactory != null)
      {
        return theBXCoreFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new BXCoreFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BXCoreFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case BXCorePackage.BX_PROGRAM: return createBXProgram();
      case BXCorePackage.IMPORT_SECTION: return createImportSection();
      case BXCorePackage.DEFINITION: return createDefinition();
      case BXCorePackage.CUSTOMIZED_BI_GUL_DEFINITION: return createCustomizedBiGULDefinition();
      case BXCorePackage.TYPE_LITERAL: return createTypeLiteral();
      case BXCorePackage.TUPLE_TYPE_LITERAL: return createTupleTypeLiteral();
      case BXCorePackage.UNORDERED_TUPLE_TYPE_LITERAL: return createUnorderedTupleTypeLiteral();
      case BXCorePackage.ORDERED_TUPLE_TYPE_LITERAL: return createOrderedTupleTypeLiteral();
      case BXCorePackage.TYPE_VAR: return createTypeVar();
      case BXCorePackage.PREDEFINED_TYPE_LITERAL: return createPredefinedTypeLiteral();
      case BXCorePackage.PATTERN_TYPE_LITERAL: return createPatternTypeLiteral();
      case BXCorePackage.TYPE_DEFINITION: return createTypeDefinition();
      case BXCorePackage.PATTERN_DEFINITION: return createPatternDefinition();
      case BXCorePackage.CONTEXT_TYPE_REF: return createContextTypeRef();
      case BXCorePackage.BX_FUNCTION_DEFINITION: return createBXFunctionDefinition();
      case BXCorePackage.TYPE_REF: return createTypeRef();
      case BXCorePackage.INDEX_DEFINITION: return createIndexDefinition();
      case BXCorePackage.PATTERN_NODE: return createPatternNode();
      case BXCorePackage.PATTERN_EDGE: return createPatternEdge();
      case BXCorePackage.PATTERN_VALUE_CONDITION: return createPatternValueCondition();
      case BXCorePackage.PATTERN_NODE_REF: return createPatternNodeRef();
      case BXCorePackage.PATTERN: return createPattern();
      case BXCorePackage.PATTERN_DEFINITION_REFERENCE: return createPatternDefinitionReference();
      case BXCorePackage.XMU_CORE_STATEMENT: return createXmuCoreStatement();
      case BXCorePackage.XMU_CORE_COMPOSITION_CHILD_STATEMENT: return createXmuCoreCompositionChildStatement();
      case BXCorePackage.TYPE_INDICATOR: return createTypeIndicator();
      case BXCorePackage.XMU_CORE_CONTEXT_SOURCE: return createXmuCoreContextSource();
      case BXCorePackage.XMU_CORE_MATCH_SOURCE: return createXmuCoreMatchSource();
      case BXCorePackage.XMU_CORE_MATCH_VIEW: return createXmuCoreMatchView();
      case BXCorePackage.XMU_CORE_EXPAND_SOURCE: return createXmuCoreExpandSource();
      case BXCorePackage.XMU_CORE_EXPAND_VIEW: return createXmuCoreExpandView();
      case BXCorePackage.VAR_MAPPING: return createVarMapping();
      case BXCorePackage.XMU_CORE_GRAPH_REPLACE: return createXmuCoreGraphReplace();
      case BXCorePackage.XMU_CORE_PARALLEL_COMPOSITION: return createXmuCoreParallelComposition();
      case BXCorePackage.XMU_CORE_SWITCH: return createXmuCoreSwitch();
      case BXCorePackage.XMU_CORE_SWITCH_BRANCH: return createXmuCoreSwitchBranch();
      case BXCorePackage.XMU_CORE_SWITCH_ADAPTION: return createXmuCoreSwitchAdaption();
      case BXCorePackage.CONVERSION: return createConversion();
      case BXCorePackage.XMU_CORE_FORK: return createXmuCoreFork();
      case BXCorePackage.XMU_CORE_FORK_BRANCH: return createXmuCoreForkBranch();
      case BXCorePackage.XMU_CORE_ALIGN: return createXmuCoreAlign();
      case BXCorePackage.XMU_CORE_FUNCTION_CALL: return createXmuCoreFunctionCall();
      case BXCorePackage.XMU_CORE_INDEX: return createXmuCoreIndex();
      case BXCorePackage.INDEX_PART: return createIndexPart();
      case BXCorePackage.XMU_CORE_FOR_EACH_MATCH_SOURCE: return createXmuCoreForEachMatchSource();
      case BXCorePackage.CONTEXT_AWARE_CONDITION: return createContextAwareCondition();
      case BXCorePackage.CONTEXT_AWARE_UNIDIRECTIONAL_ACTION: return createContextAwareUnidirectionalAction();
      case BXCorePackage.BI_GUL_STATEMENT: return createBiGULStatement();
      case BXCorePackage.BI_GUL_REPLACE: return createBiGULReplace();
      case BXCorePackage.BI_GUL_SKIP: return createBiGULSkip();
      case BXCorePackage.CUSTOMIZED_BI_GUL_REFERENCE: return createCustomizedBiGULReference();
      case BXCorePackage.CONTEXT_EXPRESSION: return createContextExpression();
      case BXCorePackage.CONTEXT_PRIMARY_EXPRESSION: return createContextPrimaryExpression();
      case BXCorePackage.NEW_INSTANCE_EXPRESSION: return createNewInstanceExpression();
      case BXCorePackage.ANNOTATED_TYPE: return createAnnotatedType();
      case BXCorePackage.ALL_INSTANCE_EXPRESSION: return createAllInstanceExpression();
      case BXCorePackage.MODIFICATION_EXPRESSION: return createModificationExpression();
      case BXCorePackage.ENFORCEMENT_EXPRESSION: return createEnforcementExpression();
      case BXCorePackage.DELETE_ELEMENT_EXPRESSION: return createDeleteElementExpression();
      case BXCorePackage.VALUE_MAPPING: return createValueMapping();
      case BXCorePackage.DEFINED_CONTEXT_TYPE_REF: return createDefinedContextTypeRef();
      case BXCorePackage.ECORE_TYPE_REF: return createEcoreTypeRef();
      case BXCorePackage.FEATURE_TYPE_REF: return createFeatureTypeRef();
      case BXCorePackage.NAVIGATION_EXPRESSION: return createNavigationExpression();
      case BXCorePackage.CONTEXT_VAR_EXPRESSION: return createContextVarExpression();
      case BXCorePackage.EXPRESSION_CONVERSION: return createExpressionConversion();
      case BXCorePackage.MODIFICATION_EXPRESSION_BLOCK: return createModificationExpressionBlock();
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
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case BXCorePackage.SIDE_ENUM:
        return createSideEnumFromString(eDataType, initialValue);
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
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case BXCorePackage.SIDE_ENUM:
        return convertSideEnumToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BXProgram createBXProgram()
  {
    BXProgramImpl bxProgram = new BXProgramImpl();
    return bxProgram;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImportSection createImportSection()
  {
    ImportSectionImpl importSection = new ImportSectionImpl();
    return importSection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Definition createDefinition()
  {
    DefinitionImpl definition = new DefinitionImpl();
    return definition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CustomizedBiGULDefinition createCustomizedBiGULDefinition()
  {
    CustomizedBiGULDefinitionImpl customizedBiGULDefinition = new CustomizedBiGULDefinitionImpl();
    return customizedBiGULDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeLiteral createTypeLiteral()
  {
    TypeLiteralImpl typeLiteral = new TypeLiteralImpl();
    return typeLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TupleTypeLiteral createTupleTypeLiteral()
  {
    TupleTypeLiteralImpl tupleTypeLiteral = new TupleTypeLiteralImpl();
    return tupleTypeLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnorderedTupleTypeLiteral createUnorderedTupleTypeLiteral()
  {
    UnorderedTupleTypeLiteralImpl unorderedTupleTypeLiteral = new UnorderedTupleTypeLiteralImpl();
    return unorderedTupleTypeLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrderedTupleTypeLiteral createOrderedTupleTypeLiteral()
  {
    OrderedTupleTypeLiteralImpl orderedTupleTypeLiteral = new OrderedTupleTypeLiteralImpl();
    return orderedTupleTypeLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeVar createTypeVar()
  {
    TypeVarImpl typeVar = new TypeVarImpl();
    return typeVar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PredefinedTypeLiteral createPredefinedTypeLiteral()
  {
    PredefinedTypeLiteralImpl predefinedTypeLiteral = new PredefinedTypeLiteralImpl();
    return predefinedTypeLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternTypeLiteral createPatternTypeLiteral()
  {
    PatternTypeLiteralImpl patternTypeLiteral = new PatternTypeLiteralImpl();
    return patternTypeLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDefinition createTypeDefinition()
  {
    TypeDefinitionImpl typeDefinition = new TypeDefinitionImpl();
    return typeDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternDefinition createPatternDefinition()
  {
    PatternDefinitionImpl patternDefinition = new PatternDefinitionImpl();
    return patternDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextTypeRef createContextTypeRef()
  {
    ContextTypeRefImpl contextTypeRef = new ContextTypeRefImpl();
    return contextTypeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BXFunctionDefinition createBXFunctionDefinition()
  {
    BXFunctionDefinitionImpl bxFunctionDefinition = new BXFunctionDefinitionImpl();
    return bxFunctionDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeRef createTypeRef()
  {
    TypeRefImpl typeRef = new TypeRefImpl();
    return typeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndexDefinition createIndexDefinition()
  {
    IndexDefinitionImpl indexDefinition = new IndexDefinitionImpl();
    return indexDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternNode createPatternNode()
  {
    PatternNodeImpl patternNode = new PatternNodeImpl();
    return patternNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternEdge createPatternEdge()
  {
    PatternEdgeImpl patternEdge = new PatternEdgeImpl();
    return patternEdge;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternValueCondition createPatternValueCondition()
  {
    PatternValueConditionImpl patternValueCondition = new PatternValueConditionImpl();
    return patternValueCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternNodeRef createPatternNodeRef()
  {
    PatternNodeRefImpl patternNodeRef = new PatternNodeRefImpl();
    return patternNodeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Pattern createPattern()
  {
    PatternImpl pattern = new PatternImpl();
    return pattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PatternDefinitionReference createPatternDefinitionReference()
  {
    PatternDefinitionReferenceImpl patternDefinitionReference = new PatternDefinitionReferenceImpl();
    return patternDefinitionReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreStatement createXmuCoreStatement()
  {
    XmuCoreStatementImpl xmuCoreStatement = new XmuCoreStatementImpl();
    return xmuCoreStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreCompositionChildStatement createXmuCoreCompositionChildStatement()
  {
    XmuCoreCompositionChildStatementImpl xmuCoreCompositionChildStatement = new XmuCoreCompositionChildStatementImpl();
    return xmuCoreCompositionChildStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeIndicator createTypeIndicator()
  {
    TypeIndicatorImpl typeIndicator = new TypeIndicatorImpl();
    return typeIndicator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreContextSource createXmuCoreContextSource()
  {
    XmuCoreContextSourceImpl xmuCoreContextSource = new XmuCoreContextSourceImpl();
    return xmuCoreContextSource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreMatchSource createXmuCoreMatchSource()
  {
    XmuCoreMatchSourceImpl xmuCoreMatchSource = new XmuCoreMatchSourceImpl();
    return xmuCoreMatchSource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreMatchView createXmuCoreMatchView()
  {
    XmuCoreMatchViewImpl xmuCoreMatchView = new XmuCoreMatchViewImpl();
    return xmuCoreMatchView;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreExpandSource createXmuCoreExpandSource()
  {
    XmuCoreExpandSourceImpl xmuCoreExpandSource = new XmuCoreExpandSourceImpl();
    return xmuCoreExpandSource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreExpandView createXmuCoreExpandView()
  {
    XmuCoreExpandViewImpl xmuCoreExpandView = new XmuCoreExpandViewImpl();
    return xmuCoreExpandView;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarMapping createVarMapping()
  {
    VarMappingImpl varMapping = new VarMappingImpl();
    return varMapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreGraphReplace createXmuCoreGraphReplace()
  {
    XmuCoreGraphReplaceImpl xmuCoreGraphReplace = new XmuCoreGraphReplaceImpl();
    return xmuCoreGraphReplace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreParallelComposition createXmuCoreParallelComposition()
  {
    XmuCoreParallelCompositionImpl xmuCoreParallelComposition = new XmuCoreParallelCompositionImpl();
    return xmuCoreParallelComposition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreSwitch createXmuCoreSwitch()
  {
    XmuCoreSwitchImpl xmuCoreSwitch = new XmuCoreSwitchImpl();
    return xmuCoreSwitch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreSwitchBranch createXmuCoreSwitchBranch()
  {
    XmuCoreSwitchBranchImpl xmuCoreSwitchBranch = new XmuCoreSwitchBranchImpl();
    return xmuCoreSwitchBranch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreSwitchAdaption createXmuCoreSwitchAdaption()
  {
    XmuCoreSwitchAdaptionImpl xmuCoreSwitchAdaption = new XmuCoreSwitchAdaptionImpl();
    return xmuCoreSwitchAdaption;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Conversion createConversion()
  {
    ConversionImpl conversion = new ConversionImpl();
    return conversion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreFork createXmuCoreFork()
  {
    XmuCoreForkImpl xmuCoreFork = new XmuCoreForkImpl();
    return xmuCoreFork;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreForkBranch createXmuCoreForkBranch()
  {
    XmuCoreForkBranchImpl xmuCoreForkBranch = new XmuCoreForkBranchImpl();
    return xmuCoreForkBranch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreAlign createXmuCoreAlign()
  {
    XmuCoreAlignImpl xmuCoreAlign = new XmuCoreAlignImpl();
    return xmuCoreAlign;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreFunctionCall createXmuCoreFunctionCall()
  {
    XmuCoreFunctionCallImpl xmuCoreFunctionCall = new XmuCoreFunctionCallImpl();
    return xmuCoreFunctionCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreIndex createXmuCoreIndex()
  {
    XmuCoreIndexImpl xmuCoreIndex = new XmuCoreIndexImpl();
    return xmuCoreIndex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndexPart createIndexPart()
  {
    IndexPartImpl indexPart = new IndexPartImpl();
    return indexPart;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public XmuCoreForEachMatchSource createXmuCoreForEachMatchSource()
  {
    XmuCoreForEachMatchSourceImpl xmuCoreForEachMatchSource = new XmuCoreForEachMatchSourceImpl();
    return xmuCoreForEachMatchSource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextAwareCondition createContextAwareCondition()
  {
    ContextAwareConditionImpl contextAwareCondition = new ContextAwareConditionImpl();
    return contextAwareCondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextAwareUnidirectionalAction createContextAwareUnidirectionalAction()
  {
    ContextAwareUnidirectionalActionImpl contextAwareUnidirectionalAction = new ContextAwareUnidirectionalActionImpl();
    return contextAwareUnidirectionalAction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BiGULStatement createBiGULStatement()
  {
    BiGULStatementImpl biGULStatement = new BiGULStatementImpl();
    return biGULStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BiGULReplace createBiGULReplace()
  {
    BiGULReplaceImpl biGULReplace = new BiGULReplaceImpl();
    return biGULReplace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BiGULSkip createBiGULSkip()
  {
    BiGULSkipImpl biGULSkip = new BiGULSkipImpl();
    return biGULSkip;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CustomizedBiGULReference createCustomizedBiGULReference()
  {
    CustomizedBiGULReferenceImpl customizedBiGULReference = new CustomizedBiGULReferenceImpl();
    return customizedBiGULReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextExpression createContextExpression()
  {
    ContextExpressionImpl contextExpression = new ContextExpressionImpl();
    return contextExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextPrimaryExpression createContextPrimaryExpression()
  {
    ContextPrimaryExpressionImpl contextPrimaryExpression = new ContextPrimaryExpressionImpl();
    return contextPrimaryExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NewInstanceExpression createNewInstanceExpression()
  {
    NewInstanceExpressionImpl newInstanceExpression = new NewInstanceExpressionImpl();
    return newInstanceExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AnnotatedType createAnnotatedType()
  {
    AnnotatedTypeImpl annotatedType = new AnnotatedTypeImpl();
    return annotatedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AllInstanceExpression createAllInstanceExpression()
  {
    AllInstanceExpressionImpl allInstanceExpression = new AllInstanceExpressionImpl();
    return allInstanceExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModificationExpression createModificationExpression()
  {
    ModificationExpressionImpl modificationExpression = new ModificationExpressionImpl();
    return modificationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnforcementExpression createEnforcementExpression()
  {
    EnforcementExpressionImpl enforcementExpression = new EnforcementExpressionImpl();
    return enforcementExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DeleteElementExpression createDeleteElementExpression()
  {
    DeleteElementExpressionImpl deleteElementExpression = new DeleteElementExpressionImpl();
    return deleteElementExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueMapping createValueMapping()
  {
    ValueMappingImpl valueMapping = new ValueMappingImpl();
    return valueMapping;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefinedContextTypeRef createDefinedContextTypeRef()
  {
    DefinedContextTypeRefImpl definedContextTypeRef = new DefinedContextTypeRefImpl();
    return definedContextTypeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EcoreTypeRef createEcoreTypeRef()
  {
    EcoreTypeRefImpl ecoreTypeRef = new EcoreTypeRefImpl();
    return ecoreTypeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureTypeRef createFeatureTypeRef()
  {
    FeatureTypeRefImpl featureTypeRef = new FeatureTypeRefImpl();
    return featureTypeRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NavigationExpression createNavigationExpression()
  {
    NavigationExpressionImpl navigationExpression = new NavigationExpressionImpl();
    return navigationExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextVarExpression createContextVarExpression()
  {
    ContextVarExpressionImpl contextVarExpression = new ContextVarExpressionImpl();
    return contextVarExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionConversion createExpressionConversion()
  {
    ExpressionConversionImpl expressionConversion = new ExpressionConversionImpl();
    return expressionConversion;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModificationExpressionBlock createModificationExpressionBlock()
  {
    ModificationExpressionBlockImpl modificationExpressionBlock = new ModificationExpressionBlockImpl();
    return modificationExpressionBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SideEnum createSideEnumFromString(EDataType eDataType, String initialValue)
  {
    SideEnum result = SideEnum.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSideEnumToString(EDataType eDataType, Object instanceValue)
  {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BXCorePackage getBXCorePackage()
  {
    return (BXCorePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static BXCorePackage getPackage()
  {
    return BXCorePackage.eINSTANCE;
  }

} //BXCoreFactoryImpl
