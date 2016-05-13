package edu.ustb.sei.mde.emg.graph.command;

import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.emg.graph.ModelSpace;

public class DeleteElementCommand extends ModelCommand {
	public DeleteElementCommand(ModelSpace space, EObject object) {
		super();
		this.space = space;
		this.object = object;
	}

	protected EObject object;

	@Override
	public boolean undo() {
		
		space.deleteElement(object);
		return false;
	}

	@Override
	public boolean redo() {
		
		space.addElement(object);
		return false;
	}

}
