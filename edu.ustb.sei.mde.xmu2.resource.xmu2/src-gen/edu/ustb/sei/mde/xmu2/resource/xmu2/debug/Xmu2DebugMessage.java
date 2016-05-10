/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class Xmu2DebugMessage {
	
	private static final char DELIMITER = ':';
	private edu.ustb.sei.mde.xmu2.resource.xmu2.debug.EXmu2DebugMessageTypes messageType;
	private String[] arguments;
	
	public Xmu2DebugMessage(edu.ustb.sei.mde.xmu2.resource.xmu2.debug.EXmu2DebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public Xmu2DebugMessage(edu.ustb.sei.mde.xmu2.resource.xmu2.debug.EXmu2DebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.debug.EXmu2DebugMessageTypes getMessageType() {
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
		return edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2StringUtil.encode(DELIMITER, parts);
	}
	
	public static Xmu2DebugMessage deserialize(String response) {
		java.util.List<String> parts = edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2StringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		edu.ustb.sei.mde.xmu2.resource.xmu2.debug.EXmu2DebugMessageTypes type = edu.ustb.sei.mde.xmu2.resource.xmu2.debug.EXmu2DebugMessageTypes.valueOf(messageType);
		Xmu2DebugMessage message = new Xmu2DebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(edu.ustb.sei.mde.xmu2.resource.xmu2.debug.EXmu2DebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2StringUtil.explode(arguments, ", ") + "]";
	}
	
}
