/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

/**
 * An Excpetion to represent invalid content types for parser instances.
 * 
 * @see edu.ustb.sei.mde.xmu.resource.xmu.IXmuOptions.RESOURCE_CONTENT_TYPE
 */
public class XmuUnexpectedContentTypeException extends org.antlr.runtime3_4_0.RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  XmuUnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
