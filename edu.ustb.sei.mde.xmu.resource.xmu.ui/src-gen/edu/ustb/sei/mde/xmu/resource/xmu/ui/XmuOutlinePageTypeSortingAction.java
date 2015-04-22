/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.ui;

public class XmuOutlinePageTypeSortingAction extends edu.ustb.sei.mde.xmu.resource.xmu.ui.AbstractXmuOutlinePageAction {
	
	public XmuOutlinePageTypeSortingAction(edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
