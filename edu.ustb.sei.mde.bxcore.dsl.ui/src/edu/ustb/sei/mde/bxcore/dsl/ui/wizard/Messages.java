package edu.ustb.sei.mde.bxcore.dsl.ui.wizard;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "edu.ustb.sei.mde.bxcore.dsl.ui.wizard.messages"; //$NON-NLS-1$
	
	public static String HelloWorldFile_Label;
	public static String HelloWorldFile_Description;
	public static String HelloWorldProject_Label;
	public static String HelloWorldProject_Description;
	public static String SimpleBXProject_Label;
	public static String SimpleBXProject_Description;
	public static String SimpleBXFile_Label;
	public static String SimpleBXFile_Description;
	
	static {
	// initialize resource bundle
	NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
