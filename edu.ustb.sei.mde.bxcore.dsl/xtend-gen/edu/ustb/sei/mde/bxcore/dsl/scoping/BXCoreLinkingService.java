package edu.ustb.sei.mde.bxcore.dsl.scoping;

import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXCorePackage;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class BXCoreLinkingService extends DefaultLinkingService {
  @Override
  public List<EObject> getLinkedObjects(final EObject context, final EReference ref, final INode node) throws IllegalNodeException {
    if ((ref == BXCorePackage.Literals.IMPORT_SECTION__METAMODEL)) {
      InputOutput.<String>println("in linking metamodel");
      try {
        final String uri = this.getCrossRefNodeAsString(node);
        final IScope scope = this.getScope(context, ref);
        Iterable<IEObjectDescription> _allElements = scope.getAllElements();
        for (final IEObjectDescription d : _allElements) {
          boolean _equals = d.getQualifiedName().getFirstSegment().equals(uri);
          if (_equals) {
            InputOutput.<String>println("out linking metamodel");
            return Collections.<EObject>singletonList(d.getEObjectOrProxy());
          }
        }
        final EPackage p = EcoreUtil2.loadEPackage(uri, this.getClass().getClassLoader());
        if ((p != null)) {
          InputOutput.<String>println("out linking metamodel");
          return Collections.<EObject>singletonList(p);
        }
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          InputOutput.<String>println("out linking metamodel");
          return Collections.<EObject>emptyList();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } else {
      return super.getLinkedObjects(context, ref, node);
    }
    return null;
  }
}
