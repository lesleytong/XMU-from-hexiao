/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.ui;

public abstract class AbstractXmu2OutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2OutlinePageTreeViewer treeViewer;
	
	public AbstractXmu2OutlinePageAction(edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2OutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2ImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2UIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
		valueChanged(checked, false);
	}
	
	@Override	
	public void run() {
		if (keepState()) {
			valueChanged(isChecked(), true);
		} else {
			runBusy(true);
		}
	}
	
	public void runBusy(final boolean on) {
		org.eclipse.swt.custom.BusyIndicator.showWhile(org.eclipse.swt.widgets.Display.getCurrent(), new Runnable() {
			public void run() {
				runInternal(on);
			}
		});
	}
	
	public abstract void runInternal(boolean on);
	
	private void valueChanged(boolean on, boolean store) {
		setChecked(on);
		runBusy(on);
		if (store) {
			edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2UIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2OutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2OutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2OutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
