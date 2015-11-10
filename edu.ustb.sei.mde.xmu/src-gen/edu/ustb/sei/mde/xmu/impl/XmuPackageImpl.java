/**
 */
package edu.ustb.sei.mde.xmu.impl;

import edu.ustb.sei.mde.xmu.AdditiveExpr;
import edu.ustb.sei.mde.xmu.AdditiveExprChild;
import edu.ustb.sei.mde.xmu.AdditiveOperator;
import edu.ustb.sei.mde.xmu.AllInstanceExpr;
import edu.ustb.sei.mde.xmu.AtomicExpr;
import edu.ustb.sei.mde.xmu.BlockStatement;
import edu.ustb.sei.mde.xmu.BooleanAndExpr;
import edu.ustb.sei.mde.xmu.BooleanAndExprChild;
import edu.ustb.sei.mde.xmu.BooleanLiteral;
import edu.ustb.sei.mde.xmu.BooleanOrExpr;
import edu.ustb.sei.mde.xmu.BooleanOrExprChild;
import edu.ustb.sei.mde.xmu.CaseDefaultStatement;
import edu.ustb.sei.mde.xmu.CasePatternStatement;
import edu.ustb.sei.mde.xmu.CaseSubStatement;
import edu.ustb.sei.mde.xmu.CaseValueStatement;
import edu.ustb.sei.mde.xmu.ConstantExpr;
import edu.ustb.sei.mde.xmu.DefaultVStatement;
import edu.ustb.sei.mde.xmu.DeleteLink;
import edu.ustb.sei.mde.xmu.DeleteNode;
import edu.ustb.sei.mde.xmu.EResource;
import edu.ustb.sei.mde.xmu.ESet;
import edu.ustb.sei.mde.xmu.EmptyLiteral;
import edu.ustb.sei.mde.xmu.EmptyType;
import edu.ustb.sei.mde.xmu.EnumLiteral;
import edu.ustb.sei.mde.xmu.Expr;
import edu.ustb.sei.mde.xmu.Fail;
import edu.ustb.sei.mde.xmu.FeaturePath;
import edu.ustb.sei.mde.xmu.ForStatement;
import edu.ustb.sei.mde.xmu.HelperMapping;
import edu.ustb.sei.mde.xmu.HelperMappingEntry;
import edu.ustb.sei.mde.xmu.HelperPath;
import edu.ustb.sei.mde.xmu.InitialMappingStatement;
import edu.ustb.sei.mde.xmu.IntegerLiteral;
import edu.ustb.sei.mde.xmu.LoopOperator;
import edu.ustb.sei.mde.xmu.LoopPath;
import edu.ustb.sei.mde.xmu.MultiplicativeExpr;
import edu.ustb.sei.mde.xmu.MultiplicativeExprChild;
import edu.ustb.sei.mde.xmu.MultiplicativeOperator;
import edu.ustb.sei.mde.xmu.NamedElement;
import edu.ustb.sei.mde.xmu.ObjectPathExpr;
import edu.ustb.sei.mde.xmu.ObjectVariable;
import edu.ustb.sei.mde.xmu.OperationPath;
import edu.ustb.sei.mde.xmu.Parameter;
import edu.ustb.sei.mde.xmu.ParenExpr;
import edu.ustb.sei.mde.xmu.Path;
import edu.ustb.sei.mde.xmu.Pattern;
import edu.ustb.sei.mde.xmu.PatternEqualExpr;
import edu.ustb.sei.mde.xmu.PatternExpr;
import edu.ustb.sei.mde.xmu.PatternNode;
import edu.ustb.sei.mde.xmu.PatternReferenceExpr;
import edu.ustb.sei.mde.xmu.PrimitiveVariable;
import edu.ustb.sei.mde.xmu.PrintStatement;
import edu.ustb.sei.mde.xmu.PseudoUpdate;
import edu.ustb.sei.mde.xmu.RelationalExpr;
import edu.ustb.sei.mde.xmu.RelationalExprChild;
import edu.ustb.sei.mde.xmu.RelationalOperator;
import edu.ustb.sei.mde.xmu.Rule;
import edu.ustb.sei.mde.xmu.RuleCallStatement;
import edu.ustb.sei.mde.xmu.Skip;
import edu.ustb.sei.mde.xmu.StartRoot;
import edu.ustb.sei.mde.xmu.StartStatement;
import edu.ustb.sei.mde.xmu.Statement;
import edu.ustb.sei.mde.xmu.StringLiteral;
import edu.ustb.sei.mde.xmu.SwitchStatement;
import edu.ustb.sei.mde.xmu.TaggedElement;
import edu.ustb.sei.mde.xmu.TaggedVStatement;
import edu.ustb.sei.mde.xmu.UnaryExpr;
import edu.ustb.sei.mde.xmu.UnaryExprChild;
import edu.ustb.sei.mde.xmu.UnaryOperator;
import edu.ustb.sei.mde.xmu.Update;
import edu.ustb.sei.mde.xmu.UpdatePattern;
import edu.ustb.sei.mde.xmu.VStatement;
import edu.ustb.sei.mde.xmu.VStmtType;
import edu.ustb.sei.mde.xmu.Variable;
import edu.ustb.sei.mde.xmu.VariableExp;
import edu.ustb.sei.mde.xmu.VariableFlag;
import edu.ustb.sei.mde.xmu.XMUModel;
import edu.ustb.sei.mde.xmu.XmuFactory;
import edu.ustb.sei.mde.xmu.XmuPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class XmuPackageImpl extends EPackageImpl implements XmuPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementEClass = null;

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
	private EClass objectVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleEClass = null;

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
	private EClass forStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deleteLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass updatePatternEClass = null;

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
	private EClass patternExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternReferenceExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternEqualExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constantExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emptyLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumLiteralEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass defaultVStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taggedVStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass switchStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass taggedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseSubStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass casePatternStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseValueStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caseDefaultStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xmuModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleCallStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanOrExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanOrExprChildEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanAndExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanAndExprChildEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationalExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationalExprChildEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass additiveExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass additiveExprChildEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicativeExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass multiplicativeExprChildEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryExprChildEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass atomicExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parenExprEClass = null;

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
	private EClass helperPathEClass = null;

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
	private EClass startStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass startRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass printStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allInstanceExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectPathExprEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initialMappingStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass helperMappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass helperMappingEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pseudoUpdateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass skipEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass failEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum variableFlagEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum relationalOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum emptyTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum vStmtTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum additiveOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum multiplicativeOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum unaryOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum loopOperatorEEnum = null;

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
	 * @see edu.ustb.sei.mde.xmu.XmuPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private XmuPackageImpl() {
		super(eNS_URI, XmuFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link XmuPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static XmuPackage init() {
		if (isInited) return (XmuPackage)EPackage.Registry.INSTANCE.getEPackage(XmuPackage.eNS_URI);

		// Obtain or create and register package
		XmuPackageImpl theXmuPackage = (XmuPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof XmuPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new XmuPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theXmuPackage.createPackageContents();

		// Initialize created meta-data
		theXmuPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theXmuPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(XmuPackage.eNS_URI, theXmuPackage);
		return theXmuPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
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
	public EClass getObjectVariable() {
		return objectVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveVariable() {
		return primitiveVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrimitiveVariable_Type() {
		return (EReference)primitiveVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRule() {
		return ruleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_NVars() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_SVars() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_SpVars() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_VVars() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_Statement() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_Parameters() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(0);
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
	public EClass getForStatement() {
		return forStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForStatement_SPattern() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForStatement_VPattern() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForStatement_Actions() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getForStatement_When() {
		return (EReference)forStatementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdate() {
		return updateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteNode() {
		return deleteNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeleteNode_Variable() {
		return (EReference)deleteNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeleteLink() {
		return deleteLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeleteLink_Source() {
		return (EReference)deleteLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeleteLink_Target() {
		return (EReference)deleteLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeleteLink_Feature() {
		return (EReference)deleteLinkEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpdatePattern() {
		return updatePatternEClass;
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
	public EReference getPatternNode_Expr() {
		return (EReference)patternNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternExpr() {
		return patternExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternReferenceExpr() {
		return patternReferenceExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternReferenceExpr_Reference() {
		return (EReference)patternReferenceExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternReferenceExpr_Node() {
		return (EReference)patternReferenceExprEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternReferenceExpr_Pos() {
		return (EReference)patternReferenceExprEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPatternEqualExpr() {
		return patternEqualExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternEqualExpr_Feature() {
		return (EReference)patternEqualExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternEqualExpr_Value() {
		return (EReference)patternEqualExprEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPatternEqualExpr_Pos() {
		return (EReference)patternEqualExprEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpr() {
		return exprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableExp() {
		return variableExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableExp_Var() {
		return (EReference)variableExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableExp_Path() {
		return (EReference)variableExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstantExpr() {
		return constantExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstantExpr_Path() {
		return (EReference)constantExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmptyLiteral() {
		return emptyLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEmptyLiteral_Value() {
		return (EAttribute)emptyLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringLiteral() {
		return stringLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringLiteral_Value() {
		return (EAttribute)stringLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerLiteral() {
		return integerLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerLiteral_Value() {
		return (EAttribute)integerLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanLiteral() {
		return booleanLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanLiteral_Value() {
		return (EAttribute)booleanLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumLiteral() {
		return enumLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumLiteral_Type() {
		return (EReference)enumLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumLiteral_Value() {
		return (EReference)enumLiteralEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVStatement() {
		return vStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVStatement_Tag() {
		return (EAttribute)vStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVStatement_Statement() {
		return (EReference)vStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefaultVStatement() {
		return defaultVStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaggedVStatement() {
		return taggedVStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlockStatement() {
		return blockStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlockStatement_Statements() {
		return (EReference)blockStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSwitchStatement() {
		return switchStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchStatement_Var() {
		return (EReference)switchStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSwitchStatement_Cases() {
		return (EReference)switchStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTaggedElement() {
		return taggedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTaggedElement_Tag() {
		return (EAttribute)taggedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaseSubStatement() {
		return caseSubStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCaseSubStatement_Statement() {
		return (EReference)caseSubStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCaseSubStatement_When() {
		return (EReference)caseSubStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCasePatternStatement() {
		return casePatternStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCasePatternStatement_Pattern() {
		return (EReference)casePatternStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaseValueStatement() {
		return caseValueStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCaseValueStatement_Expression() {
		return (EReference)caseValueStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCaseDefaultStatement() {
		return caseDefaultStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getXMUModel() {
		return xmuModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXMUModel_InitialMappings() {
		return (EReference)xmuModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXMUModel_HelperMappings() {
		return (EReference)xmuModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXMUModel_Rules() {
		return (EReference)xmuModelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXMUModel_Packages() {
		return (EReference)xmuModelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getXMUModel_Start() {
		return (EReference)xmuModelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameter_Variable() {
		return (EReference)parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleCallStatement() {
		return ruleCallStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleCallStatement_ActualParameters() {
		return (EReference)ruleCallStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleCallStatement_Rule() {
		return (EReference)ruleCallStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanOrExpr() {
		return booleanOrExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBooleanOrExpr_Operands() {
		return (EReference)booleanOrExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanOrExprChild() {
		return booleanOrExprChildEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanAndExpr() {
		return booleanAndExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBooleanAndExpr_Operands() {
		return (EReference)booleanAndExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanAndExprChild() {
		return booleanAndExprChildEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationalExpr() {
		return relationalExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationalExpr_Left() {
		return (EReference)relationalExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationalExpr_Right() {
		return (EReference)relationalExprEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelationalExpr_Operator() {
		return (EAttribute)relationalExprEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationalExprChild() {
		return relationalExprChildEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdditiveExpr() {
		return additiveExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAdditiveExpr_Operands() {
		return (EReference)additiveExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAdditiveExpr_Operators() {
		return (EAttribute)additiveExprEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdditiveExprChild() {
		return additiveExprChildEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicativeExpr() {
		return multiplicativeExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMultiplicativeExpr_Operands() {
		return (EReference)multiplicativeExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMultiplicativeExpr_Operators() {
		return (EAttribute)multiplicativeExprEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMultiplicativeExprChild() {
		return multiplicativeExprChildEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryExpr() {
		return unaryExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnaryExpr_Body() {
		return (EReference)unaryExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUnaryExpr_Operator() {
		return (EAttribute)unaryExprEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryExprChild() {
		return unaryExprChildEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAtomicExpr() {
		return atomicExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParenExpr() {
		return parenExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParenExpr_Body() {
		return (EReference)parenExprEClass.getEStructuralFeatures().get(0);
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
	public EClass getHelperPath() {
		return helperPathEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHelperPath_Helper() {
		return (EReference)helperPathEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getFeaturePath_Feature() {
		return (EAttribute)featurePathEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getOperationPath_Operation() {
		return (EAttribute)operationPathEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationPath_Parameters() {
		return (EReference)operationPathEClass.getEStructuralFeatures().get(1);
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
	public EReference getLoopPath_Variable() {
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
	public EClass getStartStatement() {
		return startStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStartStatement_Rule() {
		return (EReference)startStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStartStatement_Root() {
		return (EReference)startStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStartRoot() {
		return startRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStartRoot_Id() {
		return (EAttribute)startRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEResource() {
		return eResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEResource_Content() {
		return (EReference)eResourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrintStatement() {
		return printStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPrintStatement_Expr() {
		return (EReference)printStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllInstanceExpr() {
		return allInstanceExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAllInstanceExpr_Root() {
		return (EReference)allInstanceExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAllInstanceExpr_Type() {
		return (EReference)allInstanceExprEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getESet() {
		return eSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getESet_Content() {
		return (EReference)eSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectPathExpr() {
		return objectPathExprEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectPathExpr_Object() {
		return (EReference)objectPathExprEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitialMappingStatement() {
		return initialMappingStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInitialMappingStatement_Source() {
		return (EReference)initialMappingStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInitialMappingStatement_Target() {
		return (EReference)initialMappingStatementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHelperMapping() {
		return helperMappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHelperMapping_Entries() {
		return (EReference)helperMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getHelperMapping_DefaultEqual() {
		return (EAttribute)helperMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHelperMappingEntry() {
		return helperMappingEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHelperMappingEntry_Left() {
		return (EReference)helperMappingEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHelperMappingEntry_Right() {
		return (EReference)helperMappingEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPseudoUpdate() {
		return pseudoUpdateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPseudoUpdate_Message() {
		return (EAttribute)pseudoUpdateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSkip() {
		return skipEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFail() {
		return failEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVariableFlag() {
		return variableFlagEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRelationalOperator() {
		return relationalOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getEmptyType() {
		return emptyTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVStmtType() {
		return vStmtTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAdditiveOperator() {
		return additiveOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getMultiplicativeOperator() {
		return multiplicativeOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUnaryOperator() {
		return unaryOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLoopOperator() {
		return loopOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XmuFactory getXmuFactory() {
		return (XmuFactory)getEFactoryInstance();
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
		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

		variableEClass = createEClass(VARIABLE);

		objectVariableEClass = createEClass(OBJECT_VARIABLE);

		primitiveVariableEClass = createEClass(PRIMITIVE_VARIABLE);
		createEReference(primitiveVariableEClass, PRIMITIVE_VARIABLE__TYPE);

		ruleEClass = createEClass(RULE);
		createEReference(ruleEClass, RULE__PARAMETERS);
		createEReference(ruleEClass, RULE__NVARS);
		createEReference(ruleEClass, RULE__SVARS);
		createEReference(ruleEClass, RULE__SP_VARS);
		createEReference(ruleEClass, RULE__VVARS);
		createEReference(ruleEClass, RULE__STATEMENT);

		statementEClass = createEClass(STATEMENT);

		forStatementEClass = createEClass(FOR_STATEMENT);
		createEReference(forStatementEClass, FOR_STATEMENT__SPATTERN);
		createEReference(forStatementEClass, FOR_STATEMENT__VPATTERN);
		createEReference(forStatementEClass, FOR_STATEMENT__ACTIONS);
		createEReference(forStatementEClass, FOR_STATEMENT__WHEN);

		updateEClass = createEClass(UPDATE);

		deleteNodeEClass = createEClass(DELETE_NODE);
		createEReference(deleteNodeEClass, DELETE_NODE__VARIABLE);

		deleteLinkEClass = createEClass(DELETE_LINK);
		createEReference(deleteLinkEClass, DELETE_LINK__SOURCE);
		createEReference(deleteLinkEClass, DELETE_LINK__TARGET);
		createEReference(deleteLinkEClass, DELETE_LINK__FEATURE);

		updatePatternEClass = createEClass(UPDATE_PATTERN);

		patternEClass = createEClass(PATTERN);
		createEReference(patternEClass, PATTERN__ROOT);
		createEReference(patternEClass, PATTERN__GUARD);

		patternNodeEClass = createEClass(PATTERN_NODE);
		createEReference(patternNodeEClass, PATTERN_NODE__VARIABLE);
		createEReference(patternNodeEClass, PATTERN_NODE__TYPE);
		createEReference(patternNodeEClass, PATTERN_NODE__EXPR);

		patternExprEClass = createEClass(PATTERN_EXPR);

		patternReferenceExprEClass = createEClass(PATTERN_REFERENCE_EXPR);
		createEReference(patternReferenceExprEClass, PATTERN_REFERENCE_EXPR__REFERENCE);
		createEReference(patternReferenceExprEClass, PATTERN_REFERENCE_EXPR__NODE);
		createEReference(patternReferenceExprEClass, PATTERN_REFERENCE_EXPR__POS);

		patternEqualExprEClass = createEClass(PATTERN_EQUAL_EXPR);
		createEReference(patternEqualExprEClass, PATTERN_EQUAL_EXPR__FEATURE);
		createEReference(patternEqualExprEClass, PATTERN_EQUAL_EXPR__VALUE);
		createEReference(patternEqualExprEClass, PATTERN_EQUAL_EXPR__POS);

		exprEClass = createEClass(EXPR);

		variableExpEClass = createEClass(VARIABLE_EXP);
		createEReference(variableExpEClass, VARIABLE_EXP__VAR);
		createEReference(variableExpEClass, VARIABLE_EXP__PATH);

		constantExprEClass = createEClass(CONSTANT_EXPR);
		createEReference(constantExprEClass, CONSTANT_EXPR__PATH);

		emptyLiteralEClass = createEClass(EMPTY_LITERAL);
		createEAttribute(emptyLiteralEClass, EMPTY_LITERAL__VALUE);

		stringLiteralEClass = createEClass(STRING_LITERAL);
		createEAttribute(stringLiteralEClass, STRING_LITERAL__VALUE);

		integerLiteralEClass = createEClass(INTEGER_LITERAL);
		createEAttribute(integerLiteralEClass, INTEGER_LITERAL__VALUE);

		booleanLiteralEClass = createEClass(BOOLEAN_LITERAL);
		createEAttribute(booleanLiteralEClass, BOOLEAN_LITERAL__VALUE);

		enumLiteralEClass = createEClass(ENUM_LITERAL);
		createEReference(enumLiteralEClass, ENUM_LITERAL__TYPE);
		createEReference(enumLiteralEClass, ENUM_LITERAL__VALUE);

		vStatementEClass = createEClass(VSTATEMENT);
		createEAttribute(vStatementEClass, VSTATEMENT__TAG);
		createEReference(vStatementEClass, VSTATEMENT__STATEMENT);

		defaultVStatementEClass = createEClass(DEFAULT_VSTATEMENT);

		taggedVStatementEClass = createEClass(TAGGED_VSTATEMENT);

		blockStatementEClass = createEClass(BLOCK_STATEMENT);
		createEReference(blockStatementEClass, BLOCK_STATEMENT__STATEMENTS);

		switchStatementEClass = createEClass(SWITCH_STATEMENT);
		createEReference(switchStatementEClass, SWITCH_STATEMENT__VAR);
		createEReference(switchStatementEClass, SWITCH_STATEMENT__CASES);

		taggedElementEClass = createEClass(TAGGED_ELEMENT);
		createEAttribute(taggedElementEClass, TAGGED_ELEMENT__TAG);

		caseSubStatementEClass = createEClass(CASE_SUB_STATEMENT);
		createEReference(caseSubStatementEClass, CASE_SUB_STATEMENT__STATEMENT);
		createEReference(caseSubStatementEClass, CASE_SUB_STATEMENT__WHEN);

		casePatternStatementEClass = createEClass(CASE_PATTERN_STATEMENT);
		createEReference(casePatternStatementEClass, CASE_PATTERN_STATEMENT__PATTERN);

		caseValueStatementEClass = createEClass(CASE_VALUE_STATEMENT);
		createEReference(caseValueStatementEClass, CASE_VALUE_STATEMENT__EXPRESSION);

		caseDefaultStatementEClass = createEClass(CASE_DEFAULT_STATEMENT);

		xmuModelEClass = createEClass(XMU_MODEL);
		createEReference(xmuModelEClass, XMU_MODEL__INITIAL_MAPPINGS);
		createEReference(xmuModelEClass, XMU_MODEL__HELPER_MAPPINGS);
		createEReference(xmuModelEClass, XMU_MODEL__RULES);
		createEReference(xmuModelEClass, XMU_MODEL__PACKAGES);
		createEReference(xmuModelEClass, XMU_MODEL__START);

		parameterEClass = createEClass(PARAMETER);
		createEReference(parameterEClass, PARAMETER__VARIABLE);

		ruleCallStatementEClass = createEClass(RULE_CALL_STATEMENT);
		createEReference(ruleCallStatementEClass, RULE_CALL_STATEMENT__ACTUAL_PARAMETERS);
		createEReference(ruleCallStatementEClass, RULE_CALL_STATEMENT__RULE);

		booleanOrExprEClass = createEClass(BOOLEAN_OR_EXPR);
		createEReference(booleanOrExprEClass, BOOLEAN_OR_EXPR__OPERANDS);

		booleanOrExprChildEClass = createEClass(BOOLEAN_OR_EXPR_CHILD);

		booleanAndExprEClass = createEClass(BOOLEAN_AND_EXPR);
		createEReference(booleanAndExprEClass, BOOLEAN_AND_EXPR__OPERANDS);

		booleanAndExprChildEClass = createEClass(BOOLEAN_AND_EXPR_CHILD);

		relationalExprEClass = createEClass(RELATIONAL_EXPR);
		createEReference(relationalExprEClass, RELATIONAL_EXPR__LEFT);
		createEReference(relationalExprEClass, RELATIONAL_EXPR__RIGHT);
		createEAttribute(relationalExprEClass, RELATIONAL_EXPR__OPERATOR);

		relationalExprChildEClass = createEClass(RELATIONAL_EXPR_CHILD);

		additiveExprEClass = createEClass(ADDITIVE_EXPR);
		createEReference(additiveExprEClass, ADDITIVE_EXPR__OPERANDS);
		createEAttribute(additiveExprEClass, ADDITIVE_EXPR__OPERATORS);

		additiveExprChildEClass = createEClass(ADDITIVE_EXPR_CHILD);

		multiplicativeExprEClass = createEClass(MULTIPLICATIVE_EXPR);
		createEReference(multiplicativeExprEClass, MULTIPLICATIVE_EXPR__OPERANDS);
		createEAttribute(multiplicativeExprEClass, MULTIPLICATIVE_EXPR__OPERATORS);

		multiplicativeExprChildEClass = createEClass(MULTIPLICATIVE_EXPR_CHILD);

		unaryExprEClass = createEClass(UNARY_EXPR);
		createEReference(unaryExprEClass, UNARY_EXPR__BODY);
		createEAttribute(unaryExprEClass, UNARY_EXPR__OPERATOR);

		unaryExprChildEClass = createEClass(UNARY_EXPR_CHILD);

		atomicExprEClass = createEClass(ATOMIC_EXPR);

		parenExprEClass = createEClass(PAREN_EXPR);
		createEReference(parenExprEClass, PAREN_EXPR__BODY);

		pathEClass = createEClass(PATH);

		helperPathEClass = createEClass(HELPER_PATH);
		createEReference(helperPathEClass, HELPER_PATH__HELPER);

		featurePathEClass = createEClass(FEATURE_PATH);
		createEAttribute(featurePathEClass, FEATURE_PATH__FEATURE);

		operationPathEClass = createEClass(OPERATION_PATH);
		createEAttribute(operationPathEClass, OPERATION_PATH__OPERATION);
		createEReference(operationPathEClass, OPERATION_PATH__PARAMETERS);

		loopPathEClass = createEClass(LOOP_PATH);
		createEAttribute(loopPathEClass, LOOP_PATH__OPERATOR);
		createEReference(loopPathEClass, LOOP_PATH__VARIABLE);
		createEReference(loopPathEClass, LOOP_PATH__BODY);

		startStatementEClass = createEClass(START_STATEMENT);
		createEReference(startStatementEClass, START_STATEMENT__RULE);
		createEReference(startStatementEClass, START_STATEMENT__ROOT);

		startRootEClass = createEClass(START_ROOT);
		createEAttribute(startRootEClass, START_ROOT__ID);

		eResourceEClass = createEClass(ERESOURCE);
		createEReference(eResourceEClass, ERESOURCE__CONTENT);

		printStatementEClass = createEClass(PRINT_STATEMENT);
		createEReference(printStatementEClass, PRINT_STATEMENT__EXPR);

		allInstanceExprEClass = createEClass(ALL_INSTANCE_EXPR);
		createEReference(allInstanceExprEClass, ALL_INSTANCE_EXPR__ROOT);
		createEReference(allInstanceExprEClass, ALL_INSTANCE_EXPR__TYPE);

		eSetEClass = createEClass(ESET);
		createEReference(eSetEClass, ESET__CONTENT);

		objectPathExprEClass = createEClass(OBJECT_PATH_EXPR);
		createEReference(objectPathExprEClass, OBJECT_PATH_EXPR__OBJECT);

		initialMappingStatementEClass = createEClass(INITIAL_MAPPING_STATEMENT);
		createEReference(initialMappingStatementEClass, INITIAL_MAPPING_STATEMENT__SOURCE);
		createEReference(initialMappingStatementEClass, INITIAL_MAPPING_STATEMENT__TARGET);

		helperMappingEClass = createEClass(HELPER_MAPPING);
		createEReference(helperMappingEClass, HELPER_MAPPING__ENTRIES);
		createEAttribute(helperMappingEClass, HELPER_MAPPING__DEFAULT_EQUAL);

		helperMappingEntryEClass = createEClass(HELPER_MAPPING_ENTRY);
		createEReference(helperMappingEntryEClass, HELPER_MAPPING_ENTRY__LEFT);
		createEReference(helperMappingEntryEClass, HELPER_MAPPING_ENTRY__RIGHT);

		pseudoUpdateEClass = createEClass(PSEUDO_UPDATE);
		createEAttribute(pseudoUpdateEClass, PSEUDO_UPDATE__MESSAGE);

		skipEClass = createEClass(SKIP);

		failEClass = createEClass(FAIL);

		// Create enums
		variableFlagEEnum = createEEnum(VARIABLE_FLAG);
		relationalOperatorEEnum = createEEnum(RELATIONAL_OPERATOR);
		emptyTypeEEnum = createEEnum(EMPTY_TYPE);
		vStmtTypeEEnum = createEEnum(VSTMT_TYPE);
		additiveOperatorEEnum = createEEnum(ADDITIVE_OPERATOR);
		multiplicativeOperatorEEnum = createEEnum(MULTIPLICATIVE_OPERATOR);
		unaryOperatorEEnum = createEEnum(UNARY_OPERATOR);
		loopOperatorEEnum = createEEnum(LOOP_OPERATOR);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		variableEClass.getESuperTypes().add(this.getNamedElement());
		objectVariableEClass.getESuperTypes().add(this.getVariable());
		primitiveVariableEClass.getESuperTypes().add(this.getVariable());
		ruleEClass.getESuperTypes().add(this.getNamedElement());
		forStatementEClass.getESuperTypes().add(this.getStatement());
		updateEClass.getESuperTypes().add(this.getStatement());
		deleteNodeEClass.getESuperTypes().add(this.getUpdate());
		deleteLinkEClass.getESuperTypes().add(this.getUpdate());
		updatePatternEClass.getESuperTypes().add(this.getPattern());
		updatePatternEClass.getESuperTypes().add(this.getUpdate());
		patternEClass.getESuperTypes().add(this.getTaggedElement());
		patternReferenceExprEClass.getESuperTypes().add(this.getPatternExpr());
		patternEqualExprEClass.getESuperTypes().add(this.getPatternExpr());
		variableExpEClass.getESuperTypes().add(this.getAtomicExpr());
		constantExprEClass.getESuperTypes().add(this.getAtomicExpr());
		emptyLiteralEClass.getESuperTypes().add(this.getConstantExpr());
		stringLiteralEClass.getESuperTypes().add(this.getConstantExpr());
		integerLiteralEClass.getESuperTypes().add(this.getConstantExpr());
		booleanLiteralEClass.getESuperTypes().add(this.getConstantExpr());
		enumLiteralEClass.getESuperTypes().add(this.getConstantExpr());
		defaultVStatementEClass.getESuperTypes().add(this.getVStatement());
		taggedVStatementEClass.getESuperTypes().add(this.getVStatement());
		blockStatementEClass.getESuperTypes().add(this.getStatement());
		switchStatementEClass.getESuperTypes().add(this.getStatement());
		switchStatementEClass.getESuperTypes().add(this.getTaggedElement());
		casePatternStatementEClass.getESuperTypes().add(this.getCaseSubStatement());
		caseValueStatementEClass.getESuperTypes().add(this.getCaseSubStatement());
		caseDefaultStatementEClass.getESuperTypes().add(this.getCaseValueStatement());
		parameterEClass.getESuperTypes().add(this.getTaggedElement());
		ruleCallStatementEClass.getESuperTypes().add(this.getStatement());
		ruleCallStatementEClass.getESuperTypes().add(this.getTaggedElement());
		booleanOrExprEClass.getESuperTypes().add(this.getExpr());
		booleanOrExprChildEClass.getESuperTypes().add(this.getExpr());
		booleanAndExprEClass.getESuperTypes().add(this.getBooleanOrExprChild());
		booleanAndExprChildEClass.getESuperTypes().add(this.getBooleanOrExprChild());
		relationalExprEClass.getESuperTypes().add(this.getBooleanAndExprChild());
		relationalExprChildEClass.getESuperTypes().add(this.getBooleanAndExprChild());
		additiveExprEClass.getESuperTypes().add(this.getRelationalExprChild());
		additiveExprChildEClass.getESuperTypes().add(this.getRelationalExprChild());
		multiplicativeExprEClass.getESuperTypes().add(this.getAdditiveExprChild());
		multiplicativeExprChildEClass.getESuperTypes().add(this.getAdditiveExprChild());
		unaryExprEClass.getESuperTypes().add(this.getMultiplicativeExprChild());
		unaryExprChildEClass.getESuperTypes().add(this.getMultiplicativeExprChild());
		atomicExprEClass.getESuperTypes().add(this.getUnaryExprChild());
		parenExprEClass.getESuperTypes().add(this.getAtomicExpr());
		helperPathEClass.getESuperTypes().add(this.getPath());
		featurePathEClass.getESuperTypes().add(this.getPath());
		operationPathEClass.getESuperTypes().add(this.getPath());
		loopPathEClass.getESuperTypes().add(this.getPath());
		startRootEClass.getESuperTypes().add(this.getTaggedElement());
		printStatementEClass.getESuperTypes().add(this.getStatement());
		allInstanceExprEClass.getESuperTypes().add(this.getExpr());
		objectPathExprEClass.getESuperTypes().add(this.getExpr());
		helperMappingEClass.getESuperTypes().add(this.getNamedElement());
		pseudoUpdateEClass.getESuperTypes().add(this.getUpdate());
		skipEClass.getESuperTypes().add(this.getPseudoUpdate());
		failEClass.getESuperTypes().add(this.getPseudoUpdate());

		// Initialize classes, features, and operations; add parameters
		initEClass(namedElementEClass, NamedElement.class, "NamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(objectVariableEClass, ObjectVariable.class, "ObjectVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(primitiveVariableEClass, PrimitiveVariable.class, "PrimitiveVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrimitiveVariable_Type(), ecorePackage.getEDataType(), null, "type", null, 1, 1, PrimitiveVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRule_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_NVars(), this.getPrimitiveVariable(), null, "nVars", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_SVars(), this.getObjectVariable(), null, "sVars", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_SpVars(), this.getObjectVariable(), null, "spVars", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_VVars(), this.getObjectVariable(), null, "vVars", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Statement(), this.getStatement(), null, "statement", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statementEClass, Statement.class, "Statement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(forStatementEClass, ForStatement.class, "ForStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getForStatement_SPattern(), this.getPattern(), null, "sPattern", null, 1, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_VPattern(), this.getPattern(), null, "vPattern", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_Actions(), this.getVStatement(), null, "actions", null, 1, 3, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getForStatement_When(), this.getRuleCallStatement(), null, "when", null, 0, -1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(updateEClass, Update.class, "Update", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deleteNodeEClass, DeleteNode.class, "DeleteNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeleteNode_Variable(), this.getObjectVariable(), null, "variable", null, 1, 1, DeleteNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(deleteLinkEClass, DeleteLink.class, "DeleteLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeleteLink_Source(), this.getObjectVariable(), null, "source", null, 1, 1, DeleteLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeleteLink_Target(), this.getVariable(), null, "target", null, 1, 1, DeleteLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDeleteLink_Feature(), ecorePackage.getEStructuralFeature(), null, "feature", null, 1, 1, DeleteLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(updatePatternEClass, UpdatePattern.class, "UpdatePattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(patternEClass, Pattern.class, "Pattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPattern_Root(), this.getPatternNode(), null, "root", null, 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPattern_Guard(), this.getExpr(), null, "guard", null, 0, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternNodeEClass, PatternNode.class, "PatternNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternNode_Variable(), this.getVariable(), null, "variable", null, 1, 1, PatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternNode_Type(), ecorePackage.getEClass(), null, "type", null, 1, 1, PatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternNode_Expr(), this.getPatternExpr(), null, "expr", null, 0, -1, PatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternExprEClass, PatternExpr.class, "PatternExpr", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(patternReferenceExprEClass, PatternReferenceExpr.class, "PatternReferenceExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternReferenceExpr_Reference(), ecorePackage.getEReference(), null, "reference", null, 1, 1, PatternReferenceExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternReferenceExpr_Node(), this.getPatternNode(), null, "node", null, 1, 1, PatternReferenceExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternReferenceExpr_Pos(), this.getAtomicExpr(), null, "pos", null, 0, 1, PatternReferenceExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(patternEqualExprEClass, PatternEqualExpr.class, "PatternEqualExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPatternEqualExpr_Feature(), ecorePackage.getEStructuralFeature(), null, "feature", null, 1, 1, PatternEqualExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternEqualExpr_Value(), this.getAtomicExpr(), null, "value", null, 1, 1, PatternEqualExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPatternEqualExpr_Pos(), this.getAtomicExpr(), null, "pos", null, 0, 1, PatternEqualExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exprEClass, Expr.class, "Expr", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variableExpEClass, VariableExp.class, "VariableExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableExp_Var(), this.getVariable(), null, "var", null, 1, 1, VariableExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableExp_Path(), this.getPath(), null, "path", null, 0, -1, VariableExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constantExprEClass, ConstantExpr.class, "ConstantExpr", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstantExpr_Path(), this.getPath(), null, "path", null, 0, -1, ConstantExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(emptyLiteralEClass, EmptyLiteral.class, "EmptyLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEmptyLiteral_Value(), this.getEmptyType(), "value", null, 1, 1, EmptyLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringLiteralEClass, StringLiteral.class, "StringLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringLiteral_Value(), ecorePackage.getEString(), "value", null, 1, 1, StringLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerLiteralEClass, IntegerLiteral.class, "IntegerLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerLiteral_Value(), ecorePackage.getEIntegerObject(), "value", null, 1, 1, IntegerLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanLiteralEClass, BooleanLiteral.class, "BooleanLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanLiteral_Value(), ecorePackage.getEBooleanObject(), "value", null, 1, 1, BooleanLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumLiteralEClass, EnumLiteral.class, "EnumLiteral", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumLiteral_Type(), ecorePackage.getEEnum(), null, "type", null, 1, 1, EnumLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnumLiteral_Value(), ecorePackage.getEEnumLiteral(), null, "value", null, 1, 1, EnumLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(vStatementEClass, VStatement.class, "VStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVStatement_Tag(), this.getVStmtType(), "tag", null, 1, 1, VStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVStatement_Statement(), this.getStatement(), null, "statement", null, 1, 1, VStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(defaultVStatementEClass, DefaultVStatement.class, "DefaultVStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(taggedVStatementEClass, TaggedVStatement.class, "TaggedVStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(blockStatementEClass, BlockStatement.class, "BlockStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockStatement_Statements(), this.getStatement(), null, "statements", null, 0, -1, BlockStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(switchStatementEClass, SwitchStatement.class, "SwitchStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSwitchStatement_Var(), this.getVariable(), null, "var", null, 1, 1, SwitchStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSwitchStatement_Cases(), this.getCaseSubStatement(), null, "cases", null, 0, -1, SwitchStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(taggedElementEClass, TaggedElement.class, "TaggedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTaggedElement_Tag(), this.getVariableFlag(), "tag", null, 1, 1, TaggedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caseSubStatementEClass, CaseSubStatement.class, "CaseSubStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCaseSubStatement_Statement(), this.getStatement(), null, "statement", null, 1, 1, CaseSubStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCaseSubStatement_When(), this.getRuleCallStatement(), null, "when", null, 0, -1, CaseSubStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(casePatternStatementEClass, CasePatternStatement.class, "CasePatternStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCasePatternStatement_Pattern(), this.getPattern(), null, "pattern", null, 1, 1, CasePatternStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caseValueStatementEClass, CaseValueStatement.class, "CaseValueStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCaseValueStatement_Expression(), this.getExpr(), null, "expression", null, 1, 1, CaseValueStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caseDefaultStatementEClass, CaseDefaultStatement.class, "CaseDefaultStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xmuModelEClass, XMUModel.class, "XMUModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getXMUModel_InitialMappings(), this.getInitialMappingStatement(), null, "initialMappings", null, 0, -1, XMUModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXMUModel_HelperMappings(), this.getHelperMapping(), null, "helperMappings", null, 0, -1, XMUModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXMUModel_Rules(), this.getRule(), null, "rules", null, 0, -1, XMUModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXMUModel_Packages(), ecorePackage.getEPackage(), null, "packages", null, 0, -1, XMUModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getXMUModel_Start(), this.getStartStatement(), null, "start", null, 1, -1, XMUModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameter_Variable(), this.getVariable(), null, "variable", null, 1, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleCallStatementEClass, RuleCallStatement.class, "RuleCallStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuleCallStatement_ActualParameters(), this.getExpr(), null, "actualParameters", null, 0, -1, RuleCallStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleCallStatement_Rule(), this.getRule(), null, "rule", null, 1, 1, RuleCallStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanOrExprEClass, BooleanOrExpr.class, "BooleanOrExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBooleanOrExpr_Operands(), this.getBooleanOrExprChild(), null, "operands", null, 2, -1, BooleanOrExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanOrExprChildEClass, BooleanOrExprChild.class, "BooleanOrExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(booleanAndExprEClass, BooleanAndExpr.class, "BooleanAndExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBooleanAndExpr_Operands(), this.getBooleanAndExprChild(), null, "operands", null, 2, -1, BooleanAndExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanAndExprChildEClass, BooleanAndExprChild.class, "BooleanAndExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relationalExprEClass, RelationalExpr.class, "RelationalExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationalExpr_Left(), this.getRelationalExprChild(), null, "left", null, 1, 1, RelationalExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationalExpr_Right(), this.getRelationalExprChild(), null, "right", null, 1, 1, RelationalExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelationalExpr_Operator(), this.getRelationalOperator(), "operator", null, 1, 1, RelationalExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationalExprChildEClass, RelationalExprChild.class, "RelationalExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(additiveExprEClass, AdditiveExpr.class, "AdditiveExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAdditiveExpr_Operands(), this.getAdditiveExprChild(), null, "operands", null, 2, -1, AdditiveExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAdditiveExpr_Operators(), this.getAdditiveOperator(), "operators", null, 1, -1, AdditiveExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(additiveExprChildEClass, AdditiveExprChild.class, "AdditiveExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(multiplicativeExprEClass, MultiplicativeExpr.class, "MultiplicativeExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiplicativeExpr_Operands(), this.getMultiplicativeExprChild(), null, "operands", null, 2, -1, MultiplicativeExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMultiplicativeExpr_Operators(), this.getMultiplicativeOperator(), "operators", null, 1, -1, MultiplicativeExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(multiplicativeExprChildEClass, MultiplicativeExprChild.class, "MultiplicativeExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unaryExprEClass, UnaryExpr.class, "UnaryExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnaryExpr_Body(), this.getUnaryExprChild(), null, "body", null, 1, 1, UnaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnaryExpr_Operator(), this.getUnaryOperator(), "operator", "not", 1, 1, UnaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(unaryExprChildEClass, UnaryExprChild.class, "UnaryExprChild", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(atomicExprEClass, AtomicExpr.class, "AtomicExpr", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parenExprEClass, ParenExpr.class, "ParenExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParenExpr_Body(), this.getExpr(), null, "body", null, 1, 1, ParenExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathEClass, Path.class, "Path", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(helperPathEClass, HelperPath.class, "HelperPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHelperPath_Helper(), this.getHelperMapping(), null, "helper", null, 1, 1, HelperPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featurePathEClass, FeaturePath.class, "FeaturePath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFeaturePath_Feature(), ecorePackage.getEString(), "feature", null, 1, 1, FeaturePath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(operationPathEClass, OperationPath.class, "OperationPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperationPath_Operation(), ecorePackage.getEString(), "operation", null, 1, 1, OperationPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationPath_Parameters(), this.getExpr(), null, "parameters", null, 0, -1, OperationPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(loopPathEClass, LoopPath.class, "LoopPath", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoopPath_Operator(), this.getLoopOperator(), "operator", null, 1, 1, LoopPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoopPath_Variable(), this.getVariable(), null, "variable", null, 1, 1, LoopPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getLoopPath_Body(), this.getExpr(), null, "body", null, 1, 1, LoopPath.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(startStatementEClass, StartStatement.class, "StartStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStartStatement_Rule(), this.getRule(), null, "rule", null, 1, 1, StartStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getStartStatement_Root(), this.getStartRoot(), null, "root", null, 1, -1, StartStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(startRootEClass, StartRoot.class, "StartRoot", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStartRoot_Id(), ecorePackage.getEInt(), "id", "0", 1, 1, StartRoot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eResourceEClass, EResource.class, "EResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEResource_Content(), ecorePackage.getEObject(), null, "content", null, 0, -1, EResource.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(printStatementEClass, PrintStatement.class, "PrintStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrintStatement_Expr(), this.getExpr(), null, "expr", null, 1, 1, PrintStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(allInstanceExprEClass, AllInstanceExpr.class, "AllInstanceExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAllInstanceExpr_Root(), this.getStartRoot(), null, "root", null, 1, 1, AllInstanceExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAllInstanceExpr_Type(), ecorePackage.getEClass(), null, "type", null, 1, 1, AllInstanceExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eSetEClass, ESet.class, "ESet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getESet_Content(), ecorePackage.getEObject(), null, "content", null, 0, -1, ESet.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectPathExprEClass, ObjectPathExpr.class, "ObjectPathExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectPathExpr_Object(), ecorePackage.getEObject(), null, "object", null, 1, 1, ObjectPathExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(initialMappingStatementEClass, InitialMappingStatement.class, "InitialMappingStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInitialMappingStatement_Source(), this.getExpr(), null, "source", null, 1, -1, InitialMappingStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInitialMappingStatement_Target(), this.getExpr(), null, "target", null, 1, 1, InitialMappingStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(helperMappingEClass, HelperMapping.class, "HelperMapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHelperMapping_Entries(), this.getHelperMappingEntry(), null, "entries", null, 1, -1, HelperMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHelperMapping_DefaultEqual(), ecorePackage.getEBoolean(), "defaultEqual", "false", 0, 1, HelperMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(helperMappingEntryEClass, HelperMappingEntry.class, "HelperMappingEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHelperMappingEntry_Left(), this.getExpr(), null, "left", null, 1, 1, HelperMappingEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHelperMappingEntry_Right(), this.getExpr(), null, "right", null, 1, 1, HelperMappingEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pseudoUpdateEClass, PseudoUpdate.class, "PseudoUpdate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPseudoUpdate_Message(), ecorePackage.getEString(), "message", null, 0, 1, PseudoUpdate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(skipEClass, Skip.class, "Skip", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(failEClass, Fail.class, "Fail", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(variableFlagEEnum, VariableFlag.class, "VariableFlag");
		addEEnumLiteral(variableFlagEEnum, VariableFlag.NORMAL);
		addEEnumLiteral(variableFlagEEnum, VariableFlag.SOURCE);
		addEEnumLiteral(variableFlagEEnum, VariableFlag.VIEW);
		addEEnumLiteral(variableFlagEEnum, VariableFlag.CONTEXT);
		addEEnumLiteral(variableFlagEEnum, VariableFlag.SOURCE_POST);

		initEEnum(relationalOperatorEEnum, RelationalOperator.class, "RelationalOperator");
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.EQUAL);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESS);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.LESS_EQUAL);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER);
		addEEnumLiteral(relationalOperatorEEnum, RelationalOperator.GREATER_EQUAL);

		initEEnum(emptyTypeEEnum, EmptyType.class, "EmptyType");
		addEEnumLiteral(emptyTypeEEnum, EmptyType.NULL_VALUE);
		addEEnumLiteral(emptyTypeEEnum, EmptyType.EMPTY_VALUE);

		initEEnum(vStmtTypeEEnum, VStmtType.class, "VStmtType");
		addEEnumLiteral(vStmtTypeEEnum, VStmtType.DEFAULT);
		addEEnumLiteral(vStmtTypeEEnum, VStmtType.MATCH);
		addEEnumLiteral(vStmtTypeEEnum, VStmtType.UNMATCHV);
		addEEnumLiteral(vStmtTypeEEnum, VStmtType.UNMATCHS);

		initEEnum(additiveOperatorEEnum, AdditiveOperator.class, "AdditiveOperator");
		addEEnumLiteral(additiveOperatorEEnum, AdditiveOperator.ADD);
		addEEnumLiteral(additiveOperatorEEnum, AdditiveOperator.SUB);
		addEEnumLiteral(additiveOperatorEEnum, AdditiveOperator.APPEND);

		initEEnum(multiplicativeOperatorEEnum, MultiplicativeOperator.class, "MultiplicativeOperator");
		addEEnumLiteral(multiplicativeOperatorEEnum, MultiplicativeOperator.MUL);
		addEEnumLiteral(multiplicativeOperatorEEnum, MultiplicativeOperator.DIV);

		initEEnum(unaryOperatorEEnum, UnaryOperator.class, "UnaryOperator");
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.NOT);
		addEEnumLiteral(unaryOperatorEEnum, UnaryOperator.MINUS);

		initEEnum(loopOperatorEEnum, LoopOperator.class, "LoopOperator");
		addEEnumLiteral(loopOperatorEEnum, LoopOperator.SELECT);
		addEEnumLiteral(loopOperatorEEnum, LoopOperator.FOR_ALL);
		addEEnumLiteral(loopOperatorEEnum, LoopOperator.EXISTS);

		// Create resource
		createResource(eNS_URI);
	}

} //XmuPackageImpl
