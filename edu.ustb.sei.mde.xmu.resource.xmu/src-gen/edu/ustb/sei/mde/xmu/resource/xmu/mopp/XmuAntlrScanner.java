/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.mopp;

public class XmuAntlrScanner implements edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public XmuAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextToken result = new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
