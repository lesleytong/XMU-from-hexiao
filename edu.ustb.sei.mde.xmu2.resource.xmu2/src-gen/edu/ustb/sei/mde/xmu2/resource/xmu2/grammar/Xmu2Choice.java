/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.grammar;

public class Xmu2Choice extends edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2SyntaxElement {
	
	public Xmu2Choice(edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Cardinality cardinality, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2SyntaxElement... choices) {
		super(cardinality, choices);
	}
	
	public String toString() {
		return edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2StringUtil.explode(getChildren(), "|");
	}
	
}
