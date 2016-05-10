/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IXmu2ResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ResourcePostProcessor getResourcePostProcessor();
	
}
