/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.ui;

public class XmuOutlinePageLexicalSortingAction extends edu.ustb.sei.mde.xmu.resource.xmu.ui.AbstractXmuOutlinePageAction {
	
	public XmuOutlinePageLexicalSortingAction(edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuOutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
