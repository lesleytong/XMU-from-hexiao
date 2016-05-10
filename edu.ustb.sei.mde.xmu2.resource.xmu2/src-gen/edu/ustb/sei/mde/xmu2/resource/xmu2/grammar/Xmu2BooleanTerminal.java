/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.grammar;

/**
 * A class to represent boolean terminals in a grammar.
 */
public class Xmu2BooleanTerminal extends edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Terminal {
	
	private String trueLiteral;
	private String falseLiteral;
	
	public Xmu2BooleanTerminal(org.eclipse.emf.ecore.EStructuralFeature attribute, String trueLiteral, String falseLiteral, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Cardinality cardinality, int mandatoryOccurrencesAfter) {
		super(attribute, cardinality, mandatoryOccurrencesAfter);
		assert attribute instanceof org.eclipse.emf.ecore.EAttribute;
		this.trueLiteral = trueLiteral;
		this.falseLiteral = falseLiteral;
	}
	
	public String getTrueLiteral() {
		return trueLiteral;
	}
	
	public String getFalseLiteral() {
		return falseLiteral;
	}
	
	public org.eclipse.emf.ecore.EAttribute getAttribute() {
		return (org.eclipse.emf.ecore.EAttribute) getFeature();
	}
	
}
