/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

public class XmuResourceFactory implements org.eclipse.emf.ecore.resource.Resource.Factory {
	
	public XmuResourceFactory() {
		super();
	}
	
	public org.eclipse.emf.ecore.resource.Resource createResource(org.eclipse.emf.common.util.URI uri) {
		return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuResource(uri);
	}
	
}
