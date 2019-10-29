/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.ui.launch;

/**
 * A class that provides the tabs for the launch configuration.
 */
public class Xmu2LaunchConfigurationTabGroup extends org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup {
	
	public void createTabs(org.eclipse.debug.ui.ILaunchConfigurationDialog dialog, String mode) {
		// Set the overrideLaunchConfigurationTabGroup option to false to implement this
		// method.
		setTabs(new org.eclipse.debug.ui.ILaunchConfigurationTab[] {new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.launch.Xmu2LaunchConfigurationMainTab()});
	}
	
}
