/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

public class XmuMetaInformation implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuMetaInformation {
	
	public String getSyntaxName() {
		return "xmu";
	}
	
	public String getURI() {
		return "http://www.ustb.edu.cn/sei/mde/xmu";
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextScanner createLexer() {
		return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuAntlrScanner(new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuLexer());
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuParser().createInstance(inputStream, encoding);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextPrinter createPrinter(java.io.OutputStream outputStream, edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource resource) {
		return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolverSwitch getReferenceResolverSwitch() {
		return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuReferenceResolverSwitch();
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolverFactory getTokenResolverFactory() {
		return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "edu.ustb.sei.mde.xmu/metamodel/xmu.cs";
	}
	
	public String[] getTokenNames() {
		return edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuParser.tokenNames;
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenStyle getDefaultTokenStyle(String tokenName) {
		return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<edu.ustb.sei.mde.xmu.resource.xmu.IXmuBracketPair> getBracketPairs() {
		return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuResourceFactory();
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuNewFileContentProvider getNewFileContentProvider() {
		return new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuResourceFactory());
	}
	
	/**
	 * Returns the key of the option that can be used to register a preprocessor that
	 * is used as a pipe when loading resources. This key is language-specific. To
	 * register one preprocessor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getInputStreamPreprocessorProviderOptionKey() {
		return getSyntaxName() + "_" + "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	}
	
	/**
	 * Returns the key of the option that can be used to register a post-processors
	 * that are invoked after loading resources. This key is language-specific. To
	 * register one post-processor for multiple resource types, it must be registered
	 * individually using all keys.
	 */
	public String getResourcePostProcessorProviderOptionKey() {
		return getSyntaxName() + "_" + "RESOURCE_POSTPROCESSOR_PROVIDER";
	}
	
	public String getLaunchConfigurationType() {
		return "edu.ustb.sei.mde.xmu.resource.xmu.ui.launchConfigurationType";
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuNameProvider createNameProvider() {
		return new edu.ustb.sei.mde.xmu.resource.xmu.analysis.XmuDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuAntlrTokenHelper tokenHelper = new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuAntlrTokenHelper();
		java.util.List<String> highlightableTokens = new java.util.ArrayList<String>();
		String[] parserTokenNames = getTokenNames();
		for (int i = 0; i < parserTokenNames.length; i++) {
			// If ANTLR is used we need to normalize the token names
			if (!tokenHelper.canBeUsedForSyntaxHighlighting(i)) {
				continue;
			}
			String tokenName = tokenHelper.getTokenName(parserTokenNames, i);
			if (tokenName == null) {
				continue;
			}
			highlightableTokens.add(tokenName);
		}
		highlightableTokens.add(edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
