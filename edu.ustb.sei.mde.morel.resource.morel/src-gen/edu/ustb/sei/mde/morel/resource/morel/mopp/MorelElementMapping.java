/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

/**
 * A basic implementation of the
 * edu.ustb.sei.mde.morel.resource.morel.IMorelElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
public class MorelElementMapping<ReferenceType> implements edu.ustb.sei.mde.morel.resource.morel.IMorelElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	private String identifier;
	private String warning;
	
	public MorelElementMapping(String identifier, ReferenceType target, String warning) {
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
