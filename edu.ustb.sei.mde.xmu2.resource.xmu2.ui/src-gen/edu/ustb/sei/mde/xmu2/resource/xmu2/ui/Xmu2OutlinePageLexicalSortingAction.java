/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.ui;

public class Xmu2OutlinePageLexicalSortingAction extends edu.ustb.sei.mde.xmu2.resource.xmu2.ui.AbstractXmu2OutlinePageAction {
	
	public Xmu2OutlinePageLexicalSortingAction(edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2OutlinePageTreeViewer treeViewer) {
		super(treeViewer, "Sort alphabetically", org.eclipse.jface.action.IAction.AS_CHECK_BOX);
		initialize("icons/sort_lexically_icon.gif");
	}
	
	public void runInternal(boolean on) {
		getTreeViewerComparator().setSortLexically(on);
		getTreeViewer().refresh();
	}
	
}
