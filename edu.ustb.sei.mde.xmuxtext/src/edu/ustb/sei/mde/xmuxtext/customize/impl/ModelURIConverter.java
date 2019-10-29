package edu.ustb.sei.mde.xmuxtext.customize.impl;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.ValueConverterWithValueException;
import org.eclipse.xtext.nodemodel.INode;

public class ModelURIConverter implements IValueConverter<String> {

	public ModelURIConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toValue(String string, INode node) throws ValueConverterException {
		if(string.length()<2 || (string.charAt(0)!='<'||string.charAt(string.length()-1)!='>')) {
			throw new ValueConverterWithValueException("invalid uri", node, "", null);
		} else {
			return string.substring(1,string.length()-1);
		}
	}

	@Override
	public String toString(String value) throws ValueConverterException {
		return "<"+value+'>';
	}

}
