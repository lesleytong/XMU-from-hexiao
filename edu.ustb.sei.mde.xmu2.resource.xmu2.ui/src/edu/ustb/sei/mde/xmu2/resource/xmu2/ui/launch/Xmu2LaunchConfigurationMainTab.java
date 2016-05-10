/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.ui.launch;

import edu.ustb.sei.mde.xmu2.resource.xmu2.launch.Xmu2LaunchConfigurationDelegate;
import edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2UIPlugin;

/**
 * A class that provides the main tab to parameterize launch configurations.
 * Set the overrideLaunchConfigurationMainTab option to false to customize this
 * class.
 */
public class Xmu2LaunchConfigurationMainTab extends org.eclipse.debug.ui.AbstractLaunchConfigurationTab {
	
	private org.eclipse.swt.widgets.Label resourceUriLabel;
	private org.eclipse.swt.widgets.Text resourceUriText;
	private org.eclipse.swt.widgets.Button resourceWorkspaceButton;
	private org.eclipse.swt.widgets.Button resourceFileSystemButton;
	
	private org.eclipse.swt.widgets.Label sourceUriLabel;
	private org.eclipse.swt.widgets.Text sourceUriText;
	private org.eclipse.swt.widgets.Button sourceWorkspaceButton;
	private org.eclipse.swt.widgets.Button sourceFileSystemButton;
	
	private org.eclipse.swt.widgets.Label viewUriLabel;
	private org.eclipse.swt.widgets.Text viewUriText;
	private org.eclipse.swt.widgets.Button viewWorkspaceButton;
	private org.eclipse.swt.widgets.Button viewFileSystemButton;
	
	private org.eclipse.swt.widgets.Button modeButton;
	private boolean mode = true;
	
	public void createControl(org.eclipse.swt.widgets.Composite parent) {
		org.eclipse.swt.widgets.Composite comp = new org.eclipse.swt.widgets.Composite(parent, org.eclipse.swt.SWT.NONE);
		org.eclipse.swt.layout.GridLayout layout = new org.eclipse.swt.layout.GridLayout(1, true);
		comp.setLayout(layout);
		
		org.eclipse.swt.layout.GridData gd = new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL_BOTH);
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = org.eclipse.swt.SWT.FILL;
		comp.setLayoutData(gd);
		
		org.eclipse.swt.widgets.Group group = new org.eclipse.swt.widgets.Group(comp, org.eclipse.swt.SWT.NONE);
		group.setText("Launch parameters");
		group.setLayout(new org.eclipse.swt.layout.GridLayout(3, false));
		gd = new org.eclipse.swt.layout.GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = org.eclipse.swt.SWT.FILL;
		group.setLayoutData(gd);
		
		{// resource
			resourceUriLabel = new org.eclipse.swt.widgets.Label(group, org.eclipse.swt.SWT.NONE);
			resourceUriLabel.setText("Resource to execute:");
			gd = new org.eclipse.swt.layout.GridData();
			resourceUriLabel.setLayoutData(gd);
			
			resourceUriText = new org.eclipse.swt.widgets.Text(group, org.eclipse.swt.SWT.SINGLE | org.eclipse.swt.SWT.BORDER);
			resourceUriText.setLayoutData(new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL_HORIZONTAL));
			resourceUriText.addModifyListener(new org.eclipse.swt.events.ModifyListener() {
				public void modifyText(org.eclipse.swt.events.ModifyEvent evt) {
					updateLaunchConfigurationDialog();
				}
			});
			gd = new org.eclipse.swt.layout.GridData();
			gd.grabExcessHorizontalSpace = true;
			gd.horizontalAlignment = org.eclipse.swt.SWT.FILL;
			gd.horizontalSpan = 2;
			resourceUriText.setLayoutData(gd);
			
