/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.debug;

/**
 * A DebuggableInterpreter is a facade for interpreters that adds debug support.
 * 
 * @param <ResultType> the result type of the actual interpreter
 * @param <ContextType> the context type of the actual interpreter
 */
public class Xmu2DebuggableInterpreter<ResultType, ContextType> extends edu.ustb.sei.mde.xmu2.resource.xmu2.debug.AbstractXmu2Debuggable {
	
	/**
	 * The actual interpreter. Interpretation is delegated to this object.
	 */
	private edu.ustb.sei.mde.xmu2.resource.xmu2.util.AbstractXmu2Interpreter<ResultType, ContextType> interpreterDelegate;
	
	/**
	 * To check whether we must stop the execution after step over/into/return, we use
	 * a closure
	 */
	private edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Command<org.eclipse.emf.ecore.EObject> stopCondition;
	
	/**
	 * The port of the socket that is used to send debug events to the Eclipse
	 * debugging framework
	 */
	private int eventPort;
	
	/**
	 * This map is used to remember the IDs of stack frame elements
	 */
	java.util.Map<Integer, org.eclipse.emf.ecore.EObject> stackFrameMap = new java.util.LinkedHashMap<Integer, org.eclipse.emf.ecore.EObject>();
	
	/**
	 * The ID of the last stack frame element
	 */
	int stackFrameID = 0;
	
	public Xmu2DebuggableInterpreter(edu.ustb.sei.mde.xmu2.resource.xmu2.util.AbstractXmu2Interpreter<ResultType, ContextType> interpreterDelegate, int eventPort) {
		this.eventPort = eventPort;
		this.interpreterDelegate = interpreterDelegate;
		this.interpreterDelegate.addListener(new edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2InterpreterListener() {
			
			public void handleInterpreteObject(org.eclipse.emf.ecore.EObject element) {
				// check whether we have hit an element after a step over/into/return
				evaluateStep(element);
				// if we are stepping we do ignore breakpoints
				if (stopCondition != null) {
					return;
				}
				// check whether we have hit a line breakpoint
				int line = getLine(element);
				org.eclipse.emf.ecore.EObject parent = element.eContainer();
				if (parent != null) {
					int parentLine = getLine(parent);
					if (line == parentLine) {
						return;
					}
				}
				if (line >= 0) {
					evaluateLineBreakpoint(element.eResource().getURI(), line);
				}
			}
		});
	}
	
	private ResultType interprete(ContextType context) {
		startUpAndWait();
		// start interpretation when the debugger has sent the resume signal
		ResultType result = interpreterDelegate.interprete(context);
		terminate();
		return result;
	}
	
	public ResultType interprete(ContextType context, boolean debugMode) {
		setDebugMode(debugMode);
		startEventSocket(eventPort);
		
		ResultType result = interprete(context);
		return result;
	}
	
	public String[] getStack() {
		org.eclipse.emf.ecore.EObject next = interpreterDelegate.getNextObjectToInterprete();
		java.util.List<org.eclipse.emf.ecore.EObject> parents = new java.util.ArrayList<org.eclipse.emf.ecore.EObject>();
		org.eclipse.emf.ecore.EObject current = next;
		while (current != null) {
			parents.add(current);
			current = current.eContainer();
		}
		String[] stack = new String[parents.size()];
		int i = parents.size();
		for (org.eclipse.emf.ecore.EObject parent : parents) {
			String serializedStackElement = edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2StringUtil.encode(',', new String[] {parent.eClass().getName(), Integer.toString(stackFrameID), parent.eResource().getURI().toString(), Integer.toString(getLine(parent)), Integer.toString(getCharStart(parent)), Integer.toString(getCharEnd(parent))});
			stack[--i] = serializedStackElement;
			stackFrameMap.put(stackFrameID++, parent);
		}
		return stack;
	}
	
