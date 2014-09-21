/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.ui;

/**
 * A class used to initialize default preference values.
 */
public class MorelPreferenceInitializer extends org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer {
	
	public void initializeDefaultPreferences() {
		
		initializeDefaultSyntaxHighlighting();
		initializeDefaultBrackets();
		
		org.eclipse.jface.preference.IPreferenceStore store = edu.ustb.sei.mde.morel.resource.morel.ui.MorelUIPlugin.getDefault().getPreferenceStore();
		// Set default value for matching brackets
		store.setDefault(edu.ustb.sei.mde.morel.resource.morel.ui.MorelPreferenceConstants.EDITOR_MATCHING_BRACKETS_COLOR, "192,192,192");
		store.setDefault(edu.ustb.sei.mde.morel.resource.morel.ui.MorelPreferenceConstants.EDITOR_MATCHING_BRACKETS_CHECKBOX, true);
		
	}
	
	private void initializeDefaultBrackets() {
		org.eclipse.jface.preference.IPreferenceStore store = edu.ustb.sei.mde.morel.resource.morel.ui.MorelUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultBrackets(store, new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelMetaInformation());
	}
	
	public void initializeDefaultSyntaxHighlighting() {
		org.eclipse.jface.preference.IPreferenceStore store = edu.ustb.sei.mde.morel.resource.morel.ui.MorelUIPlugin.getDefault().getPreferenceStore();
		initializeDefaultSyntaxHighlighting(store, new edu.ustb.sei.mde.morel.resource.morel.mopp.MorelMetaInformation());
	}
	
	private void initializeDefaultBrackets(org.eclipse.jface.preference.IPreferenceStore store, edu.ustb.sei.mde.morel.resource.morel.IMorelMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		// set default brackets for ITextResource bracket set
		edu.ustb.sei.mde.morel.resource.morel.ui.MorelBracketSet bracketSet = new edu.ustb.sei.mde.morel.resource.morel.ui.MorelBracketSet(null, null);
		final java.util.Collection<edu.ustb.sei.mde.morel.resource.morel.IMorelBracketPair> bracketPairs = metaInformation.getBracketPairs();
		if (bracketPairs != null) {
			for (edu.ustb.sei.mde.morel.resource.morel.IMorelBracketPair bracketPair : bracketPairs) {
				bracketSet.addBracketPair(bracketPair.getOpeningBracket(), bracketPair.getClosingBracket(), bracketPair.isClosingEnabledInside());
			}
		}
		store.setDefault(languageId + edu.ustb.sei.mde.morel.resource.morel.ui.MorelPreferenceConstants.EDITOR_BRACKETS_SUFFIX, bracketSet.getBracketString());
	}
	
	private void initializeDefaultSyntaxHighlighting(org.eclipse.jface.preference.IPreferenceStore store, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelMetaInformation metaInformation) {
		String languageId = metaInformation.getSyntaxName();
		String[] tokenNames = metaInformation.getSyntaxHighlightableTokenNames();
		if (tokenNames == null) {
			return;
		}
		for (int i = 0; i < tokenNames.length; i++) {
			String tokenName = tokenNames[i];
			edu.ustb.sei.mde.morel.resource.morel.IMorelTokenStyle style = metaInformation.getDefaultTokenStyle(tokenName);
			if (style != null) {
				String color = getColorString(style.getColorAsRGB());
				setProperties(store, languageId, tokenName, color, style.isBold(), true, style.isItalic(), style.isStrikethrough(), style.isUnderline());
			} else {
				setProperties(store, languageId, tokenName, "0,0,0", false, false, false, false, false);
			}
		}
	}
	
	private void setProperties(org.eclipse.jface.preference.IPreferenceStore store, String languageID, String tokenName, String color, boolean bold, boolean enable, boolean italic, boolean strikethrough, boolean underline) {
		store.setDefault(edu.ustb.sei.mde.morel.resource.morel.ui.MorelSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.morel.resource.morel.ui.MorelSyntaxColoringHelper.StyleProperty.BOLD), bold);
		store.setDefault(edu.ustb.sei.mde.morel.resource.morel.ui.MorelSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.morel.resource.morel.ui.MorelSyntaxColoringHelper.StyleProperty.COLOR), color);
		store.setDefault(edu.ustb.sei.mde.morel.resource.morel.ui.MorelSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.morel.resource.morel.ui.MorelSyntaxColoringHelper.StyleProperty.ENABLE), enable);
		store.setDefault(edu.ustb.sei.mde.morel.resource.morel.ui.MorelSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.morel.resource.morel.ui.MorelSyntaxColoringHelper.StyleProperty.ITALIC), italic);
		store.setDefault(edu.ustb.sei.mde.morel.resource.morel.ui.MorelSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.morel.resource.morel.ui.MorelSyntaxColoringHelper.StyleProperty.STRIKETHROUGH), strikethrough);
		store.setDefault(edu.ustb.sei.mde.morel.resource.morel.ui.MorelSyntaxColoringHelper.getPreferenceKey(languageID, tokenName, edu.ustb.sei.mde.morel.resource.morel.ui.MorelSyntaxColoringHelper.StyleProperty.UNDERLINE), underline);
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
