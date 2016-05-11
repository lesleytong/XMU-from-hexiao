/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.launch;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import edu.ustb.sei.mde.modeling.ui.ConsolePrinter;
import edu.ustb.sei.mde.modeling.ui.ConsoleUtil;
import edu.ustb.sei.mde.xmu2.runtime.executor.BackwardModelEnforceInterpreter;
import edu.ustb.sei.mde.xmu2.runtime.executor.ForwardModelEnforceInterpreter;
import edu.ustb.sei.mde.xmu2.runtime.executor.ModelEnforceInterpreter;
import edu.ustb.sei.mde.xmu2.runtime.structures.Environment;
import edu.ustb.sei.mde.xmu2.util.AnalysisUtil;
import edu.ustb.sei.mde.xmu2core.Transformation;


/**
 * A class that provides common methods that are required by launch configuration
 * delegates.
 */
public class Xmu2Launcher extends Xmu2LaunchConfigurationHelper {
	
	private String[] getSourceURI(ILaunchConfiguration configuration) {
		try {
			String str = configuration.getAttribute(Xmu2LaunchConfigurationDelegate.ATTR_SOURCE_URI, (String)null);
			if(str==null) return null;
			
			String[] buf = str.split(" ");
			
			return buf;
		} catch (CoreException e) {
			return null;
		}
	}
	
	private String[] getViewURI(ILaunchConfiguration configuration) {
		try {
			String str = configuration.getAttribute(Xmu2LaunchConfigurationDelegate.ATTR_VIEW_URI, (String)null);
			if(str==null) return null;
			
			String[] buf = str.split(" ");
			return buf;
		} catch (CoreException e) {
			return null;
		}
	}



	private URI getResourceURI(ILaunchConfiguration configuration) {
		try {
			String str = configuration.getAttribute(Xmu2LaunchConfigurationDelegate.ATTR_RESOURCE_URI, (String)null);
			if(str==null) return null;
			return URI.createURI(str);
		} catch (CoreException e) {
			return null;
		}
	}



	public boolean getMode(org.eclipse.debug.core.ILaunchConfiguration configuration) {
		try {
			String attribute = configuration.getAttribute(Xmu2LaunchConfigurationDelegate.ATTR_MODE, 
					Xmu2LaunchConfigurationDelegate.MODE[0]);
			return attribute.equals(Xmu2LaunchConfigurationDelegate.MODE[0]);
		} catch (CoreException e) {
			return true;
		}
	}
	
	/**
	 * Launch an example interpreter that prints object to System.out.
	 */
	public void launch(org.eclipse.debug.core.ILaunchConfiguration configuration, String mode, org.eclipse.debug.core.ILaunch launch, org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
//		org.eclipse.emf.ecore.EObject root = getModelRoot(configuration);
//		// replace this delegate with your actual interpreter
//		SystemOutInterpreter delegate = new SystemOutInterpreter();
//		delegate.addObjectTreeToInterpreteTopDown(root);
//		launchInterpreter(configuration, mode, launch, monitor, delegate, null);

		
		try {
			boolean forward = getMode(configuration);
			URI resourceURI = getResourceURI(configuration);
			URI buildFile = resourceURI.trimFileExtension().appendFileExtension(AnalysisUtil.CORE_EXTENSION);
			
			String[] sourceURI = getSourceURI(configuration);
			String[] viewURI = getViewURI(configuration);
			
			checkAndBuild(resourceURI, buildFile);
			
			
			if(resourceURI == null || sourceURI==null || viewURI==null) return;
			
			ConsoleUtil.clearConsole("XMU2");
			ConsolePrinter printer = ConsoleUtil.getMessageWriter("XMU2");
			
			printer.println("XMU2 is starting");
			
			printer.println("BX Program URI:");
			
			printer.println(resourceURI.toString());
			printer.println(buildFile.toString());
			
			printer.println("BX Program Mode:");
			printer.println(forward?"Forward":"Backward");
			
			printer.println("Source Files:");
			for(String s : sourceURI)
				printer.println(s);
			
			printer.println("View Files:");
			
			for(String s : viewURI)
				printer.println(s);
			
			printer.println();
			
			
			Environment env = null;
			Transformation model = null;
			
			
			
			ModelEnforceInterpreter enforce;
			
			if(forward) {
				env = Environment.createForwardEnvironment(buildFile,sourceURI,viewURI);
				enforce = new ForwardModelEnforceInterpreter();
			}
			else {
				env = Environment.createBackwardEnvironment(buildFile,sourceURI,viewURI);
				enforce = new BackwardModelEnforceInterpreter();
			}
			
			model = env.getTransformation();
			
			env.setPrinter(printer);
			
			
			try {
				enforce.executeTransformation(model, env);
			} catch (Exception e) {
				e.printStackTrace(printer);
			}
			
			printer.println("saving...");
			env.save();
			
			printer.println("Transformation is over.\n");
//			if(forward)
//				env.saveViews();
//			else 
//				env.saveSourcePosts();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void checkAndBuild(URI resourceURI, URI buildFile) {
		
	}
}
