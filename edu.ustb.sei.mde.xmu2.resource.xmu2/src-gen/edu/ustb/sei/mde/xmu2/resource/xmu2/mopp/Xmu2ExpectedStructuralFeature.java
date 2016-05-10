/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

/**
 * A representation for a range in a document where a structural feature (e.g., a
 * reference) is expected.
 */
public class Xmu2ExpectedStructuralFeature extends edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2AbstractExpectedElement {
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Placeholder placeholder;
	
	public Xmu2ExpectedStructuralFeature(edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Placeholder placeholder) {
		super(placeholder.getMetaclass());
		this.placeholder = placeholder;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getFeature() {
		return placeholder.getFeature();
	}
	
	/**
	 * Returns the expected placeholder.
	 */
	public edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2SyntaxElement getSymtaxElement() {
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
		if (o instanceof Xmu2ExpectedStructuralFeature) {
			return getFeature().equals(((Xmu2ExpectedStructuralFeature) o).getFeature());
		}
		return false;
	}
	@Override	
	public int hashCode() {
		return getFeature().hashCode();
	}
	
}
