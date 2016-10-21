package edu.ustb.sei.mde.xmuxtext.ui.customize;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

public class Xmu2HighlightingConfiguration extends DefaultHighlightingConfiguration {

	public Xmu2HighlightingConfiguration() {
		super();
	}
	
	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		// TODO Auto-generated method stub
		super.configure(acceptor);
		acceptor.acceptDefaultHighlighting(Xmu2AntlrTokenToAttributeIdMapper.PRIMITIVE_TYPE_ID, 
				Xmu2AntlrTokenToAttributeIdMapper.PRIMITIVE_TYPE_ID, primitiveTypeTextStyle());
		acceptor.acceptDefaultHighlighting(Xmu2AntlrTokenToAttributeIdMapper.PATH_NAME_ID, 
				Xmu2AntlrTokenToAttributeIdMapper.PATH_NAME_ID, complexTypeTextStyle());
	}
	
	@Override
	public TextStyle numberTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 0, 192));
		return textStyle;
	}
	
	@Override
	public TextStyle stringTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(192, 0, 0));
		return textStyle;
	}
	
	@Override
	public TextStyle commentTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(64, 128, 0));
		return textStyle;
	}

	public TextStyle primitiveTypeTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(128,0, 128));
		return textStyle;
	}
	
	public TextStyle complexTypeTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 64, 128));
		return textStyle;
	}

}
