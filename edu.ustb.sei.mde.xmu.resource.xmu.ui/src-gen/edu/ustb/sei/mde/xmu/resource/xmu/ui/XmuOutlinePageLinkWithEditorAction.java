/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.ui;

public class XmuOutlinePageLinkWithEditorAction extends edu.ustb.sei.mde.xmu.resource.xmu.ui.AbstractXmuOutlinePageAction {
	
	public XmuOutlinePageLinkWithEditorAction(edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Link with Editor", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/link_with_editor_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setLinkWithEditor(on);
	}
	
}
