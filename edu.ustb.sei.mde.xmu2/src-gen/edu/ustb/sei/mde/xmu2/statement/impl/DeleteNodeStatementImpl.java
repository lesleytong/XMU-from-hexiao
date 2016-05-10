/**
 */
package edu.ustb.sei.mde.xmu2.statement.impl;

import edu.ustb.sei.mde.xmu2.expression.VariableExpression;

import edu.ustb.sei.mde.xmu2.statement.DeleteNodeStatement;
import edu.ustb.sei.mde.xmu2.statement.StatementPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Delete Node Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu2.statement.impl.DeleteNodeStatementImpl#getNode <em>Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DeleteNodeStatementImpl extends UnidirectionalStatementImpl implements DeleteNodeStatement {
	/**
	 * The cached value of the '{@link #getNode() <em>Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected VariableExpression node;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DeleteNodeStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StatementPackage.Literals.DELETE_NODE_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableExpression getNode() {
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode(VariableExpression newNode, NotificationChain msgs) {
		VariableExpression oldNode = node;
		node = newNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StatementPackage.DELETE_NODE_STATEMENT__NODE, oldNode, newNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode(VariableExpression newNode) {
		if (newNode != node) {
			NotificationChain msgs = null;
			if (node != null)
				msgs = ((InternalEObject)node).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StatementPackage.DELETE_NODE_STATEMENT__NODE, null, msgs);
			if (newNode != null)
				msgs = ((InternalEObject)newNode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StatementPackage.DELETE_NODE_STATEMENT__NODE, null, msgs);
			msgs = basicSetNode(newNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StatementPackage.DELETE_NODE_STATEMENT__NODE, newNode, newNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StatementPackage.DELETE_NODE_STATEMENT__NODE:
				return basicSetNode(null, msgs);
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
			case StatementPackage.DELETE_NODE_STATEMENT__NODE:
				return getNode();
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
			case StatementPackage.DELETE_NODE_STATEMENT__NODE:
				setNode((VariableExpression)newValue);
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
			case StatementPackage.DELETE_NODE_STATEMENT__NODE:
				setNode((VariableExpression)null);
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
			case StatementPackage.DELETE_NODE_STATEMENT__NODE:
				return node != null;
		}
		return super.eIsSet(featureID);
	}

} //DeleteNodeStatementImpl
