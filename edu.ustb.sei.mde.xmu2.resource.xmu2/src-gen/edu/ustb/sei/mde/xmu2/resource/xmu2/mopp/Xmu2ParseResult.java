/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

public class Xmu2ParseResult implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Command<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource>> commands = new java.util.ArrayList<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Command<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource>>();
	
	public Xmu2ParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Command<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource>> getPostParseCommands() {
		return commands;
	}
	
}
