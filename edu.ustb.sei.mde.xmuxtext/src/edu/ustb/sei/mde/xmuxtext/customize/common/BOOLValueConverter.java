package edu.ustb.sei.mde.xmuxtext.customize.common;

import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.Strings;

public class BOOLValueConverter implements IValueConverter<Boolean> {

	public BOOLValueConverter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean toValue(String string, INode node) throws ValueConverterException {
		if (Strings.isEmpty(string))
			throw new ValueConverterException("Couldn't convert empty string to a boolean value.", node, null);
		try {
			return Boolean.valueOf(string);
		} catch (NumberFormatException e) {
			throw new ValueConverterException("Couldn't convert '" + string + "' to a boolean value.", node, e);
		}
	}

	@Override
	public String toString(Boolean value) throws ValueConverterException {
		if(value==null) {
			throw new ValueConverterException("Couldn't convert null to a boolean string.", null, null);
		} else {
			if(value) return "true";
			else return "false";
		}
	}

}
