/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

/**
 * An Excpetion to represent invalid content types for parser instances.
 * 
 * @see edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Options.RESOURCE_CONTENT_TYPE
 */
public class Xmu2UnexpectedContentTypeException extends org.antlr.runtime3_4_0.RecognitionException {
	
	private static final long serialVersionUID = 4791359811519433999L;
	
	private Object contentType = null;
	
	public  Xmu2UnexpectedContentTypeException(Object contentType) {
		this.contentType = contentType;
	}
	
	public Object getContentType() {
		return contentType;
	}
	
}
