package edu.ustb.sei.mde.xmu2.runtime.structures;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import edu.ustb.sei.mde.xmu2.util.AnalysisUtil;
import edu.ustb.sei.mde.xmu2.util.CommandBasedModelModificationEngine;
import edu.ustb.sei.mde.xmu2.util.TransformationTrace;

public class CommandBasedEnvironment extends Environment implements Cloneable{
	
	protected TransformationEditingDomain editingDomain;

	public CommandBasedEnvironment() {
		trace = new TransformationTrace();
		editingDomain = new TransformationEditingDomain(this);
		engine = new CommandBasedModelModificationEngine(editingDomain);
	}
	
	public CommandBasedEnvironment(boolean isForward) {
		this();
		forward = isForward;
		cache = new CacheSystem();
		resourceSet = new ResourceSetImpl();
		AnalysisUtil.initializeResourceSet(resourceSet);
	}
	
	static public CommandBasedEnvironment createForwardEnvironment(URI executable,String[] sourcePaths, String[] viewPaths) {
		CommandBasedEnvironment env = new CommandBasedEnvironment(true);
		env.transformation = env.loadSpecification(executable);
		env.loadSourceModels(sourcePaths);
		env.updatedSources.addAll(env.sources);
		env.createViewModels(viewPaths);
		env.engine.setFocusedResources(env.views);
		return env;
	}
	
	static public Environment createBackwardEnvironment(URI executable,String[] sourcePaths, String[] viewPaths) {
		CommandBasedEnvironment env = new CommandBasedEnvironment(false);
		env.transformation = env.loadSpecification(executable);
		env.loadSourceModels(sourcePaths);
		env.initUpdatedSource();
		env.loadViewModels(viewPaths);
		env.engine.setFocusedResources(env.updatedSources);
		return env;
	}
	
	public void undo() {
		((CommandBasedModelModificationEngine)this.engine).undoAll();
	}
	
	public void redo() {
		((CommandBasedModelModificationEngine)this.engine).redoAll();
	}
	
	public CommandBasedEnvironment clone() {
		CommandBasedEnvironment newEnv = new CommandBasedEnvironment(this.forward);
		newEnv.transformation = this.transformation;

		newEnv.sources.addAll(this.sources);
		newEnv.views.addAll(this.views);
		newEnv.updatedSources.addAll(this.updatedSources);
		
		newEnv.engine.setFocusedResources(this.engine.getFocusedResources());

		this.trace.copyTo(newEnv.trace);
		// external data is shared by all environments
		newEnv.externalData = this.externalData;
		return newEnv;
	}
	
	public CommandBasedEnvironment createHistoryScreenshot() {
		CommandBasedEnvironment newEnv = this.clone();
		CommandBasedEnvironment preEnv = this.clone();
		((TransformationCommandStack)preEnv.editingDomain.getCommandStack()).cloneCommandStack(((TransformationCommandStack)this.editingDomain.getCommandStack()));
		newEnv.previousState = preEnv;
		return newEnv;
	}
	
	public void mergeTraceFrom(CommandBasedEnvironment source) {
		this.trace.mergeFrom(source.trace, source.previousState.trace);
	}
	
	protected CommandBasedEnvironment previousState; 
}
