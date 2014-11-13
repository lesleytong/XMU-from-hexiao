package edu.ustb.sei.mde.morel.resource.morel.analysis;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;

public class FeatureResolver {
	public static EEnumLiteral getEnumLiteral(String identifier, EEnum container) {
		EEnumLiteral literal = container.getEEnumLiteral(identifier);
		if(literal==null&&identifier.charAt(0)=='_') {
			literal = container.getEEnumLiteral(identifier.substring(1));
		}
		return literal;
	}
	
	public static EStructuralFeature getStructuralFeature(String identifier, EClass cls) {
		EStructuralFeature feature = cls.getEStructuralFeature(identifier);
		if(feature==null && identifier.charAt(0)=='_') {
			feature = cls.getEStructuralFeature(identifier.substring(0));
		}
		return feature;
	}

}
