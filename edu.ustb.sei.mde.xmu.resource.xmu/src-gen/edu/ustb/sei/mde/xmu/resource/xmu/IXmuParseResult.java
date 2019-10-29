/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IXmuParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<edu.ustb.sei.mde.xmu.resource.xmu.IXmuCommand<edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource>> getPostParseCommands();
	
}
