/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.debug;

public class Xmu2DebugCommunicationHelper {
	
	public void sendEvent(edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugMessage message, java.io.PrintStream stream) {
		synchronized (stream) {
			stream.println(message.serialize());
		}
	}
	
	/**
	 * Sends a message using the given stream and waits for an answer.
	 * 
	 * @param messageType the type of message to send
	 * @param stream the stream to send the message to
	 * @param reader the reader to obtain the answer from
	 * @param parameters additional parameter to send
	 * 
	 * @return the answer that is received
	 */
	public edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugMessage sendAndReceive(edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugMessage message, java.io.PrintStream stream, java.io.BufferedReader reader) {
		synchronized (stream) {
			sendEvent(message, stream);
			edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugMessage response = receive(reader);
			return response;
		}
	}
	
	/**
	 * Receives a message from the given reader. This method block until a message has
	 * arrived.
	 * 
	 * @param reader the read to obtain the message from
	 * 
	 * @return the received message
	 */
	public edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugMessage receive(java.io.BufferedReader reader) {
		try {
			String response = reader.readLine();
			if (response == null) {
				return null;
			}
			edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugMessage receivedMessage = edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugMessage.deserialize(response);
			return receivedMessage;
		} catch (java.io.IOException e) {
			return null;
		}
	}
	
}
