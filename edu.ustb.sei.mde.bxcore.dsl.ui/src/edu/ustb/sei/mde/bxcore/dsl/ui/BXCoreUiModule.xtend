/*
 * generated by Xtext 2.14.0
 */
package edu.ustb.sei.mde.bxcore.dsl.ui

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import edu.ustb.sei.mde.bxcore.dsl.ui.labeling.BXCoreHoverProvider

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
class BXCoreUiModule extends AbstractBXCoreUiModule {
	
	override bindIEObjectHoverProvider() {
		BXCoreHoverProvider
	}
	
}
