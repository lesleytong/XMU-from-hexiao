/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.grammar;

public class XmuLineBreak extends edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuFormattingElement {
	
	private final int tabs;
	
	public XmuLineBreak(edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuCardinality cardinality, int tabs) {
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
