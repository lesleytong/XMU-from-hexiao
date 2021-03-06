/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.execution;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import edu.ustb.sei.mde.emg.graph.ModelSpace;
import edu.ustb.sei.mde.emg.runtime.Context;
import edu.ustb.sei.mde.emg.runtime.Environment;
import edu.ustb.sei.mde.emg.runtime.RuntimeFactory;
import edu.ustb.sei.mde.modeling.ui.ConsoleUtil;
//import edu.ustb.sei.mde.morel.BXMode;
//import edu.ustb.sei.mde.morel.BXRewritingModel;
//import edu.ustb.sei.mde.morel.BXRewritingRule;
//import edu.ustb.sei.mde.morel.BxModelAttribute;
//import edu.ustb.sei.mde.morel.BxMorelModel;
//import edu.ustb.sei.mde.morel.BxTypedModel;
import edu.ustb.sei.mde.morel.MorelFactory;
import edu.ustb.sei.mde.morel.PredefinedVariable;
import edu.ustb.sei.mde.morel.PrimitiveVariable;
import edu.ustb.sei.mde.morel.Query;
import edu.ustb.sei.mde.morel.QueryModel;
import edu.ustb.sei.mde.morel.TransformationModel;
import edu.ustb.sei.mde.morel.TypedModel;
import edu.ustb.sei.mde.morel.TypedModelAction;
import edu.ustb.sei.mde.morel.Unit;
import edu.ustb.sei.mde.morel.resource.morel.conversion.SimplifyExpression;
import edu.ustb.sei.mde.morel.resource.morel.execution.primitives.Initialize;
import edu.ustb.sei.mde.morel.resource.morel.execution.primitives.Match;
import edu.ustb.sei.mde.morel.resource.morel.mopp.MorelResource;

/**
 * A class that provides common methods that are required by launch configuration
 * delegates.
 */
public class MorelLaunchConfigurationHelper {
	
	public static final String MOREL_TITLE = "Morel";
	public static class SystemOutInterpreter extends edu.ustb.sei.mde.morel.resource.morel.util.AbstractMorelInterpreter<Void,Void> {
		
		@Override		
		public Void interprete(org.eclipse.emf.ecore.EObject object, Void context) {
			System.out.println("Found " + object + ", but don't know what to do with it.");
			return null;
		}
	}
	
	
	
