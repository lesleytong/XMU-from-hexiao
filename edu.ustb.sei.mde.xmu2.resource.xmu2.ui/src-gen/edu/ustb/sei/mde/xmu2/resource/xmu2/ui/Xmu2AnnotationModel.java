/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.ui;

public class Xmu2AnnotationModel extends org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel {
	
	public Xmu2AnnotationModel(org.eclipse.core.resources.IResource resource) {
		super(resource);
	}
	
	protected org.eclipse.ui.texteditor.MarkerAnnotation createMarkerAnnotation(org.eclipse.core.resources.IMarker marker) {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2MarkerAnnotation(marker);
	}
	
}
