/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class Xmu2ExpectedCsString extends edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2AbstractExpectedElement {
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Keyword keyword;
	
	public Xmu2ExpectedCsString(edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Keyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2SyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof Xmu2ExpectedCsString) {
			return getValue().equals(((Xmu2ExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
