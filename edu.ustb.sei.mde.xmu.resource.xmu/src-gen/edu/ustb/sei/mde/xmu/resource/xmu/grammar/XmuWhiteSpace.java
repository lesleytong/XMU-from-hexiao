/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.grammar;

public class XmuWhiteSpace extends edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuFormattingElement {
	
	private final int amount;
	
	public XmuWhiteSpace(int amount, edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuCardinality cardinality) {
		super(cardinality);
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public String toString() {
		return "#" + getAmount();
	}
	
}
