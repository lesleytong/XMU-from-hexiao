/**
 */
package edu.ustb.sei.mde.xmu.impl;

import edu.ustb.sei.mde.xmu.AtomicExpr;
import edu.ustb.sei.mde.xmu.PatternNode;
import edu.ustb.sei.mde.xmu.PatternReferenceExpr;
import edu.ustb.sei.mde.xmu.XmuPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Reference Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.PatternReferenceExprImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.PatternReferenceExprImpl#getNode <em>Node</em>}</li>
 *   <li>{@link edu.ustb.sei.mde.xmu.impl.PatternReferenceExprImpl#getPos <em>Pos</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PatternReferenceExprImpl extends PatternExprImpl implements PatternReferenceExpr {
	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected EReference reference;

	/**
	 * The cached value of the '{@link #getNode() <em>Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected PatternNode node;

	/**
	 * The cached value of the '{@link #getPos() <em>Pos</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPos()
	 * @generated
	 * @ordered
	 */
	protected AtomicExpr pos;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternReferenceExprImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return XmuPackage.Literals.PATTERN_REFERENCE_EXPR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference() {
		if (reference != null && reference.eIsProxy()) {
			InternalEObject oldReference = (InternalEObject)reference;
			reference = (EReference)eResolveProxy(oldReference);
			if (reference != oldReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, XmuPackage.PATTERN_REFERENCE_EXPR__REFERENCE, oldReference, reference));
			}
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(EReference newReference) {
		EReference oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmuPackage.PATTERN_REFERENCE_EXPR__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternNode getNode() {
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNode(PatternNode newNode, NotificationChain msgs) {
		PatternNode oldNode = node;
		node = newNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XmuPackage.PATTERN_REFERENCE_EXPR__NODE, oldNode, newNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode(PatternNode newNode) {
		if (newNode != node) {
			NotificationChain msgs = null;
			if (node != null)
				msgs = ((InternalEObject)node).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XmuPackage.PATTERN_REFERENCE_EXPR__NODE, null, msgs);
			if (newNode != null)
				msgs = ((InternalEObject)newNode).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XmuPackage.PATTERN_REFERENCE_EXPR__NODE, null, msgs);
			msgs = basicSetNode(newNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmuPackage.PATTERN_REFERENCE_EXPR__NODE, newNode, newNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AtomicExpr getPos() {
		return pos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPos(AtomicExpr newPos, NotificationChain msgs) {
		AtomicExpr oldPos = pos;
		pos = newPos;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, XmuPackage.PATTERN_REFERENCE_EXPR__POS, oldPos, newPos);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPos(AtomicExpr newPos) {
		if (newPos != pos) {
			NotificationChain msgs = null;
			if (pos != null)
				msgs = ((InternalEObject)pos).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - XmuPackage.PATTERN_REFERENCE_EXPR__POS, null, msgs);
			if (newPos != null)
				msgs = ((InternalEObject)newPos).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - XmuPackage.PATTERN_REFERENCE_EXPR__POS, null, msgs);
			msgs = basicSetPos(newPos, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, XmuPackage.PATTERN_REFERENCE_EXPR__POS, newPos, newPos));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case XmuPackage.PATTERN_REFERENCE_EXPR__NODE:
				return basicSetNode(null, msgs);
			case XmuPackage.PATTERN_REFERENCE_EXPR__POS:
				return basicSetPos(null, msgs);
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
			case XmuPackage.PATTERN_REFERENCE_EXPR__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
			case XmuPackage.PATTERN_REFERENCE_EXPR__NODE:
				return getNode();
			case XmuPackage.PATTERN_REFERENCE_EXPR__POS:
				return getPos();
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
			case XmuPackage.PATTERN_REFERENCE_EXPR__REFERENCE:
				setReference((EReference)newValue);
				return;
			case XmuPackage.PATTERN_REFERENCE_EXPR__NODE:
				setNode((PatternNode)newValue);
				return;
			case XmuPackage.PATTERN_REFERENCE_EXPR__POS:
				setPos((AtomicExpr)newValue);
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
			case XmuPackage.PATTERN_REFERENCE_EXPR__REFERENCE:
				setReference((EReference)null);
				return;
			case XmuPackage.PATTERN_REFERENCE_EXPR__NODE:
				setNode((PatternNode)null);
				return;
			case XmuPackage.PATTERN_REFERENCE_EXPR__POS:
				setPos((AtomicExpr)null);
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
			case XmuPackage.PATTERN_REFERENCE_EXPR__REFERENCE:
				return reference != null;
			case XmuPackage.PATTERN_REFERENCE_EXPR__NODE:
				return node != null;
			case XmuPackage.PATTERN_REFERENCE_EXPR__POS:
				return pos != null;
		}
		return super.eIsSet(featureID);
	}

} //PatternReferenceExprImpl
