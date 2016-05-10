/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.grammar;

public class Xmu2Compound extends edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2SyntaxElement {
	
	public Xmu2Compound(edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Choice choice, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Cardinality cardinality) {
		super(cardinality, new edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2SyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
