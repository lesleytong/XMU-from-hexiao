/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class XmuExpectedStructuralFeature extends edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuAbstractExpectedElement {
	
	private edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuPlaceholder placeholder;
	
	public XmuExpectedStructuralFeature(edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuPlaceholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuSyntaxElement getSymtaxElement() {
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
		if (o instanceof XmuExpectedStructuralFeature) {
			return getFeature().equals(((XmuExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
