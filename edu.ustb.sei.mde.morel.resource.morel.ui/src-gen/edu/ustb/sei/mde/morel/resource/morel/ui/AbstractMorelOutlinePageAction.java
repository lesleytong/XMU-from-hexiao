/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.ui;

public abstract class AbstractMorelOutlinePageAction extends org.eclipse.jface.action.Action {
	
	private String preferenceKey = this.getClass().getSimpleName() + ".isChecked";
	
	private edu.ustb.sei.mde.morel.resource.morel.ui.MorelOutlinePageTreeViewer treeViewer;
	
	public AbstractMorelOutlinePageAction(edu.ustb.sei.mde.morel.resource.morel.ui.MorelOutlinePageTreeViewer treeViewer, String text, int style) {
		super(text, style);
		this.treeViewer = treeViewer;
	}
	
	public void initialize(String imagePath) {
		org.eclipse.jface.resource.ImageDescriptor descriptor = edu.ustb.sei.mde.morel.resource.morel.ui.MorelImageProvider.INSTANCE.getImageDescriptor(imagePath);
		setDisabledImageDescriptor(descriptor);
		setImageDescriptor(descriptor);
		setHoverImageDescriptor(descriptor);
		boolean checked = edu.ustb.sei.mde.morel.resource.morel.ui.MorelUIPlugin.getDefault().getPreferenceStore().getBoolean(preferenceKey);
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
			edu.ustb.sei.mde.morel.resource.morel.ui.MorelUIPlugin.getDefault().getPreferenceStore().setValue(preferenceKey, on);
		}
	}
	
	public boolean keepState() {
		return true;
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.ui.MorelOutlinePageTreeViewer getTreeViewer() {
		return treeViewer;
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.ui.MorelOutlinePageTreeViewerComparator getTreeViewerComparator() {
		return (edu.ustb.sei.mde.morel.resource.morel.ui.MorelOutlinePageTreeViewerComparator) treeViewer.getComparator();
	}
	
}
