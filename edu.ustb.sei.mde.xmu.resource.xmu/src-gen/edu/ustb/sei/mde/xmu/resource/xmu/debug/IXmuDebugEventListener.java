/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.debug;

public interface IXmuDebugEventListener {
	
	/**
	 * Notification that the given event occurred in the while debugging.
	 */
	public void handleMessage(edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugMessage message);
}
