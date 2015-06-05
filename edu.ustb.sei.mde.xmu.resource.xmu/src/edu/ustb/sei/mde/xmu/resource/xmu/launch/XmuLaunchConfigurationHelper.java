/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.launch;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.ustb.sei.mde.xmu.*;
import edu.ustb.sei.mde.xmu.resource.xmu.interpret.SafeType;
import edu.ustb.sei.mde.xmu.resource.xmu.interpret.XmuContext;
import edu.ustb.sei.mde.xmu.resource.xmu.interpret.XmuEnvironment;
import edu.ustb.sei.mde.xmu.resource.xmu.interpret.XmuModelBackwardEnforce;
import edu.ustb.sei.mde.xmu.resource.xmu.interpret.XmuModelEnforce;
import edu.ustb.sei.mde.xmu.resource.xmu.interpret.XmuModelForwardEnforce;

/**
 * A class that provides common methods that are required by launch configuration
 * delegates.
 */
public class XmuLaunchConfigurationHelper {
	
	public static class SystemOutInterpreter extends edu.ustb.sei.mde.xmu.resource.xmu.util.AbstractXmuInterpreter<Void,Void> {
		
		@Override		
		public Void interprete(org.eclipse.emf.ecore.EObject object, Void context) {
			System.out.println("Found " + object + ", but don't know what to do with it.");
			return null;
		}
	}
	
	//private ResourceSet resourceSet; 
	
	public XmuLaunchConfigurationHelper() {
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
			List<URI> sourceURI = getSourceURI(configuration);
			List<URI> viewURI = getViewURI(configuration);
			
			if(resourceURI == null || sourceURI==null || viewURI==null) return;
			
			XmuEnvironment env = null;
			XMUModel model = null;
			XmuContext base = null;
			XmuModelEnforce enforce;
			
			if(forward) {
				env = XmuEnvironment.createForwardEnvironment();
				model = env.loadSpecification(resourceURI);
				env.loadSources(sourceURI.toArray(new URI[]{}));
				env.createViews(viewURI.toArray(new URI[]{}));
				enforce = new XmuModelForwardEnforce();
			}
			else {
				env = XmuEnvironment.createBackwardEnvironment();
				model = env.loadSpecification(resourceURI);
				env.loadSources(sourceURI.toArray(new URI[]{}));
				env.loadViews(viewURI.toArray(new URI[]{}));
				env.createSourcePost();
				enforce = new XmuModelBackwardEnforce();
			}
			
			base = new XmuContext(env);
			
			for(InitialMappingStatement s : model.getInitialMappings()) {
				enforce.interprete(s, base);
			}
			
			for(HelperMapping s : model.getHelperMappings()) {
				enforce.interprete(s, base);
			}
			
			for(StartStatement ss : model.getStart()) {
				SafeType ret = enforce.interprete_edu_ustb_sei_mde_xmu_StartStatement(ss, base);
				if(ret.getValue()!=Boolean.TRUE) {
					System.out.println(ret);
					return;
				}
			}
			
			if(forward)
				env.saveViews();
			else 
				env.saveSourcePosts();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private List<URI> getSourceURI(ILaunchConfiguration configuration) {
		try {
			String str = configuration.getAttribute(XmuLaunchConfigurationDelegate.ATTR_SOURCE_URI, (String)null);
			if(str==null) return null;
			
			String[] buf = str.split(" ");
			ArrayList<URI> l = new ArrayList<URI>();
			
			for(String s : buf) {
				l.add(URI.createURI(s));
			}
			
			return l;
		} catch (CoreException e) {
			return null;
		}
	}
	
	private List<URI> getViewURI(ILaunchConfiguration configuration) {
		try {
			String str = configuration.getAttribute(XmuLaunchConfigurationDelegate.ATTR_VIEW_URI, (String)null);
			if(str==null) return null;
			
			String[] buf = str.split(" ");
			ArrayList<URI> l = new ArrayList<URI>();
			
			for(String s : buf) {
				l.add(URI.createURI(s));
			}
			
			return l;
		} catch (CoreException e) {
			return null;
		}
	}



	private URI getResourceURI(ILaunchConfiguration configuration) {
		try {
			String str = configuration.getAttribute(XmuLaunchConfigurationDelegate.ATTR_RESOURCE_URI, (String)null);
			if(str==null) return null;
			return URI.createURI(str);
		} catch (CoreException e) {
			return null;
		}
	}



	public boolean getMode(org.eclipse.debug.core.ILaunchConfiguration configuration) {
		try {
			String attribute = configuration.getAttribute(XmuLaunchConfigurationDelegate.ATTR_MODE, 
					XmuLaunchConfigurationDelegate.MODE[0]);
			return attribute.equals(XmuLaunchConfigurationDelegate.MODE[0]);
		} catch (CoreException e) {
			return true;
		}
	}
	
	public <ResultType, ContextType> void launchInterpreter(org.eclipse.debug.core.ILaunchConfiguration configuration, String mode, org.eclipse.debug.core.ILaunch launch, org.eclipse.core.runtime.IProgressMonitor monitor, edu.ustb.sei.mde.xmu.resource.xmu.util.AbstractXmuInterpreter<ResultType, ContextType> delegate, final ContextType context) throws org.eclipse.core.runtime.CoreException {
		final boolean enableDebugger = mode.equals(org.eclipse.debug.core.ILaunchManager.DEBUG_MODE);
		// step 1: find two free ports we can use to communicate between the Eclipse and
		// the interpreter
		int requestPort = findFreePort();
		int eventPort = findFreePort();
		if (requestPort < 0 || eventPort < 0) {
			abort("Unable to find free port", null);
		}
		
		final edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebuggableInterpreter<ResultType, ContextType> interpreter = new edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebuggableInterpreter<ResultType, ContextType>(delegate, eventPort);
		
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
		edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebuggerListener<ResultType, ContextType> debugListener = new edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebuggerListener<ResultType, ContextType>(requestPort);
		debugListener.setDebuggable(interpreter);
		new Thread(debugListener).start();
		
		// step 4: start debugger
		edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugProcess process = new edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugProcess(launch);
		launch.addDebugTarget(new edu.ustb.sei.mde.xmu.resource.xmu.debug.XmuDebugTarget(process, launch, requestPort, eventPort));
	}
	
	public org.eclipse.emf.common.util.URI getURI(org.eclipse.debug.core.ILaunchConfiguration configuration) throws org.eclipse.core.runtime.CoreException {
		return org.eclipse.emf.common.util.URI.createURI(configuration.getAttribute(edu.ustb.sei.mde.xmu.resource.xmu.launch.XmuLaunchConfigurationDelegate.ATTR_RESOURCE_URI, (String) null));
	}
	
	public org.eclipse.emf.ecore.EObject getModelRoot(org.eclipse.debug.core.ILaunchConfiguration configuration) throws org.eclipse.core.runtime.CoreException {
		return edu.ustb.sei.mde.xmu.resource.xmu.util.XmuResourceUtil.getResourceContent(getURI(configuration));
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
		throw new org.eclipse.core.runtime.CoreException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuPlugin.DEBUG_MODEL_ID, 0, message, e));
	}
}
