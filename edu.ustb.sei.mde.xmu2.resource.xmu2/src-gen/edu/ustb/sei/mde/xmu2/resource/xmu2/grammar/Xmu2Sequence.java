/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.grammar;

public class Xmu2Sequence extends edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2SyntaxElement {
	
	public Xmu2Sequence(edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Cardinality cardinality, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2SyntaxElement... elements) {
		super(cardinality, elements);
	}
	
	public String toString() {
		return edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2StringUtil.explode(getChildren(), " ");
	}
	
}
