/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.grammar;

public class MorelLineBreak extends edu.ustb.sei.mde.morel.resource.morel.grammar.MorelFormattingElement {
	
	private final int tabs;
	
	public MorelLineBreak(edu.ustb.sei.mde.morel.resource.morel.grammar.MorelCardinality cardinality, int tabs) {
		super(cardinality);
		this.tabs = tabs;
	}
	
	public int getTabs() {
		return tabs;
	}
	
	public String toString() {
		return "!" + getTabs();
	}
	
}
