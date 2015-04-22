/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class XmuExpectedCsString extends edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuAbstractExpectedElement {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuKeyword keyword;
	
	public XmuExpectedCsString(edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof XmuExpectedCsString) {
			return getValue().equals(((XmuExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
