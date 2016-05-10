/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class Xmu2AbstractExpectedElement implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ExpectedElement {
	
	private org.eclipse.emf.ecore.EClass ruleMetaclass;
	
	private java.util.Set<edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2Pair<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ExpectedElement, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContainedFeature[]>> followers = new java.util.LinkedHashSet<edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2Pair<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ExpectedElement, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContainedFeature[]>>();
	
	public Xmu2AbstractExpectedElement(org.eclipse.emf.ecore.EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public org.eclipse.emf.ecore.EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ExpectedElement follower, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContainedFeature[] path) {
		followers.add(new edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2Pair<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ExpectedElement, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContainedFeature[]>(follower, path));
	}
	
	public java.util.Collection<edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2Pair<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ExpectedElement, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
