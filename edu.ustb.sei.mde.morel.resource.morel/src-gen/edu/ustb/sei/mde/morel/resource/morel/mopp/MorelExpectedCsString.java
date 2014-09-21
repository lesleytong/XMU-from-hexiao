/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

/**
 * A representation for a range in a document where a keyword (i.e., a static
 * string) is expected.
 */
public class MorelExpectedCsString extends edu.ustb.sei.mde.morel.resource.morel.mopp.MorelAbstractExpectedElement {
	
	private edu.ustb.sei.mde.morel.resource.morel.grammar.MorelKeyword keyword;
	
	public MorelExpectedCsString(edu.ustb.sei.mde.morel.resource.morel.grammar.MorelKeyword keyword) {
		super(keyword.getMetaclass());
		this.keyword = keyword;
	}
	
	public String getValue() {
		return keyword.getValue();
	}
	
	/**
	 * Returns the expected keyword.
	 */
	public edu.ustb.sei.mde.morel.resource.morel.grammar.MorelSyntaxElement getSymtaxElement() {
		return keyword;
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton("'" + getValue() + "'");
	}
	
	public String toString() {
		return "CsString \"" + getValue() + "\"";
	}
	
	public boolean equals(Object o) {
		if (o instanceof MorelExpectedCsString) {
			return getValue().equals(((MorelExpectedCsString) o).getValue());
		}
		return false;
	}
	
	@Override	
	public int hashCode() {
		return getValue().hashCode();
	}
	
}
