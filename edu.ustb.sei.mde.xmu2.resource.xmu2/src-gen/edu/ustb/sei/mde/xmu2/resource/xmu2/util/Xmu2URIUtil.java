/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.util;

public class Xmu2URIUtil {
	
	public boolean isInBinFolder(org.eclipse.emf.common.util.URI uri) {
		String[] segments = uri.segments();
		for (String segment : segments) {
			if ("bin".equals(segment)) {
				return true;
			}
		}
		return false;
	}
	
}
