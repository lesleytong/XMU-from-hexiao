/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

public class XmuSyntaxElementDecorator {
	
	/**
	 * the syntax element to be decorated
	 */
	private edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuSyntaxElement decoratedElement;
	
	/**
	 * an array of child decorators (one decorator per child of the decorated syntax
	 * element
	 */
	private XmuSyntaxElementDecorator[] childDecorators;
	
	/**
	 * a list of the indices that must be printed
	 */
	private java.util.List<Integer> indicesToPrint = new java.util.ArrayList<Integer>();
	
	public XmuSyntaxElementDecorator(edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuSyntaxElement decoratedElement, XmuSyntaxElementDecorator[] childDecorators) {
		super();
		this.decoratedElement = decoratedElement;
		this.childDecorators = childDecorators;
	}
	
	public void addIndexToPrint(Integer index) {
		indicesToPrint.add(index);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.grammar.XmuSyntaxElement getDecoratedElement() {
		return decoratedElement;
	}
	
	public XmuSyntaxElementDecorator[] getChildDecorators() {
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
