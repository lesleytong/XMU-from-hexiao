/*
 * generated by Xtext 2.10.0
 */
package edu.ustb.sei.mde.xmuxtext.ui

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import com.google.inject.Binder
import edu.ustb.sei.mde.xmuxtext.ui.customize.Xmu2HighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration
import edu.ustb.sei.mde.xmuxtext.ui.customize.Xmu2AntlrTokenToAttributeIdMapper
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
class Xmu2UiModule extends AbstractXmu2UiModule {
	def configureIHighlightingConfiguration(Binder binder) {
		binder.bind(IHighlightingConfiguration).to(Xmu2HighlightingConfiguration)
	}
	def configureAbstractAntlrTokenToAttributeIdMapper(Binder binder) {
		binder.bind(AbstractAntlrTokenToAttributeIdMapper).to(Xmu2AntlrTokenToAttributeIdMapper)
	}
	
}
