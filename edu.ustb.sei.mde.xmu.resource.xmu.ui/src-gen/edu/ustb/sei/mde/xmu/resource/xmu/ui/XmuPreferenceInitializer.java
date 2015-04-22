/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.ui;

/**
 * A class used to initialize default preference values.
 */
public class XmuPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, edu.ustb.sei.mde.xmu.resource.xmu.IXmuMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuBracketSet bracketSet = new edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuBracketSet(null, null);
		final java.util.Collection<edu.ustb.sei.mde.xmu.resource.xmu.IXmuBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (edu.ustb.sei.mde.xmu.resource.xmu.IXmuBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			edu.ustb.sei.mde.xmu.resource.xmu.IXmuTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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
