/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

/**
 * A representation for a range in a document where an enumeration literal (i.e.,
 * a set of static strings) is expected.
 */
public class Xmu2ExpectedEnumerationTerminal extends edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2AbstractExpectedElement {
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2EnumerationTerminal enumerationTerminal;
	
	public Xmu2ExpectedEnumerationTerminal(edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2EnumerationTerminal enumerationTerminal) {
		super(enumerationTerminal.getMetaclass());
		this.enumerationTerminal = enumerationTerminal;
	}
	
	public java.util.Set<String> getTokenNames() {
		// EnumerationTerminals are associated with multiple tokens, one for each literal
		// that was mapped to a string
		java.util.Set<String> tokenNames = new java.util.LinkedHashSet<String>();
		java.util.Map<String, String> mapping = enumerationTerminal.getLiteralMapping();
		for (String literalName : mapping.keySet()) {
			String text = mapping.get(literalName);
			if (text != null && !"".equals(text)) {
				tokenNames.add("'" + text + "'");
			}
		}
		return tokenNames;
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2EnumerationTerminal getEnumerationTerminal() {
		return this.enumerationTerminal;
	}
	
	/**
	 * Returns the expected enumeration terminal.
	 */
	public edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2SyntaxElement getSymtaxElement() {
		return enumerationTerminal;
	}
	
	public String toString() {
		return "EnumTerminal \"" + getEnumerationTerminal() + "\"";
	}
	
}
