/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class XmuAbstractExpectedElement implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<edu.ustb.sei.mde.xmu.resource.xmu.util.XmuPair<edu.ustb.sei.mde.xmu.resource.xmu.IXmuExpectedElement, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContainedFeature[]>> followers = new java.util.LinkedHashSet<edu.ustb.sei.mde.xmu.resource.xmu.util.XmuPair<edu.ustb.sei.mde.xmu.resource.xmu.IXmuExpectedElement, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContainedFeature[]>>();
	
	public XmuAbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(edu.ustb.sei.mde.xmu.resource.xmu.IXmuExpectedElement follower, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContainedFeature[] path) {
		followers.add(new edu.ustb.sei.mde.xmu.resource.xmu.util.XmuPair<edu.ustb.sei.mde.xmu.resource.xmu.IXmuExpectedElement, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<edu.ustb.sei.mde.xmu.resource.xmu.util.XmuPair<edu.ustb.sei.mde.xmu.resource.xmu.IXmuExpectedElement, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