			resourceWorkspaceButton = new org.eclipse.swt.widgets.Button(group, org.eclipse.swt.SWT.PUSH);
			resourceWorkspaceButton.setText("Workspace...");
			resourceWorkspaceButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
				public void widgetSelected(org.eclipse.swt.events.SelectionEvent event) {
					handleBrowseWorkspace(resourceUriText);
				}
				
			});
			gd = new org.eclipse.swt.layout.GridData();
			gd.grabExcessHorizontalSpace = true;
			gd.horizontalAlignment = org.eclipse.swt.SWT.RIGHT;
			gd.horizontalSpan = 2;
			resourceWorkspaceButton.setLayoutData(gd);
			
			resourceFileSystemButton = new org.eclipse.swt.widgets.Button(group, org.eclipse.swt.SWT.PUSH);
			resourceFileSystemButton.setText("File System...");
			resourceFileSystemButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
				public void widgetSelected(org.eclipse.swt.events.SelectionEvent event) {
					handleBrowseFileSystem(resourceUriText);
				}
				
			});
			gd = new org.eclipse.swt.layout.GridData();
			gd.horizontalAlignment = org.eclipse.swt.SWT.RIGHT;
			resourceFileSystemButton.setLayoutData(gd);
		}
		
		{// source
			sourceUriLabel = new org.eclipse.swt.widgets.Label(group, org.eclipse.swt.SWT.NONE);
			sourceUriLabel.setText("Source:");
			gd = new org.eclipse.swt.layout.GridData();
			sourceUriLabel.setLayoutData(gd);
			
			sourceUriText = new org.eclipse.swt.widgets.Text(group, org.eclipse.swt.SWT.SINGLE | org.eclipse.swt.SWT.BORDER);
			sourceUriText.setLayoutData(new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL_HORIZONTAL));
			sourceUriText.addModifyListener(new org.eclipse.swt.events.ModifyListener() {
				public void modifyText(org.eclipse.swt.events.ModifyEvent evt) {
					updateLaunchConfigurationDialog();
				}
			});
			gd = new org.eclipse.swt.layout.GridData();
			gd.grabExcessHorizontalSpace = true;
			gd.horizontalAlignment = org.eclipse.swt.SWT.FILL;
			gd.horizontalSpan = 2;
			sourceUriText.setLayoutData(gd);
			
			sourceWorkspaceButton = new org.eclipse.swt.widgets.Button(group, org.eclipse.swt.SWT.PUSH);
			sourceWorkspaceButton.setText("Workspace...");
			sourceWorkspaceButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
				public void widgetSelected(org.eclipse.swt.events.SelectionEvent event) {
					handleBrowseWorkspace(sourceUriText);
				}
				
			});
			gd = new org.eclipse.swt.layout.GridData();
			gd.grabExcessHorizontalSpace = true;
			gd.horizontalAlignment = org.eclipse.swt.SWT.RIGHT;
			gd.horizontalSpan = 2;
			sourceWorkspaceButton.setLayoutData(gd);
			
			sourceFileSystemButton = new org.eclipse.swt.widgets.Button(group, org.eclipse.swt.SWT.PUSH);
			sourceFileSystemButton.setText("File System...");
			sourceFileSystemButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
				public void widgetSelected(org.eclipse.swt.events.SelectionEvent event) {
					handleBrowseFileSystem(sourceUriText);
				}
				
			});
			gd = new org.eclipse.swt.layout.GridData();
			gd.horizontalAlignment = org.eclipse.swt.SWT.RIGHT;
			sourceFileSystemButton.setLayoutData(gd);
		}
		
		{// view
			viewUriLabel = new org.eclipse.swt.widgets.Label(group, org.eclipse.swt.SWT.NONE);
			viewUriLabel.setText("View:");
			gd = new org.eclipse.swt.layout.GridData();
			viewUriLabel.setLayoutData(gd);
			
			viewUriText = new org.eclipse.swt.widgets.Text(group, org.eclipse.swt.SWT.SINGLE | org.eclipse.swt.SWT.BORDER);
			viewUriText.setLayoutData(new org.eclipse.swt.layout.GridData(org.eclipse.swt.layout.GridData.FILL_HORIZONTAL));
			viewUriText.addModifyListener(new org.eclipse.swt.events.ModifyListener() {
				public void modifyText(org.eclipse.swt.events.ModifyEvent evt) {
					updateLaunchConfigurationDialog();
				}
			});
			gd = new org.eclipse.swt.layout.GridData();
			gd.grabExcessHorizontalSpace = true;
			gd.horizontalAlignment = org.eclipse.swt.SWT.FILL;
			gd.horizontalSpan = 2;
			viewUriText.setLayoutData(gd);
			
			viewWorkspaceButton = new org.eclipse.swt.widgets.Button(group, org.eclipse.swt.SWT.PUSH);
			viewWorkspaceButton.setText("Workspace...");
			viewWorkspaceButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
				public void widgetSelected(org.eclipse.swt.events.SelectionEvent event) {
					handleBrowseWorkspace(viewUriText);
				}
				
			});
			gd = new org.eclipse.swt.layout.GridData();
			gd.grabExcessHorizontalSpace = true;
			gd.horizontalAlignment = org.eclipse.swt.SWT.RIGHT;
			gd.horizontalSpan = 2;
			viewWorkspaceButton.setLayoutData(gd);
			
			viewFileSystemButton = new org.eclipse.swt.widgets.Button(group, org.eclipse.swt.SWT.PUSH);
			viewFileSystemButton.setText("File System...");
			viewFileSystemButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
				public void widgetSelected(org.eclipse.swt.events.SelectionEvent event) {
					handleBrowseFileSystem(viewUriText);
				}
				
			});
			gd = new org.eclipse.swt.layout.GridData();
			gd.horizontalAlignment = org.eclipse.swt.SWT.RIGHT;
			viewFileSystemButton.setLayoutData(gd);
		}
		
		{
			modeButton = new org.eclipse.swt.widgets.Button(group, org.eclipse.swt.SWT.PUSH);
			modeButton.setText(Xmu2LaunchConfigurationDelegate.MODE[0]);
			modeButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
				public void widgetSelected(org.eclipse.swt.events.SelectionEvent event) {
					mode = !mode;
					if(mode) {
						modeButton.setText(Xmu2LaunchConfigurationDelegate.MODE[0]);
					} else {
						modeButton.setText(Xmu2LaunchConfigurationDelegate.MODE[1]);
					}
					updateLaunchConfigurationDialog();
				}
			});
			gd = new org.eclipse.swt.layout.GridData();
			gd.grabExcessHorizontalSpace = true;
			gd.horizontalAlignment = org.eclipse.swt.SWT.LEFT;
			gd.horizontalSpan = 2;
			modeButton.setLayoutData(gd);
		}
		
		setControl(comp);
	}
	
	public void setDefaults(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy configuration) {
	}
	
	public void initializeFrom(org.eclipse.debug.core.ILaunchConfiguration configuration) {
		try {
			resourceUriText.setText(configuration.getAttribute(Xmu2LaunchConfigurationDelegate.ATTR_RESOURCE_URI, ""));
			sourceUriText.setText(configuration.getAttribute(Xmu2LaunchConfigurationDelegate.ATTR_SOURCE_URI, ""));
			viewUriText.setText(configuration.getAttribute(Xmu2LaunchConfigurationDelegate.ATTR_VIEW_URI, ""));
			mode = configuration.getAttribute(Xmu2LaunchConfigurationDelegate.ATTR_MODE, Xmu2LaunchConfigurationDelegate.MODE[0]).equals(Xmu2LaunchConfigurationDelegate.MODE[0]);
			if(mode) modeButton.setText(Xmu2LaunchConfigurationDelegate.MODE[0]);
			else modeButton.setText(Xmu2LaunchConfigurationDelegate.MODE[1]);
		} catch (org.eclipse.core.runtime.CoreException e) {
			edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Plugin.logError("Can't initialize launch configuration tab.", e);
		}
	}
	
	public void performApply(org.eclipse.debug.core.ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(Xmu2LaunchConfigurationDelegate.ATTR_RESOURCE_URI, resourceUriText.getText());
		configuration.setAttribute(Xmu2LaunchConfigurationDelegate.ATTR_SOURCE_URI, sourceUriText.getText());
		configuration.setAttribute(Xmu2LaunchConfigurationDelegate.ATTR_VIEW_URI, viewUriText.getText());
		configuration.setAttribute(Xmu2LaunchConfigurationDelegate.ATTR_MODE, mode? Xmu2LaunchConfigurationDelegate.MODE[0]:Xmu2LaunchConfigurationDelegate.MODE[1]);
	}
	
	public String getName() {
		return "XMU2";
	}
	
	@Override	
	public org.eclipse.swt.graphics.Image getImage() {
		return edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2ImageProvider.INSTANCE.getImage("icons/launch_tab_main_icon.gif");
	}
	
	protected void handleBrowseFileSystem(org.eclipse.swt.widgets.Text text) {
		org.eclipse.swt.widgets.FileDialog dialog = new org.eclipse.swt.widgets.FileDialog(getControl().getShell());
		dialog.setText("Select file");
		String result = dialog.open();
		if (result != null) {
			text.setText(org.eclipse.emf.common.util.URI.createFileURI(result).toString());
		}
	}
	
	protected void handleBrowseWorkspace(org.eclipse.swt.widgets.Text text) {
		org.eclipse.ui.dialogs.ElementTreeSelectionDialog dialog = new org.eclipse.ui.dialogs.ElementTreeSelectionDialog(getControl().getShell(), new org.eclipse.ui.model.WorkbenchLabelProvider(), new org.eclipse.ui.model.WorkbenchContentProvider());
		
		dialog.setInput(org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot());

		dialog.setAllowMultiple(false);
		dialog.setTitle("Select resource");
		dialog.setMessage("Resource");
		dialog.setValidator(new org.eclipse.ui.dialogs.ISelectionStatusValidator() {
			public org.eclipse.core.runtime.IStatus validate(Object[] selection) {
				if (selection.length > 0 && selection[0] instanceof org.eclipse.core.resources.IFile)				
					return new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.OK, Xmu2UIPlugin.PLUGIN_ID, org.eclipse.core.runtime.IStatus.OK, "", null);
				
				return new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, Xmu2UIPlugin.PLUGIN_ID, org.eclipse.core.runtime.IStatus.ERROR, "", null);
			}
		});
		if (dialog.open() == org.eclipse.jface.window.Window.OK) {
			org.eclipse.core.resources.IFile file = (org.eclipse.core.resources.IFile) dialog.getFirstResult();
			text.setText(org.eclipse.emf.common.util.URI.createPlatformResourceURI(file.getFullPath().makeRelative().toString(), true).toString());
		}
	}
	
}
