/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.mopp;

public class Xmu2AntlrScanner implements edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public Xmu2AntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextToken result = new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2ANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
