/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.grammar;

/**
 * A class to represent a keyword in the grammar.
 */
public class Xmu2Keyword extends edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2SyntaxElement {
	
	private final String value;
	
	public Xmu2Keyword(String value, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Cardinality cardinality) {
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
