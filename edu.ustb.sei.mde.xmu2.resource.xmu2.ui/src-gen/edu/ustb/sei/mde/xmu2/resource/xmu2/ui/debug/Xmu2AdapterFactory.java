/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.ui.debug;

@SuppressWarnings("restriction")
public class Xmu2AdapterFactory implements org.eclipse.core.runtime.IAdapterFactory {
	
	@SuppressWarnings("rawtypes")	
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof org.eclipse.ui.texteditor.ITextEditor) {
			org.eclipse.ui.texteditor.ITextEditor editorPart = (org.eclipse.ui.texteditor.ITextEditor) adaptableObject;
			org.eclipse.core.resources.IResource resource = (org.eclipse.core.resources.IResource) editorPart.getEditorInput().getAdapter(org.eclipse.core.resources.IResource.class);
			if (resource != null) {
				String extension = resource.getFileExtension();
				if (extension != null && extension.equals(new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2MetaInformation().getSyntaxName())) {
					return new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.debug.Xmu2LineBreakpointAdapter();
				}
			}
		}
		if (adapterType == org.eclipse.debug.internal.ui.viewers.model.provisional.IElementLabelProvider.class && adaptableObject instanceof edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugVariable) {
			final edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugVariable variable = (edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugVariable) adaptableObject;
			return new org.eclipse.debug.internal.ui.viewers.model.provisional.IElementLabelProvider() {
				
				public void update(org.eclipse.debug.internal.ui.viewers.model.provisional.ILabelUpdate[] updates) {
					for (org.eclipse.debug.internal.ui.viewers.model.provisional.ILabelUpdate update : updates) {
						try {
							update.setLabel(variable.getName(), 0);
							update.setLabel(variable.getValue().getValueString(), 1);
							update.done();
						} catch (org.eclipse.debug.core.DebugException e) {
						}
					}
				}
			};
		}
		if (adapterType == org.eclipse.debug.internal.ui.viewers.model.provisional.IElementContentProvider.class && adaptableObject instanceof edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugVariable) {
			final edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugVariable variable = (edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugVariable) adaptableObject;
			return new org.eclipse.debug.internal.ui.viewers.model.provisional.IElementContentProvider() {
				
				public void update(org.eclipse.debug.internal.ui.viewers.model.provisional.IChildrenCountUpdate[] updates) {
					try {
						for (org.eclipse.debug.internal.ui.viewers.model.provisional.IChildrenCountUpdate update : updates) {
							org.eclipse.debug.core.model.IValue value = variable.getValue();
							edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugValue castedValue = (edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugValue) value;
							update.setChildCount(castedValue.getVariableCount());
							update.done();
						}
					} catch (org.eclipse.debug.core.DebugException e) {
						e.printStackTrace();
					}
				}
				
				public void update(org.eclipse.debug.internal.ui.viewers.model.provisional.IChildrenUpdate[] updates) {
					try {
						org.eclipse.debug.core.model.IValue value = variable.getValue();
						edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugValue castedValue = (edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugValue) value;
						for (org.eclipse.debug.internal.ui.viewers.model.provisional.IChildrenUpdate update : updates) {
							int offset = update.getOffset();
							int length = update.getLength();
							for (int i = offset; i < offset + length; i++) {
								org.eclipse.debug.core.model.IVariable variable = castedValue.getChild(i);
								update.setChild(variable, i);
							}
							update.done();
						}
					} catch (org.eclipse.debug.core.DebugException e) {
						e.printStackTrace();
					}
				}
				
				public void update(org.eclipse.debug.internal.ui.viewers.model.provisional.IHasChildrenUpdate[] updates) {
					for (org.eclipse.debug.internal.ui.viewers.model.provisional.IHasChildrenUpdate update : updates) {
						try {
							update.setHasChilren(variable.getValue().hasVariables());
							update.done();
						} catch (org.eclipse.debug.core.DebugException e) {
							e.printStackTrace();
						}
					}
				}
			};
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")	
	public Class[] getAdapterList() {
		return new Class[] {org.eclipse.debug.ui.actions.IToggleBreakpointsTarget.class};
	}
	
}
