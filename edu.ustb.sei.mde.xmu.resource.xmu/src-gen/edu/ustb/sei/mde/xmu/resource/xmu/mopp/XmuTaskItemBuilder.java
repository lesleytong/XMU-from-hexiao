/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

/**
 * The XmuTaskItemBuilder is used to find task items in text documents. The
 * current implementation uses the generated lexer and the TaskItemDetector to
 * detect task items. This class is called by the BuilderAdapter, which runs both
 * this builder and the default builder that is intended to be customized.
 */
public class XmuTaskItemBuilder {
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		monitor.setTaskName("Searching for task items");
		new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuMarkerHelper().removeAllMarkers(resource, org.eclipse.core.resources.IMarker.TASK);
		if (isInBinFolder(resource)) {
			return;
		}
		java.util.List<edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTaskItem> taskItems = new java.util.ArrayList<edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTaskItem>();
		edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTaskItemDetector taskItemDetector = new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTaskItemDetector();
		try {
			java.io.InputStream inputStream = resource.getContents();
			String content = edu.ustb.sei.mde.xmu.resource.xmu.util.XmuStreamUtil.getContent(inputStream);
			edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextScanner lexer = new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuMetaInformation().createLexer();
			lexer.setText(content);
			
			edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextToken nextToken = lexer.getNextToken();
			while (nextToken != null) {
				String text = nextToken.getText();
				taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));
				nextToken = lexer.getNextToken();
			}
		} catch (java.io.IOException e) {
			edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuPlugin.logError("Exception while searching for task items", e);
		} catch (org.eclipse.core.runtime.CoreException e) {
			edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuPlugin.logError("Exception while searching for task items", e);
		}
		
		for (edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTaskItem taskItem : taskItems) {
			java.util.Map<String, Object> markerAttributes = new java.util.LinkedHashMap<String, Object>();
			markerAttributes.put(org.eclipse.core.resources.IMarker.USER_EDITABLE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.DONE, false);
			markerAttributes.put(org.eclipse.core.resources.IMarker.LINE_NUMBER, taskItem.getLine());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_START, taskItem.getCharStart());
			markerAttributes.put(org.eclipse.core.resources.IMarker.CHAR_END, taskItem.getCharEnd());
			markerAttributes.put(org.eclipse.core.resources.IMarker.MESSAGE, taskItem.getMessage());
			new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuMarkerHelper().createMarker(resource, org.eclipse.core.resources.IMarker.TASK, markerAttributes);
		}
	}
	
	public String getBuilderMarkerId() {
		return org.eclipse.core.resources.IMarker.TASK;
	}
	
	public boolean isInBinFolder(org.eclipse.core.resources.IFile resource) {
		org.eclipse.core.resources.IContainer parent = resource.getParent();
		while (parent != null) {
			if ("bin".equals(parent.getName())) {
				return true;
			}
			parent = parent.getParent();
		}
		return false;
	}
	
}
