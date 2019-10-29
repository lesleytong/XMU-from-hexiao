/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.ui;

public class XmuOutlinePageAutoExpandAction extends edu.ustb.sei.mde.xmu.resource.xmu.ui.AbstractXmuOutlinePageAction {
	
	public XmuOutlinePageAutoExpandAction(edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Auto expand", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/auto_expand_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewer().setAutoExpand(on);
		getTreeViewer().refresh();
	}
	
}
