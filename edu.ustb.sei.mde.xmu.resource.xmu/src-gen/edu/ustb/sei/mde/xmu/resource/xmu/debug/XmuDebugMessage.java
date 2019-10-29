/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class XmuDebugMessage {
	
	private static final char DELIMITER = ':';
	private edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes messageType;
	private String[] arguments;
	
	public XmuDebugMessage(edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public XmuDebugMessage(edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes getMessageType() {
		return messageType;
	}
	
	public String[] getArguments() {
		return arguments;
	}
	
	public String serialize() {
		java.util.List<String> parts = new java.util.ArrayList<String>();
		parts.add(messageType.name());
		for (String argument : arguments) {
			parts.add(argument);
		}
		return edu.ustb.sei.mde.xmu.resource.xmu.util.XmuStringUtil.encode(DELIMITER, parts);
	}
	
	public static XmuDebugMessage deserialize(String response) {
		java.util.List<String> parts = edu.ustb.sei.mde.xmu.resource.xmu.util.XmuStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes type = edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes.valueOf(messageType);
		XmuDebugMessage message = new XmuDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(edu.ustb.sei.mde.xmu.resource.xmu.debug.EXmuDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + edu.ustb.sei.mde.xmu.resource.xmu.util.XmuStringUtil.explode(arguments, ", ") + "]";
	}
	
}
