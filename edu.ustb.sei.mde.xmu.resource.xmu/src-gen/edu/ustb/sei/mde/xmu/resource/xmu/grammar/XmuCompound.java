/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.grammar;

public class XmuCompound extends edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuSyntaxElement {
	
	public XmuCompound(edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuChoice choice, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuCardinality cardinality) {
		super(cardinality, new edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuSyntaxElement[] {choice});
	}
	
	public String toString() {
		return "(" + getChildren()[0] + ")";
	}
	
}
