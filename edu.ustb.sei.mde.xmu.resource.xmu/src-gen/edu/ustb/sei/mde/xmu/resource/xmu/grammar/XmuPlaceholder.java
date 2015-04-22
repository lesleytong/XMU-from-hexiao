/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.grammar;

/**
 * A class to represent placeholders in a grammar.
 */
public class XmuPlaceholder extends edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuTerminal {
	
	private final String tokenName;
	
	public XmuPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
