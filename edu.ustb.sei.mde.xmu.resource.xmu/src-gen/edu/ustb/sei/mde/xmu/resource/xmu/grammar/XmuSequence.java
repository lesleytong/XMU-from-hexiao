/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.grammar;

public class XmuSequence extends edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuSyntaxElement {
	
	public XmuSequence(edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuCardinality cardinality, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuSyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return edu.ustb.sei.mde.xmu.resource.xmu.util.XmuStringUtil.explode(getChildren(), " ");
	}
	
}
