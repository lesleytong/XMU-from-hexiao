/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.grammar;

public class XmuChoice extends edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuSyntaxElement {
	
	public XmuChoice(edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuCardinality cardinality, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuSyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return edu.ustb.sei.mde.xmu.resource.xmu.util.XmuStringUtil.explode(getChildren(), "|");
	}
	
}
