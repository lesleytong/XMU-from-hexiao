/**
 */
package edu.ustb.sei.mde.xmu2core.provider;


import edu.ustb.sei.mde.xmu2core.AlignStatement;
import edu.ustb.sei.mde.xmu2core.Xmu2coreFactory;
import edu.ustb.sei.mde.xmu2core.Xmu2corePackage;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.emf.ecore.*;

/**
 * This is the item provider adapter for a {@link edu.ustb.sei.mde.xmu2core.AlignStatement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AlignStatementItemProvider extends StatementItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlignStatementItemProvider(AdapterFactory adapterFactory) {
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
			childrenFeatures.add(Xmu2corePackage.Literals.ALIGN_STATEMENT__SOURCE);
			childrenFeatures.add(Xmu2corePackage.Literals.ALIGN_STATEMENT__VIEW);
			childrenFeatures.add(Xmu2corePackage.Literals.ALIGN_STATEMENT__MATCH);
			childrenFeatures.add(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHV);
			childrenFeatures.add(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHS);
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
	 * This returns AlignStatement.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/AlignStatement"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		return ((EObject)object).eContainmentFeature().getName() + " -> "+getString("_UI_AlignStatement_type");
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

		switch (notification.getFeatureID(AlignStatement.class)) {
			case Xmu2corePackage.ALIGN_STATEMENT__SOURCE:
			case Xmu2corePackage.ALIGN_STATEMENT__VIEW:
			case Xmu2corePackage.ALIGN_STATEMENT__MATCH:
			case Xmu2corePackage.ALIGN_STATEMENT__UNMATCHV:
			case Xmu2corePackage.ALIGN_STATEMENT__UNMATCHS:
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
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__SOURCE,
				 Xmu2coreFactory.eINSTANCE.createPattern()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__VIEW,
				 Xmu2coreFactory.eINSTANCE.createPattern()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__MATCH,
				 Xmu2coreFactory.eINSTANCE.createAlignStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__MATCH,
				 Xmu2coreFactory.eINSTANCE.createCaseStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__MATCH,
				 Xmu2coreFactory.eINSTANCE.createCallStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__MATCH,
				 Xmu2coreFactory.eINSTANCE.createForEachStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__MATCH,
				 Xmu2coreFactory.eINSTANCE.createDeleteNodeStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__MATCH,
				 Xmu2coreFactory.eINSTANCE.createDeleteLinkStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__MATCH,
				 Xmu2coreFactory.eINSTANCE.createEnforceNodeStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__MATCH,
				 Xmu2coreFactory.eINSTANCE.createEnforceLinkStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__MATCH,
				 Xmu2coreFactory.eINSTANCE.createMatchPattern()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__MATCH,
				 Xmu2coreFactory.eINSTANCE.createCheckExpressionStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__MATCH,
				 Xmu2coreFactory.eINSTANCE.createEnforceExpressionStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__MATCH,
				 Xmu2coreFactory.eINSTANCE.createSolveConstraintStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__MATCH,
				 Xmu2coreFactory.eINSTANCE.createCommandStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHV,
				 Xmu2coreFactory.eINSTANCE.createAlignStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHV,
				 Xmu2coreFactory.eINSTANCE.createCaseStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHV,
				 Xmu2coreFactory.eINSTANCE.createCallStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHV,
				 Xmu2coreFactory.eINSTANCE.createForEachStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHV,
				 Xmu2coreFactory.eINSTANCE.createDeleteNodeStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHV,
				 Xmu2coreFactory.eINSTANCE.createDeleteLinkStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHV,
				 Xmu2coreFactory.eINSTANCE.createEnforceNodeStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHV,
				 Xmu2coreFactory.eINSTANCE.createEnforceLinkStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHV,
				 Xmu2coreFactory.eINSTANCE.createMatchPattern()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHV,
				 Xmu2coreFactory.eINSTANCE.createCheckExpressionStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHV,
				 Xmu2coreFactory.eINSTANCE.createEnforceExpressionStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHV,
				 Xmu2coreFactory.eINSTANCE.createSolveConstraintStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHV,
				 Xmu2coreFactory.eINSTANCE.createCommandStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHS,
				 Xmu2coreFactory.eINSTANCE.createAlignStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHS,
				 Xmu2coreFactory.eINSTANCE.createCaseStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHS,
				 Xmu2coreFactory.eINSTANCE.createCallStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHS,
				 Xmu2coreFactory.eINSTANCE.createForEachStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHS,
				 Xmu2coreFactory.eINSTANCE.createDeleteNodeStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHS,
				 Xmu2coreFactory.eINSTANCE.createDeleteLinkStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHS,
				 Xmu2coreFactory.eINSTANCE.createEnforceNodeStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHS,
				 Xmu2coreFactory.eINSTANCE.createEnforceLinkStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHS,
				 Xmu2coreFactory.eINSTANCE.createMatchPattern()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHS,
				 Xmu2coreFactory.eINSTANCE.createCheckExpressionStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHS,
				 Xmu2coreFactory.eINSTANCE.createEnforceExpressionStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHS,
				 Xmu2coreFactory.eINSTANCE.createSolveConstraintStatement()));

		newChildDescriptors.add
			(createChildParameter
				(Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHS,
				 Xmu2coreFactory.eINSTANCE.createCommandStatement()));
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
			childFeature == Xmu2corePackage.Literals.ALIGN_STATEMENT__SOURCE ||
			childFeature == Xmu2corePackage.Literals.ALIGN_STATEMENT__VIEW ||
			childFeature == Xmu2corePackage.Literals.ALIGN_STATEMENT__MATCH ||
			childFeature == Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHV ||
			childFeature == Xmu2corePackage.Literals.ALIGN_STATEMENT__UNMATCHS;

		if (qualify) {
			return getString
				("_UI_CreateChild_text2",
				 new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

}
