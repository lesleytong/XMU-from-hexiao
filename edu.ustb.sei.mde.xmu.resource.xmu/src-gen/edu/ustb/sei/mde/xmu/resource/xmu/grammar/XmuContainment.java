/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.grammar;

public class XmuContainment extends edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public XmuContainment(org.eclipse.emf.ecore.EStructuralFeature feature, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		String typeRestrictions = null;
		if (allowedTypes != null && allowedTypes.length > 0) {
			typeRestrictions = edu.ustb.sei.mde.xmu.resource.xmu.util.XmuStringUtil.explode(allowedTypes, ", ", new edu.ustb.sei.mde.xmu.resource.xmu.IXmuFunction1<String, org.eclipse.emf.ecore.EClass>() {
				public String execute(org.eclipse.emf.ecore.EClass eClass) {
					return eClass.getName();
				}
			});
		}
		return getFeature().getName() + (typeRestrictions == null ? "" : "[" + typeRestrictions + "]");
	}
	
}
