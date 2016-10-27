/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.launch;

import java.io.File;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import edu.ustb.sei.mde.modeling.ui.ConsolePrinter;
import edu.ustb.sei.mde.modeling.ui.ConsoleUtil;
import edu.ustb.sei.mde.xmu2.runtime.executor.AbstractInterpreter;
import edu.ustb.sei.mde.xmu2.runtime.executor.BackwardModelEnforceInterpreter;
import edu.ustb.sei.mde.xmu2.runtime.executor.ForwardModelEnforceInterpreter;
import edu.ustb.sei.mde.xmu2.runtime.executor.ModelEnforceInterpreter;
import edu.ustb.sei.mde.xmu2.runtime.structures.CommandBasedEnvironment;
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
	
	public int getEnvType(org.eclipse.debug.core.ILaunchConfiguration configuration) {
		try {
			String attribute = configuration.getAttribute(Xmu2LaunchConfigurationDelegate.ATTR_ENVTYPE, 
					Xmu2LaunchConfigurationDelegate.ENVTYPE[0]);
			int i = 0;
			for(String str : Xmu2LaunchConfigurationDelegate.ENVTYPE) {
				if(str.equals(attribute))
					return i;
				i++;
			}
			return 0;
		} catch(Exception e) {
			return 0;
		}
	}
	
	
	
	/**
	 * Launch an example interpreter that prints object to System.out.
	 */
	public void launch(org.eclipse.debug.core.ILaunchConfiguration configuration, String mode, org.eclipse.debug.core.ILaunch launch, org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		Runnable monitorThread = new Runnable() {
			
			@Override
			public void run() {
				Runnable executor = new Runnable() {
					public void run() {
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
							printer.println();
							
							printer.println("BX Program URI:");
							
							printer.println(resourceURI.toString());
							printer.println(buildFile.toString());
							
							printer.print("BX Program Mode: ");
							printer.println(forward?"Forward":"Backward");
							
							printer.println("Source Files:");
							for(String s : sourceURI)
								printer.println(s);
							
							printer.println("View Files:");
							
							for(String s : viewURI)
								printer.println(s);
							
							
							
							
							Environment env = null;
							Transformation model = null;
							
							
							
							ModelEnforceInterpreter enforce;
							
							int envType = getEnvType(configuration);
							printer.print("Environment Type: ");
							printer.println(Xmu2LaunchConfigurationDelegate.ENVTYPE[envType]);
							printer.println();
							
							
							if(forward) {
								env = createForwardEnvironment(buildFile, sourceURI, viewURI, envType);
								enforce = AbstractInterpreter.FORWARD_ENFORCE;
							}
							else {
								env = createBackwardEnvironment(buildFile, sourceURI, viewURI, envType);
								enforce = AbstractInterpreter.BACKWARD_ENFORCE;
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

						}catch(Exception e) {
							e.printStackTrace();
						}
						
					}
				};
				
				Thread executorThread = new Thread(executor);
				executorThread.start();
				
				while(monitor.isCanceled()==false) {
					try {
						Thread.sleep(1000);
					} catch(Exception e) {
					}
				}
				
				executorThread.stop();
				System.out.println("Transformation is over.\n");
			}
		}; 
		
		Thread core = new Thread(monitorThread);
		
		core.start();
		
//		int requestPort = findFreePort();
//		int eventPort = findFreePort();
//		if (requestPort < 0 || eventPort < 0) {
//			abort("Unable to find free port", null);
//		}
//		
//		
////		edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebuggerListener<ResultType, ContextType> debugListener = new edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebuggerListener<ResultType, ContextType>(requestPort);
////		debugListener.setDebuggable(interpreter);
////		new Thread(debugListener).start();
		Xmu2InternalProcess process = new Xmu2InternalProcess(launch, core);
		launch.addProcess(process);
		
//		.addDebugTarget(new edu.ustb.sei.mde.xmu2.resource.xmu2.debug.Xmu2DebugTarget(process, launch, requestPort, eventPort));
		
	}
	
	private void checkAndBuild(URI resourceURI, URI buildFile) {
		
	}

	protected Environment createForwardEnvironment(URI buildFile, String[] sourceURI, String[] viewURI, int type) {
		
		Environment env;
		switch(type) {
		case 0:
			env = Environment.createForwardEnvironment(buildFile,sourceURI,viewURI);
			break;
		case 1:
			env = CommandBasedEnvironment.createForwardEnvironment(buildFile, sourceURI, viewURI);
			break;
		default:
			env = Environment.createForwardEnvironment(buildFile,sourceURI,viewURI);
			break;
		}
		return env;
	}

	protected Environment createBackwardEnvironment(URI buildFile, String[] sourceURI, String[] viewURI, int type) {
		Environment env;
		
		switch(type) {
		case 0:
			env = Environment.createBackwardEnvironment(buildFile,sourceURI,viewURI);
			break;
		case 1:
			env = CommandBasedEnvironment.createBackwardEnvironment(buildFile, sourceURI, viewURI);
			break;
		default:
			env = Environment.createBackwardEnvironment(buildFile,sourceURI,viewURI);
			break;
		}
		return env;
	}
	
	class Xmu2InternalProcess implements IProcess {
		
		
		private org.eclipse.debug.core.ILaunch launch;
		public Xmu2InternalProcess(ILaunch launch, Thread coreThread) {
			super();
			this.launch = launch;
			this.coreThread = coreThread;
		}

		private Thread coreThread;
		
		@Override
		public <T> T getAdapter(Class<T> adapter) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean canTerminate() {
			return false;
		}

		@Override
		public boolean isTerminated() {
			return coreThread.isAlive();
		}

		@Override
		public void terminate() throws DebugException {
		}

		@Override
		public String getLabel() {
			return "XMU2";
		}

		@Override
		public ILaunch getLaunch() {
			return launch;
		}

		@Override
		public IStreamsProxy getStreamsProxy() {
			return null;
		}

		@Override
		public void setAttribute(String key, String value) {
		}

		@Override
		public String getAttribute(String key) {
			return null;
		}

		@Override
		public int getExitValue() throws DebugException {
			return 0;
		}
		
	}
}
