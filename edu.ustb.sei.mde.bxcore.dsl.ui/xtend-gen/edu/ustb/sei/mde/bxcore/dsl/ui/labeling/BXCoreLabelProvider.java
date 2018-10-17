/**
 * generated by Xtext 2.14.0
 */
package edu.ustb.sei.mde.bxcore.dsl.ui.labeling;

import com.google.inject.Inject;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXFunctionDefinition;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BXProgram;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.BiGULStatement;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextAwareCondition;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ContextAwareUnidirectionalAction;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.ImportSection;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.IndexDefinition;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.PatternDefinition;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.TypeDefinition;
import edu.ustb.sei.mde.bxcore.dsl.bXCore.XmuCoreStatement;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.xtext.xbase.ui.labeling.XbaseLabelProvider;

/**
 * Provides labels for EObjects.
 * 
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#label-provider
 */
@SuppressWarnings("all")
public class BXCoreLabelProvider extends XbaseLabelProvider {
  @Inject
  public BXCoreLabelProvider(final AdapterFactoryLabelProvider delegate) {
    super(delegate);
  }
  
  public String text(final BXProgram p) {
    String _lastSegment = p.eResource().getURI().lastSegment();
    return ("Program " + _lastSegment);
  }
  
  public String text(final ImportSection i) {
    String _shortName = i.getShortName();
    return ("Load " + _shortName);
  }
  
  public String text(final TypeDefinition e) {
    String _name = e.getName();
    return ("Type " + _name);
  }
  
  public String text(final PatternDefinition e) {
    String _xifexpression = null;
    String _name = e.getName();
    boolean _tripleEquals = (_name == null);
    if (_tripleEquals) {
      _xifexpression = "Pattern (Unnamed)";
    } else {
      String _name_1 = e.getName();
      _xifexpression = ("Pattern " + _name_1);
    }
    return _xifexpression;
  }
  
  public String text(final BXFunctionDefinition e) {
    String _name = e.getName();
    return ("Function " + _name);
  }
  
  public String text(final IndexDefinition e) {
    String _name = e.getName();
    return ("Index " + _name);
  }
  
  public String text(final XmuCoreStatement e) {
    return e.eClass().getName();
  }
  
  public String text(final BiGULStatement e) {
    return e.eClass().getName();
  }
  
  public String text(final ContextAwareCondition e) {
    return "Condition";
  }
  
  public String text(final ContextAwareUnidirectionalAction e) {
    return "Unidirectional Action";
  }
}
