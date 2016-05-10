/**
 */
package edu.ustb.sei.mde.xmu2core.provider;


import edu.ustb.sei.mde.xmu2core.ForEachStatement;
import edu.ustb.sei.mde.xmu2core.Xmu2coreFactory;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link edu.ustb.sei.mde.xmu2core.ForEachStatement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ForEachStatementItemProvider extends StatementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForEachStatementItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(Xmu2corePackage.Literals.FOR_EACH_STATEMENT__PATTERN);
			childrenFeatures.add(Xmu2corePackage.Literals.FOR_EACH_STATEMENT__ACTION);
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
	 * This returns ForEachStatement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ForEachStatement"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return ((EObject)object).eContainmentFeature().getName() + " -> "+getString("_UI_ForEachStatement_type");
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

		switch (notification.getFeatureID(ForEachStatement.class)) {
			case Xmu2corePackage.FOR_EACH_STATEMENT__PATTERN:
			case Xmu2corePackage.FOR_EACH_STATEMENT__ACTION:
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
				(Xmu2corePackage.Literals.FOR_EACH_STATEMENT__PATTERN,
				 Xmu2coreFactory.eINSTANCE.createPattern()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.FOR_EACH_STATEMENT__ACTION,
				 Xmu2coreFactory.eINSTANCE.createAlignStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.FOR_EACH_STATEMENT__ACTION,
				 Xmu2coreFactory.eINSTANCE.createCaseStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.FOR_EACH_STATEMENT__ACTION,
				 Xmu2coreFactory.eINSTANCE.createProcedureCallStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.FOR_EACH_STATEMENT__ACTION,
				 Xmu2coreFactory.eINSTANCE.createForEachStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.FOR_EACH_STATEMENT__ACTION,
				 Xmu2coreFactory.eINSTANCE.createDeleteNodeStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.FOR_EACH_STATEMENT__ACTION,
				 Xmu2coreFactory.eINSTANCE.createDeleteLinkStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.FOR_EACH_STATEMENT__ACTION,
				 Xmu2coreFactory.eINSTANCE.createEnforceNodeStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.FOR_EACH_STATEMENT__ACTION,
				 Xmu2coreFactory.eINSTANCE.createEnforceLinkStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.FOR_EACH_STATEMENT__ACTION,
				 Xmu2coreFactory.eINSTANCE.createMatchPattern()));
	}

}
