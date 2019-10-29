/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.ui;

public class MorelOutlinePageLinkWithEditorAction extends edu.ustb.sei.mde.morel.resource.morel.ui.AbstractMorelOutlinePageAction {
	
	public MorelOutlinePageLinkWithEditorAction(edu.ustb.sei.mde.morel.resource.morel.ui.MorelOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
