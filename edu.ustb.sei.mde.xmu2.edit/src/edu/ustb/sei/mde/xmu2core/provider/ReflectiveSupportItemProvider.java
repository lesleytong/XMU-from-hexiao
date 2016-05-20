/**
 */
package edu.ustb.sei.mde.xmu2core.provider;


import edu.ustb.sei.mde.xmu2core.ReflectiveSupport;
import edu.ustb.sei.mde.xmu2core.Xmu2coreFactory;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.ustb.sei.mde.xmu2core.ReflectiveSupport} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ReflectiveSupportItemProvider 
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReflectiveSupportItemProvider(AdapterFactory adapterFactory) {
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

			addReflectivePropertyDescriptor(object);
			addResolvePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Reflective feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addReflectivePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ReflectiveSupport_reflective_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ReflectiveSupport_reflective_feature", "_UI_ReflectiveSupport_type"),
				 Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__REFLECTIVE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Resolve feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResolvePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ReflectiveSupport_resolve_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ReflectiveSupport_resolve_feature", "_UI_ReflectiveSupport_type"),
				 Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__RESOLVE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
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
			childrenFeatures.add(Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER);
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		ReflectiveSupport reflectiveSupport = (ReflectiveSupport)object;
		return getString("_UI_ReflectiveSupport_type") + " " + reflectiveSupport.isReflective();
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

		switch (notification.getFeatureID(ReflectiveSupport.class)) {
			case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE:
			case Xmu2corePackage.REFLECTIVE_SUPPORT__RESOLVE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case Xmu2corePackage.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER:
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
				(Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER,
				 Xmu2coreFactory.eINSTANCE.createBooleanOrExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER,
				 Xmu2coreFactory.eINSTANCE.createBooleanAndExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER,
				 Xmu2coreFactory.eINSTANCE.createRelationalExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER,
				 Xmu2coreFactory.eINSTANCE.createAdditiveExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER,
				 Xmu2coreFactory.eINSTANCE.createMultiplicativeExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER,
				 Xmu2coreFactory.eINSTANCE.createUnaryExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER,
				 Xmu2coreFactory.eINSTANCE.createTypeCastExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER,
				 Xmu2coreFactory.eINSTANCE.createStringValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER,
				 Xmu2coreFactory.eINSTANCE.createBooleanValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER,
				 Xmu2coreFactory.eINSTANCE.createIntegerValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER,
				 Xmu2coreFactory.eINSTANCE.createEnumValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER,
				 Xmu2coreFactory.eINSTANCE.createEmptyValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER,
				 Xmu2coreFactory.eINSTANCE.createObjectValueExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER,
				 Xmu2coreFactory.eINSTANCE.createVariableExpression()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.REFLECTIVE_SUPPORT__REFLECTIVE_IDENTIFIER,
				 Xmu2coreFactory.eINSTANCE.createEntryRuleParameter()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return Xmu2coreEditPlugin.INSTANCE;
	}

}
