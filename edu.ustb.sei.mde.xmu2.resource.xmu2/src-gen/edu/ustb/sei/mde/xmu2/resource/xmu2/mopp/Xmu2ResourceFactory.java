/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

public class Xmu2ResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public Xmu2ResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Resource(uri);
	}
	
}
