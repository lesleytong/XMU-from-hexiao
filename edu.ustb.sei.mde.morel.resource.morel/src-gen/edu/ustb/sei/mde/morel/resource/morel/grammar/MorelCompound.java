/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.grammar;

public class MorelCompound extends edu.ustb.sei.mde.morel.resource.morel.grammar.MorelSyntaxElement {
	
	public MorelCompound(edu.ustb.sei.mde.morel.resource.morel.grammar.MorelChoice choice, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelCardinality cardinality) {
		super(cardinality, new edu.ustb.sei.mde.morel.resource.morel.grammar.MorelSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
