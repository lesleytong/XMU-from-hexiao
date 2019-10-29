/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

public class XmuParseResult implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<edu.ustb.sei.mde.xmu.resource.xmu.IXmuCommand<edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource>> commands = new java.util.ArrayList<edu.ustb.sei.mde.xmu.resource.xmu.IXmuCommand<edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource>>();
	
	public XmuParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<edu.ustb.sei.mde.xmu.resource.xmu.IXmuCommand<edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
