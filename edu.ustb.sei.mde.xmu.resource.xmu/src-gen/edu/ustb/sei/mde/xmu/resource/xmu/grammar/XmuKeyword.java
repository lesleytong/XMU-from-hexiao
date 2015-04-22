/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class XmuKeyword extends edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuSyntaxElement {
	
	private final String value;
	
	public XmuKeyword(String value, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuCardinality cardinality) {
		super(cardinality, null);
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
