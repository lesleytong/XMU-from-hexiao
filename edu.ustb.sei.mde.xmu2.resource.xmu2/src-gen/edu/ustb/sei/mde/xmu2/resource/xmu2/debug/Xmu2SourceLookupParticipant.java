/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.debug;

public class Xmu2SourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2StackFrame) {
			edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2StackFrame frame = (edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2StackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
