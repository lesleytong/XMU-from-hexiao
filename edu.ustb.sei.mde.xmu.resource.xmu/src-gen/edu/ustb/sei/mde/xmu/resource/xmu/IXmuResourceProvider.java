/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu;

/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IXmuResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource getResource();
	
}
