/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

/**
 * A basic implementation of the
 * edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class Xmu2ElementMapping<ReferenceType> implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public Xmu2ElementMapping(String identifier, ReferenceType target, String warning) {
		super();
		this.target = target;
		this.identifier = identifier;
		this.warning = warning;
	}
	
	public ReferenceType getTargetElement() {
		return target;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	
	public String getWarning() {
		return warning;
	}
	
}
