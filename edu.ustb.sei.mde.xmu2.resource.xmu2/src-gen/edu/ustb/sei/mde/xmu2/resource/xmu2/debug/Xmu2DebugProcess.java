/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.debug;

public class Xmu2DebugProcess extends edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugElement implements org.eclipse.debug.core.model.IProcess, edu.ustb.sei.mde.xmu2.resource.xmu2.debug.IXmu2DebugEventListener {
	
	private org.eclipse.debug.core.ILaunch launch;
	
	private boolean terminated = false;
	
	public Xmu2DebugProcess(org.eclipse.debug.core.ILaunch launch) {
		super(launch.getDebugTarget());
		this.launch = launch;
	}
	
	public boolean canTerminate() {
		return !terminated;
	}
	
	public boolean isTerminated() {
		return terminated;
	}
	
	public void terminate() throws org.eclipse.debug.core.DebugException {
		terminated = true;
	}
	
	public String getLabel() {
		return null;
	}
	
	public org.eclipse.debug.core.ILaunch getLaunch() {
		return launch;
	}
	
	public org.eclipse.debug.core.model.IStreamsProxy getStreamsProxy() {
		return null;
	}
	
	public void setAttribute(String key, String value) {
	}
	
	public String getAttribute(String key) {
		return null;
	}
	
	public int getExitValue() throws org.eclipse.debug.core.DebugException {
		return 0;
	}
	
	public void handleMessage(edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugMessage message) {
		if (message.hasType(edu.ustb.sei.mde.xmu2.resource.xmu2.debug.EXmu2DebugMessageTypes.TERMINATED)) {
			terminated = true;
		} else {
			// ignore other events
		}
	}
	
}
