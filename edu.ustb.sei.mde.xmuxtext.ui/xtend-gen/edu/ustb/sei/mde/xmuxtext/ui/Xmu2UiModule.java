/**
 * generated by Xtext 2.10.0
 */
package edu.ustb.sei.mde.xmuxtext.ui;

import com.google.inject.Binder;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import edu.ustb.sei.mde.xmuxtext.ui.AbstractXmu2UiModule;
import edu.ustb.sei.mde.xmuxtext.ui.customize.Xmu2AntlrTokenToAttributeIdMapper;
import edu.ustb.sei.mde.xmuxtext.ui.customize.Xmu2HighlightingConfiguration;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class Xmu2UiModule extends AbstractXmu2UiModule {
  public ScopedBindingBuilder configureIHighlightingConfiguration(final Binder binder) {
    AnnotatedBindingBuilder<IHighlightingConfiguration> _bind = binder.<IHighlightingConfiguration>bind(IHighlightingConfiguration.class);
    return _bind.to(Xmu2HighlightingConfiguration.class);
  }
  
  public ScopedBindingBuilder configureAbstractAntlrTokenToAttributeIdMapper(final Binder binder) {
    AnnotatedBindingBuilder<AbstractAntlrTokenToAttributeIdMapper> _bind = binder.<AbstractAntlrTokenToAttributeIdMapper>bind(AbstractAntlrTokenToAttributeIdMapper.class);
    return _bind.to(Xmu2AntlrTokenToAttributeIdMapper.class);
  }
  
  public Xmu2UiModule(final AbstractUIPlugin plugin) {
    super(plugin);
  }
}
