/**
 * generated by Xtext 2.10.0
 */
package edu.ustb.sei.mde.xmuxtext.ui.wizard;

import java.io.ByteArrayInputStream;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class Xmu2NewProjectWizardInitialContents {
  public ByteArrayInputStream generateInitialContents(final String newName, final boolean ecore, final String[] importFiles) {
    byte[] _bytes = this.generateInitialContentString(newName, ecore, importFiles).getBytes();
    return new ByteArrayInputStream(_bytes);
  }
  
  public String generateInitialContentString(final String newName, final boolean ecore, final String[] importFiles) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("module ");
    _builder.append(newName);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      if (ecore) {
        _builder.append("// import ecore");
        _builder.newLine();
        _builder.append("import <http://www.eclipse.org/emf/2002/Ecore>");
        _builder.newLine();
      }
    }
    _builder.newLine();
    {
      for(final String str : importFiles) {
        _builder.append("import <");
        _builder.append(str);
        _builder.append(">");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.newLine();
    _builder.append("entry top(source[0], view[0])");
    _builder.newLine();
    _builder.newLine();
    _builder.append("rule top(source sr:Resource, view tr:Resource) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// write your code here");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    String str_1 = _builder.toString();
    return str_1;
  }
}
