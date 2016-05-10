/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.ui;

public class Xmu2HoverTextProvider implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2HoverTextProvider {
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2DefaultHoverTextProvider defaultProvider = new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2DefaultHoverTextProvider();
	
	public String getHoverText(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject referencedObject) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(referencedObject);
	}
	
	public String getHoverText(org.eclipse.emf.ecore.EObject object) {
		// Set option overrideHoverTextProvider to false and customize this method to
		// obtain custom hover texts.
		return defaultProvider.getHoverText(object);
	}
	
}
