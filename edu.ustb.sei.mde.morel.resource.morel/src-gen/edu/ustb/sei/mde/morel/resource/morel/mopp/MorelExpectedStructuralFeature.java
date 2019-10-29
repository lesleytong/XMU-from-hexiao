/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class MorelExpectedStructuralFeature extends edu.ustb.sei.mde.morel.resource.morel.mopp.MorelAbstractExpectedElement {
	
	private edu.ustb.sei.mde.morel.resource.morel.grammar.MorelPlaceholder placeholder;
	
	public MorelExpectedStructuralFeature(edu.ustb.sei.mde.morel.resource.morel.grammar.MorelPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public edu.ustb.sei.mde.morel.resource.morel.grammar.MorelSyntaxElement getSymtaxElement() {
		return placeholder;
	}
	
	public String getTokenName() {
		return placeholder.getTokenName();
	}
	
	public java.util.Set<String> getTokenNames() {
		return java.util.Collections.singleton(getTokenName());
	}
	
	public String toString() {
		return "EFeature " + getFeature().getEContainingClass().getName() + "." + getFeature().getName();
	}
	
	public boolean equals(Object o) {
		if (o instanceof MorelExpectedStructuralFeature) {
			return getFeature().equals(((MorelExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
