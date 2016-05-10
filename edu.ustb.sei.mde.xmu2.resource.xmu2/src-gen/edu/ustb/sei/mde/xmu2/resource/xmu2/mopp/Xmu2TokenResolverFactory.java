/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

/**
 * The Xmu2TokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class Xmu2TokenResolverFactory implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolverFactory {
	
	private java.util.Map<String, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver> featureName2CollectInTokenResolver;
	private static edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver defaultResolver = new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultTokenResolver();
	
	public Xmu2TokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver>();
		registerTokenResolver("TYPE", new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2TYPETokenResolver());
		registerTokenResolver("BOOLEAN", new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2BOOLEANTokenResolver());
		registerTokenResolver("NAME", new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2NAMETokenResolver());
		registerTokenResolver("NUMBER", new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2NUMBERTokenResolver());
		registerTokenResolver("OBJ_URI", new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2OBJ_URITokenResolver());
		registerTokenResolver("QUOTED_60_62_92", new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2QUOTED_60_62_92TokenResolver());
		registerTokenResolver("QUOTED_39_39_92", new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2QUOTED_39_39_92TokenResolver());
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver internalCreateResolver(java.util.Map<String, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver> resolverMap, String key, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
