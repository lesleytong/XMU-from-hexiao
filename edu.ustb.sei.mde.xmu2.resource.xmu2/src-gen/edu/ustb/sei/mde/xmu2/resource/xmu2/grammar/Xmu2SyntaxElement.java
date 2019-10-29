/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class Xmu2SyntaxElement {
	
	private Xmu2SyntaxElement[] children;
	private Xmu2SyntaxElement parent;
	private edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Cardinality cardinality;
	
	public Xmu2SyntaxElement(edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Cardinality cardinality, Xmu2SyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (Xmu2SyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(Xmu2SyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public Xmu2SyntaxElement getParent() {
		return parent;
	}
	
	public Xmu2SyntaxElement[] getChildren() {
		if (children == null) {
			return new Xmu2SyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2Cardinality getCardinality() {
		return cardinality;
	}
	
}
