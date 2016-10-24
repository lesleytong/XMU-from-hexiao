/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmuxtext.ui.launch;

/**
 * A class that converts the current selection or active editor to a launch
 * configuration.
 * Set the overrideLaunchShortcut option to false to customize this class.
 */
public class Xmu2LaunchShortcut implements org.eclipse.debug.ui.ILaunchShortcut2 {
	
	public void launch(org.eclipse.jface.viewers.ISelection selection, String mode) {
		if (selection instanceof org.eclipse.jface.viewers.IStructuredSelection) {
			org.eclipse.jface.viewers.IStructuredSelection structuredSelection = (org.eclipse.jface.viewers.IStructuredSelection) selection;
			java.util.Iterator<?> it = structuredSelection.iterator();
			while (it.hasNext()) {
				Object object = it.next();
				if (object instanceof org.eclipse.core.resources.IFile) {
					org.eclipse.core.resources.IFile file = (org.eclipse.core.resources.IFile) object;
					launch(file, mode);
				}
			}
		}
	}
	
	public void launch(org.eclipse.ui.IEditorPart editorPart, String mode) {
		org.eclipse.ui.IEditorInput editorInput = editorPart.getEditorInput();
		if (editorInput instanceof org.eclipse.ui.IFileEditorInput) {
			org.eclipse.ui.IFileEditorInput fileInput = (org.eclipse.ui.IFileEditorInput) editorInput;
			launch(fileInput.getFile(), mode);
		}
	}
	
	private void launch(org.eclipse.core.resources.IFile file, String mode) {
		try {
			org.eclipse.debug.core.ILaunchManager lm = org.eclipse.debug.core.DebugPlugin.getDefault().getLaunchManager();
			org.eclipse.debug.core.ILaunchConfigurationType type = lm.getLaunchConfigurationType(Xmu2LaunchConfigurationDelegate.LAUNCH_CONFIGURATION_TYPE);
			org.eclipse.debug.core.ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null, file.getName());
			org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			workingCopy.setAttribute(Xmu2LaunchConfigurationDelegate.ATTR_RESOURCE_URI, uri.toString());
			org.eclipse.debug.core.ILaunchConfiguration configuration = workingCopy.doSave();
			org.eclipse.debug.ui.DebugUITools.launch(configuration, mode);
		} catch (org.eclipse.core.runtime.CoreException e) {
			//edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Plugin.logError("Exception while launching selection", e);
		}
	}
	
	public org.eclipse.debug.core.ILaunchConfiguration[] getLaunchConfigurations(org.eclipse.jface.viewers.ISelection selection) {
		return null;
	}
	
	public org.eclipse.debug.core.ILaunchConfiguration[] getLaunchConfigurations(org.eclipse.ui.IEditorPart editorPart) {
		return null;
	}
	
	public org.eclipse.core.resources.IResource getLaunchableResource(org.eclipse.jface.viewers.ISelection selection) {
		return null;
	}
	
	public org.eclipse.core.resources.IResource getLaunchableResource(org.eclipse.ui.IEditorPart editorPart) {
		return null;
	}
	
}
