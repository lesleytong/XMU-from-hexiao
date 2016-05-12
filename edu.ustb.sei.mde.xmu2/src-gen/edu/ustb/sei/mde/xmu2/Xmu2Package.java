/**
 */
package edu.ustb.sei.mde.xmu2;

import edu.ustb.sei.mde.xmu2common.Xmu2commonPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu2.Xmu2Factory
 * @model kind="package"
 * @generated
 */
public interface Xmu2Package extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xmu2";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ustb.edu.cn/sei/mde/xmu2";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xmu2";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Xmu2Package eINSTANCE = edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.impl.NamedElementImpl
	 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.impl.TransformationModelImpl <em>Transformation Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.impl.TransformationModelImpl
	 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getTransformationModel()
	 * @generated
	 */
	int TRANSFORMATION_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MODEL__NAME = Xmu2commonPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Packages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MODEL__PACKAGES = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entry Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MODEL__ENTRY_POINTS = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MODEL__RULES = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transformation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_MODEL_FEATURE_COUNT = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.impl.EntryPointImpl <em>Entry Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.impl.EntryPointImpl
	 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getEntryPoint()
	 * @generated
	 */
	int ENTRY_POINT = 2;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__RULE = 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__PARAMETERS = 1;

	/**
	 * The number of structural features of the '<em>Entry Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.impl.EntryDataImpl <em>Entry Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.impl.EntryDataImpl
	 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getEntryData()
	 * @generated
	 */
	int ENTRY_DATA = 3;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_DATA__TAG = Xmu2commonPackage.DOMAIN_ELEMENT__TAG;

	/**
	 * The feature id for the '<em><b>Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_DATA__INDEX = Xmu2commonPackage.DOMAIN_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Fragment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_DATA__FRAGMENT = Xmu2commonPackage.DOMAIN_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Entry Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_DATA_FEATURE_COUNT = Xmu2commonPackage.DOMAIN_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.impl.AbstractRuleImpl <em>Abstract Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.impl.AbstractRuleImpl
	 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getAbstractRule()
	 * @generated
	 */
	int ABSTRACT_RULE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RULE__NAME = Xmu2commonPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RULE__PARAMETERS = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RULE_FEATURE_COUNT = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.impl.ParameterImpl
	 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = Xmu2commonPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TAG = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.impl.ModelRuleImpl <em>Model Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.impl.ModelRuleImpl
	 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getModelRule()
	 * @generated
	 */
	int MODEL_RULE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RULE__NAME = ABSTRACT_RULE__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RULE__PARAMETERS = ABSTRACT_RULE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RULE__ACTIVE = ABSTRACT_RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RULE__VARIABLE_DECLARATIONS = ABSTRACT_RULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RULE__STATEMENT = ABSTRACT_RULE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Model Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_RULE_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.impl.ArithmeticRuleImpl <em>Arithmetic Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.impl.ArithmeticRuleImpl
	 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getArithmeticRule()
	 * @generated
	 */
	int ARITHMETIC_RULE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_RULE__NAME = ABSTRACT_RULE__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_RULE__PARAMETERS = ABSTRACT_RULE__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_RULE__STATEMENTS = ABSTRACT_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Arithmetic Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARITHMETIC_RULE_FEATURE_COUNT = ABSTRACT_RULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.impl.VariableDeclarationImpl
	 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__NAME = Xmu2commonPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__TYPE = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = Xmu2commonPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2.impl.TypedElementImpl <em>Typed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2.impl.TypedElementImpl
	 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getTypedElement()
	 * @generated
	 */
	int TYPED_ELEMENT = 9;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__TYPE = 0;

	/**
	 * The number of structural features of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see edu.ustb.sei.mde.xmu2.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.ustb.sei.mde.xmu2.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.TransformationModel <em>Transformation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation Model</em>'.
	 * @see edu.ustb.sei.mde.xmu2.TransformationModel
	 * @generated
	 */
	EClass getTransformationModel();

	/**
	 * Returns the meta object for the reference list '{@link edu.ustb.sei.mde.xmu2.TransformationModel#getPackages <em>Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Packages</em>'.
	 * @see edu.ustb.sei.mde.xmu2.TransformationModel#getPackages()
	 * @see #getTransformationModel()
	 * @generated
	 */
	EReference getTransformationModel_Packages();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2.TransformationModel#getEntryPoints <em>Entry Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entry Points</em>'.
	 * @see edu.ustb.sei.mde.xmu2.TransformationModel#getEntryPoints()
	 * @see #getTransformationModel()
	 * @generated
	 */
	EReference getTransformationModel_EntryPoints();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2.TransformationModel#getRules <em>Rules</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rules</em>'.
	 * @see edu.ustb.sei.mde.xmu2.TransformationModel#getRules()
	 * @see #getTransformationModel()
	 * @generated
	 */
	EReference getTransformationModel_Rules();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.EntryPoint <em>Entry Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry Point</em>'.
	 * @see edu.ustb.sei.mde.xmu2.EntryPoint
	 * @generated
	 */
	EClass getEntryPoint();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2.EntryPoint#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rule</em>'.
	 * @see edu.ustb.sei.mde.xmu2.EntryPoint#getRule()
	 * @see #getEntryPoint()
	 * @generated
	 */
	EReference getEntryPoint_Rule();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2.EntryPoint#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see edu.ustb.sei.mde.xmu2.EntryPoint#getParameters()
	 * @see #getEntryPoint()
	 * @generated
	 */
	EReference getEntryPoint_Parameters();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.EntryData <em>Entry Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry Data</em>'.
	 * @see edu.ustb.sei.mde.xmu2.EntryData
	 * @generated
	 */
	EClass getEntryData();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.EntryData#getIndex <em>Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Index</em>'.
	 * @see edu.ustb.sei.mde.xmu2.EntryData#getIndex()
	 * @see #getEntryData()
	 * @generated
	 */
	EAttribute getEntryData_Index();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.EntryData#getFragment <em>Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fragment</em>'.
	 * @see edu.ustb.sei.mde.xmu2.EntryData#getFragment()
	 * @see #getEntryData()
	 * @generated
	 */
	EAttribute getEntryData_Fragment();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.AbstractRule <em>Abstract Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Rule</em>'.
	 * @see edu.ustb.sei.mde.xmu2.AbstractRule
	 * @generated
	 */
	EClass getAbstractRule();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2.AbstractRule#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see edu.ustb.sei.mde.xmu2.AbstractRule#getParameters()
	 * @see #getAbstractRule()
	 * @generated
	 */
	EReference getAbstractRule_Parameters();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see edu.ustb.sei.mde.xmu2.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.ModelRule <em>Model Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Rule</em>'.
	 * @see edu.ustb.sei.mde.xmu2.ModelRule
	 * @generated
	 */
	EClass getModelRule();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2.ModelRule#isActive <em>Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Active</em>'.
	 * @see edu.ustb.sei.mde.xmu2.ModelRule#isActive()
	 * @see #getModelRule()
	 * @generated
	 */
	EAttribute getModelRule_Active();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2.ModelRule#getVariableDeclarations <em>Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable Declarations</em>'.
	 * @see edu.ustb.sei.mde.xmu2.ModelRule#getVariableDeclarations()
	 * @see #getModelRule()
	 * @generated
	 */
	EReference getModelRule_VariableDeclarations();

	/**
	 * Returns the meta object for the containment reference '{@link edu.ustb.sei.mde.xmu2.ModelRule#getStatement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Statement</em>'.
	 * @see edu.ustb.sei.mde.xmu2.ModelRule#getStatement()
	 * @see #getModelRule()
	 * @generated
	 */
	EReference getModelRule_Statement();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.ArithmeticRule <em>Arithmetic Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arithmetic Rule</em>'.
	 * @see edu.ustb.sei.mde.xmu2.ArithmeticRule
	 * @generated
	 */
	EClass getArithmeticRule();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.ustb.sei.mde.xmu2.ArithmeticRule#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see edu.ustb.sei.mde.xmu2.ArithmeticRule#getStatements()
	 * @see #getArithmeticRule()
	 * @generated
	 */
	EReference getArithmeticRule_Statements();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see edu.ustb.sei.mde.xmu2.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element</em>'.
	 * @see edu.ustb.sei.mde.xmu2.TypedElement
	 * @generated
	 */
	EClass getTypedElement();

	/**
	 * Returns the meta object for the reference '{@link edu.ustb.sei.mde.xmu2.TypedElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see edu.ustb.sei.mde.xmu2.TypedElement#getType()
	 * @see #getTypedElement()
	 * @generated
	 */
	EReference getTypedElement_Type();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Xmu2Factory getXmu2Factory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.impl.NamedElementImpl
		 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.impl.TransformationModelImpl <em>Transformation Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.impl.TransformationModelImpl
		 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getTransformationModel()
		 * @generated
		 */
		EClass TRANSFORMATION_MODEL = eINSTANCE.getTransformationModel();

		/**
		 * The meta object literal for the '<em><b>Packages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_MODEL__PACKAGES = eINSTANCE.getTransformationModel_Packages();

		/**
		 * The meta object literal for the '<em><b>Entry Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_MODEL__ENTRY_POINTS = eINSTANCE.getTransformationModel_EntryPoints();

		/**
		 * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION_MODEL__RULES = eINSTANCE.getTransformationModel_Rules();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.impl.EntryPointImpl <em>Entry Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.impl.EntryPointImpl
		 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getEntryPoint()
		 * @generated
		 */
		EClass ENTRY_POINT = eINSTANCE.getEntryPoint();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY_POINT__RULE = eINSTANCE.getEntryPoint_Rule();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY_POINT__PARAMETERS = eINSTANCE.getEntryPoint_Parameters();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.impl.EntryDataImpl <em>Entry Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.impl.EntryDataImpl
		 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getEntryData()
		 * @generated
		 */
		EClass ENTRY_DATA = eINSTANCE.getEntryData();

		/**
		 * The meta object literal for the '<em><b>Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTRY_DATA__INDEX = eINSTANCE.getEntryData_Index();

		/**
		 * The meta object literal for the '<em><b>Fragment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTRY_DATA__FRAGMENT = eINSTANCE.getEntryData_Fragment();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.impl.AbstractRuleImpl <em>Abstract Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.impl.AbstractRuleImpl
		 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getAbstractRule()
		 * @generated
		 */
		EClass ABSTRACT_RULE = eINSTANCE.getAbstractRule();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_RULE__PARAMETERS = eINSTANCE.getAbstractRule_Parameters();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.impl.ParameterImpl
		 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.impl.ModelRuleImpl <em>Model Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.impl.ModelRuleImpl
		 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getModelRule()
		 * @generated
		 */
		EClass MODEL_RULE = eINSTANCE.getModelRule();

		/**
		 * The meta object literal for the '<em><b>Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_RULE__ACTIVE = eINSTANCE.getModelRule_Active();

		/**
		 * The meta object literal for the '<em><b>Variable Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_RULE__VARIABLE_DECLARATIONS = eINSTANCE.getModelRule_VariableDeclarations();

		/**
		 * The meta object literal for the '<em><b>Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_RULE__STATEMENT = eINSTANCE.getModelRule_Statement();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.impl.ArithmeticRuleImpl <em>Arithmetic Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.impl.ArithmeticRuleImpl
		 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getArithmeticRule()
		 * @generated
		 */
		EClass ARITHMETIC_RULE = eINSTANCE.getArithmeticRule();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARITHMETIC_RULE__STATEMENTS = eINSTANCE.getArithmeticRule_Statements();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.impl.VariableDeclarationImpl
		 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getVariableDeclaration()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2.impl.TypedElementImpl <em>Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2.impl.TypedElementImpl
		 * @see edu.ustb.sei.mde.xmu2.impl.Xmu2PackageImpl#getTypedElement()
		 * @generated
		 */
		EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT__TYPE = eINSTANCE.getTypedElement_Type();

	}

} //Xmu2Package
