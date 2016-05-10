/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.grammar;

public class Xmu2LineBreak extends edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2FormattingElement {
	
	private final int tabs;
	
	public Xmu2LineBreak(edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Cardinality cardinality, int tabs) {
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
