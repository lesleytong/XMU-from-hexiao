/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel;

/**
 * Implementors of this interface provide an EMF resource.
 */
public interface IMorelResourceProvider {
	
	/**
	 * Returns the resource.
	 */
	public edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource getResource();
	
}
