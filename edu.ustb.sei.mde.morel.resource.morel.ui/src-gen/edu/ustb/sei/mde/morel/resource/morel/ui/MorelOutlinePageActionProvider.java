/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.ui;

public class MorelOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(edu.ustb.sei.mde.morel.resource.morel.ui.MorelOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new edu.ustb.sei.mde.morel.resource.morel.ui.MorelOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new edu.ustb.sei.mde.morel.resource.morel.ui.MorelOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new edu.ustb.sei.mde.morel.resource.morel.ui.MorelOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new edu.ustb.sei.mde.morel.resource.morel.ui.MorelOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new edu.ustb.sei.mde.morel.resource.morel.ui.MorelOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new edu.ustb.sei.mde.morel.resource.morel.ui.MorelOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
