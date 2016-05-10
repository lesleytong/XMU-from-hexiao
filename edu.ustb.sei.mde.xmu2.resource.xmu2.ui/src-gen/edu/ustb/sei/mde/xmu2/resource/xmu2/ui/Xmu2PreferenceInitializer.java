/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.ui;

/**
 * A class used to initialize default preference values.
 */
public class Xmu2PreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2UIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2PreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2PreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2UIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2MetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2UIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2MetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2MetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2BracketSet bracketSet = new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2BracketSet(null, null);
		final java.util.Collection<edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2BracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2BracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2PreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2MetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2SyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2SyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2SyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2SyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2SyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2SyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2SyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
	}
	
	private String getColorString(int[] colorAsRGB) {
		if (colorAsRGB == null) {
			return "0,0,0";
		}
		if (colorAsRGB.length != 3) {
			return "0,0,0";
		}
		return colorAsRGB[0] + "," +colorAsRGB[1] + ","+ colorAsRGB[2];
	}
}
