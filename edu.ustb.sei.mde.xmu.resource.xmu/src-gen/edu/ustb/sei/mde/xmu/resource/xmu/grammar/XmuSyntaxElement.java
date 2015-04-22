/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class XmuSyntaxElement {
	
	private XmuSyntaxElement[] children;
	private XmuSyntaxElement parent;
	private edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuCardinality cardinality;
	
	public XmuSyntaxElement(edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuCardinality cardinality, XmuSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (XmuSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(XmuSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public XmuSyntaxElement getParent() {
		return parent;
	}
	
	public XmuSyntaxElement[] getChildren() {
		if (children == null) {
			return new XmuSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuCardinality getCardinality() {
		return cardinality;
	}
	
}
