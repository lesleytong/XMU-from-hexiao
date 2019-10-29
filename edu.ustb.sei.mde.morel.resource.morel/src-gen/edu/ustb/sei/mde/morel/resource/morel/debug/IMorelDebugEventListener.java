/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.debug;

public interface IMorelDebugEventListener {
	
	/**
	 * Notification that the given event occurred in the while debugging.
	 */
	public void handleMessage(edu.ustb.sei.mde.morel.resource.morel.debug.MorelDebugMessage message);
}
