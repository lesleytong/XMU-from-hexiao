/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class MorelDebugMessage {
	
	private static final char DELIMITER = ':';
	private edu.ustb.sei.mde.morel.resource.morel.debug.EMorelDebugMessageTypes messageType;
	private String[] arguments;
	
	public MorelDebugMessage(edu.ustb.sei.mde.morel.resource.morel.debug.EMorelDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public MorelDebugMessage(edu.ustb.sei.mde.morel.resource.morel.debug.EMorelDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.debug.EMorelDebugMessageTypes getMessageType() {
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
		return edu.ustb.sei.mde.morel.resource.morel.util.MorelStringUtil.encode(DELIMITER, parts);
	}
	
	public static MorelDebugMessage deserialize(String response) {
		java.util.List<String> parts = edu.ustb.sei.mde.morel.resource.morel.util.MorelStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		edu.ustb.sei.mde.morel.resource.morel.debug.EMorelDebugMessageTypes type = edu.ustb.sei.mde.morel.resource.morel.debug.EMorelDebugMessageTypes.valueOf(messageType);
		MorelDebugMessage message = new MorelDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(edu.ustb.sei.mde.morel.resource.morel.debug.EMorelDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + edu.ustb.sei.mde.morel.resource.morel.util.MorelStringUtil.explode(arguments, ", ") + "]";
	}
	
}
