/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class MorelSyntaxElement {
	
	private MorelSyntaxElement[] children;
	private MorelSyntaxElement parent;
	private edu.ustb.sei.mde.morel.resource.morel.grammar.MorelCardinality cardinality;
	
	public MorelSyntaxElement(edu.ustb.sei.mde.morel.resource.morel.grammar.MorelCardinality cardinality, MorelSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (MorelSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(MorelSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public MorelSyntaxElement getParent() {
		return parent;
	}
	
	public MorelSyntaxElement[] getChildren() {
		if (children == null) {
			return new MorelSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.grammar.MorelCardinality getCardinality() {
		return cardinality;
	}
	
}
