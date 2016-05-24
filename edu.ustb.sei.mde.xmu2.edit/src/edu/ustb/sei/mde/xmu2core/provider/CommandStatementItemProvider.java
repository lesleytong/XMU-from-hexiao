/**
 */
package edu.ustb.sei.mde.xmu2core.provider;


import edu.ustb.sei.mde.xmu2core.CommandStatement;
import edu.ustb.sei.mde.xmu2core.Xmu2coreFactory;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.ustb.sei.mde.xmu2core.CommandStatement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CommandStatementItemProvider extends StatementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommandStatementItemProvider(AdapterFactory adapterFactory) {
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

			addCommandPropertyDescriptor(object);
			addParametersPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Parameters feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addParametersPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CommandStatement_parameters_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CommandStatement_parameters_feature", "_UI_CommandStatement_type"),
				 Xmu2corePackage.Literals.COMMAND_STATEMENT__PARAMETERS,
				 true,
				 false,
				 false,
				 null,
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
			childrenFeatures.add(Xmu2corePackage.Literals.COMMAND_STATEMENT__ACTIONS);
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
	 * This adds a property descriptor for the Command feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCommandPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CommandStatement_command_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CommandStatement_command_feature", "_UI_CommandStatement_type"),
				 Xmu2corePackage.Literals.COMMAND_STATEMENT__COMMAND,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This returns CommandStatement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/CommandStatement"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		String label = ((CommandStatement)object).getCommand();
		return label == null || label.length() == 0 ?
			((EObject)object).eContainmentFeature().getName() + " -> " + getString("_UI_CommandStatement_type") :
			getString("_UI_CommandStatement_type") + " " + label;
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

		switch (notification.getFeatureID(CommandStatement.class)) {
			case Xmu2corePackage.COMMAND_STATEMENT__COMMAND:
			case Xmu2corePackage.COMMAND_STATEMENT__PARAMETERS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case Xmu2corePackage.COMMAND_STATEMENT__ACTIONS:
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
				(Xmu2corePackage.Literals.COMMAND_STATEMENT__ACTIONS,
				 Xmu2coreFactory.eINSTANCE.createAlignStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.COMMAND_STATEMENT__ACTIONS,
				 Xmu2coreFactory.eINSTANCE.createCaseStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.COMMAND_STATEMENT__ACTIONS,
				 Xmu2coreFactory.eINSTANCE.createCallStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.COMMAND_STATEMENT__ACTIONS,
				 Xmu2coreFactory.eINSTANCE.createForEachStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.COMMAND_STATEMENT__ACTIONS,
				 Xmu2coreFactory.eINSTANCE.createDeleteNodeStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.COMMAND_STATEMENT__ACTIONS,
				 Xmu2coreFactory.eINSTANCE.createDeleteLinkStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.COMMAND_STATEMENT__ACTIONS,
				 Xmu2coreFactory.eINSTANCE.createEnforceNodeStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.COMMAND_STATEMENT__ACTIONS,
				 Xmu2coreFactory.eINSTANCE.createEnforceLinkStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.COMMAND_STATEMENT__ACTIONS,
				 Xmu2coreFactory.eINSTANCE.createMatchPattern()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.COMMAND_STATEMENT__ACTIONS,
				 Xmu2coreFactory.eINSTANCE.createCheckExpressionStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.COMMAND_STATEMENT__ACTIONS,
				 Xmu2coreFactory.eINSTANCE.createEnforceExpressionStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.COMMAND_STATEMENT__ACTIONS,
				 Xmu2coreFactory.eINSTANCE.createSolveConstraintStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.COMMAND_STATEMENT__ACTIONS,
				 Xmu2coreFactory.eINSTANCE.createCommandStatement()));
	}

}
