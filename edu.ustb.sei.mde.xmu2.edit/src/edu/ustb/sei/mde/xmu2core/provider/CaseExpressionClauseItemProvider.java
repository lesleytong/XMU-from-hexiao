/**
 */
package edu.ustb.sei.mde.xmu2core.provider;


import edu.ustb.sei.mde.xmu2core.CaseExpressionClause;
import edu.ustb.sei.mde.xmu2core.Xmu2coreFactory;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.ustb.sei.mde.xmu2core.CaseExpressionClause} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CaseExpressionClauseItemProvider extends CaseClauseItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CaseExpressionClauseItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

		}
		return itemPropertyDescriptors;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(Xmu2corePackage.Literals.CASE_EXPRESSION_CLAUSE__CONDITION);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns CaseExpressionClause.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CaseExpressionClause"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		return getString("_UI_CaseExpressionClause_type");
	}
	

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(CaseExpressionClause.class)) {
			case Xmu2corePackage.CASE_EXPRESSION_CLAUSE__CONDITION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.CASE_EXPRESSION_CLAUSE__CONDITION,
				 Xmu2coreFactory.eINSTANCE.createBooleanOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.CASE_EXPRESSION_CLAUSE__CONDITION,
				 Xmu2coreFactory.eINSTANCE.createBooleanAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.CASE_EXPRESSION_CLAUSE__CONDITION,
				 Xmu2coreFactory.eINSTANCE.createRelationalExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.CASE_EXPRESSION_CLAUSE__CONDITION,
				 Xmu2coreFactory.eINSTANCE.createAdditiveExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.CASE_EXPRESSION_CLAUSE__CONDITION,
				 Xmu2coreFactory.eINSTANCE.createMultiplicativeExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.CASE_EXPRESSION_CLAUSE__CONDITION,
				 Xmu2coreFactory.eINSTANCE.createUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.CASE_EXPRESSION_CLAUSE__CONDITION,
				 Xmu2coreFactory.eINSTANCE.createTypeCastExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.CASE_EXPRESSION_CLAUSE__CONDITION,
				 Xmu2coreFactory.eINSTANCE.createStringValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.CASE_EXPRESSION_CLAUSE__CONDITION,
				 Xmu2coreFactory.eINSTANCE.createBooleanValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.CASE_EXPRESSION_CLAUSE__CONDITION,
				 Xmu2coreFactory.eINSTANCE.createIntegerValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.CASE_EXPRESSION_CLAUSE__CONDITION,
				 Xmu2coreFactory.eINSTANCE.createEnumValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.CASE_EXPRESSION_CLAUSE__CONDITION,
				 Xmu2coreFactory.eINSTANCE.createEmptyValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.CASE_EXPRESSION_CLAUSE__CONDITION,
				 Xmu2coreFactory.eINSTANCE.createObjectValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.CASE_EXPRESSION_CLAUSE__CONDITION,
				 Xmu2coreFactory.eINSTANCE.createVariableExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.CASE_EXPRESSION_CLAUSE__CONDITION,
				 Xmu2coreFactory.eINSTANCE.createEntryRuleParameter()));
	}

}
