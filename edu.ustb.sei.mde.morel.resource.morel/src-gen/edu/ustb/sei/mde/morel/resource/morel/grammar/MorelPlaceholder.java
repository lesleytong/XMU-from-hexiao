/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class MorelPlaceholder extends edu.ustb.sei.mde.morel.resource.morel.grammar.MorelTerminal {
	
	private final String tokenName;
	
	public MorelPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
