/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2;

public interface IXmu2HoverTextProvider {
	
	/**
	 * Returns the hoves text that is shown when the mouse pointer rests over the
	 * given object. The hover text can contain HTML.
	 */
	public String getHoverText(org.eclipse.emf.ecore.EObject object);
	
	/**
	 * Returns the hoves text that is shown when the mouse pointer rests over a
	 * reference to the given object. The hover text can contain HTML.
	 */
	public String getHoverText(org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EObject referencedObject);
	
}
