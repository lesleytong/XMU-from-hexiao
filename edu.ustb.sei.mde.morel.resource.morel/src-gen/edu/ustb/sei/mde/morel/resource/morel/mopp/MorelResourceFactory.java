/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

public class MorelResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public MorelResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelResource(uri);
	}
	
}
