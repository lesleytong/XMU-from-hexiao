/**
 */
package edu.ustb.sei.mde.xmu2core.impl;

import edu.ustb.sei.mde.xmu2common.Xmu2commonPackage;

import edu.ustb.sei.mde.xmu2core.AdditiveExpression;
import edu.ustb.sei.mde.xmu2core.AlignStatement;
import edu.ustb.sei.mde.xmu2core.AtomicExpression;
import edu.ustb.sei.mde.xmu2core.BooleanAndExpression;
import edu.ustb.sei.mde.xmu2core.BooleanOrExpression;
import edu.ustb.sei.mde.xmu2core.BooleanValueExpression;
import edu.ustb.sei.mde.xmu2core.CallStatement;
import edu.ustb.sei.mde.xmu2core.Callable;
import edu.ustb.sei.mde.xmu2core.CaseClause;
import edu.ustb.sei.mde.xmu2core.CaseExpressionClause;
import edu.ustb.sei.mde.xmu2core.CasePatternClause;
import edu.ustb.sei.mde.xmu2core.CaseStatement;
import edu.ustb.sei.mde.xmu2core.CaseStatementClause;
import edu.ustb.sei.mde.xmu2core.CheckExpressionStatement;
import edu.ustb.sei.mde.xmu2core.DeleteLinkStatement;
import edu.ustb.sei.mde.xmu2core.DeleteNodeStatement;
import edu.ustb.sei.mde.xmu2core.EmptyValueExpression;
import edu.ustb.sei.mde.xmu2core.EnforceExpressionStatement;
import edu.ustb.sei.mde.xmu2core.EnforceLinkStatement;
import edu.ustb.sei.mde.xmu2core.EnforceNodeStatement;
import edu.ustb.sei.mde.xmu2core.EntryRuleParameter;
import edu.ustb.sei.mde.xmu2core.EnumValueExpression;
import edu.ustb.sei.mde.xmu2core.Expression;
import edu.ustb.sei.mde.xmu2core.FeaturePath;
import edu.ustb.sei.mde.xmu2core.ForEachStatement;
import edu.ustb.sei.mde.xmu2core.Function;
import edu.ustb.sei.mde.xmu2core.IntegerValueExpression;
import edu.ustb.sei.mde.xmu2core.LoopPath;
import edu.ustb.sei.mde.xmu2core.MatchPattern;
import edu.ustb.sei.mde.xmu2core.MultiplicativeExpression;
import edu.ustb.sei.mde.xmu2core.Nullable;
import edu.ustb.sei.mde.xmu2core.ObjectPatternExpression;
import edu.ustb.sei.mde.xmu2core.ObjectValueExpression;
import edu.ustb.sei.mde.xmu2core.OclCollection;
import edu.ustb.sei.mde.xmu2core.OclCollectionType;
import edu.ustb.sei.mde.xmu2core.OperationPath;
import edu.ustb.sei.mde.xmu2core.Path;
import edu.ustb.sei.mde.xmu2core.Pattern;
import edu.ustb.sei.mde.xmu2core.PatternExpression;
import edu.ustb.sei.mde.xmu2core.PatternNode;
import edu.ustb.sei.mde.xmu2core.PositionPath;
import edu.ustb.sei.mde.xmu2core.PrimitiveValueExpression;
import edu.ustb.sei.mde.xmu2core.Procedure;
import edu.ustb.sei.mde.xmu2core.PropertyPatternExpression;
import edu.ustb.sei.mde.xmu2core.RelationalExpression;
import edu.ustb.sei.mde.xmu2core.SolveConstraintStatement;
import edu.ustb.sei.mde.xmu2core.Statement;
import edu.ustb.sei.mde.xmu2core.StringValueExpression;
import edu.ustb.sei.mde.xmu2core.Transformation;
import edu.ustb.sei.mde.xmu2core.TypeCastExpression;
import edu.ustb.sei.mde.xmu2core.TypedElement;
import edu.ustb.sei.mde.xmu2core.UnaryExpression;
import edu.ustb.sei.mde.xmu2core.Variable;
import edu.ustb.sei.mde.xmu2core.VariableExpression;
import edu.ustb.sei.mde.xmu2core.Xmu2coreFactory;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Xmu2corePackageImpl extends EPackageImpl implements Xmu2corePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nullableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass procedureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass alignStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass casePatternClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseExpressionClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseStatementClauseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectPatternExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyPatternExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanOrExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanAndExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationalExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass additiveExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicativeExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atomicExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeCastExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveValueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringValueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanValueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerValueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumValueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emptyValueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectValueExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featurePathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loopPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass positionPathEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entryRuleParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forEachStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteNodeStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteLinkStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enforceNodeStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enforceLinkStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclCollectionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oclCollectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass matchPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkExpressionStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enforceExpressionStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass solveConstraintStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType nullEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType undefinedEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see edu.ustb.sei.mde.xmu2core.Xmu2corePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Xmu2corePackageImpl() {
		super(eNS_URI, Xmu2coreFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link Xmu2corePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Xmu2corePackage init() {
		if (isInited) return (Xmu2corePackage)EPackage.Registry.INSTANCE.getEPackage(Xmu2corePackage.eNS_URI);

		// Obtain or create and register package
		Xmu2corePackageImpl theXmu2corePackage = (Xmu2corePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Xmu2corePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Xmu2corePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		Xmu2commonPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theXmu2corePackage.createPackageContents();

		// Initialize created meta-data
		theXmu2corePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXmu2corePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Xmu2corePackage.eNS_URI, theXmu2corePackage);
		return theXmu2corePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedElement() {
		return typedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElement_Type() {
		return (EReference)typedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNullable() {
		return nullableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNullable_Nullable() {
		return (EAttribute)nullableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallable() {
		return callableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallable_Variables() {
		return (EReference)callableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallable_Parameters() {
		return (EReference)callableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcedure() {
		return procedureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcedure_BackwardStatements() {
		return (EReference)procedureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcedure_ForwardStatements() {
		return (EReference)procedureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStatement() {
		return statementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAlignStatement() {
		return alignStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlignStatement_Source() {
		return (EReference)alignStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlignStatement_View() {
		return (EReference)alignStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlignStatement_Match() {
		return (EReference)alignStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlignStatement_Unmatchv() {
		return (EReference)alignStatementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAlignStatement_Unmatchs() {
		return (EReference)alignStatementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaseStatement() {
		return caseStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCaseStatement_Clauses() {
		return (EReference)caseStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaseClause() {
		return caseClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCaseClause_Action() {
		return (EReference)caseClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCasePatternClause() {
		return casePatternClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCasePatternClause_Condition() {
		return (EReference)casePatternClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaseExpressionClause() {
		return caseExpressionClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCaseExpressionClause_Condition() {
		return (EReference)caseExpressionClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaseStatementClause() {
		return caseStatementClauseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCaseStatementClause_Condition() {
		return (EReference)caseStatementClauseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPattern() {
		return patternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPattern_Root() {
		return (EReference)patternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPattern_Guard() {
		return (EReference)patternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternNode() {
		return patternNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternNode_Variable() {
		return (EReference)patternNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternNode_Type() {
		return (EReference)patternNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternNode_Expressions() {
		return (EReference)patternNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternExpression() {
		return patternExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternExpression_Feature() {
		return (EReference)patternExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternExpression_Selector() {
		return (EReference)patternExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternExpression_Position() {
		return (EReference)patternExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectPatternExpression() {
		return objectPatternExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectPatternExpression_Target() {
		return (EReference)objectPatternExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyPatternExpression() {
		return propertyPatternExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyPatternExpression_Target() {
		return (EReference)propertyPatternExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanOrExpression() {
		return booleanOrExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBooleanOrExpression_Operands() {
		return (EReference)booleanOrExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanAndExpression() {
		return booleanAndExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBooleanAndExpression_Operands() {
		return (EReference)booleanAndExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationalExpression() {
		return relationalExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationalExpression_Left() {
		return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationalExpression_Right() {
		return (EReference)relationalExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationalExpression_Operator() {
		return (EAttribute)relationalExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdditiveExpression() {
		return additiveExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdditiveExpression_Operands() {
		return (EReference)additiveExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdditiveExpression_Operators() {
		return (EAttribute)additiveExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicativeExpression() {
		return multiplicativeExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiplicativeExpression_Operands() {
		return (EReference)multiplicativeExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicativeExpression_Operators() {
		return (EAttribute)multiplicativeExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryExpression() {
		return unaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnaryExpression_Body() {
		return (EReference)unaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnaryExpression_Operator() {
		return (EAttribute)unaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAtomicExpression() {
		return atomicExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAtomicExpression_Paths() {
		return (EReference)atomicExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeCastExpression() {
		return typeCastExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeCastExpression_TargetType() {
		return (EReference)typeCastExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeCastExpression_Body() {
		return (EReference)typeCastExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeCastExpression_SourceType() {
		return (EReference)typeCastExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveValueExpression() {
		return primitiveValueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimitiveValueExpression_Type() {
		return (EReference)primitiveValueExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringValueExpression() {
		return stringValueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringValueExpression_Value() {
		return (EAttribute)stringValueExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanValueExpression() {
		return booleanValueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanValueExpression_Value() {
		return (EAttribute)booleanValueExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerValueExpression() {
		return integerValueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerValueExpression_Value() {
		return (EAttribute)integerValueExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumValueExpression() {
		return enumValueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumValueExpression_Value() {
		return (EReference)enumValueExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmptyValueExpression() {
		return emptyValueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectValueExpression() {
		return objectValueExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectValueExpression_Value() {
		return (EReference)objectValueExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableExpression() {
		return variableExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableExpression_Variable() {
		return (EReference)variableExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPath() {
		return pathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeaturePath() {
		return featurePathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFeaturePath_Feature() {
		return (EReference)featurePathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationPath() {
		return operationPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationPath_Parameters() {
		return (EReference)operationPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationPath_Operation() {
		return (EAttribute)operationPathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoopPath() {
		return loopPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoopPath_Operator() {
		return (EAttribute)loopPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopPath_Iterator() {
		return (EReference)loopPathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLoopPath_Body() {
		return (EReference)loopPathEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPositionPath() {
		return positionPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPositionPath_Value() {
		return (EReference)positionPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPositionPath_Operator() {
		return (EAttribute)positionPathEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallStatement() {
		return callStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallStatement_Callable() {
		return (EReference)callStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallStatement_Parameters() {
		return (EReference)callStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallStatement_UpdatedParameters() {
		return (EReference)callStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformation() {
		return transformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformation_Callables() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformation_DeclaredTypes() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformation_EntryRules() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformation_Packages() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntryRuleParameter() {
		return entryRuleParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntryRuleParameter_Index() {
		return (EAttribute)entryRuleParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEntryRuleParameter_Fragment() {
		return (EAttribute)entryRuleParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getForEachStatement() {
		return forEachStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachStatement_Pattern() {
		return (EReference)forEachStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForEachStatement_Action() {
		return (EReference)forEachStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getForEachStatement_Derived() {
		return (EAttribute)forEachStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteNodeStatement() {
		return deleteNodeStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeleteNodeStatement_Target() {
		return (EReference)deleteNodeStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteLinkStatement() {
		return deleteLinkStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeleteLinkStatement_Target() {
		return (EReference)deleteLinkStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeleteLinkStatement_Source() {
		return (EReference)deleteLinkStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeleteLinkStatement_Feature() {
		return (EReference)deleteLinkStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnforceNodeStatement() {
		return enforceNodeStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnforceNodeStatement_Node() {
		return (EReference)enforceNodeStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnforceNodeStatement_Type() {
		return (EReference)enforceNodeStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnforceNodeStatement_Candidate() {
		return (EReference)enforceNodeStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnforceLinkStatement() {
		return enforceLinkStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnforceLinkStatement_Target() {
		return (EReference)enforceLinkStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnforceLinkStatement_Source() {
		return (EReference)enforceLinkStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnforceLinkStatement_Feature() {
		return (EReference)enforceLinkStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnforceLinkStatement_Selector() {
		return (EReference)enforceLinkStatementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnforceLinkStatement_Position() {
		return (EReference)enforceLinkStatementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnforceLinkStatement_SourceType() {
		return (EReference)enforceLinkStatementEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclCollectionType() {
		return oclCollectionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclCollectionType_Elementtype() {
		return (EReference)oclCollectionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOclCollection() {
		return oclCollectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOclCollection_ElementType() {
		return (EReference)oclCollectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMatchPattern() {
		return matchPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMatchPattern_Pattern() {
		return (EReference)matchPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckExpressionStatement() {
		return checkExpressionStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckExpressionStatement_Expression() {
		return (EReference)checkExpressionStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnforceExpressionStatement() {
		return enforceExpressionStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnforceExpressionStatement_Expression() {
		return (EReference)enforceExpressionStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunction() {
		return functionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_BackwardStatements() {
		return (EReference)functionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_ForwardStatements() {
		return (EReference)functionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSolveConstraintStatement() {
		return solveConstraintStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolveConstraintStatement_Variables() {
		return (EReference)solveConstraintStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSolveConstraintStatement_Constraint() {
		return (EReference)solveConstraintStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNull() {
		return nullEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getUndefined() {
		return undefinedEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xmu2coreFactory getXmu2coreFactory() {
		return (Xmu2coreFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		typedElementEClass = createEClass(TYPED_ELEMENT);
		createEReference(typedElementEClass, TYPED_ELEMENT__TYPE);

		nullableEClass = createEClass(NULLABLE);
		createEAttribute(nullableEClass, NULLABLE__NULLABLE);

		callableEClass = createEClass(CALLABLE);
		createEReference(callableEClass, CALLABLE__VARIABLES);
		createEReference(callableEClass, CALLABLE__PARAMETERS);

		procedureEClass = createEClass(PROCEDURE);
		createEReference(procedureEClass, PROCEDURE__BACKWARD_STATEMENTS);
		createEReference(procedureEClass, PROCEDURE__FORWARD_STATEMENTS);

		variableEClass = createEClass(VARIABLE);

		statementEClass = createEClass(STATEMENT);

		alignStatementEClass = createEClass(ALIGN_STATEMENT);
		createEReference(alignStatementEClass, ALIGN_STATEMENT__SOURCE);
		createEReference(alignStatementEClass, ALIGN_STATEMENT__VIEW);
		createEReference(alignStatementEClass, ALIGN_STATEMENT__MATCH);
		createEReference(alignStatementEClass, ALIGN_STATEMENT__UNMATCHV);
		createEReference(alignStatementEClass, ALIGN_STATEMENT__UNMATCHS);

		caseStatementEClass = createEClass(CASE_STATEMENT);
		createEReference(caseStatementEClass, CASE_STATEMENT__CLAUSES);

		caseClauseEClass = createEClass(CASE_CLAUSE);
		createEReference(caseClauseEClass, CASE_CLAUSE__ACTION);

		casePatternClauseEClass = createEClass(CASE_PATTERN_CLAUSE);
		createEReference(casePatternClauseEClass, CASE_PATTERN_CLAUSE__CONDITION);

		caseExpressionClauseEClass = createEClass(CASE_EXPRESSION_CLAUSE);
		createEReference(caseExpressionClauseEClass, CASE_EXPRESSION_CLAUSE__CONDITION);

		caseStatementClauseEClass = createEClass(CASE_STATEMENT_CLAUSE);
		createEReference(caseStatementClauseEClass, CASE_STATEMENT_CLAUSE__CONDITION);

		patternEClass = createEClass(PATTERN);
		createEReference(patternEClass, PATTERN__ROOT);
		createEReference(patternEClass, PATTERN__GUARD);

		patternNodeEClass = createEClass(PATTERN_NODE);
		createEReference(patternNodeEClass, PATTERN_NODE__VARIABLE);
		createEReference(patternNodeEClass, PATTERN_NODE__TYPE);
		createEReference(patternNodeEClass, PATTERN_NODE__EXPRESSIONS);

		patternExpressionEClass = createEClass(PATTERN_EXPRESSION);
		createEReference(patternExpressionEClass, PATTERN_EXPRESSION__FEATURE);
		createEReference(patternExpressionEClass, PATTERN_EXPRESSION__SELECTOR);
		createEReference(patternExpressionEClass, PATTERN_EXPRESSION__POSITION);

		objectPatternExpressionEClass = createEClass(OBJECT_PATTERN_EXPRESSION);
		createEReference(objectPatternExpressionEClass, OBJECT_PATTERN_EXPRESSION__TARGET);

		propertyPatternExpressionEClass = createEClass(PROPERTY_PATTERN_EXPRESSION);
		createEReference(propertyPatternExpressionEClass, PROPERTY_PATTERN_EXPRESSION__TARGET);

		expressionEClass = createEClass(EXPRESSION);

		booleanOrExpressionEClass = createEClass(BOOLEAN_OR_EXPRESSION);
		createEReference(booleanOrExpressionEClass, BOOLEAN_OR_EXPRESSION__OPERANDS);

		booleanAndExpressionEClass = createEClass(BOOLEAN_AND_EXPRESSION);
		createEReference(booleanAndExpressionEClass, BOOLEAN_AND_EXPRESSION__OPERANDS);

		relationalExpressionEClass = createEClass(RELATIONAL_EXPRESSION);
		createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__LEFT);
		createEReference(relationalExpressionEClass, RELATIONAL_EXPRESSION__RIGHT);
		createEAttribute(relationalExpressionEClass, RELATIONAL_EXPRESSION__OPERATOR);

		additiveExpressionEClass = createEClass(ADDITIVE_EXPRESSION);
		createEReference(additiveExpressionEClass, ADDITIVE_EXPRESSION__OPERANDS);
		createEAttribute(additiveExpressionEClass, ADDITIVE_EXPRESSION__OPERATORS);

		multiplicativeExpressionEClass = createEClass(MULTIPLICATIVE_EXPRESSION);
		createEReference(multiplicativeExpressionEClass, MULTIPLICATIVE_EXPRESSION__OPERANDS);
		createEAttribute(multiplicativeExpressionEClass, MULTIPLICATIVE_EXPRESSION__OPERATORS);

		unaryExpressionEClass = createEClass(UNARY_EXPRESSION);
		createEReference(unaryExpressionEClass, UNARY_EXPRESSION__BODY);
		createEAttribute(unaryExpressionEClass, UNARY_EXPRESSION__OPERATOR);

		atomicExpressionEClass = createEClass(ATOMIC_EXPRESSION);
		createEReference(atomicExpressionEClass, ATOMIC_EXPRESSION__PATHS);

		typeCastExpressionEClass = createEClass(TYPE_CAST_EXPRESSION);
		createEReference(typeCastExpressionEClass, TYPE_CAST_EXPRESSION__TARGET_TYPE);
		createEReference(typeCastExpressionEClass, TYPE_CAST_EXPRESSION__BODY);
		createEReference(typeCastExpressionEClass, TYPE_CAST_EXPRESSION__SOURCE_TYPE);

		primitiveValueExpressionEClass = createEClass(PRIMITIVE_VALUE_EXPRESSION);
		createEReference(primitiveValueExpressionEClass, PRIMITIVE_VALUE_EXPRESSION__TYPE);

		stringValueExpressionEClass = createEClass(STRING_VALUE_EXPRESSION);
		createEAttribute(stringValueExpressionEClass, STRING_VALUE_EXPRESSION__VALUE);

		booleanValueExpressionEClass = createEClass(BOOLEAN_VALUE_EXPRESSION);
		createEAttribute(booleanValueExpressionEClass, BOOLEAN_VALUE_EXPRESSION__VALUE);

		integerValueExpressionEClass = createEClass(INTEGER_VALUE_EXPRESSION);
		createEAttribute(integerValueExpressionEClass, INTEGER_VALUE_EXPRESSION__VALUE);

		enumValueExpressionEClass = createEClass(ENUM_VALUE_EXPRESSION);
		createEReference(enumValueExpressionEClass, ENUM_VALUE_EXPRESSION__VALUE);

		emptyValueExpressionEClass = createEClass(EMPTY_VALUE_EXPRESSION);

		objectValueExpressionEClass = createEClass(OBJECT_VALUE_EXPRESSION);
		createEReference(objectValueExpressionEClass, OBJECT_VALUE_EXPRESSION__VALUE);

		variableExpressionEClass = createEClass(VARIABLE_EXPRESSION);
		createEReference(variableExpressionEClass, VARIABLE_EXPRESSION__VARIABLE);

		pathEClass = createEClass(PATH);

		featurePathEClass = createEClass(FEATURE_PATH);
		createEReference(featurePathEClass, FEATURE_PATH__FEATURE);

		operationPathEClass = createEClass(OPERATION_PATH);
		createEReference(operationPathEClass, OPERATION_PATH__PARAMETERS);
		createEAttribute(operationPathEClass, OPERATION_PATH__OPERATION);

		loopPathEClass = createEClass(LOOP_PATH);
		createEAttribute(loopPathEClass, LOOP_PATH__OPERATOR);
		createEReference(loopPathEClass, LOOP_PATH__ITERATOR);
		createEReference(loopPathEClass, LOOP_PATH__BODY);

		positionPathEClass = createEClass(POSITION_PATH);
		createEReference(positionPathEClass, POSITION_PATH__VALUE);
		createEAttribute(positionPathEClass, POSITION_PATH__OPERATOR);

		callStatementEClass = createEClass(CALL_STATEMENT);
		createEReference(callStatementEClass, CALL_STATEMENT__CALLABLE);
		createEReference(callStatementEClass, CALL_STATEMENT__PARAMETERS);
		createEReference(callStatementEClass, CALL_STATEMENT__UPDATED_PARAMETERS);

		transformationEClass = createEClass(TRANSFORMATION);
		createEReference(transformationEClass, TRANSFORMATION__CALLABLES);
		createEReference(transformationEClass, TRANSFORMATION__DECLARED_TYPES);
		createEReference(transformationEClass, TRANSFORMATION__ENTRY_RULES);
		createEReference(transformationEClass, TRANSFORMATION__PACKAGES);

		entryRuleParameterEClass = createEClass(ENTRY_RULE_PARAMETER);
		createEAttribute(entryRuleParameterEClass, ENTRY_RULE_PARAMETER__INDEX);
		createEAttribute(entryRuleParameterEClass, ENTRY_RULE_PARAMETER__FRAGMENT);

		forEachStatementEClass = createEClass(FOR_EACH_STATEMENT);
		createEReference(forEachStatementEClass, FOR_EACH_STATEMENT__PATTERN);
		createEReference(forEachStatementEClass, FOR_EACH_STATEMENT__ACTION);
		createEAttribute(forEachStatementEClass, FOR_EACH_STATEMENT__DERIVED);

		deleteNodeStatementEClass = createEClass(DELETE_NODE_STATEMENT);
		createEReference(deleteNodeStatementEClass, DELETE_NODE_STATEMENT__TARGET);

		deleteLinkStatementEClass = createEClass(DELETE_LINK_STATEMENT);
		createEReference(deleteLinkStatementEClass, DELETE_LINK_STATEMENT__TARGET);
		createEReference(deleteLinkStatementEClass, DELETE_LINK_STATEMENT__SOURCE);
		createEReference(deleteLinkStatementEClass, DELETE_LINK_STATEMENT__FEATURE);

		enforceNodeStatementEClass = createEClass(ENFORCE_NODE_STATEMENT);
		createEReference(enforceNodeStatementEClass, ENFORCE_NODE_STATEMENT__NODE);
		createEReference(enforceNodeStatementEClass, ENFORCE_NODE_STATEMENT__TYPE);
		createEReference(enforceNodeStatementEClass, ENFORCE_NODE_STATEMENT__CANDIDATE);

		enforceLinkStatementEClass = createEClass(ENFORCE_LINK_STATEMENT);
		createEReference(enforceLinkStatementEClass, ENFORCE_LINK_STATEMENT__TARGET);
		createEReference(enforceLinkStatementEClass, ENFORCE_LINK_STATEMENT__SOURCE);
		createEReference(enforceLinkStatementEClass, ENFORCE_LINK_STATEMENT__FEATURE);
		createEReference(enforceLinkStatementEClass, ENFORCE_LINK_STATEMENT__SELECTOR);
		createEReference(enforceLinkStatementEClass, ENFORCE_LINK_STATEMENT__POSITION);
		createEReference(enforceLinkStatementEClass, ENFORCE_LINK_STATEMENT__SOURCE_TYPE);

		oclCollectionTypeEClass = createEClass(OCL_COLLECTION_TYPE);
		createEReference(oclCollectionTypeEClass, OCL_COLLECTION_TYPE__ELEMENTTYPE);

		oclCollectionEClass = createEClass(OCL_COLLECTION);
		createEReference(oclCollectionEClass, OCL_COLLECTION__ELEMENT_TYPE);

		matchPatternEClass = createEClass(MATCH_PATTERN);
		createEReference(matchPatternEClass, MATCH_PATTERN__PATTERN);

		checkExpressionStatementEClass = createEClass(CHECK_EXPRESSION_STATEMENT);
		createEReference(checkExpressionStatementEClass, CHECK_EXPRESSION_STATEMENT__EXPRESSION);

		enforceExpressionStatementEClass = createEClass(ENFORCE_EXPRESSION_STATEMENT);
		createEReference(enforceExpressionStatementEClass, ENFORCE_EXPRESSION_STATEMENT__EXPRESSION);

		functionEClass = createEClass(FUNCTION);
		createEReference(functionEClass, FUNCTION__BACKWARD_STATEMENTS);
		createEReference(functionEClass, FUNCTION__FORWARD_STATEMENTS);

		solveConstraintStatementEClass = createEClass(SOLVE_CONSTRAINT_STATEMENT);
		createEReference(solveConstraintStatementEClass, SOLVE_CONSTRAINT_STATEMENT__VARIABLES);
		createEReference(solveConstraintStatementEClass, SOLVE_CONSTRAINT_STATEMENT__CONSTRAINT);

		// Create data types
		nullEDataType = createEDataType(NULL);
		undefinedEDataType = createEDataType(UNDEFINED);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		Xmu2commonPackage theXmu2commonPackage = (Xmu2commonPackage)EPackage.Registry.INSTANCE.getEPackage(Xmu2commonPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		callableEClass.getESuperTypes().add(theXmu2commonPackage.getNamedElement());
		procedureEClass.getESuperTypes().add(this.getCallable());
		variableEClass.getESuperTypes().add(theXmu2commonPackage.getNamedElement());
		variableEClass.getESuperTypes().add(this.getTypedElement());
		variableEClass.getESuperTypes().add(theXmu2commonPackage.getDomainElement());
		alignStatementEClass.getESuperTypes().add(this.getStatement());
		caseStatementEClass.getESuperTypes().add(this.getStatement());
		caseStatementEClass.getESuperTypes().add(theXmu2commonPackage.getDomainElement());
		casePatternClauseEClass.getESuperTypes().add(this.getCaseClause());
		caseExpressionClauseEClass.getESuperTypes().add(this.getCaseClause());
		caseStatementClauseEClass.getESuperTypes().add(this.getCaseClause());
		patternExpressionEClass.getESuperTypes().add(this.getNullable());
		objectPatternExpressionEClass.getESuperTypes().add(this.getPatternExpression());
		propertyPatternExpressionEClass.getESuperTypes().add(this.getPatternExpression());
		booleanOrExpressionEClass.getESuperTypes().add(this.getExpression());
		booleanAndExpressionEClass.getESuperTypes().add(this.getExpression());
		relationalExpressionEClass.getESuperTypes().add(this.getExpression());
		additiveExpressionEClass.getESuperTypes().add(this.getExpression());
		multiplicativeExpressionEClass.getESuperTypes().add(this.getExpression());
		unaryExpressionEClass.getESuperTypes().add(this.getExpression());
		atomicExpressionEClass.getESuperTypes().add(this.getExpression());
		typeCastExpressionEClass.getESuperTypes().add(this.getAtomicExpression());
		primitiveValueExpressionEClass.getESuperTypes().add(this.getAtomicExpression());
		stringValueExpressionEClass.getESuperTypes().add(this.getPrimitiveValueExpression());
		booleanValueExpressionEClass.getESuperTypes().add(this.getPrimitiveValueExpression());
		integerValueExpressionEClass.getESuperTypes().add(this.getPrimitiveValueExpression());
		enumValueExpressionEClass.getESuperTypes().add(this.getPrimitiveValueExpression());
		emptyValueExpressionEClass.getESuperTypes().add(this.getPrimitiveValueExpression());
		objectValueExpressionEClass.getESuperTypes().add(this.getAtomicExpression());
		variableExpressionEClass.getESuperTypes().add(this.getAtomicExpression());
		featurePathEClass.getESuperTypes().add(this.getPath());
		operationPathEClass.getESuperTypes().add(this.getPath());
		loopPathEClass.getESuperTypes().add(this.getPath());
		positionPathEClass.getESuperTypes().add(this.getPath());
		callStatementEClass.getESuperTypes().add(this.getStatement());
		transformationEClass.getESuperTypes().add(theXmu2commonPackage.getNamedElement());
		entryRuleParameterEClass.getESuperTypes().add(this.getExpression());
		entryRuleParameterEClass.getESuperTypes().add(theXmu2commonPackage.getDomainElement());
		forEachStatementEClass.getESuperTypes().add(this.getStatement());
		deleteNodeStatementEClass.getESuperTypes().add(this.getStatement());
		deleteLinkStatementEClass.getESuperTypes().add(this.getStatement());
		enforceNodeStatementEClass.getESuperTypes().add(this.getStatement());
		enforceNodeStatementEClass.getESuperTypes().add(theXmu2commonPackage.getDomainElement());
		enforceNodeStatementEClass.getESuperTypes().add(this.getNullable());
		enforceLinkStatementEClass.getESuperTypes().add(this.getStatement());
		enforceLinkStatementEClass.getESuperTypes().add(theXmu2commonPackage.getDomainElement());
		oclCollectionTypeEClass.getESuperTypes().add(ecorePackage.getEClass());
		matchPatternEClass.getESuperTypes().add(this.getStatement());
		checkExpressionStatementEClass.getESuperTypes().add(this.getStatement());
		enforceExpressionStatementEClass.getESuperTypes().add(this.getStatement());
		functionEClass.getESuperTypes().add(this.getCallable());
		solveConstraintStatementEClass.getESuperTypes().add(this.getStatement());

		// Initialize classes, features, and operations; add parameters
		initEClass(typedElementEClass, TypedElement.class, "TypedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedElement_Type(), ecorePackage.getEClassifier(), null, "type", null, 1, 1, TypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nullableEClass, Nullable.class, "Nullable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNullable_Nullable(), ecorePackage.getEBoolean(), "nullable", "false", 1, 1, Nullable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callableEClass, Callable.class, "Callable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallable_Variables(), this.getVariable(), null, "variables", null, 0, -1, Callable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallable_Parameters(), this.getVariable(), null, "parameters", null, 0, -1, Callable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(procedureEClass, Procedure.class, "Procedure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcedure_BackwardStatements(), this.getStatement(), null, "backwardStatements", null, 0, -1, Procedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProcedure_ForwardStatements(), this.getStatement(), null, "forwardStatements", null, 0, -1, Procedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(statementEClass, Statement.class, "Statement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(alignStatementEClass, AlignStatement.class, "AlignStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAlignStatement_Source(), this.getPattern(), null, "source", null, 1, 1, AlignStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlignStatement_View(), this.getPattern(), null, "view", null, 1, 1, AlignStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlignStatement_Match(), this.getStatement(), null, "match", null, 0, -1, AlignStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlignStatement_Unmatchv(), this.getStatement(), null, "unmatchv", null, 0, -1, AlignStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAlignStatement_Unmatchs(), this.getStatement(), null, "unmatchs", null, 0, -1, AlignStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caseStatementEClass, CaseStatement.class, "CaseStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCaseStatement_Clauses(), this.getCaseClause(), null, "clauses", null, 1, -1, CaseStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caseClauseEClass, CaseClause.class, "CaseClause", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCaseClause_Action(), this.getStatement(), null, "action", null, 0, -1, CaseClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(casePatternClauseEClass, CasePatternClause.class, "CasePatternClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCasePatternClause_Condition(), this.getPattern(), null, "condition", null, 1, 1, CasePatternClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caseExpressionClauseEClass, CaseExpressionClause.class, "CaseExpressionClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCaseExpressionClause_Condition(), this.getExpression(), null, "condition", null, 1, 1, CaseExpressionClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caseStatementClauseEClass, CaseStatementClause.class, "CaseStatementClause", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCaseStatementClause_Condition(), this.getStatement(), null, "condition", null, 0, -1, CaseStatementClause.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternEClass, Pattern.class, "Pattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPattern_Root(), this.getPatternNode(), null, "root", null, 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPattern_Guard(), this.getExpression(), null, "guard", null, 0, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternNodeEClass, PatternNode.class, "PatternNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternNode_Variable(), this.getVariable(), null, "variable", null, 1, 1, PatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternNode_Type(), ecorePackage.getEClass(), null, "type", null, 1, 1, PatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternNode_Expressions(), this.getPatternExpression(), null, "expressions", null, 0, -1, PatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternExpressionEClass, PatternExpression.class, "PatternExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternExpression_Feature(), ecorePackage.getEStructuralFeature(), null, "feature", null, 1, 1, PatternExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternExpression_Selector(), this.getLoopPath(), null, "selector", null, 0, 1, PatternExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternExpression_Position(), this.getPositionPath(), null, "position", null, 0, 1, PatternExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectPatternExpressionEClass, ObjectPatternExpression.class, "ObjectPatternExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectPatternExpression_Target(), this.getPatternNode(), null, "target", null, 1, 1, ObjectPatternExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyPatternExpressionEClass, PropertyPatternExpression.class, "PropertyPatternExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyPatternExpression_Target(), this.getExpression(), null, "target", null, 1, 1, PropertyPatternExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionEClass, Expression.class, "Expression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanOrExpressionEClass, BooleanOrExpression.class, "BooleanOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBooleanOrExpression_Operands(), this.getExpression(), null, "operands", null, 0, -1, BooleanOrExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanAndExpressionEClass, BooleanAndExpression.class, "BooleanAndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBooleanAndExpression_Operands(), this.getExpression(), null, "operands", null, 0, -1, BooleanAndExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationalExpressionEClass, RelationalExpression.class, "RelationalExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationalExpression_Left(), this.getExpression(), null, "left", null, 1, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationalExpression_Right(), this.getExpression(), null, "right", null, 1, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationalExpression_Operator(), theXmu2commonPackage.getRelationalOperator(), "operator", null, 1, 1, RelationalExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(additiveExpressionEClass, AdditiveExpression.class, "AdditiveExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdditiveExpression_Operands(), this.getExpression(), null, "operands", null, 0, -1, AdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdditiveExpression_Operators(), theXmu2commonPackage.getAdditiveOperator(), "operators", null, 0, -1, AdditiveExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiplicativeExpressionEClass, MultiplicativeExpression.class, "MultiplicativeExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiplicativeExpression_Operands(), this.getExpression(), null, "operands", null, 0, -1, MultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiplicativeExpression_Operators(), theXmu2commonPackage.getMultiplicativeOperator(), "operators", null, 0, -1, MultiplicativeExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unaryExpressionEClass, UnaryExpression.class, "UnaryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnaryExpression_Body(), this.getExpression(), null, "body", null, 1, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnaryExpression_Operator(), theXmu2commonPackage.getUnaryOperator(), "operator", null, 1, 1, UnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(atomicExpressionEClass, AtomicExpression.class, "AtomicExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAtomicExpression_Paths(), this.getPath(), null, "paths", null, 0, -1, AtomicExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeCastExpressionEClass, TypeCastExpression.class, "TypeCastExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeCastExpression_TargetType(), ecorePackage.getEClassifier(), null, "targetType", null, 1, 1, TypeCastExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeCastExpression_Body(), this.getExpression(), null, "body", null, 1, 1, TypeCastExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeCastExpression_SourceType(), ecorePackage.getEClassifier(), null, "sourceType", null, 1, 1, TypeCastExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveValueExpressionEClass, PrimitiveValueExpression.class, "PrimitiveValueExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrimitiveValueExpression_Type(), ecorePackage.getEDataType(), null, "type", null, 0, 1, PrimitiveValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringValueExpressionEClass, StringValueExpression.class, "StringValueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringValueExpression_Value(), ecorePackage.getEString(), "value", null, 0, 1, StringValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanValueExpressionEClass, BooleanValueExpression.class, "BooleanValueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanValueExpression_Value(), ecorePackage.getEBoolean(), "value", null, 1, 1, BooleanValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerValueExpressionEClass, IntegerValueExpression.class, "IntegerValueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerValueExpression_Value(), ecorePackage.getEInt(), "value", null, 1, 1, IntegerValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumValueExpressionEClass, EnumValueExpression.class, "EnumValueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumValueExpression_Value(), ecorePackage.getEEnumLiteral(), null, "value", null, 1, 1, EnumValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(emptyValueExpressionEClass, EmptyValueExpression.class, "EmptyValueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectValueExpressionEClass, ObjectValueExpression.class, "ObjectValueExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectValueExpression_Value(), ecorePackage.getEObject(), null, "value", null, 1, 1, ObjectValueExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableExpressionEClass, VariableExpression.class, "VariableExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableExpression_Variable(), this.getVariable(), null, "variable", null, 1, 1, VariableExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathEClass, Path.class, "Path", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(featurePathEClass, FeaturePath.class, "FeaturePath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeaturePath_Feature(), ecorePackage.getEStructuralFeature(), null, "feature", null, 1, 1, FeaturePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationPathEClass, OperationPath.class, "OperationPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationPath_Parameters(), this.getExpression(), null, "parameters", null, 0, -1, OperationPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperationPath_Operation(), ecorePackage.getEString(), "operation", null, 1, 1, OperationPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loopPathEClass, LoopPath.class, "LoopPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoopPath_Operator(), theXmu2commonPackage.getLoopOperator(), "operator", null, 1, 1, LoopPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoopPath_Iterator(), this.getVariable(), null, "iterator", null, 1, 1, LoopPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoopPath_Body(), this.getExpression(), null, "body", null, 1, 1, LoopPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(positionPathEClass, PositionPath.class, "PositionPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPositionPath_Value(), this.getExpression(), null, "value", null, 0, 1, PositionPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPositionPath_Operator(), theXmu2commonPackage.getPositionOperator(), "operator", null, 1, 1, PositionPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callStatementEClass, CallStatement.class, "CallStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallStatement_Callable(), this.getCallable(), null, "callable", null, 1, 1, CallStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallStatement_Parameters(), this.getExpression(), null, "parameters", null, 0, -1, CallStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCallStatement_UpdatedParameters(), this.getExpression(), null, "updatedParameters", null, 0, -1, CallStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationEClass, Transformation.class, "Transformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformation_Callables(), this.getCallable(), null, "callables", null, 0, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformation_DeclaredTypes(), ecorePackage.getEClassifier(), null, "declaredTypes", null, 0, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformation_EntryRules(), this.getCallStatement(), null, "entryRules", null, 0, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformation_Packages(), ecorePackage.getEPackage(), null, "packages", null, 0, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entryRuleParameterEClass, EntryRuleParameter.class, "EntryRuleParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEntryRuleParameter_Index(), ecorePackage.getEInt(), "index", null, 1, 1, EntryRuleParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEntryRuleParameter_Fragment(), ecorePackage.getEString(), "fragment", null, 0, 1, EntryRuleParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forEachStatementEClass, ForEachStatement.class, "ForEachStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForEachStatement_Pattern(), this.getPattern(), null, "pattern", null, 1, 1, ForEachStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForEachStatement_Action(), this.getStatement(), null, "action", null, 0, -1, ForEachStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getForEachStatement_Derived(), ecorePackage.getEBoolean(), "derived", "false", 1, 1, ForEachStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deleteNodeStatementEClass, DeleteNodeStatement.class, "DeleteNodeStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeleteNodeStatement_Target(), this.getVariable(), null, "target", null, 1, 1, DeleteNodeStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deleteLinkStatementEClass, DeleteLinkStatement.class, "DeleteLinkStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeleteLinkStatement_Target(), this.getExpression(), null, "target", null, 1, 1, DeleteLinkStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeleteLinkStatement_Source(), this.getVariable(), null, "source", null, 1, 1, DeleteLinkStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeleteLinkStatement_Feature(), ecorePackage.getEStructuralFeature(), null, "feature", null, 1, 1, DeleteLinkStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enforceNodeStatementEClass, EnforceNodeStatement.class, "EnforceNodeStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnforceNodeStatement_Node(), this.getVariable(), null, "node", null, 1, 1, EnforceNodeStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnforceNodeStatement_Type(), ecorePackage.getEClassifier(), null, "type", null, 1, 1, EnforceNodeStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnforceNodeStatement_Candidate(), this.getVariableExpression(), null, "candidate", null, 0, 1, EnforceNodeStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enforceLinkStatementEClass, EnforceLinkStatement.class, "EnforceLinkStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnforceLinkStatement_Target(), this.getExpression(), null, "target", null, 1, 1, EnforceLinkStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnforceLinkStatement_Source(), this.getVariable(), null, "source", null, 1, 1, EnforceLinkStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnforceLinkStatement_Feature(), ecorePackage.getEStructuralFeature(), null, "feature", null, 1, 1, EnforceLinkStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnforceLinkStatement_Selector(), this.getLoopPath(), null, "selector", null, 0, 1, EnforceLinkStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnforceLinkStatement_Position(), this.getPositionPath(), null, "position", null, 0, 1, EnforceLinkStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnforceLinkStatement_SourceType(), ecorePackage.getEClassifier(), null, "sourceType", null, 1, 1, EnforceLinkStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oclCollectionTypeEClass, OclCollectionType.class, "OclCollectionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOclCollectionType_Elementtype(), ecorePackage.getEClassifier(), null, "elementtype", null, 1, 1, OclCollectionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oclCollectionEClass, OclCollection.class, "OclCollection", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOclCollection_ElementType(), ecorePackage.getEClassifier(), null, "elementType", null, 1, 1, OclCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(matchPatternEClass, MatchPattern.class, "MatchPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMatchPattern_Pattern(), this.getPattern(), null, "pattern", null, 1, 1, MatchPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(checkExpressionStatementEClass, CheckExpressionStatement.class, "CheckExpressionStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCheckExpressionStatement_Expression(), this.getExpression(), null, "expression", null, 1, 1, CheckExpressionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enforceExpressionStatementEClass, EnforceExpressionStatement.class, "EnforceExpressionStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnforceExpressionStatement_Expression(), this.getExpression(), null, "expression", null, 1, 1, EnforceExpressionStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunction_BackwardStatements(), this.getStatement(), null, "backwardStatements", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_ForwardStatements(), this.getStatement(), null, "forwardStatements", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(solveConstraintStatementEClass, SolveConstraintStatement.class, "SolveConstraintStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSolveConstraintStatement_Variables(), this.getVariable(), null, "variables", null, 0, -1, SolveConstraintStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSolveConstraintStatement_Constraint(), this.getExpression(), null, "constraint", null, 1, 1, SolveConstraintStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(nullEDataType, Object.class, "Null", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(undefinedEDataType, Object.class, "Undefined", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //Xmu2corePackageImpl
