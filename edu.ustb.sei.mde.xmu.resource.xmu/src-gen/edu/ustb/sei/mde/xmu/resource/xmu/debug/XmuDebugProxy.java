/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.debug;

/**
 * The DebugProxy allows to communicate between the interpreter, which runs in a
 * separate thread or process and the Eclipse Debug framework (i.e., the
 * DebugTarget class).
 */
public class XmuDebugProxy {
	
	public static final int STARTUP_DELAY = 1000;
	
	private java.io.PrintStream output;
	
	private java.io.BufferedReader reader;
	
	private edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugTarget debugTarget;
	
	private edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugCommunicationHelper communicationHelper = new edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugCommunicationHelper();
	
	public XmuDebugProxy(edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugTarget debugTarget, int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		this.debugTarget = debugTarget;
		// give interpreter a chance to start
		try {
			Thread.sleep(STARTUP_DELAY);
		} catch (InterruptedException e) {
		}
		startSocket(requestPort);
	}
	
	private void startSocket(int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		// creating client proxy socket (trying to connect)...
		java.net.Socket client = new java.net.Socket("localhost", requestPort);
		// creating client proxy socket - done. (connected)
		try {
			java.io.BufferedInputStream input = new java.io.BufferedInputStream(client.getInputStream());
			reader = new java.io.BufferedReader(new java.io.InputStreamReader(input));
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
		try {
			output = new java.io.PrintStream(client.getOutputStream());
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
	}
	
	public void resume() {
		sendCommand(edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes.RESUME);
	}
	
	public void stepOver() {
		sendCommand(edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes.STEP_OVER);
	}
	
	public void stepInto() {
		sendCommand(edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes.STEP_INTO);
	}
	
	public void stepReturn() {
		sendCommand(edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes.STEP_RETURN);
	}
	
	public void terminate() {
		sendCommand(edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes.EXIT);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugMessage getStack() {
		return sendCommandAndRead(edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes.GET_STACK);
	}
	
	public void addLineBreakpoint(String location, int line) {
		edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugMessage message = new edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugMessage(edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes.ADD_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public void removeLineBreakpoint(String location, int line) {
		edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugMessage message = new edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugMessage(edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes.REMOVE_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public org.eclipse.debug.core.model.IVariable[] getStackVariables(String stackFrame) {
		edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugMessage response = sendCommandAndRead(edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes.GET_FRAME_VARIABLES, new String[] {stackFrame});
		String[] ids = response.getArguments();
		// fetch all variables
		org.eclipse.debug.core.model.IVariable[] variables = getVariables(ids);
		return variables;
	}
	
	public org.eclipse.debug.core.model.IVariable[] getVariables(String... requestedIDs) {
		edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugMessage response = sendCommandAndRead(edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes.GET_VARIABLES, requestedIDs);
		String[] varStrings = response.getArguments();
		edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugVariable[] variables  = new edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugVariable[varStrings.length];
		int i = 0;
		for (String varString : varStrings) {
			java.util.Map<String, String> properties = edu.ustb.sei.mde.xmu.resource.xmu.util.XmuStringUtil.convertFromString(varString);
			
			// convert varString to variables and values
			String valueString = properties.get("!valueString");
			String valueRefType = "valueRefType";
			java.util.Map<String, Long> childVariables = new java.util.TreeMap<String, Long>(new java.util.Comparator<String>() {
				public int compare(String s1, String s2) {
					return s1.compareToIgnoreCase(s2);
				}
			});
			for (String property : properties.keySet()) {
				// ignore special properties - they are not children
				if (property.startsWith("!")) {
					continue;
				}
				childVariables.put(property, Long.parseLong(properties.get(property)));
			}
			String id = properties.get("!id");
			org.eclipse.debug.core.model.IValue value = new edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugValue(debugTarget, id, valueString, valueRefType, childVariables);
			
			String variableName = properties.get("!name");
			String variableRefType = properties.get("!type");
			
			edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugVariable variable = new edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugVariable(debugTarget, variableName, value, variableRefType);
			variables[i++] = variable;
		}
		return variables;
	}
	
	private void sendCommand(edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes command, String... parameters) {
		edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugMessage message = new edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugMessage(command, parameters);
		communicationHelper.sendEvent(message, output);
	}
	
	private edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugMessage sendCommandAndRead(edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes command, String... parameters) {
		edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugMessage message = new edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugMessage(command, parameters);
		return communicationHelper.sendAndReceive(message, output, reader);
	}
	
}
