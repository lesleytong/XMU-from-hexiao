/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.grammar;

public class MorelChoice extends edu.ustb.sei.mde.morel.resource.morel.grammar.MorelSyntaxElement {
	
	public MorelChoice(edu.ustb.sei.mde.morel.resource.morel.grammar.MorelCardinality cardinality, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return edu.ustb.sei.mde.morel.resource.morel.util.MorelStringUtil.explode(getChildren(), "|");
	}
	
}
