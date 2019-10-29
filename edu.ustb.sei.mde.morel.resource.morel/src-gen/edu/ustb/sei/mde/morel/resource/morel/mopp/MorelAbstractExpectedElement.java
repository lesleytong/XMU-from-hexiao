/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class MorelAbstractExpectedElement implements edu.ustb.sei.mde.morel.resource.morel.IMorelExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<edu.ustb.sei.mde.morel.resource.morel.util.MorelPair<edu.ustb.sei.mde.morel.resource.morel.IMorelExpectedElement, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContainedFeature[]>> followers = new java.util.LinkedHashSet<edu.ustb.sei.mde.morel.resource.morel.util.MorelPair<edu.ustb.sei.mde.morel.resource.morel.IMorelExpectedElement, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContainedFeature[]>>();
	
	public MorelAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(edu.ustb.sei.mde.morel.resource.morel.IMorelExpectedElement follower, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContainedFeature[] path) {
		followers.add(new edu.ustb.sei.mde.morel.resource.morel.util.MorelPair<edu.ustb.sei.mde.morel.resource.morel.IMorelExpectedElement, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<edu.ustb.sei.mde.morel.resource.morel.util.MorelPair<edu.ustb.sei.mde.morel.resource.morel.IMorelExpectedElement, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