	public edu.ustb.sei.mde.xmu2.resource.xmu2.util.AbstractXmu2Interpreter<ResultType, ContextType> getInterpreterDelegate() {
		return interpreterDelegate;
	}
	
	private int getLine(org.eclipse.emf.ecore.EObject element) {
		int line = -1;
		edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2LocationMap locationMap = getLocationMap(element);
		if (locationMap != null) {
			line = locationMap.getLine(element);
		}
		return line;
	}
	
	private int getCharStart(org.eclipse.emf.ecore.EObject element) {
		edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2LocationMap locationMap = getLocationMap(element);
		if (locationMap != null) {
			return locationMap.getCharStart(element);
		}
		return -1;
	}
	
	private int getCharEnd(org.eclipse.emf.ecore.EObject element) {
		edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2LocationMap locationMap = getLocationMap(element);
		if (locationMap != null) {
			return locationMap.getCharEnd(element) + 1;
		}
		return -1;
	}
	
	private edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2LocationMap getLocationMap(org.eclipse.emf.ecore.EObject element) {
		org.eclipse.emf.ecore.resource.Resource resource = element.eResource();
		if (resource instanceof edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource) {
			edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource textResource = (edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2TextResource) resource;
			edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2LocationMap locationMap = textResource.getLocationMap();
			return locationMap;
		}
		return null;
	}
	
	private void evaluateStep(org.eclipse.emf.ecore.EObject element) {
		// create local copy to avoid race conditions
		edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Command<org.eclipse.emf.ecore.EObject> stopCheck = stopCondition;
		if (stopCheck != null && stopCheck.execute(element)) {
			stopCondition = null;
			// suspending after step...
			setSuspend(true);
			sendEvent(edu.ustb.sei.mde.xmu2.resource.xmu2.debug.EXmu2DebugMessageTypes.SUSPENDED, true);
			return;
		}
		waitIfSuspended();
	}
	
	public void terminate() {
		interpreterDelegate.terminate();
		super.terminate();
	}
	
	public void stepOver() {
		final org.eclipse.emf.ecore.EObject current = interpreterDelegate.getNextObjectToInterprete();
		final int currentLevel = edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2EObjectUtil.getDepth(current);
		stopCondition = new edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Command<org.eclipse.emf.ecore.EObject>() {
			public boolean execute(org.eclipse.emf.ecore.EObject element) {
				// For step over, we stop at the next object that is at the same level or higher
				int depth = edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2EObjectUtil.getDepth(element);
				boolean sameOrHigher = depth <= currentLevel;
				boolean differentElement = element != current;
				return sameOrHigher && differentElement;
			}
		};
		resume();
	}
	
	public void stepInto() {
		stopCondition = new edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Command<org.eclipse.emf.ecore.EObject>() {
			public boolean execute(org.eclipse.emf.ecore.EObject element) {
				// For step into, we stop at the next object
				return true;
			}
		};
		resume();
	}
	
	public void stepReturn() {
		org.eclipse.emf.ecore.EObject current = interpreterDelegate.getNextObjectToInterprete();
		final int parentLevel = edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2EObjectUtil.getDepth(current) - 1;
		stopCondition = new edu.ustb.sei.mde.xmu2.resource.xmu2.IXmu2Command<org.eclipse.emf.ecore.EObject>() {
			public boolean execute(org.eclipse.emf.ecore.EObject element) {
				// For step return, we stop at the next object that is at least one level higher
				int depth = edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2EObjectUtil.getDepth(element);
				return depth <= parentLevel;
			}
		};
		resume();
	}
	
	public java.util.Map<String, Object> getFrameVariables(String stackFrame) {
		int stackFrameID = Integer.parseInt(stackFrame);
		java.util.Map<String, Object> frameVariables = new java.util.LinkedHashMap<String, Object>();
		frameVariables.put("this", stackFrameMap.get(stackFrameID));
		frameVariables.put("context", getInterpreterDelegate().getCurrentContext());
		return frameVariables;
	}
	
}
