package edu.ustb.sei.mde.xmuxtext.customize.impl;

import org.eclipse.xtext.naming.IQualifiedNameConverter;

public class Xmu2QualifiedNameConverter extends IQualifiedNameConverter.DefaultImpl{

	@Override
	public String getDelimiter() {
		return "!";
	}

}
