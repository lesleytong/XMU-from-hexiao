/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.ui;

public class MorelOutlinePageLexicalSortingAction extends edu.ustb.sei.mde.morel.resource.morel.ui.AbstractMorelOutlinePageAction {
	
	public MorelOutlinePageLexicalSortingAction(edu.ustb.sei.mde.morel.resource.morel.ui.MorelOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
