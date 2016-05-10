/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

public class Xmu2SyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2SyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private Xmu2SyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private java.util.List<Integer> indicesToPrint = new java.util.ArrayList<Integer>();
	
	public Xmu2SyntaxElementDecorator(edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2SyntaxElement decoratedElement, Xmu2SyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2SyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public Xmu2SyntaxElementDecorator[] getChildDecorators() {
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
