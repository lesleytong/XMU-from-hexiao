/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

public class Xmu2DynamicTokenStyler {
	
	/**
	 * This method is called to dynamically style tokens.
	 * 
	 * @param resource the TextResource that contains the token
	 * @param token the token to obtain a style for
	 * @param staticStyle the token style as set in the editor preferences (is
	 * <code>null</code> if syntax highlighting for the token is disabled)
	 */
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenStyle getDynamicTokenStyle(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource resource, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextToken token, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenStyle staticStyle) {
		// The default implementation returns the static style without any changes. To
		// implement dynamic token styling, set the overrideDynamicTokenStyler option to
		// <code>false</code> and customize this method.
		return staticStyle;
	}
	
}
