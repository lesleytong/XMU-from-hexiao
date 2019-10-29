/**
 */
package edu.ustb.sei.mde.xmu2.pattern.impl;

import edu.ustb.sei.mde.xmu2.pattern.ObjectPatternExpression;
import edu.ustb.sei.mde.xmu2.pattern.PatternNode;
import edu.ustb.sei.mde.xmu2.pattern.PatternPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Pattern Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.pattern.impl.ObjectPatternExpressionImpl#getTargetNode <em>Target Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ObjectPatternExpressionImpl extends PatternExpressionImpl implements ObjectPatternExpression {
	/**
	 * The cached value of the '{@link #getTargetNode() <em>Target Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetNode()
	 * @generated
	 * @ordered
	 */
	protected PatternNode targetNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectPatternExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PatternPackage.Literals.OBJECT_PATTERN_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternNode getTargetNode() {
		return targetNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTargetNode(PatternNode newTargetNode, NotificationChain msgs) {
		PatternNode oldTargetNode = targetNode;
		targetNode = newTargetNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PatternPackage.OBJECT_PATTERN_EXPRESSION__TARGET_NODE, oldTargetNode, newTargetNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetNode(PatternNode newTargetNode) {
		if (newTargetNode != targetNode) {
			NotificationChain msgs = null;
			if (targetNode != null)
				msgs = ((InternalEObject)targetNode).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PatternPackage.OBJECT_PATTERN_EXPRESSION__TARGET_NODE, null, msgs);
			if (newTargetNode != null)
				msgs = ((InternalEObject)newTargetNode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PatternPackage.OBJECT_PATTERN_EXPRESSION__TARGET_NODE, null, msgs);
			msgs = basicSetTargetNode(newTargetNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PatternPackage.OBJECT_PATTERN_EXPRESSION__TARGET_NODE, newTargetNode, newTargetNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case PatternPackage.OBJECT_PATTERN_EXPRESSION__TARGET_NODE:
				return basicSetTargetNode(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PatternPackage.OBJECT_PATTERN_EXPRESSION__TARGET_NODE:
				return getTargetNode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PatternPackage.OBJECT_PATTERN_EXPRESSION__TARGET_NODE:
				setTargetNode((PatternNode)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PatternPackage.OBJECT_PATTERN_EXPRESSION__TARGET_NODE:
				setTargetNode((PatternNode)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PatternPackage.OBJECT_PATTERN_EXPRESSION__TARGET_NODE:
				return targetNode != null;
		}
		return super.eIsSet(featureID);
	}

} //ObjectPatternExpressionImpl
