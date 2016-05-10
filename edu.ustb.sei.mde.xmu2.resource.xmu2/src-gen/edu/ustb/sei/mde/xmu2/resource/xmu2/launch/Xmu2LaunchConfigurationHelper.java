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
public class Xmu2LaunchConfigurationHelper {
	
	public static class SystemOutInterpreter extends edu.ustb.sei.mde.xmu2.resource.xmu2.util.AbstractXmu2Interpreter<Void,Void> {
		
		@Override		
		public Void interprete(org.eclipse.emf.ecore.EObject object, Void context) {
			System.out.println("Found " + object + ", but don't know what to do with it.");
			return null;
		}
	}
	
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
			
			env.save();
			
			printer.println("Transformation is over");
			
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

	public <ResultType, ContextType> void launchInterpreter(org.eclipse.debug.core.ILaunchConfiguration configuration, String mode, org.eclipse.debug.core.ILaunch launch, org.eclipse.core.runtime.IProgressMonitor monitor, edu.ustb.sei.mde.xmu2.resource.xmu2.util.AbstractXmu2Interpreter<ResultType, ContextType> delegate, final ContextType context) throws org.eclipse.core.runtime.CoreException {
		final boolean enableDebugger = mode.equals(org.eclipse.debug.core.ILaunchManager.DEBUG_MODE);
		// step 1: find two free ports we can use to communicate between the Eclipse and
		// the interpreter
		int requestPort = findFreePort();
		int eventPort = findFreePort();
		if (requestPort < 0 || eventPort < 0) {
			abort("Unable to find free port", null);
		}
		
		final edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebuggableInterpreter<ResultType, ContextType> interpreter = new edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebuggableInterpreter<ResultType, ContextType>(delegate, eventPort);
		
		// step 2: prepare and start interpreter in separate thread
		Thread interpreterThread = new Thread(new Runnable() {
			
			public void run() {
				// if we are in debug mode, the interpreter must wait for the debugger to attach
				interpreter.interprete(context, enableDebugger);
			}
		});
		interpreterThread.start();
		
		// step 3: start debugger listener (sends commands from Eclipse debug framework to
		// running process
		edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebuggerListener<ResultType, ContextType> debugListener = new edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebuggerListener<ResultType, ContextType>(requestPort);
		debugListener.setDebuggable(interpreter);
		new Thread(debugListener).start();
		
		// step 4: start debugger
		edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugProcess process = new edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugProcess(launch);
		launch.addDebugTarget(new edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugTarget(process, launch, requestPort, eventPort));
	}
	
	public org.eclipse.emf.common.util.URI getURI(org.eclipse.debug.core.ILaunchConfiguration configuration) throws org.eclipse.core.runtime.CoreException {
		return org.eclipse.emf.common.util.URI.createURI(configuration.getAttribute(edu.ustb.sei.mde.xmu2.resource.xmu2.launch.Xmu2LaunchConfigurationDelegate.ATTR_RESOURCE_URI, (String) null));
	}
	
	public org.eclipse.emf.ecore.EObject getModelRoot(org.eclipse.debug.core.ILaunchConfiguration configuration) throws org.eclipse.core.runtime.CoreException {
		return edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2ResourceUtil.getResourceContent(getURI(configuration));
	}
	
	/**
	 * Returns a free port number on localhost, or -1 if unable to find a free port.
	 */
	protected int findFreePort() {
		java.net.ServerSocket socket = null;
		try {
			socket = new java.net.ServerSocket(0);
			return socket.getLocalPort();
		} catch (java.io.IOException e) {
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (java.io.IOException e) {
				}
			}
		}
		return -1;
	}
	/**
	 * Throws an exception with a new status containing the given message and optional
	 * exception.
	 * 
	 * @param message error message
	 * @param e underlying exception
	 * 
	 * @throws CoreException
	 */
	protected void abort(String message, Throwable e) throws org.eclipse.core.runtime.CoreException {
		throw new org.eclipse.core.runtime.CoreException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Plugin.DEBUG_MODEL_ID, 0, message, e));
	}
}
