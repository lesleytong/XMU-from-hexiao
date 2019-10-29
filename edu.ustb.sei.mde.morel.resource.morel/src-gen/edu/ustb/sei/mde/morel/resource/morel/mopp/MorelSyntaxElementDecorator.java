/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

public class MorelSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private edu.ustb.sei.mde.morel.resource.morel.grammar.MorelSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private MorelSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private java.util.List<Integer> indicesToPrint = new java.util.ArrayList<Integer>();
	
	public MorelSyntaxElementDecorator(edu.ustb.sei.mde.morel.resource.morel.grammar.MorelSyntaxElement decoratedElement, MorelSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.grammar.MorelSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public MorelSyntaxElementDecorator[] getChildDecorators() {
		return childDecorators;
	}
	
	public Integer getNextIndexToPrint() {
		if (indicesToPrint.size() == 0) {
			return null;
		}
		return indicesToPrint.remove(0);
	}
	
	public String toString() {
		return "" + getDecoratedElement();
	}
	
}
