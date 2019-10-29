/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.grammar;

public class Xmu2Containment extends edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Terminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public Xmu2Containment(org.eclipse.emf.ecore.EStructuralFeature feature, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Cardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2StringUtil.explode(allowedTypes, ", ", new edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Function1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
