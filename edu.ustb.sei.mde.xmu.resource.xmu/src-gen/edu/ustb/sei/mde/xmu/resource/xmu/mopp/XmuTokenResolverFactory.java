/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

/**
 * The XmuTokenResolverFactory class provides access to all generated token
 * resolvers. By giving the name of a defined token, the corresponding resolve can
 * be obtained. Despite the fact that this class is called TokenResolverFactory is
 * does NOT create new token resolvers whenever a client calls methods to obtain a
 * resolver. Rather, this class maintains a map of all resolvers and creates each
 * resolver at most once.
 */
public class XmuTokenResolverFactory implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolverFactory {
	
	private java.util.Map<String, edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver> tokenName2TokenResolver;
	private java.util.Map<String, edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver> featureName2CollectInTokenResolver;
	private static edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver defaultResolver = new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultTokenResolver();
	
	public XmuTokenResolverFactory() {
		tokenName2TokenResolver = new java.util.LinkedHashMap<String, edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver>();
		featureName2CollectInTokenResolver = new java.util.LinkedHashMap<String, edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver>();
		registerTokenResolver("URI", new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuURITokenResolver());
		registerTokenResolver("PRIMITIVE", new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuPRIMITIVETokenResolver());
		registerTokenResolver("BOOLEAN", new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuBOOLEANTokenResolver());
		registerTokenResolver("NAME", new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuNAMETokenResolver());
		registerTokenResolver("NUMBER", new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuNUMBERTokenResolver());
		registerTokenResolver("OBJ_URI", new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuOBJ_URITokenResolver());
		registerTokenResolver("QUOTED_39_39_92", new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuQUOTED_39_39_92TokenResolver());
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver createTokenResolver(String tokenName) {
		return internalCreateResolver(tokenName2TokenResolver, tokenName);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver createCollectInTokenResolver(String featureName) {
		return internalCreateResolver(featureName2CollectInTokenResolver, featureName);
	}
	
	protected boolean registerTokenResolver(String tokenName, edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver resolver){
		return internalRegisterTokenResolver(tokenName2TokenResolver, tokenName, resolver);
	}
	
	protected boolean registerCollectInTokenResolver(String featureName, edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver resolver){
		return internalRegisterTokenResolver(featureName2CollectInTokenResolver, featureName, resolver);
	}
	
	protected edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver deRegisterTokenResolver(String tokenName){
		return tokenName2TokenResolver.remove(tokenName);
	}
	
	private edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver internalCreateResolver(java.util.Map<String, edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver> resolverMap, String key) {
		if (resolverMap.containsKey(key)){
			return resolverMap.get(key);
		} else {
			return defaultResolver;
		}
	}
	
	private boolean internalRegisterTokenResolver(java.util.Map<String, edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver> resolverMap, String key, edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolver resolver) {
		if (!resolverMap.containsKey(key)) {
			resolverMap.put(key,resolver);
			return true;
		}
		return false;
	}
	
}
