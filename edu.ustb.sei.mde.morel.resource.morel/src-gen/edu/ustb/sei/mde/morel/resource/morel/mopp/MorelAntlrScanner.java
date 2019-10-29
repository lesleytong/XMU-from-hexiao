/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.mopp;

public class MorelAntlrScanner implements edu.ustb.sei.mde.morel.resource.morel.IMorelTextScanner {
	
	private org.antlr.runtime3_4_0.Lexer antlrLexer;
	
	public MorelAntlrScanner(org.antlr.runtime3_4_0.Lexer antlrLexer) {
		this.antlrLexer = antlrLexer;
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelTextToken getNextToken() {
		if (antlrLexer.getCharStream() == null) {
			return null;
		}
		final org.antlr.runtime3_4_0.Token current = antlrLexer.nextToken();
		if (current == null || current.getType() < 0) {
			return null;
		}
		edu.ustb.sei.mde.morel.resource.morel.IMorelTextToken result = new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelANTLRTextToken(current);
		return result;
	}
	
	public void setText(String text) {
		antlrLexer.setCharStream(new org.antlr.runtime3_4_0.ANTLRStringStream(text));
	}
	
}
