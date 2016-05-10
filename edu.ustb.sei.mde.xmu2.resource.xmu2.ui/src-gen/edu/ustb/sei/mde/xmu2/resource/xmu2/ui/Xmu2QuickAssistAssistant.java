/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.ui;

public class Xmu2QuickAssistAssistant extends org.eclipse.jface.text.quickassist.QuickAssistAssistant implements org.eclipse.jface.text.quickassist.IQuickAssistAssistant {
	
	public Xmu2QuickAssistAssistant(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ResourceProvider resourceProvider, edu.ustb.sei.mde.xmu2.resource.xmu2.ui.IXmu2AnnotationModelProvider annotationModelProvider) {
		setQuickAssistProcessor(new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2QuickAssistProcessor(resourceProvider, annotationModelProvider));
		setInformationControlCreator(new org.eclipse.jface.text.AbstractReusableInformationControlCreator() {
			public org.eclipse.jface.text.IInformationControl doCreateInformationControl(org.eclipse.swt.widgets.Shell parent) {
				return new org.eclipse.jface.text.DefaultInformationControl(parent, (org.eclipse.jface.text.DefaultInformationControl.IInformationPresenter) null);
			}
		});
	}
	
	public boolean canAssist(org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext invocationContext) {
		return false;
	}
	
	public boolean canFix(org.eclipse.jface.text.source.Annotation annotation) {
		return true;
	}
	
}
