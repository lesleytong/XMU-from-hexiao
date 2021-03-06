/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmuxtext.ui.launch;

/**
 * A class that handles launch configurations.
 */
public class Xmu2LaunchConfigurationDelegate extends org.eclipse.debug.core.model.LaunchConfigurationDelegate {
	
	/**
	 * The URI of the resource that shall be launched.
	 */
	public final static String ATTR_RESOURCE_URI = "resource_uri";
	public final static String ATTR_SOURCE_URI = "source_uri";
	public final static String ATTR_VIEW_URI = "view_uri";
	public final static String ATTR_MODE = "mode";
	public static final String[] MODE = new String[]{"Forward", "Backward"};
	public final static String ATTR_ENVTYPE = "env_type";
	public static final String[] ENVTYPE = new String[]{"normal","command-based"};
	
	public static final String LAUNCH_CONFIGURATION_TYPE = "edu.ustb.sei.mde.xmu2.resource.xmu2.ui.launchConfigurationType";
	
	
	public void launch(org.eclipse.debug.core.ILaunchConfiguration configuration, String mode, org.eclipse.debug.core.ILaunch launch, org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		// Set the overrideLaunchConfigurationDelegate option to <code>false</code> to
		// implement this method or disable launching support by setting
		// disableLaunchSupport to <code>true</code>.
		
		new Xmu2Launcher().launch(configuration, mode, launch, monitor);
	}
	
}
