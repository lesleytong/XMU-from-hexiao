/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

/**
 * A representation for a range in a document where a boolean attribute is
 * expected.
 */
public class Xmu2ExpectedBooleanTerminal extends edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2AbstractExpectedElement {
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2BooleanTerminal booleanTerminal;
	
	public Xmu2ExpectedBooleanTerminal(edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2BooleanTerminal booleanTerminal) {
		super(booleanTerminal.getMetaclass());
		this.booleanTerminal = booleanTerminal;
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2BooleanTerminal getBooleanTerminal() {
		return booleanTerminal;
	}
	
	/**
	 * Returns the expected boolean terminal.
	 */
	public edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2SyntaxElement getSymtaxElement() {
		return booleanTerminal;
	}
	
	private org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return booleanTerminal.getFeature();
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof Xmu2ExpectedBooleanTerminal) {
			return getFeature().equals(((Xmu2ExpectedBooleanTerminal) o).getFeature());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
	public java.util.Set<String> getTokenNames() {
		// BooleanTerminals are associated with two or one token(s)
		java.util.Set<String> tokenNames = new java.util.LinkedHashSet<String>(2);
		String trueLiteral = booleanTerminal.getTrueLiteral();
		if (!"".equals(trueLiteral)) {
			tokenNames.add("'" + trueLiteral + "'");
		}
		String falseLiteral = booleanTerminal.getFalseLiteral();
		if (!"".equals(falseLiteral)) {
			tokenNames.add("'" + falseLiteral + "'");
		}
		return tokenNames;
	}
	
}
