/**
 * generated by Xtext 2.14.0
 */
package edu.ustb.sei.mde.bxcore.dsl.ui.wizard;

import edu.ustb.sei.mde.bxcore.dsl.ui.wizard.SimpleBXProject;
import org.eclipse.xtext.ui.wizard.template.AbstractProjectTemplate;
import org.eclipse.xtext.ui.wizard.template.IProjectTemplateProvider;

/**
 * Create a list with all project templates to be shown in the template new project wizard.
 * 
 * Each template is able to generate one or more projects. Each project can be configured such that any number of files are included.
 */
@SuppressWarnings("all")
public class BXCoreProjectTemplateProvider implements IProjectTemplateProvider {
  @Override
  public AbstractProjectTemplate[] getProjectTemplates() {
    SimpleBXProject _simpleBXProject = new SimpleBXProject();
    return new AbstractProjectTemplate[] { _simpleBXProject };
  }
}
