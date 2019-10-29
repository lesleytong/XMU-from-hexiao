/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu;

/**
 * This interface provides information about a generated EMFText text resource
 * plug-in.
 */
public interface IXmuMetaInformation {
	
	public String getURI();
	
	/**
	 * Returns the name of the concrete syntax. This name is used as file extension.
	 * 
	 * @return the file extension
	 */
	public String getSyntaxName();
	
	/**
	 * Returns the relative path to the .cs file within the plug-in.
	 * 
	 * @return relative path to the .cs specification
	 */
	public String getPathToCSDefinition();
	
	/**
	 * Returns a lexer capable to split the underlying text file into tokens.
	 * 
	 * @return a new instance of the lexer class.
	 */
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextScanner createLexer();
	
	/**
	 * Returns an instance of the parser. This factory method is needed, because we
	 * can not create ANTLR parsers using the default constructor without arguments,
	 * because this constructor does expect the input stream or rather a token stream
	 * as arguments. Furthermore, the parser implementation can be exchanged by
	 * returning other parsers in this factory method.
	 * 
	 * @param inputStream the stream to read from
	 * @param encoding the encoding of the input stream, pass null to use platform
	 * default encoding
	 * 
	 * @return a new instance of the parser class
	 */
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextParser createParser(java.io.InputStream inputStream, String encoding);
	
	/**
	 * Returns a new instance of the printer.
	 * 
	 * @param outputStream the stream to print to
	 * @param resource that contains the elements that will be printed
	 * 
	 * @return a new instance of the printer class
	 */
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextPrinter createPrinter(java.io.OutputStream outputStream, edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource resource);
	
	/**
	 * Returns all meta classes for which syntax was defined. This information is used
	 * both by the NewFileWizard and the code completion.
	 */
	public org.eclipse.emf.ecore.EClass[] getClassesWithSyntax();
	
	/**
	 * Returns an instance of the reference resolver switch class.
	 */
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuReferenceResolverSwitch getReferenceResolverSwitch();
	
	/**
	 * Returns an instance of the token resolver factory.
	 */
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenResolverFactory getTokenResolverFactory();
	
	/**
	 * Returns a list of the names of all tokens defined in the syntax.
	 */
	public String[] getTokenNames();
	
	/**
	 * Returns the default style that should be used to present tokens of the given
	 * type.
	 * 
	 * @param tokenName the name of the token type
	 * 
	 * @return a style object or null if no default style is set
	 */
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenStyle getDefaultTokenStyle(String tokenName);
	
	/**
	 * Returns the default bracket pairs.
	 */
	public java.util.Collection<edu.ustb.sei.mde.xmu.resource.xmu.IXmuBracketPair> getBracketPairs();
	
	/**
	 * Returns all classes for which folding must be enabled in the editor.
	 */
	public org.eclipse.emf.ecore.EClass[] getFoldableClasses();
	
}
