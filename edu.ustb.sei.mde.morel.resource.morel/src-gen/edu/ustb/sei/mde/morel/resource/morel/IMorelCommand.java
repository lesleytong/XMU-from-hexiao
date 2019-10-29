/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IMorelCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
