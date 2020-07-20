package edu.ustb.sei.mde.query.infra.ecore;

import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import edu.ustb.sei.mde.query.infra.TypeContext;
import edu.ustb.sei.mde.query.structure.ContainerCreator;

public class EcoreTypeContext
		extends TypeContext<EPackage, EClassifier, EClass, EDataType, EStructuralFeature, EReference, EAttribute> {
	
	public EcoreTypeContext() {
	}
	
	private Map<EStructuralFeature, EStructuralFeature> pseudoInverse = ContainerCreator.autoMap();

	@Override
	protected void resolvePackage(EPackage pkg) {
		int nodeSize = this.typeIdMap.size();
		int edgeSize = this.featureIdMap.size();
		
		TreeIterator<EObject> it = pkg.eAllContents();
		
		while(it.hasNext()) {
			EObject e = it.next();
			if(e instanceof EClass) {
				int id = nodeSize++;
				this.addTypeIdMap((EClass)e, id);
				
				((EClass) e).getEAllSuperTypes().forEach(sup->addSubclasses(sup,(EClass)e));
				addSupClasses((EClass)e, ((EClass) e).getEAllSuperTypes());
				addToSortedList((EClass)e);
				
				// for performance reason, we put the following two lines here
				this.addReferences((EClass)e, ((EClass) e).getEAllReferences());
				this.addAttributes((EClass)e, ((EClass) e).getEAllAttributes());
			} else if(e instanceof EReference) {
				int id = edgeSize++;
				this.addFeatureIdMap((EReference)e, id);
				if(((EReference) e).getEOpposite()==null) {
					id = edgeSize++;
					InverseEFeature inverse = new InverseEFeature((EReference) e);
					this.registerInverseFeature(inverse);
					this.addFeatureIdMap(inverse, id);	
					this.addInverseReference(((EReference) e).getEReferenceType(), (EReference) e);
				}
			} else if(e instanceof EDataType) {
//				this.typeIdMap.put((EDataType)e, nodeSize++);
			} else if(e instanceof EAttribute) {
				InverseEFeature inverse = new InverseEFeature((EAttribute) e);
				this.registerInverseFeature(inverse);	
			}
		}
		
	}

	@Override
	public boolean isClass(EClassifier c) {
		return c instanceof EClass;
	}

	@Override
	public EStructuralFeature getInverseFeature(EStructuralFeature feature) {
		if(feature instanceof EReference) {
			if(((EReference) feature).getEOpposite()!=null) return ((EReference) feature).getEOpposite();
			else return this.pseudoInverse.get(feature);
		} else {
			return this.pseudoInverse.get(feature);
		}
	}
	
	protected void registerInverseFeature(InverseEFeature inv) {
		this.pseudoInverse.put(inv.getOriginalFeature(), inv);
	}

	@Override
	public boolean isReference(EStructuralFeature type) {
		return type instanceof EReference;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(super.toString());
		builder.append("Inverse:\n");
		this.pseudoInverse.forEach((k,v)->{
			builder.append("\t[inv] ");
			builder.append(featureIdMap.forwardGet(v));
			builder.append("\t->\t");
			builder.append(k);
			builder.append("\n");
		});
		
		return builder.toString();
	}
}
