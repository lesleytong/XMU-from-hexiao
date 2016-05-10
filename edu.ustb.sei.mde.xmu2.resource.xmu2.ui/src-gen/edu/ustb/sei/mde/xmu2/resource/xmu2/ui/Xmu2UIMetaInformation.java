/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.ui;

public class Xmu2UIMetaInformation extends edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2MetaInformation {
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2HoverTextProvider getHoverTextProvider() {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2HoverTextProvider();
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2ImageProvider getImageProvider() {
		return edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2ImageProvider.INSTANCE;
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2ColorManager createColorManager() {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2ColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource,
	 * edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2ColorManager) instead.
	 */
	public edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2TokenScanner createTokenScanner(edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2ColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2TokenScanner createTokenScanner(edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource resource, edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2ColorManager colorManager) {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2TokenScanner(resource, colorManager);
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2CodeCompletionHelper createCodeCompletionHelper() {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.ui.Xmu2CodeCompletionHelper();
	}
	
}
