/**
 */
package edu.ustb.sei.mde.xmu2core.provider;


import edu.ustb.sei.mde.xmu2common.RelationalOperator;

import edu.ustb.sei.mde.xmu2core.RelationalExpression;
import edu.ustb.sei.mde.xmu2core.Xmu2coreFactory;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.ustb.sei.mde.xmu2core.RelationalExpression} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RelationalExpressionItemProvider extends ExpressionItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalExpressionItemProvider(AdapterFactory adapterFactory) {
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

			addOperatorPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Operator feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOperatorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_RelationalExpression_operator_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_RelationalExpression_operator_feature", "_UI_RelationalExpression_type"),
				 Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__OPERATOR,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
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
			childrenFeatures.add(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT);
			childrenFeatures.add(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT);
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
	 * This returns RelationalExpression.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/RelationalExpression"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		RelationalOperator labelValue = ((RelationalExpression)object).getOperator();
		String label = labelValue == null ? null : labelValue.toString();
		return label == null || label.length() == 0 ?
			getString("_UI_RelationalExpression_type") :
			getString("_UI_RelationalExpression_type") + " " + label;
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

		switch (notification.getFeatureID(RelationalExpression.class)) {
			case Xmu2corePackage.RELATIONAL_EXPRESSION__OPERATOR:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case Xmu2corePackage.RELATIONAL_EXPRESSION__LEFT:
			case Xmu2corePackage.RELATIONAL_EXPRESSION__RIGHT:
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
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT,
				 Xmu2coreFactory.eINSTANCE.createBooleanOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT,
				 Xmu2coreFactory.eINSTANCE.createBooleanAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT,
				 Xmu2coreFactory.eINSTANCE.createRelationalExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT,
				 Xmu2coreFactory.eINSTANCE.createAdditiveExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT,
				 Xmu2coreFactory.eINSTANCE.createMultiplicativeExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT,
				 Xmu2coreFactory.eINSTANCE.createUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT,
				 Xmu2coreFactory.eINSTANCE.createTypeCastExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT,
				 Xmu2coreFactory.eINSTANCE.createStringValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT,
				 Xmu2coreFactory.eINSTANCE.createBooleanValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT,
				 Xmu2coreFactory.eINSTANCE.createIntegerValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT,
				 Xmu2coreFactory.eINSTANCE.createEnumValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT,
				 Xmu2coreFactory.eINSTANCE.createEmptyValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT,
				 Xmu2coreFactory.eINSTANCE.createObjectValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT,
				 Xmu2coreFactory.eINSTANCE.createVariableExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT,
				 Xmu2coreFactory.eINSTANCE.createEntryRuleParameter()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT,
				 Xmu2coreFactory.eINSTANCE.createTupleExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT,
				 Xmu2coreFactory.eINSTANCE.createBooleanOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT,
				 Xmu2coreFactory.eINSTANCE.createBooleanAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT,
				 Xmu2coreFactory.eINSTANCE.createRelationalExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT,
				 Xmu2coreFactory.eINSTANCE.createAdditiveExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT,
				 Xmu2coreFactory.eINSTANCE.createMultiplicativeExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT,
				 Xmu2coreFactory.eINSTANCE.createUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT,
				 Xmu2coreFactory.eINSTANCE.createTypeCastExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT,
				 Xmu2coreFactory.eINSTANCE.createStringValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT,
				 Xmu2coreFactory.eINSTANCE.createBooleanValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT,
				 Xmu2coreFactory.eINSTANCE.createIntegerValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT,
				 Xmu2coreFactory.eINSTANCE.createEnumValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT,
				 Xmu2coreFactory.eINSTANCE.createEmptyValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT,
				 Xmu2coreFactory.eINSTANCE.createObjectValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT,
				 Xmu2coreFactory.eINSTANCE.createVariableExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT,
				 Xmu2coreFactory.eINSTANCE.createEntryRuleParameter()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT,
				 Xmu2coreFactory.eINSTANCE.createTupleExpression()));
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify =
			childFeature == Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__LEFT ||
			childFeature == Xmu2corePackage.Literals.RELATIONAL_EXPRESSION__RIGHT;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
