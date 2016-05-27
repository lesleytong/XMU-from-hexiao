package edu.ustb.sei.mde.xmu2.runtime.structures;

import org.eclipse.emf.common.command.BasicCommandStack;

public class TransformationCommandStack extends BasicCommandStack {

	public TransformationCommandStack() {
	}
	
	public boolean undoAll() {
		while(this.canUndo())
			this.undo();
		return (this.top==-1);
	}
	
	public boolean redoAll() {
		while(this.canRedo()) this.redo();
		return (this.top==this.commandList.size());
	}
	
	public void cloneCommandStack(TransformationCommandStack stack) {
		this.commandList.clear();
		this.commandList.addAll(stack.commandList);
		
		this.mostRecentCommand = stack.mostRecentCommand;
		
		this.saveIndex = stack.saveIndex;
		
		this.top = stack.top;
	}

}
