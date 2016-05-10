/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2;

/**
 * A TokenResolverFactory creates TokenResolvers. The concrete resolver to be
 * created is determined by the given token name (i.e., the type of the token).
 * One may consider TokenResolverFactories as a registry, which maps token types
 * to TokenResolvers.
 */
public interface IXmu2TokenResolverFactory {
	
	/**
	 * Creates a token resolver for normal tokens of type <code>tokenName</code>.
	 */
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver createTokenResolver(String tokenName);
	
	/**
	 * Creates a token resolver for COLLECT-IN tokens that are stored in feature
	 * <code>featureName</code>.
	 */
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver createCollectInTokenResolver(String featureName);
	
}
