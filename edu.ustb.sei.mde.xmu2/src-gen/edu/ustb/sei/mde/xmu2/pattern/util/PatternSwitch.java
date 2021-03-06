/**
 */
package edu.ustb.sei.mde.xmu2.pattern.util;

import edu.ustb.sei.mde.xmu2.ReflectiveAPI;
import edu.ustb.sei.mde.xmu2.pattern.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see edu.ustb.sei.mde.xmu2.pattern.PatternPackage
 * @generated
 */
public class PatternSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PatternPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternSwitch() {
		if (modelPackage == null) {
			modelPackage = PatternPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case PatternPackage.PATTERN: {
				Pattern pattern = (Pattern)theEObject;
				T result = casePattern(pattern);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternPackage.PATTERN_NODE: {
				PatternNode patternNode = (PatternNode)theEObject;
				T result = casePatternNode(patternNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternPackage.PATTERN_EXPRESSION: {
				PatternExpression patternExpression = (PatternExpression)theEObject;
				T result = casePatternExpression(patternExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternPackage.OBJECT_PATTERN_EXPRESSION: {
				ObjectPatternExpression objectPatternExpression = (ObjectPatternExpression)theEObject;
				T result = caseObjectPatternExpression(objectPatternExpression);
				if (result == null) result = casePatternExpression(objectPatternExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternPackage.PROPERTY_PATTERN_EXPRESSION: {
				PropertyPatternExpression propertyPatternExpression = (PropertyPatternExpression)theEObject;
				T result = casePropertyPatternExpression(propertyPatternExpression);
				if (result == null) result = casePatternExpression(propertyPatternExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternPackage.REFLECTIVE_PATTERN_NODE: {
				ReflectivePatternNode reflectivePatternNode = (ReflectivePatternNode)theEObject;
				T result = caseReflectivePatternNode(reflectivePatternNode);
				if (result == null) result = casePatternNode(reflectivePatternNode);
				if (result == null) result = caseReflectiveAPI(reflectivePatternNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternPackage.REFLECTIVE_OBJECT_PATTERN_EXPRESSION: {
				ReflectiveObjectPatternExpression reflectiveObjectPatternExpression = (ReflectiveObjectPatternExpression)theEObject;
				T result = caseReflectiveObjectPatternExpression(reflectiveObjectPatternExpression);
				if (result == null) result = caseObjectPatternExpression(reflectiveObjectPatternExpression);
				if (result == null) result = caseReflectiveAPI(reflectiveObjectPatternExpression);
				if (result == null) result = casePatternExpression(reflectiveObjectPatternExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PatternPackage.REFLECTIVE_PROPERTY_PATTERN_EXPRESSION: {
				ReflectivePropertyPatternExpression reflectivePropertyPatternExpression = (ReflectivePropertyPatternExpression)theEObject;
				T result = caseReflectivePropertyPatternExpression(reflectivePropertyPatternExpression);
				if (result == null) result = casePropertyPatternExpression(reflectivePropertyPatternExpression);
				if (result == null) result = caseReflectiveAPI(reflectivePropertyPatternExpression);
				if (result == null) result = casePatternExpression(reflectivePropertyPatternExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pattern</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pattern</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePattern(Pattern object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternNode(PatternNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePatternExpression(PatternExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Pattern Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Pattern Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectPatternExpression(ObjectPatternExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Pattern Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Pattern Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyPatternExpression(PropertyPatternExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reflective Pattern Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reflective Pattern Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReflectivePatternNode(ReflectivePatternNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reflective Object Pattern Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reflective Object Pattern Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReflectiveObjectPatternExpression(ReflectiveObjectPatternExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reflective Property Pattern Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reflective Property Pattern Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReflectivePropertyPatternExpression(ReflectivePropertyPatternExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reflective API</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reflective API</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReflectiveAPI(ReflectiveAPI object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //PatternSwitch