	/**
	 * Launch an example interpreter that prints object to System.out.
	 */
	public void launch(org.eclipse.debug.core.ILaunchConfiguration configuration, String mode, org.eclipse.debug.core.ILaunch launch, org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.emf.ecore.EObject root = getModelRoot(configuration);
		
		SimplifyExpression.process((MorelResource) root.eResource());
		
		ConsoleUtil.printToConsole("Execute "+root.eResource().getURI(), MOREL_TITLE, true);
		String[] uris = getModelURIs(configuration);
		// replace this delegate with your actual interpreter
		
		Environment env = RuntimeFactory.eINSTANCE.createEnvironment();
		
		initModelSpace(root, uris, env);
		
		
		try {
			Context global = env.createContext();
			Context createContext = env.createContext();
			createContext.setGlobal(global);
			
			PrimitiveVariable var = MorelFactory.eINSTANCE.createPrimitiveVariable();
			var.setName(PredefinedVariable.THIS.getLiteral());
			var.setType(EcorePackage.eINSTANCE.getEJavaObject());
			global.registerVariable(var);
			
			OclInterpreter interpreter = null;
			
//			if(root instanceof BXRewritingModel)
//				interpreter = new BXUpdateInterpreter();
//			else if(root instanceof BxMorelModel)
//			{
//				if(((BxMorelModel) root).getMode()==BXMode.PUT)
//					interpreter = new BxMorelPutInterpreter();
//				else 
//					throw new UnsupportedOperationException();
//			} else
				interpreter = new OclInterpreter();
			
			global.putValue(var, new ModuleProvider((Unit) root, interpreter));
			interpreter.start();
			if(root instanceof QueryModel) {
				interpreter.interprete_edu_ustb_sei_mde_morel_QueryModel((QueryModel) root, createContext);
			} else if(root instanceof TransformationModel) {
//				OclInterpreter interpreter = new OclInterpreter();
				long startTime = Calendar.getInstance().getTimeInMillis();
				interpreter.interprete_edu_ustb_sei_mde_morel_TransformationModel((TransformationModel) root, createContext);
				long endTime = Calendar.getInstance().getTimeInMillis();
				ConsoleUtil.printToConsole("Execute time (ms): "+(endTime-startTime), MOREL_TITLE, true);
				saveModelSpace(root, env);
			} 
//			else if(root instanceof BXRewritingModel) {
////				OclInterpreter interpreter = new OclInterpreter();
//				interpreter.interprete_edu_ustb_sei_mde_morel_BXRewritingModel((BXRewritingModel) root, createContext);
//				saveModelSpace(root, env);
//			} else if(root instanceof BxMorelModel) {
////				OclInterpreter interpreter = new OclInterpreter();
//				interpreter.interprete_edu_ustb_sei_mde_morel_BxMorelModel((BxMorelModel) root, createContext);
//				saveBxModelSpace(root, ((BxMorelModel) root).getMode(), env);
//			} 
			else {
				SystemOutInterpreter delegate = new SystemOutInterpreter();
				delegate.addObjectTreeToInterpreteTopDown(root);
				launchInterpreter(configuration, mode, launch, monitor, delegate, null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	private void saveBxModelSpace(EObject root, BXMode mode, Environment env) {
//		Map<TypedModel, ModelSpace> map = env.getModelSpaces();
//		
//		if(mode==BXMode.GET) {
//			
//		} else {
//			for(Entry<TypedModel,ModelSpace> entry : map.entrySet()) {
//				BxTypedModel m = (BxTypedModel) entry.getKey();
//				
//				if(m.getAttribute()==BxModelAttribute.SOURCE) {
//					entry.getValue().save();
//				}
//			}			
//		}
//	}

	private void saveModelSpace(org.eclipse.emf.ecore.EObject root, Environment env) {
		Map<TypedModel, ModelSpace> map = env.getModelSpaces();
		for(Entry<TypedModel,ModelSpace> entry : map.entrySet()) {
			if(entry.getKey().getType()==TypedModelAction.NORMAL||entry.getKey().getType()==TypedModelAction.CREATE_ONLY)
				entry.getValue().save();
		}
	}
	
	private void registerPackage(EPackage.Registry reg, EPackage pkg) {
		reg.put(pkg.getNsURI(), pkg);
		for(EPackage sp : pkg.getESubpackages())
			registerPackage(reg, sp);
	}

	private void initModelSpace(org.eclipse.emf.ecore.EObject root,
			String[] uris, Environment env) {
		ResourceSet resSet = root.eResource().getResourceSet();
//		resSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
//			    Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		
		Unit queryModel = (Unit) root;
		
		for(TypedModel m : queryModel.getModels()){
//			resSet.getPackageRegistry().put(m.getPackage().getNsURI(), m.getPackage());
			registerPackage(resSet.getPackageRegistry(),m.getPackage());
			
			if(m.getType()==TypedModelAction.TRANSIENT)
				env.getModelSpaces().put(m, env.getModelUniverse().createModelSpace());
		}
		
//		if(uris.length!=queryModel.getModels().size()) {
//			ConsoleUtil.printToConsole("Wrong Model Size", MOREL_TITLE, true);
//			return;
//		} else 
		{
			for(String u : uris) {
				String buf[] = u.split("=");
				if(buf.length!=2) {
					ConsoleUtil.printToConsole("Wrong URI format: "+u,MOREL_TITLE, true);
					return;
				} else {
					TypedModel typedModel = queryModel.getTypedModel(buf[0]);
					if(typedModel==null) {
						ConsoleUtil.printToConsole("Wrong Model Name: "+u,MOREL_TITLE, true);
						return;
					}
					if(typedModel.getType()==TypedModelAction.TRANSIENT) continue;

					Resource res = null;
					URI createURI = org.eclipse.emf.common.util.URI.createURI(buf[1]);
					try {
						if(typedModel.getType()==TypedModelAction.CREATE_ONLY)
							res = resSet.createResource(createURI);
						else 
							res = resSet.getResource(createURI, true);
					} catch (Exception e) {
						res = resSet.createResource(createURI);
					}
					
					ConsoleUtil.printToConsole("Load "+res.getURI(), MOREL_TITLE, true);
					
					ModelSpace space = env.getModelUniverse().createModelSpace();
					space.initWithResource(res, typedModel.getPackage());
					env.getModelSpaces().put(typedModel, space);
				}
			}
		}
	}
	
	
	
	private String[] getModelURIs(ILaunchConfiguration configuration) {
		String[] uris = null;
		try {
			String uri = configuration.getAttribute(edu.ustb.sei.mde.morel.resource.morel.execution.MorelLaunchConfigurationDelegate.ATTR_MODEL_URIS, (String)null);
			uris = uri.split(";");
		} catch (CoreException e) {
		}
		return uris;
	}

	public <ResultType, ContextType> void launchInterpreter(org.eclipse.debug.core.ILaunchConfiguration configuration, String mode, org.eclipse.debug.core.ILaunch launch, org.eclipse.core.runtime.IProgressMonitor monitor, edu.ustb.sei.mde.morel.resource.morel.util.AbstractMorelInterpreter<ResultType, ContextType> delegate, final ContextType context) throws org.eclipse.core.runtime.CoreException {
		final boolean enableDebugger = mode.equals(org.eclipse.debug.core.ILaunchManager.DEBUG_MODE);
		// step 1: find two free ports we can use to communicate between the Eclipse and
		// the interpreter
		int requestPort = findFreePort();
		int eventPort = findFreePort();
		if (requestPort < 0 || eventPort < 0) {
			abort("Unable to find free port", null);
		}
		
		final edu.ustb.sei.mde.morel.resource.morel.debug.MorelDebuggableInterpreter<ResultType, ContextType> interpreter = new edu.ustb.sei.mde.morel.resource.morel.debug.MorelDebuggableInterpreter<ResultType, ContextType>(delegate, eventPort);
		
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
		edu.ustb.sei.mde.morel.resource.morel.debug.MorelDebuggerListener<ResultType, ContextType> debugListener = new edu.ustb.sei.mde.morel.resource.morel.debug.MorelDebuggerListener<ResultType, ContextType>(requestPort);
		debugListener.setDebuggable(interpreter);
		new Thread(debugListener).start();
		
		// step 4: start debugger
		edu.ustb.sei.mde.morel.resource.morel.debug.MorelDebugProcess process = new edu.ustb.sei.mde.morel.resource.morel.debug.MorelDebugProcess(launch);
		launch.addDebugTarget(new edu.ustb.sei.mde.morel.resource.morel.debug.MorelDebugTarget(process, launch, requestPort, eventPort));
	}
	
	public org.eclipse.emf.common.util.URI getURI(org.eclipse.debug.core.ILaunchConfiguration configuration) throws org.eclipse.core.runtime.CoreException {
		return org.eclipse.emf.common.util.URI.createURI(configuration.getAttribute(edu.ustb.sei.mde.morel.resource.morel.execution.MorelLaunchConfigurationDelegate.ATTR_RESOURCE_URI, (String) null));
	}
	
	public org.eclipse.emf.ecore.EObject getModelRoot(org.eclipse.debug.core.ILaunchConfiguration configuration) throws org.eclipse.core.runtime.CoreException {
		return edu.ustb.sei.mde.morel.resource.morel.util.MorelResourceUtil.getResourceContent(getURI(configuration));
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
		throw new org.eclipse.core.runtime.CoreException(new org.eclipse.core.runtime.Status(org.eclipse.core.runtime.IStatus.ERROR, edu.ustb.sei.mde.morel.resource.morel.mopp.MorelPlugin.DEBUG_MODEL_ID, 0, message, e));
	}
}
