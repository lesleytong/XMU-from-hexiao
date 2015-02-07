package edu.ustb.sei.mde.emg.graph.command;

import edu.ustb.sei.mde.emg.graph.ModelSpace;

abstract public class ModelCommand {
	protected ModelSpace space;
	
	abstract public boolean undo();
	abstract public boolean redo();
}
