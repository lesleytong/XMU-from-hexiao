/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IMorelResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public edu.ustb.sei.mde.morel.resource.morel.IMorelResourcePostProcessor getResourcePostProcessor();
	
}
