/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

public class Xmu2MetaInformation implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2MetaInformation {
	
	public String getSyntaxName() {
		return "xmu2";
	}
	
	public String getURI() {
		return "http://www.ustb.edu.cn/sei/mde/xmu2";
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextScanner createLexer() {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2AntlrScanner(new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Lexer());
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextParser createParser(java.io.InputStream inputStream, String encoding) {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Parser().createInstance(inputStream, encoding);
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextPrinter createPrinter(java.io.OutputStream outputStream, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource resource) {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Printer2(outputStream, resource);
	}
	
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax() {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2SyntaxCoverageInformationProvider().getClassesWithSyntax();
	}
	
	public org.eclipse.emf.ecore.EClass[] getStartSymbols() {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2SyntaxCoverageInformationProvider().getStartSymbols();
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2ReferenceResolverSwitch getReferenceResolverSwitch() {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ReferenceResolverSwitch();
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenResolverFactory getTokenResolverFactory() {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenResolverFactory();
	}
	
	public String getPathToCSDefinition() {
		return "edu.ustb.sei.mde.xmu2/metamodel/xmu2.cs";
	}
	
	public String[] getTokenNames() {
		return edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Parser.tokenNames;
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenStyle getDefaultTokenStyle(String tokenName) {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyleInformationProvider().getDefaultTokenStyle(tokenName);
	}
	
	public java.util.Collection<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2BracketPair> getBracketPairs() {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2BracketInformationProvider().getBracketPairs();
	}
	
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses() {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2FoldingInformationProvider().getFoldableClasses();
	}
	
	public org.eclipse.emf.ecore.resource.Resource.Factory createResourceFactory() {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ResourceFactory();
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2NewFileContentProvider getNewFileContentProvider() {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2NewFileContentProvider();
	}
	
	public void registerResourceFactory() {
		org.eclipse.emf.ecore.resource.Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(getSyntaxName(), new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ResourceFactory());
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
		return "edu.ustb.sei.mde.xmu2.resource.xmu2.ui.launchConfigurationType";
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2NameProvider createNameProvider() {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.analysis.Xmu2DefaultNameProvider();
	}
	
	public String[] getSyntaxHighlightableTokenNames() {
		edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2AntlrTokenHelper tokenHelper = new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2AntlrTokenHelper();
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
		highlightableTokens.add(edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2TokenStyleInformationProvider.TASK_ITEM_TOKEN_NAME);
		return highlightableTokens.toArray(new String[highlightableTokens.size()]);
	}
	
}
