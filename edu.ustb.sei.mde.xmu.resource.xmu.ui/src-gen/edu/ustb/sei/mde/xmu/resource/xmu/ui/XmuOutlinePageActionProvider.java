/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.ui;

public class XmuOutlinePageActionProvider {
	
	public java.util.List<org.eclipse.jface.action.IAction> getActions(edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuOutlinePageTreeViewer treeViewer) {
		// To add custom actions to the outline view, set the
		// 'overrideOutlinePageActionProvider' option to <code>false</code> and modify
		// this method.
		java.util.List<org.eclipse.jface.action.IAction> defaultActions = new java.util.ArrayList<org.eclipse.jface.action.IAction>();
		defaultActions.add(new edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuOutlinePageLinkWithEditorAction(treeViewer));
		defaultActions.add(new edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuOutlinePageCollapseAllAction(treeViewer));
		defaultActions.add(new edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuOutlinePageExpandAllAction(treeViewer));
		defaultActions.add(new edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuOutlinePageAutoExpandAction(treeViewer));
		defaultActions.add(new edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuOutlinePageLexicalSortingAction(treeViewer));
		defaultActions.add(new edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuOutlinePageTypeSortingAction(treeViewer));
		return defaultActions;
	}
	
}
