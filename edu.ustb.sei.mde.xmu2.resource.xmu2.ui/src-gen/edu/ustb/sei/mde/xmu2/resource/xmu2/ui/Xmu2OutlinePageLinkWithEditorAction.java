/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.ui;

public class Xmu2OutlinePageLinkWithEditorAction extends edu.ustb.sei.mde.xmu2.resource.xmu2.ui.AbstractXmu2OutlinePageAction {
	
	public Xmu2OutlinePageLinkWithEditorAction(edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2OutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
