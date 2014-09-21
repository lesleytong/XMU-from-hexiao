/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.ui;

public class MorelUIMetaInformation extends edu.ustb.sei.mde.morel.resource.morel.mopp.MorelMetaInformation {
	
	public edu.ustb.sei.mde.morel.resource.morel.IMorelHoverTextProvider getHoverTextProvider() {
		return new edu.ustb.sei.mde.morel.resource.morel.ui.MorelHoverTextProvider();
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.ui.MorelImageProvider getImageProvider() {
		return edu.ustb.sei.mde.morel.resource.morel.ui.MorelImageProvider.INSTANCE;
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.ui.MorelColorManager createColorManager() {
		return new edu.ustb.sei.mde.morel.resource.morel.ui.MorelColorManager();
	}
	
	/**
	 * @deprecated this method is only provided to preserve API compatibility. Use
	 * createTokenScanner(edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource,
	 * edu.ustb.sei.mde.morel.resource.morel.ui.MorelColorManager) instead.
	 */
	public edu.ustb.sei.mde.morel.resource.morel.ui.MorelTokenScanner createTokenScanner(edu.ustb.sei.mde.morel.resource.morel.ui.MorelColorManager colorManager) {
		return createTokenScanner(null, colorManager);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.ui.MorelTokenScanner createTokenScanner(edu.ustb.sei.mde.morel.resource.morel.IMorelTextResource resource, edu.ustb.sei.mde.morel.resource.morel.ui.MorelColorManager colorManager) {
		return new edu.ustb.sei.mde.morel.resource.morel.ui.MorelTokenScanner(resource, colorManager);
	}
	
	public edu.ustb.sei.mde.morel.resource.morel.ui.MorelCodeCompletionHelper createCodeCompletionHelper() {
		return new edu.ustb.sei.mde.morel.resource.morel.ui.MorelCodeCompletionHelper();
	}
	
}
