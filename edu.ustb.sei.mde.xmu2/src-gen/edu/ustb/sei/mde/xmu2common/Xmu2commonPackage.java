/**
 */
package edu.ustb.sei.mde.xmu2common;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu2common.Xmu2commonFactory
 * @model kind="package"
 * @generated
 */
public interface Xmu2commonPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "xmu2common";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ustb.edu.cn/sei/mde/xmu2/common";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "xmu2common";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Xmu2commonPackage eINSTANCE = edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2common.impl.DomainElementImpl <em>Domain Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2common.impl.DomainElementImpl
	 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getDomainElement()
	 * @generated
	 */
	int DOMAIN_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Tag</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ELEMENT__TAG = 0;

	/**
	 * The number of structural features of the '<em>Domain Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Domain Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2common.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2common.impl.NamedElementImpl
	 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 1;

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
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2common.DomainTag <em>Domain Tag</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2common.DomainTag
	 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getDomainTag()
	 * @generated
	 */
	int DOMAIN_TAG = 2;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2common.AdditiveOperator <em>Additive Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2common.AdditiveOperator
	 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getAdditiveOperator()
	 * @generated
	 */
	int ADDITIVE_OPERATOR = 3;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2common.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2common.MultiplicativeOperator
	 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getMultiplicativeOperator()
	 * @generated
	 */
	int MULTIPLICATIVE_OPERATOR = 4;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2common.RelationalOperator <em>Relational Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2common.RelationalOperator
	 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getRelationalOperator()
	 * @generated
	 */
	int RELATIONAL_OPERATOR = 5;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2common.UnaryOperator <em>Unary Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2common.UnaryOperator
	 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getUnaryOperator()
	 * @generated
	 */
	int UNARY_OPERATOR = 6;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2common.LoopOperator <em>Loop Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2common.LoopOperator
	 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getLoopOperator()
	 * @generated
	 */
	int LOOP_OPERATOR = 7;

	/**
	 * The meta object id for the '{@link edu.ustb.sei.mde.xmu2common.PositionOperator <em>Position Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.ustb.sei.mde.xmu2common.PositionOperator
	 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getPositionOperator()
	 * @generated
	 */
	int POSITION_OPERATOR = 8;


	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2common.DomainElement <em>Domain Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Element</em>'.
	 * @see edu.ustb.sei.mde.xmu2common.DomainElement
	 * @generated
	 */
	EClass getDomainElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2common.DomainElement#getTag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag</em>'.
	 * @see edu.ustb.sei.mde.xmu2common.DomainElement#getTag()
	 * @see #getDomainElement()
	 * @generated
	 */
	EAttribute getDomainElement_Tag();

	/**
	 * Returns the meta object for class '{@link edu.ustb.sei.mde.xmu2common.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see edu.ustb.sei.mde.xmu2common.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link edu.ustb.sei.mde.xmu2common.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see edu.ustb.sei.mde.xmu2common.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.xmu2common.DomainTag <em>Domain Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Domain Tag</em>'.
	 * @see edu.ustb.sei.mde.xmu2common.DomainTag
	 * @generated
	 */
	EEnum getDomainTag();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.xmu2common.AdditiveOperator <em>Additive Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Additive Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu2common.AdditiveOperator
	 * @generated
	 */
	EEnum getAdditiveOperator();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.xmu2common.MultiplicativeOperator <em>Multiplicative Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Multiplicative Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu2common.MultiplicativeOperator
	 * @generated
	 */
	EEnum getMultiplicativeOperator();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.xmu2common.RelationalOperator <em>Relational Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Relational Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu2common.RelationalOperator
	 * @generated
	 */
	EEnum getRelationalOperator();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.xmu2common.UnaryOperator <em>Unary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unary Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu2common.UnaryOperator
	 * @generated
	 */
	EEnum getUnaryOperator();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.xmu2common.LoopOperator <em>Loop Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Loop Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu2common.LoopOperator
	 * @generated
	 */
	EEnum getLoopOperator();

	/**
	 * Returns the meta object for enum '{@link edu.ustb.sei.mde.xmu2common.PositionOperator <em>Position Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Position Operator</em>'.
	 * @see edu.ustb.sei.mde.xmu2common.PositionOperator
	 * @generated
	 */
	EEnum getPositionOperator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Xmu2commonFactory getXmu2commonFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2common.impl.DomainElementImpl <em>Domain Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2common.impl.DomainElementImpl
		 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getDomainElement()
		 * @generated
		 */
		EClass DOMAIN_ELEMENT = eINSTANCE.getDomainElement();

		/**
		 * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN_ELEMENT__TAG = eINSTANCE.getDomainElement_Tag();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2common.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2common.impl.NamedElementImpl
		 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getNamedElement()
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
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2common.DomainTag <em>Domain Tag</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2common.DomainTag
		 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getDomainTag()
		 * @generated
		 */
		EEnum DOMAIN_TAG = eINSTANCE.getDomainTag();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2common.AdditiveOperator <em>Additive Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2common.AdditiveOperator
		 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getAdditiveOperator()
		 * @generated
		 */
		EEnum ADDITIVE_OPERATOR = eINSTANCE.getAdditiveOperator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2common.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2common.MultiplicativeOperator
		 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getMultiplicativeOperator()
		 * @generated
		 */
		EEnum MULTIPLICATIVE_OPERATOR = eINSTANCE.getMultiplicativeOperator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2common.RelationalOperator <em>Relational Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2common.RelationalOperator
		 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getRelationalOperator()
		 * @generated
		 */
		EEnum RELATIONAL_OPERATOR = eINSTANCE.getRelationalOperator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2common.UnaryOperator <em>Unary Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2common.UnaryOperator
		 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getUnaryOperator()
		 * @generated
		 */
		EEnum UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2common.LoopOperator <em>Loop Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2common.LoopOperator
		 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getLoopOperator()
		 * @generated
		 */
		EEnum LOOP_OPERATOR = eINSTANCE.getLoopOperator();

		/**
		 * The meta object literal for the '{@link edu.ustb.sei.mde.xmu2common.PositionOperator <em>Position Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.ustb.sei.mde.xmu2common.PositionOperator
		 * @see edu.ustb.sei.mde.xmu2common.impl.Xmu2commonPackageImpl#getPositionOperator()
		 * @generated
		 */
		EEnum POSITION_OPERATOR = eINSTANCE.getPositionOperator();

	}

} //Xmu2commonPackage
