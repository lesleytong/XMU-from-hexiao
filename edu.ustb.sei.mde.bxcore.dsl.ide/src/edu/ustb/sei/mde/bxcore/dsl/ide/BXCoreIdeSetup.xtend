/*
 * generated by Xtext 2.14.0
 */
package edu.ustb.sei.mde.bxcore.dsl.ide

import com.google.inject.Guice
import edu.ustb.sei.mde.bxcore.dsl.BXCoreRuntimeModule
import edu.ustb.sei.mde.bxcore.dsl.BXCoreStandaloneSetup
import org.eclipse.xtext.util.Modules2

/**
 * Initialization support for running Xtext languages as language servers.
 */
class BXCoreIdeSetup extends BXCoreStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new BXCoreRuntimeModule, new BXCoreIdeModule))
	}
	
}
