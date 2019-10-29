/*
 * generated by Xtext 2.10.0
 */
package edu.ustb.sei.mde.xmuxtext

import edu.ustb.sei.mde.xmuxtext.customize.impl.Xmu2ResolverRegister
import edu.ustb.sei.mde.xmuxtext.customize.impl.Xmu2LinkingService
import edu.ustb.sei.mde.xmuxtext.customize.impl.Xmu2ValueConverterService
import com.google.inject.Binder
import edu.ustb.sei.mde.xmuxtext.customize.common.IResolverRegister
import org.eclipse.xtext.naming.IQualifiedNameConverter
import edu.ustb.sei.mde.xmuxtext.customize.impl.Xmu2QualifiedNameConverter
import org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer
import edu.ustb.sei.mde.xmuxtext.customize.common.DefaultCrossReferenceSerializer
import edu.ustb.sei.mde.xmuxtext.customize.impl.ModelURIConverter
import edu.ustb.sei.mde.xmuxtext.customize.common.BOOLValueConverter

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class Xmu2RuntimeModule extends AbstractXmu2RuntimeModule {
	def configureIResolverRegister(Binder binder) {
		binder.bind(IResolverRegister).to(Xmu2ResolverRegister)
	}
	
	override bindILinkingService() {
		Xmu2LinkingService
	}
	
	override bindIValueConverterService() {
		Xmu2ValueConverterService
	}
	
	def configureIQualifiedNameConverter(Binder binder) {
		binder.bind(IQualifiedNameConverter).to(Xmu2QualifiedNameConverter)
	}
	
	def configureCrossReferenceSerializer(Binder binder) {
		binder.bind(ICrossReferenceSerializer).to(DefaultCrossReferenceSerializer)	
	}
	
//	def configureValueConverter(Binder binder) {
//		binder.bind(ModelURIConverter).to(ModelURIConverter);
//		binder.bind(BOOLValueConverter).to(BOOLValueConverter);
//	}
	
}
