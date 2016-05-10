/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

/**
 * A basic implementation of the
 * edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2URIMapping interface that can map
 * identifiers to URIs.
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement
 * edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2URIMapping.
 */
public class Xmu2URIMapping<ReferenceType> implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2URIMapping<ReferenceType> {
	
	private org.eclipse.emf.common.util.URI uri;
	private String identifier;
	private String warning;
	
	public Xmu2URIMapping(String identifier, org.eclipse.emf.common.util.URI newIdentifier, String warning) {
		super();
		this.uri = newIdentifier;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public org.eclipse.emf.common.util.URI getTargetIdentifier() {
		return uri;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
