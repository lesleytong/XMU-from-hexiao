package edu.ustb.sei.mde.morel.resource.morel.mopp;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

public class SetPackageReferenceQuickFix extends MorelQuickFix {

	public SetPackageReferenceQuickFix(String displayString, String imageKey, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, org.eclipse.emf.ecore.EObject target) {
		super(displayString, imageKey, java.util.Arrays.asList(container, reference, target));
		this.container = container;
		this.reference = reference;
		this.element = target;
	}
	
	private EObject container;
	private EReference reference;
	private EObject element;

	@Override
	public void applyChanges() {
		if(reference.isMany()) {
			List<EObject> list = (List<EObject>)container.eGet(reference);
			list.add(element);
		} else {
			container.eSet(reference, element);
		}
	}

}
