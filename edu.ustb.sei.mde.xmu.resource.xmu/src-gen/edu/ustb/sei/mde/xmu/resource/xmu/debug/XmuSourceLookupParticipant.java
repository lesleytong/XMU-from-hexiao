/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.debug;

public class XmuSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuStackFrame) {
			edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuStackFrame frame = (edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
