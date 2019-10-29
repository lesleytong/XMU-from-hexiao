/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

public class MorelParseResult implements edu.ustb.sei.mde.morel.resource.morel.IMorelParseResult {
	
	private org.eclipse.emf.ecore.EObject root;
	private java.util.Collection<edu.ustb.sei.mde.morel.resource.morel.IMorelCommand<edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource>> commands = new java.util.ArrayList<edu.ustb.sei.mde.morel.resource.morel.IMorelCommand<edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource>>();
	
	public MorelParseResult() {
		super();
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public java.util.Collection<edu.ustb.sei.mde.morel.resource.morel.IMorelCommand<edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource>> getPostParseCommands() {
		return commands;
	}
	
}
