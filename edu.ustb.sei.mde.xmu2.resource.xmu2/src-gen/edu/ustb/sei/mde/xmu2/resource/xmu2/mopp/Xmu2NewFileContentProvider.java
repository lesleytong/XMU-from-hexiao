/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

public class Xmu2NewFileContentProvider {
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2MetaInformation getMetaInformation() {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2MetaInformation();
	}
	
	public String getNewFileContent(String newFileName) {
		return getExampleContent(new org.eclipse.emf.ecore.EClass[] {
			edu.ustb.sei.mde.xmu2.Xmu2Package.eINSTANCE.getTransformationModel(),
		}, getMetaInformation().getClassesWithSyntax(), newFileName);
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass[] startClasses, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, String newFileName) {
		String content = "";
		for (org.eclipse.emf.ecore.EClass next : startClasses) {
			content = getExampleContent(next, allClassesWithSyntax, newFileName);
			if (content.trim().length() > 0) {
				break;
			}
		}
		return content;
	}
	
	protected String getExampleContent(org.eclipse.emf.ecore.EClass eClass, org.eclipse.emf.ecore.EClass[] allClassesWithSyntax, String newFileName) {
		// create a minimal model
		org.eclipse.emf.ecore.EObject root = new edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2MinimalModelHelper().getMinimalModel(eClass, allClassesWithSyntax, newFileName);
		if (root == null) {
			// could not create a minimal model. returning an empty document is the best we
			// can do.
			return "";
		}
		// use printer to get text for model
		java.io.ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
		edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextPrinter printer = getPrinter(buffer);
		try {
			printer.print(root);
		} catch (java.io.IOException e) {
			new edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2RuntimeUtil().logError("Exception while generating example content.", e);
		}
		return buffer.toString();
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextPrinter getPrinter(java.io.OutputStream outputStream) {
		return getMetaInformation().createPrinter(outputStream, new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Resource());
	}
	
}
