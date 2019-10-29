/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.grammar;

public class Xmu2WhiteSpace extends edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2FormattingElement {
	
	private final int amount;
	
	public Xmu2WhiteSpace(int amount, edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Cardinality cardinality) {
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
