/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

public class MorelMetaInformation implements edu.ustb.sei.mde.morel.resource.morel.IMorelMetaInformation {
	
	public String getSyntaxName() {
		return "morel";
	}
	
	public String getURI() {
		return "http://www.ustb.edu.cn/sei/mde/morel";
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelTextScanner createLexer() {
		return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelAntlrScanner(new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelLexer());
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelTextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelParser().createInstance(inputStream, encoding);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelTextPrinter createPrinter(java.io.OutputStream outputStream, edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource resource) {
		return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelPrinter2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelSyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelSyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelReferenceResolverSwitch getReferenceResolverSwitch() {
		return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelReferenceResolverSwitch();
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelTokenResolverFactory getTokenResolverFactory() {
		return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "edu.ustb.sei.mde.morel/metamodel/morel.cs";
	}
	
	public String[] getTokenNames() {
		return edu.ustb.sei.mde.morel.resource.morel.mopp.MorelParser.tokenNames;
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelTokenStyle getDefaultTokenStyle(String tokenName) {
		return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<edu.ustb.sei.mde.morel.resource.morel.IMorelBracketPair> getBracketPairs() {
		return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelBracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelFoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelResourceFactory();
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.mopp.MorelNewFileContentProvider getNewFileContentProvider() {
		return new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelNewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelResourceFactory());
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
		return "edu.ustb.sei.mde.morel.resource.morel.ui.launchConfigurationType";
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelNameProvider createNameProvider() {
		return new edu.ustb.sei.mde.morel.resource.morel.analysis.MorelDefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		edu.ustb.sei.mde.morel.resource.morel.mopp.MorelAntlrTokenHelper tokenHelper = new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelAntlrTokenHelper();
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
		highlightableTokens.add(edu.ustb.sei.mde.morel.resource.morel.mopp.MorelTokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
