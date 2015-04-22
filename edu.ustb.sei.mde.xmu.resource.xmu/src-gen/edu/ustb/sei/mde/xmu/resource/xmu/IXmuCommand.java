/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu;

/**
 * A simple interface for commands that can be executed and that return
 * information about the success of their execution.
 */
public interface IXmuCommand<ContextType> {
	
	public boolean execute(ContextType context);
}
