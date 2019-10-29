/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

/**
 * The MorelTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class MorelTokenResolverFactory implements edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolverFactory {
	
	private java.util.Map<String, edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver> featureName2CollectInTokenResolver;
	private static edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver defaultResolver = new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultTokenResolver();
	
	public MorelTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver>();
		registerTokenResolver("COLLECTION", new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelCOLLECTIONTokenResolver());
		registerTokenResolver("DATA_TYPE", new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDATA_TYPETokenResolver());
		registerTokenResolver("IDENTIFIER", new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelIDENTIFIERTokenResolver());
		registerTokenResolver("URINS", new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelURINSTokenResolver());
		registerTokenResolver("INUMBER", new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelINUMBERTokenResolver());
		registerTokenResolver("RNUMBER", new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelRNUMBERTokenResolver());
		registerTokenResolver("QUOTED_39_39_92", new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelQUOTED_39_39_92TokenResolver());
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver internalCreateResolver(java.util.Map<String, edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver> resolverMap, String key, edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
