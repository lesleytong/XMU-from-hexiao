/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class MorelKeyword extends edu.ustb.sei.mde.morel.resource.morel.grammar.MorelSyntaxElement {
	
	private final String value;
	
	public MorelKeyword(String value, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelCardinality cardinality) {
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
