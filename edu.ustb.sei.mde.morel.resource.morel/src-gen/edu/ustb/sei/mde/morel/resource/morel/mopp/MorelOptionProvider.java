/**
 * <copyright>
 * </copyright>
 *
 * 
 */
/**
 * This class can be used to configure options that must be used when resources
 * are loaded. This is similar to using the extension point
 * 'edu.ustb.sei.mde.morel.resource.morel.default_load_options' with the
 * difference that the options defined in this class are used even if no Eclipse
 * platform is running.
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

public class MorelOptionProvider implements edu.ustb.sei.mde.morel.resource.morel.IMorelOptionProvider {
	
	public java.util.Map<?,?> getOptions() {
		// create a map with static option providers here
		return java.util.Collections.emptyMap();
	}
	
}
