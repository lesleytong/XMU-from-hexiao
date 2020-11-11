package edu.ustb.sei.mde.query.infra.ecore;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

public class InverseEFeature implements EStructuralFeature {
	
	public InverseEFeature(EStructuralFeature originalFeature) {
		super();
		this.originalFeature = originalFeature;
	}
	
	public EStructuralFeature getOriginalFeature() {
		return originalFeature;
	}

	private EStructuralFeature originalFeature;

	@Override
	public boolean isOrdered() {
		return false;
	}

	@Override
	public void setOrdered(boolean value) {}

	@Override
	public boolean isUnique() {
		if(originalFeature instanceof EReference)
			return ((EReference) originalFeature).isContainment();
		return false;
	}

	@Override
	public void setUnique(boolean value) {}

	@Override
	public int getLowerBound() {return 0;}

	@Override
	public void setLowerBound(int value) {}

	@Override
	public int getUpperBound() {
		if(originalFeature instanceof EReference)
			return ((EReference) originalFeature).isContainment() ? 1 : -1;
		return -1;
	}

	@Override
	public void setUpperBound(int value) {}

	@Override
	public boolean isMany() {
		return getUpperBound()!=1;
	}

	@Override
	public boolean isRequired() {
		return false;
	}

	@Override
	public EClassifier getEType() {
		return originalFeature.getEContainingClass();
	}

	@Override
	public void setEType(EClassifier value) {}

	@Override
	public EGenericType getEGenericType() {
		return null;
	}

	@Override
	public void setEGenericType(EGenericType value) {
	}
	
	private String name = null;

	@Override
	public String getName() {
		if(name==null) 
			name = "~"+originalFeature.getName();
		return name;
	}

	@Override
	public void setName(String value) {}

	@Override
	public EList<EAnnotation> getEAnnotations() {
		return null;
	}

	@Override
	public EAnnotation getEAnnotation(String source) {
		return null;
	}

	@Override
	public EClass eClass() {
		return originalFeature.eClass();
	}

	@Override
	public Resource eResource() {
		return originalFeature.eResource();
	}

	@Override
	public EObject eContainer() {
		return originalFeature.eContainer();
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		return originalFeature.eContainingFeature();
	}

	@Override
	public EReference eContainmentFeature() {
		return originalFeature.eContainmentFeature();
	}

	@Override
	public EList<EObject> eContents() {
		return originalFeature.eContents();
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		return originalFeature.eAllContents();
	}

	@Override
	public boolean eIsProxy() {
		return originalFeature.eIsProxy();
	}

	@Override
	public EList<EObject> eCrossReferences() {
		throw new RuntimeException("InverseFeature is just a placeholder");
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		throw new RuntimeException("InverseFeature is just a placeholder");	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		throw new RuntimeException("InverseFeature is just a placeholder");
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
		throw new RuntimeException("InverseFeature is just a placeholder");
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		throw new RuntimeException("InverseFeature is just a placeholder");
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
		throw new RuntimeException("InverseFeature is just a placeholder");
	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
		throw new RuntimeException("InverseFeature is just a placeholder");
	}

	@Override
	public EList<Adapter> eAdapters() {
		throw new RuntimeException("InverseFeature is just a placeholder");
	}

	@Override
	public boolean eDeliver() {
		throw new RuntimeException("InverseFeature is just a placeholder");
	}

	@Override
	public void eSetDeliver(boolean deliver) {
		throw new RuntimeException("InverseFeature is just a placeholder");
	}

	@Override
	public void eNotify(Notification notification) {
		throw new RuntimeException("InverseFeature is just a placeholder");
	}

	@Override
	public boolean isTransient() {
		return originalFeature.isTransient();
	}

	@Override
	public void setTransient(boolean value) {}

	@Override
	public boolean isVolatile() {
		return originalFeature.isVolatile();
	}

	@Override
	public void setVolatile(boolean value) {}

	@Override
	public boolean isChangeable() {
		return originalFeature.isChangeable();
	}

	@Override
	public void setChangeable(boolean value) {}

	@Override
	public String getDefaultValueLiteral() {
		throw new RuntimeException("InverseFeature is just a placeholder");
	}

	@Override
	public void setDefaultValueLiteral(String value) {
		throw new RuntimeException("InverseFeature is just a placeholder");
	}

	@Override
	public Object getDefaultValue() {
		throw new RuntimeException("InverseFeature is just a placeholder");
	}

	@Override
	public void setDefaultValue(Object value) {
		throw new RuntimeException("InverseFeature is just a placeholder");
	}

	@Override
	public boolean isUnsettable() {
		return originalFeature.isUnsettable();
	}

	@Override
	public void setUnsettable(boolean value) {}

	@Override
	public boolean isDerived() {
		return true;
	}

	@Override
	public void setDerived(boolean value) {}

	@Override
	public EClass getEContainingClass() {
		return originalFeature.getEContainingClass();
	}

	@Override
	public int getFeatureID() {
		return 0;
	}

	@Override
	public Class<?> getContainerClass() {
		return originalFeature.getContainerClass();
	}

}
