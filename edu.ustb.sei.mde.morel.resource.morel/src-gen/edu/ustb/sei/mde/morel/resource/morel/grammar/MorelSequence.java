/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.grammar;

public class MorelSequence extends edu.ustb.sei.mde.morel.resource.morel.grammar.MorelSyntaxElement {
	
	public MorelSequence(edu.ustb.sei.mde.morel.resource.morel.grammar.MorelCardinality cardinality, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return edu.ustb.sei.mde.morel.resource.morel.util.MorelStringUtil.explode(getChildren(), " ");
	}
	
}
