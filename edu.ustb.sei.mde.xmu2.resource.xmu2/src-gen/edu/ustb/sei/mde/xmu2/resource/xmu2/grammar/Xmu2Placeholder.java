/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class Xmu2Placeholder extends edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Terminal {
	
	private final String tokenName;
	
	public Xmu2Placeholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Cardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
