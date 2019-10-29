/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IMorelParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<edu.ustb.sei.mde.morel.resource.morel.IMorelCommand<edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource>> getPostParseCommands();
	
}
