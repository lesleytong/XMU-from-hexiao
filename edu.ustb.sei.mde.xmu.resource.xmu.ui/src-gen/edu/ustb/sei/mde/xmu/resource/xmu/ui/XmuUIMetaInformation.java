/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.ui;

public class XmuUIMetaInformation extends edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuMetaInformation {
	
	public edu.ustb.sei.mde.xmu.resource.xmu.IXmuHoverTextProvider getHoverTextProvider() {
		return new edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuHoverTextProvider();
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuImageProvider getImageProvider() {
		return edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuImageProvider.INSTANCE;
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuColorManager createColorManager() {
		return new edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource,
	 * edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuColorManager) instead.
	 */
	public edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuTokenScanner createTokenScanner(edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuTokenScanner createTokenScanner(edu.ustb.sei.mde.xmu.resource.xmu.IXmuTextResource resource, edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuColorManager colorManager) {
		return new edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuTokenScanner(resource, colorManager);
	}
	
	public edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuCodeCompletionHelper createCodeCompletionHelper() {
		return new edu.ustb.sei.mde.xmu.resource.xmu.ui.XmuCodeCompletionHelper();
	}
	
}
