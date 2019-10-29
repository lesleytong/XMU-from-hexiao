/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu;

/**
 * Implementors of this interface can provide a post-processor for text resources.
 */
public interface IXmuResourcePostProcessorProvider {
	
	/**
	 * Returns the processor that shall be called after text resource are successfully
	 * parsed.
	 */
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuResourcePostProcessor getResourcePostProcessor();
	
}
