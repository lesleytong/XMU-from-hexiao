/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.grammar;

public class MorelWhiteSpace extends edu.ustb.sei.mde.morel.resource.morel.grammar.MorelFormattingElement {
	
	private final int amount;
	
	public MorelWhiteSpace(int amount, edu.ustb.sei.mde.morel.resource.morel.grammar.MorelCardinality cardinality) {
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
