/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IMorelExpectedElement {
	
	/**
	 * Returns the names of all tokens that are expected at the given position.
	 */
	public java.util.Set<String> getTokenNames();
	
	/**
	 * Returns the metaclass of the rule that contains the expected element.
	 */
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	
	/**
	 * Returns the syntax element that is expected.
	 */
	public edu.ustb.sei.mde.morel.resource.morel.grammar.MorelSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(edu.ustb.sei.mde.morel.resource.morel.IMorelExpectedElement follower, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<edu.ustb.sei.mde.morel.resource.morel.util.MorelPair<edu.ustb.sei.mde.morel.resource.morel.IMorelExpectedElement, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelContainedFeature[]>> getFollowers();
	
}
