/**
 */
package edu.ustb.sei.mde.xmu2common.impl;

import edu.ustb.sei.mde.xmu2common.*;

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
public class Xmu2commonFactoryImpl extends EFactoryImpl implements Xmu2commonFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Xmu2commonFactory init() {
		try {
			Xmu2commonFactory theXmu2commonFactory = (Xmu2commonFactory)EPackage.Registry.INSTANCE.getEFactory(Xmu2commonPackage.eNS_URI);
			if (theXmu2commonFactory != null) {
				return theXmu2commonFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Xmu2commonFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xmu2commonFactoryImpl() {
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
			case Xmu2commonPackage.DOMAIN_TAG:
				return createDomainTagFromString(eDataType, initialValue);
			case Xmu2commonPackage.ADDITIVE_OPERATOR:
				return createAdditiveOperatorFromString(eDataType, initialValue);
			case Xmu2commonPackage.MULTIPLICATIVE_OPERATOR:
				return createMultiplicativeOperatorFromString(eDataType, initialValue);
			case Xmu2commonPackage.RELATIONAL_OPERATOR:
				return createRelationalOperatorFromString(eDataType, initialValue);
			case Xmu2commonPackage.UNARY_OPERATOR:
				return createUnaryOperatorFromString(eDataType, initialValue);
			case Xmu2commonPackage.LOOP_OPERATOR:
				return createLoopOperatorFromString(eDataType, initialValue);
			case Xmu2commonPackage.POSITION_OPERATOR:
				return createPositionOperatorFromString(eDataType, initialValue);
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
			case Xmu2commonPackage.DOMAIN_TAG:
				return convertDomainTagToString(eDataType, instanceValue);
			case Xmu2commonPackage.ADDITIVE_OPERATOR:
				return convertAdditiveOperatorToString(eDataType, instanceValue);
			case Xmu2commonPackage.MULTIPLICATIVE_OPERATOR:
				return convertMultiplicativeOperatorToString(eDataType, instanceValue);
			case Xmu2commonPackage.RELATIONAL_OPERATOR:
				return convertRelationalOperatorToString(eDataType, instanceValue);
			case Xmu2commonPackage.UNARY_OPERATOR:
				return convertUnaryOperatorToString(eDataType, instanceValue);
			case Xmu2commonPackage.LOOP_OPERATOR:
				return convertLoopOperatorToString(eDataType, instanceValue);
			case Xmu2commonPackage.POSITION_OPERATOR:
				return convertPositionOperatorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DomainTag createDomainTagFromString(EDataType eDataType, String initialValue) {
		DomainTag result = DomainTag.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDomainTagToString(EDataType eDataType, Object instanceValue) {
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
	public LoopOperator createLoopOperatorFromString(EDataType eDataType, String initialValue) {
		LoopOperator result = LoopOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLoopOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PositionOperator createPositionOperatorFromString(EDataType eDataType, String initialValue) {
		PositionOperator result = PositionOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPositionOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Xmu2commonPackage getXmu2commonPackage() {
		return (Xmu2commonPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Xmu2commonPackage getPackage() {
		return Xmu2commonPackage.eINSTANCE;
	}

} //Xmu2commonFactoryImpl
