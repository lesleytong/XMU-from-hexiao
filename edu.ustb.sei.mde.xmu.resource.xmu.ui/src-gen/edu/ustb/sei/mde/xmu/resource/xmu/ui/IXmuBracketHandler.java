/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.ui;

/**
 * The BracketHandler is responsible for handling the input of brackets. It
 * automatically adds closing brackets, if the opening counterpart is entered in
 * editors. It does also ignore the input of closing brackets, if these were
 * automatically inserted right before.
 */
public interface IXmuBracketHandler {
	
	/**
	 * If a closing bracket was added right before, this method returns true.
	 */
	public boolean addedClosingBracket();
	
	/**
	 * Returns the last closing bracket that was added automatically.
	 */
	public String getClosingBracket();
	
}
