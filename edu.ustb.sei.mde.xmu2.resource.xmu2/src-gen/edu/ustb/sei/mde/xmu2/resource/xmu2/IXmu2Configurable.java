/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2;

/**
 * Implementors of this interface can be configured by a map of options (or
 * parameters).
 */
public interface IXmu2Configurable {
	
	/**
	 * Passes the options given by the map to the configurable object.
	 */
	public void setOptions(java.util.Map<?,?> options);
}
