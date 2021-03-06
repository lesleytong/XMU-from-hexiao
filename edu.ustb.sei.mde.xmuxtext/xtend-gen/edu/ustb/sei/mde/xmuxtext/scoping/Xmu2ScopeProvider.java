/**
 * generated by Xtext 2.10.0
 */
package edu.ustb.sei.mde.xmuxtext.scoping;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import edu.ustb.sei.mde.xmuxtext.customize.common.IReferenceResolver;
import edu.ustb.sei.mde.xmuxtext.customize.common.IResolverRegister;
import edu.ustb.sei.mde.xmuxtext.scoping.AbstractXmu2ScopeProvider;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;

/**
 * This class contains custom scoping description.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#scoping
 * on how and when to use it.
 */
@SuppressWarnings("all")
public class Xmu2ScopeProvider extends AbstractXmu2ScopeProvider {
  @Inject
  private IResolverRegister resolverRegister;
  
  @Override
  public IScope getScope(final EObject context, final EReference reference) {
    IScope _xblockexpression = null;
    {
      IReferenceResolver resolver = this.resolverRegister.getReferenceResolverForScopingService(reference);
      IScope _xifexpression = null;
      boolean _notEquals = (!Objects.equal(resolver, null));
      if (_notEquals) {
        _xifexpression = resolver.getScope(context, reference);
      } else {
        _xifexpression = super.getScope(context, reference);
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
