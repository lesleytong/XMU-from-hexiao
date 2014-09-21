/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.debug;

public class MorelSourceLookupParticipant extends org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant {
	
	public String getSourceName(Object object) throws org.eclipse.core.runtime.CoreException {
		if (object instanceof edu.ustb.sei.mde.morel.resource.morel.debug.MorelStackFrame) {
			edu.ustb.sei.mde.morel.resource.morel.debug.MorelStackFrame frame = (edu.ustb.sei.mde.morel.resource.morel.debug.MorelStackFrame) object;
			return frame.getResourceURI();
		}
		return null;
	}
	
}
