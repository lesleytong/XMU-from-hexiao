/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2;

/**
 * An interface used to access the result of parsing a document.
 */
public interface IXmu2ParseResult {
	
	/**
	 * Returns the root object of the document.
	 */
	public org.eclipse.emf.ecore.EObject getRoot();
	
	/**
	 * Returns a list of commands that must be executed after parsing the document.
	 */
	public java.util.Collection<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Command<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource>> getPostParseCommands();
	
}
