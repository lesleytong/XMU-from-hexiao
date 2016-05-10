/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.ui;

public class Xmu2OutlinePageExpandAllAction extends edu.ustb.sei.mde.xmu2.resource.xmu2.ui.AbstractXmu2OutlinePageAction {
	
	public Xmu2OutlinePageExpandAllAction(edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2OutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Expand all", org.eclipse.jface.action.IAction.AS_PUSH_BUTTON);
		initialize("icons/expand_all_icon.gif");
	}
	
	public void runInternal(boolean on) {
		if (on) {
			getTreeViewer().expandAll();
		}
	}
	
	public boolean keepState() {
		return false;
	}
	
}
