/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.ui;

public class MorelOutlinePageTypeSortingAction extends edu.ustb.sei.mde.morel.resource.morel.ui.AbstractMorelOutlinePageAction {
	
	public MorelOutlinePageTypeSortingAction(edu.ustb.sei.mde.morel.resource.morel.ui.MorelOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Group types", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/group_types_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setGroupTypes(on);
		getTreeViewer().refresh();
	}
	
}
