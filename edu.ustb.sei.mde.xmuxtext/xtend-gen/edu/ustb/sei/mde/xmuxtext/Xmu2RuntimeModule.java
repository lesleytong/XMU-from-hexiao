/**
 * generated by Xtext 2.10.0
 */
package edu.ustb.sei.mde.xmuxtext;

import com.google.inject.Binder;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import edu.ustb.sei.mde.xmuxtext.AbstractXmu2RuntimeModule;
import edu.ustb.sei.mde.xmuxtext.customize.common.DefaultCrossReferenceSerializer;
import edu.ustb.sei.mde.xmuxtext.customize.common.IResolverRegister;
import edu.ustb.sei.mde.xmuxtext.customize.impl.Xmu2LinkingService;
import edu.ustb.sei.mde.xmuxtext.customize.impl.Xmu2QualifiedNameConverter;
import edu.ustb.sei.mde.xmuxtext.customize.impl.Xmu2ResolverRegister;
import edu.ustb.sei.mde.xmuxtext.customize.impl.Xmu2ValueConverterService;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.linking.ILinkingService;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("all")
public class Xmu2RuntimeModule extends AbstractXmu2RuntimeModule {
  public ScopedBindingBuilder configureIResolverRegister(final Binder binder) {
    AnnotatedBindingBuilder<IResolverRegister> _bind = binder.<IResolverRegister>bind(IResolverRegister.class);
    return _bind.to(Xmu2ResolverRegister.class);
  }
  
  @Override
  public Class<? extends ILinkingService> bindILinkingService() {
    return Xmu2LinkingService.class;
  }
  
  @Override
  public Class<? extends IValueConverterService> bindIValueConverterService() {
    return Xmu2ValueConverterService.class;
  }
  
  public ScopedBindingBuilder configureIQualifiedNameConverter(final Binder binder) {
    AnnotatedBindingBuilder<IQualifiedNameConverter> _bind = binder.<IQualifiedNameConverter>bind(IQualifiedNameConverter.class);
    return _bind.to(Xmu2QualifiedNameConverter.class);
  }
  
  public ScopedBindingBuilder configureCrossReferenceSerializer(final Binder binder) {
    AnnotatedBindingBuilder<ICrossReferenceSerializer> _bind = binder.<ICrossReferenceSerializer>bind(ICrossReferenceSerializer.class);
    return _bind.to(DefaultCrossReferenceSerializer.class);
  }
}