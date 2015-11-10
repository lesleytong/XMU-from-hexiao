/**
 */
package edu.ustb.sei.mde.xmu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Empty Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu.XmuPackage#getEmptyType()
 * @model
 * @generated
 */
public enum EmptyType implements Enumerator {
	/**
	 * The '<em><b>Null Value</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NULL_VALUE_VALUE
	 * @generated
	 * @ordered
	 */
	NULL_VALUE(0, "NullValue", "NullValue"),

	/**
	 * The '<em><b>Empty Value</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EMPTY_VALUE_VALUE
	 * @generated
	 * @ordered
	 */
	EMPTY_VALUE(1, "EmptyValue", "EmptyValue");

	/**
	 * The '<em><b>Null Value</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Null Value</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #NULL_VALUE
	 * @model name="NullValue"
	 * @generated
	 * @ordered
	 */
	public static final int NULL_VALUE_VALUE = 0;

	/**
	 * The '<em><b>Empty Value</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Empty Value</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EMPTY_VALUE
	 * @model name="EmptyValue"
	 * @generated
	 * @ordered
	 */
	public static final int EMPTY_VALUE_VALUE = 1;

	/**
	 * An array of all the '<em><b>Empty Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final EmptyType[] VALUES_ARRAY =
		new EmptyType[] {
			NULL_VALUE,
			EMPTY_VALUE,
		};

	/**
	 * A public read-only list of all the '<em><b>Empty Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<EmptyType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Empty Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EmptyType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EmptyType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Empty Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EmptyType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			EmptyType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Empty Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static EmptyType get(int value) {
		switch (value) {
			case NULL_VALUE_VALUE: return NULL_VALUE;
			case EMPTY_VALUE_VALUE: return EMPTY_VALUE;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EmptyType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //EmptyType
