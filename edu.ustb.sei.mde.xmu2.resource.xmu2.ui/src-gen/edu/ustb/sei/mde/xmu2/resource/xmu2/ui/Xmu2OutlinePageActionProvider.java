/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.ui;

public class Xmu2OutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2OutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2OutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2OutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2OutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2OutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2OutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2OutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
