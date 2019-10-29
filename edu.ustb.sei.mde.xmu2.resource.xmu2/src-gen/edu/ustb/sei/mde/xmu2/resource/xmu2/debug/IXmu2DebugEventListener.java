/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.debug;

public interface IXmu2DebugEventListener {
	
	/**
	 * Notification that the given event occurred in the while debugging.
	 */
	public void handleMessage(edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugMessage message);
}
