/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

/**
 * A basic implementation of the ITokenResolveResult interface.
 */
public class Xmu2TokenResolveResult implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolveResult {
	
	private String errorMessage;
	private Object resolvedToken;
	
	public Xmu2TokenResolveResult() {
		super();
		clear();
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public Object getResolvedToken() {
		return resolvedToken;
	}
	
	public void setErrorMessage(String message) {
		errorMessage = message;
	}
	
	public void setResolvedToken(Object resolvedToken) {
		this.resolvedToken = resolvedToken;
	}
	
	public void clear() {
		errorMessage = "Can't resolve token.";
		resolvedToken = null;
	}
	
}
