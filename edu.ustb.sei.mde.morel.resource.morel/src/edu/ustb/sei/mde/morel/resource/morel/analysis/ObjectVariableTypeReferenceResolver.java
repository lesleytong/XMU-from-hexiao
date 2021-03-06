/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import edu.ustb.sei.mde.morel.TypedModel;
import edu.ustb.sei.mde.morel.Unit;
import edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult;

public class ObjectVariableTypeReferenceResolver implements edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolver<edu.ustb.sei.mde.morel.ObjectVariable, org.eclipse.emf.ecore.EClass> {
	
	private edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<EPackage, org.eclipse.emf.ecore.EClass> delegate = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultResolverDelegate<EPackage, org.eclipse.emf.ecore.EClass>();
	
	public void resolve(String identifier, edu.ustb.sei.mde.morel.ObjectVariable container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		
		Unit unit = TypeResolver.getUnit(container);
		if(unit==null) return;
		else {
			String modelType = container.getModel()==null?null:container.getModel().getName();
			String typeName = identifier;
			
			if(resolveFuzzy) {
				for(TypedModel mt : unit.getModels()) {
					if(mt.getName().equals(modelType)) {
						TypeResolver.collectContained(typeName,mt.getPackage(),result);						
					}
				}		
			} else {
				for(TypedModel mt : unit.getModels()) {
					if(mt.getName().equals(modelType)) {
						delegate.resolve(typeName, mt.getPackage(), reference, position, resolveFuzzy, result);						
					}
				}			
			}
		}
	}
	
	
	
	public String deResolve(org.eclipse.emf.ecore.EClass element, edu.ustb.sei.mde.morel.ObjectVariable container, org.eclipse.emf.ecore.EReference reference) {
//		StringBuilder sb = new StringBuilder();
//		List<String> array = new ArrayList<String>();
//		
//		array.add(element.getName());
//		array.add(":");
//		
//		EPackage pkg = element.getEPackage();
//		while(true) {
//			array.add(pkg.getName());
//			if(pkg.getESuperPackage()==null) break;
//			array.add(":");
//		}
//		array.add("!");		
//		Unit unit = getUnit(container);
//		for(TypedModel mt : unit.getModels()) {
//			if(mt.getPackage()==pkg) {
//				array.add(mt.getName());
//			}
//		}
//
//		for(int i=array.size()-1;i>=0;i--) {
//			sb.append(array.get(i));
//		}
//		
//		return sb.toString();
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
