/*
 * generated by Xtext 2.10.0
 */
package edu.ustb.sei.mde.xmuxtext.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class Xmu2AntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("edu/ustb/sei/mde/xmuxtext/parser/antlr/internal/InternalXmu2.tokens");
	}
}
