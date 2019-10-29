/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IXmu2Command<ContextType> {
	
	public boolean execute(ContextType context);
}
