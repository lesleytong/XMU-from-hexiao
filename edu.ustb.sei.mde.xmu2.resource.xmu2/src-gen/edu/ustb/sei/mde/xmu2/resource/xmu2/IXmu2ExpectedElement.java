/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IXmu2ExpectedElement {
	
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
	public edu.ustb.sei.mde.xmu2.resource.xmu2.grammar.Xmu2SyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ExpectedElement follower, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2Pair<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ExpectedElement, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ContainedFeature[]>> getFollowers();
	
}
