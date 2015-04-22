/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

/**
 * A representation for a range in a document where a boolean attribute is
 * expected.
 */
public class XmuExpectedBooleanTerminal extends edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuAbstractExpectedElement {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuBooleanTerminal booleanTerminal;
	
	public XmuExpectedBooleanTerminal(edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuBooleanTerminal booleanTerminal) {
		super(booleanTerminal.getMetaclass());
		this.booleanTerminal = booleanTerminal;
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuBooleanTerminal getBooleanTerminal() {
		return booleanTerminal;
	}
	
	/**
	 * Returns the expected boolean terminal.
	 */
	public edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuSyntaxElement getSymtaxElement() {
		return booleanTerminal;
	}
	
	private org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return booleanTerminal.getFeature();
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof XmuExpectedBooleanTerminal) {
			return getFeature().equals(((XmuExpectedBooleanTerminal) o).getFeature());
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
