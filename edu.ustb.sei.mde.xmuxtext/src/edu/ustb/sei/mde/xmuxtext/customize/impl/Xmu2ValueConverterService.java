package edu.ustb.sei.mde.xmuxtext.customize.impl;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.impl.AbstractDeclarativeValueConverterService;
import org.eclipse.xtext.conversion.impl.AbstractIDValueConverter;
import org.eclipse.xtext.conversion.impl.INTValueConverter;
import org.eclipse.xtext.conversion.impl.STRINGValueConverter;

import com.google.inject.Inject;

import edu.ustb.sei.mde.xmuxtext.customize.common.BOOLValueConverter;

public class Xmu2ValueConverterService extends AbstractDeclarativeValueConverterService {

	public Xmu2ValueConverterService() {
		super();
	}

	@Inject
	private ModelURIConverter modelUriConverter;
	
	@ValueConverter(rule = "MODEL_URI")
	public IValueConverter<String> getURIConverter() {
    	return modelUriConverter;
	}
	
	@Inject
	private AbstractIDValueConverter idValueConverter;

	@ValueConverter(rule = "NAME")
	public IValueConverter<String> NAME() {
		return idValueConverter;
	}
	
	@Inject
	private BOOLValueConverter boolValueConverter;
	public IValueConverter<Boolean> BOOLEAN() {
		return boolValueConverter;
	}
	
	
	
	
	/*
	 * copied from DefaultTerminalConverts
	 */
	


//	@Inject
//	private AbstractIDValueConverter terminalsIdValueConverter;
//
//	/**
//	 * @since 2.9
//	 */
//	@ValueConverter(rule = "org.eclipse.xtext.common.Terminals.ID")
//	public IValueConverter<String> TerminalsID() {
//		return terminalsIdValueConverter;
//	}
	
	@Inject
	private INTValueConverter intValueConverter;
	
	@ValueConverter(rule = "INT")
	public IValueConverter<Integer> INT() {
		return intValueConverter;
	}
	
	@Inject
	private INTValueConverter terminalsIntValueConverter;
	
	/**
	 * @since 2.9
	 */
	@ValueConverter(rule = "org.eclipse.xtext.common.Terminals.INT")
	public IValueConverter<Integer> TerminalsINT() {
		return terminalsIntValueConverter;
	}

	@Inject
	private STRINGValueConverter stringValueConverter;
	
	@ValueConverter(rule = "STRING")
	public IValueConverter<String> STRING() {
		return stringValueConverter;
	}

	@Inject
	private STRINGValueConverter terminalsStringValueConverter;
	
	/**
	 * @since 2.9
	 */
	@ValueConverter(rule = "org.eclipse.xtext.common.Terminals.STRING")
	public IValueConverter<String> TerminalsSTRING() {
		return terminalsStringValueConverter;
	}
}
